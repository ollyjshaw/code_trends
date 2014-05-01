package integration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.Ignore;
import org.junit.Test;

import play.libs.F.Callback;
import play.test.TestBrowser;
import scala.util.parsing.json.JSONFormat;
import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.*;

public class IntegrationTest {

    @Ignore
    @Test
    public void testTrends() {
        running(testServer(3333, fakeApplication(inMemoryDatabase())),
                HTMLUNIT, new Callback<TestBrowser>() {
                    public void invoke(TestBrowser browser)
                            throws InterruptedException {
                        browser.goTo("http://localhost:3333/");
                        assertThat(browser.pageSource()).contains(
                                "Search Twitter popularity");

                        browser.fill("#language1").with("java");
                        browser.fill("#language2").with("C#");
                        browser.fill("#language3").with("Scala");
                        browser.submit(".button");
                        assertThat(browser.title()).isEqualTo(
                                "Code Trend Results");
                    }
                });
    }

    @Test
    public void testTrendsData() {
        running(testServer(3333, fakeApplication(inMemoryDatabase())),
                HTMLUNIT, new Callback<TestBrowser>() {
                    public void invoke(TestBrowser browser)
                            throws InterruptedException {

                        browser.goTo("http://localhost:3333/trends/data");

                        assertThat(isValidJSON(browser.pageSource()));
                    }
                });
    }

    public boolean isValidJSON(String possibleJson) {
        return isJSONObject(possibleJson) || isJSONArray(possibleJson);
    }

    private boolean isJSONObject(String possibleJson) {
        try {
            new JSONObject(possibleJson);
            return true;
        } catch (JSONException ex) {
            return false;
        }
    }

    private boolean isJSONArray(String possibleJson) {
        try {
            new JSONArray(possibleJson);
            return true;
        } catch (JSONException ex) {
            return false;
        }
    }

}
