/**
 * CS5004 Project 3
 * Name: Yushi Cui
 */

package questions;

/**
 * A class that represents a Likert question.
 */
public class Likert extends AbstractQuestion {

  /**
   * Constructor for a Likert question.
   *
   * @param text the text of the question
   */
  public Likert(String text) {
    super(text);
  }


  /**
   * Determines if the answer is correct for a given question.
   *
   * @param answer the answer given
   * @return "Correct" or "Incorrect"
   */
  @Override
  public String answer(String answer) {
    int intAnswer;
    try {
      intAnswer = Integer.parseInt(answer);
    }
    catch( NumberFormatException e ) {
      return INCORRECT;
    }
    if(intAnswer >= 1 && intAnswer <= 5){
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
    if(other instanceof Likert){
      return this.getText().compareTo(other.getText());
    }
    return 1;
  }
}
