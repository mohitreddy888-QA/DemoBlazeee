package DemoBlaze.utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "PlaceOrder_page")
    public Object[][] PlaceOrder_page() {
        String path = System.getProperty("user.dir") +
                "/src/main/resources/TestData.xlsx";

        return ExcelUtil.getExcelData(path, "PlaceOrder_page");
    }
}