package edu.grinnell.csc207;

/**
 * App
 * Represents the game app, manages the game object
 */
public class App {

    // Launch the app
    public static void main(String[] args) {
        App app = new App();
    }// main

    // The object representing the game
    Game game;

    // The object representing the user interface
    UserInterface userInterface; 


    // Initialize the app
    public App() {
        this.userInterface = new UserInterface(this);
        this.game = null;
    } // App
} // App