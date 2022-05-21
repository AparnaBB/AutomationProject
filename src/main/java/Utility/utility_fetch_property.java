package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class utility_fetch_property
{
    public static String fetch_property_value(String key) throws IOException {
        FileInputStream F = new FileInputStream("./src/test/resources/Config/config.properties");
        Properties P = new Properties();
        P.load(F);
        return P.get(key).toString();
    }
}
