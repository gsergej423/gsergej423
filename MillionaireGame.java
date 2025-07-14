import java.util.Scanner;

public class MillionaireGame {

    // Вопросы и правильные ответы
    private static final String[] questions = {
            "Какой город является столицей Франции?",
            "Какое число получается при сложении чисел 7 и 8?",
            "Что тяжелее: килограмм железа или килограмм перьев?",
            "Какие животные являются символами Китая?",
            "Назовите самую высокую гору мира",
            "Как называется самая длинная река в мире?"
    };
    
    // Варианты ответов
    private static final String[][] answers = {
            {"Москва", "Париж", "Рим", "Берлин"},
            {"15", "16", "17", "18"},
            {"Железо", "Перья", "Одинаково", "Зависит от высоты"},
            {"Кошка и собака", "Медведь и волк", "Дракон и тигр", "Лев и орел"},
            {"Эверест", "Монблан", "Фудзи", "Мак-Кинли"},
            {"Нил", "Амазонка", "Янцзы", "Миссисипи"}
    };
    
    // Правильные варианты ответов
    private static final int[] correctAnswers = {1, 1, 2, 2, 0, 0};
    
    // Призовые суммы
    private static final int[] prizes = {1_000, 5_000, 10_000, 50_000, 100_000, 500_000};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Добро пожаловать в игру 'Кто хочет стать миллионером?'");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nВопрос №" + (i+1));
            System.out.println(questions[i]);
            
            // Показываем варианты ответов
            for (int j = 0; j < answers[i].length; j++) {
                System.out.println((j+1) + ". " + answers[i][j]);
            }
            
            // Получаем ввод пользователя
            System.out.print("Ваш выбор (1-" + answers[i].length + "): ");
            int userAnswer = scanner.nextInt() - 1;
            
            if (userAnswer != correctAnswers[i]) {
                System.out.println("Неправильно! Вы проиграли.");
                break;
            }
            
            System.out.println("Правильно! Ваш выигрыш составляет $" + prizes[i]);
            
            // Предложение продолжить или остановиться
            if(i < questions.length - 1){
                System.out.print("Хотите продолжить играть? (Да/Нет): ");
                String choice = scanner.next();
                
                if (!choice.equalsIgnoreCase("Да")) {
                    System.out.println("Вы остановились на сумме $" + prizes[i]);
                    return;
                }
            }
        }
        
        System.out.println("Поздравляем! Вы выиграли максимальный приз!");
    }
}