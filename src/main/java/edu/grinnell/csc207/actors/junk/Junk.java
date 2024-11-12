package edu.grinnell.csc207.actors.junk;

import edu.grinnell.csc207.App;
import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.actors.Actor;

/**
 * A junk type that has a chance to spawn in a room.
 *
 * @author Mitch Paiva and Paden Houck
 */
public class Junk extends Actor {

  /**
   * Create a new junk actor.
   *
   * @param newLevel
   */
  public Junk(Level newLevel) {
    super(newLevel);
  } // door

  /**
   * Gets the display text.
   */
  @Override
  public void getDisplayText() {
    App.runningApp.getUserInterface().getTerminal().addConsoleOutput("JUNK");
  } // getDisplayText
} // Door
