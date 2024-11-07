package edu.grinnell.csc207.rooms;

import java.util.ArrayList;
import javax.swing.JPanel;
import edu.grinnell.csc207.actors.Actor;

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
  public JPanel constructMapWidget() {
      return null;
  } // constructMapWidget
} // Room
