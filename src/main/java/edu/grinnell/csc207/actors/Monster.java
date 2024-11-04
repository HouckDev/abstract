package edu.grinnell.csc207.actors;

import edu.grinnell.csc207.Level;

/**
 * Monster
 * Represents the 'monster'
 * Moves until it enters the player's room, triggers a game over if the turn ends while it is in the room
 */
public class Monster extends Actor{

  // create a new monster
  public Monster(Level newLevel) {
    super(newLevel);
  }
}
