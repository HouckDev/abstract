package edu.grinnell.csc207.actors.junk;

import edu.grinnell.csc207.App;
import edu.grinnell.csc207.Level;

/**
 * A junk type that has a chance to spawn in a room.
 *
 * @author Mitch Paiva and Paden Houck
 */
public class AngryStudents extends Junk {
  /**
   * Create a new junk actor.
   *
   * @param newLevel
   */
  public AngryStudents(Level newLevel) {
    super(newLevel);
  } // FilingCabinets

  /**
   * Gets the display text.
   */
  @Override
  public void getDisplayText() {
    App.runningApp.getUserInterface().getTerminal().addConsoleOutput("Two angry CS students");
  } // getDisplayText

} // angryStudents
