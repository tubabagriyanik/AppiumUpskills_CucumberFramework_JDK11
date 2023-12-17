package generalstore.hooks;

import generalstore.utils.ConfigReader;
import generalstore.utils.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;

import static generalstore.utils.ReusableMethods.raporuAc;

public class Hooks {
        @BeforeAll
    public static void beforeAll() {
            Driver.serverBaslat(ConfigReader.getProperty("localIPAdres"), Integer.parseInt(ConfigReader.getProperty("localPort")));
    }
    @Before
    public void setUp() {
        Driver.getDriver().activateApp("com.androidsample.generalstore");
    }
    @After
    public void tearDown(Scenario scenario) {
            if(scenario.isFailed()){  //hata alirsa burasi calisir
                byte[] screenshotAs= Driver.getDriver().getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshotAs, "image/png", "Hata Resmi: ");
            }

        Driver.getDriver().terminateApp("com.androidsample.generalstore"); //hata almazsa burasi calisir

    }
    @AfterAll
    public static void afterAll() {
        Driver.uygulamayiKapat();
        Driver.serverKapat();
        raporuAc();

    }
}

/*
 @BeforeAll server i acarken kull, butun testlerden once acar, boylece zamandan kazaniriz, before da kullansaydik,
 her testten once acardi zaman kaybederdik
 @AfterAll server lapatirken, butun testleren sonra kapatir
 */

/*

calismasi icin hooks class adriver daki server baslatma metodunu koyduk

 @Before
    public void setUp(){
        Driver.serverBaslat(ConfigReader.getProperty("localIPAdres"), Integer.parseInt(ConfigReader.getProperty("localPort")));

    }
 */

//All   olanlar mutlaka static olmali hata aliriz yoksa