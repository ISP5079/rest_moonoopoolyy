package israel.sandoval.rest_moonoopoolyy.configuracion;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "israel.sandoval.rest_moonoopoolyy.repository.moonoopoolyy",
        entityManagerFactoryRef = "moonoopoolyyEntityManager",
        transactionManagerRef = "moonoopoolyyTransactionManager")
public class MoonoopoolyyConfig {
    @Primary
    @Bean(name = "moonoopoolyyDS")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource havDS(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "moonoopoolyyEMF")
    public LocalContainerEntityManagerFactoryBean
    barEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("moonoopoolyyDS") DataSource dataSource
    ) {
        return
                builder.dataSource(dataSource)
                        .packages("israel.sandoval.rest_moonoopoolyy.entitys.moonoopoolyy")
                        .persistenceUnit("moonoopoolyy")
                        .build();
    }
    @Bean(name = "moonoopoolyyTM")
    public PlatformTransactionManager barTransactionManager(
            @Qualifier("moonoopoolyyEMF") EntityManagerFactory
                    entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
