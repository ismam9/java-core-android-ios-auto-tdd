package pages.google;

import config.Log;
import config.WebActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import tests.Google_Search;
import webElements.ObjectsGoogle;

public class Google_SearchEngine extends WebActions {

    /**
     * Podemos dos opciones:
     * - Inicializar el driver aqui en la clase hija con: this.driver = driver;
     * Entonces no haría falta tenerlo inicializado en el padre WebActions, valdría con un super()
     *
     * - Si no inicializamos el driver aqui y usamos super()
     * Entonces tendremos que inicializar el driver en la clase padre con this.driver = driver
     * */

    ObjectsGoogle objGoogle;
    public Google_SearchEngine(WebDriver driver) {
        super(driver);
        objGoogle = new ObjectsGoogle(driver);
    }

    public void acceptCookie(){
        try{
            waitSecs(2);
            waitForVisibility(objGoogle.ES_MODAL_COOKIES);
            scrollTo(objGoogle.ES_MODAL_COOKIES);
            scrollTo(objGoogle.ES_MODAL_BTN_ACEPTARTODO);
            waitForVisibility(objGoogle.ES_MODAL_BTN_ACEPTARTODO);
            click(objGoogle.ES_MODAL_BTN_ACEPTARTODO);
            Log.register("[OK]: Accepted Cookies correctly");
        }catch (Exception e){
            Log.register("[ERROR]: Aceptando las Cookies " + Google_SearchEngine.class + e.getStackTrace());
        }
    }

    public void rejectCookies(){
        try{
            waitSecs(2);
            waitSecs(2);
            waitForVisibility(objGoogle.ES_MODAL_COOKIES);
            scrollTo(objGoogle.ES_MODAL_COOKIES);
            scrollTo(objGoogle.ES_MODAL_BTN_RECHAZARTODO);
            waitForVisibility(objGoogle.ES_MODAL_BTN_RECHAZARTODO);
            click(objGoogle.ES_MODAL_BTN_RECHAZARTODO);
            Log.register("[OK]: Rejected Cookies correctly");
        }catch (Exception e){
            Log.register("[ERROR]: Aceptando las Cookies " + Google_SearchEngine.class + e.getStackTrace());
        }
    }

    public void waitForGoogleInput(){
        try{
            waitForVisibility(objGoogle.ES_INPUT_GOOGLE);
            Log.register("[OK]: Google Input it's visible now");
        }catch (Exception e){
            Log.register("[ERROR]: Waiting the Search Input " + Google_SearchEngine.class + e.getStackTrace());
        }
    }

    public void searchGoogleInput(String txt){
        try{
            waitSecs(1);
            objGoogle.ES_INPUT_GOOGLE.sendKeys(txt);
            objGoogle.ES_INPUT_GOOGLE.sendKeys(Keys.ENTER);
            Log.register("[OK]: Searched on Google Input correctly");
        }catch (Exception e){
            Log.register("[ERROR]: Sending " + txt + ". " + Google_SearchEngine.class + e.getStackTrace());
        }
    }

}
