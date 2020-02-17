import static org.assertj.core.api.Assertions.assertThat;  // main one
import static org.assertj.core.api.Assertions.fail; // use when writing exception tests
import static org.assertj.core.api.Assertions.filter; // for Iterable/Array assertions
import static org.assertj.core.api.Assertions.offset; // for floating number assertions
import static org.assertj.core.api.Assertions.anyOf; // use with Condition
import static org.assertj.core.api.Assertions.contentOf; // use with File assertions

import org.junit.*;


public class JPanelLeftTest extends AbstractFrameTest {


    @Test
    public void testWithDifferingComponentMatchers() {

       Object obj2 = frame.panel("RightComboPanel").comboBox("RightPanelComboBox").list();
        Object obj = frame.panel("LeftDroppingPanel").comboBox("LeftPanelComboBox").list();
        Assert.assertNotSame("Not the same comboBoxes",obj, obj2);
    }


}
