import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.*;

public class IntegrationTest {

    @Test
    public void test() {
        running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
                browser.goTo("http://localhost:3333");
                assertThat(browser.pageSource()).contains("Your new application is ready.");
            }
        });
    }

    @Test
    public void testTrends() {
        running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
                browser.goTo("http://localhost:3333/trends/new");
                assertThat(browser.pageSource()).contains("Search Twitter popularity");

                browser.fill("#language1").with("java");
                browser.fill("#language2").with("C#");
                browser.fill("#language3").with("Scala");
                browser.submit(".button");;
                assertThat(browser.title()).isEqualTo("Code Trend Results");
            }
        });
    }
}
