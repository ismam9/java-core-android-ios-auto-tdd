package pages.android;

import config.AndroidWebActions;
import config.Log;
import org.openqa.selenium.WebDriver;
import webElements.android.ObjectsWisuki;

public class WisukiApp_Search extends AndroidWebActions {
    /**
     * Podemos dos opciones:
     * - Inicializar el driver aqui en la clase hija con: this.driver = driver;
     * Entonces no haría falta tenerlo inicializado en el padre WebActions, valdría con un super()
     *
     * - Si no inicializamos el driver aqui y usamos super()
     * Entonces tendremos que inicializar el driver en la clase padre con this.driver = driver
     * */

    ObjectsWisuki objWisuki;

    public WisukiApp_Search(WebDriver driver) {
        //this.driver = driver;
        super(driver);
        objWisuki = new ObjectsWisuki(driver);
    }

    public void assertSearchPag(){
        try{
            wait(2);
            waitForElement(objWisuki.BTN_SEARCH_DOS);
            click(objWisuki.BTN_SEARCH_DOS, "Click elemento BTN_SEARCH");
            Log.register("[OK]: SE HA HECHO CLICK CORRECTAMENTE EN EL btn_search");
        }catch (Exception e){
            Log.register("[ERROR]: FALLANDO AL HACER CLICK EN btn_search");
        }
    }

    public void searchUbication(){
        try{
            wait(2);
            waitForElement(objWisuki.INPUT_SEARCH_DOS);
            objWisuki.INPUT_SEARCH_DOS.sendKeys("Pozo Alcon");
            Log.register("[OK]: Se ha fallado al enviar 'Pozo Alcon' al input_search");
        }catch (Exception e){
            Log.register("[ERROR]: ERROR ENVIANDO AL search_input");
        }
    }
}
