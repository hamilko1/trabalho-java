package Persistence;

import Model.Banco;

import java.io.*;

public class Persistencia {
    
    public static Banco carregarBanco(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Banco) ois.readObject();
        }
    }

    public static void salvarBanco(Banco banco, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(banco);
        }
    }
}
