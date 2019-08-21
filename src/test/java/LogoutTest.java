import com.codecool.vargabeles.selenium.pom.pageObjects.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LogoutTest extends BaseTest {

    @Test
    void testSuccessfulLogout() {
        MainPage mainPage = new MainPage(driver);
        mainPage.logout();
        assertFalse(mainPage.isLoggedIn());
    }

    @Override
    protected void makePomInstances() {

    }
}