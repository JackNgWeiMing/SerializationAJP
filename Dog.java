/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class Dog implements Serializable {

    private transient Collar collar;
    private String Name;

    public Dog() {
    }

    public Dog(Collar collar, String Name) {
        this.collar = collar;
        this.Name = Name;
    }

    public Collar getCollar() {
        return collar;
    }

    public void setCollar(Collar collar) {
        this.collar = collar;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

        private void writeObject(ObjectOutputStream s) throws IOException {
            s.defaultWriteObject();
            s.writeObject(collar);
        }

        private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            collar = (Collar)s.readObject();
        }

    public static void main(String[] arg) throws Exception {

        Collar c = new Collar("black", 2);
        Dog d = new Dog(c, "Mutt");

        FileOutputStream fos = new FileOutputStream("test1.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(d);
        os.close();

        FileInputStream fis = new FileInputStream("test1.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dog x = (Dog) ois.readObject();
        ois.close();

        System.out.println(x.getName() + " has a size " + x.getCollar().getSize()
                + " " + x.getCollar().getColour() + " collar");
        //prints out “Mutt has a size 2.0 black collar”;

    }

}
