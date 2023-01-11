package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/example/calorie.txt"))) {
            int max = 0;
            int count =0;
            String line;
            while((line = br.readLine()) !=null) {

                if (!(line.equals(""))) {
                    count += Integer.parseInt(line);
                } else {
                    if (count > max) {
                        max = count;
                    }
                    index +=1;
                    count = 0;
                }
            }

            System.out.println(max);
            System.out.println(index);
        }
        catch (Exception e ) {
            System.out.println("Erreur");
        }
    }
}