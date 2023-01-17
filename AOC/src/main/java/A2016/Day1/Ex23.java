package A2016.Day1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
public class Ex23 {
    static char direction = 'H';
    static String line;
    static int distance;
    static char tourne;
    static String pos;
    static boolean sortieBoucle = false;
    //H B G D
    static int[] tabDistance = new int[2];
    static List<String> lstPos = new ArrayList<>();
    static int distanceTT;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2016/Day1/Chemin.txt"))) {

            while ((line = br.readLine()) != null) {
                String chaines[] = line.split(", ");

                for (String chaine: chaines) {
                    tourne = chaine.toCharArray()[0];
                    distance = Integer.parseInt(chaine.substring(1));
                    if(tourne == 'R') {
                        switch (direction) {
                            case 'H':
                                direction = 'D';
                                isAlreadyGo(1,true);
                                break;
                            case 'B':
                                direction = 'G';
                                isAlreadyGo(1,false);
                                break;
                            case 'G':
                                direction = 'H';
                                isAlreadyGo(0,true);
                                break;
                            case 'D':
                                direction = 'B';
                                isAlreadyGo(0,false);
                                break;
                            default:
                                throw new RuntimeException("IMPOSSIBLE DIRECTION " + tourne);
                        }
                    } else {
                        switch (direction) {
                            case 'H':
                                direction = 'G';
                                isAlreadyGo(1,false);
                                break;
                            case 'B':
                                direction = 'D';
                                isAlreadyGo(1,true);
                                break;
                            case 'G':
                                direction = 'B';
                                isAlreadyGo(0,false);
                                break;
                            case 'D':
                                direction = 'H';
                                isAlreadyGo(0,true);
                                break;
                            default:
                                throw new RuntimeException("IMPOSSIBLE DIRECTION " + tourne);
                        }
                    }
                    pos = tabDistance[0] + " - " + tabDistance[1] ;
                    if(sortieBoucle) {
                        System.out.println("pos TT: " + pos );
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
    private static void isAlreadyGo(int VertiHori, boolean ajout) {
        for (int i = 0; i < distance; i++) {
            if (ajout) {
                tabDistance[VertiHori] ++;
            } else {
                tabDistance[VertiHori] --;
            }
            pos = tabDistance[0] + " - " + tabDistance[1] ;
            if(lstPos.indexOf(pos) != -1) {
                sortieBoucle = true;
                break;
            }
            lstPos.add(pos);
        }
    }
}
