package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JToolBar;


import View.DrawFrame;
import View.ToolBarView;

public class ToolBarController implements ActionListener {
    private DrawFrame frame;
    private ToolBarView toolbarView;

    public ToolBarController(DrawFrame frame) {
        this.frame = frame;
        this.toolbarView = new ToolBarView();

        // Add action listeners to the buttons
        toolbarView.getDeleteButton().addActionListener(this);
        toolbarView.getClearButton().addActionListener(this);
        toolbarView.getRectangleButton().addActionListener(this);
        toolbarView.getSquareButton().addActionListener(this);
        toolbarView.getTriangleButton().addActionListener(this);
        toolbarView.getLineButton().addActionListener(this);
        toolbarView.getCircleButton().addActionListener(this);
        toolbarView.getEllipseButton().addActionListener(this);
        toolbarView.getEraseButton().addActionListener(this);
        toolbarView.getPencilButton().addActionListener(this);
        toolbarView.getComboBox().addActionListener(this);
        toolbarView.getUndoButton().addActionListener(this);
        toolbarView.getRedoButton().addActionListener(this);
        toolbarView.getTextButton().addActionListener(this);
        toolbarView.getImageButton().addActionListener(this);
        toolbarView.getMoveButton().addActionListener(this);
        toolbarView.getFillButton().addActionListener(this);
        toolbarView.getSaveButton().addActionListener(this);
        toolbarView.getOpenButton().addActionListener(this);
        toolbarView.getNewFileButton().addActionListener(this);
        toolbarView.getOkButton().addActionListener(this);
        toolbarView.getCancelButton().addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source == toolbarView.getClearButton()) {
            frame.getInkPanel().clear();
        } else if (source == toolbarView.getDeleteButton()) {
            frame.getInkPanel().setTool(13);
        } else if (source == toolbarView.getPencilButton()) {
            frame.getInkPanel().setTool(0);
        } else if (source == toolbarView.getLineButton()) {
            frame.getInkPanel().setTool(1);
        } else if (source == toolbarView.getRectangleButton()) {
            frame.getInkPanel().setTool(2);
        } else if (source == toolbarView.getSquareButton()) {
            frame.getInkPanel().setTool(11);
        } else if (source == toolbarView.getTriangleButton()) {
            frame.getInkPanel().setTool(9);
        } else if (source == toolbarView.getCircleButton()) {
            frame.getInkPanel().setTool(3);
        } else if (source == toolbarView.getEllipseButton()) {
            frame.getInkPanel().setTool(8);
        } else if (source == toolbarView.getTextButton()) {
            frame.getInkPanel().setTool(5);
        } else if (source == toolbarView.getImageButton()) {
            frame.getInkPanel().setTool(12);
        } else if (source == toolbarView.getMoveButton()) {
            frame.getInkPanel().setTool(10);
        } else if (source == toolbarView.getEraseButton()) {
            frame.getInkPanel().setTool(6);
        } else if (source == toolbarView.getFillButton()) {
            frame.getInkPanel().setTool(7);
        } else if (source == toolbarView.getUndoButton()) {
            frame.getInkPanel().undo();
        } else if (source == toolbarView.getRedoButton()) {
            frame.getInkPanel().redo();
        } else if (source == toolbarView.getComboBox()) {
            try {
                JComboBox<String> combo = toolbarView.getComboBox();
                String current = (String) combo.getSelectedItem();
                frame.getInkPanel().setThickness(Float.valueOf(current));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else if (source == toolbarView.getOpenButton()) {
            if (toolbarView.getFileChooser().showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File file = toolbarView.getFileChooser().getSelectedFile();
                openFile(file);
            }
        } else if (source == toolbarView.getSaveButton()) {
            if (toolbarView.getFileChooser().showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File file = new File(toolbarView.getFileChooser().getSelectedFile() + ".png");
                try {
                    saveFile(file);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } else if (source == toolbarView.getNewFileButton()) {
            toolbarView.getNewFileFrame().setVisible(true);
        } else if (source == toolbarView.getOkButton()) {
            try {
                Dimension newDimensions = new Dimension(Integer.parseInt(toolbarView.getWidthField().getText()),
                        Integer.parseInt(toolbarView.getHeightField().getText()));
                frame.getInkPanel().setInkPanel(newDimensions.width, newDimensions.height);
                setDimensions(newDimensions.width, newDimensions.height);
                toolbarView.getNewFileFrame().dispose();
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid numeric entry. A proper integer is required.",
                        "New", JOptionPane.ERROR_MESSAGE);
            }
        } else if (source == toolbarView.getCancelButton()) {
            toolbarView.getNewFileFrame().dispose();
        }
    }

    private void setDimensions(int width, int height) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        if (height > dim.height - 160 && width > dim.width - 150) {
            frame.getScrollPane().setSize(dim.width - 150, dim.height - 160);
        } else if (width > dim.width - 150) {
            frame.getScrollPane().setSize(dim.width - 150, height);
        } else if (height > dim.height - 160) {
            frame.getScrollPane().setSize(width, dim.height - 160);
        } else {
            frame.getScrollPane().setSize(width, height);
        }
    }

    private void openFile(File file) {
        try {
            frame.getInkPanel().setImage(ImageIO.read(file));
            Dimension newDimensions = new Dimension(ImageIO.read(file).getWidth(), ImageIO.read(file).getHeight());
            setDimensions(newDimensions.width, newDimensions.height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFile(File file) throws IOException {
        BufferedImage image = makePanel(frame.getInkPanel());
        ImageIO.write(image, "png", file);
    }

    private BufferedImage makePanel(JPanel panel) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        panel.print(graphics);
        return image;
    }

    public JToolBar getToolBar() {
        return toolbarView.getToolBar();
    }
}
