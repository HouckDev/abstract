package edu.grinnell.csc207.actors;

import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.TurnInterface;

/**
 * Actor
 * Base class for an 'actor', an object that has a tangible prescense in the game level
 */
public class Actor implements TurnInterface {

  // The level that this actor is in
  Level owningLevel;

  public Actor(Level newlevel) {
    this.owningLevel = newlevel;
  }

  @Override
  public void advanceTurn() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'advanceTurn'");
  }
}
