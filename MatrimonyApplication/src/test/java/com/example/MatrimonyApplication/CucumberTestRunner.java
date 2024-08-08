package com.example.MatrimonyApplication;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // Path to feature files
        glue = "com.example.matrimony.stepdefinitions",  // Path to step definitions
        plugin = {"pretty", "html:target/cucumber-reports"},  // Output format and reports
        tags = "@api"  // Tags to filter scenarios to run
)
public class CucumberTestRunner {
}