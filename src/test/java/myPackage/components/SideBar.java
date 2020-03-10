package myPackage.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import myPackage.pages.PuppyListPage;


public class SideBar {

  private final WebDriver driver;
  private By sidebarLocator = By.id("sidebar");
  private By homeButtonLocator = By.xpath("//*[@title=\"Home\"]");
  private By navlistLocator = By.id("navlist");


  public SideBar (WebDriver driver)
  {
    this.driver = driver;
  }

  public void clickHomeButton()
  {
    WebElement sidebar = driver.findElement(sidebarLocator);
    sidebar.findElement(homeButtonLocator).click();
  }

  private List<WebElement> getNavItems()
  {
    WebElement navlist = driver.findElement(navlistLocator);
    return navlist.findElements(By.tagName("a"));
  }

  public PuppyListPage clickAdoptAPuppy()
  {
    getNavItems().get(0).click();
    return new PuppyListPage(driver);
  }

  public void clickLearn()
  {
    getNavItems().get(1).click();
  }

  public void clickAnimalShelters()
  {
    getNavItems().get(2).click();
  }

  public void clickClassifieds()
  {
    getNavItems().get(3).click();
  }

  public void clickMessageBoards()
  {
    getNavItems().get(4).click();
  }

  public void clickPetNews()
  {
    getNavItems().get(5).click();
  }

}
