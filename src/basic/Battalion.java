package basic;

import java.util.ArrayList;

public class Battalion {
   private ArrayList<Soldier> soldiers;
   private Soldier leader;

   public Battalion(ArrayList<Soldier> soldiers, Soldier leader) {
      this.soldiers = soldiers;
      this.leader = leader;
      this.leader.setRang(Rang.Officer);
   }
}
