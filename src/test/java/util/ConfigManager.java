package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private InputStream inputStream;
    private String propValue = "";
    private final String propFileName = "src/resources/config.properties";

    public String getOSInfo() throws IOException {

        try{
            Properties prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            }

            propValue = prop.getProperty("myOperationSystem");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
        return propValue;
    }
}
