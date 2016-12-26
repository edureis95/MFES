

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Cell {
  public Object color = Hitori.quotes.WHITEQuote.getInstance();
  public Number number;
  private Coord coord;

  public void cg_init_Cell_1(final Number n, final Coord c) {

    number = n;
    coord = Utils.copy(c);
    return;
  }

  public Cell(final Number n, final Coord c) {

    cg_init_Cell_1(n, Utils.copy(c));
  }

  public Number getNumber() {

    return number;
  }

  public Coord getCoord() {

    return Utils.copy(coord);
  }

  public Cell() {}

  public String toString() {

    return "Cell{"
        + "color := "
        + Utils.toString(color)
        + ", number := "
        + Utils.toString(number)
        + ", coord := "
        + Utils.toString(coord)
        + "}";
  }

  public static class Coord implements Record {
    public Number x;
    public Number y;

    public Coord(final Number _x, final Number _y) {

      x = _x;
      y = _y;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof Coord)) {
        return false;
      }

      Coord other = ((Coord) obj);

      return (Utils.equals(x, other.x)) && (Utils.equals(y, other.y));
    }

    public int hashCode() {

      return Utils.hashCode(x, y);
    }

    public Coord copy() {

      return new Coord(x, y);
    }

    public String toString() {

      return "mk_Cell`Coord" + Utils.formatFields(x, y);
    }
  }
}
