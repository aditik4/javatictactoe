package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {

  private String boardString;
  private char[][] theBoard;
  final int BOARD_SIZE = 9;
  int k = (int) Math.sqrt(BOARD_SIZE);

  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */
  public TicTacToeBoard(String board) {
    if(board == null || board.length() != BOARD_SIZE) {
      throw new IllegalArgumentException("Not a valid Board");
    }
    //initializes instance variables
    boardString = board.toLowerCase();
    theBoard = new char[k][k];

    //set up array with board values from given string
    int stringPos = 0; // current position in string
    for(int i = 0; i < k; i++) {
      for(int j = 0; j < k; j++) {
        theBoard[i][j] = boardString.charAt(stringPos);
        stringPos++;
      }
    }
  }

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
    //tests for initial Unreachable state cases
    int countX = 0;
    int countO = 0;
    for(int i = 0; i < k; i++) {
      for(int j = 0; j < k; j++) {
        if(theBoard[i][j] == 'x') {
          countX++;
        } if (theBoard[i][j] == 'o') {
          countO++;
        }
      }
    }
    if(countX >= (2 + countO) || countO >= (1 + countX)) {
      return Evaluation.UnreachableState;
    }

   //determines if a winner is present on the board and returns appropriate state.
    boolean xWins = isWinnerHorizontal('x') || isWinnerVertical('x') ||
                      isWinnerDiagonal('x') || isWinnerReverseDiagonal('x');
    boolean oWins = isWinnerHorizontal('o') || isWinnerVertical('o') ||
                    isWinnerDiagonal('o') || isWinnerReverseDiagonal('o');
    if(oWins && xWins) {
      return Evaluation.UnreachableState;
    }
    if(oWins) {
      return Evaluation.Owins;
    }
    if(xWins) {
      return Evaluation.Xwins;
    }
    return Evaluation.NoWinner;
  }

  /**
   * Determines if a winner is present in the diagonal direction.
   * @param check the character to check for.
   * @return true if there is a win in the diagonal direction;
   *         otherwise, false.
   */
  public boolean isWinnerDiagonal(char check) {
    for(int i = 0; i < k; i++) {
      if(theBoard[i][i] != check) {
        return false;
      }
    }
    return true;
  }

  /**
   * Determines if a win is present in the reverse diagonal direction.
   * @param check the character to check for.
   * @return true if the board contains a win in the reverse diagonal direction'
   *         otherwise, false.
   */
  public boolean isWinnerReverseDiagonal(char check) {
    for(int i = 0; i < k; i++) {
      if(theBoard[k - i - 1][i] != check) {
        return false;
      }
    }
    return true;
  }

  /**
   * Determines if a win is present in the vertical direction.
   * @param check the character to cheeck for.
   * @return true if a vertical win is present;
   *         otherwise, false.
   */
  public boolean isWinnerVertical(char check) {
    for(int i = 0; i < k; i++) {
      if(theBoard[0][i] == check) {
        for(int j = 0; j < k; j++) {
          if(theBoard[j][i] != check) {
            break;
          } else if(j == k - 1) {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * Determines if a win is present in the horizontal direction.
   * @param check the character to check for.
   * @return true if a horizontal win is present;
   *         otherwise, false.
   */
  public boolean isWinnerHorizontal(char check) {
    for(int i = 0; i < k; i++) {
      if(theBoard[i][0] == check) {
        for(int j = 0; j < k; j++) {
          if(theBoard[i][j] != check) {
            break;
          } else if(j == k - 1) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
