package edu.grinnell.csc207.userInterface;

import javax.swing.JFrame;

/**
 * A freestanding frame 'widget' that can interact with the
 * gamestate through the owning UI.
 */
public class Widget extends JFrame {
  /**
   * The user interface that owns this widget.
   */
  protected UserInterface userInterface;

  /**
   * @return this objects owning ui.
   */
  public UserInterface getUserInterface() {
    return userInterface;
  }

  /**
   * Construct a widget with a parent UI.
   * @param owningUserInterface
   */
  public Widget(final UserInterface owningUserInterface) {
    this.userInterface = owningUserInterface;
  }
}
