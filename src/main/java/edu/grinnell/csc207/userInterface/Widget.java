package edu.grinnell.csc207.userInterface;

import javax.swing.JFrame;

public class Widget extends JFrame{
  UserInterface userInterface;
  public UserInterface getUserInterface() {
    return userInterface;
  }
  
  public Widget(UserInterface owningUserInterface) {
    this.userInterface = owningUserInterface;
  }
}
