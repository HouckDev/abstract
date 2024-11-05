package edu.grinnell.csc207;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import edu.grinnell.csc207.UserInterface.UIPanel;

public class AlertPopupWidget extends JFrame {
  public AlertPopupWidget() {
    super("Alert");
    getContentPane().setLayout(new BorderLayout());
    //mainPanel = new UIPanel();
    //getContentPane().add(mainPanel);
    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    setSize(300,200);
    //frame.setUndecorated(true);
    getContentPane().setBackground( Color.RED );
    setVisible(true);
  }
}
