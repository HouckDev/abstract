package edu.grinnell.csc207.userInterface;

import java.awt.Font;
import java.awt.Label;

/**
 * A custom label with retro console styling.
 *
 * @author Paden Houck
 */
public class TerminalLabel extends Label {
  /**
   * Constructs a new TerminalLabel.
   * 
   * @param text
   */
  public TerminalLabel(final String text) {
    super(text);

    Font terminalFont = new Font(Font.MONOSPACED, Font.PLAIN, 12);
    setFont(terminalFont);
    setForeground(DefaultStyle.getTextColor());
  } // TerminalLabel
} // TerminalLabel
