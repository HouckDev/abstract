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
import edu.grinnell.csc207.App;

/**
 * A custom label with retro console styling.
 *
 * @author Paden Houck
 */
public class TerminalWidget extends Widget {
  /**
   * Constant for the command prompt length.
   */
  private final int commandPromptLength = 20;

  /**
   * The console log.
   */
  Box consoleLog;

  /**
   * The scroll pane.
   */
  JScrollPane scrollPane;

  /**
   * Constructs a new terminal widget.
   *
   * @param owningUserInterface
   */
  public TerminalWidget(final UserInterface owningUserInterface) {
    super(owningUserInterface);
    setTitle("Terminal");
    // Setup basic terminal UI

    getContentPane().setForeground(DefaultStyle.getTextColor());
    getContentPane().setBackground(DefaultStyle.getBackgroundColor());

    Box horizontalBox = Box.createHorizontalBox();
    horizontalBox.add(new TerminalLabel(">:"));

    JTextField commandField = new JTextField(commandPromptLength);
    commandField.setForeground(DefaultStyle.getTextColor());
    commandField.setBackground(new Color(0, 0, 0));
    horizontalBox.add(commandField);

    // construct confirm button
    JButton confirmButton = new JButton("Commit");
    confirmButton.setForeground(DefaultStyle.getTextColor());
    confirmButton.setBackground(new Color(0, 0, 0));

    horizontalBox.add(confirmButton);
    // construct console log
    consoleLog = Box.createVerticalBox();
    consoleLog = Box.createVerticalBox();
    for (int i = 0; i < 9; i++) {
      consoleLog.add(new TerminalLabel(""));
    } // for
    consoleLog.setBackground(DefaultStyle.getBackgroundColor());
    scrollPane = new JScrollPane(consoleLog);
    scrollPane = new JScrollPane(consoleLog);
    // construct main ui
    Box mainBox = Box.createVerticalBox();
    mainBox.add(scrollPane);
    mainBox.add(horizontalBox);

    add(mainBox);

    // add input

    // Test button input, advance turn on commit pressed
    confirmButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        addConsoleOutput("> " + commandField.getText());
        addConsoleOutput(getUserInterface().getOwningApp().getCurrentGame()
            .parseCommand(commandField.getText().toUpperCase()));
        // this is scuffed, editing the turn state from UI, but it works
        switch (getUserInterface().getOwningApp().getCurrentGame().getGameState()) {
          case "PLAY":
            getUserInterface().getOwningApp().getCurrentGame().setPlayerActions(
                getUserInterface().getOwningApp().getCurrentGame().getPlayerActions() - 1);
            App.runningApp.getUserInterface().getTerminal().addConsoleOutput("ACTIONS LEFT: "
                + getUserInterface().getOwningApp().getCurrentGame().getPlayerActions());

            commandField.setText("");
            if (App.runningApp.getCurrentGame().getPlayerActions() <= 0) {
              App.runningApp.getCurrentGame().advanceTurn();

            } // if

            break;

          default:
            break;
        } // switch
      } // actionPerformed
    });

    setSize(400, 300);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    addConsoleOutput("USER LOGGED IN");
    addConsoleOutput("TYPE 'HELP' TO VIEW CMDS");
  } // terminalWidget

  /**
   * Function to add console output.
   *
   * @param s a string.
   */
  public void addConsoleOutput(String s) {
    JScrollBar vertical = scrollPane.getVerticalScrollBar();
    consoleLog.add(new TerminalLabel(s));
    validate();
    vertical.setValue(vertical.getMaximum());
  } // addConsoleOutput

  /**
   * Function to add console output.
   *
   * @param s string.
   * @param c color.
   */
  public void addConsoleOutput(String s, Color c) {
    JScrollBar vertical = scrollPane.getVerticalScrollBar();
    TerminalLabel newLabel = new TerminalLabel(s);
    newLabel.setForeground(c);
    consoleLog.add(newLabel);
    validate();
    vertical.setValue(vertical.getMaximum());
  } // addConsoleOutput
} // terminalWidget
