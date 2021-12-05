import navigation.LoginPage;
import navigation.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests extends TestBase {
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);

    private static final String EXISTING_USERNAME_LOGIN = "test@softie.pl";
    private static final String EXISTING_USERNAME_PASSWORD = "1qaz!QAZ";
    private static final String NOT_EXISTING_USERNAME_LOGIN = "";
    private static final String NOT_EXISTING_USERNAME_PASSWORD = "";

    @Test
    void shouldLoginProperly() {
        mainPage.clickSignInButton();
        loginPage.login(EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);
        Assertions.assertTrue(isOnMyAccountPage());
    }

    @Test
    void shouldNotLoginProperly() {
        mainPage.clickSignInButton();
        loginPage.login(NOT_EXISTING_USERNAME_LOGIN, NOT_EXISTING_USERNAME_PASSWORD);
        Assertions.assertFalse(isOnMyAccountPage());
    }

    private boolean isOnMyAccountPage() {
        return driver.getCurrentUrl().contains("controller=my-account");
    }

    @Test
    void shouldNotLoginWithoutLoginValue() {

    }

    @Test
    void shouldNotLoginWithoutPassword() {

    }
}
