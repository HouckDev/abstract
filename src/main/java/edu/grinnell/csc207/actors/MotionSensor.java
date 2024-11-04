package edu.grinnell.csc207.actors;

import edu.grinnell.csc207.Level;

/**
 * MotionSensor
 * Represents a motion sensor actor
 * If an actor moves through here during a turn, prompt the UI with a warning
 */
public class MotionSensor extends Actor{

  // create a new motionsensor
  public MotionSensor(Level newLevel) {
    super(newLevel);
  }
}
