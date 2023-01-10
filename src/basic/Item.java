package basic;

public abstract class Item {

    public abstract int getID();

    public abstract void assignedTo(Soldier soldier);
    public boolean usable=true;   //if usable false not assignable
}
