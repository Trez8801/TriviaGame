import java.util.Scanner;

public class AndroidOS {
    // Simulate the startup of the Android device
    public AndroidOS() {
        System.out.println("AndroidOS Booting Up...");
    }

    // Simulates a quiz app
    public void runQuizApp() {
        Scanner input = new Scanner(System.in);

        // Instantiates the main object with the MainActivity class
        // and calls the starts the game
        MainActivity main = new MainActivity();
        main.startNewGame();

        // Continuously loops through each question getting an answer from the user
        // until there are no more questions to be answered
        do {
            printQuestion(main.getCurrentQuestion());
            main.getCurrentQuestion().playerAnswer = input.nextInt() - 1;
            System.out.println();
        } while(main.onAnswerSubmission());
    }

    public static void main(String[] args) {
        System.out.println("Starting: AndroidOS");
        AndroidOS androidOS = new AndroidOS();

        System.out.println();
        androidOS.runQuizApp();
    }

    static void printQuestion(Question question) {
        System.out.println("Question: " + question.questionText);
        System.out.println("1) " + question.answer0);
        System.out.println("2) " + question.answer1);
        System.out.println("3) " + question.answer2);
        System.out.println("4) " + question.answer3);
    }
}