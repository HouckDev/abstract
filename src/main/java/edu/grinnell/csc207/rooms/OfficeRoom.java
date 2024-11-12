package edu.grinnell.csc207.rooms;

import javax.swing.Box;
import javax.swing.JComponent;
import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.actors.Player;
import edu.grinnell.csc207.userInterface.TerminalLabel;

/**
 * A room type that represents the room with the player and a door.
 *
 * @author Mitch Paiva and Paden Houck
 */
public class OfficeRoom extends Room {
  public OfficeRoom(Level newLevel) {
    super(newLevel);
    addActor(new Player(newLevel));
  } // OfficeRoom

  @Override
  public JComponent constructMapWidget() {
    Box roomWidget = Box.createVerticalBox();

    roomWidget.add(new TerminalLabel("+---+"));
    roomWidget.add(new TerminalLabel("|" + this.getRoomID() + "|"));
    roomWidget.add(new TerminalLabel("| @ |"));
    roomWidget.add(new TerminalLabel("|   |"));
    roomWidget.add(new TerminalLabel("+---+"));


    return roomWidget;
  } // constructMapWidget

} // OfficeRoom
