package integration;

import globals.Global;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.F.Callback;
import play.test.TestBrowser;
import services.CodeTrendAnalytics;
import services.RandomCodeTrendAnalytics;
import services.TwitterTrendAnalytics;
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
    public void testPageNotFound() {
        running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
        	
            public void invoke(TestBrowser browser) throws InterruptedException {
                browser.goTo("http://localhost:3333/dummyUrlThatDoesntExist");
                assertThat(browser.title()).isEqualTo("Page Not Found");
            }
        });
    }

    
    @Test
    public void testThrowsException() {

        running(testServer(3333, fakeApplication(new GlobalTest())), HTMLUNIT, new Callback<TestBrowser>() {
            
            public void invoke(TestBrowser browser) throws InterruptedException {
                browser.goTo("http://localhost:3333/trends/data");
                assertThat(browser.title()).isEqualTo("Error Page");
            }
        });
    }
    @Test
    public void testTrendsData() {
        running(testServer(3333, fakeApplication(inMemoryDatabase())),
                HTMLUNIT, new Callback<TestBrowser>() {
                    public void invoke(TestBrowser browser)
                            throws InterruptedException {

                        browser.goTo("http://localhost:3333/trends/data?language1=Java&language2=Scala&language3=Spring");
                        assertThat(browser.pageSource()).contains("Java"); 
                        assertThat(browser.pageSource()).contains("Scala"); 
                        assertThat(browser.pageSource()).contains("Spring");     
                        
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
    
    public class GlobalTest extends Global {

        private Injector injector;

        @Override
        public void onStart(Application application) {
            Logger.info("Application Test has started");
            injector = Guice.createInjector(new AbstractModule() {
                @Override
                protected void configure() {
                    bind(CodeTrendAnalytics.class).to(
                            TwitterTrendAnalytics.class);
                }
            });
        }
    }
}
