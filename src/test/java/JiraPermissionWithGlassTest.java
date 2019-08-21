import com.codecool.vargabeles.selenium.pom.pageObjects.GlassDocumentationPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.GlassDocumentationPermissionPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.ProjectPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class JiraPermissionWithGlassTest extends BaseTest {

    private ProjectPage projectPage;
    private GlassDocumentationPermissionPage glassDocumentationPermissionPage;
    private GlassDocumentationPage glassDocumentationPage;

    @BeforeEach
    void setup() {

    }

    @Override
    protected void makePomInstances() {
        projectPage = new ProjectPage(driver);
        glassDocumentationPermissionPage = new GlassDocumentationPermissionPage(driver);
        glassDocumentationPage = new GlassDocumentationPage(driver);
    }


    @Test
    void checkPermissions() {
        String[][] dataFromCsv = glassDocumentationPermissionPage.readPermissionDataFromCsv();
        projectPage.navigate("/projects/PERMTEST?selectedItem=com.codecanvas.glass:glass");
        glassDocumentationPage.clickOnPermission();
        String[][] checkPermissionWithGlassList = glassDocumentationPermissionPage.getPermissionList(12);
        assertArrayEquals(dataFromCsv, checkPermissionWithGlassList);
    }
}