import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseDriver;

import java.util.List;
import java.util.Random;

public class ReadMe extends BaseDriver {
    /*
    NOTE: Create your own account in the website in manual part
    Navigate to website http://a.testaddressbook.com/sign_in
    Click on sign up button
    Automation part
        Navigate to http://a.testaddressbook.com/sign_in
        Enter the username and password
        Click on sign in button
        Click on Addresses
        Click on new address button
        Enter the first name "Fernando"
        Enter the last name  "Torres"
        Enter the address 1 "Anfield Rd"
        Enter the address 2 "Anfield"
        Enter the city "Liverpool"
        Choose the random option from the state dropdown
        Enter the Zipcode "L4 0TH"
        Click on United States
        Enter the birthday "03/20/1984"
        Enter the age "36"
        Enter the WebSite "https://www.google.com/"
        Enter the phone "8625747878"
        Click on Climbing and Dancing
        Enter the Note "Never Back Down"
        Click on Create Address button
        Verify the first name as "Fernando"
        Verify the last name as "Torres"
        Click on Addresses
        Click on Edit button
        Change the first name as "Peter"
        Change the last name as "Crouch"
        Click on Update address
        Verify the first name as "Peter"
        Verify the last name as "Crouch"
        Click on Addresses
        Click on Destroy
        Address should be removed
     */
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://a.testaddressbook.com/sign_in");

        logIn("ny_techno@study.com ","techno_study");

        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("a[data-test='create']")).click();
        Thread.sleep(2000);

        WebElement address_first_name = driver.findElement(By.id("address_first_name"));
        address_first_name.sendKeys("Fernando");
        Thread.sleep(2000);

        WebElement address_last_name = driver.findElement(By.cssSelector("input[id='address_last_name']"));
        address_last_name.sendKeys("Torres");

        WebElement address = driver.findElement(By.id("address_street_address"));
        address.sendKeys("Anfield Rd");

        WebElement address2 = driver.findElement(By.id("address_secondary_address"));
        address2.sendKeys("Anfield");

        WebElement address_city = driver.findElement(By.id("address_city"));
        address_city.sendKeys("Liverpool");


        WebElement address_state = driver.findElement(By.id("address_state"));
        Select selectState = new Select(address_state);
        List<WebElement> stateList = selectState.getOptions();
        Random input = new Random();
        int randomInput = input.nextInt(stateList.size());
        selectState.selectByIndex(randomInput);


        WebElement zipCode = driver.findElement(By.id("address_zip_code"));
        zipCode.sendKeys("L4 0TH");

        driver.findElement(By.id("address_country_us")).click();

        WebElement address_birthday = driver.findElement(By.id("address_birthday"));
        address_birthday.sendKeys("03/20/1984");

        WebElement address_age = driver.findElement(By.id("address_age"));
        address_age.sendKeys("36");

        WebElement address_website = driver.findElement(By.id("address_website"));
        address_website.sendKeys("https://www.google.com/");

        WebElement address_phone = driver.findElement(By.id("address_phone"));
        address_phone.sendKeys("8625747878");

        driver.findElement(By.id("address_interest_climb")).click();
        driver.findElement(By.id("address_interest_dance")).click();

        WebElement address_note = driver.findElement(By.id("address_note"));
        address_note.sendKeys("Never Back Down");

        driver.findElement(By.cssSelector(" input[value='Create Address']")).click();

        String getName = driver.findElement(By.cssSelector("span[data-test='first_name']")).getText();
        String getLast = driver.findElement(By.cssSelector("span[data-test='last_name']")).getText();



        Assert.assertEquals("Fernando", getName);
        Assert.assertEquals("Torres", getLast);

        driver.findElement(By.cssSelector("a[data-test='edit']")).click();

        Thread.sleep(2000);
        WebElement newName = driver.findElement(By.id("address_first_name"));
        newName.clear();
        String newNameString = "Peter";
        newName.sendKeys(newNameString);

        Thread.sleep(2000);

        WebElement newLast = driver.findElement(By.id("address_last_name"));
        newLast.clear();
        String newLastSrring = "Crouch";
        newLast.sendKeys(newLastSrring);

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input[value='Update Address']")).click();

        String getNewName = driver.findElement(By.cssSelector("span[data-test='first_name']")).getText();
        String getNewLast = driver.findElement(By.cssSelector("span[data-test='last_name']")).getText();

        Assert.assertEquals(newNameString, getNewName);
        Assert.assertEquals(newLastSrring, getNewLast);

        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Destroy']")).click();

        driver.switchTo().alert().accept();


    }

    private static void logIn(String username, String password) {
        driver.findElement(By.cssSelector("#session_email")).sendKeys(username);
        driver.findElement(By.cssSelector("#session_password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }


}
