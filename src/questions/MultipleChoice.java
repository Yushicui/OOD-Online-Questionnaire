/**
 * CS5004 Project 3
 * Name: Yushi Cui
 */

package questions;

/**
 * A class that represents a MultipleChoice question.
 */
public class MultipleChoice extends AbstractQuestion {

  private String correctAnswer;
  private String[] options;

  /**
   * Constructor for a MultipleChoice question.
   *
   * @param text the text of the question
   * @param correctAnswer the index of the correct answer
   * @param options the possible answers to the question
   *
   * @throws IllegalArgumentException if the number of options is less than 3 or greater than 8
   */
  public MultipleChoice(String text, String correctAnswer, String... options) {
    super(text);
    if (options.length < 3 || options.length > 8) {
      throw new IllegalArgumentException("Question should has least 3 options but no more than 8");
    }
    this.correctAnswer = correctAnswer;
    this.options = options;
  }


  /**
   * Determines if the answer is correct for a given question.
   *
   * @param answer the answer given
   * @return "Correct" or "Incorrect"
   */
  @Override
  public String answer(String answer) {
    if(answer.equals(correctAnswer)){
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
    if(other instanceof MultipleChoice){
      return this.getText().compareTo(other.getText());
    } else if (other instanceof TrueFalse){
      return 1;
    } else {
      return -1;
    }
  }
}
