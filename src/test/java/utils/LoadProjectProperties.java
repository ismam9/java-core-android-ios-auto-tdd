package utils;


import config.Log;

import java.util.Arrays;
import java.util.List;

public class LoadProjectProperties {
    public static String selectedBrowser;
    public static String selectedPlatform;

    public static boolean isValidBrowser(String browser) {
        List<String> validBrowsers = Arrays.asList("chrome", "firefox", "edge", "android", "ios");
        return validBrowsers.contains(browser.toLowerCase());
    }

    public static boolean isValidPlatform(String platform) {
        List<String> validPlatforms = Arrays.asList("windows", "mac", "linux");
        return validPlatforms.contains(platform.toLowerCase());
    }

    public static void configureBrowserAndPlatform(String browser, String platform) {
        selectedBrowser = browser;
        selectedPlatform = platform;

        if (selectedBrowser == null || selectedBrowser.isEmpty()) {
            selectedBrowser = "chrome"; // Valor predeterminado si no se especifica el navegador
            System.out.println("No se ha especificado un navegador. Se establecerá el navegador predeterminado como 'chrome'.");
        }

        if (!isValidBrowser(selectedBrowser)) {
            throw new IllegalArgumentException("El navegador especificado no es válido: " + selectedBrowser);
        }

        if (selectedPlatform == null || selectedPlatform.isEmpty()) {
            selectedPlatform = "windows"; // Valor predeterminado si no se especifica la plataforma
            System.out.println("No se ha especificado una plataforma. Se establecerá la plataforma predeterminada como 'windows'.");
        }

        if (!isValidPlatform(selectedPlatform)) {
            throw new IllegalArgumentException("La plataforma especificada no es válida: " + selectedPlatform);
        }
    }
}
