package edu.grinnell.csc207.userInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

public class TerminalLabel extends Label {
  public TerminalLabel(String text) {
    
    super(text);

    Font terminalFont = new Font(Font.MONOSPACED, Font.PLAIN, 12);
    setFont(terminalFont);
    setForeground(new Color(64, 255, 128));
  }
}
