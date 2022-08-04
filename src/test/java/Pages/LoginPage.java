package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseClass {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    By locatorTxtNombreUsuario = By.id("edit-name");
    By locatorTxtConrasena = By.id("edit-pass");
    By locatorBtnIniciarSesion = By.id("edit-submit");

    //Definir las acciones de la Página
    public void login(String user, String pass){
        agregarTexto(esperaExplicita(locatorTxtNombreUsuario),user);
        agregarTexto(esperaExplicita(locatorTxtConrasena),pass);
        click(esperaExplicita(locatorBtnIniciarSesion));
    }




}
