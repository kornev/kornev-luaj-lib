package org.luaj.vm2;

import junit.framework.TestCase;

import org.luaj.vm2.lib.jse.JsePlatform;

public class UTF8StreamTest extends TestCase {

  public void testUtf8CharsInStream() {
    String script = "x = \"98\u00b0: today's temp!\"\n" + "print('x = ', x)\n" + "return x";
    Globals globals = JsePlatform.standardGlobals();
    LuaValue chunk = globals.load(script);
    LuaValue result = chunk.call();
    String str = result.tojstring();
    assertEquals("98\u00b0: today's temp!", str);
  }
}
