package edu.grinnell.csc207.actors;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import edu.grinnell.csc207.App;
import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.matrix.MatrixV0;
import edu.grinnell.csc207.rooms.Hallway;
import edu.grinnell.csc207.rooms.OfficeRoom;
import edu.grinnell.csc207.rooms.Room;
import edu.grinnell.csc207.userInterface.AlertPopupWidget;
import edu.grinnell.csc207.userInterface.DefaultStyle;
import edu.grinnell.csc207.userInterface.GameOverWidget;

/**
 * Monster Represents a monster actor Can be prevented by doors and detected by motion sensors
 */

public class Monster extends Actor {

  private int AGGRESSION_COUNTER = 8;

  // create a new monster
  public Monster(Level newLevel, int cfg_aggression) {
    super(newLevel);
    AGGRESSION_COUNTER = cfg_aggression;
  } // monster

  // create a new monster
  public Monster(Level newLevel) {
    super(newLevel);
  } // monster

  @Override
  public void getDisplayText() {
    App.runningApp.getUserInterface().getTerminal().addConsoleOutput("SYS$ERROR",
        DefaultStyle.getErrorTextColor());
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
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      double width = screenSize.getWidth();
      double height = screenSize.getHeight();
      GameOverWidget testPopup = new GameOverWidget(App.runningApp.getUserInterface());
      testPopup.setLocation(((int) width / 2) - (testPopup.getWidth() / 2),
          ((int) height / 2) - (testPopup.getHeight() / 2));
      App.runningApp.getUserInterface().getTerminal().addConsoleOutput("GAME OVER");
      return;
    } // if
    int movesCounter = 0;

    boolean isNotValid = true;

    while (isNotValid || (movesCounter == AGGRESSION_COUNTER)) {
      direction = (int) (Math.random() * directions.length);
      movesCounter += 1;

      Room currentDesiredRoom = getOwningLevel().getLevelRooms().get(
          getPosition()[0] + directions[direction][0], getPosition()[1] + directions[direction][1]);

      isNotValid = (currentDesiredRoom == null);

      if (!isNotValid) {
        for (Actor actor : currentDesiredRoom.getContents()) {
          if (actor instanceof Door) {
            if (((Door) actor).isClosed())
              isNotValid = true;
          } // if
        } // for
      } // if
    } // while

    if (!(movesCounter == AGGRESSION_COUNTER)) {
      (getOwningLevel().getLevelRooms().get(getPosition()[0] + directions[direction][0],
          getPosition()[1] + directions[direction][1])).addActor(this);
      System.out.println("DEBUG: Monster moved to " + getCurrentRoom().getRoomID());
    } // if
    if (getCurrentRoom() instanceof OfficeRoom) {
      App.runningApp.getUserInterface().getTerminal()
          .addConsoleOutput("YOUR OFFICE IS NO LONGER SAFE...");
    } // if
  } // advanceTurn

  // static void arrayShuffle(int[][] array) {
  // Random randomizer = new Random();
  // for (int i = array.length - 1; i > 0; i--) {
  // int index = randomizer.nextInt(i + 1);
  // int[] tmp = array[index];
  // array[index] = array[i];
  // array[i] = tmp;
  // }
  // } // arrayShuffle
} // Monster
