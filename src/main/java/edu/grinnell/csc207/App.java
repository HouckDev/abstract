package edu.grinnell.csc207;

import edu.grinnell.csc207.userInterface.UserInterface;

/**
 * App Represents the game app, manages the game object.
 *
 * @author Mitch Paiva and Paden Houck
 */
public class App {

    /**
     * The running app.
     */
  public static App runningApp;

    /**
     * The userInterface that is active.
     */
  private UserInterface userInterface;

    /**
     * @return the active user interface
     */
  public UserInterface getUserInterface() {
    return userInterface;
  } // getUserInterface

    /**
     * The current game the app is running.
     */
  private Game game;

    /**
     * @return the current game
     */
  public Game getCurrentGame() {
    return this.game;
  } // getCurrentGame

     /**
     * The main class.
     * @param args
     */
  public static void main(String[] args) {
    App.runningApp = new App();
  } // main

    /**
     * Initialize the app.
     */
  public App() {
    this.game = new Game();
    this.userInterface = new UserInterface(this);
    // this.game = null;
  } // App
} // App
