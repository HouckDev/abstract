package edu.grinnell.csc207.userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import javax.swing.Box;

/**
 * The pop up widget that appears when there is an alert.
 *
 * @author Mitch Paiva and Paden Houck
 */
public class AlertPopupWidget extends Widget {
  /**
   * Constructs a new alert Popup.
   *
   * @param owningUserInterface
   * @param alertText
   */
  public AlertPopupWidget(final UserInterface owningUserInterface, String alertText) {
    super(owningUserInterface);
    setTitle("Alert");
    getContentPane().setLayout(new BorderLayout());
    // mainPanel = new UIPanel();
    // getContentPane().add(mainPanel);
    // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    Box vertbox = Box.createVerticalBox();

    Label alertLabel = new Label("ALERT");
    Font alertFont = new Font(Font.MONOSPACED, Font.PLAIN, 24);
    alertLabel.setFont(alertFont);
    alertLabel.setForeground(new Color(255, 255, 255));
    vertbox.add(alertLabel);

    Label alertTextLabel = new Label(alertText);
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
