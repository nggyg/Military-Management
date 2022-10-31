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

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Weapon(String name, float calibre, int serialNumber) {
        this.name = name;
        this.calibre = calibre;
        this.serialNumber = serialNumber;
    }

    private String name;
    private float calibre;
    private int serialNumber;

    @Override
    public String toString(){
        return this.getName();
    }
}
