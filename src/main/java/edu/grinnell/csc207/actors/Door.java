package edu.grinnell.csc207.actors;

import edu.grinnell.csc207.App;
import edu.grinnell.csc207.Level;

/**
 * Door Represents a door actor Can be shut to prevent movement of actors.
 *
 * @author Mitch Paiva and Paden Houck
 */
public class Door extends Actor {
  /**
   * Keeps track of door status.
   */
  private boolean isClosedBoolean = false;

  /**
   * Keeps track of door timer.
   */
  private int timer = 0;

  /**
   * Set is closed to false.
   *
   * @return isClosedBoolean the current boolean for the door.
   */
  public boolean isClosed() {
    return isClosedBoolean;
  } // isClosed

  /**
   * Set is closed to false.
   *
   * @param isClosed
   */
  public void setClosed(boolean isClosed) {
    this.isClosedBoolean = isClosed;
  } // setClosed

  /**
   * Create a new door.
   *
   * @param newLevel
   */
  public Door(Level newLevel) {
    super(newLevel);
  } // door

  /**
   * parses the command and tells the door to close if applicable, then sets the amount of time the
   * door will be closed for.
   *
   * @param command
   *
   */
  @Override
  public String parseCommand(String command) {
    if (command.equals("CLOSE")) {
      this.isClosedBoolean = true;
      this.timer = (int) (Math.random()) * 2 + 4;
      return "DOOR CLOSED";
    } else {
      return super.parseCommand(command);
    } // else
  } // parseCommand

  /**
   * Gets display text.
   *
   */
  @Override
  public void getDisplayText() {
    if (isClosed()) {
      App.runningApp.getUserInterface().getTerminal().addConsoleOutput("DOOR [Closed]");

    } else {
      App.runningApp.getUserInterface().getTerminal().addConsoleOutput("DOOR [Open]");

    } // else
  } // getDisplayText

  /**
   * Advance the timer for the door.
   *
   */
  @Override
  public void advanceTurn() {
    this.timer = -1;
    if (this.timer <= 0) {
      this.isClosedBoolean = false;
    } // if
  } // advanceTurn
} // Door
