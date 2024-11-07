package edu.grinnell.csc207.actors.junk;

import edu.grinnell.csc207.App;
import edu.grinnell.csc207.Level;

public class TVStack extends Junk{
  /**
   * Create a new junk actor
   * 
   * @param newLevel
   */
  public TVStack(Level newLevel) {
    super(newLevel);
  } // TVStack
  
  @Override
  public void getDisplayText() {
    App.runningApp.getUserInterface().getTerminal().addConsoleOutput("Stack of cracked TV's");
  }
  
}
