import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.*;

public class ChemicalFormulaParser {

    public static void main (String[] args) {
        String testFormula = "Na(LiAl)3Al6(BO3)3Si6O18(OH)4";
        validateFormula(testFormula);
        Map<Element, Integer> result = parseWithParentheses(testFormula);
        System.out.println(result.toString());
    }

    public static Map<Element, Integer> parseNoParenthesesFormula (String formula) {
        Map<Element, Integer> result = new HashMap<Element, Integer>();
        Pattern ElementIntegerToken = Pattern.compile("([A-Z][a-z]?)(\\d*)"); // regex pattern to match a chemical symbol followed by any number (zero or more) of digits
        Matcher matcher = ElementIntegerToken.matcher(formula);

        while (matcher.find()) {
            int elementCount = 1;
            if (!matcher.group(2).isEmpty()) {
                elementCount = Integer.parseInt(matcher.group(2));
            }
            addElement(result, Element.forAtomicSymbol(matcher.group(1)), elementCount);
        }
        return result;
    }

    public static Map<Element, Integer> parseWithParentheses(String formula) {

        Map<Element, Integer> result = new HashMap<Element, Integer>();

        // parameter validation
        if (formula == null) {
            throw new IllegalArgumentException("Null formula");
        }

        if (formula.length() == 0) {
            return result;
        }

        if (Character.isDigit(formula.charAt(0))) {
            throw new IllegalArgumentException("Formula cannot begin with number");
        }

        // parsing logic
        StringBuilder noParenthesesString = new StringBuilder("");

        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                noParenthesesString.append(c);

                if (i == formula.length() - 1) {
                    // end of formula

                    Map<Element, Integer> noParenthesesMap = parseNoParenthesesFormula(noParenthesesString.toString());
                    mergeElementIntegerMaps(result, noParenthesesMap);
                    return result;
                }

            } else if (c == '(') {
                Map<Element, Integer> noParenthesesMap = parseNoParenthesesFormula(noParenthesesString.toString());
                mergeElementIntegerMaps(result, noParenthesesMap);

                int closeParenthesesIndex = findCloseParenthesesIndex(formula, i);
                String parenthesesBlockFormula = formula.substring(i + 1, closeParenthesesIndex);
                Map<Element, Integer> parenthesesBlockMap = parseWithParentheses(parenthesesBlockFormula);
//                System.out.println("parenthesesBlockFormula: " + parenthesesBlockFormula);

                if (closeParenthesesIndex == formula.length() - 1) {
                    // end of formula
//                    System.out.println("end of formula");
                    mergeElementIntegerMaps(result, parenthesesBlockMap);


                } else if (!Character.isDigit(formula.charAt(closeParenthesesIndex + 1))) {
                    // next character is not an integer multiplier
//                    System.out.println("not digit");
                    mergeElementIntegerMaps(result, parenthesesBlockMap);

                } else {
                    // parse the multiplier after parentheses block
//                    System.out.println("digit multiplier");
                    StringBuilder multiplierAsString = new StringBuilder("");
                    while (closeParenthesesIndex + 1 < formula.length()) {
                        if (Character.isDigit(formula.charAt(closeParenthesesIndex + 1))) {
                            multiplierAsString.append(formula.charAt(closeParenthesesIndex + 1));
                            closeParenthesesIndex++;
                        } else {
                            break;
                        }
                    }
                    int multiplier = Integer.parseInt(multiplierAsString.toString());
                    multiplyElementCounts(parenthesesBlockMap, multiplier);
                    mergeElementIntegerMaps(result, parenthesesBlockMap);
                }

                if (closeParenthesesIndex + 1 != formula.length()) {
                    // formula continues
//                    System.out.println("formula continues");
                    String restOfFormula = formula.substring(closeParenthesesIndex + 1);
                    Map<Element, Integer> restOfFormulaMap = parseWithParentheses(restOfFormula);
                    mergeElementIntegerMaps(result, restOfFormulaMap);
                }
                return result;
            }
        }
        return result;
    }

    public static Map<Element, Integer> parseWithParenthesesIterative(String formula) {

        Map<Element, Integer> result = new HashMap<Element, Integer>();

        // parameter validation
        if (formula == null) {
            throw new IllegalArgumentException("Null formula");
        }

        if (formula.length() == 0) {
            return result;
        }

        if (Character.isDigit(formula.charAt(0))) {
            throw new IllegalArgumentException("Formula cannot begin with number");
        }

        // parsing logic
        StringBuilder noParenthesesString = new StringBuilder("");
        Stack recursiveStack = new Stack<Map<Element, Integer>>();

        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                noParenthesesString.append(c);

                if (i == formula.length() - 1) {
                    // end of formula

                    Map<Element, Integer> noParenthesesMap = parseNoParenthesesFormula(noParenthesesString.toString());
                    mergeElementIntegerMaps(result, noParenthesesMap);
                    return result;
                }

            } else if (c == '(') {
                Map<Element, Integer> noParenthesesMap = parseNoParenthesesFormula(noParenthesesString.toString());
                recursiveStack.push(noParenthesesMap);

                noParenthesesString = new StringBuilder("");

                if (Character.isDigit(formula.charAt(i + 1))) {
                    throw new IllegalArgumentException("Formula cannot begin with number");
                }
            }
        }
        return result;
    }

    // Verifies that formula contains only valid characters (letters and numbers) and all parentheses are paired
    // Throws exceptions if above conditions are not met
    public static void validateFormula (String formula) {
        char[] formulaChars = formula.toCharArray();
        int openVsCloseParentheses = 0;
        for (char ch: formulaChars) {
            if (ch == '(') {
                openVsCloseParentheses++;
            } else if (ch == ')') {
                openVsCloseParentheses--;
            } else if (!Character.isLetterOrDigit(ch)) {
                throw new IllegalArgumentException("Invalid character in formula");
            }
            if (openVsCloseParentheses < 0) {
                throw new IllegalArgumentException("Close parentheses exists before open parentheses");
            }
        }
        if (openVsCloseParentheses != 0) {
            throw new IllegalArgumentException("Parentheses are not paired");
        }
    }

    // Merges the entries of map 2 into map 1, summing the counts of the elements if the element exists in both
    public static void mergeElementIntegerMaps (Map<Element, Integer> map1, Map<Element, Integer> map2) {
        if (map1 == null || map2 == null) {
            throw new IllegalArgumentException("Null map argument");
        }
        for (Map.Entry<Element, Integer> e : map2.entrySet()) {
            map1.merge(e.getKey(), e.getValue(), Integer::sum);
        }
    }

    // Given a string and the index of an open parentheses, finds the index of the matching closing parentheses
    public static int findCloseParenthesesIndex (String formula, int openParenthesesIndex) {
        char[] formulaChars = formula.toCharArray();
        int openVsCloseParentheses = 0;
        for(int i = openParenthesesIndex; i < formulaChars.length; i++) {
            char ch = formulaChars[i];
            if (ch == '(') {
                openVsCloseParentheses++;
            } else if (ch == ')') {
                openVsCloseParentheses--;
            }
            if (openVsCloseParentheses == 0) {
                return i;
            }
        }
        // should never reach this point if formula is properly validated
        throw new IllegalStateException("Could not find closing parentheses");
    }

    // Multiplies the count of every element in map by multiplier
    public static void multiplyElementCounts (Map<Element, Integer> map, int multiplier) {
        for(Element key : map.keySet()) {
            map.put(key, map.get(key) * multiplier);
        }
//        map.forEach((key, value) -> map.put(key, value * multiplier));
    }

    // Puts an element integer pair into a map, adding their counts if the element already exists in the map
    public static void addElement (Map<Element, Integer> map, Element element, int count) {
        if (map.containsKey(element)) {
            map.put(element, map.get(element) + count);
        } else {
            map.put(element, count);
        }
    }

}
