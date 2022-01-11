package com.ticketbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Detail Studio
 */
public class DetailStudio {

    /**
     * Add Studio
     * @param filename filename
     */
    public static void addStudio(String filename) {
        Scanner value = new Scanner(System.in);
        String result = "\n"+value.nextLine();
        try {
            FileOutputStream object=new FileOutputStream(filename,true);
            object.write(result.getBytes(StandardCharsets.UTF_8));
            object.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Edit Studio
     * @param filename filename
     * @throws IOException exception
     */
    public static void editStudio(String filename) throws IOException {
        System.out.println("1. Delete All");
        System.out.println("2. Add");
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose Menu :");
        int value = Integer.parseInt(bufferedreader.readLine());
        String result = "\n"+value;
        switch (value){
            case 1:
                File file =new File(filename);
                file.delete();
                break;
            case 2:
                try {
                    FileOutputStream object=new FileOutputStream(filename,true);
                    object.write(result.getBytes(StandardCharsets.UTF_8));
                    object.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    /**
     * View Studio
     * @param filename filename
     */
    public static void viewStudio(String filename){
        File view_file = new File(filename);
        Scanner view_studio;
        try {
            view_studio = new Scanner(view_file);
            while(view_studio.hasNextLine()){
                String getDataString = view_studio.nextLine();
                System.out.println(getDataString);
            }
            view_studio.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
