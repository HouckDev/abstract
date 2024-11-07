package edu.grinnell.csc207.userInterface;

import java.awt.Dimension;
import java.awt.Toolkit;
import edu.grinnell.csc207.App;

public class UserInterface {
  /**
   * the application this UI is connected to.
   */
  private TerminalWidget terminal;

  /**
   * @return the terminal widget
   */
  public TerminalWidget getTerminal() {
    return terminal;
  } // getTerminal

  private App owningApp;

  /**
   * @return owning application
   */
  public App getOwningApp() {
    return owningApp;
  } // getOwningApp

  /**
   * Constructs a new UserInterface.
   * @param newOwningApp
   */
  public UserInterface(final App newOwningApp) {
    this.owningApp = newOwningApp;

    // Get screen dimensions
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();

    // Add initial widgets

    terminal = new TerminalWidget(this);
    terminal.setLocation(((int) width / 2) - (terminal.getWidth() / 2),
        ((int) height / 2) - (terminal.getHeight() / 2));

    AlertPopupWidget testPopup = new AlertPopupWidget(this);
    testPopup.setLocation(((int) width / 2) - (testPopup.getWidth() / 2),
        ((int) height / 2) - (testPopup.getHeight() / 2));
    MapWidget mapWidget = new MapWidget(this);
    mapWidget.setLocation(((int) width / (2 * 2)) - (mapWidget.getWidth() / 2),
        ((int) height / 2) - (mapWidget.getHeight() / 2));
  } // UserInterface(App)
} // UserInterface

