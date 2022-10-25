import basic.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            File in = new File("data.txt");
            Scanner scan = new Scanner(in);
            System.out.println(scan.next());
            scan.close();
        }catch (FileNotFoundException e){
            System.out.println("File error");
            e.printStackTrace();
        }
    }
}