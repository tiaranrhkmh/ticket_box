package com.ticketbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Buy Ticket Class
 */
public class BuyTicket {
    public static String WELCOME = "Welcome Kelompok Ganjil";

    /**
     * Select Studio : to choose studio what you want
     * @param filename filename
     * @throws IOException exception
     */
    public static void select_Studio(String filename) throws IOException {
        List<String> line;
        DetailStudio.viewStudio(filename);
        line = Files.readAllLines(Paths.get(filename));
        System.out.println("Choose Studio:");
        System.out.println(line.get(0));
        for (int i =0; i<line.toArray().length;i++)
        {
            Scanner value = new Scanner(System.in);
            int result = value.nextInt();
            if (result >0){
                System.out.println(WELCOME);
                System.out.println(line.get(i));
                buyTicket(i,line);
            } else {
                System.out.println("Error Result please try again");
            }
        }
    }

    /**
     * Buy Ticket Process
     * @param i integer
     * @param line List<String>
     * @throws IOException exception
     */
    private static void buyTicket(int i,List<String> line) throws IOException {
        createPicture();
        System.out.println("How many you want to buy Ticket:");
        Scanner input = new Scanner(System.in);
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        int x = input.nextInt();
        if (x>0){
            for (int k = 0; k<x; k++){
                File save_file = new File(i+1+".txt");
                System.out.printf("\nTicket %d Row [A-J] :",k+1);
                String row = bufferedreader.readLine();
                System.out.printf("\nTicket %d Seat[1-20] :",k+1);
                String column = bufferedreader.readLine();
                try {
                    FileOutputStream object=new FileOutputStream(save_file,true);
                    if (object.toString().contains(column) || object.toString().contains(row)){
                        System.out.println("Please Try Again");
                    } else {
                        FileOutputStream object1=new FileOutputStream(save_file,true);
                        String combine = "\n"+" "+ line.get(i) + " " +row+" "+column;
                        object1.write(combine.getBytes(StandardCharsets.UTF_8));
                        object1.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * Create Picture
     */
    private static void createPicture() {
        System.out.println(" 1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
        for(int i=1;i<=10;i++){
            for(int j=1;j<=20;j++){
                System.out.print(" * ");
            }
            System.out.println((char)(i + 64));
        }
        System.out.println("===========================================================");
        System.out.println("                        SCREEN                             ");
        System.out.println("===========================================================");
    }
}

