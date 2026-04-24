package com.example.api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        features = "src/test/resources/features",
        glue = "com.example.api.steps",
        plugin = {
                "pretty",
                "summary",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        monochrome = true
)
public class TestRunner {
}
