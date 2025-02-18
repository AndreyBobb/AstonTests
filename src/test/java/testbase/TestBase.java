package testbase;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;


public class TestBase {

    @Step("Открываем страницу https://astondevs.ru/")
    @BeforeAll
    static void openPage() {
        Configuration.baseUrl = "https://astondevs.ru/";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("version", "latest");
        Configuration.browserSize = "1920x1080";
        Configuration.remote = System.getProperty("Url_Of_Selenoid");

        ChromeOptions options = new ChromeOptions();
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVideo", true);
        }});
        Configuration.browserCapabilities = options;
    }

    @BeforeEach
    void setUp() {
        if (!WebDriverRunner.hasWebDriverStarted()) {
            open(""); // Инициализирует WebDriver
        }
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .savePageSource(false)
                .screenshots(true)
                .includeSelenideSteps(true)
        );
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}

//    @Step("Открываем страницу https://astondevs.ru/")
//    @BeforeAll
//    static void openPage() {
//        Configuration.browserSize = "1920x1080";
//        open("https://astondevs.ru/");
//        sleep(2000);

//        Configuration.baseUrl = "https://astondevs.ru/";
//        Configuration.browserSize = "1920x1080";
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
//
//        Configuration.baseUrl = "https://astondevs.ru/";
//        Configuration.browser = System.getProperty("browser");
//        Configuration.browserVersion = System.getProperty("version");
//        Configuration.browserSize = System.getProperty("browser_size");
//        Configuration.remote = System.getProperty("Url_Of_Selenoid");
//
//
//
//        ChromeOptions options = new ChromeOptions();
//        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
//            put("enableVideo", true);
//        }});
//        Configuration.browserCapabilities = options;
//    }
//
//    @BeforeEach
//    void addListener() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//    }
//
//    @AfterEach
//    void addAttachments() {
//        Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
//        Attach.browserConsoleLogs();
//        Attach.addVideo();
//    }
//}
