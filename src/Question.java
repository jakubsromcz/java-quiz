import java.util.List;

public abstract class Question {
    protected String questionText;
    protected List<Option> options;

    public Question(String questionText, List<Option> options) {
        this.questionText = questionText;
        this.options = options;
    }

    public abstract boolean checkAnswer(String userAnswer);

    public void displayQuestion() {
        System.out.println(questionText);
        char identifier = 'a';
        for (Option option : options) {
            System.out.println(identifier + ") " + option.getText());
            identifier++;
        }
    }
}
