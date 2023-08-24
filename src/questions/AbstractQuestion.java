/**
 * CS5004 Project 3
 * Name: Yushi Cui
 */

package questions;

/**
 * This abstract class provides common methods for all types of questions.
 */
public abstract class AbstractQuestion implements Question{

  protected String text;

  /**
   * Constructor for a question.
   *
   * @param text the text of the question
   */
  public AbstractQuestion(String text) {
    this.text = text;
  }

  /**
   * Returns the text of the question.
   *
   * @return the text
   */
  @Override
  public String getText() {
    return this.text;
  }
}
