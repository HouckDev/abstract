package edu.grinnell.csc207;

import edu.grinnell.csc207.rooms.Room;
import edu.grinnell.csc207.matrix.MatrixV0;

/**
 * Level
 * Holds a matrix of all the rooms in the game, also contains other enviormental info
 */
public class Level implements TurnInterface {
  /**
   * Matrix of room layouts
   */
  MatrixV0<Room> level;

  public MatrixV0<Room> getLevelRooms() {
    return level;
  } // getLevelRooms


  /**
   * Generate a new level given the default parameters
   */
  public Level() {
    // Initialize the room matrix
    this.level = new MatrixV0<Room>(5,5);

    // Generate the rooms
    this.level.set(0, 0, new Room());
  } // Level


  @Override
  public void advanceTurn() {
    for (int y = 0; y < getLevelRooms().height(); y++) {
      for (int x = 0; x < getLevelRooms().height(); x++) {
        if (getLevelRooms().get(y, x) != null ) {
          getLevelRooms().get(y, x).advanceTurn();
        } // if
      } // for
    } // for
  } // advanceTurn

} // Level
