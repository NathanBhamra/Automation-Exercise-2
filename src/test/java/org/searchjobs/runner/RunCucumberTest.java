package org.searchjobs.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "org.searchjobs/features/",
        glue = {"org.searchjobs.stepdefs"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
class TestRunner {
}
