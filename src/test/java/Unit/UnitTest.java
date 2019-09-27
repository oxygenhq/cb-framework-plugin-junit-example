package Unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class UnitTest {
    @Test
    @Tag("success")
    public void successUnitTest() {
        Assertions.assertEquals(2, 1+1);
    }

    @Test
    @Tag("fail")
    public void failUnitTest() throws Exception {
        Assertions.assertEquals(2, 1+2);
    }
}
