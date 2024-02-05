package franxx.code.spring.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void createSingleton() {

        Database instance1 = Database.getInstance();
        Database instance2 = Database.getInstance();
        assertSame(instance2, instance1);

    }
}