package edu.grinnell.csc207;


/**
 * The turn interface.
 *
 * @author Mitch Paiva and Paden Houck
 */
public interface TurnInterface {
  /**
   * Advance the game state. Should propogate to subobjects so the entire game state's turn
   * advances.
   */
  void advanceTurn(); // advanceTurn
} // TurnInterface
