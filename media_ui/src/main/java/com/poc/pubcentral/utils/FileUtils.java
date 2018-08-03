package com.poc.pubcentral.utils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by kiryl_zayets on 10/13/15.
 */
public class FileUtils {

    public static String readFile(String path) {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());

        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}
