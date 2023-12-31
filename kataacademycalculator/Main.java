package kataacademycalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CustomException {

        instructions();

        Scanner sc = new Scanner(System.in);
        boolean isExit = false;

        while (!isExit) {
            String userInput = sc.nextLine();
            if (isExit = userInput.equals("exit")) {
                break;
            }

            System.out.println(calc(userInput));

            //Ввод нового выражения или выход из программы
            System.out.println("Введите выражение (для выхода введите \"exit\":)");
        }
    }

    static void instructions() {
        System.out.println("Консольный калькулятор для вычисления выражений типа \"<значение_1> <оператор> <значение_2>\".");
        System.out.println("В качестве значений могут быть использованы арабские или римские числа от одного до десяти включительно.");
        System.out.println("В качестве оператора могут быть использованы символы \"+\", \"-\", \"*\" или \"/\", \n"
                + "представляющие операции сложения, вычитания, умножения или деления соответственно.");
        System.out.println("Введите выражение (для выхода введите \"exit\":)");
    }

    public static String calc(String input) throws CustomException {

        // Выполняем парсинг введенных данных и сохраняем результаты парсинга.
        String[] arrToCalc = Parser.parseMe(input);

        //Отдаем результаты парсинга для проверок и вычислений в объект класса Calculator.
        Calculator calculator = new Calculator();
        return calculator.getResult(arrToCalc);
    }
}
