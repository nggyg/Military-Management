package basic;

import java.util.ArrayList;

public class Battalion {
   public ArrayList<Soldier> getSoldiers() {
      return soldiers;
   }

   public void setSoldiers(ArrayList<Soldier> soldiers) {
      this.soldiers = soldiers;
   }

   public Soldier getLeader() {
      return leader;
   }

   public void setLeader(Soldier leader) {
      this.leader = leader;
   }

   private ArrayList<Soldier> soldiers;
   private Soldier leader;

   public Battalion(ArrayList<Soldier> soldiers, Soldier leader) {
      this.soldiers = soldiers;
      this.leader = leader;
      this.leader.setRang(Rang.Officer);
   }
}
