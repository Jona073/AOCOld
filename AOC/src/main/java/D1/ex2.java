package D1;

import java.io.BufferedReader;
import java.io.FileReader;

public class ex2 {

    public static void main(String[] args) {
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/example/calorie.txt"))) {
            int max = 0;
            int max1 = 0;
            int max2 = 0;
            int max3 = 0;
            int Maxmax =0;
            int count =0;
            int index1 = -1;
            int index2 = -1;
            int index3 = -1;
            String line;

            br.mark(100000);
            for (int i = 1; i <= 3; i++) {
                max = 0;
                index = 0;
                count = 0;

                while ((line = br.readLine()) != null) {

                    if (!(line.equals(""))) {
                        count += Integer.parseInt(line);
                    } else {
                        if (count > max && index != index1 && index != index2 && index != index3) {
                            max = count;
                            switch (i) {
                                case 1:
                                    max1 = count;
                                    index1 = index;
                                    break;
                                case 2:
                                    max2 = count;
                                    index2 = index;
                                    break;
                                case 3:
                                    max3 = count;
                                    index3 = index;
                                    break;
                            }
                        }
                        index += 1;
                        count = 0;
                    }
                }

                br.reset();
            }

            System.out.println(index1);
            System.out.println(index2);
            System.out.println(index3);
            Maxmax = max1 + max2 + max3;

            System.out.println(max1);
            System.out.println(max2);
            System.out.println(max3);


            System.out.println(Maxmax);
        }
        catch (Exception e ) {
            System.out.println("Erreur");
        }
    }

}
