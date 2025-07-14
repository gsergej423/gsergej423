import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Класс Question хранит один вопрос и правильный ответ
class Own game {
    private String category;
    private int value;
    private String questionText;
    private String correctAnswer;

    public Question(String category, int value, String questionText, String correctAnswer) {
        this.category = category;
        this.value = value;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    // Геттеры для полей класса
    public String getCategory() { return category; }
    public int getValue() { return value; }
    public String getQuestionText() { return questionText; }
    public String getCorrectAnswer() { return correctAnswer; }
}

// Контроллер игры отслеживает ход игры и очки игроков
public class GameController implements ActionListener {
    private List<JButton> buttons;
    private JLabel scoreLabel;
    private JTextField answerField;
    private JButton checkButton;
    private JPanel mainPanel;
    private JFrame frame;
    private List<Question> questions;
    private int currentScore = 0;

    public GameController(JFrame frame) {
        this.frame = frame;
        setupUI();
        loadQuestions(); // Загружаем вопросы заранее
    }

    // Создаем UI нашего окна
    private void setupUI() {
        frame.setTitle("Своя Игра");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new GridLayout(7, 2));
        scoreLabel = new JLabel("Очки игрока: " + currentScore);
        answerField = new JTextField();
        checkButton = new JButton("Проверить ответ");
        checkButton.addActionListener(this); // Добавляем обработчик нажатия

        buttons = new ArrayList<>();
        for(int i = 0; i < 14; i++) {
            JButton button = new JButton("Вопрос №" + (i+1));
            button.addActionListener(this);
            buttons.add(button);
            mainPanel.add(button);
        }

        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        frame.getContentPane().add(scoreLabel, BorderLayout.NORTH);
        frame.getContentPane().add(answerField, BorderLayout.SOUTH);
        frame.getContentPane().add(checkButton, BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);
    }

    // Метод загружает список вопросов (пример)
    private void loadQuestions() {
        questions = new ArrayList<>();
        questions.add(new Question("География", 100, "Столица Франции?", "Париж"));
        questions.add(new Question("История", 200, "Год основания Москвы?", "1147"));
        questions.add(new Question("Культура", 300, "Автор романа 'Война и мир'?", "Толстой"));
        // Продолжайте добавлять больше вопросов...
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton)e.getSource();
            if(clickedButton.equals(checkButton)) {
                checkAnswer();
            } else {
                showQuestion(clickedButton);
            }
        }
    }

    // Показываем вопрос игроку
    private void showQuestion(JButton button) {
        int index = buttons.indexOf(button);
        if(index >= 0 && index < questions.size()) {
            Question q = questions.get(index);
            JOptionPane.showMessageDialog(frame,
                    "<html><b>" + q.getCategory() + "</b><br>" +
                            "<font size=+1 color='blue'>За " + q.getValue() + " очков!</font><br>" +
                            q.getQuestionText());
        }
    }

    // Проверяем введенный игроком ответ
    private void checkAnswer() {
        String userAnswer = answerField.getText().trim();
        Question lastShownQuestion = questions.get(buttons.size()-1); // Берем последний показанный вопрос
        boolean isCorrect = userAnswer.equalsIgnoreCase(lastShownQuestion.getCorrectAnswer());
        if(isCorrect) {
            currentScore += lastShownQuestion.getValue();
            JOptionPane.showMessageDialog(frame, "Правильно! Вы заработали " + lastShownQuestion.getValue() + " очков.");
        } else {
            JOptionPane.showMessageDialog(frame, "Неправильный ответ!");
        }
        updateScoreDisplay();
        answerField.setText("");
    }

    // Обновляет дисплей очков
    private void updateScoreDisplay() {
        scoreLabel.setText("Очки игрока: " + currentScore);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            new GameController(frame);
        });
    }
}