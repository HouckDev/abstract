package edu.grinnell.csc207.actors;

import java.awt.Dimension;
import java.awt.Toolkit;
import edu.grinnell.csc207.App;
import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.rooms.OfficeRoom;
import edu.grinnell.csc207.rooms.Room;
import edu.grinnell.csc207.userInterface.DefaultStyle;
import edu.grinnell.csc207.userInterface.GameOverWidget;

/**
 * Monster Represents a monster actor Can be prevented by doors and detected by motion sensors.
 *
 * @author Mitch Paiva and Paden Houck
 */
public class Monster extends Actor {
  /**
   * The agression counter.
   */
  private int aggressionCounter = 8;

  /**
   * The moves counter.
   */
  private int moves = 1; // 'fix' for monster insta moving across the map bcz of level iterating

  /**
   * Creates a new conster.
   *
   * @param newLevel
   * @param cfgAggression
   */
  public Monster(Level newLevel, int cfgAggression) {
    super(newLevel);
    aggressionCounter = cfgAggression;
  } // monster

  /**
   * Creates a new monster.
   *
   * @param newLevel
   */
  public Monster(Level newLevel) {
    super(newLevel);
  } // monster

  /**
   * Get display text.
   */
  @Override
  public void getDisplayText() {
    App.runningApp.getUserInterface().getTerminal().addConsoleOutput("SYS$ERROR",
        DefaultStyle.getErrorTextColor());
  } // getDisplayText

  /**
   * Advance the monster's movement to a valid room without a closed door.
   *
   */
  @Override
  public void advanceTurn() {
    if (moves <= 0) {
      moves = 3;
      return;
    } // if
    moves--;
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

    while (isNotValid && (movesCounter < aggressionCounter)) {
      direction = (int) (Math.random() * directions.length);
      movesCounter += 1;
      if (!(getPosition()[0] + directions[direction][0] > 0
          && getPosition()[0] + directions[direction][0] < getOwningLevel().getLevelRooms().width()
          && getPosition()[1] + directions[direction][1] > 0 && getPosition()[1]
              + directions[direction][1] < getOwningLevel().getLevelRooms().height())) {
        continue;
      } // if
      Room currentDesiredRoom = getOwningLevel().getLevelRooms().get(
          getPosition()[0] + directions[direction][0], getPosition()[1] + directions[direction][1]);

      isNotValid = (currentDesiredRoom == null);

      if (!isNotValid) {
        for (Actor actor : currentDesiredRoom.getContents()) {
          if (actor instanceof Door) {
            if (((Door) actor).isClosed()) {
              isNotValid = true;
            } // if
          } // if
        } // for
      } // if
    } // while

    if (!(movesCounter == aggressionCounter)) {
      (getOwningLevel().getLevelRooms().get(getPosition()[0] + directions[direction][0],
          getPosition()[1] + directions[direction][1])).addActor(this);
      // System.out.println("DEBUG: Monster moved to " + getCurrentRoom().getRoomID());
    } // if
    if (getCurrentRoom() instanceof OfficeRoom) {
      App.runningApp.getUserInterface().getTerminal()
          .addConsoleOutput("YOUR OFFICE IS NO LONGER SAFE...");
      moves = 0;
    } // if
  } // advanceTurn

} // Monster
