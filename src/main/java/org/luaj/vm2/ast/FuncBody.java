package org.luaj.vm2.ast;

public class FuncBody extends SyntaxElement {
  public ParList parlist;
  public Block block;
  public NameScope scope;

  public FuncBody(ParList parlist, Block block) {
    this.parlist = parlist != null ? parlist : ParList.EMPTY_PARLIST;
    this.block = block;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
