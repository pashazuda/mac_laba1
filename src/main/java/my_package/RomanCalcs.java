package my_package;

import java.util.HashMap;

public class RomanCalcs extends Calculations{
    private static final HashMap<String, Integer> romeDict = new HashMap<>();
    static {
        romeDict.put("I", 1);
        romeDict.put("II", 2);
        romeDict.put("III", 3);
        romeDict.put("IV", 4);
        romeDict.put("V", 5);
        romeDict.put("VI", 6);
        romeDict.put("VII", 7);
        romeDict.put("VIII", 8);
        romeDict.put("IX", 9);
        romeDict.put("X", 10);
        romeDict.put("C", 100);
    }
    private static final HashMap<String, Integer> extraRomeDict = new HashMap<>();
    static {
        extraRomeDict.put("X", 1); //10
        extraRomeDict.put("XX", 2); //20
        extraRomeDict.put("XXX", 3); //30
        extraRomeDict.put("XL", 4); //40
        extraRomeDict.put("L", 5); //50
        extraRomeDict.put("LX", 6); //60
        extraRomeDict.put("LXX", 7); //70
        extraRomeDict.put("LXXX", 8); //80
        extraRomeDict.put("XC", 9); //90
    }

    public String romanCalc(String num1, String num2, String operator) throws CalcException {
        int a = romeDict.get(num1);
        int b = romeDict.get(num2);
        int result = operation(a, b, operator);
        if (result <= 0) {
            throw new CalcException("В римской системе нет отрицательных чисел и нуля");
        }
        if ((10 < result) && (result < 100)) {
            if (romeDict.containsKey(getKeyFromValue(romeDict, result % 10))) {
                return (getKeyFromValue(extraRomeDict, result / 10) + getKeyFromValue(romeDict, result % 10));
            } else {
                return getKeyFromValue(extraRomeDict, result / 10);
            }
        } else return getKeyFromValue(romeDict, result);
    }

    static String getKeyFromValue(HashMap dict, Object value){
        for (Object o : dict.keySet()) {
            if (dict.get(o).equals(value)) {
                return (String) o;
            }
        }
        return null;
    }

    @Override
    int addition(int a, int b) {
        Operation operation = (x, y) -> x + y;
        return operation.execute(a,b);
    }

    @Override
    int subtraction(int a, int b) {
        Operation operation = (x, y) -> x - y;
        return operation.execute(a,b);
    }

    @Override
    int multiplication(int a, int b) {
        Operation operation = (x, y) -> x * y;
        return operation.execute(a,b);
    }

    @Override
    int division(int a, int b) {
        Operation operation = (x, y) -> x / y;
        return operation.execute(a,b);
    }


    public int operation(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> addition(a, b);
            case "-" -> subtraction(a, b);
            case "*" -> multiplication(a, b);
            case "/" -> division(a, b);
            default -> 0;
        };
    }
}
