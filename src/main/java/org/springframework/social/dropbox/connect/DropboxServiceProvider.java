package org.springframework.social.dropbox.connect;

import org.springframework.social.dropbox.api.Dropbox;
import org.springframework.social.dropbox.api.impl.DropboxTemplate;
import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.oauth1.OAuth1Template;
import org.springframework.social.oauth1.OAuth1Version;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * @author Bryce Fischer
 * @author Robert Drysdale
 */
public class DropboxServiceProvider extends AbstractOAuth2ServiceProvider<Dropbox> {
	private final boolean appFolder;
	
    public DropboxServiceProvider(String consumerKey, String consumerSecret, boolean appFolder) {

        super(
                new OAuth2Template(consumerKey, consumerSecret,
                "https://www.dropbox.com/1/oauth2/authorize",
                "https://api.dropbox.com/1/oauth2/token"
        ));
        this.appFolder = appFolder;
    }

    @Override
    public Dropbox getApi(String accessToken) {
        return new DropboxTemplate(accessToken, appFolder);
    }
}
