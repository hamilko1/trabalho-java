package Persistence;

import Model.Banco;

import java.io.*;

public class Persistencia {
    
    // Método para carregar um objeto Banco a partir de um arquivo
    public static Banco carregarBanco(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Banco) ois.readObject(); // Lê o objeto Banco do arquivo e o retorna
        }
    }

    // Método para salvar um objeto Banco em um arquivo
    public static void salvarBanco(Banco banco, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(banco); // Escreve o objeto Banco no arquivo especificado
        }
    }
}
