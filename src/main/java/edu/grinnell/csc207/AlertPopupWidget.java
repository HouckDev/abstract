package edu.grinnell.csc207;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import edu.grinnell.csc207.UserInterface.UIPanel;

public class AlertPopupWidget extends Widget {
  public AlertPopupWidget() {
    setTitle("Alert");
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
