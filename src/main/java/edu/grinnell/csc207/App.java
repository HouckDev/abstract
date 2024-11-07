package edu.grinnell.csc207;

import edu.grinnell.csc207.userInterface.UserInterface;

/**
 * App
 * Represents the game app, manages the game object
 */
public class App {

    // The object representing the user interface
    UserInterface userInterface;

    // The object representing the game
    Game game;

    public Game getCurrentGame() {
        return this.game;
    } // getCurrentGame

    // Launch the app
    public static void main(String[] args) {
        App app = new App();
    } // main

    // Initialize the app
    public App() {
        
        this.game = new Game();
        this.userInterface = new UserInterface(this);
        //this.game = null;
    } // App
} // App