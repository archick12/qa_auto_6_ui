package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigProperties {

    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    protected static File file;

    static {
        try {
            File file1 = new File("src/test/java/resources/jira.properties");
            fileInputStream = new FileInputStream(file1);
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String getTestProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}