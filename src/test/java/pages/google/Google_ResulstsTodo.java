package pages.google;

import config.Log;
import config.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webElements.ObjectsGoogle;

public class Google_ResulstsTodo extends WebActions {

    /**
     * Podemos dos opciones:
     * - Inicializar el driver aqui en la clase hija con: this.driver = driver;
     * Entonces no haría falta tenerlo inicializado en el padre WebActions, valdría con un super()
     *
     * - Si no inicializamos el driver aqui y usamos super()
     * Entonces tendremos que inicializar el driver en la clase padre con this.driver = driver
     * */

    ObjectsGoogle objGoogle;
    public Google_ResulstsTodo(WebDriver driver) {
        //this.driver = driver;
        super(driver);
        objGoogle = new ObjectsGoogle(driver);
    }

    public void assertSearchResult(){
        try{
            waitSecs(2);
            waitForVisibility(objGoogle.NAV_RESULTS);
            for (WebElement cites: objGoogle.ALL_CITE_SITES){
                scrollTo(cites);
                waitForVisibility(cites);
            }
            Log.register("[OK]: We have reached the results Google Search page :)");
        }catch (Exception e){
            Log.register("[ERROR]: Aceptando las Cookies " + Google_SearchEngine.class + e.getStackTrace());
        }
    }

    public void printResultsUrlsOnPage(){
        waitSecs(1);
        scrollTop();
        try{
            waitForVisibility(objGoogle.NAV_RESULTS);
            for (WebElement cites: objGoogle.ALL_CITE_SITES){
                scrollTo(cites);
                Log.register("[OK]: URL's founded: " + cites.getText());
                waitForVisibility(cites);
            }
        }catch (Exception e){
            Log.register("[ERROR]: Aceptando las Cookies " + Google_SearchEngine.class + e.getStackTrace());
        }
    }

    public void printResultsTitlesOnPage(){

    }

}
