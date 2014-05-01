package controllers;

import static org.fest.assertions.Assertions.assertThat;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.callAction;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;
import static play.test.Helpers.status;

import org.junit.Test;

import play.mvc.Result;

public class TrendsTest {

	@Test
	public void trendsDataTest() {
	   running(fakeApplication(), new Runnable() {
	       public void run() {;
	           Result result = callAction(controllers.routes.ref.Trends.data());
	           //assert(contentAsString(result).contains("test1"));
	           assertThat(status(result)).isEqualTo(OK);
	           assertThat(contentType(result)).isEqualTo("application/json");
	       }
	   });
	}
}
