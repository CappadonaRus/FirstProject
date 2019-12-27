import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionsWindow extends Frames {

    public void createFrame() {

        final JPanel droppingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 3));
        droppingPanel.setBorder(new TitledBorder("Border"));
        droppingPanel.add(createComboTable());
        droppingPanel.add(createAddNewButton());

        final JPanel upperPanel = new JPanel(new BorderLayout(5, 5));
        upperPanel.add(droppingPanel, BorderLayout.NORTH);
        upperPanel.add(createButtonsGroup(), BorderLayout.CENTER);
        upperPanel.add(SplitPaneCreate.createSplitPane(), BorderLayout.WEST);

        final JFrame mainFrame = new JFrame("For my Braza");
        mainFrame.setContentPane(upperPanel);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);

        try {
            mainFrame.setLocationByPlatform(true);
            mainFrame.setMinimumSize(mainFrame.getSize());
        } catch (Throwable ignoreAndContinue) {
        }

        mainFrame.setVisible(true);
    }

    public JComboBox createComboTable() {
        String[] items = {"Элемент списка 1", "Элемент списка 2", "Элемент списка 3"};
        final JComboBox comboButton = new JComboBox(items);
        comboButton.setEditable(false);
        comboButton.setAlignmentX(LEFT_ALIGNMENT);

        comboButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            }
        });
        return comboButton;
    }

    public JPanel createButtonsGroup() {
        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        buttonsPanel.setBorder(new TitledBorder("Radio Buttons"));
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton radioButton1 = new JRadioButton("first button", false);
        buttonGroup.add(radioButton1);
        JRadioButton radioButton2 = new JRadioButton("Second button", false);
        buttonGroup.add(radioButton2);
        JRadioButton radioButton3 = new JRadioButton("Third button", false);
        buttonGroup.add(radioButton3);

        final JPanel buttonsGroup = new JPanel(new GridLayout(1, 3));
        buttonsGroup.add(radioButton1);
        buttonsGroup.add(radioButton2);
        buttonsGroup.add(radioButton3);
        buttonsGroup.setLayout(new BoxLayout(buttonsGroup, BoxLayout.Y_AXIS));

        return buttonsGroup;
    }

 public JButton createAddNewButton(){
     final JButton button2 = new JButton("Add new Button");
     button2.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 3));
     button2.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
     return button2;
 }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
};

