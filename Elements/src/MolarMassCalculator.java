import java.util.*;

public class MolarMassCalculator {

    public static void main(String[] args) {
        String testFormula = "NaMg3Al6(BO3)3Si6O18(OH)4";
        ChemicalFormulaParser.validateFormula(testFormula);
        List<ResultPerElement> resultPerElements = calculateMassPerElement(testFormula);

        for (ResultPerElement result: resultPerElements) {
            System.out.println("Symbol: " + result.getAtomicSymbol() + ", Name: " + result.getAtomicName() + ", Atomic Weight: " + result.getAtomicWeight() +
                    ", Number of Atoms: " + result.getCount() + ", Molar Mass: " + result.getMolarMass() + ", Percent of Total Mass: " + result.getMassPercent());
        }
        System.out.print("Total mass of molecule: " + calculateTotalMolarMass(testFormula) + " g/mol");
    }

    private static class ResultPerElement {
        private Element element;
        private int count;
        private double totalMolarMass;

        private ResultPerElement (Element element, int count, double totalMolarMass) {
            this.element = element;
            this.count = count;
            this.totalMolarMass = totalMolarMass;
        }

        public int getAtomicNumber() {
            return element.getAtomicNumber();
        }

        public String getAtomicSymbol() {
            return element.getSymbol();
        }

        public String getAtomicName() {
            return element.getFullName();
        }

        public double getAtomicWeight() {
            return element.getAtomicWeight();
        }

        public double getMolarMass() {
            return (double) Math.round(element.getAtomicWeight() * count) / 100;
        }

        public int getCount() {
            return count;
        }

        public double getMassPercent() {
            double percent = 100 * element.getAtomicWeight() * count / totalMolarMass;
            return (double) Math.round(percent * 100) / 100;
        }
    }

    public static double calculateTotalMolarMass (String formula) {
        Map<Element, Integer> formulaAsMap = ChemicalFormulaParser.parseWithParentheses(formula);
        double result = 0.0;
        for (Element element: formulaAsMap.keySet()) {
            double elementAtomicWeight = element.getAtomicWeight();
            int count = formulaAsMap.get(element);
            result += elementAtomicWeight * count;
        }
        return (double) Math.round(100 * result) / 100;
    }

    public static double calculateTotalMolarMass (Map<Element, Integer> formulaAsMap) {
        double result = 0.0;
        for (Element element: formulaAsMap.keySet()) {
            double elementAtomicWeight = element.getAtomicWeight();
            int count = formulaAsMap.get(element);
            result += elementAtomicWeight * count;
        }
        return (double) Math.round(100 * result) / 100;
    }

    public static List<ResultPerElement> calculateMassPerElement (String formula) {
        Map<Element, Integer> formulaAsMap = ChemicalFormulaParser.parseWithParentheses(formula);
        double totalMolarMass = calculateTotalMolarMass(formulaAsMap);
        List<ResultPerElement> elementsByAtomicNumber = new ArrayList<ResultPerElement>();
        for (Element element: formulaAsMap.keySet()) {
            elementsByAtomicNumber.add(new ResultPerElement(element, formulaAsMap.get(element), totalMolarMass));
        }
        elementsByAtomicNumber.sort(Comparator.comparing(ResultPerElement::getAtomicNumber));
        return elementsByAtomicNumber;
    }
}
