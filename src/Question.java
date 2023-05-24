public class Question {
    int correctAnswer;
    int playerAnswer;
    String questionText;
    String answer0, answer1, answer2, answer3;

    /*
    * Class constructor that is used to build multiple question objects
    */
    public Question(int correctAnswerIndex, String questionString, String answerZero, String answerOne,
                      String answerTwo, String answerThree) {
        correctAnswer = correctAnswerIndex;
        questionText = questionString;
        answer0 = answerZero;
        answer1 = answerOne;
        answer2 = answerTwo;
        answer3 = answerThree;
        playerAnswer = -1;
    }

    boolean isCorrect() {
        return playerAnswer == correctAnswer;
    }
}
