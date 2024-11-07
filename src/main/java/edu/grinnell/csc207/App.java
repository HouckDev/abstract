package edu.grinnell.csc207;

import edu.grinnell.csc207.userInterface.UserInterface;

/**
 * App
 * Represents the game app, manages the game object
 */
public class App {

    // Launch the app
    public static void main(String[] args) {
        App app = new App();
    } // main

    // The object representing the game
    Game game;

    public Game getCurrentGame() {
        return game;
    } // getCurrentGame

    // The object representing the user interface
    UserInterface userInterface; 


    // Initialize the app
    public App() {
        this.userInterface = new UserInterface(this);
        this.game = null;
    } // App
} // App