package Extra;

import Builder.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Extras {
    public static WebDriver driver;

    static {
        try {
            driver = Singleton.getDriverInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String ENTER = "notSigned";
    private static String PRESSENTER = "ember1686";
    private static String ASSERTFIRSTFIELD = "#parsley-id-12 > li";
    private static String EXCEPTEDRSULT = "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";
    private static String ASSERTSECONDFILED = "#parsley-id-14 > li";


//    }
    public static void homescreen() throws Exception {  ///Assert Sign In Error Message
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.className(ENTER))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(PRESSENTER))).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(ASSERTFIRSTFIELD)).getText(), EXCEPTEDRSULT);
        Assert.assertEquals(driver.findElement(By.cssSelector(ASSERTSECONDFILED)).getText(), EXCEPTEDRSULT);
    }
    public static void collorforbutton(){ //// Print Color Of How To Send
        WebElement color = driver.findElement(By.cssSelector("#ember2100 > div > div.steps > div.step.active"));
       String collor =  color.getCssValue("color");
        String c = Color.fromString(collor).asHex();
        System.out.println(c);

    }
}