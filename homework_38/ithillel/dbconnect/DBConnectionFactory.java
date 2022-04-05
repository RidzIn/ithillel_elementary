package ua.ithillel.dbconnect;

import ua.ithillel.util.AppConfig;

public class DBConnectionFactory {
    public static DbConnection build() {
        String type = AppConfig.getProperty("db.con.type");
        if ("simple".equals(type)) {
            return new SimpleConnection();
        } else {
            return new PoolConnection();
        }
    }
}
