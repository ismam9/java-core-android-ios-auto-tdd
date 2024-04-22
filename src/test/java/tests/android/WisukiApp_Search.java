package tests.android;

import config.AndroidWebActions;
import config.Log;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.fail;

public class WisukiApp_Search  extends AndroidWebActions {

    @Test(description = "Comprobación en la busuqeda de la aplicacion de Wisuki")
    public void wisukiAppSerch(){
        //ObjectsGoogle googleObj = new ObjectsGoogle();
        pages.android.WisukiApp wisukiAppPag = new pages.android.WisukiApp(driver);
        pages.android.WisukiApp_Search wisukiSearchPag = new pages.android.WisukiApp_Search(driver);

        try {
            wisukiAppPag.assertInitPag();
            wisukiSearchPag.assertSearchPag();
            wisukiSearchPag.searchUbication();
            Log.register("[OK]: Basic Search on Wisuki App correctly done");
        }catch (Exception e){
            Log.register("[ERROR]: " + e.getStackTrace());
        }

    }
}
