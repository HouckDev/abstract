package edu.grinnell.csc207.rooms;

import edu.grinnell.csc207.Level;
import edu.grinnell.csc207.actors.junk.AngryStudents;
import edu.grinnell.csc207.actors.junk.Cabybara;
import edu.grinnell.csc207.actors.junk.FilingCabinets;
import edu.grinnell.csc207.actors.junk.Garbage;
import edu.grinnell.csc207.actors.junk.TVStack;

public class FacilityRoom extends Room {
  public FacilityRoom(Level newLevel) {
    super(newLevel);
    // Calculate junk to spawn
    int junkCount = (int) (Math.pow(Math.random(), 2) * 3) + 1;
    for (int i = 0; i < junkCount; i++) {
      switch ((int) (Math.random() * 3)) {
        case 0:
          addActor(new FilingCabinets(newLevel));
          break;
        case 1:
          addActor(new Garbage(newLevel));
          break;
        case 2:
          addActor(new TVStack(newLevel));
          break;
        default:
          break;
      } // switch
    } // for loop
    if ((Math.random() * 10) == 7) {
      addActor(new Cabybara(newLevel));
    } // if statement
    if ((Math.random() * 100) == 69) {
      addActor(new AngryStudents(newLevel));
    } // if statement
  } // OfficeRoom

} // OfficeRoom
