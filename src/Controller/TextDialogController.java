package Controller;

import View.TextDialogView;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextDialogController implements ActionListener {
    public static final int APPLY_OPTION = 0;
    public static final int CANCEL_OPTION = 1;

    private TextDialogView view;
    private int userResponse;
    private Font mainFont;
    private String inputText;
    private  int inputSize;

    public TextDialogController(Frame owner) {
        this.view = new TextDialogView(owner);
        this.view.getOkButton().addActionListener(this);
        this.view.getCancelButton().addActionListener(this);
        this.view.getInputField().addActionListener(this);
        this.view.getFontsComboBox().addActionListener(this);
        this.view.getSizesComboBox().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source == view.getOkButton()) {
            userResponse = APPLY_OPTION;
            update();
            view.setVisible(false);
        } else if (source == view.getCancelButton()) {
            userResponse = CANCEL_OPTION;
            view.setVisible(false);
        } else {
            update();
        }
    }

    public void update() {
        inputText = view.getInputField().getText();
        inputSize = Integer.valueOf((String) view.getSizesComboBox().getSelectedItem());
        mainFont = new Font((String) view.getFontsComboBox().getSelectedItem(), Font.PLAIN, inputSize);
        view.getExampleField().setFont(mainFont);
        view.getExampleField().setText(inputText);
    }

    public Font getFont() {
        return mainFont;
    }

    public String getText() {
        return inputText;
    }

    public int getInputSize() {
		return this.inputSize;
	}

    public int showCustomDialog(Frame f) {
        view.setLocationRelativeTo(f);
        view.setVisible(true);
        return userResponse;
    }
}
