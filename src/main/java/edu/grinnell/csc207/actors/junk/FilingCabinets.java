package edu.grinnell.csc207.actors.junk;

import edu.grinnell.csc207.App;
import edu.grinnell.csc207.Level;

public class FilingCabinets extends Junk {
  /**
   * Create a new junk actor
   * 
   * @param newLevel
   */
  public FilingCabinets(Level newLevel) {
    super(newLevel);
  } // FilingCabinets

  @Override
  public void getDisplayText() {
    App.runningApp.getUserInterface().getTerminal().addConsoleOutput("Cabinets");
  } // getDisplayText

} // Filing Cabinets
