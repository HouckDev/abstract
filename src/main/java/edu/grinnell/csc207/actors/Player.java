package edu.grinnell.csc207.actors;

import edu.grinnell.csc207.App;
import edu.grinnell.csc207.Level;

public class Player extends Actor {
  // create a new Player
  public Player(Level newLevel) {
    super(newLevel);
  } // player

  @Override
  public void getDisplayText() {
    App.runningApp.getUserInterface().getTerminal().addConsoleOutput("Human [You]");
  }
} // Player


