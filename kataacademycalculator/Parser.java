package kataacademycalculator;

class Parser {

    static String[] romanDigits = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static String[] operators = {"+", "-", "*", "/"};

    static String[] parseMe(String userIn) throws CustomException {
        // Преобразуем полученную от пользователя строку в массив строк с помощью String.split()
        String[] toCalc = userIn.split(" ");

        // Массив для флагов: корректность элементов и наличие римских цифр.
        String[] flags = {"false", "false", "false"};

        // Проверяем, что строка содержит 3 элемента (два числа и оператор).
        if (toCalc.length != 3) {
            throw new CustomException("формат математической операции не удовлетворяет заданию или строка не является математической операцией");
        }

        /* Проверяем принадлежность первого и третьего элементов массива к римским цифрам
        и проставляем флаги в массиве flags. */
        for (String str : romanDigits) {
            if (toCalc[0].equals(str)) {
                flags[0] = "roman";
                break;
            }
        }

        for (String str : romanDigits) {
            if (toCalc[2].equals(str)) {
                flags[2] = "roman";
                break;
            }
        }

        /* Проверяем принадлежность первого и третьего элементов массива к целым числам (метод isNumeric),
         а также их попадание в диапазон 1 < x < 11, и проставляем флаги в массиве flags. */
        if (flags[0] != "roman") {
            if (isNumeric(toCalc[0]) && (Integer.parseInt(toCalc[0]) > 0 && Integer.parseInt(toCalc[0]) < 11)) {
                flags[0] = "arabic";
            }
        }

        if (flags[2] != "roman") {
            if (isNumeric(toCalc[2]) && (Integer.parseInt(toCalc[2]) > 0 && Integer.parseInt(toCalc[2]) < 11)) {
                flags[2] = "arabic";
            }
        }

        // Проверяем корректность оператора и и проставляем флаг в массиве flags.
        for (String str : operators) {
            if (toCalc[1].equals(str)) {
                flags[1] = "correct";
                break;
            }
        }

        /* Проверяем флаги в массиве flags. Если массив некорректен - выбрасываем исключение */
        for (String elem : flags) {
            if (elem.equals("false")) {
                throw new CustomException("формат математической операции не удовлетворяет заданию");
            }
        }

        // новый массив длиной 6
        String[] combinedArray = new String[toCalc.length + flags.length];

        // Копируем два массива в объединенный
        System.arraycopy(toCalc, 0, combinedArray, 0, flags.length);
        System.arraycopy(flags, 0, combinedArray, toCalc.length, toCalc.length);

        return combinedArray;
    }

    //Проверка возможности распарсить элемент как целое число.
    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
