package edu.grinnell.csc207.actors.junk;

import edu.grinnell.csc207.Level;

public class FilingCabinets extends Junk{
  /**
   * Create a new junk actor
   * 
   * @param newLevel
   */
  public FilingCabinets(Level newLevel) {
    super(newLevel);
  } // FilingCabinets
  
  @Override
  public String getDisplayText() {
    return "Cabinets";
  }
  
}
