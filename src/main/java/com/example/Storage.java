package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public static void writeUsernames(ArrayList<String> usernameList) {
        try {
            tryWriteUsernames(usernameList);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void tryWriteUsernames(ArrayList<String> usernameList) throws IOException {
        FileWriter fw = new FileWriter ("usernames.txt");
        Charset.forName("utf-8");
        for(String username : usernameList) {
            fw.write(username + "\n");
        }
        fw.close();
    }

    public static ArrayList<String> readUsernames() {
        try {
            return tryReadUsernames();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    private static ArrayList<String> tryReadUsernames() throws FileNotFoundException {
        ArrayList<String> usernameList = new ArrayList<>();
        File file = new File("usernames.txt");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                usernameList.add(line);
            }
        }
        return usernameList;
    }
}
