package edu.grinnell.csc207;

import edu.grinnell.csc207.rooms.FacilityRoom;
import edu.grinnell.csc207.rooms.Hallway;
import edu.grinnell.csc207.rooms.OfficeRoom;
import edu.grinnell.csc207.rooms.Room;
import edu.grinnell.csc207.matrix.MatrixV0;

/**
 * Level Holds a matrix of all the rooms in the game, also contains other enviormental info.
 */
public class Level implements TurnInterface {
  /**
   * The default room count.
   */
  private static final int ROOM_COUNT = 8;

  /**
   * Matrix of room layouts.
   */
  MatrixV0<Room> level;

  /**
   * @return the room matrix of this level
   */
  public MatrixV0<Room> getLevelRooms() {
    return level;
  } // getLevelRooms


  /**
   * Generate a new level given the default parameters.
   */
  public Level() {
    // Initialize the room matrix
    this.level = new MatrixV0<Room>(9, 9);
    // Generate the rooms
    int rootX = (this.level.width() - 1) / 2;
    int rootY = (this.level.height() - 1) / 2;
    this.level.set(rootX, rootY, new FacilityRoom(this));
    for (int i = 0; i < ROOM_COUNT; i++) {
      int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
      int direction = (int) (Math.random() * directions.length);
      while (rootX + (directions[direction][0] * 2) < 0
          || rootX + (directions[direction][0] * 2) >= this.level.width()
          || rootY + (directions[direction][1] * 2) < 0
          || rootY + (directions[direction][1] * 2) >= this.level.height()

      ) {
        direction = (int) (Math.random() * directions.length);
      }
      this.level.set(rootX + (directions[direction][0] * 1), rootY + (directions[direction][1] * 1),
          new Hallway(this));
      this.level.set(rootX + (directions[direction][0] * 2), rootY + (directions[direction][1] * 2),
          new FacilityRoom(this));
      rootX = rootX + (directions[direction][0] * 2);
      rootY = rootY + (directions[direction][1] * 2);
    }
    // Place the Player Office
    this.level.set(rootX,rootY,
        new OfficeRoom(this));

  } // Level


  @Override
  public void advanceTurn() {
    for (int y = 0; y < getLevelRooms().height(); y++) {
      for (int x = 0; x < getLevelRooms().height(); x++) {
        if (getLevelRooms().get(y, x) != null) {
          getLevelRooms().get(y, x).advanceTurn();
        } // if
      } // for
    } // for
  } // advanceTurn

} // Level
