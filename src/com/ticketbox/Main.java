package com.ticketbox;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main Class
 */
public class Main {
    public static String WELCOME = "Welcome Kelompok Ganjil";
    private static final String filename = "studio.txt";

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner value = new Scanner(System.in);

        System.out.println(WELCOME);
        System.out.println("Menu");
        System.out.println("====");
        System.out.println("1. Add Studio");
        System.out.println("2. Edit Studio");
        System.out.println("3. View Studio");
        System.out.println("4. Buy Ticket");
        System.out.println("5. Exit");
        System.out.println("Choose : ");

        int choose = value.nextInt();

        switch (choose){
            case 1:
                System.out.println(WELCOME);
                System.out.println("Add Studio");
                DetailStudio.addStudio(filename);
                break;
            case 2:
                System.out.println(WELCOME);
                System.out.println("Edit Studio");
                DetailStudio.editStudio(filename);
                break;
            case 3:
                System.out.println(WELCOME);
                System.out.println("View Studio");
                DetailStudio.viewStudio(filename);
                break;
            case 4:
                System.out.println(WELCOME);
                System.out.println("Buy Ticket");
                BuyTicket.select_Studio(filename);
                break;
            case 5:
                System.exit(0);
                break;
        }
    }
}
