package basic;

public class Weapon extends Item {
    @Override
    public void assignedTo(Soldier soldier) {

    }

    @Override
    public boolean usable() {
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCalibre() {
        return calibre;
    }

    public void setCalibre(float calibre) {
        this.calibre = calibre;
    }

    @Override
    public int getID() {
        return weaponID;
    }

    public void setWeaponID(int weaponID) {
        this.weaponID = weaponID;
    }

    public Weapon(String name, float calibre, int weaponID) {
        this.name = name;
        this.calibre = calibre;
        this.weaponID = weaponID;
    }

    private String name;
    private float calibre;
    private int weaponID;

    @Override
    public String toString(){
        return this.getName();
    }
}
