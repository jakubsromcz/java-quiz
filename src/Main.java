import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Question> quiz = new ArrayList<>();

        // Add new questions

        quiz.add(new SingleChoiceQuestion(
                "What is the capital city of Czechia?",
                List.of("Bratislava", "Praha", "Madrid"),
                "b"
        ));

        quiz.add(new SingleChoiceQuestion(
                "What is currency in Slovakia?",
                List.of("Dollar", "Libra", "Euro"),
                "c"
        ));

        quiz.add(new MultipleChoiceQuestion(
                "Which of these are programming languages? (type answer like abc)",
                List.of("Python", "HTML", "Java"),
                List.of("a", "c")
        ));

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // List of all questions
        for (int i = 0; i <quiz.size(); i++) {
            System.out.println("Question " + (i + 1) + ":");
            quiz.get(i).displayQuestion();
            System.out.print("Your answer is: ");
            String userAnswer = scanner.nextLine();

            if (quiz.get(i).checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong answer :(");
            }
        }
        System.out.println("Your score is " + score + "/" + quiz.size() + ".");
    }
}
