package com.ImmFLY.StepDefs;



import com.ImmFLY.Utilities.ConfigurationReader;
import com.ImmFLY.Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    WebDriver driver= Driver.get();
    @Before
    public void beforeMethod(){

        driver.get(ConfigurationReader.getValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @After
    public void After(Scenario scenario){
        if (scenario.isFailed()){

            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            //Down Casting
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }

}
