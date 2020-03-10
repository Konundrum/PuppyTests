package myPackage.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class PuppyList
{
  private WebDriver driver;
  private By contentLocator = By.id("content");
  private By paginationLocator = By.className("pagination");
  private By previousLocator = By.className("previous_page");
  private By nextLocator = By.className("next_page");
  private By currentLocator = By.className("current");
  private By puppyLocator = By.className("puppy_list");

  public PuppyList(WebDriver driver)
  {
    this.driver = driver;
  }


  public int getNumberOfPuppies()
  {
    WebElement content = driver.findElement(contentLocator);
    List<WebElement> puppies = content.findElements(puppyLocator);
    return puppies.size();
  }

  public Puppy getPuppy(int index)
  {
    WebElement content = driver.findElement(contentLocator);
    List<WebElement> puppies = content.findElements(puppyLocator);
    return new Puppy(driver, puppies.get(index));
  }


  public void clickNext()
  {
    WebElement content = driver.findElement(contentLocator);
    WebElement pagination = content.findElement(paginationLocator);
    WebElement nextLink = pagination.findElement(nextLocator);
    nextLink.click();
  }

  public void clickPrevious()
  {
    WebElement content = driver.findElement(contentLocator);
    WebElement pagination = content.findElement(paginationLocator);
    WebElement previousLink = pagination.findElement(previousLocator);
    previousLink.click();
  }

  public void clickPageNumber(int number)
  {
    WebElement content = driver.findElement(contentLocator);
    WebElement pagination = content.findElement(paginationLocator);
    WebElement pageLink = pagination.findElement(By.linkText(String.valueOf(number)));
    pageLink.click();
  }

  public int getNumberOfPages()
  {
    WebElement content = driver.findElement(contentLocator);
    WebElement pagination = content.findElement(paginationLocator);
    List<WebElement> paginationChildren = pagination.findElements(By.xpath("./*"));
    return paginationChildren.size() - 2;
  }

  public int getCurrentPage()
  {
    WebElement content = driver.findElement(contentLocator);
    WebElement pagination = content.findElement(paginationLocator);
    WebElement current = pagination.findElement(currentLocator);
    return Integer.parseInt(current.getText());
  }

}
