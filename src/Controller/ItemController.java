package Controller;

import Repository.Repository;
import basic.Item;

public class ItemController {
    private Repository<Item> content;
    public void add(Item newItem){
        this.content.add(newItem);
    }
    public boolean removeItem(int id){
        for(Item item:this.content.getContent()) {
            if (item.getID() == id) {
                this.content.remove(item);
                return true;
            }
        }
        return false;
    }
    public boolean update(int id){
        for(Item item:this.content.getContent()) {
            if (item.getID() == id) {
                //update item
                return true;
            }
        }
        return false;
    }
    public void display(){
        this.content.display();
    }
}
