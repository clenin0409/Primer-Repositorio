package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;


public class login extends util {

    String product;

    @FindBy(css = "[id='loginusername']") private WebElement tbxemail;
    @FindBy(css = "[id='loginpassword']") private WebElement txbpassword;
    @FindBy(xpath = "//label[contains(text(),'LOGIN VALID')]") private WebElement lblConfirmacion;
    @FindBy(xpath = "//label[contains(text(),'REQUIRED')]") private WebElement lblNoNull;
    @FindBy(css = "[onclick='logIn()']") private WebElement btnLogin;
    @FindBy(css = "[id='logInModalLabel']") private WebElement lblLogin;
    @FindBy(css = "[id='login2']") private WebElement btnLog_in;
    @FindBy(css = "[id='logout2']") private WebElement btnLogOut;




    public login(WebDriver driver){

        PageFactory.initElements(driver,this);

    }
    public void timeOUT(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickBtnLog_in(){
        wait.until(ExpectedConditions.visibilityOf(btnLog_in));
        btnLog_in.click();
    }
    public void setUser(String user,String password){
        timeOUT();
        wait.until(ExpectedConditions.visibilityOf(lblLogin));
        if(user.contains("@") && user.length()>=5)
        {
            tbxemail.sendKeys(user);
        }
        else
        {
            tbxemail.sendKeys(user);
            System.out.println("Error...! Email debe tener como minimo 5 caracteres y @");
        }
        ;
        if (password.length()>=5){
            txbpassword.sendKeys(password);
        }else{
            txbpassword.sendKeys(password);
            System.out.println("Error...! Contraseña debe tener como minimo 5 caracteres");
        }



    }
    public void clickBtnLogin(){
        btnLogin.click();
    }
    public void validateLogin(String user){
        timeOUT();
        if (driver.findElement(By.xpath("//a[contains(text(),'Welcome "+user+"')]")).isDisplayed()){
            System.out.println("Se realizo registro correctamente");
        }else {
            if (lblNoNull.isDisplayed()) {
                System.out.println("Error..! Datos requeridos");
            }
        }
    }
    public void clickLogOut(){
        wait.until(ExpectedConditions.visibilityOf(btnLogOut));
        btnLogOut.click();
    }
    public void validateLogOut(){
            if (btnLog_in.isDisplayed()) {
                System.out.println("Cierre de sesion Exitoso..!");
            }
        }
        public void clickLaptops(){
            timeOUT();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Laptops')]"))));
            driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
        }
        public void addLaptop(){
            timeOUT();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='tbodyid']/div[1]/div/a"))));
            product = driver.findElement(By.xpath("//div[@id='tbodyid']/div[1]/div/div//a")).getText();
            driver.findElement(By.xpath("//div[@id='tbodyid']/div[1]/div/a")).click();
            timeOUT();
            driver.findElement(By.cssSelector("[onclick='addToCart(8)']")).click();
            timeOUT();
            driver.switchTo().alert().accept();
            timeOUT();
        }
        public void verifyInCart(){
            timeOUT();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[id='cartur']"))));
            driver.findElement(By.cssSelector("[id='cartur']")).click();
            timeOUT();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tbody[@id='tbodyid']"))));
            product.equals(driver.findElement(By.xpath("//tbody[@id='tbodyid']/tr[1]//td[2]")).getText());
        }
}

