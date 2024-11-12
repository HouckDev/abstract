package edu.grinnell.csc207.userInterface;

import java.awt.Color;

/**
 * Default style.
 * 
 * @author Mitch Paiva and Paden Houck
 */
public class DefaultStyle {
  private static final Color TEXT_COLOR = new Color(64, 255, 128);

  public static Color getTextColor() {
    return TEXT_COLOR;
  } // getTextColor

  private static final Color BACKGROUND_COLOR = new Color(8, 32, 16);

  public static Color getBackgroundColor() {
    return BACKGROUND_COLOR;
  } // getBackgroundColor

  private static final Color ERRORTEXT_COLOR = new Color(255, 32, 128);

  public static Color getErrorTextColor() {
    return ERRORTEXT_COLOR;
  } // getBackgroundColor

} // DefaultStyle
