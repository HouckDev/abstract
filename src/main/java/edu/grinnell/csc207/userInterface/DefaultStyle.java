package edu.grinnell.csc207.userInterface;

import java.awt.Color;

public class DefaultStyle {
  private static Color textColor = new Color(64, 255, 128);
  public static Color getTextColor() {
    return textColor;
  }
  private static Color backgroundColor = new Color(8, 32, 16);
  public static Color getBackgroundColor() {
    return backgroundColor;
  }
} // DefaultStyle
