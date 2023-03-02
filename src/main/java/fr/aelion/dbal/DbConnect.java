package fr.aelion.dbal;
// Mean : src/main/java/fr/aelion/dbal

import fr.aelion.helpers.properties.PropertiesUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public abstract class DbConnect {
    protected String dsn;

    protected String username;

    protected String password;

    public abstract Connection connect() throws SQLException;

    public abstract void disconnect() throws SQLException;

    protected Properties readProperties() {
        Properties properties = new PropertiesUtil().loadProperties();

        this.username = properties.getProperty("user");
        this.password = properties.getProperty("password");
        this.dsn = properties.getProperty("url");

        return properties;
    }

}