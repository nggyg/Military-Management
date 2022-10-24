package basic;

public abstract class Item {
    public abstract void assignedTo(Soldier soldier);
    public abstract boolean usable();   //if usable false not assignable
}
