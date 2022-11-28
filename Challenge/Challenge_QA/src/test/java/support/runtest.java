package support;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features",
tags = "@Pruebas_Automatizadas",
glue ="definitions",
//plugin = {"json:target/cucumber-report/cucumber.json"})
 plugin = {"html:target/cucumber-report/index.html"})
public class runtest {
}
