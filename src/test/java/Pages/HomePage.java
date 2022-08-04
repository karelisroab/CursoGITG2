package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass {
    public HomePage(WebDriver driver) {
        super(driver);
    }

        //Centralizar los localizadores
        By locatorBtnIngresar = By.xpath("//a[contains(text(),'Iniciar Sesi')]");
        By locatorBtnIngles = By.xpath("//a[contains(text(),'ENG')]");
        By locatorBtnSoporte = By.xpath("//a[contains(text(),'Soporte')]");
        By locatorBtnGuia = By.xpath("//a[contains(text(),'Guia de inicio')]");

        //Definir las acciones de la Página
        public void ingresar(){
            click(esperaExplicita(locatorBtnIngresar));
        }
        public void cambiarIdioma(){
            click(esperaExplicita(locatorBtnIngles));

        }

        public void soporte(){
            click(esperaExplicita(locatorBtnSoporte));
        }

        public void guiaInicio(){
            click(esperaExplicita(locatorBtnGuia));
        }


}
