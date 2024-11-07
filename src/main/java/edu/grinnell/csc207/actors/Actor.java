package edu.grinnell.csc207.actors;

import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.TurnInterface;

/**
 * Actor Base class for an 'actor', an object that has a 
 * tangible prescense in the game level.
 */
public class Actor implements TurnInterface {

  /**
   * The level that this actor is in.
   */
  private Level owningLevel;

  /**
   * @return the owning level
   */
  public Level getOwningLevel() {
    return owningLevel;
  } // getOwningLevle

  /**
   * Constructs a new actor within a level.
   * 
   * @param newlevel
   */
  public Actor(Level newlevel) {
    this.owningLevel = newlevel;
  } // Actor

  @Override
  public void advanceTurn() {} // advanceTurn
} // Actor
