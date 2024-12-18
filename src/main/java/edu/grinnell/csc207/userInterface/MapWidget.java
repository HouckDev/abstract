package edu.grinnell.csc207.userInterface;

import javax.swing.Box;
import javax.swing.JFrame;
import edu.grinnell.csc207.matrix.MatrixV0;
import edu.grinnell.csc207.rooms.Room;

/**
 * Class for the map.
 *
 * @author Mitch Paiva and Paden Houck
 */
public class MapWidget extends Widget {
  /**
   * Constructs a new MapWidget.
   *
   * @param owningUserInterface
   */
  public MapWidget(final UserInterface owningUserInterface) {
    super(owningUserInterface);
    setTitle("Map");
    // Setup basic terminal UI

    getContentPane().setForeground(DefaultStyle.getTextColor());
    getContentPane().setBackground(DefaultStyle.getBackgroundColor());
    // // row 1
    // Box room1 = Box.createVerticalBox();

    // room1.add(new TerminalLabel("+---+"));
    // room1.add(new TerminalLabel("| |"));
    // room1.add(new TerminalLabel("+---+"));

    // Box hall1 = Box.createVerticalBox();

    // hall1.add(new TerminalLabel(" "));
    // hall1.add(new TerminalLabel("-[ ]-"));
    // hall1.add(new TerminalLabel(" "));

    // Box room2 = Box.createVerticalBox();

    // room2.add(new TerminalLabel("+---+"));
    // room2.add(new TerminalLabel("| |"));
    // room2.add(new TerminalLabel("+---+"));

    // Box row1 = Box.createHorizontalBox();
    // row1.add(room1);
    // row1.add(hall1);
    // row1.add(room2);

    // // row 2
    // Box hall2 = Box.createVerticalBox();

    // hall2.add(new TerminalLabel(" | "));
    // hall2.add(new TerminalLabel(" [ ] "));
    // hall2.add(new TerminalLabel(" | "));

    // Box empty1 = Box.createVerticalBox();

    // empty1.add(new TerminalLabel(" "));
    // empty1.add(new TerminalLabel(" "));
    // empty1.add(new TerminalLabel(" "));

    // Box empty2 = Box.createVerticalBox();

    // empty2.add(new TerminalLabel(" "));
    // empty2.add(new TerminalLabel(" "));
    // empty2.add(new TerminalLabel(" "));

    // Box row2 = Box.createHorizontalBox();
    // row2.add(hall2);
    // row2.add(empty1);
    // row2.add(empty2);

    // // row 3
    // Box room3 = Box.createVerticalBox();

    // room3.add(new TerminalLabel("+---+"));
    // room3.add(new TerminalLabel("| |"));
    // room3.add(new TerminalLabel("+---+"));

    // Box hall3 = Box.createVerticalBox();

    // hall3.add(new TerminalLabel(" "));
    // hall3.add(new TerminalLabel("-[ ]-"));
    // hall3.add(new TerminalLabel(" "));

    // Box room4 = Box.createVerticalBox();

    // room4.add(new TerminalLabel("+---+"));
    // room4.add(new TerminalLabel("| |"));
    // room4.add(new TerminalLabel("+---+"));

    // Box row3 = Box.createHorizontalBox();
    // row3.add(room3);
    // row3.add(hall3);
    // row3.add(room4);

    // //setLayout(new BorderLayout());
    // Box mainList = Box.createVerticalBox();
    // mainList.add(row1);
    // mainList.add(row2);
    // mainList.add(row3);
    // getContentPane().add(mainList);
    Box mainList = Box.createVerticalBox();
    MatrixV0<Room> roomMatrix =
        this.getUserInterface().getOwningApp().getCurrentGame().getCurrentLevel().getLevelRooms();
    for (int y = 0; y < roomMatrix.height(); y++) {
      Box row = Box.createHorizontalBox();
      for (int x = 0; x < roomMatrix.height(); x++) {
        if (roomMatrix.get(y, x) != null) {
          row.add(roomMatrix.get(y, x).constructMapWidget());
        } else { // construct an empty space widget
          Box emptyRoomWidget = Box.createVerticalBox();
          emptyRoomWidget.add(new TerminalLabel("     "));
          emptyRoomWidget.add(new TerminalLabel("     "));
          emptyRoomWidget.add(new TerminalLabel("  +  "));
          emptyRoomWidget.add(new TerminalLabel("     "));
          emptyRoomWidget.add(new TerminalLabel("     "));
          row.add(emptyRoomWidget);
        } // if else
      } // for

      mainList.add(row);
    } // for

    getContentPane().add(mainList);
    setSize(
        this.getUserInterface().getOwningApp().getCurrentGame().getCurrentLevel().getLevelRooms()
            .width() * 75,
        this.getUserInterface().getOwningApp().getCurrentGame().getCurrentLevel().getLevelRooms()
            .height() * 125);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  } // MapWidget
} // MapWidget
