package is.stanton.andy.interrogate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {
    private static final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Value("${app.database.host}")
    private String databaseHost;

    @Bean
    public HikariDataSource datasource() {
        String databaseUrl = String.format("jdbc:mysql://%s:3306/interrogate", databaseHost);
        log.info("databaseUrl: {}", databaseUrl);
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(databaseUrl);
        config.setUsername("interrogate");
        config.setPassword("interrogate");
        config.addDataSourceProperty("useSSL", false);
        config.setInitializationFailTimeout(-1);

        return new HikariDataSource(config);
    }
}
