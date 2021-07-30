package org.luaj.vm2.lib.jse;

public class JseStringLib extends org.luaj.vm2.lib.StringLib {

  /** public constructor */
  public JseStringLib() {}

  protected String format(String src, double x) {
    String out;
    try {
      out = String.format(src, new Object[] {Double.valueOf(x)});
    } catch (Throwable e) {
      out = super.format(src, x);
    }
    return out;
  }
}
