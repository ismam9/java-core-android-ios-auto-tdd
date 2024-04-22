package webElements.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjectsWisuki {

    private WebDriver driver; // Referencia al driver

    // Constructor que recibe el driver como argumento
    public ObjectsWisuki(org.openqa.selenium.WebDriver driver) {
        this.driver = driver; // Asigna el driver recibido al atributo de la clase
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // Inicializa los elementos de la página
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text('Wisuki')")
    public WebElement TITLE;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Wisuki\"]")
    public WebElement TITLE_DOS;

    @AndroidFindBy(uiAutomator = "new UiSelector().text('FAVORITOS')")
    public WebElement TAB_FAVORITOS;

    @FindBy(xpath = "//android.widget.TextView[@text=\"FAVORITOS\"]")
    public WebElement TAB_FAVORITOS_DOS;

    @AndroidFindBy(uiAutomator = "new UiSelector().text('CERCANOS')")
    public WebElement TAB_CERCANOS;

    @FindBy(xpath = "//android.widget.TextView[@text=\"CERCANOS\"]")
    public WebElement TAB_CERCANOS_DOS;

    @AndroidFindBy(uiAutomator = "new UiSelector().text('PRIVADOS')")
    public WebElement TAB_PRIVADOS;

    @FindBy(xpath = "//android.widget.TextView[@text=\"PRIVADOS\"]")
    public WebElement TAB_PRIVADOS_DOS;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId('com.coolz.wisuki:id/action_search')")
    public WebElement BTN_SEARCH;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Buscar\"]")
    public WebElement BTN_SEARCH_DOS;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId('com.coolz.wisuki:id/search_src_text')")
    public WebElement INPUT_SEARCH;

    @FindBy(xpath = "//android.widget.AutoCompleteTextView[@resource-id=\"com.coolz.wisuki:id/search_src_text\"]")
    public WebElement INPUT_SEARCH_DOS;
}
