package org.luaj.vm2.ast;

import java.util.ArrayList;
import java.util.List;

public class FuncName extends SyntaxElement {
  // example: a.b.c.d:e

  // initial base name: "a"
  public final Name name;

  // intermediate field accesses: "b", "c", "d"
  public List<String> dots;

  // optional final method name: "e"
  public String method;

  public FuncName(String name) {
    this.name = new Name(name);
  }

  public void adddot(String dot) {
    if (dots == null) dots = new ArrayList<String>();
    dots.add(dot);
  }
}
