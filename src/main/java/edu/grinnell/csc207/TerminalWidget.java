package edu.grinnell.csc207;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import edu.grinnell.csc207.UserInterface.UIPanel;

public class TerminalWidget extends Widget {
  public TerminalWidget(UserInterface owningUserInterface) {
    super(owningUserInterface);
    setTitle("Terminal");
    // Setup basic terminal UI

    getContentPane().setForeground(new Color(64, 255, 128));
    getContentPane().setBackground(new Color(8, 32, 16));

    Box horizontalBox = Box.createHorizontalBox();
    horizontalBox.add(new Label(">:"));

    JTextField commandField = new JTextField(20);
    commandField.setForeground(new Color(64, 255, 128));
    commandField.setBackground(new Color(0, 0, 0));
    horizontalBox.add(commandField);

    JButton confirmButton = new JButton("Commit");
    confirmButton.setForeground(new Color(64, 255, 128));

    //Test button input, advance turn on commit pressed
    confirmButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            getUserInterface().owningApp.game.advanceTurn();
          }
      });
    confirmButton.setBackground(new Color(0, 0, 0));

    horizontalBox.add(confirmButton);

    add(horizontalBox);
    
    setSize(300,300);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
