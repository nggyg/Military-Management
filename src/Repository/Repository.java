package Repository;

import basic.Soldier;

import java.util.ArrayList;

public class Repository<E> {
    private ArrayList<E> content;

    public Repository(ArrayList<E> content) {
        this.content = content;
    }

    public ArrayList<E> content() {
        return content;
    }

    public void setContent(ArrayList<E> content) {
        this.content = content;
    }

    public void add(E item){
        this.content.add(item);

    }
    public void remove(E item){
        this.content.remove(item);
    }
    public void display(){
        for(E elem:this.content){
            System.out.println(elem);
        }
    }
}
