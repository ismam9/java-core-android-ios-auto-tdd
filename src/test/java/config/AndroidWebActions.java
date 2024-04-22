package config;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import java.io.IOException;
import java.time.Duration;

import static org.testng.AssertJUnit.fail;

public class AndroidWebActions extends WebDriver{

    public static String msg;

    /**
     * Este consctructor vacio es para los Tests
     * */
    public AndroidWebActions() {
        // Constructor sin argumentos
    }

    /**
     * Mientras que este constructor inicializado es para las Pages
     * */
    public AndroidWebActions(org.openqa.selenium.WebDriver driver) {
        this.driver = driver;
        //super(driver)
    }

    // Métodos útiles para usar en Appium
    public void wait(int s) {
        try {
            Thread.sleep(s * 1000);
//			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.register("[ERROR][" + this.getClass().getSimpleName() + "]: " + "[Ha habido un problema al hacer la espera]");
        }
    }

    public void waitForElement(WebElement elm) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(elm));
            Log.register("[OK][" + this.getClass().getSimpleName() + "]: " + "[Se ha esperado a que el elemento " + elm.toString() + " " + " sea visible]");
        } catch (Exception ex) {
            Log.register("[ERROR][" + this.getClass().getSimpleName() + "]: " + "[Error al esperar a que el elemento "
                    + elm.toString() + " " + " sea visible]");
        }
    }

    public void logAssert(boolean condicion, String mensaje) throws IOException {
        mensaje = "<small>" + mensaje + "</small>";
        try {
            Assert.assertTrue(condicion);
            Log.register("[Assert OK][" + this.getClass().getSimpleName() + "]: " + "[Elemento es visible]" + mensaje);
        } catch (AssertionError ex) {
            Log.register("[Assert KO][" + this.getClass().getSimpleName() + "]: " + "[Elemento no es visible]" + mensaje);
            fail(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForInvisibility(String uiAutomator) throws IOException {
        String msg = "";
        int tiempoEspera = 35;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tiempoEspera));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(new AppiumBy.ByAndroidUIAutomator(uiAutomator)));
            Log.register("[OK][" + this.getClass().getSimpleName() + "]: " + "Espera OK. Elemento " + uiAutomator + " es ahora invisible.");
        } catch (Exception ex) {
            Log.register("[ERROR][" + this.getClass().getSimpleName() + "]: " + "Tiempo de espera superado (" + tiempoEspera + " seg.). Elemento se mantiene visible.");
            throw new SkipException("Timeout");
        }

    }

    public boolean isElementPresent(WebElement elm) {
        try {
            if (elm.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /*public void scrollTo(String txtVisibile) {
        try {
            String uiSelector = "new UiSelector().textMatches(\"" + txtVisibile + "\")";
            String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                    + uiSelector + ");";
            driver(command);
            Log.register("[OK][" + this.getClass().getSimpleName() + "]: " + "[Scroll con éxito al texto " + txtVisibile
                    + "]");
        } catch (Exception ex) {
            Log.register("[ERROR][" + this.getClass().getSimpleName() + "]: " + "[No se ha hecho el scroll al texto "
                    + txtVisibile + "]");
        }

    }*/

    public void click(WebElement elm, String descripcion) {
        String proceso = " Click ";
        descripcion = " [ <small>"+ descripcion + "</small> ] ";
        try {
            elm.click();
            Log.register("[OK][" + this.getClass().getSimpleName() + "]: " + "[Click en el elemento " + descripcion + "]");
        } catch (Exception ex) {
            Log.register("[ERROR][" + this.getClass().getSimpleName() + "]: " + "[Error al dar click en el elemento "
                    + descripcion + "]");
            fail(ex.getMessage());
        }


    }

    public void sendKeys(WebElement elm, String texto, String descripcion) {
        String proceso = " Enviar texto ";
        descripcion = " [ <small>"+ descripcion + "</small> ] ";

        if (texto == null) {
            texto = " ";
        }

        try {
            elm.sendKeys(texto);
            Log.register("[OK][" + this.getClass().getSimpleName() + "]: " + "[ \"" + texto + "\" enviado al elemento " + descripcion + "]");
        } catch (Exception ex) {
            Log.register("[ERROR][" + this.getClass().getSimpleName() + "]: " + "[ Error al enviar \"" + texto + "\" " + "al elemento " + descripcion + "]");
            fail(ex.getMessage());
        }

    }

    public void pressEnter() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void hideKeyboard() {
        ((AndroidDriver) driver).hideKeyboard();
    }

    public void clearSendKeys(WebElement elm, String ploja) {
        try {
            elm.clear();
            elm.sendKeys(ploja);
            Log.register("[OK][" + this.getClass().getSimpleName() + "]: " + "[ \"" + ploja + "\" enviado al elemento "
                    + elm.toString() + "]");
        } catch (Exception ex) {
            Log.register("[ERROR][" + this.getClass().getSimpleName() + "]: " + "[ Error al enviar \"" + ploja + "\" "
                    + "al elemento " + elm.toString() + "]");
        } finally {
            ((AndroidDriver) driver).hideKeyboard();
        }
    }

    /*public void swipe(String side, String size) {

        Dimension windowSize = driver.manage().window().getSize();
        int screenDivisor = 1;
        int auxCompensation = 0;
        TouchAction ta = new TouchAction(driver);

        switch (size) {
            case "SMALL":
                screenDivisor = 2;
                auxCompensation = 0;
                break;
            case "BIG":
                screenDivisor = 1;
                auxCompensation = 50;
                break;
            default:
                System.out.println("ERROR: No se ha introducido un tamaño de swipe correcto");
                Log.register("[ERROR][" + this.getClass().getSimpleName() + "]: " + "[Error al realizar un swipe]");
                test.fail("Error al realizar un swipe.");
        }

        switch (side) {
            case "DOWN":
                ta.press(PointOption.point((int) windowSize.getWidth() / 2,
                                ((int) windowSize.getHeight() / screenDivisor) - auxCompensation))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point((int) windowSize.getWidth() / 2, (int) 10)).release().perform();
                Log.register("[OK][" + this.getClass().getSimpleName() + "]: " + "[Se ha realizado un swipe hacia abajo ]");
                //test.log(Status.PASS, "Se ha realizado un swipe hacia abajo");
                break;
            case "UP":
                ta.press(PointOption.point((int) windowSize.getWidth() / 2, (int) 150))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point((int) windowSize.getWidth() / 2,
                                ((int) windowSize.getHeight() / screenDivisor) - auxCompensation))
                        .release().perform();
                Log.register("[OK][" + this.getClass().getSimpleName() + "]: " + "[Se ha realizado un swipe hacia arriba ]");
                //test.log(Status.PASS, "Se ha realizado un swipe hacia arriba");
                break;
            default:
                System.out.println("ERROR: No se ha introducido una direccion de swipe correcto");
                Log.register("[ERROR][" + this.getClass().getSimpleName() + "]: " + "[Error al realizar un swipe]");
                test.fail("Error al realizar un swipe.");
        }
    }*/
}
