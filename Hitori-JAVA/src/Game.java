

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Game {
  private Board board;

  public void cg_init_Game_1() {

    board = new Board();
    return;
  }

  public Game() {

    cg_init_Game_1();
  }

  public String toString() {

    return "Game{" + "board := " + Utils.toString(board) + "}";
  }
}
