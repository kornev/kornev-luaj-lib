package org.luaj.vm2.ast;

import java.util.ArrayList;
import java.util.List;

public class Block extends Stat {

  public List<Stat> stats = new ArrayList<Stat>();
  public NameScope scope;

  public void add(Stat s) {
    if (s == null) return;
    stats.add(s);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
