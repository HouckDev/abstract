package edu.grinnell.csc207.rooms;

import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JComponent;
import edu.grinnell.csc207.actors.Actor;
import edu.grinnell.csc207.userInterface.TerminalLabel;

/**
 * Room
 * Represents a room, contains a list of actors reprsenting the contents
 */
public class Room {
  ArrayList<Actor> contents = new ArrayList<Actor>();

  /**
   * constructMapWidget
   * Constructs a new Widget to represent this room in the map
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
} // Room
