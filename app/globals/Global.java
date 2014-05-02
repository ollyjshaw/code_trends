package globals;

import play.Logger;
import play.mvc.SimpleResult;
import play.mvc.Http.RequestHeader;
import play.libs.F.Promise;

import static play.mvc.Results.*;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import play.Application;
import play.GlobalSettings;
import services.CodeTrendAnalytics;
import services.RandomCodeTrendAnalytics;

public class Global extends GlobalSettings {

    private Injector injector;

    @Override
    public void onStart(Application application) {
        Logger.info("Application has started");
        injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(CodeTrendAnalytics.class).to(
                        RandomCodeTrendAnalytics.class);
            }
        });
    }

    public Promise<SimpleResult> onError(RequestHeader request, Throwable t) {
        return Promise.<SimpleResult>pure(internalServerError(
            views.html.error.errorPage.render(t)
        ));
    }
    
    public Promise<SimpleResult> onHandlerNotFound(RequestHeader request) {
        return Promise.<SimpleResult>pure(notFound(
            views.html.error.notFoundPage.render(request.uri())
        ));
    }
    
    public void onStop(Application app) {
        Logger.info("Application shutdown...");
    }
    
    
    @Override
    public <T> T getControllerInstance(Class<T> aClass) throws Exception {
        return injector.getInstance(aClass);
    }
}

