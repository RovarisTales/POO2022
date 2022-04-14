import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartCameraTest {

    public SmartCameraTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testConstructor() {
        SmartCamera smartcamera = new SmartCamera();
        assertTrue(smartcamera!=null);
        smartcamera = new SmartCamera();
        assertTrue(smartcamera!=null);
        /*
        smartcamera = new SmartCamera("b1", "RUM", 5);
        assertTrue(smartcamera!=null);
         */
    }
}
