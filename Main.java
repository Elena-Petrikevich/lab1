
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Введите число строк:");
            try {
                n = sc.nextInt();
                if (n >= 0) {
                    break;
                } else {
                    System.out.println("Число строк должно быть неотрицательным. Попробуйте снова.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Введите (целое) число.");
                sc.nextLine();
            }
        }

        String[] str = new String[n];
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("Введите строку №" + (i + 1) + ":");
            str[i] = sc.nextLine();
        }

        for (int i = 0; i < str.length - 1; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].length() > str[j].length()) {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }

        int minLength = str[0].length();
        System.out.println("Строки в порядке возрастания длины:");
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
            for (int j = 0; j < minLength - str[i].length(); j++) {
                System.out.print(" ");
            }
            System.out.println("  ее длина = " + str[i].length());
        }
    }
}