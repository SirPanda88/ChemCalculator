import java.util.HashMap;
import java.util.Map;

public class MolarMassCalculator {
    public static double calculateMolarMass (String formula) {
        double result = 0.0;
        Map<Element, Integer> formulaAsMap = ChemicalFormulaParser.parseWithParentheses(formula);
        for (Element element: formulaAsMap.keySet()) {
            double elementAtomicWeight = element.getAtomicWeight();
            int count = formulaAsMap.get(element);

        }
        return 0.0;
    }
}
