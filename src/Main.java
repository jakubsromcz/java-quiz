import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Question> quiz = List.of(
                new SingleChoiceQuestion(
                        "What is the capital city of Czechia?",
                        List.of(
                                new Option("Bratislava", false),
                                new Option("Praha", true),
                                new Option("Madrid", false)
                        )
                ),
                new MultipleChoiceQuestion(
                        "Which of these are programming languages?",
                        List.of(
                                new Option("Python", true),
                                new Option("HTML", false),
                                new Option("Java", true)
                        )
                )
        );

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < quiz.size(); i++) {
            System.out.println("Question " + (i + 1) + ":");
            quiz.get(i).displayQuestion();

            while (true) {
                System.out.print("Your answer is: ");
                String userAnswer = scanner.nextLine();

                if (quiz.get(i).checkAnswer(userAnswer)) {
                    System.out.println("Correct!");
                    score++;
                    break;
                } else if (!"abc".contains(userAnswer.toLowerCase())) {
                    System.out.println("Invalid answer format. Please try again.");
                } else {
                    System.out.println("Wrong answer :(");
                    break;
                }
            }
        }

        System.out.println("Your score is " + score + "/" + quiz.size() + ".");
    }
}
