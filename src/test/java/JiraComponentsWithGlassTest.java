import com.codecool.vargabeles.selenium.pom.pageObjects.ComponentsPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.GlassDocumentationPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.IssuePage;
import com.codecool.vargabeles.selenium.pom.pageObjects.ProjectPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.UUID;

class JiraComponentsWithGlassTest extends BaseTest {
    private ProjectPage projectPage;
    private ComponentsPage componentsPage;
    private IssuePage issuePage;
    private GlassDocumentationPage glassDocumentationPage;
    private int projectId = new Random().nextInt(3) + 1;
    private String uniqueId = UUID.randomUUID().toString();

    @Override
    protected void makePomInstances() {
        projectPage = new ProjectPage(driver);
        componentsPage = new ComponentsPage(driver);
        issuePage = new IssuePage(driver);
        glassDocumentationPage = new GlassDocumentationPage(driver);
    }

    @Test
    void connectComponentToIssue() {
        projectPage.navigate("/projects/PP"+ projectId +"?selectedItem=com.atlassian.jira.jira-projects-plugin:components-page");
        componentsPage.makeNewComponent(uniqueId, "Project lead (Administrator)");
        componentsPage.clickToIssuesLink();
        issuePage.addComponentToIssue(uniqueId);
        issuePage.navigate("/projects/PP"+ projectId +"?selectedItem=com.codecanvas.glass:glass");

        int result = glassDocumentationPage.getNumOfComponentsOfIssue();
        Assert.assertEquals(result, 1);
    }

    @AfterEach
    void deleteComponent(){
        componentsPage.deleteComponent(uniqueId, projectId);
    }
}