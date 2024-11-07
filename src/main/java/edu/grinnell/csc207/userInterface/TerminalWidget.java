package edu.grinnell.csc207.userInterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TerminalWidget extends Widget {
  Box consoleLog;

  public TerminalWidget(UserInterface owningUserInterface) {
    super(owningUserInterface);
    setTitle("Terminal");
    // Setup basic terminal UI

    getContentPane().setForeground(new Color(64, 255, 128));
    getContentPane().setBackground(new Color(8, 32, 16));

    Box horizontalBox = Box.createHorizontalBox();
    horizontalBox.add(new TerminalLabel(">:"));

    JTextField commandField = new JTextField(20);
    commandField.setForeground(new Color(64, 255, 128));
    commandField.setBackground(new Color(0, 0, 0));
    horizontalBox.add(commandField);

    // construct confirm button
    JButton confirmButton = new JButton("Commit");
    confirmButton.setForeground(new Color(64, 255, 128));
    confirmButton.setBackground(new Color(0, 0, 0));

    horizontalBox.add(confirmButton);
    // construct console log
    consoleLog = Box.createVerticalBox();
    for (int i = 0; i < 9; i++) {
      consoleLog.add(new TerminalLabel(""));
    }
    consoleLog.add(new TerminalLabel("> Game Begin"));
    consoleLog.setBackground(new Color(8, 32, 16));
    JScrollPane scrollPane = new JScrollPane(consoleLog);
    // construct main ui
    Box mainBox = Box.createVerticalBox();
    mainBox.add(scrollPane);
    mainBox.add(horizontalBox);

    add(mainBox);

    // add input

    // Test button input, advance turn on commit pressed
    confirmButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        consoleLog.add(new TerminalLabel("> " + commandField.getText()));
        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        validate();
        vertical.setValue(vertical.getMaximum());
        getUserInterface().owningApp.getCurrentGame().advanceTurn();
      }
    });

    setSize(300, 300);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
