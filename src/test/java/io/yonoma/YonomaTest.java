package io.yonoma;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class YonomaTest {

    @Test
    public void testGetCurrentDateTime() {
        String dateTime = Yonoma.getCurrentDateTime();
        assertNotNull(dateTime);  // Ensure the result is not null
        System.out.println("Current Date-Time: " + dateTime);
    }
}
