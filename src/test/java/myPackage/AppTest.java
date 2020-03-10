package myPackage;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import myPackage.pages.PuppyListPage;
import myPackage.pages.PuppyDetailPage;
import myPackage.components.Puppy;



/**
 * Example unit tests for the puppy adoption agency.
 */
public class AppTest
{
    private WebDriver driver;
    private static String homepageURL = "http://puppies.herokuapp.com";
    private PuppyListPage puppyListPage;
    private PuppyDetailPage puppyDetailPage;


    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "E:\\Projects\\selenium-example\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(homepageURL);
        puppyListPage = new PuppyListPage(driver);
    }


    @Test
    public void verifyHomepageName()
    {
        assertTrue("\nHomepage title incorrect: " + driver.getTitle() + "\nExpected: Sally's Puppy Adoption Agency",
            driver.getTitle().equals("Sally's Puppy Adoption Agency"));
    }


    @Test
    public void ninePuppiesInTotal()
    {
        assertTrue("There are not 3 pages of puppies.",
            puppyListPage.puppyList.getNumberOfPages() == 3);

        assertTrue("1rst page does not contain 4 puppies", // 1rst page
            puppyListPage.puppyList.getNumberOfPuppies() == 4);

        puppyListPage.puppyList.clickNext(); // 2nd page
        assertTrue("2nd page does not contain 4 puppies",
            puppyListPage.puppyList.getNumberOfPuppies() == 4);

        puppyListPage.puppyList.clickPageNumber(3); // 3rd page
        assertTrue("2nd page does not contain 1 puppy",
            puppyListPage.puppyList.getNumberOfPuppies() == 1);
    }

    @Test
    public void verifyPuppyInformation()
    {
        Puppy puppy = puppyListPage.puppyList.getPuppy(0);
        assertTrue("First puppy should be named Brook.",
            puppy.getName().equals("Brook"));

        puppy = puppyListPage.puppyList.getPuppy(3);
        assertTrue("Fourth puppy should be a Pit Bull Terrier",
            puppy.getBreed().equals("Pit Bull Terrier"));

        puppyListPage.puppyList.clickPageNumber(2);
        puppy = puppyListPage.puppyList.getPuppy(1);
        assertTrue("6th puppy should be Spud, a male Beagle/Hound Mix",
            puppy.getName().equals("Spud") &&
            puppy.getSex().equals("Male") &&
            puppy.getBreed().equals("Beagle/Hound Mix")
        );
    }


    @Test
    public void verifyPuppyDetails()
    {
        puppyDetailPage = puppyListPage.puppyList.getPuppy(0).clickViewDetails();
        assertTrue("Brook should be the first puppy.",
            puppyDetailPage.details.getName().equals("Brook"));

        assertTrue("Brook should be a Female Golden Retriever.",
            puppyDetailPage.details.getSexAndBreed().equals("Female Golden Retriever"));

        assertTrue("Brook should cost $34.95.",
            puppyDetailPage.details.getFees().equals("The fees to adopt me are $34.95"));

        assertTrue("Brook's details are incorrect.",
            puppyDetailPage.details.getDescription().equals("This young lady is trying to put her shelter eperience behind her. She's only about 7 months old, and as you can see from her picture, she loves her toys!! Basically a blank slate as far as training, she'll fit into a new home very quickly."));
    }


    @After
    public void tearDown()
    {
        driver.close();
    }

}
