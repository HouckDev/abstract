package edu.grinnell.csc207.rooms;

import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JComponent;
import edu.grinnell.csc207.App;
import edu.grinnell.csc207.CommandInterface;
import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.TurnInterface;
import edu.grinnell.csc207.actors.Actor;
import edu.grinnell.csc207.actors.MotionSensor;
import edu.grinnell.csc207.userInterface.DefaultStyle;
import edu.grinnell.csc207.userInterface.TerminalLabel;

/**
 * Room Represents a room, contains a list of actors reprsenting the contents.
 */
public class Room implements TurnInterface, CommandInterface {
  private ArrayList<Actor> contents = new ArrayList<Actor>();
  Level owningLevel;
  String roomID = String.valueOf((int) (Math.random()*10)) + String.valueOf((int) (Math.random()*10)) + String.valueOf((int) (Math.random()*10));
  public String getRoomID() {
    return roomID;
  } // Room class

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
    roomWidget.add(new TerminalLabel("|" + this.getRoomID() +"|"));
    roomWidget.add(new TerminalLabel("|   |"));
    roomWidget.add(new TerminalLabel("|   |"));
    roomWidget.add(new TerminalLabel("+---+"));

    return roomWidget;
  } // constructMapWidget

  @Override
  public void advanceTurn() {
    ArrayList<Actor> temp = getContents();
    for (int i = 0 ; i < temp.size(); i++) {
      Actor actor = temp.get(i);
      actor.advanceTurn();
    } // for
  } // advanceTurn

  @Override
  public String parseCommand(String command) {
    if (command.isBlank()) {
      App.runningApp.getUserInterface().getTerminal().addConsoleOutput("ROOM CONTENTS:");
      for (int i = 0; i < this.contents.size(); i++) {
        Actor actor = this.contents.get(i);
        App.runningApp.getUserInterface().getTerminal().addConsoleOutput(i + ":");
        if (Math.random() > 0.8) {
          App.runningApp.getUserInterface().getTerminal().addConsoleOutput("SYS$ERROR",DefaultStyle.getErrorTextColor());
        } else {
          actor.getDisplayText();
        } // if else
      } // for
      return "";
    }
    String[] commandList = command.split(" ",2);
    if (commandList[0].equals("MOTION")) {
      addActor(new MotionSensor(owningLevel));
      return "Motion Sensor Added To Room " + this.getRoomID();
    } // if
    try {
      int value = Integer.parseInt(commandList[0]);
      if (value >= 0 && value < getContents().size()) {
        return getContents().get(value).parseCommand(commandList[1]);
      } // if
      
    } catch (Exception e) {
    } // catch
    return "ERROR: INVALID OBJECT";
  } // parseCommand

} // Room
