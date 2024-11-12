/*
 * This package contains classes and interfaces
 * for the game's operation and central logic.
 */
package edu.grinnell.csc207;

/**
   * The main command interface.
   */
public interface CommandInterface {
  /**
   * Parse a command from the terminal.
   *
   * @param command a user inputted command
   * @return string to feed to the game logic
   */
  String parseCommand(String command); // advanceTurn
} // CommandInterface
