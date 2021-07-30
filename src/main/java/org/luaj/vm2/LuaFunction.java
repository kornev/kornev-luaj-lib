package org.luaj.vm2;

/**
 * Base class for functions implemented in Java.
 *
 * <p>Direct subclass include {@link org.luaj.vm2.lib.LibFunction} which is the base class for all
 * built-in library functions coded in Java, and {@link LuaClosure}, which represents a lua closure
 * whose bytecode is interpreted when the function is invoked.
 *
 * @see LuaValue
 * @see LuaClosure
 * @see org.luaj.vm2.lib.LibFunction
 */
public abstract class LuaFunction extends LuaValue {

  /** Shared static metatable for all functions and closures. */
  public static LuaValue s_metatable;

  public int type() {
    return TFUNCTION;
  }

  public String typename() {
    return "function";
  }

  public boolean isfunction() {
    return true;
  }

  public LuaFunction checkfunction() {
    return this;
  }

  public LuaFunction optfunction(LuaFunction defval) {
    return this;
  }

  public LuaValue getmetatable() {
    return s_metatable;
  }

  public String tojstring() {
    return "function: " + classnamestub();
  }

  public LuaString strvalue() {
    return valueOf(tojstring());
  }

  /**
   * Return the last part of the class name, to be used as a function name in tojstring and
   * elsewhere.
   *
   * @return String naming the last part of the class name after the last dot (.) or dollar sign
   *     ($). If the first character is '_', it is skipped.
   */
  public String classnamestub() {
    String s = getClass().getName();
    int offset = Math.max(s.lastIndexOf('.'), s.lastIndexOf('$')) + 1;
    if (s.charAt(offset) == '_') offset++;
    return s.substring(offset);
  }

  /**
   * Return a human-readable name for this function. Returns the last part of the class name by
   * default. Is overridden by LuaClosure to return the source file and line, and by LibFunctions to
   * return the name.
   *
   * @return common name for this function.
   */
  public String name() {
    return classnamestub();
  }
}
