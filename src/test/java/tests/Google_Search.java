package tests;

import config.Log;
import config.WebActions;
import org.testng.annotations.Test;
import pages.google.Google_ResulstsTodo;
import pages.google.Google_SearchEngine;
import webElements.ObjectsGoogle;

import static org.testng.AssertJUnit.fail;

public class Google_Search extends WebActions{
    
    @Test(description = "User typicall search")
    public void searchGoogle(){
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
            searchPag.searchGoogleInput("https://clipdrop.co/");
            resultPag.printResultsUrlsOnPage();
            resultPag.printResultsTitlesOnPage();
            Log.register("[OK]: Basic Search on Google correctly done");
        }catch (Exception e){
            Log.register("[ERROR]: " + e.getStackTrace());
        }

    }

}
