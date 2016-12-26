package Hitori;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Rules {
  public void cg_init_Rules_1() {

    return;
  }

  public Rules() {

    cg_init_Rules_1();
  }

  public Boolean checkRule1(final VDMMap board, final Number size) {

    Cell cell = null;
    Cell.Coord coords = null;
    for (Iterator iterator_27 = MapUtil.rng(Utils.copy(board)).iterator();
        iterator_27.hasNext();
        ) {
      Cell i = (Cell) iterator_27.next();
      cell = i;
      coords = i.getCoord();
      Boolean andResult_10 = false;

      if (Utils.equals(cell.color, Hitori.quotes.BLACKQuote.getInstance())) {
        Boolean orResult_6 = false;

        Boolean andResult_11 = false;

        if (coords.x.longValue() < size.longValue() - 1L) {
          if (Utils.equals(
              getCellOfBoard(new Cell.Coord(coords.x.longValue() + 1L, coords.y), Utils.copy(board))
                  .color,
              Hitori.quotes.BLACKQuote.getInstance())) {
            andResult_11 = true;
          }
        }

        if (andResult_11) {
          orResult_6 = true;
        } else {
          Boolean orResult_7 = false;

          Boolean andResult_12 = false;

          if (coords.y.longValue() < size.longValue() - 1L) {
            if (Utils.equals(
                getCellOfBoard(
                        new Cell.Coord(coords.x, coords.y.longValue() + 1L), Utils.copy(board))
                    .color,
                Hitori.quotes.BLACKQuote.getInstance())) {
              andResult_12 = true;
            }
          }

          if (andResult_12) {
            orResult_7 = true;
          } else {
            Boolean orResult_8 = false;

            Boolean andResult_13 = false;

            if (coords.x.longValue() > 0L) {
              if (Utils.equals(
                  getCellOfBoard(
                          new Cell.Coord(coords.x.longValue() - 1L, coords.y), Utils.copy(board))
                      .color,
                  Hitori.quotes.BLACKQuote.getInstance())) {
                andResult_13 = true;
              }
            }

            if (andResult_13) {
              orResult_8 = true;
            } else {
              Boolean andResult_14 = false;

              if (coords.y.longValue() > 0L) {
                if (Utils.equals(
                    getCellOfBoard(
                            new Cell.Coord(coords.x, coords.y.longValue() - 1L), Utils.copy(board))
                        .color,
                    Hitori.quotes.BLACKQuote.getInstance())) {
                  andResult_14 = true;
                }
              }

              orResult_8 = andResult_14;
            }

            orResult_7 = orResult_8;
          }

          orResult_6 = orResult_7;
        }

        if (orResult_6) {
          andResult_10 = true;
        }
      }

      if (andResult_10) {
        return false;
      }
    }
    return true;
  }

  public Cell getCellOfBoard(final Cell.Coord coord, final VDMMap board) {

    VDMMap mapCell = MapUtil.map();
    mapCell = MapUtil.domResTo(SetUtil.set(Utils.copy(coord)), Utils.copy(board));
    {
      Cell j = null;
      Boolean success_13 = false;
      VDMSet set_13 = MapUtil.rng(Utils.copy(mapCell));
      for (Iterator iterator_13 = set_13.iterator(); iterator_13.hasNext() && !(success_13); ) {
        j = ((Cell) iterator_13.next());
        success_13 = true;
      }
      if (!(success_13)) {
        throw new RuntimeException("Let Be St found no applicable bindings");
      }

      {
        return j;
      }
    }
  }

  public Boolean checkRule2(final VDMMap board, final Number size) {

    VDMMap visited = MapUtil.map();
    Cell firstCell = null;
    Cell cellAnalyzing = null;
    Cell cellGoingToStack = null;
    Stack neighborsToAnalyze = new Stack(size.longValue() * size.longValue());
    for (Iterator iterator_28 = MapUtil.dom(Utils.copy(board)).iterator();
        iterator_28.hasNext();
        ) {
      Cell.Coord i = (Cell.Coord) iterator_28.next();
      visited = MapUtil.override(Utils.copy(visited), MapUtil.map(new Maplet(Utils.copy(i), 0L)));
    }
    for (Iterator iterator_29 = MapUtil.rng(Utils.copy(board)).iterator();
        iterator_29.hasNext();
        ) {
      Cell i = (Cell) iterator_29.next();
      if (Utils.equals(i.color, Hitori.quotes.WHITEQuote.getInstance())) {
        firstCell = i;
      }
    }
    neighborsToAnalyze.push(firstCell);
    Boolean whileCond_5 = true;
    while (whileCond_5) {
      whileCond_5 = neighborsToAnalyze.getContentsLen().longValue() > 0L;
      if (!(whileCond_5)) {
        break;
      }

      {
        VDMMap mapCellVisited = MapUtil.map();
        cellAnalyzing = neighborsToAnalyze.top();
        neighborsToAnalyze.pop();
        mapCellVisited =
            MapUtil.domResTo(SetUtil.set(cellAnalyzing.getCoord()), Utils.copy(visited));
        {
          Number j = null;
          Boolean success_14 = false;
          VDMSet set_14 = MapUtil.rng(Utils.copy(mapCellVisited));
          for (Iterator iterator_14 = set_14.iterator(); iterator_14.hasNext() && !(success_14); ) {
            j = ((Number) iterator_14.next());
            success_14 = true;
          }
          if (!(success_14)) {
            throw new RuntimeException("Let Be St found no applicable bindings");
          }

          {
            if (Utils.equals(j, 0L)) {
              visited =
                  MapUtil.override(
                      Utils.copy(visited), MapUtil.map(new Maplet(cellAnalyzing.getCoord(), 1L)));
              if (cellAnalyzing.getCoord().x.longValue() > 0L) {
                cellGoingToStack =
                    getCellOfBoard(
                        new Cell.Coord(
                            cellAnalyzing.getCoord().x.longValue() - 1L,
                            cellAnalyzing.getCoord().y),
                        Utils.copy(board));
                if (Utils.equals(cellGoingToStack.color, Hitori.quotes.WHITEQuote.getInstance())) {
                  mapCellVisited =
                      MapUtil.domResTo(
                          SetUtil.set(cellGoingToStack.getCoord()), Utils.copy(visited));
                  {
                    Number d = null;
                    Boolean success_15 = false;
                    VDMSet set_15 = MapUtil.rng(Utils.copy(mapCellVisited));
                    for (Iterator iterator_15 = set_15.iterator();
                        iterator_15.hasNext() && !(success_15);
                        ) {
                      d = ((Number) iterator_15.next());
                      success_15 = true;
                    }
                    if (!(success_15)) {
                      throw new RuntimeException("Let Be St found no applicable bindings");
                    }

                    {
                      if (Utils.equals(d, 0L)) {
                        neighborsToAnalyze.push(cellGoingToStack);
                      }
                    }
                  }
                }
              }

              if (cellAnalyzing.getCoord().y.longValue() > 0L) {
                cellGoingToStack =
                    getCellOfBoard(
                        new Cell.Coord(
                            cellAnalyzing.getCoord().x,
                            cellAnalyzing.getCoord().y.longValue() - 1L),
                        Utils.copy(board));
                if (Utils.equals(cellGoingToStack.color, Hitori.quotes.WHITEQuote.getInstance())) {
                  mapCellVisited =
                      MapUtil.domResTo(
                          SetUtil.set(cellGoingToStack.getCoord()), Utils.copy(visited));
                  {
                    Number d = null;
                    Boolean success_16 = false;
                    VDMSet set_16 = MapUtil.rng(Utils.copy(mapCellVisited));
                    for (Iterator iterator_16 = set_16.iterator();
                        iterator_16.hasNext() && !(success_16);
                        ) {
                      d = ((Number) iterator_16.next());
                      success_16 = true;
                    }
                    if (!(success_16)) {
                      throw new RuntimeException("Let Be St found no applicable bindings");
                    }

                    {
                      if (Utils.equals(d, 0L)) {
                        neighborsToAnalyze.push(cellGoingToStack);
                      }
                    }
                  }
                }
              }

              if (cellAnalyzing.getCoord().x.longValue() < size.longValue() - 1L) {
                cellGoingToStack =
                    getCellOfBoard(
                        new Cell.Coord(
                            cellAnalyzing.getCoord().x.longValue() + 1L,
                            cellAnalyzing.getCoord().y),
                        Utils.copy(board));
                if (Utils.equals(cellGoingToStack.color, Hitori.quotes.WHITEQuote.getInstance())) {
                  mapCellVisited =
                      MapUtil.domResTo(
                          SetUtil.set(cellGoingToStack.getCoord()), Utils.copy(visited));
                  {
                    Number d = null;
                    Boolean success_17 = false;
                    VDMSet set_17 = MapUtil.rng(Utils.copy(mapCellVisited));
                    for (Iterator iterator_17 = set_17.iterator();
                        iterator_17.hasNext() && !(success_17);
                        ) {
                      d = ((Number) iterator_17.next());
                      success_17 = true;
                    }
                    if (!(success_17)) {
                      throw new RuntimeException("Let Be St found no applicable bindings");
                    }

                    {
                      if (Utils.equals(d, 0L)) {
                        neighborsToAnalyze.push(cellGoingToStack);
                      }
                    }
                  }
                }
              }

              if (cellAnalyzing.getCoord().y.longValue() < size.longValue() - 1L) {
                cellGoingToStack =
                    getCellOfBoard(
                        new Cell.Coord(
                            cellAnalyzing.getCoord().x,
                            cellAnalyzing.getCoord().y.longValue() + 1L),
                        Utils.copy(board));
                if (Utils.equals(cellGoingToStack.color, Hitori.quotes.WHITEQuote.getInstance())) {
                  mapCellVisited =
                      MapUtil.domResTo(
                          SetUtil.set(cellGoingToStack.getCoord()), Utils.copy(visited));
                  {
                    Number d = null;
                    Boolean success_18 = false;
                    VDMSet set_18 = MapUtil.rng(Utils.copy(mapCellVisited));
                    for (Iterator iterator_18 = set_18.iterator();
                        iterator_18.hasNext() && !(success_18);
                        ) {
                      d = ((Number) iterator_18.next());
                      success_18 = true;
                    }
                    if (!(success_18)) {
                      throw new RuntimeException("Let Be St found no applicable bindings");
                    }

                    {
                      if (Utils.equals(d, 0L)) {
                        neighborsToAnalyze.push(cellGoingToStack);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    for (Iterator iterator_30 = MapUtil.rng(Utils.copy(board)).iterator();
        iterator_30.hasNext();
        ) {
      Cell i = (Cell) iterator_30.next();
      VDMMap mapCellVisited = MapUtil.map();
      if (Utils.equals(i.color, Hitori.quotes.WHITEQuote.getInstance())) {
        mapCellVisited = MapUtil.domResTo(SetUtil.set(i.getCoord()), Utils.copy(visited));
        {
          Number j = null;
          Boolean success_19 = false;
          VDMSet set_19 = MapUtil.rng(Utils.copy(mapCellVisited));
          for (Iterator iterator_19 = set_19.iterator(); iterator_19.hasNext() && !(success_19); ) {
            j = ((Number) iterator_19.next());
            success_19 = true;
          }
          if (!(success_19)) {
            throw new RuntimeException("Let Be St found no applicable bindings");
          }

          {
            if (Utils.equals(j, 0L)) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  public Boolean checkRule3(final VDMMap board, final Number size) {

    VDMSet possibleNumbers = SetUtil.range(1L, size);
    VDMMap columnFlag = MapUtil.map();
    VDMMap rowFlag = MapUtil.map();
    VDMMap flag = MapUtil.map();
    for (Iterator iterator_31 = possibleNumbers.iterator(); iterator_31.hasNext(); ) {
      Number i = (Number) iterator_31.next();
      columnFlag = MapUtil.override(Utils.copy(columnFlag), MapUtil.map(new Maplet(i, 0L)));
      rowFlag = MapUtil.override(Utils.copy(columnFlag), MapUtil.map(new Maplet(i, 0L)));
    }
    for (Iterator iterator_32 = SetUtil.range(0L, size.longValue() - 1L).iterator();
        iterator_32.hasNext();
        ) {
      Number i = (Number) iterator_32.next();
      for (Iterator iterator_33 = MapUtil.rng(Utils.copy(board)).iterator();
          iterator_33.hasNext();
          ) {
        Cell j = (Cell) iterator_33.next();
        if (Utils.equals(j.color, Hitori.quotes.WHITEQuote.getInstance())) {
          if (Utils.equals(j.getCoord().x, i)) {
            flag = MapUtil.domResTo(SetUtil.set(j.number), Utils.copy(columnFlag));
            {
              Number k = null;
              Boolean success_20 = false;
              VDMSet set_20 = MapUtil.rng(Utils.copy(flag));
              for (Iterator iterator_20 = set_20.iterator();
                  iterator_20.hasNext() && !(success_20);
                  ) {
                k = ((Number) iterator_20.next());
                success_20 = true;
              }
              if (!(success_20)) {
                throw new RuntimeException("Let Be St found no applicable bindings");
              }

              {
                if (Utils.equals(k, 1L)) {
                  return false;
                }
              }
            }

            flag = MapUtil.map();
            columnFlag =
                MapUtil.override(Utils.copy(columnFlag), MapUtil.map(new Maplet(j.number, 1L)));
          }
        }
      }
      columnFlag = MapUtil.map();
      for (Iterator iterator_34 = possibleNumbers.iterator(); iterator_34.hasNext(); ) {
        Number n = (Number) iterator_34.next();
        columnFlag = MapUtil.override(Utils.copy(columnFlag), MapUtil.map(new Maplet(n, 0L)));
      }
    }
    return true;
  }

  public String toString() {

    return "Rules{}";
  }
}
