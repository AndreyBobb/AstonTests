package testlauncher;

import org.junit.jupiter.api.Test;
import steps.StepsForApplyForm;
import steps.StepsForTopMenu;
import testbase.TestBase;

public class LaunchTests extends TestBase {
    StepsForTopMenu stepsForTopMenu = new StepsForTopMenu();
    StepsForApplyForm stepForApplicationForm = new StepsForApplyForm();

    @Test
    void testOfTopMenu() {
        stepsForTopMenu.checkDomainExpertise();
        stepsForTopMenu.checkServicesForBusiness();
        stepsForTopMenu.checkCareer();
        stepsForTopMenu.checkAstonMedia();
        stepsForTopMenu.checkProjects();
        stepsForTopMenu.checkAboutUs();
    }

    @Test
    void testOfApplicationForm() {
        stepForApplicationForm.fillApplicationForm();
        stepForApplicationForm.buttonSendShouldBeClickable();
    }
}
