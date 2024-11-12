package edu.grinnell.csc207.rooms;

import javax.swing.Box;
import javax.swing.JComponent;
import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.userInterface.TerminalLabel;
import edu.grinnell.csc207.actors.Door;

/**
 * A room type that represents a hallway with a door.
 *
 * @author Mitch Paiva and Paden Houck
 */
public class Hallway extends Room {
  public Hallway(Level newLevel) {
    super(newLevel);
    addActor(new Door(newLevel));
  } // Hallway

  @Override
  public JComponent constructMapWidget() {
    Box roomWidget = Box.createVerticalBox();

    roomWidget.add(new TerminalLabel("     "));
    roomWidget.add(new TerminalLabel("     "));
    roomWidget.add(new TerminalLabel("-" + this.getRoomID() + "-"));
    roomWidget.add(new TerminalLabel("     "));
    roomWidget.add(new TerminalLabel("     "));

    return roomWidget;
  } // constructMapWidget
} // Hallway
