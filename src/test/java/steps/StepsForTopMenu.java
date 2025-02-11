package steps;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepsForTopMenu {

    String fintech = "Финтех";
    String development1C = "1С-разработка";
    String projectDevelopment = "Проектная разработка";
    String teamExpansion = "Расширение команды";
    String dedicatedTeam = "Выделенная команда";
    String consulting = "Консалтинг";
    String workInAston = "Работа в ASTON";
    String vacancies = "Вакансии";
    String internship = "Стажировка";
    String courses = "Курсы";
    String cultureCode = "Культурный код";
    String astonRadio = "ASTON Радио";
    String urlOurProjects = "https://astondevs.ru/our-projects";
    String urlAboutUs = "https://astondevs.ru/about-us";

    @Step("При наведении на раздел \"Доменная экспертиза\" появляются \"Финтех\" и \"1С-разработка\"")
    public void checkDomainExpertise() {
        $("#header div nav p").hover();
        $("div.chakra-stack h2.chakra-text").
                shouldBe(visible).shouldHave(text(fintech));

        $("div.chakra-stack article.chakra-linkbox").sibling(0)
                .shouldHave(text(development1C));
    }

    @Step("При наведении на раздел \"Услуги для бизнеса\" появляются \"Проектная разработка\", " +
            "\"Расширение команды\", \"Выделенная команда\" и \"Консалтинг\"")
    public void checkServicesForBusiness() {
        $("#header div nav p").sibling(0).hover();
        $("div.chakra-stack article.chakra-linkbox").shouldHave(text(projectDevelopment));
        $("div.chakra-stack article.chakra-linkbox").sibling(0)
                .shouldHave(text(teamExpansion));
        $("div.chakra-stack article.chakra-linkbox").sibling(1)
                .shouldHave(text(dedicatedTeam));
        $("div.chakra-stack article.chakra-linkbox").sibling(2)
                .shouldHave(text(consulting));
    }

    @Step("При наведении на раздел \"Карьера\" появляются \"Работа в ASTON\"," +
            " \"Вакансии\", \"Стажировка\" и \"Курсы\"")
    public void checkCareer() {
        $("#header div nav p").sibling(2).hover();
        $("div.chakra-stack article.chakra-linkbox").
                shouldHave(text(workInAston));
        $("div.chakra-stack article.chakra-linkbox").sibling(0).
                shouldHave(text(vacancies));
        $("div.chakra-stack article.chakra-linkbox").sibling(1).
                shouldHave(text(internship));
        $("div.chakra-stack article.chakra-linkbox").sibling(2).
                shouldHave(text(courses));
    }

    @Step("При наведении на раздел \"ASTON медия\" появляются \"Культурный код\" и \"ASTON Радио\"")
    public void checkAstonMedia() {
        $("#header div nav p").sibling(3).hover();
        $("div.chakra-stack article.chakra-linkbox").
                shouldHave(text(cultureCode));
        $("div.chakra-stack article.chakra-linkbox").sibling(0).
                shouldHave(text(astonRadio));

    }

    @Step("При переходе в раздел \"Проекты\" url страницы https://astondevs.ru/our-projects")
    public void checkProjects() {
        $("#header div nav a").click();
        sleep(3000);
        String CurrentUrl = WebDriverRunner.url();
        assertEquals(CurrentUrl, urlOurProjects);

    }

    @Step("При переходе в раздел \"О нас\" url страницы https://astondevs.ru/about-us")
    public void checkAboutUs() {
        $("#header div nav a").sibling(2).click();
        sleep(3000);
        String CurrentUrl = WebDriverRunner.url();
        assertEquals(CurrentUrl, urlAboutUs);
    }
}
