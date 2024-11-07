package edu.grinnell.csc207.actors.junk;

import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.actors.Actor;

public class Junk extends Actor {

  /**
   * Create a new junk actor
   * 
   * @param newLevel
   */
  public Junk(Level newLevel) {
    super(newLevel);
  } // door

  @Override
  public String getDisplayText() {
    return "JUNK";
  }
} // Door 
