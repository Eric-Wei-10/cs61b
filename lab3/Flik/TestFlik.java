import org.junit.Test;
import static org.junit.Assert.*;

public class TestFlik {
    @Test
    public void testFlik() {
        assertTrue(Flik.isSameNumber(128, 128));
        int i = 128;
        int j = 128;
        assertTrue(Flik.isSameNumber(i, j));
    }
}
