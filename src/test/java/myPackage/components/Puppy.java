package myPackage.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import myPackage.pages.PuppyDetailPage;


public class Puppy
{
  private WebDriver driver;
  private WebElement puppy;
  private By nameLocator = By.className("name");
  private By detailsLocator = By.className("details");
  private By viewDetailsLocator = By.className("view");


  public Puppy(WebDriver driver, WebElement puppy)
  {
    this.driver = driver;
    this.puppy = puppy;
  }

  public String getName()
  {
    WebElement name = puppy.findElement(nameLocator);
    return name.getText();
  }

  public String getBreed()
  {
    WebElement details = puppy.findElement(detailsLocator);
    WebElement breed = details.findElement(By.xpath("./h4[1]"));
    return breed.getText();
  }

  public String getSex()
  {
    WebElement details = puppy.findElement(detailsLocator);
    WebElement sex = details.findElement(By.xpath("./h4[2]"));
    return sex.getText();
  }

  public PuppyDetailPage clickViewDetails()
  {
    WebElement viewDetails = puppy.findElement(viewDetailsLocator);
    WebElement button = viewDetails.findElement(By.tagName("input"));
    button.click();
    return new PuppyDetailPage(driver);
  }
}
