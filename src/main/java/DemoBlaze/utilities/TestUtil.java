package DemoBlaze.utilities;

import java.io.InputStream;
import java.util.Properties;

public class TestUtil {

    public static Properties prop;

    static {
        try {
            prop = new Properties();

            InputStream input = TestUtil.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("config.properties file NOT FOUND");
            }

            prop.load(input);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}