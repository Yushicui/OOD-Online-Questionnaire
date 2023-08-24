/**
 * CS5004 Project 3
 * Name: Yushi Cui
 */

package questions;

/**
 * A class that represents a TrueFalse question.
 */
public class TrueFalse extends AbstractQuestion{

  private String correctAnswer;

  /**
   * Constructor for a TrueFalse question.
   *
   * @param text the text of the question
   * @param correctAnswer the correct answer to the question, either true or false
   */
  public TrueFalse(String text, String correctAnswer) {
    super(text);
    this.correctAnswer = correctAnswer;
  }


  /**
   * Determines if the answer is correct for a given question.
   *
   * @param answer the answer given
   * @return "Correct" or "Incorrect"
   */
  @Override
  public String answer(String answer) {
    if(answer.equalsIgnoreCase(correctAnswer)) {
      return CORRECT;
    }
    return INCORRECT;
  }


  /**
   * Compares the current Question to another Questions.
   *
   * @param other the other Question to compare to
   * @return a negative integer, zero, or a positive integer.
   */
  @Override
  public int compareTo(Question other) {
    if(other instanceof TrueFalse){
      return this.getText().compareTo(other.getText());
    }
    return -1;
  }
}
