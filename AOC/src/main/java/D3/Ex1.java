package D3;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/D3/sac.txt"))) {

            String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

            String line;
            String partie1;
            String partie2;
            int total = 0;
            char car;
            while ((line = br.readLine()) != null) {
                partie1="";
                partie2 ="";
                car = ' ';

                partie1 = line.substring(0,(line.length()/2));
                partie2 = line.substring((line.length()/2));

                for (char c : partie1.toCharArray()) {
                   if (partie2.indexOf(c) != -1) {
                       car = c;
                   }
                }

                if (car != ' ') {
                    total += alphabet.indexOf(car) +1;
                }

            }
            System.out.println(total);
        }
        catch (Exception e ) {
            System.out.println("Erreur");
        }
    }
}
