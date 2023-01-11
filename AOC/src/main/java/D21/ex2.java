package D21;

import java.io.BufferedReader;
import java.io.FileReader;

public class ex2 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/D21/game.txt"))) {

            String line;
            String J1;
            String J2;
            int ttPoint=0;

            //X perds
            //Y match nul
            //Z gagne
            while ((line = br.readLine()) != null) {
                J1 = line.substring(0,1);
                J2 = line.substring(2,3);

                switch (J1) {
                    case "A":
                        switch (J2) {
                            case "X":
                                ttPoint +=0;
                                ttPoint +=3;
                                break;
                            case "Y":
                                ttPoint +=3;
                                ttPoint +=1;
                                break;
                            case "Z":
                                ttPoint +=6;
                                ttPoint +=2;
                                break;
                        }
                        break;
                    case "B":
                        switch (J2) {
                            case "X":
                                ttPoint +=0;
                                ttPoint +=1;
                                break;
                            case "Y":
                                ttPoint +=3;
                                ttPoint +=2;
                                break;
                            case "Z":
                                ttPoint +=6;
                                ttPoint +=3;
                                break;
                        }
                        break;
                    case "C":
                        switch (J2) {
                            case "X":
                                ttPoint +=0;
                                ttPoint +=2;
                                break;
                            case "Y":
                                ttPoint +=3;
                                ttPoint +=3;
                                break;
                            case "Z":
                                ttPoint +=6;
                                ttPoint +=1;
                                break;
                        }

                        break;

                }


            }
            System.out.println(ttPoint);

        }

        catch (Exception e ) {
            System.out.println("Erreur");
        }
    }
}
