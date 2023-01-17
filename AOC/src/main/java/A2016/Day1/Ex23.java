package A2016.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ex23 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2016/Day1/Chemin.txt"))) {
            char direction = 'H';
            String line;
            int distance;
            char tourne;
            String pos;
            boolean sortieBoucle = false;
            //H B G D
            int[] tabDistance = new int[2];
            List<String> lstPos = new ArrayList<>();

            int distanceTT;

            while ((line = br.readLine()) != null) {
                String chaines[] = line.split(", ");

                for (String chaine: chaines) {
                    tourne = chaine.toCharArray()[0];
                    distance = Integer.parseInt(chaine.substring(1));
                    if(tourne == 'R') {
                        switch (direction) {
                            case 'H':
                                direction = 'D';
                                for (int i = 0; i < distance; i++) {
                                    tabDistance[1] ++;
                                    pos = tabDistance[0] + " - " + tabDistance[1] ;
                                    if(lstPos.indexOf(pos) != -1) {

                                        sortieBoucle = true;
                                        break;
                                    }
                                    lstPos.add(pos);
                                }
                                break;

                            case 'B':
                                direction = 'G';
                                for (int i = 0; i < distance; i++) {
                                    tabDistance[1] --;
                                    pos = tabDistance[0] + " - " + tabDistance[1] ;
                                    if(lstPos.indexOf(pos) != -1) {
                                        sortieBoucle = true;
                                        break;
                                    }
                                    lstPos.add(pos);
                                }
                                break;

                            case 'G':
                                direction = 'H';
                                for (int i = 0; i < distance; i++) {
                                    tabDistance[0] ++;
                                    pos = tabDistance[0] + " - " + tabDistance[1] ;
                                    if(lstPos.indexOf(pos) != -1) {
                                        sortieBoucle = true;
                                        break;
                                    }
                                    lstPos.add(pos);
                                }
                                break;

                            case 'D':
                                direction = 'B';
                                for (int i = 0; i < distance; i++) {
                                    tabDistance[0] --;
                                    pos = tabDistance[0] + " - " + tabDistance[1] ;
                                    if(lstPos.indexOf(pos) != -1) {
                                        sortieBoucle = true;
                                        break;
                                    }
                                    lstPos.add(pos);
                                }
                                break;

                            default:
                                throw new RuntimeException("IMPOSSIBLE DIRECTION " + tourne);
                        }
                    } else {
                        switch (direction) {
                            case 'H':
                                direction = 'G';
                                for (int i = 0; i < distance; i++) {
                                    tabDistance[1] --;
                                    pos = tabDistance[0] + " - " + tabDistance[1] ;
                                    if(lstPos.indexOf(pos) != -1) {
                                        sortieBoucle = true;
                                        break;
                                    }
                                    lstPos.add(pos);
                                }

                                break;

                            case 'B':
                                direction = 'D';
                                for (int i = 0; i < distance; i++) {
                                    tabDistance[1] ++;
                                    pos = tabDistance[0] + " - " + tabDistance[1] ;
                                    if(lstPos.indexOf(pos) != -1) {
                                        sortieBoucle = true;
                                        break;
                                    }
                                    lstPos.add(pos);
                                }
                                break;

                            case 'G':
                                direction = 'B';
                                for (int i = 0; i < distance; i++) {
                                    tabDistance[0] --;
                                    pos = tabDistance[0] + " - " + tabDistance[1] ;
                                    if(lstPos.indexOf(pos) != -1) {
                                        sortieBoucle = true;
                                        break;
                                    }
                                    lstPos.add(pos);
                                }
                                break;

                            case 'D':
                                direction = 'H';
                                for (int i = 0; i < distance; i++) {
                                    tabDistance[0] ++;
                                    pos = tabDistance[0] + " - " + tabDistance[1] ;
                                    if(lstPos.indexOf(pos) != -1) {
                                        sortieBoucle = true;
                                        break;
                                    }
                                    lstPos.add(pos);
                                }
                                break;

                            default:
                                throw new RuntimeException("IMPOSSIBLE DIRECTION " + tourne);
                        }
                    }


                    pos = tabDistance[0] + " - " + tabDistance[1] ;
                    System.out.println(pos);

                    
                    if(sortieBoucle) {

                        System.out.println("Distance TT: " + pos );
                        break;
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
