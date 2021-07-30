package org.luaj.vm2.ast;

public class TableField extends SyntaxElement {

  public final Exp index;
  public final String name;
  public final Exp rhs;

  public TableField(Exp index, String name, Exp rhs) {
    this.index = index;
    this.name = name;
    this.rhs = rhs;
  }

  public static TableField keyedField(Exp index, Exp rhs) {
    return new TableField(index, null, rhs);
  }

  public static TableField namedField(String name, Exp rhs) {
    return new TableField(null, name, rhs);
  }

  public static TableField listField(Exp rhs) {
    return new TableField(null, null, rhs);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
