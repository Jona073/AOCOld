package D21;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {

        String line;

        //Pierre    A   X           1Point
        //Papier    B   Y           2Point
        //Ciseaux   C   Z           3Point

        //Si gagne 6P
        //Si nul   3P
        //Si perds P

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/D21/game.txt"))) {

            String J1;
            String J2;
            int ttPoint=0;


            while ((line = br.readLine()) != null) {
                J1 = line.substring(0,1);
                J2 = line.substring(2,3);

                switch (J1) {
                    case "A":
                        switch (J2) {
                            case "X":
                                ttPoint += 1;
                                ttPoint +=3;
                                break;
                            case "Y":
                                ttPoint += 2;
                                ttPoint += 6;
                                break;
                            case "Z":
                                ttPoint +=0;
                                ttPoint += 3;
                                break;
                        }
                        break;
                    case "B":
                        switch (J2) {
                            case "X":
                                ttPoint += 1;
                                ttPoint +=0;
                                break;
                            case "Y":
                                ttPoint += 2;
                                ttPoint += 3;
                                break;
                            case "Z":
                                ttPoint +=6;
                                ttPoint += 3;
                                break;
                        }
                        break;
                    case "C":
                        switch (J2) {
                            case "X":
                                ttPoint += 1;
                                ttPoint +=6;
                                break;
                            case "Y":
                                ttPoint += 2;
                                ttPoint += 0;
                                break;
                            case "Z":
                                ttPoint +=3;
                                ttPoint += 3;
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
