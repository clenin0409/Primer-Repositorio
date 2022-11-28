package support;


import definitions.hook;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class util  extends hook {

    public static WebDriverWait wait;

    public util() {
        wait = new WebDriverWait(driver,40);
    }

    public void ventanaActiva(){
        Set<String> identificadores = hook.driver.getWindowHandles();
        for (String identificador:identificadores) {
            hook.driver.switchTo().window(identificador);
        }
    }
    public void ventanaInicial(){
        hook.driver.close();
        hook.driver.switchTo().window("");
    }
}
