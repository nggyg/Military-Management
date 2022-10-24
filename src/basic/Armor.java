package basic;

public class Armor extends Item{
    @Override
    public void assignedTo(Soldier soldier) {

    }

    @Override
    public boolean usable() {
        return false;
    }

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }

    public int getArmorID() {
        return armorID;
    }

    public void setArmorID(int armorID) {
        this.armorID = armorID;
    }

    public Armor(String armorType, int armorID) {
        this.armorType = armorType;
        this.armorID = armorID;
    }

    private String armorType;
    private int armorID;

}
