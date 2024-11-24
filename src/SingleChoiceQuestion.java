import java.util.List;
import java.util.Scanner;

public class SingleChoiceQuestion extends Question{
    private final String correctAnswer;

    public SingleChoiceQuestion(String questionText, List<String> options, String correctAnswer) {
        super(questionText, options);
        this.correctAnswer = correctAnswer.toLowerCase();
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        Scanner scanner = new Scanner(System.in);

        // Check if answer has only ONE letter
        while (userAnswer == null || userAnswer.length() != 1 || !"abc".contains(userAnswer.toLowerCase())) {
            System.out.println("Invalid answer. You must enter exactly one letter: a, b, or c.");
            System.out.print("Please enter your answer again: ");
            userAnswer = scanner.nextLine();
        }

        return correctAnswer.equals(userAnswer.toLowerCase());
    }
}
