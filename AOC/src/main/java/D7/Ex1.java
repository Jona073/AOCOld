package D7;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/D7/chemin.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                if(line.charAt(0) == '$') {

                }
            }



        } catch (Exception e) {
            System.out.println("Erreur");
        }
    }
}
