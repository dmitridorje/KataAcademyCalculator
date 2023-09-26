package kataacademycalculator;

class RomeAndArabia {

    private static final int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] romanLiterals = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    static int convertToArabic(String str) {

        // Переменная для сохранения результата
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            // Получаем значение символа s[i]
            int s1 = arabicValue(str.charAt(i));

            // Получаем значение символа s[i+1]
            if (i + 1 < str.length()) {
                int s2 = arabicValue(str.charAt(i + 1));

                if (s1 >= s2) {
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
            }
        }
        return res;
    }

    static int arabicValue(char c) {
        if (c == 'I')
            return 1;
        if (c == 'V')
            return 5;
        if (c == 'X')
            return 10;
        return -1;
    }

    static String convertToRoman(int numb) throws CustomException {
        if (numb < 1) {
            throw new CustomException("В римской системе нет нуля и отрицательных чисел");
        }
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (numb >= values[i]) {
                numb -= values[i];
                s.append(romanLiterals[i]);
            }
        }

        return s.toString();
    }
}