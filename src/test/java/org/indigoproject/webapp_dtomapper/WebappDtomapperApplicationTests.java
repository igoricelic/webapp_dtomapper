package org.indigoproject.webapp_dtomapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WebappDtomapperApplicationTests {

    @Autowired
    private Environment environment;

    @Test
    void contextLoads() {
        assertEquals("org.h2.Driver", environment.getProperty("spring.datasource.driverClassName"));
        assertEquals("org.hibernate.dialect.H2Dialect", environment.getProperty("spring.jpa.properties.hibernate.dialect"));
        assertEquals("create-drop", environment.getProperty("spring.jpa.hibernate.ddl-auto"));
        assertEquals("jdbc:h2:mem:webapp", environment.getProperty("spring.datasource.url"));
    }

}
