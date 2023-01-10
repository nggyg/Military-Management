package basic;

import java.util.Map;
import java.util.ArrayList;

public class Soldier extends Person{
    private Rang rang;
    private Map.Entry<Weapon,Armor> equipment;
    private ArrayList<Vehicle> vehicleList;

    public Soldier(int id) {
        super(id);
        this.setId(id);
    }

    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public Soldier(String name, int id) {
        super(name, id);
        this.setName("tbd");
    }

    public Soldier(String name, int id, Rang rang) {
        super(name, id);
        this.rang=rang;
    }

    public void promote(){
        if(this.getRang()==Rang.Private)
            this.setRang(Rang.Officer);
        if(this.getRang()==Rang.Officer)
            this.setRang(Rang.General);
    }
    public void demote(){
        if(this.getRang()==Rang.General)
            this.setRang(Rang.Officer);
        if(this.getRang()==Rang.Officer)
            this.setRang(Rang.Private);
    }

    public Weapon getWeapon(){
        return this.equipment.getKey();
    }
    public void setWeapon(Weapon w){
        this.setEquipment(Map.entry(w,this.getArmor()));
    }
    public Armor getArmor(){
        return this.equipment.getValue();
    }
    public void setArmor(Armor a){
        this.setEquipment(Map.entry(this.getWeapon(),a));
    }
    public Map.Entry<Weapon, Armor> getEquipment() {
        return equipment;
    }

    public void setEquipment(Map.Entry<Weapon, Armor> equipment) {
        this.equipment = equipment;
    }

    public Rang getRang() {
        return rang;
    }

    public void setRang(Rang rang) {
        this.rang = rang;
    }
    @Override
    public String toString(){
        return String.valueOf(this.getId())+" "+this.getName()+" "+String.valueOf(this.getRang());
    }

    public boolean getAvailableEq(){
        return false;
    }
}
