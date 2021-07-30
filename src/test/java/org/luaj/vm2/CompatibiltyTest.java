package org.luaj.vm2;

import junit.framework.TestSuite;

import org.luaj.vm2.luajc.LuaJC;

/**
 * Compatibility tests for the Luaj VM
 *
 * <p>Results are compared for exact match with the installed C-based lua environment.
 */
public class CompatibiltyTest extends TestSuite {

  private static final String dir = "";

  protected abstract static class CompatibiltyTestSuite extends ScriptDrivenTest {
    LuaValue savedStringMetatable;

    protected CompatibiltyTestSuite(PlatformType platform) {
      super(platform, dir);
    }

    protected void setUp() throws Exception {
      savedStringMetatable = LuaString.s_metatable;
      super.setUp();
    }

    protected void tearDown() throws Exception {
      super.tearDown();
      LuaNil.s_metatable = null;
      LuaBoolean.s_metatable = null;
      LuaNumber.s_metatable = null;
      LuaFunction.s_metatable = null;
      LuaThread.s_metatable = null;
      LuaString.s_metatable = savedStringMetatable;
    }

    public void testBaseLib() {
      runTest("baselib");
    }

    public void testCoroutineLib() {
      runTest("coroutinelib");
    }

    public void testDebugLib() {
      runTest("debuglib");
    }

    public void testErrors() {
      runTest("errors");
    }

    public void testFunctions() {
      runTest("functions");
    }

    public void testIoLib() {
      runTest("iolib");
    }

    public void testManyUpvals() {
      runTest("manyupvals");
    }

    public void testMathLib() {
      runTest("mathlib");
    }

    public void testMetatags() {
      runTest("metatags");
    }

    public void testOsLib() {
      runTest("oslib");
    }

    public void testStringLib() {
      runTest("stringlib");
    }

    public void testTableLib() {
      runTest("tablelib");
    }

    public void testTailcalls() {
      runTest("tailcalls");
    }

    public void testUpvalues() {
      runTest("upvalues");
    }

    public void testVm() {
      runTest("vm");
    }
  }

  public static TestSuite suite() {
    TestSuite suite = new TestSuite("Compatibility Tests");
    suite.addTest(new TestSuite(JseCompatibilityTest.class, "JSE Compatibility Tests"));
    suite.addTest(new TestSuite(LuaJCCompatibilityTest.class, "LuaJC Compatibility Tests"));
    return suite;
  }

  public static class JseCompatibilityTest extends CompatibiltyTestSuite {
    public JseCompatibilityTest() {
      super(ScriptDrivenTest.PlatformType.JSE);
    }

    protected void setUp() throws Exception {
      super.setUp();
      System.setProperty("JME", "false");
    }
  }

  public static class LuaJCCompatibilityTest extends CompatibiltyTestSuite {
    public LuaJCCompatibilityTest() {
      super(ScriptDrivenTest.PlatformType.LUAJIT);
    }

    protected void setUp() throws Exception {
      super.setUp();
      System.setProperty("JME", "false");
      LuaJC.install(globals);
    }
    // not supported on this platform - don't test
    public void testDebugLib() {}
  }
}
