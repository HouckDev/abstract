package edu.grinnell.csc207;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import edu.grinnell.csc207.actors.Door;
import edu.grinnell.csc207.actors.Monster;
import edu.grinnell.csc207.rooms.OfficeRoom;
import edu.grinnell.csc207.rooms.Room;
import edu.grinnell.csc207.userInterface.MapWidget;

/**
 * Game Holds and updates the game state, contains the parameters for difficulty, etc. Basic game
 * premise: player is stuck in a control room, a monster is hunting for them, they can use a console
 * to influence the level around them to keep it away player inputs actions every turn via a console
 * input game ends if the monster enters the same room as the player
 */
public class Game implements TurnInterface, CommandInterface {
  int playerActions = 5;
  private String gameState = "CONFIG";
  private int CONFIG_MONSTER_AGGRESSION = 8;
  private int CONFIG_LEVEL_SIZE = 7;
  private int CONFIG_LEVEL_ROOMS = 16;

  public void setPlayerActions(int playerActions) {
    this.playerActions = playerActions;
  }

  public String getGameState() {
    return gameState;

  }

  public void setGameState(String gameState) {
    this.gameState = gameState;

  }

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
    // generate the level
    level.generate(CONFIG_LEVEL_ROOMS, CONFIG_LEVEL_SIZE);
    App.runningApp.getUserInterface().getTerminal()
        .addConsoleOutput("ACTIONS LEFT: " + playerActions);

    // Spawn the monster
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
        } // if
      } // for
    } // for
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

    tempRooms.get((int) (Math.random() * tempRooms.size()))
        .addActor(new Monster(this.getCurrentLevel(), this.CONFIG_MONSTER_AGGRESSION));

    // Add the map widget
    // Get screen dimensions
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    MapWidget mapWidget = new MapWidget(App.runningApp.getUserInterface());
    mapWidget.setLocation(((int) width / (2 * 2)) - (mapWidget.getWidth() / 2),
        ((int) height / 2) - (mapWidget.getHeight() / 2));
  } // beginGame

  /**
   * Parse a command action from the terminal.
   * 
   * @param command
   */
  public String parseCommand(String command) {
    String[] commandList = command.split(" ", 3);
    switch (getGameState()) {
      case "CONFIG":
        switch (commandList[0]) {
          case "START":
            gameState = "PLAY";
            beginGame();
            App.runningApp.getUserInterface().getTerminal().addConsoleOutput("YOU ARE THE '@");
            App.runningApp.getUserInterface().getTerminal().addConsoleOutput("YOUR OFFICE IS SAFE");
            App.runningApp.getUserInterface().getTerminal()
                .addConsoleOutput("SURVIVE FOR AS LONG AS POSSIBLE");
            return "";
          case "CONFIG":
            switch (commandList[1]) {
              case "M_AGGRESSION":
                int value = 8;
                try {
                  value = Integer.valueOf(commandList[2]);
                  CONFIG_MONSTER_AGGRESSION = value;
                  return "SET MONSTER AGGRESSION TO " + CONFIG_MONSTER_AGGRESSION;

                } catch (Exception e) {
                  return "SETTING MUST BE AN INT";
                }
              case "L_SIZE":
                int value2 = 9;
                try {
                  value2 = Integer.valueOf(commandList[2]);
                  if (value2 % 2 == 0 && value2 > 3) {
                    throw new Exception();
                  }
                  CONFIG_LEVEL_SIZE = value2;
                  return "SET LEVEL SIZE TO " + CONFIG_LEVEL_SIZE;

                } catch (Exception e) {
                  return "SETTING MUST BE AN ODD INT > 3";
                }
              case "L_ROOMS":
                int value3 = 32;
                try {
                  value3 = Integer.valueOf(commandList[2]);
                  CONFIG_LEVEL_ROOMS = value3;
                  return "SET LEVEL ROOMS TO " + CONFIG_LEVEL_ROOMS;

                } catch (Exception e) {
                  return "SETTING MUST BE AN ODD INT";
                }
              default:
                return "INVALID CONFIG SETTING";
            }
          case "HELP":
            App.runningApp.getUserInterface().getTerminal()
                .addConsoleOutput("START - Start the game");
            App.runningApp.getUserInterface().getTerminal()
                .addConsoleOutput("CONFIG [SETTING] - Set a config option");
            App.runningApp.getUserInterface().getTerminal().addConsoleOutput("- M_AGGRESSION - ["
                + CONFIG_MONSTER_AGGRESSION + "] The aggression of the monster");
            App.runningApp.getUserInterface().getTerminal().addConsoleOutput(
                "- L_SIZE - [" + CONFIG_LEVEL_SIZE + "] The dimensions of the level");
            App.runningApp.getUserInterface().getTerminal().addConsoleOutput(
                "- L_ROOMS - [" + CONFIG_LEVEL_ROOMS + "] The potential max count of rooms");
            return "";
          default:
            break;
        }
        return "INVALID COMMAND";
      case "PLAY":
        if (command.equals("HELP")) {
          App.runningApp.getUserInterface().getTerminal()
              .addConsoleOutput("[ROOM #] - Inspect a room, list the objects");
          App.runningApp.getUserInterface().getTerminal()
              .addConsoleOutput("[ROOM #] MOTION - Add a motion sensor to a room");
          App.runningApp.getUserInterface().getTerminal()
              .addConsoleOutput("[ROOM #] [Object #] - Inspect an object");
          App.runningApp.getUserInterface().getTerminal()
              .addConsoleOutput("[ROOM #] [Object #] CLOSE - Lock a door for a few turns");

        }
        String nextCommand = "";
        if (commandList.length > 1) {
          nextCommand = commandList[1];
        }
        for (int y = 0; y < getCurrentLevel().getLevelRooms().height(); y++) {
          for (int x = 0; x < getCurrentLevel().getLevelRooms().height(); x++) {
            if (getCurrentLevel().getLevelRooms().get(y, x) != null
                && getCurrentLevel().getLevelRooms().get(y, x).getRoomID().equals(commandList[0])) {
              return getCurrentLevel().getLevelRooms().get(y, x).parseCommand(nextCommand);
            } // if
          } // if
        } // for
        return "ERROR: INVALID ROOM";
      default:
        break;
    }
    return "ERROR: INVALID GAME STATE";
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
