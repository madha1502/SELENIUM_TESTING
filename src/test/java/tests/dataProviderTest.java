package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderTest {
    @Test
    public void loginTest() throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Title : "+driver.getTitle());
        Thread.sleep(5000);
        //driver.quit();
    }
    @Test(dataProvider = "loginDataTest")
    public void credential(String userName,String Password) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(Password);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
    }
    @DataProvider(name = "loginDataTest")
    public Object[][] loginData(){
        Object[][] data = new Object[2][2];
        data[0][0] = "Admin";
        data[0][1] = "admin123";
        data[1][0] = "Admin";
        data[1][1] = "admin";
        return data;
    }

    //By using the 2-Dimensional Object Array
    @Test(dataProvider = "Object2Test")
    public void Object2(Object[] s) throws Exception{
        for(int i=0;i<s.length;i++){
            System.out.print(s[i]+">>>");
        }
    }
    @DataProvider(name = "Object2Test")
    public Object[][] Object2Data(){
        Object[][] data = new Object[][]{
            {"Admin","admin123"},
            {"Admin","admin"}
        };
        return data;
    }

    //By using 1-Dimensional Array
    @Test(dataProvider = "Object1Test")
    public void Object1(Object[] s) throws Exception{
        System.out.println(s[0]+"--->"+s[1]);
    }
    @DataProvider(name = "Object1Test")
    public Object[] Object1Data(){
        Object[][] data = new Object[][]{
                {"Admin","admin123"},
                {"Admin","admin"}
        };
        return data;
    }

}
