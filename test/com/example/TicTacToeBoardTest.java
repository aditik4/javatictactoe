package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Testing Strategy:
 * Tested for Illegal Argument, No Winner, Valid Boards, and Unreachable States.
 */
public class TicTacToeBoardTest {
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgument() {
    TicTacToeBoard board = new TicTacToeBoard("oo");
    board.evaluate();
  }
  @Test
  public void testValidBoardNoWinner() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }
  @Test
  public void testValidBoardHorizontalXWins() {
    TicTacToeBoard board = new TicTacToeBoard("XxxO.o...");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }
  @Test
  public void testValidBoardVerticalXWins() {
    TicTacToeBoard board = new TicTacToeBoard("xooxxoxox");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }
  @Test
  public void testValidBoardDiagonalXWins() {
    TicTacToeBoard board = new TicTacToeBoard("X_o.x_o.x");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }
  @Test
  public void testValidBoardHorizontalOWins() {
    TicTacToeBoard board = new TicTacToeBoard(".x.oOox.x");
    assertEquals(Evaluation.Owins, board.evaluate());
  }
  @Test
  public void testValidBoardVerticalOWins() {
    TicTacToeBoard board = new TicTacToeBoard(".o.XOzxoX");
    assertEquals(Evaluation.Owins, board.evaluate());
  }
  @Test
  public void testValidBoardDiagonalOWins() {
    TicTacToeBoard board = new TicTacToeBoard("xxO.oXozz");
    assertEquals(Evaluation.Owins, board.evaluate());
  }
  @Test
  public void testUnreachableUnevenX() {
    TicTacToeBoard board = new TicTacToeBoard("xzxxOx.xz");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }
  @Test
  public void testUnreachableUnevenO() {
    TicTacToeBoard board = new TicTacToeBoard("O.oOxo.o.");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }
  @Test
  public void testUnreachableXWins() {
    TicTacToeBoard board = new TicTacToeBoard("XoOxo.xo.");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }
  @Test
  public void testUnreachableDoubleWin() {
    TicTacToeBoard board = new TicTacToeBoard("OoOx.oxXx");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }
}
