package Builder;

import Extra.Extras;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;

public class Singleton {
    private static WebDriver driver;
    public static WebDriverWait wait;

    public static WebDriver getDriverInstance() throws Exception {

        if (driver == null) {
            Report.beforeClass();
String type = getData("browserType");
if (type.equals("Chrome")) {
    try {

        System.setProperty("webdriver.chrome.driver", Constant.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        wait = new WebDriverWait(Singleton.getDriverInstance(), Duration.ofSeconds(10));
        Report.test.log(Status.PASS, "Driver established successfully");


    } catch (Exception e) {
        e.printStackTrace();
        Report.test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
        throw new Exception("Driver failed");
    }
}
        }
        return driver;
    }
    public static void getUrl() throws Exception {
        String URL = getData("URL");
        driver.get(URL);
//        Extras.logo();
        driver.manage().window().maximize();
    }



    public static String getData (String keyName) throws Exception{
        ClassLoader classLoader = Singleton.class.getClassLoader();
        String xmlFilePath = String.valueOf(new File("C:\\Users\\Omer Brosh\\Desktop\\SeleniumProject-master-master-master\\src\\main\\java\\XML\\Data.xml"));
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

}



