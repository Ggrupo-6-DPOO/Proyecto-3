package Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ArchivoSerializable<T extends Serializable> {

    public void escribir(ArrayList<T> objetos, String nombreArchivo) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(nombreArchivo)));
            oos.writeObject(objetos);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    public ArrayList<T> leer(String nombreArchivo) {
        try {
            ArrayList<T> objetos;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(nombreArchivo)));
            objetos = (ArrayList<T>) ois.readObject();
            ois.close();
            return objetos;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}