package edu.grinnell.csc207.actors;

import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.TurnInterface;
import edu.grinnell.csc207.rooms.Room;

/**
 * Actor Base class for an 'actor', an object that has a tangible prescense in the game level.
 */
public class Actor implements TurnInterface {

  /**
   * The level that this actor is in.
   */
  private Level owningLevel;
  /**
   * The room that this actor is in
   */
  private Room currentRoom;


  /**
   * @param currentRoom the room
   */
  public Room getCurrentRoom() {
    return currentRoom;
  } // getCurrentRoom

  /**
   * @param currentRoom the room to be set to
   */
  public void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  /**
   * @return the owning level
   */
  public Level getOwningLevel() {
    return owningLevel;
  } // getOwningLevle

  public int[] getPosition() {
    for (int y = 0; y < getOwningLevel().getLevelRooms().height(); y++) {
      for (int x = 0; x < getOwningLevel().getLevelRooms().height(); x++) {
        if (getOwningLevel().getLevelRooms().get(y, x) == getCurrentRoom()) {
          return new int[]{x,y};
        }
      }
    }
    return null;
  }

  /**
   * Constructs a new actor within a level.
   * 
   * @param newlevel
   */
  public Actor(Level newlevel) {
    this.owningLevel = newlevel;
  } // Actor

  @Override
  public void advanceTurn() {} // advanceTurn
} // Actor
