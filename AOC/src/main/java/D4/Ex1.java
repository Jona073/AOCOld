package D4;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/D4/section.txt"))) {
            String line;
            String elfe1;
            int p1e1;
            int p2e1;

            int p1e2;
            int p2e2;
            String elfe2;
            String sections1;
            String setion2;
            int count = 0;

            //Lire les chaine et faire longue chaine ex : 8-15 = 08,09,10,11,12,13,14,15
            while ((line = br.readLine()) != null) {
                elfe1 = "";
                elfe2 = "";
                p1e1 = Integer.parseInt((line.split(",")[0]).split("-")[0]);
                p2e1 = Integer.parseInt((line.split(",")[0]).split("-")[1]);

                for (int i = p1e1; i <= p2e1; i++) {
                    if (i<10) {
                        elfe1 += '0';
                    }
                    elfe1 +=  i + ",";
                }

                p1e2 = Integer.parseInt((line.split(",")[1]).split("-")[0]);
                p2e2 = Integer.parseInt((line.split(",")[1]).split("-")[1]);

                for (int i = p1e2; i <= p2e2; i++) {
                    if (i<10) {
                        elfe2 += '0';
                    }
                    elfe2 += i + ",";
                }

                if(elfe1.contains(elfe2) || elfe2.contains(elfe1)) {
                    count++;
                }

            }


            System.out.println(count);
        }
        catch (Exception e ) {
            System.out.println("Erreur");
        }
    }
}
