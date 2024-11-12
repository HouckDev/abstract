package edu.grinnell.csc207.userInterface;

import java.awt.Color;

/**
 * Default style.
 *
 * @author Mitch Paiva and Paden Houck
 */
public class DefaultStyle {

  /**
   * Color for default style.
   *
   */
  private static final Color TEXT_COLOR = new Color(64, 255, 128);

  /**
   * Color for default style.
   *
   * @return TEXT_COLOR the text color.
   */
  public static Color getTextColor() {
    return TEXT_COLOR;
  } // getTextColor

  /**
   * Color for default style.
   */
  private static final Color BACKGROUND_COLOR = new Color(8, 32, 16);

  /**
   * Color for default style.
   *
   * @return BACKGROUND_COLOR
   */
  public static Color getBackgroundColor() {
    return BACKGROUND_COLOR;
  } // getBackgroundColor

  /**
   * Color for default style.
   */
  private static final Color ERRORTEXT_COLOR = new Color(255, 32, 128);

  /**
   * Color for default style.
   *
   * @return ERRORTEXT_COLOR
   */
  public static Color getErrorTextColor() {
    return ERRORTEXT_COLOR;
  } // getBackgroundColor

} // DefaultStyle
