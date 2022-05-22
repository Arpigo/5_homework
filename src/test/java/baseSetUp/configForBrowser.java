package baseSetUp;

import com.codeborne.selenide.Configuration;

public class configForBrowser {

    public void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
}