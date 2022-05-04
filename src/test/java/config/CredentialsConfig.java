package config;


import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends org.aeonbits.owner.Config {
    String login();
    String password();
}
