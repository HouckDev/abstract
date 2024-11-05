package edu.grinnell.csc207;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class UserInterface {
  App owningApp;
  UIPanel mainPanel;
  public UserInterface(App newOwningApp) {
    this.owningApp = newOwningApp;
    
    JFrame frame = new JFrame("AbstractGame");
    frame.getContentPane().setLayout(new BorderLayout());
    mainPanel = new UIPanel();
    frame.getContentPane().add(mainPanel);
    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setSize(300,300);
    //frame.setUndecorated(true);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  } // UserInterface(App)

  public class UIPanel extends JPanel {
    public UIPanel() {
      Box horizontalBox = Box.createHorizontalBox();
      horizontalBox.add(new Label(">:"));
      horizontalBox.add(new JTextField(20));

      add(horizontalBox);
    }
  }
} // UserInterface

