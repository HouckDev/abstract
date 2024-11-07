package edu.grinnell.csc207.rooms;

import javax.swing.Box;
import javax.swing.JComponent;
import edu.grinnell.csc207.userInterface.TerminalLabel;

public class OfficeRoom extends Room {
  public OfficeRoom() {
    super();

  }
  @Override
  public JComponent constructMapWidget() {
    Box roomWidget = Box.createVerticalBox();

    roomWidget.add(new TerminalLabel("+---+"));
    roomWidget.add(new TerminalLabel("|   |"));
    roomWidget.add(new TerminalLabel("| @ |"));
    roomWidget.add(new TerminalLabel("|   |"));
    roomWidget.add(new TerminalLabel("+---+"));


    return roomWidget;
  } // constructMapWidget
  
} // OfficeRoom
