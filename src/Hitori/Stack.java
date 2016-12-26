package Hitori;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Stack {
  private VDMSeq contents = SeqUtil.seq();
  private Number capacity;

  public void cg_init_Stack_1(final Number c) {

    capacity = c;
    return;
  }

  public Stack(final Number c) {

    cg_init_Stack_1(c);
  }

  public void clear() {

    contents = SeqUtil.seq();
  }

  public void push(final Cell x) {

    contents = SeqUtil.conc(SeqUtil.seq(x), Utils.copy(contents));
  }

  public void pop() {

    contents = SeqUtil.tail(Utils.copy(contents));
  }

  public Cell top() {

    return ((Cell) contents.get(0));
  }

  public Number getContentsLen() {

    return contents.size();
  }

  public Stack() {}

  public String toString() {

    return "Stack{"
        + "contents := "
        + Utils.toString(contents)
        + ", capacity := "
        + Utils.toString(capacity)
        + "}";
  }
}
