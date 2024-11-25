import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion extends Question {

    public MultipleChoiceQuestion(String questionText, List<Option> options) {
        super(questionText, options);
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        // Check if answer is letter from abc, 1-3 letters.
        if (userAnswer == null || userAnswer.isEmpty() || userAnswer.length() > options.size() || !userAnswer.toLowerCase().matches("[abc]+")) {
            System.out.println("Invalid answer. You must enter valid letters: a, b, or c.");
            return false;
        }

        // Convert answers to list of indexes
        List<Integer> userIndexes = new ArrayList<>();
        for (char c : userAnswer.toLowerCase().toCharArray()) {
            int index = c - 'a';
            userIndexes.add(index);
        }

        // Check if user answer all isCorrect answers
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isCorrect() && !userIndexes.contains(i)) {
                return false;
            }
        }

        for (int index : userIndexes) {
            if (!options.get(index).isCorrect()) {
                return false;
            }
        }

        // Check wrong answers
        for (int index : userIndexes) {
            if (!options.get(index).isCorrect()) {
                return false;
            }
        }

        return true;
    }
}
