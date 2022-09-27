package com.ImmFLY.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public interface ShortCuts {
    WebDriverWait wait=new WebDriverWait(Driver.get(),40);
    Actions action=new Actions(Driver.get());

    public default void isClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public default void isClickable(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public default void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public default void writeText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(text);
    }

    public default void pressEnter(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(Keys.ENTER);
    }

    public default void waitForTitle(String title){
        wait.until(ExpectedConditions.titleContains(title));
    }

    public default String titleReceiver(){
        return Driver.get().getTitle();
    }

    public default void hoverOverElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        action.moveToElement(element).perform();
    }

    public default void staticWait(int secNumber) {
        try {
            Thread.sleep(secNumber * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public default String readText(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public default boolean isDisplayed(By element){
        return Driver.get().findElement(element).isDisplayed();
    }


    public default boolean invisibilityOf(WebElement element){
      return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public default String urlReturn(String urlContains){
        wait.until(ExpectedConditions.urlContains(urlContains));
        return Driver.get().getCurrentUrl();
    }

    public default void jseClick(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("arguments[0].click();", element);
    }

    public default WebElement receiveElementByText(String text){
         WebElement element=Driver.get().findElement(By.xpath("//*[text()='"+text+"']"));
         return element;
    }
    public default WebElement receiveElementByPartialText(String text){
        WebElement element=Driver.get().findElement(By.xpath("//*[contains(text(),'"+text+"')]"));
        return element;
    }

    public default boolean urlContainsBoolean(String urlPart){
       return wait.until(ExpectedConditions.urlContains(urlPart));
    }
}
