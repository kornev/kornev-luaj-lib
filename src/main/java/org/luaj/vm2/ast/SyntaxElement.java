package org.luaj.vm2.ast;

/**
 * Base class for syntax elements of the parse tree that appear in source files. The LuaParser class
 * will fill these values out during parsing for use in syntax highlighting, for example.
 */
public class SyntaxElement {
  /** The line number on which the element begins. */
  public int beginLine;

  /** The column at which the element begins. */
  public short beginColumn;

  /** The line number on which the element ends. */
  public int endLine;

  /** The column at which the element ends. */
  public short endColumn;
}
