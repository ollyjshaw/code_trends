package helpers;

import play.Configuration;
import play.Play;

public class ApplicationProperties {
    static Configuration conf = Play.application().configuration();
    public static final String OAUTHCONSUMERKEY = conf
            .getString("myapp.oauthconsumerkey");
    public static final String OAUTHCONSUMERSECRET = conf
            .getString("myapp.oauthconsumersecret");
    public static final String OAUTHACCESSTOKEN = conf
            .getString("myapp.oauthaccesstoken");
    public static final String OAUTHACCESSTOKENSECRET = conf
            .getString("myapp.oauthaccesstokensecret");

}
