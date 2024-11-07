package edu.grinnell.csc207;

/**
 * Game
 * Holds and updates the game state, contains the parameters for difficulty, etc.
 * Basic game premise:
 * player is stuck in a control room, a monster is hunting for them, they can use a console to influence the level around them to keep it away
 * player inputs actions every turn via a console input
 * game ends if the monster enters the same room as the player
 */
public class Game implements TurnInterface {

  // The object represeting the game level
  Level level;

  public Level getCurrentLevel() {
    return level;
  }

  /**
   * Start a new game with default parameters
   */
  public Game() {

  } // Game

  @Override
  public void advanceTurn() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'advanceTurn'");
  }
} // Game
