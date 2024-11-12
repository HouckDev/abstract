package edu.grinnell.csc207.actors;

import edu.grinnell.csc207.App;
import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.userInterface.AlertPopupWidget;
import java.awt.Dimension;
import java.awt.Toolkit;
import edu.grinnell.csc207.App;

/**
 * MotionSensor Represents a motion sensor actor If an actor moves through here during a turn,
 * prompt the UI with a warning
 */
public class MotionSensor extends Actor {
  // keeps track of the previous amount of items in each room
  int previousCount = 0;


  // create a new motionsensor
  public MotionSensor(Level newLevel) {
    super(newLevel);
  } // MotionSensor

  @Override
  public void getDisplayText() {
    App.runningApp.getUserInterface().getTerminal().addConsoleOutput("SENSOR");
  } // getDisplayText

  /**
   * If a motion sensor is triggered, send an alert to the user.
   * 
   */
  @Override
  public void advanceTurn() {

    if (previousCount != getCurrentRoom().getContents().size()) {
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      double width = screenSize.getWidth();
      double height = screenSize.getHeight();
      AlertPopupWidget testPopup = new AlertPopupWidget(App.runningApp.getUserInterface(),
          "Motion In Room " + getCurrentRoom().getRoomID());
      testPopup.setLocation(((int) width / 2) - (testPopup.getWidth() / 2),
          ((int) height / 2) - (testPopup.getHeight() / 2));
      previousCount = getCurrentRoom().getContents().size();
    } // if statement
  } // advanceTurn
} // MotionSensor
