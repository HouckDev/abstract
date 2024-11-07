package edu.grinnell.csc207;

import java.util.ArrayList;
import edu.grinnell.csc207.actors.Door;
import edu.grinnell.csc207.actors.Monster;
import edu.grinnell.csc207.rooms.OfficeRoom;
import edu.grinnell.csc207.rooms.Room;

/**
 * Game Holds and updates the game state, contains the parameters for difficulty, etc. Basic game
 * premise: player is stuck in a control room, a monster is hunting for them, they can use a console
 * to influence the level around them to keep it away player inputs actions every turn via a console
 * input game ends if the monster enters the same room as the player
 */
public class Game implements TurnInterface, CommandInterface {
  int playerActions = 3;

  public int getPlayerActions() {
    return playerActions;
  } // getPlayerActions

  /**
   * The level the game is running.
   */
  Level level;

  /**
   * @return the current level
   */
  public Level getCurrentLevel() {
    return level;
  } // getCurrentLevel

  /**
   * Start a new game with default parameters.
   */
  public Game() {
    this.level = new Level();
  } // Game

  /**
   * Begins the game by allowing the player three moves and then spawns the monster.
   */
  public void beginGame() {
    App.runningApp.getUserInterface().getTerminal()
        .addConsoleOutput("ACTIONS LEFT: " + playerActions);
    int tmpOfficeX = 0;
    int tmpOfficeY = 0;
    int distanceX = 0;
    int distanceY = 0;
    ArrayList<Room> tempRooms = new ArrayList<Room>();
    for (int y = 0; y < getCurrentLevel().getLevelRooms().height(); y++) {
      for (int x = 0; x < getCurrentLevel().getLevelRooms().height(); x++) {
        if (getCurrentLevel().getLevelRooms().get(y, x) instanceof OfficeRoom) {
          tmpOfficeX = x;
          tmpOfficeY = y;
        }
      }
    }
    for (int y = 0; y < getCurrentLevel().getLevelRooms().height(); y++) {
      for (int x = 0; x < getCurrentLevel().getLevelRooms().height(); x++) {
        if (getCurrentLevel().getLevelRooms().get(y, x) != null) {
          distanceX = Math.abs(x - tmpOfficeX);
          distanceY = Math.abs(y - tmpOfficeY);

          if ((distanceX >= 2) && (distanceY >= 2)) {
            tempRooms.add(getCurrentLevel().getLevelRooms().get(y, x));
          } // if
        } // if
      } // for
    } // for

    tempRooms.get((int) (Math.random() * tempRooms.size())).addActor(new Monster(this.getCurrentLevel()));
  } // beginGame

  /**
   * Parse a command action from the terminal.
   * 
   * @param command
   */
  public String parseCommand(String command) {
    String[] commandList = command.split(" ", 2);
    String nextCommand = "";
    if (commandList.length > 1) {
      nextCommand = commandList[1];
    }
    for (int y = 0; y < getCurrentLevel().getLevelRooms().height(); y++) {
      for (int x = 0; x < getCurrentLevel().getLevelRooms().height(); x++) {
        if (getCurrentLevel().getLevelRooms().get(y, x) != null
            && getCurrentLevel().getLevelRooms().get(y, x).getRoomID().equals(commandList[0])) {
          return getCurrentLevel().getLevelRooms().get(y, x).parseCommand(nextCommand);
        }
      }
    }
    playerActions--;
    App.runningApp.getUserInterface().getTerminal()
        .addConsoleOutput("ACTIONS LEFT: " + playerActions);
    return "ERROR";
  } // recieveCommandPrompt

  @Override
  public void advanceTurn() {
    playerActions = 3;
    App.runningApp.getUserInterface().getTerminal()
        .addConsoleOutput("+" + playerActions + " ACTIONS");
    level.advanceTurn();
    App.runningApp.getUserInterface().getTerminal().addConsoleOutput("The Creature Moves...");
  } // advanceTurn
} // Game
