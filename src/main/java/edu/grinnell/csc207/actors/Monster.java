package edu.grinnell.csc207.actors;

import java.util.Random;
import edu.grinnell.csc207.App;
import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.matrix.MatrixV0;
import edu.grinnell.csc207.rooms.Hallway;
import edu.grinnell.csc207.rooms.OfficeRoom;
import edu.grinnell.csc207.rooms.Room;
import edu.grinnell.csc207.userInterface.DefaultStyle;

/**
 * Monster Represents a monster actor Can be prevented by doors and detected by motion sensors
 */

public class Monster extends Actor {

  private static final int AGGRESSION_COUNTER = 8;

  // create a new monster
  public Monster(Level newLevel) {
    super(newLevel);
  } // monster

  @Override
  public void getDisplayText() {
    App.runningApp.getUserInterface().getTerminal().addConsoleOutput("SYS$ERROR",DefaultStyle.getErrorTextColor());
  }

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
    } // if
    int movesCounter = 0;
    while ((getOwningLevel().getLevelRooms().get(getPosition()[0] + directions[direction][0],
        getPosition()[1] + directions[direction][1]) == null) || (movesCounter == AGGRESSION_COUNTER)) {
      direction = (int) (Math.random() * directions.length);
      movesCounter += 1;
    } // while
    (getOwningLevel().getLevelRooms().get(getPosition()[0] + directions[direction][0],
        getPosition()[1] + directions[direction][1])).addActor(this);
  } // advanceTurn

  // static void arrayShuffle(int[][] array) {
  //   Random randomizer = new Random();
  //   for (int i = array.length - 1; i > 0; i--) {
  //     int index = randomizer.nextInt(i + 1);
  //     int[] tmp = array[index];
  //     array[index] = array[i];
  //     array[i] = tmp;
  //   }
  // } // arrayShuffle
} // Monster
