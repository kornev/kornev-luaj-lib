package org.luaj.vm2.ast;

import java.util.ArrayList;
import java.util.List;

public class ParList extends SyntaxElement {
  public static final List<Name> EMPTY_NAMELIST = new ArrayList<Name>();
  public static final ParList EMPTY_PARLIST = new ParList(EMPTY_NAMELIST, false);

  public final List<Name> names;
  public final boolean isvararg;

  public ParList(List<Name> names, boolean isvararg) {
    this.names = names;
    this.isvararg = isvararg;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
