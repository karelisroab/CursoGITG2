package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CrearApp extends BaseClass {
    public CrearApp(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    By locatorBtnCrearApp = By.xpath("//a[contains(text(),'CREAR APLICACI')]");
    By locatorBtnEntendido = By.xpath("//a[contains(text(),'ENTENDIDO')]");
    By locatorTxtNombreApp = By.xpath("//input[@id='edit-displayname-0-value']");
    By locatorTxtUrlApp = By.xpath("//input[@id='edit-callbackurl-0-value']");
    By locatorTxtDescripcion = By.xpath("//textarea[@id='edit-description-0-value']");
    By locatorTxtTPPID = By.xpath("//input[@id='edit-field-tppid-0-value']");
    By locatorTxtPublicKey = By.xpath("//input[@id='edit-field-publickey-0-value']");
    By locatorBtnRewardsSanbox = By.xpath("//label[contains(text(),'Rewards Sandbox')]");
    By locatorBtnCrear = By.xpath("//button[@id='edit-actions-submit']");

    //Definir las acciones de la Página
    public void crearApp(String nombre, String url, String descripcion, String tppid, String key) throws InterruptedException {
        click(esperaExplicita(locatorBtnCrearApp));
        Thread.sleep(6000);
        click(esperaExplicita(locatorBtnEntendido));
        agregarTexto(esperaExplicita(locatorTxtNombreApp),nombre);
        Thread.sleep(6000);
        agregarTexto(esperaExplicita(locatorTxtUrlApp),url);
        agregarTexto(esperaExplicita(locatorTxtDescripcion),descripcion);
        agregarTexto(esperaExplicita(locatorTxtTPPID),tppid);
        agregarTexto(esperaExplicita(locatorTxtPublicKey),key);
        click(esperaExplicita(locatorBtnRewardsSanbox));
        click(esperaExplicita(locatorBtnCrear));
    }



}
