import java.util.List;

public class SingleChoiceQuestion extends Question {

    public SingleChoiceQuestion(String questionText, List<Option> options) {
        super(questionText, options);
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        // Check if answer is ONE letter
        if (userAnswer == null || userAnswer.length() != 1 || !"abc".contains(userAnswer.toLowerCase())) {
            System.out.println("Invalid answer. You must enter a valid letter: a, b, or c.");
            return false;
        }

        int index = userAnswer.toLowerCase().charAt(0) - 'a';


        return options.get(index).isCorrect();
    }
}