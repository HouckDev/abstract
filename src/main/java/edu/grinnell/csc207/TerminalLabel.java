package edu.grinnell.csc207;

import java.awt.Font;
import java.awt.Label;

public class TerminalLabel extends Label {
  public TerminalLabel(String text) {
    super(text);
    setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
  }
}
