package edu.grinnell.csc207.actors;

import edu.grinnell.csc207.Level;

/**
 * Door
 * Represents a door actor
 * Can be shut to prevent movement of actors
 */
public class Door extends Actor{

  // create a new door
  public Door(Level newLevel) {
    super(newLevel);
  }
}
