import javax.swing.*;
import java.awt.*;

/**
 * Created by Bartłomiej on 2016-03-26.
 */
public abstract class Frame {

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension dim = kit.getScreenSize();
    protected int width = (int) dim.getWidth();
    protected int height = (int) dim.getHeight();
    protected int buttonHeight = height/8;
    protected int buttonWidth = width/4;
    Font ft2 = new Font("Comic", Font.BOLD, 25);

    protected JFrame createAFrame(int width, int height, String name){

        JFrame frame = new JFrame(name);

        frame.setSize(width, height);
        frame.setResizable(true);
        frame.setLocation(150, 150);
        frame.setLayout(null);

        return frame;
    }

    protected JButton createAButton(int width, int height, int numberOfButton, String name) {
        int buttonHeight = height/8;
        int buttonWidth = width/4;
        JButton button = new JButton(name);

        button.setFont(ft2);
        button.setBackground(Color.LIGHT_GRAY);
        button.setBounds(width / 2 - (buttonWidth / 2), height / 8 +(numberOfButton*buttonHeight+numberOfButton*20), buttonWidth, buttonHeight);
        button.setBorder(null);

        return button;

    }

    public int getWidth(){return width;}
    public int getHeight(){return height;}

}
