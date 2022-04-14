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
        smartcamera = new SmartCamera(1,10);
        assertTrue(smartcamera!=null);
        smartcamera = new SmartCamera("c1",1,10);
        assertTrue(smartcamera!=null);
    }

    @Test
    public void testCusto(){
        SmartCamera smartcamera = new SmartCamera("c1",1,10);
        assertTrue(smartcamera!=null);
        assertTrue(10 == smartcamera.custoEnergia());
    }

    @Test
    public void testClone(){
        SmartCamera sm1 = new SmartCamera("c1",1,100);
        SmartCamera smclone = sm1.clone();
        assertTrue(sm1.equals(smclone));
    }
}
