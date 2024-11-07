package edu.grinnell.csc207.rooms;

import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JComponent;
import edu.grinnell.csc207.CommandInterface;
import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.TurnInterface;
import edu.grinnell.csc207.actors.Actor;
import edu.grinnell.csc207.matrix.Matrix;
import edu.grinnell.csc207.userInterface.TerminalLabel;

/**
 * Room Represents a room, contains a list of actors reprsenting the contents.
 */
public class Room implements TurnInterface, CommandInterface {
  private ArrayList<Actor> contents = new ArrayList<Actor>();
  Level owningLevel;
  /**
   * @return the contents of this room
   */
  public ArrayList<Actor> getContents() {
    return contents;
  } // getContents

  /**
   * Add an actor to this room, move it from the previous room
   * @param newActor
   */
  public void addActor(Actor newActor) {
    if (newActor.getCurrentRoom() != null) {
      newActor.getCurrentRoom().removeActor(newActor);
    } // if
    newActor.setCurrentRoom(this);
    getContents().add(newActor);
  } // addActor

  /**
   * @param newActor the actor to remove
   */
  public void removeActor(Actor newActor) {
    newActor.setCurrentRoom(null);
    getContents().remove(newActor);
  } // removeActor

  /**
   * Construct a new room
   * @param newOwningLevel
   */
  public Room(Level newOwningLevel) {
    this.owningLevel = newOwningLevel;
  } // Room

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

  @Override
  public boolean parseCommand(String command) {
    String[] commandList = command.split(" ",2);
    int value = Integer.parseInt(commandList[0]);
    if (value > 0 && value < getContents().size()) {
      return getContents().get(value).parseCommand(commandList[1]);
    }
    return false;
  }
} // Room
