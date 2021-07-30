package org.luaj.vm2;

import java.io.InputStream;
import java.io.Reader;

import junit.framework.TestCase;

import org.luaj.vm2.lib.jse.JsePlatform;
import org.luaj.vm2.server.Launcher;
import org.luaj.vm2.server.LuajClassLoader;

// Tests using class loading orders that have caused problems for some use cases.
public class LoadOrderTest extends TestCase {

  public void testLoadGlobalsFirst() {
    Globals g = JsePlatform.standardGlobals();
    assertNotNull(g);
  }

  public void testLoadStringFirst() {
    LuaString BAR = LuaString.valueOf("bar");
    assertNotNull(BAR);
  }

  public static class TestLauncherLoadStringFirst implements Launcher {
    // Static initializer that causes LuaString->LuaValue->LuaString
    private static final LuaString FOO = LuaString.valueOf("foo");

    @Override
    public Object[] launch(String script, Object[] arg) {
      return new Object[] {FOO};
    }

    @Override
    public Object[] launch(InputStream script, Object[] arg) {
      return null;
    }

    @Override
    public Object[] launch(Reader script, Object[] arg) {
      return null;
    }
  }

  public void testClassLoadsStringFirst() throws Exception {
    Launcher launcher = LuajClassLoader.NewLauncher(TestLauncherLoadStringFirst.class);
    Object[] results = launcher.launch("foo", null);
    assertNotNull(results);
  }
}
