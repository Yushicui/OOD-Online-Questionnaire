/**
 * CS5004 Project 3
 * Name: Yushi Cui
 */

import org.junit.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {

  @Test
  public void testLikert() {
    Likert LikertQn = new Likert("Does your job have work life balance?");
    assertEquals(Question.CORRECT, LikertQn.answer("3"));
    assertEquals(Question.CORRECT, LikertQn.answer("5"));
    assertEquals(Question.INCORRECT, LikertQn.answer("0"));
    assertEquals(Question.INCORRECT, LikertQn.answer(""));
    assertEquals(Question.INCORRECT, LikertQn.answer("6"));
    assertEquals(Question.INCORRECT, LikertQn.answer("abc"));
    assertEquals("Does your job have work life balance?", LikertQn.getText());
  }

  @Test
  public void testMultipleChoiceQuestion() {
    MultipleChoice MCQn = new MultipleChoice("What is the color of the hat?", "1", "Blue", "Red", "Black", "Yellow");
    assertEquals(Question.CORRECT, MCQn.answer("1"));
    assertEquals(Question.INCORRECT, MCQn.answer("3"));
    assertEquals(Question.INCORRECT, MCQn.answer("5"));
    assertEquals(Question.INCORRECT, MCQn.answer(""));
    assertEquals(Question.INCORRECT, MCQn.answer("abc"));
    assertEquals("What is the color of the hat?", MCQn.getText());

    assertThrows(IllegalArgumentException.class, () -> {
      new MultipleChoice("Question", "2", "1", "2");});

    assertThrows(IllegalArgumentException.class, () -> {
      new MultipleChoice("Question", "2","1","2","3","4","5","6","7","8","9");});
  }

  @Test
  public void testMultipleSelectQuestion() {
    MultipleSelect MSQn = new MultipleSelect("Which of the following are food?", "1 2", "Pizza", "Burger", "Table", "Chair");
    assertEquals(Question.CORRECT, MSQn.answer("1 2"));
    assertEquals(Question.INCORRECT, MSQn.answer("1"));
    assertEquals(Question.INCORRECT, MSQn.answer("2 4"));
    assertEquals(Question.INCORRECT, MSQn.answer(""));
    assertEquals(Question.INCORRECT, MSQn.answer("abc"));
    assertEquals("Which of the following are food?", MSQn.getText());

    assertThrows(IllegalArgumentException.class, () -> {
      new MultipleSelect("Question", "3 5", "1", "2");});

    assertThrows(IllegalArgumentException.class, () -> {
      new MultipleSelect("Question", "3 5","1","2","3","4","5","6","7","8","9");});
  }

  @Test
  public void testTrueFalseQuestion() {
    TrueFalse TFQn1 = new TrueFalse("Is dog an animal?", "true");
    TrueFalse TFQn2 = new TrueFalse("Dog is not an animal?", "false");
    assertEquals(Question.CORRECT, TFQn1.answer("tRue"));
    assertEquals(Question.CORRECT, TFQn1.answer("TRUE"));
    assertEquals(Question.INCORRECT, TFQn1.answer(" "));
    assertEquals(Question.INCORRECT, TFQn1.answer("false"));
    assertEquals(Question.INCORRECT, TFQn1.answer("abc"));
    assertEquals(Question.INCORRECT, TFQn1.answer("123"));

    assertEquals(Question.CORRECT, TFQn2.answer("fALse"));
    assertEquals(Question.CORRECT, TFQn2.answer("FALSE"));
    assertEquals(Question.INCORRECT, TFQn2.answer(" "));
    assertEquals(Question.INCORRECT, TFQn2.answer("true"));
    assertEquals(Question.INCORRECT, TFQn2.answer("abc"));
    assertEquals(Question.INCORRECT, TFQn2.answer("123"));

    assertEquals("Is dog an animal?", TFQn1.getText());
  }

  @Test
  public void testCompareTo() {
    TrueFalse TFQn1 = new TrueFalse("Is Java a programming language?", "true");
    TrueFalse TFQn2 = new TrueFalse("Is Python a programming language?", "true");
    MultipleChoice MCQn1 = new MultipleChoice("What is the capital of the UK?", "2", "London", "Paris", "Berlin", "Madrid");
    MultipleChoice MCQn2 = new MultipleChoice("What is the capital of France?", "1", "London", "Paris", "Berlin", "Madrid");
    MultipleSelect MSQn1 = new MultipleSelect("Which of the following are fruits?", "1 3", "Apple", "Carrot", "Banana", "Potato");
    MultipleSelect MSQn2 = new MultipleSelect("Which of the following are vegetables?", "2 4", "Apple", "Carrot", "Banana", "Potato");
    Likert LikertQn1 = new Likert("Do you like tea?");
    Likert LikertQn2 = new Likert("Do you like coffee?");

    assertTrue(TFQn1.compareTo(TFQn2) < 0);
    assertTrue(MCQn1.compareTo(MCQn2) > 0);
    assertTrue(MSQn1.compareTo(MSQn2) < 0);
    assertTrue(LikertQn1.compareTo(LikertQn2) > 0);

    assertTrue(TFQn1.compareTo(MCQn1) < 0);
    assertTrue(TFQn1.compareTo(MSQn1) < 0);
    assertTrue(TFQn1.compareTo(LikertQn1) < 0);

    assertTrue(MCQn1.compareTo(MSQn1) < 0);
    assertTrue(MCQn1.compareTo(LikertQn1) < 0);

    assertTrue(MSQn1.compareTo(LikertQn1) < 0);

    assertTrue(LikertQn1.compareTo(TFQn1) > 0);
    assertTrue(LikertQn1.compareTo(MCQn1) > 0);
    assertTrue(LikertQn1.compareTo(MSQn1) > 0);

    Question[] questionnaire = {LikertQn1, MSQn1, TFQn2, MCQn1, TFQn1, MSQn2};
    Question[] expectedQuestionnaire = {TFQn1, TFQn2, MCQn1, MSQn1, MSQn2, LikertQn1};
    Arrays.sort(questionnaire);
    assertArrayEquals(expectedQuestionnaire, questionnaire);

    for (Question question : questionnaire) {
      System.out.println(question.getText());
    }
  }

}