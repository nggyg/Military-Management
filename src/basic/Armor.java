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

    @Override
    public int getID() {
        return armorID;
    }

    public void setArmorID(int armorID) {
        this.armorID = armorID;
    }

    public String getArmorLightness() {
        return armorLightness;
    }

    public void setArmorLightness(String armorLightness) {
        this.armorLightness = armorLightness;
    }

    public Armor(String armorType, String armorLightness, int armorID) {
        this.armorType = armorType;
        this.armorID = armorID;
        this.armorLightness = armorLightness;
    }

    private String armorType;
    private int armorID;
    private String armorLightness;

    @Override
    public String toString(){
        return this.getArmorType();
    }


}
