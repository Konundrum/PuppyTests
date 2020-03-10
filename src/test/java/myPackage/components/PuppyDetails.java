package myPackage.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import myPackage.pages.PuppyListPage;


public class PuppyDetails {
  private WebDriver driver;
  private By contentLocator = By.id("content");
  private By nameLocator = By.xpath("./div/h2");
  private By sexAndBreedLocator = By.xpath("./div/h3");
  private By descriptionLocator = By.xpath("./div/p");
  private By feesLocator = By.className("fees");
  private By returnToListLocator = By.linkText("Return to List");

  public PuppyDetails(WebDriver driver)
  {
    this.driver = driver;
  }

  public String getName()
  {
    return driver.findElement(contentLocator).findElement(nameLocator).getText();
  }

  public String getSexAndBreed()
  {
    return driver.findElement(contentLocator).findElement(sexAndBreedLocator).getText();
  }

  public String getDescription()
  {
    return driver.findElement(contentLocator).findElement(descriptionLocator).getText();
  }

  public String getFees()
  {
   return driver.findElement(contentLocator).findElement(feesLocator).getText();
  }

  public PuppyListPage clickReturnToList()
  {
    driver.findElement(contentLocator).findElement(returnToListLocator).click();
    return new PuppyListPage(driver);
  }
}
