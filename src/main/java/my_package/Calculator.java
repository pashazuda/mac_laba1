package my_package;

public class Calculator {
    public static String calc(String input) throws CalcException {
        String operator = null;
        String[] subStr = input.split("([+\\-*/])");
        Type calcType = Type.NOTYPE;
        if (NumberIdentifier.isRomanNumber(subStr[0]) && NumberIdentifier.isRomanNumber(subStr[1])) {
            calcType = Type.ROME;
        } else if (NumberIdentifier.isArabicNumber(subStr[0]) && NumberIdentifier.isArabicNumber(subStr[1])) {
            calcType = Type.ARABIC;
        } else if ((NumberIdentifier.isRomanNumber(subStr[0]) && NumberIdentifier.isArabicNumber(subStr[1])) ||
                (NumberIdentifier.isArabicNumber(subStr[0]) && NumberIdentifier.isRomanNumber(subStr[1]))) {
            throw new CalcException("Неверный формат чисел, используются одновременно разные системы счисления");
        }
        if (input.contains("+")) { operator = "+";}
        else if (input.contains("-")) { operator = "-";}
        else if (input.contains("*")) { operator = "*";}
        else if (input.contains("/")) { operator = "/";}
        ArabicCalcs ac = new ArabicCalcs();
        RomanCalcs rc = new RomanCalcs();
        return switch (calcType) {
            case ROME -> rc.romanCalc(subStr[0], subStr[1], operator);
            case ARABIC -> Integer.toString(ac.arabicCalc(subStr[0], subStr[1], operator));
            case NOTYPE -> null;
        };
    }
}
