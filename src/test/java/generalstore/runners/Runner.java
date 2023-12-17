package generalstore.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:raporlar/CucumberRapor.html",
        features = "src/test/resources/features",
        glue = {"generalstore/stepdefs","generalstore/hooks"},
        tags = "",
        dryRun = false,
        monochrome = true
)
public class Runner {
}


/*@CucumberOptions( burda raporumuz için plugin oluşturuyoruz :class lar calismaya baslamadan once yuklenmesini istedigimiz dosyalari yaziyoruz bu kisma
monochrome = true, tek renk siyah verir terminalde raporu
dryRun = false ,//boş methodları alıp stepdefin içine koyabiliyoruz true yapınca
 */