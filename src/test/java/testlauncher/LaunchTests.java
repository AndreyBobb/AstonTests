package testlauncher;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.StepsForApplyForm;
import steps.StepsForTopMenu;
import testbase.TestBase;

public class LaunchTests extends TestBase {
    StepsForTopMenu stepsForTopMenu = new StepsForTopMenu();
    StepsForApplyForm stepForApplicationForm = new StepsForApplyForm();

    @Tag("remote")
    @Test
    void testOfTopMenu() {
        stepsForTopMenu.checkDomainExpertise();
        stepsForTopMenu.checkServicesForBusiness();
        stepsForTopMenu.checkCareer();
        stepsForTopMenu.checkAstonMedia();
        stepsForTopMenu.checkProjects();
        stepsForTopMenu.checkAboutUs();
    }
    @Tag("remote")
    @Test
    void testOfApplicationForm() {
        stepForApplicationForm.fillApplicationForm();
        stepForApplicationForm.buttonSendShouldBeClickable();
    }
}
