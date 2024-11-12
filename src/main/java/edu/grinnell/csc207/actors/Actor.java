package edu.grinnell.csc207.actors;

import edu.grinnell.csc207.CommandInterface;
import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.TurnInterface;
import edu.grinnell.csc207.rooms.Room;

/**
 * Actor Base class for an 'actor', an object that has a tangible prescense in the game level.
 *
 * @author Mitch Paiva and Paden Houck
 */
public class Actor implements TurnInterface, CommandInterface {

  /**
   * The level that this actor is in.
   */
  private Level owningLevel;
  /**
   * The room that this actor is in.
   */
  private Room currentRoom;

  /**
   * Get the display text.
   */
  public void getDisplayText() {
  } // getDisplayText

  /**
   * @return currentRoom the current room.
   */
  public Room getCurrentRoom() {
    return currentRoom;
  } // getCurrentRoom

  /**
   * @param room the room to be set to
   */
  public void setCurrentRoom(Room room) {
    this.currentRoom = room;
  } // setCurrentRoom

  /**
   * @return the owning level
   */
  public Level getOwningLevel() {
    return owningLevel;
  } // getOwningLevle

  /**
   * A function to get the position of the specified actor.
   *
   * @return position
   */
  public int[] getPosition() {
    for (int y = 0; y < getOwningLevel().getLevelRooms().height(); y++) {
      for (int x = 0; x < getOwningLevel().getLevelRooms().height(); x++) {
        if (getOwningLevel().getLevelRooms().get(y, x) == getCurrentRoom()) {
          return new int[] {x, y};
        } // if
      } // for
    } // for
    return null;
  } // getPosition

  /**
   * Constructs a new actor within a level.
   *
   * @param newlevel
   */
  public Actor(Level newlevel) {
    this.owningLevel = newlevel;
  } // Actor

  /**
   * Function to advance the turn.
   */
  @Override
  public void advanceTurn() {
  } // advanceTurn

  /**
   * Parses the command.
   *
   * @param command the command inputted.
   */
  @Override
  public String parseCommand(String command) {
    return "ERROR: Command Not Valid";
  } // parseCommand
} // Actor
