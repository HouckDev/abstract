package edu.grinnell.csc207.actors;

import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.matrix.MatrixV0;
import edu.grinnell.csc207.rooms.Hallway;
import edu.grinnell.csc207.rooms.OfficeRoom;
import edu.grinnell.csc207.rooms.Room;

/**
 * Monster Represents a monster actor Can be prevented by doors and detected by motion sensors
 */

public class Monster extends Actor {

  private static final int ROOM_COUNT = 8;

  // create a new monster
  public Monster(Level newLevel) {
    super(newLevel);
  } // monster

  /**
   * Advance the monster's movement to a valid room without a closed door.
   * 
   */
  @Override
  public void advanceTurn() {
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int direction = (int) (Math.random() * directions.length);
    if (getCurrentRoom() instanceof OfficeRoom) {
      // STUB
    }
    while (getOwningLevel().getLevelRooms().get(getPosition()[0] + directions[direction][0],
        getPosition()[1] + directions[direction][1]) == null) {
      direction = (int) (Math.random() * directions.length);
    } // while
    (getOwningLevel().getLevelRooms().get(getPosition()[0] + directions[direction][0],
        getPosition()[1] + directions[direction][1])).addActor(this);
  } // advanceTurn
} // Monster
