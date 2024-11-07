package edu.grinnell.csc207.userInterface;

import java.awt.BorderLayout;
import java.awt.Color;

public class AlertPopupWidget extends Widget {
  /**
   * Constructs a new alert Popup.
   * @param owningUserInterface
   */
  public AlertPopupWidget(final UserInterface owningUserInterface) {
    super(owningUserInterface);
    setTitle("Alert");
    getContentPane().setLayout(new BorderLayout());
    // mainPanel = new UIPanel();
    // getContentPane().add(mainPanel);
    // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    setSize(300, 200);
    // frame.setUndecorated(true);
    getContentPane().setBackground(Color.RED);
    setVisible(true);
  } // AlertPopupWidget
} // AlertPopupWidget
