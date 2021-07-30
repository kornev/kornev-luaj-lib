package org.luaj.vm2;

import org.luaj.vm2.LuaTable.Slot;

/** Provides operations that depend on the __mode key of the metatable. */
interface Metatable {

  /** Return whether or not this table's keys are weak. */
  boolean useWeakKeys();

  /** Return whether or not this table's values are weak. */
  boolean useWeakValues();

  /** Return this metatable as a LuaValue. */
  LuaValue toLuaValue();

  /** Return an instance of Slot appropriate for the given key and value. */
  Slot entry(LuaValue key, LuaValue value);

  /** Returns the given value wrapped in a weak reference if appropriate. */
  LuaValue wrap(LuaValue value);

  /**
   * Returns the value at the given index in the array, or null if it is a weak reference that has
   * been dropped.
   */
  LuaValue arrayget(LuaValue[] array, int index);
}
