package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EliminarApp extends BaseClass {
    public EliminarApp(WebDriver driver) {
        super(driver);
    }
    //Centralizar los localizadores
    By locatorBtnApp = By.xpath("//a[contains(text(),'PruebaCinco')]");//("//*[@id=\"pruebacinco-info\"]/td[1]/a");
    By locatorBtnBorrarApp = By.xpath("//a[contains(text(),'Delete')]");
    By locatorTxtNombreApp = By.xpath("//input[@id='edit-verification-code']");
    By locatorBtnBorrarAppDos = By.xpath("//button[@id='edit-submit']");

    //Definir las acciones de la Página
    public void borrarApp(String nombreApp) throws InterruptedException {
        click(esperaExplicita(locatorBtnApp));
        Thread.sleep(6000);
        click(esperaExplicita(locatorBtnBorrarApp));
        agregarTexto(esperaExplicita(locatorTxtNombreApp),nombreApp);
        Thread.sleep(6000);
        click(esperaExplicita(locatorBtnBorrarAppDos));
    }
}
