package my_package;

import java.util.HashMap;

public class ArabicCalcs extends Calculations{
    private static final HashMap<String, Integer> arabicDict = new HashMap<>();
    static {
        arabicDict.put("1", 1);
        arabicDict.put("2", 2);
        arabicDict.put("3", 3);
        arabicDict.put("4", 4);
        arabicDict.put("5", 5);
        arabicDict.put("6", 6);
        arabicDict.put("7", 7);
        arabicDict.put("8", 8);
        arabicDict.put("9", 9);
        arabicDict.put("10", 10);
    }

    public int arabicCalc(String num1, String num2, String operator){
        int a = arabicDict.get(num1);
        int b = arabicDict.get(num2);
        return operation(a, b, operator);
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
