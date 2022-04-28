package testsimple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkippedTests {
    @Test
    @Disabled
    void test00() {
        assertTrue(true);
    }

    @Disabled
    @Test
    void test01() {
        assertTrue(true);
    }

    @Disabled("some reason")
    @Test
    void test02() {
        assertTrue(true);
    }

}



