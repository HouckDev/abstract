package edu.grinnell.csc207.userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import javax.swing.Box;

public class GameOverWidget extends Widget {
  /**
   * Constructs a new alert Popup.
   * @param owningUserInterface
   */
  public GameOverWidget(final UserInterface owningUserInterface) {
    super(owningUserInterface);
    setTitle("Game Over");
    getContentPane().setLayout(new BorderLayout());
    // mainPanel = new UIPanel();
    // getContentPane().add(mainPanel);
    // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    
    Box vertbox = Box.createVerticalBox();

    Label alertLabel = new Label("YOUR ARE DEAD");
    Font alertFont = new Font(Font.MONOSPACED, Font.PLAIN, 24);
    alertLabel.setFont(alertFont);
    alertLabel.setForeground(new Color(255, 255, 255));
    vertbox.add(alertLabel);
    
    Label alertTextLabel = new Label("The Monster Entered The Office");
    Font alertTextFont = new Font(Font.MONOSPACED, Font.PLAIN, 12);
    alertTextLabel.setFont(alertTextFont);
    alertTextLabel.setForeground(new Color(255, 255, 255));
    vertbox.add(alertTextLabel);
    add(vertbox);
    setSize(300, 200);
    // frame.setUndecorated(true);
    getContentPane().setBackground(Color.RED);
    setVisible(true);
  } // AlertPopupWidget
} // AlertPopupWidget
