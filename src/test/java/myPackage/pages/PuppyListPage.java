package myPackage.pages;

import org.openqa.selenium.WebDriver;
import myPackage.components.SideBar;
import myPackage.components.PuppyList;


public class PuppyListPage {
  public SideBar sidebar;
  public PuppyList puppyList;


  public PuppyListPage (WebDriver driver)
  {
    this.sidebar = new SideBar(driver);
    this.puppyList = new PuppyList(driver);
  }

  // title = Home
}