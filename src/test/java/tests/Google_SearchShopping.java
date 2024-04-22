package tests;

import config.Log;
import config.WebActions;
import org.testng.annotations.Test;
import pages.google.Google_ResulstsTodo;
import pages.google.Google_SearchEngine;

import static org.testng.AssertJUnit.fail;

public class Google_SearchShopping extends WebActions {

    @Test(description = "User typicall search on Shopping Tab")
    public void searchGoogleShopping(){
        //ObjectsGoogle googleObj = new ObjectsGoogle();
        Google_SearchEngine searchPag = new Google_SearchEngine(driver);
        Google_ResulstsTodo resultPag = new Google_ResulstsTodo(driver);

        try{
            access("https://www.google.com/");
        }catch (Exception e){
            fail();
        }

        try {
            searchPag.acceptCookie();
            searchPag.waitForGoogleInput();
            searchPag.searchGoogleInput("iphone 3");
            resultPag.printResultsUrlsOnPage();
            resultPag.printResultsTitlesOnPage();
            Log.register("[OK]: Basic Search on Google correctly done");
        }catch (Exception e){
            Log.register("[ERROR]: " + e.getStackTrace());
        }

    }
}
