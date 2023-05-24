import java.util.ArrayList;

public class MainActivity {
    int currentQuestionIndex;
    int totalCorrect;
    int totalQuestions;
    ArrayList<Question> questions = new ArrayList<>();

    /*
    * Creates three 'Question' objects and creates a local ArrayList that is assigned the
    * same address as the questions ArrayList in order to fill the global ArrayList with
    * the newly created questions
    */
    void startNewGame() {
        Question One = new Question(3, "Who invented the computer algorithm?",
                "Charles Babbage", "John Carmack", "Alan Turing", "Ada Lovelace");

        Question Two = new Question(1, "What do you call the time complexity of a program?",
                "Ono", "Big O Notation", "Time analysis", "RAM");

        Question Three = new Question(0, "What is the space complexity of a program?",
                "Efficiency of memory usage", "Execution time of program", "Amount of space available on the system",
                "# of lines of code required to implement functionality");

        ArrayList<Question> newQuestion = questions;
        newQuestion.add(One); newQuestion.add(Two); newQuestion.add(Three);

        totalCorrect = 0; totalQuestions = newQuestion.size();
    }

    /*
    * Calls the generateRandomNumber method in order to get the next question
    */
    void chooseNewQuestion() {
        currentQuestionIndex = generateRandomNumber(questions.size()-1);
    }

    /*
    * After every answer the user inputs it will check if the answer is correct, remove the question
    * from the ArrayList, and either end the game or get the next question
    */
    boolean onAnswerSubmission() {
        if (getCurrentQuestion().isCorrect()) totalCorrect++;
        questions.remove(getCurrentQuestion());

        if (questions.size() == 0) {
            String message  = getGameOverMessage(totalCorrect, totalQuestions);
            System.out.println("Game over.\n" + message);
            return false;
        } else {
            chooseNewQuestion();
        }

        displayQuestionRemaining(questions.size());
        return true;
    }

    void displayQuestionRemaining(int questions) {
        System.out.println("Questions remaining: " + questions + "\n");
    }

    /*
    * Gets and returns the current 'Question' object in the ArrayList
    */
    Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    /*
    * Used to generate a random number within the range of the ArrayList in order to get
    * the next question's index
    */
    int generateRandomNumber(int max) {
        double num = Math.random();
        return (int)Math.round(num * max);
    }

    /*
    * Returns the appropriate message to the user once the game is over
    */
    String getGameOverMessage(int totalCorrect, int totalQuestions) {
        if(totalCorrect == totalQuestions)
            return "You got all " + totalCorrect + " right! You won!";

        return "You got " + totalCorrect + " right out of " + totalQuestions + ". Better luck next time!";
    }
}
