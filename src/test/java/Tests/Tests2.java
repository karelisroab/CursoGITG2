package Tests;

import Pages.*;
import Utils.DataDriven;
import Utils.PropertiesDriven;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.ArrayList;

public class Tests2 {

    //Atributos
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ChangePassword changePassword;
    private Contactanos contactanos;
    private CrearApp crearApp;
    private EliminarApp eliminarApp;
    private String url;
    private ArrayList<String> dataCP;
    private String browser;
    private String propertyDriver;
    private String rutaDriver;
    private LoginFallido loginFallido;

    //Métodos
    @BeforeTest
    public void preparacion(){

        browser = PropertiesDriven.getProperty("browser");;
        propertyDriver = PropertiesDriven.getProperty("propertyDriver");
        rutaDriver = Paths.get(System.getProperty("user.dir"),PropertiesDriven.getProperty("rutaDriver")).toString();

    }

    @BeforeMethod
    public void preTest() {
        homePage = new HomePage(driver);
        homePage.conexionDriver(browser,rutaDriver,propertyDriver);
        loginPage = new LoginPage(homePage.getDriver());
        loginFallido = new LoginFallido(homePage.getDriver());
        changePassword = new ChangePassword(homePage.getDriver());
        contactanos = new Contactanos(homePage.getDriver());
        crearApp = new CrearApp(homePage.getDriver());
        eliminarApp = new EliminarApp(homePage.getDriver());
        dataCP = new ArrayList<>();

        url = PropertiesDriven.getProperty("url");
        homePage.cargarSitio(url);
        homePage.maximizarBrowser();

    }

    @Test
    public void CP001_Login_Exitoso(){
        dataCP = DataDriven.getData("CP001_Login_Exitoso");
        homePage.ingresar();
        loginPage.esperarXSegundos(2000);
        loginPage.login(dataCP.get(1), dataCP.get(2));
        loginPage.esperarXSegundos(1000);
        Assert.assertEquals(loginPage.obtenerUrlPagina(),dataCP.get(3));

    }



    @Test
    public void CP002_Cambiar_Contrasena(){
        dataCP = DataDriven.getData("CP002_Cambiar_Contrasena");
        homePage.ingresar();
        changePassword.CambiarContrasena(dataCP.get(1));
        Assert.assertEquals(changePassword.obtenerUrlPagina(),dataCP.get(2));

    }

    @Test
    public void CP003_Cambiar_Idioma_Pagina(){
        dataCP = DataDriven.getData("CP003_Cambiar_Idioma_Pagina");
        homePage.cambiarIdioma();
        Assert.assertEquals(homePage.obtenerUrlPagina(),dataCP.get(1));

    }

    @Test
    public void CP004_Contactanos() throws InterruptedException {
        dataCP = DataDriven.getData("CP004_Contactanos");
        homePage.soporte();
        contactanos.contactanos(dataCP.get(1), dataCP.get(2), dataCP.get(3), dataCP.get(4));
        Assert.assertEquals(contactanos.obtenerTituloPagina(),dataCP.get(5));
        Thread.sleep(6000);

    }

    @Test
    public void CP005_Login_Fallido() {
        dataCP = DataDriven.getData("CP005_Login_Fallido");
        homePage.ingresar();
        loginPage.esperarXSegundos(2000);
        loginPage.login(dataCP.get(1), dataCP.get(2));
        loginPage.esperarXSegundos(1000);
        Assert.assertEquals(loginFallido.obtenerLabelErrorAuth(),dataCP.get(3));

    }

    @Test
    public void CP006_Guia_Inicio() throws InterruptedException {
        dataCP = DataDriven.getData("CP006_Guia_Inicio");
        homePage.guiaInicio();
        Assert.assertEquals(homePage.obtenerUrlPagina(),dataCP.get(1));
        Thread.sleep(6000);

    }

    @Test
    public void CP007_Crear_App() throws InterruptedException {
        dataCP = DataDriven.getData("CP007_Crear_App");
        homePage.ingresar();
        loginPage.login(dataCP.get(1), dataCP.get(2));
        crearApp.crearApp(dataCP.get(3), dataCP.get(4), dataCP.get(5), dataCP.get(6), dataCP.get(7));
        Assert.assertEquals(crearApp.obtenerUrlPagina(),dataCP.get(8));
        Thread.sleep(8000);

    }

    @Test
    public void CP008_Borrar_App() throws InterruptedException {
        dataCP = DataDriven.getData("CP008_Borrar_App");
        homePage.ingresar();
        loginPage.login(dataCP.get(1), dataCP.get(2));
        eliminarApp.borrarApp(dataCP.get(3));
        Assert.assertEquals(eliminarApp.obtenerUrlPagina(),dataCP.get(4));
        Thread.sleep(8000);


    }

    @AfterMethod
    public void postTests(){
        loginPage.cerrarBrowser();

    }


}
