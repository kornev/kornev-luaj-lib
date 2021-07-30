package org.luaj.vm2;

import java.io.IOException;
import java.io.InputStream;

/**
 * Test argument type check errors
 *
 * <p>Results are compared for exact match with the installed C-based lua environment.
 */
public class ErrorsTest extends ScriptDrivenTest {

  private static final String dir = "errors/";

  public ErrorsTest() {
    super(ScriptDrivenTest.PlatformType.JSE, dir);
  }

  protected void setUp() throws Exception {
    super.setUp();
  }

  public void testBaseLibArgs() {
    globals.STDIN =
        new InputStream() {
          public int read() throws IOException {
            return -1;
          }
        };
    runTest("baselibargs");
  }

  public void testCoroutineLibArgs() {
    runTest("coroutinelibargs");
  }

  public void testDebugLibArgs() {
    runTest("debuglibargs");
  }

  public void testIoLibArgs() {
    runTest("iolibargs");
  }

  public void testMathLibArgs() {
    runTest("mathlibargs");
  }

  public void testModuleLibArgs() {
    runTest("modulelibargs");
  }

  public void testOperators() {
    runTest("operators");
  }

  public void testStringLibArgs() {
    runTest("stringlibargs");
  }

  public void testTableLibArgs() {
    runTest("tablelibargs");
  }
}
