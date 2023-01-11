package D6;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/D6/radio.txt"))) {
            String line;
            int result = -1;
            char[] tabCar;


            //Lire les chaine et faire longue chaine ex : 8-15 = 08,09,10,11,12,13,14,15
            while ((line = br.readLine()) != null) {
                tabCar = line.toCharArray();

                for (int i = 0; i < tabCar.length; i++) {
                    if(i +4 < tabCar.length)
                    if (tabCar[i] != tabCar[i+1] && tabCar[i] != tabCar[i+2] && tabCar[i] != tabCar[i+3] && tabCar[i] != tabCar[i+4]
                     && tabCar[i+1] != tabCar[i+2] && tabCar[i+1] != tabCar[i+3] && tabCar[i+1] != tabCar[i+4]
                     && tabCar[i+2] != tabCar[i+3] && tabCar[i+2] != tabCar[i+4] && tabCar[i+3] != tabCar[i+4])
                    {
                        result = i+4;
                        break;
                    }
                }
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Erreur");
        }
    }
}
