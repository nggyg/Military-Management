package basic;

public class Soldier extends Person{
    private Rang rang;
    public Soldier(String name, int id, Rang rang) {
        super(name, id);
        this.rang=rang;
    }

    public Rang rang() {
        return rang;
    }

    public void setRang(Rang rang) {
        this.rang = rang;
    }
}
