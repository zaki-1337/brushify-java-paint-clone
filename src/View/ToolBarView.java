package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ToolBarView {
    private JToolBar toolBar;
    private JButton pencil;
    private JButton line;
    private JButton rectangle;
    private JButton square;
    private JButton triangle;
    private JButton circle;
    private JButton ellipse;
    private JButton text;
    private JButton imageBtn;
    private JButton move;
    private JButton erase;
    private JButton fill;
    private JButton undo;
    private JButton redo;
    private JButton delete;
    private JButton clear;
    private JButton save;
    private JButton open;
    private JButton newFile;
    private JComboBox<String> comboBox;
    private JFileChooser fc;

    private JFrame newFileFrame;
    private JTextField widthField, heightField;
    private JButton okButton, cancelButton;

    public ToolBarView() {
        initializeFileChooser();
        initializeToolBar();
        initializeNewFileDialog();
    }

    private void initializeFileChooser() {
        fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png"));
    }

    private ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    private void initializeToolBar() {
        toolBar = new JToolBar(JToolBar.VERTICAL);
        toolBar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        toolBar.setFloatable(false);
        toolBar.setLayout(new GridLayout(24, 0));

        save = new JButton("Save", resizeImageIcon("/icons/save.png", 24, 24));
        open = new JButton("Open", resizeImageIcon("/icons/open-file.png", 28, 28));
        newFile = new JButton("New", resizeImageIcon("/icons/new-file.png", 24, 24));
        pencil = new JButton("Pencil", resizeImageIcon("/icons/pencil.png", 24, 24));
        line = new JButton("Line", resizeImageIcon("/icons/line.png", 24, 24));
        rectangle = new JButton("Rectangle", resizeImageIcon("/icons/rectangle.png", 30, 30));
        square = new JButton("Square", resizeImageIcon("/icons/square.png", 24, 24));
        triangle = new JButton("Triangle", resizeImageIcon("/icons/triangle.png", 24, 24));
        circle = new JButton("Circle", resizeImageIcon("/icons/circle.png", 24, 24));
        ellipse = new JButton("Ellipse", resizeImageIcon("/icons/ellipse.png", 30, 30));
        text = new JButton("Text", resizeImageIcon("/icons/text.png", 24, 24));
        imageBtn = new JButton("Image", resizeImageIcon("/icons/image.png", 24, 24));
        move = new JButton("Move", resizeImageIcon("/icons/move.png", 24, 24));
        fill = new JButton("Fill", resizeImageIcon("/icons/fill.png", 24, 24));
        erase = new JButton("Erase", resizeImageIcon("/icons/eraser.png", 24, 24));
        undo = new JButton("Undo", resizeImageIcon("/icons/undo.png", 24, 24));
        redo = new JButton("Redo", resizeImageIcon("/icons/redo.png", 24, 24));
        clear = new JButton("Clear", resizeImageIcon("/icons/clear.png", 24, 24));
        delete = new JButton("Delete", resizeImageIcon("/icons/delete.png", 24, 24));

        String[] items = { "Line Width", "1", "2", "3", "4", "5", "6", "7", "8" };
        comboBox = new JComboBox<>(items);
        comboBox.setMaximumSize(new Dimension(100, 25));

        toolBar.add(newFile);
        toolBar.add(open);
        toolBar.add(save);
        toolBar.addSeparator();
        toolBar.add(pencil);
        toolBar.add(line);
        toolBar.add(rectangle);
        toolBar.add(square);
        toolBar.add(triangle);
        toolBar.add(circle);
        toolBar.add(ellipse);
        toolBar.addSeparator();
        toolBar.add(text);
        toolBar.add(imageBtn);
        toolBar.add(move);
        toolBar.add(fill);
        toolBar.add(erase);
        toolBar.add(delete);
        toolBar.add(clear);
        toolBar.addSeparator();
        toolBar.add(undo);
        toolBar.add(redo);
        toolBar.addSeparator();
        toolBar.add(comboBox);
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public JButton getSaveButton() {
        return save;
    }

    public JButton getOpenButton() {
        return open;
    }

    public JButton getNewFileButton() {
        return newFile;
    }

    public JButton getPencilButton() {
        return pencil;
    }

    public JButton getLineButton() {
        return line;
    }

    public JButton getRectangleButton() {
        return rectangle;
    }

    public JButton getSquareButton() {
        return square;
    }

    public JButton getTriangleButton() {
        return triangle;
    }

    public JButton getCircleButton() {
        return circle;
    }

    public JButton getClearButton() {
        return clear;
    }

    public JButton getDeleteButton() {
        return delete;
    }

    public JButton getEllipseButton() {
        return ellipse;
    }

    public JButton getTextButton() {
        return text;
    }

    public JButton getImageButton() {
        return imageBtn;
    }

    public JButton getMoveButton() {
        return move;
    }

    public JButton getFillButton() {
        return fill;
    }

    public JButton getEraseButton() {
        return erase;
    }

    public JButton getUndoButton() {
        return undo;
    }

    public JButton getRedoButton() {
        return redo;
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }


    // Additional getters for other buttons and the file chooser

    public JFileChooser getFileChooser() {
        return fc;
    }

    private void initializeNewFileDialog() {
        newFileFrame = new JFrame("New File");
        newFileFrame.setLayout(new GridLayout(3, 2, 10, 10));
        newFileFrame.setSize(300, 150);
        newFileFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JLabel widthLabel = new JLabel("Width (px):");
        widthField = new JTextField();
        JLabel heightLabel = new JLabel("Height (px):");
        heightField = new JTextField();

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        newFileFrame.add(widthLabel);
        newFileFrame.add(widthField);
        newFileFrame.add(heightLabel);
        newFileFrame.add(heightField);
        newFileFrame.add(okButton);
        newFileFrame.add(cancelButton);

        // Center the frame
        newFileFrame.setLocationRelativeTo(null);
    }

    public JFrame getNewFileFrame() {
        return newFileFrame;
    }

    public JTextField getWidthField() {
        return widthField;
    }

    public JTextField getHeightField() {
        return heightField;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

}
