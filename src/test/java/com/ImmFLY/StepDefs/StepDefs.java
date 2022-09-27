package com.ImmFLY.StepDefs;

import com.ImmFLY.Pages.HomePage;
import com.ImmFLY.Utilities.ShortCuts;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class StepDefs implements ShortCuts {
    Select select;
    HomePage homePage=new HomePage();


    @Given("The user is on the {string} page")
    public void the_user_is_on_the_page(String title) {
        Assert.assertTrue(titleReceiver().contains(title));
    }

    @Then("The first time the page is sorted by {string}")
    public void the_first_time_the_page_is_sorted_by(String sortBy) {
        isClickable(homePage.sortButton);
        select=new Select(homePage.sortButton);
        String actualButton=select.getFirstSelectedOption().getText().trim();
        Assert.assertEquals(sortBy,actualButton);
    }
}
