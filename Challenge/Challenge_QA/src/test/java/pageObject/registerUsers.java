package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.util;


public class registerUsers extends util {

    @FindBy(css = "[id='sign-username']") private WebElement tbxemail;
    @FindBy(css = "[id='sign-password']") private WebElement txbpassword;
    @FindBy(xpath = "//label[contains(text(),'SAVED')]") private WebElement lblConfirmacion;
    @FindBy(xpath = "//label[contains(text(),'INVALID')]") private WebElement lblinvalido;
    @FindBy(xpath = "//label[contains(text(),'REQUIRED')]") private WebElement lblNoNull;
    @FindBy(css = "[onclick='register()']") private WebElement btnRegister;
    @FindBy(css = "[id='signin2']") private WebElement btnSingUp;
    @FindBy(css = "[id='signInModalLabel']") private WebElement lblSingUp;



    public registerUsers(WebDriver driver){

        PageFactory.initElements(driver,this);

    }

    public void clickBtnSingUp(){
        wait.until(ExpectedConditions.visibilityOf(btnSingUp));
        btnSingUp.click();
    }
    public void writingUser(String user,String password){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.visibilityOf(lblSingUp));
        //btnRegister.click();
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
    public void clickBtnRegister(){
        wait.until(ExpectedConditions.visibilityOf(btnRegister));
        btnRegister.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void validateRegister(){
        driver.switchTo().alert().accept();
    }
    public void validateRegisterInvalid(){


            if (lblinvalido.isDisplayed()) {
                System.out.println("Error..! Datos incorrectos");
            }else {

                System.out.println("Error..! Inesperado");
                }
            }
    public void validateRegisterNull(){


                if (lblNoNull.isDisplayed()) {
                    System.out.println("Error..! Datos requeridos");
                }else{
                    System.out.println("Error..! Inesperado");
                }


    }

}
