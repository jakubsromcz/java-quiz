import java.util.List;


public abstract class Question {
    protected String questionText;
    protected List<String> options;

    public Question (String questionText, List<String> options) {
        this.questionText = questionText;
        this.options = options;
    }

    public abstract boolean checkAnswer(String userAnswer);

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((char) ('a' + i) + ") " + options.get(i));
        }
    }
}
