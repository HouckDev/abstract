package edu.grinnell.csc207;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import edu.grinnell.csc207.UserInterface.UIPanel;

public class MapWidget extends Widget {
  public MapWidget(UserInterface owningUserInterface) {
    super(owningUserInterface);
    setTitle("Map");
    // Setup basic terminal UI

    getContentPane().setForeground(new Color(64, 255, 128));
    getContentPane().setBackground(new Color(8, 32, 16));
    Box horizontalBox = Box.createHorizontalBox();
    Box verticalBox = Box.createVerticalBox();

    verticalBox.add(new TerminalLabel("+---+"));
    verticalBox.add(new TerminalLabel("|   |"));
    verticalBox.add(new TerminalLabel("+---+"));

    setLayout(new BorderLayout()); 
    horizontalBox.add(verticalBox);

    getContentPane().add(horizontalBox, BorderLayout.NORTH);

    setSize(300,300);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
