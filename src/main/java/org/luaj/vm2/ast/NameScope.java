package org.luaj.vm2.ast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NameScope {

  private static final Set<String> LUA_KEYWORDS = new HashSet<String>();

  static {
    String[] k =
        new String[] {
          "and",
          "break",
          "do",
          "else",
          "elseif",
          "end",
          "false",
          "for",
          "function",
          "if",
          "in",
          "local",
          "nil",
          "not",
          "or",
          "repeat",
          "return",
          "then",
          "true",
          "until",
          "while"
        };
    for (int i = 0; i < k.length; i++) LUA_KEYWORDS.add(k[i]);
  }

  public final Map<String, Variable> namedVariables = new HashMap<String, Variable>();

  public final NameScope outerScope;

  public int functionNestingCount;

  /** Construct default names scope */
  public NameScope() {
    this.outerScope = null;
    this.functionNestingCount = 0;
  }

  /** Construct name scope within another scope */
  public NameScope(NameScope outerScope) {
    this.outerScope = outerScope;
    this.functionNestingCount = outerScope != null ? outerScope.functionNestingCount : 0;
  }

  /** Look up a name. If it is a global name, then throw IllegalArgumentException. */
  public Variable find(String name) throws IllegalArgumentException {
    validateIsNotKeyword(name);
    for (NameScope n = this; n != null; n = n.outerScope)
      if (n.namedVariables.containsKey(name)) return (Variable) n.namedVariables.get(name);
    Variable value = new Variable(name);
    this.namedVariables.put(name, value);
    return value;
  }

  /** Define a name in this scope. If it is a global name, then throw IllegalArgumentException. */
  public Variable define(String name) throws IllegalStateException, IllegalArgumentException {
    validateIsNotKeyword(name);
    Variable value = new Variable(name, this);
    this.namedVariables.put(name, value);
    return value;
  }

  private void validateIsNotKeyword(String name) {
    if (LUA_KEYWORDS.contains(name))
      throw new IllegalArgumentException("name is a keyword: '" + name + "'");
  }
}
