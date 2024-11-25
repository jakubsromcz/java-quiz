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
                new SingleChoiceQuestion(
                        "What is the currency in Slovakia?",
                        List.of(
                                new Option("Dollar", false),
                                new Option("Libra", false),
                                new Option("Euro", true)
                        )
                ),
                new MultipleChoiceQuestion(
                        "Which of these are programming languages? (type answer like ac)",
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
                    }
                else if ("abc".contains(userAnswer.toLowerCase()) || userAnswer.toLowerCase().matches("[abc]+")) {
                    System.out.println("Wrong answer :(");
                    break;
                    }
                }
            }

        System.out.println("Your score is " + score + "/" + quiz.size() + ".");
    }
}
