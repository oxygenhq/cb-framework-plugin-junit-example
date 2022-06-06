package Unit;

import io.cloudbeat.junit.CbJunitExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({CbJunitExtension.class})
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
