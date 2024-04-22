package pages.android;

import config.AndroidWebActions;
import config.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.google.Google_SearchEngine;
import webElements.ObjectsGoogle;
import webElements.android.ObjectsWisuki;

public class WisukiApp extends AndroidWebActions {
    /**
     * Podemos dos opciones:
     * - Inicializar el driver aqui en la clase hija con: this.driver = driver;
     * Entonces no haría falta tenerlo inicializado en el padre WebActions, valdría con un super()
     *
     * - Si no inicializamos el driver aqui y usamos super()
     * Entonces tendremos que inicializar el driver en la clase padre con this.driver = driver
     * */

    ObjectsWisuki objWisuki;

    public WisukiApp(WebDriver driver) {
        //this.driver = driver;
        super(driver);
        objWisuki = new ObjectsWisuki(driver);
    }

    public void assertInitPag(){
        try{
            wait(2);
            waitForElement(objWisuki.TITLE_DOS);
            waitForElement(objWisuki.TAB_FAVORITOS_DOS);
            waitForElement(objWisuki.TAB_CERCANOS_DOS);
            waitForElement(objWisuki.TAB_PRIVADOS_DOS);
            Log.register("[OK]: WAIT FOR MAIN PAGE IT IS CORRECT");
        }catch (Exception e){
            Log.register("[ERROR]: ELEMENTS FOR MAIN PAGE ARE  NOT DISPLAYED " + Google_SearchEngine.class + e.getStackTrace());
        }
    }

    public void clickCercanos(){
        try{
            wait(2);
            waitForElement(objWisuki.TAB_CERCANOS_DOS);
            click(objWisuki.TAB_CERCANOS_DOS, "Clickamos en el TAB de 'CERCANOS'");
            Log.register("[OK]: WAIT FOR MAIN PAGE IT IS CORRECT");
        }catch (Exception e){
            Log.register("[ERROR]: ELEMENTS FOR MAIN PAGE ARE  NOT DISPLAYED " + Google_SearchEngine.class + e.getStackTrace());
        }
    }
}
