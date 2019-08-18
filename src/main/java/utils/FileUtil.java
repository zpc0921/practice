package utils;

import javafx.beans.binding.ObjectExpression;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class FileUtil {
    public static String
    read(String fileName) {
        String encoding = "UTF-8";
        final String pathName = FileUtil.getPath(fileName);
        if (Objects.isNull(pathName)) {
            return null;
        }

        final File file = new File(pathName);
        final Long filelength = file.length();
        final byte[] filecontent = new byte[filelength.intValue()];

        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        try {
            final String filestr = new String(filecontent, encoding);
            System.out.println(filestr);
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    private static String getPath(String fileName) {
        try {
            return FileUtil.class.getClassLoader().getResource(fileName).getPath();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
