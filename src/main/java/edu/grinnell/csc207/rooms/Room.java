package edu.grinnell.csc207.rooms;

import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JComponent;
import edu.grinnell.csc207.TurnInterface;
import edu.grinnell.csc207.actors.Actor;
import edu.grinnell.csc207.matrix.Matrix;
import edu.grinnell.csc207.userInterface.TerminalLabel;

/**
 * Room Represents a room, contains a list of actors reprsenting the contents.
 */
public class Room implements TurnInterface {
  private ArrayList<Actor> contents = new ArrayList<Actor>();

  /**
   * @return the contents of this room
   */
  public ArrayList<Actor> getContents() {
    return contents;
  } // getContents

  

  /**
   * constructMapWidget Constructs a new Widget to represent this room in the map.
   * 
   * @return the widget to represent this room
   */
  public JComponent constructMapWidget() {
    Box roomWidget = Box.createVerticalBox();

    roomWidget.add(new TerminalLabel("+---+"));
    roomWidget.add(new TerminalLabel("|   |"));
    roomWidget.add(new TerminalLabel("|   |"));
    roomWidget.add(new TerminalLabel("|   |"));
    roomWidget.add(new TerminalLabel("+---+"));

    return roomWidget;
  } // constructMapWidget

  @Override
  public void advanceTurn() {
    for (Actor actor : this.contents) {
      actor.advanceTurn();
    } // for
  } // advanceTurn
} // Room
