package myPackage.pages;

import org.openqa.selenium.WebDriver;
import myPackage.components.SideBar;
import myPackage.components.PuppyDetails;

public class PuppyDetailPage {
  public SideBar sidebar;
  public PuppyDetails details;


  public PuppyDetailPage (WebDriver driver)
  {
    this.sidebar = new SideBar(driver);
    this.details = new PuppyDetails(driver);
  }
}
