package edu.grinnell.csc207;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
  App owningApp;
  UIPanel mainPanel;
  public UserInterface(App newOwningApp) {
    this.owningApp = newOwningApp;
    
    //Get screen dimensions
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();

    JFrame frame = new JFrame("AbstractGame");
    frame.getContentPane().setLayout(new BorderLayout());
    mainPanel = new UIPanel();
    frame.getContentPane().add(mainPanel);
    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setSize(300,300);
    //frame.setUndecorated(true);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Add initial widgets
    AlertPopupWidget testPopup = new AlertPopupWidget();
    testPopup.setLocation(((int) width / 2) - (testPopup.getWidth() / 2), ((int) height / 2) - (testPopup.getHeight() / 2));
    
  } // UserInterface(App)

  public class UIPanel extends JPanel {
    public UIPanel() {
      // Setup basic terminal UI
      Box horizontalBox = Box.createHorizontalBox();
      horizontalBox.add(new Label(">:"));

      JTextField commandField = new JTextField(20);
      commandField.setBackground(new Color(0, 0, 0));
      horizontalBox.add(commandField);

      JButton confirmButton = new JButton("Commit");

      //Test button input, advance turn on commit pressed
      confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              owningApp.game.advanceTurn();
            }
        });
      confirmButton.setBackground(new Color(0, 0, 0));

      horizontalBox.add(confirmButton);

      add(horizontalBox);
      setForeground(new Color(64, 255, 128));
      setBackground(new Color(8, 32, 16));
    } //UIPanel
  } // UIPanel
} // UserInterface

