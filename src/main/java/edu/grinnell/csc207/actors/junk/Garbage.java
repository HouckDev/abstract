package edu.grinnell.csc207.actors.junk;

import edu.grinnell.csc207.Level;

public class Garbage extends Junk{
  /**
   * Create a new junk actor
   * 
   * @param newLevel
   */
  public Garbage(Level newLevel) {
    super(newLevel);
  } // FilingCabinets
  
  @Override
  public String getDisplayText() {
    return "Pile of garbage";
  }
  
}
