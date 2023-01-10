package basic;

public class globals {
    private int SolID;
    private int ItemID;

    public int getSolID() {
        SolID=SolID+1;
        return SolID;
    }

    public void setSolID(int solID) {
        SolID = solID;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public globals() {
        SolID = 0;
        ItemID = 0;
    }
}
