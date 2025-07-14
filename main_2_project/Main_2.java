public class Main_2 {
    public static void main(String[] args) {
        for (int perv = 1; perv <= 11; perv++) { // заменил "< 11" на "<= 10" для ясности
            for (int two = 1; two <= 11; two++) { // аналогично предыдущему комментарию
                int tab = perv * two;
                System.out.println(perv + "*" + two + "=" + tab); // выводит таблицу умножения
            }
            System.out.println(); // пустая строка между таблицами
        }
    }
}