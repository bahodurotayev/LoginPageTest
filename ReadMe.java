import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class ReadMe extends Driver {
    /*
    NOTE: Create your own account in the website in manual part
    Navigate to website http://a.testaddressbook.com/sign_in
    Click on sign up button
    Automation part
*/
    public static void main(String[] args) throws InterruptedException {
       // Navigate to http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");

       // Enter the username and password
        logIn("ny_techno@study.com ","techno_study");

        //Click on sign in button
        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("a[data-test='create']")).click();
        Thread.sleep(2000);

        //Enter the first name "Fernando"
        WebElement address_first_name = driver.findElement(By.id("address_first_name"));
        address_first_name.sendKeys("Fernando");
        Thread.sleep(2000);

        //Enter the last name  "Torres"
        WebElement address_last_name = driver.findElement(By.cssSelector("input[id='address_last_name']"));
        address_last_name.sendKeys("Torres");

        //Enter the address 1 "Anfield Rd"
        WebElement address = driver.findElement(By.id("address_street_address"));
        address.sendKeys("Anfield Rd");

        //Enter the address 2 "Anfield"
        WebElement address2 = driver.findElement(By.id("address_secondary_address"));
        address2.sendKeys("Anfield");

        //Enter the city "Liverpool"
        WebElement address_city = driver.findElement(By.id("address_city"));
        address_city.sendKeys("Liverpool");


        //Choose the random option from the state dropdown
        WebElement address_state = driver.findElement(By.id("address_state"));
        Select selectState = new Select(address_state);
        List<WebElement> stateList = selectState.getOptions();
        Random input = new Random();
        int randomInput = input.nextInt(stateList.size());
        selectState.selectByIndex(randomInput);

        //Enter the Zipcode "L4 0TH"
        WebElement zipCode = driver.findElement(By.id("address_zip_code"));
        zipCode.sendKeys("L4 0TH");

        //Click on United States
        driver.findElement(By.id("address_country_us")).click();

        //Enter the birthday "03/20/1984"
        WebElement address_birthday = driver.findElement(By.id("address_birthday"));
        address_birthday.sendKeys("03/20/1984");

        //Enter the age "36"
        WebElement address_age = driver.findElement(By.id("address_age"));
        address_age.sendKeys("36");

        //Enter the WebSite "https://www.google.com/"
        WebElement address_website = driver.findElement(By.id("address_website"));
        address_website.sendKeys("https://www.google.com/");

        //Enter the phone "8625747878"
        WebElement address_phone = driver.findElement(By.id("address_phone"));
        address_phone.sendKeys("8625747878");

        //Click on Climbing and Dancing
        driver.findElement(By.id("address_interest_climb")).click();
        driver.findElement(By.id("address_interest_dance")).click();

        //Enter the Note "Never Back Down"
        WebElement address_note = driver.findElement(By.id("address_note"));
        address_note.sendKeys("Never Back Down");

        //Click on Create Address button
        driver.findElement(By.cssSelector(" input[value='Create Address']")).click();

        //Verify the first name as "Fernando"
        String getName = driver.findElement(By.cssSelector("span[data-test='first_name']")).getText();
        Assert.assertEquals("Fernando", getName);

        //Verify the last name as "Torres"
        String getLast = driver.findElement(By.cssSelector("span[data-test='last_name']")).getText();
        Assert.assertEquals("Torres", getLast);


        //Click on Edit button
        driver.findElement(By.cssSelector("a[data-test='edit']")).click();
        Thread.sleep(2000);

        //Change the first name as "Peter"
        WebElement newName = driver.findElement(By.id("address_first_name"));
        newName.clear();
        String newNameString = "Peter";
        newName.sendKeys(newNameString);
        Thread.sleep(2000);

        //Change the last name as "Crouch"
        WebElement newLast = driver.findElement(By.id("address_last_name"));
        newLast.clear();
        String newLastSrring = "Crouch";
        newLast.sendKeys(newLastSrring);
        Thread.sleep(2000);

        //Click on Update address
        driver.findElement(By.cssSelector("input[value='Update Address']")).click();

        //Verify the first name as "Peter"
        String getNewName = driver.findElement(By.cssSelector("span[data-test='first_name']")).getText();
        Assert.assertEquals(newNameString, getNewName);

        //Verify the Last name as "Crouch"
        String getNewLast = driver.findElement(By.cssSelector("span[data-test='last_name']")).getText();
        Assert.assertEquals(newLastSrring, getNewLast);

        // Click on Addresses
        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();
        Thread.sleep(2000);

        //Click on Destroy
        driver.findElement(By.xpath("//a[text()='Destroy']")).click();

        //Alert
        driver.switchTo().alert().accept();
    }

    private static void logIn(String username, String password) {
        driver.findElement(By.cssSelector("#session_email")).sendKeys(username);
        driver.findElement(By.cssSelector("#session_password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }
}
