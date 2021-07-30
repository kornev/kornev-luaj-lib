package org.luaj.vm2.lib;

import java.io.InputStream;

import org.luaj.vm2.Globals;

/**
 * Interface for opening application resource files such as scripts sources.
 *
 * <p>This is used by required to load files that are part of the application, and implemented by
 * BaseLib for Jse platform.
 *
 * <p>The io library does not use this API for file manipulation.
 *
 * <p>
 *
 * @see BaseLib
 * @see Globals#finder
 * @see org.luaj.vm2.lib.jse.JseBaseLib
 * @see org.luaj.vm2.lib.jse.JsePlatform
 */
public interface ResourceFinder {

  /**
   * Try to open a file, or return null if not found.
   *
   * @see org.luaj.vm2.lib.BaseLib
   * @see org.luaj.vm2.lib.jse.JseBaseLib
   * @param filename path to file
   * @return InputStream, or null if not found.
   */
  public InputStream findResource(String filename);
}
