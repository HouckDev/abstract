package edu.grinnell.csc207.userInterface;

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
import edu.grinnell.csc207.userInterface.UserInterface.UIPanel;

public class MapWidget extends Widget {
  public MapWidget(UserInterface owningUserInterface) {
    super(owningUserInterface);
    setTitle("Map");
    // Setup basic terminal UI

    getContentPane().setForeground(new Color(64, 255, 128));
    getContentPane().setBackground(new Color(8, 32, 16));
    Box room1 = Box.createVerticalBox();

    room1.add(new TerminalLabel("+---+"));
    room1.add(new TerminalLabel("|   |"));
    room1.add(new TerminalLabel("+---+"));
    
    Box hall1 = Box.createVerticalBox();

    hall1.add(new TerminalLabel("     "));
    hall1.add(new TerminalLabel("-[ ]-"));
    hall1.add(new TerminalLabel("     "));

    Box room2 = Box.createVerticalBox();

    room2.add(new TerminalLabel("+---+"));
    room2.add(new TerminalLabel("|   |"));
    room2.add(new TerminalLabel("+---+"));

    Box horizontalBox = Box.createHorizontalBox();
    horizontalBox.add(room1);
    horizontalBox.add(hall1);
    horizontalBox.add(room2);

    setLayout(new BorderLayout()); 
    getContentPane().add(horizontalBox, BorderLayout.NORTH);

    setSize(300,300);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
