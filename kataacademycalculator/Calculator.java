package kataacademycalculator;

class Calculator {

    int result;
    int x;
    int y;
    String operator;
    boolean romanAnswerRequired = false;

    String getResult(String[] strArr) throws CustomException {
        int res = solve(strArr);
        if (res < 101) {
            return Integer.toString(res);
        } else {
            return (RomeAndArabia.convertToRoman(res - 100500));
        }
    }

    int solve(String[] arr) throws CustomException {

        //Одна римская и одна арабская - некорректный формат.
        if ((arr[3] == "roman" && arr[5] != "roman") || (arr[3] != "roman" && arr[5] == "roman")) {
            throw new CustomException("Используются одновременно разные системы счисления");
        }

        //Превращаем римские в арабские (если таковые есть) и присваиваем значения для x и y
        if (arr[3] == "roman" && arr[5] == "roman") {
            x = RomeAndArabia.convertToArabic(arr[0]);
            y = RomeAndArabia.convertToArabic(arr[2]);
            romanAnswerRequired = true;
        } else {
            x = Integer.parseInt(arr[0]);
            y = Integer.parseInt(arr[2]);
        }

        operator = arr[1];

        switch (operator) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
        }
        if (!romanAnswerRequired) {
            return result;
        } else {
            return result + 100500; // :) ;
        }
    }
}
