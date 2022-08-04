package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFallido extends BaseClass {
    public LoginFallido(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    By locatorTxtMensajeError = By.xpath("//h2[contains(text(),'Mensaje de error')]");

    //Definir las acciones de la Página
    public String obtenerLabelErrorAuth(){
        return obtenerTexto(esperaExplicita(locatorTxtMensajeError));
    }
}
