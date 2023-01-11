package D6;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/D6/radio.txt"))) {
            String line;
            int result = -1;
            char[] tabCar;
            boolean test = true;

            //Lire les chaine et faire longue chaine ex : 8-15 = 08,09,10,11,12,13,14,15
            while ((line = br.readLine()) != null) {
                tabCar = line.toCharArray();

                for (int i = 0; i < tabCar.length; i++) {
                    if(i +14 < tabCar.length)
                        test = true;
                        for (int j = 0; j < 14; j++) {
                            for (int k = 0; k < j; k++) {
                                if (tabCar[i+j] == tabCar[i+k]) {
                                    test = false;
                                }
                            }
                        }
                    if (test)
                    {
                        result = i+14;
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
