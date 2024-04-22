package tests.android;

import config.AndroidWebActions;
import config.Log;
import config.WebActions;
import org.testng.annotations.Test;
import pages.android.WisukiApp_Search;

import static org.testng.AssertJUnit.fail;

public class WisukiApp extends AndroidWebActions {

    @Test(description = "Comprobación en el acceso a Wisuki App")
    public void wisukiApp(){
        //ObjectsGoogle googleObj = new ObjectsGoogle();
        pages.android.WisukiApp wisukiAppPag = new pages.android.WisukiApp(driver);
        pages.android.WisukiApp_Search wisukiSearchPag = new WisukiApp_Search(driver);

        try {
            wisukiAppPag.assertInitPag();
            wisukiAppPag.clickCercanos();
            Log.register("[OK]: Basic Access on Wisuki App correctly done");
        }catch (Exception e){
            Log.register("[ERROR]: " + e.getStackTrace());
        }

    }
}
