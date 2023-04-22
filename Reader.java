//non utilisée car le modèle actuel de la calculatrice favorise un échange permanent entre client et serveur.
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class Reader {
    static String reading(String s) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\zyadm\\eclipse-workspace\\Projet Archi\\src\\Exercice_cours\\fichier.txt"));
        while (reader.readLine() != null);
        reader.close();
        
        Properties p = new Properties();
        p.load(new FileInputStream("C:\\Users\\zyadm\\eclipse-workspace\\Projet Archi\\src\\Exercice_cours\\fichier.txt"));
        return p.getProperty(s);
        }
}
