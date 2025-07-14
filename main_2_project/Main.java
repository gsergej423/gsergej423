import java.util.Scanner;   // Импортируем класс Scanner

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Создаем объект Scanner

        // Запрашиваем ввод данных
        System.out.print("Ваш возраст: ");
        int age = scanner.nextInt();              // Читаем введённое целое число

        System.out.print("Ваше имя: ");
        String name = scanner.nextLine();          // Чтение следующей строки
        name = scanner.nextLine();                // Фиксируем проблему пропуска nextLine()

        System.out.print("Ваш рост: ");
        double height = scanner.nextDouble();     // Читаем введённое вещественное число

        // Выводим полученные данные на экран
        System.out.println("\nПолучены следующие данные:");
        System.out.println("Возраст: " + age);
        System.out.println("Имя: " + name);
        System.out.println("Рост: " + height);
    }
}