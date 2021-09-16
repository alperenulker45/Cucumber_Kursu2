package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Aşağıdaki seçenekde tags eklendi içinde grup adına
 * sahip senaryolar çalıştıralacak sadece tüm senaryolardan
 * tags etiketi sınırlama yaptı sadece bu etikete veya grup adına sahip
 * olanlar çalışacak
 *
 *
 *  SmokeTest : En genel manada ana unsurları test etmek
 *  RegressionTest : Bütün birimleri uyumlu şekilde çalışma test etme
 *
 */
@CucumberOptions(
        tags = {"@SmokeTest"},
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},

        plugin = { //basit rapor oluşturan plugin: Jenkins için eklendi
        "html:target/cucumber-report",
        "json:target/cucumber.json",
}

)
public class _03_TestRunnerSmoke extends AbstractTestNGCucumberTests {

}
