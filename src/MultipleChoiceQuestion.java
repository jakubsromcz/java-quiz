import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultipleChoiceQuestion extends Question{
    private final List<String> correctAnswers;

    public MultipleChoiceQuestion(String questionText, List<String> options, List<String> correctAnswers) {
        super(questionText, options);
        this.correctAnswers = new ArrayList<>();
        for (String answer : correctAnswers) {
            this.correctAnswers.add(answer.toLowerCase());

        }
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        Scanner scanner = new Scanner(System.in);

        // Check if answer has 1-3 letters
        while (userAnswer == null || userAnswer.isEmpty() || userAnswer.length() > 3 || !"abc".contains(userAnswer.toLowerCase())) {
            System.out.println("Invalid answer. You must enter between 1 and 3 letters. abc.");
            System.out.print("Please enter your answer again: ");
            userAnswer = scanner.nextLine();
        }

        List<String> userAnswers = new ArrayList<>();
        for (char c : userAnswer.toLowerCase().toCharArray()) {
            userAnswers.add(String.valueOf(c));
        }
        for (String answer : userAnswers) {
            if (!correctAnswers.contains(answer.trim())) {
                return false;
            }
        }
        return userAnswers.size() == correctAnswers.size();
    }
}
