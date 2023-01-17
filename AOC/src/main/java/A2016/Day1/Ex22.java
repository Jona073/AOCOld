package A2016.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ex22 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2016/Day1/Chemin.txt"))) {
            char direction = 'H';
            String line;
            int distance;
            char tourne;
            String pos;
            //H B G D
            int[] tabDistance = new int[2];
            List<String> lstPos = new ArrayList<>();

            int distanceTT;

            while ((line = br.readLine()) != null) {
                line = "R8, R4, R4, R8";
                String chaines[] = line.split(", ");

                for (String chaine: chaines) {
                    tourne = chaine.toCharArray()[0];
                    distance = Integer.parseInt(chaine.substring(1));
                    if(tourne == 'R') {
                        switch (direction) {
                            case 'H':
                                direction = 'D';
                                tabDistance[1] += distance;
                                break;

                            case 'B':
                                direction = 'G';
                                tabDistance[1] -= distance;
                                break;

                            case 'G':
                                direction = 'H';
                                tabDistance[0] += distance;
                                break;

                            case 'D':
                                direction = 'B';
                                tabDistance[0] -= distance;
                                break;

                            default:
                                throw new RuntimeException("IMPOSSIBLE DIRECTION " + tourne);
                        }
                    } else {
                        switch (direction) {
                            case 'H':
                                direction = 'G';
                                tabDistance[1] -= distance;
                                break;

                            case 'B':
                                direction = 'D';
                                tabDistance[1] += distance;
                                break;

                            case 'G':
                                direction = 'B';
                                tabDistance[0] -= distance;
                                break;

                            case 'D':
                                direction = 'H';
                                tabDistance[0] += distance;
                                break;

                            default:
                                throw new RuntimeException("IMPOSSIBLE DIRECTION " + tourne);
                        }
                    }

                    pos = tabDistance[0] + " - " + tabDistance[1] ;
                    System.out.println(pos);


                    if(lstPos.indexOf(pos) != -1) {

                        System.out.println("Distance TT: " + pos );
                      //  break;
                    };

                    lstPos.add(pos);
                }
            }

            distanceTT = Math.abs(tabDistance[0]) + Math.abs( tabDistance[1]);

            System.out.println("Distance TT: " + distanceTT);

        } catch (Exception e) {
            System.err.println("Erreur");
        }

    }
}
