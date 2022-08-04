package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Contactanos extends BaseClass {
    public Contactanos(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    By locatorBtnContactanos = By.xpath("//header/div[2]/div[1]/a[1]");
    By locatorTxtNombre = By.xpath("//input[@id='edit-nombre-de-empresa']");
    By locatorTxtCorreo = By.xpath("//input[@id='edit-email']");
    By localorCategoria = By.xpath("//select[@id='edit-categoria']");
    By localorMensaje = By.xpath("//input[@id='edit-mensaje']");
    By locatorBtnEnviar = By.xpath("//button[@id='edit-actions-submit']");

    //Definir las acciones de la Página
    public void contactanos(String nombre, String email, String categoria, String mensaje){
        click(esperaExplicita(locatorBtnContactanos));
        agregarTexto(esperaExplicita(locatorTxtNombre),nombre);
        agregarTexto(esperaExplicita(locatorTxtCorreo),email);
        WebElement Categoria = driver.findElement(localorCategoria);
        Categoria.sendKeys(categoria);
        agregarTexto(esperaExplicita(localorMensaje),mensaje);
        click(esperaExplicita(locatorBtnEnviar));

    }
}
