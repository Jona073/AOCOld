package D3;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/D3/sac.txt"))) {

            String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

            String line;
            String sac1 = "";
            String sac2 = "";
            String sac3 = "";

            int total = 0;
            char car = ' ';
            int i = 1;
            int modulo;
            while ((line = br.readLine()) != null) {


                modulo = i % 3;
                switch(modulo) {
                    case 1:
                        sac1 = line;
                        break;
                    case 2:
                        sac2 = line;
                        break;
                    case 0:
                        sac3 = line;

                        for (char c : sac1.toCharArray()) {
                            if (sac2.indexOf(c) != -1) {
                                if (sac3.indexOf(c) != -1) {
                                    car = c;
                                }
                            }
                        }


                        if (car != ' ') {
                            total += alphabet.indexOf(car) +1;
                        }
                        car = ' ';
                        sac1="";
                        sac2="";
                        sac3="";
                        break;
                }
                i ++;
            }
            System.out.println(total);
        }
        catch (Exception e ) {
            System.out.println("Erreur");
        }
    }
}
