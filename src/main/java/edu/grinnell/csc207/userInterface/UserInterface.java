package edu.grinnell.csc207.userInterface;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import edu.grinnell.csc207.App;
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
    
    // Add initial widgets

    TerminalWidget terminal = new TerminalWidget(this);
    terminal.setLocation(((int) width / 2) - (terminal.getWidth() / 2), ((int) height / 2) - (terminal.getHeight() / 2));

    AlertPopupWidget testPopup = new AlertPopupWidget(this);
    testPopup.setLocation(((int) width / 2) - (testPopup.getWidth() / 2), ((int) height / 2) - (testPopup.getHeight() / 2));
    MapWidget mapWidget = new MapWidget(this);
    mapWidget.setLocation(((int) width / 4) - (mapWidget.getWidth() / 2), ((int) height / 2) - (mapWidget.getHeight() / 2));
    
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
              owningApp.getCurrentGame().advanceTurn();
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

