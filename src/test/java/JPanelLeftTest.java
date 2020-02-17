
import com.JsonParserProject.firstProject.CreateBothTables;
import org.assertj.swing.core.*;
import org.assertj.swing.core.Robot;

import static org.assertj.core.api.Assertions.assertThat;  // main one
import static org.assertj.core.api.Assertions.atIndex; // for List assertions
import static org.assertj.core.api.Assertions.entry;  // for Map assertions
import static org.assertj.core.api.Assertions.tuple; // when extracting several properties at once
import static org.assertj.core.api.Assertions.fail; // use when writing exception tests
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown; // idem
import static org.assertj.core.api.Assertions.filter; // for Iterable/Array assertions
import static org.assertj.core.api.Assertions.offset; // for floating number assertions
import static org.assertj.core.api.Assertions.anyOf; // use with Condition
import static org.assertj.core.api.Assertions.contentOf; // use with File assertions
import static org.assertj.core.api.Assertions.*;

import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.core.matcher.JTextComponentMatcher;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.testing.AssertJSwingTestCaseTemplate;
import org.junit.*;

import javax.swing.*;


public class JPanelLeftTest extends AbstractFrameTest {


    @Test
    public void testWithDifferingComponentMatchers() {

       Object obj2 = frame.panel("RightComboPanel").comboBox("RightPanelComboBox").list();
        Object obj = frame.panel("LeftDroppingPanel").comboBox("LeftPanelComboBox").list();
        Assert.assertNotSame("Not the same comboBoxes",obj, obj2);
    }


}
