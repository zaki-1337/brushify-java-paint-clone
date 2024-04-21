package View;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class TextDialogView extends JDialog {
    private JTextField example;
    private JTextField input;
    private JButton ok;
    private JButton cancel;
    private JComboBox fonts;
    private JComboBox sizes;

    public TextDialogView(Frame owner) {
        super(owner, "Customize Text", true);
        this.setResizable(false);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontList = ge.getAvailableFontFamilyNames();
        String[] fontSize = {"10","20","30","40","50", "60", "70", "80", "100"};

        sizes = new JComboBox(fontSize);
        fonts = new JComboBox(fontList);

        example = new JTextField("Example");
        example.setHorizontalAlignment(SwingConstants.CENTER);
        example.setFont(new Font("sanserif", Font.PLAIN, 28));
        example.setEditable(false);
        example.setPreferredSize(new Dimension(200, 50));

        ok = new JButton("Apply");
        cancel = new JButton("Cancel");
        ok.setPreferredSize(cancel.getPreferredSize());

        input = new JTextField("Example");
        input.setPreferredSize(new Dimension(200, 50));

        JPanel p0 = new JPanel();
        p0.add(input);
        p0.setBorder(new TitledBorder(new EtchedBorder(), "Text"));

        JPanel p1 = new JPanel();
        p1.add(fonts);
        p1.setBorder(new TitledBorder(new EtchedBorder(), "Font Family"));

        JPanel p2 = new JPanel(); // use FlowLayout
        p2.add(sizes);
        p2.setBorder(new TitledBorder(new EtchedBorder(), "Font Size"));
        p2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        p3.add(example);
        p3.setPreferredSize(new Dimension(250, 60));
        p3.setMaximumSize(new Dimension(250, 60));
        p3.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel p4 = new JPanel();
        p4.add(ok);
        p4.add(cancel);
        p4.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(p0);
        p.add(Box.createRigidArea(new Dimension(0, 10)));
        p.add(p1);
        p.add(Box.createRigidArea(new Dimension(0, 10)));
        p.add(p2);
        p.add(Box.createRigidArea(new Dimension(0, 10)));
        p.add(p3);
        p.add(Box.createRigidArea(new Dimension(0, 10)));
        p.add(p4);
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.setContentPane(p);
        this.pack();
    }

    public JTextField getInputField() {
        return input;
    }

    public JComboBox getFontsComboBox() {
        return fonts;
    }

    public JComboBox getSizesComboBox() {
        return sizes;
    }

    public JButton getOkButton() {
        return ok;
    }

    public JButton getCancelButton() {
        return cancel;
    }

    public JTextField getExampleField() {
        return example;
    }
}
