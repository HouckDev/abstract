package edu.grinnell.csc207.actors;

import edu.grinnell.csc207.App;
import edu.grinnell.csc207.Level;

/**
 * Door Represents a door actor Can be shut to prevent movement of actors
 */
public class Door extends Actor {
  // add boolean for status of door
  private boolean isClosed = false;
  private int timer = 0;

  /**
   * Set is closed to false
   */
  public boolean isClosed() {
    return isClosed;
  } // isClosed

  /**
   * Set is closed to false
   * 
   * @param isClosed
   */
  public void setClosed(boolean isClosed) {
    this.isClosed = isClosed;
  } // setClosed

  /**
   * Create a new door
   * 
   * @param newLevel
   */
  public Door(Level newLevel) {
    super(newLevel);
  } // door

    /**
   * parses the command and tells the door to close if applicable, 
   * then sets the amount of time the door will be closed for.
   * 
   * @param command
   * 
   */
  @Override
  public String parseCommand(String command) {
    if (command.equals("CLOSE")) {
      this.isClosed = true;
      this.timer = (int) (Math.random()) * 2 + 2;
      return "DOOR CLOSED";
    } else {
      return super.parseCommand(command);
    } // else
  } // parseCommand

  @Override
  public void getDisplayText() {
    if (isClosed()) {
      App.runningApp.getUserInterface().getTerminal().addConsoleOutput( "DOOR [Closed]");

    } else {
      App.runningApp.getUserInterface().getTerminal().addConsoleOutput( "DOOR [Open]");

    }
  }

  /**
   * Advance the timer for the door
   * 
   */
  @Override
  public void advanceTurn() {
    this.timer = -1;
    if (this.timer <= 0) {
      this.isClosed = false;
    } // if
  } // advanceTurn
} // Door 
