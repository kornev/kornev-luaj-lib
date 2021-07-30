package org.luaj.vm2.ast;

public class Chunk extends SyntaxElement {
  public final Block block;

  public Chunk(Block b) {
    this.block = b;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
