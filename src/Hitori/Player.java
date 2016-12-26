package Hitori;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Player {
  private Board board;
  private Rules rules;

  public void cg_init_Player_1(final Board boardArg, final Rules rulesArg) {

    board = boardArg;
    rules = rulesArg;
  }

  public Player(final Board boardArg, final Rules rulesArg) {

    cg_init_Player_1(boardArg, rulesArg);
  }

  public void play(final Cell.Coord coords) {

    Cell cell = null;
    cell = board.getCellOfBoard(Utils.copy(coords));
    if (Utils.equals(cell.color, Hitori.quotes.WHITEQuote.getInstance())) {
      cell.color = Hitori.quotes.BLACKQuote.getInstance();
    } else {
      cell.color = Hitori.quotes.WHITEQuote.getInstance();
    }

    board.setCellOfBoard(Utils.copy(coords), cell);
  }

  public Boolean checkWin() {

    Boolean andResult_8 = false;

    if (rules.checkRule1(board.getBoard(), board.getBoardSize())) {
      Boolean andResult_9 = false;

      if (rules.checkRule2(board.getBoard(), board.getBoardSize())) {
        if (rules.checkRule3(board.getBoard(), board.getBoardSize())) {
          andResult_9 = true;
        }
      }

      if (andResult_9) {
        andResult_8 = true;
      }
    }

    if (andResult_8) {
      return true;

    } else {
      return false;
    }
  }

  public Player() {}

  public String toString() {

    return "Player{"
        + "board := "
        + Utils.toString(board)
        + ", rules := "
        + Utils.toString(rules)
        + "}";
  }
}
