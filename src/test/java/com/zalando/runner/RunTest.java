package com.zalando.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty","json:target/cucumberreports.json"},
glue = "com.zalando", 
features = "src\\test\\resources\\features",
dryRun = false,

tags={"@zalando"},
monochrome = false)
public class RunTest {
};
