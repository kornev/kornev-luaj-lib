package org.luaj.vm2.ast;

import java.util.List;

public class TableConstructor extends Exp {
  public List<TableField> fields;

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
