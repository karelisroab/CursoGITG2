package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePassword extends BaseClass {
    public ChangePassword(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    By locatorBtnCambiarContrasena = By.xpath("//a[contains(text(),'Cambiar Contrase')]");
    By locatorTxtEmail = By.xpath("//input[@id='edit-name']");
    By locatorBtnEnviar = By.xpath("//button[@id='edit-submit']");

    //Definir las acciones de la Página
    public void CambiarContrasena(String email){
        click(esperaExplicita(locatorBtnCambiarContrasena));
        agregarTexto(esperaExplicita(locatorTxtEmail),email);
        click(esperaExplicita(locatorBtnEnviar));
    }
}
