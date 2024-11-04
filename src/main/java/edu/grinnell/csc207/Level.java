package edu.grinnell.csc207;

import edu.grinnell.csc207.matrix.Matrix;
import edu.grinnell.csc207.rooms.Room;

/**
 * Level
 * Holds a matrix of all the rooms in the game, also contains other enviormental info
 */
public class Level implements TurnInterface {
  /**
   * Matrix of room layouts
   */
  Matrix<Room> level;


  /**
   * Generate a new level given the default parameters
   */
  public Level() {

  } // Level


  @Override
  public void advanceTurn() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'advanceTurn'");
  }

} // Level
