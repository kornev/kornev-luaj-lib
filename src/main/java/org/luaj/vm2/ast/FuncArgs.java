package org.luaj.vm2.ast;

import java.util.ArrayList;
import java.util.List;

import org.luaj.vm2.LuaString;

public class FuncArgs extends SyntaxElement {

  public final List<Exp> exps;

  /** exp1,exp2... */
  public static FuncArgs explist(List<Exp> explist) {
    return new FuncArgs(explist);
  }

  /** {...} */
  public static FuncArgs tableconstructor(TableConstructor table) {
    return new FuncArgs(table);
  }

  /** "mylib" */
  public static FuncArgs string(LuaString string) {
    return new FuncArgs(string);
  }

  public FuncArgs(List<Exp> exps) {
    this.exps = exps;
  }

  public FuncArgs(LuaString string) {
    this.exps = new ArrayList<Exp>();
    this.exps.add(Exp.constant(string));
  }

  public FuncArgs(TableConstructor table) {
    this.exps = new ArrayList<Exp>();
    this.exps.add(table);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
