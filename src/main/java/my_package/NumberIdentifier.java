package my_package;

import java.util.HashMap;

public class NumberIdentifier {
    private static Integer a = 10;
    /* Инициализация словарей с римскими и арабскими цифрами*/
    private static HashMap<String, Integer> romanDict = new HashMap<>();
    static {
        romanDict.put("I", 1);
        romanDict.put("II", 2);
        romanDict.put("III", 3);
        romanDict.put("IV", 4);
        romanDict.put("V", 5);
        romanDict.put("VI", 6);
        romanDict.put("VII", 7);
        romanDict.put("VIII", 8);
        romanDict.put("IX", 9);
        romanDict.put("X", 10);
    }
    private static HashMap<String, Integer> arabicDict = new HashMap<>();
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
    public static boolean isArabicNumber(String number) throws CalcException {
        if (arabicDict.containsKey(number)) {
            if (arabicDict.get(number).compareTo(a) > 0) throw new CalcException("Неверный формат чисел");
        }
        return arabicDict.containsKey(number);
    }

    public static boolean isRomanNumber(String number) throws CalcException {
        if (romanDict.containsKey(number)){
            if (romanDict.get(number).compareTo(a) > 0) throw new CalcException("Неверный формат чисел");
        }
        return romanDict.containsKey(number);
    }
}
