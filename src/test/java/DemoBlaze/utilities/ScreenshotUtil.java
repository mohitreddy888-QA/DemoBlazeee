package DemoBlaze.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        if (driver == null) {
            throw new RuntimeException("Driver is null, screenshot not captured");
        }

        String folderPath = System.getProperty("user.dir") + File.separator + "screenshots";
        File folder = new File(folderPath);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        String filePath = folderPath + File.separator + testName + "_" + System.currentTimeMillis() + ".png";

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(filePath);
            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved at: " + filePath);
            return filePath;

        } catch (IOException e) {
            throw new RuntimeException("Screenshot saving failed", e);
        }
    }
}