package edu.grinnell.csc207.actors.junk;

import edu.grinnell.csc207.Level;

public class TVStack extends Junk{
  /**
   * Create a new junk actor
   * 
   * @param newLevel
   */
  public TVStack(Level newLevel) {
    super(newLevel);
  } // TVStack
  
  @Override
  public String getDisplayText() {
    return "Stack of cracked TV's";
  }
  
}
