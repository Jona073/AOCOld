package D5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/D5/package.txt")))    {
            String line;
            int nbLigne = 0;
            int nbcolonne = 9;


            char tab[][] = new char[nbcolonne][50] ;
            char c1;
            char charsv;
            boolean tst = true;

            int select;
            int nb;
            int from;
            int to;
            int k;
            String result = "";
            String s;
            String car;
            while ((line = br.readLine()) != null) {
                if(line.contains("[") ) {
                    for (int i = 0; i < nbcolonne; i++) {
                        if(line.length()>1+i*4) {
                            car = line.substring(1 + i * 4, 1 + i * 4 +1);
                            if (!car.equals(" ")) {
                                tab[nbcolonne - i-1][nbLigne] = car.charAt(0);
                            }
                        }
                    }
                } else if (line.contains("move")) {
                    if(tst) {
                        for (int i = 0; i < nbcolonne; i++) {
                            for (int j = 0; j < 49; j++) {
                                k = 0;
                                if (tab[i][j] == 0) {
                                    while(j+k < 49) {
                                        if (tab[i][j + k] != 0) {
                                            tab[i][j] = tab[i][j+k];
                                            tab[i][j+k] = 0;
                                            break;
                                        }

                                        k++;
                                    } ;
                                }
                            }
                        }
                        tst = false;
                    }

                    s = (line.split("move")[1]).split("from")[0];
                    nb = Integer.parseInt(s.trim());

                    s = ((line.split("move")[1]).split("from")[1]).split("to")[0];
                    from = Integer.parseInt(s.trim());

                    s = ((line.split("move")[1]).split("from")[1]).split("to")[1];
                    to = Integer.parseInt(s.trim());

                    for (int i = 0; i < nb; i++) {
                        //Decaler le to de 1
                        for (int j = 48; j >= 0; j--) {
                            tab[nbcolonne-to][j+1] = tab[nbcolonne-to][j];
                        }
                        //mettre le from dans le to[1]
                        tab[nbcolonne-to][0] = tab[nbcolonne-from][0];
                        //decaler le from
                        for (int j = 0; j < 49; j++) {
                            tab[nbcolonne-from][j] = tab[nbcolonne-from][j+1];
                        }
                    }

                }

                nbLigne++;
            }
            for (int i = 0; i < nbcolonne; i++) {
                result += tab[nbcolonne-i-1][0];
            }
            System.out.println(result);
        }
        catch (Exception e ) {
            System.out.println("Erreur");
        }
    }
}
