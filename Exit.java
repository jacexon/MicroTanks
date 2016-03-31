import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.*;

/**
 * Created by Bartłomiej and Jacek on 2016-03-26.
 */
public class Exit extends Frame
{

    BufferedImage image;
    public Exit()
    {
        this.width=width/2;
        this.height=height*3/4;
    }
    public void createAnExitFrame (JFrame exitFrame)
    {
        JButton exitProgramButton = createAButton(width, height, 1, "YES");
        JButton dontExitButton = createAButton(width, height, 1, "NOOOOO");
        JTextField exitQuestion = new JTextField("Do you want to quit the game, bitch?");

        exitProgramButton.setBounds(buttonWidth/8, height - 2*buttonHeight+30, buttonWidth/2, buttonHeight/2);
        exitProgramButton.setVisible(true);
        exitFrame.add(exitProgramButton);

        dontExitButton.setBounds(width-buttonWidth/2-buttonWidth/8, height - 2*buttonHeight+30, buttonWidth/2, buttonHeight/2);
        dontExitButton.setVisible(true);
        exitFrame.add(dontExitButton);

        exitQuestion.setBounds(width / 2 - buttonWidth/2 , height / 2+30 ,buttonWidth,buttonHeight);
        exitQuestion.setVisible(true);
        exitQuestion.setEditable(false);
        exitQuestion.setBorder(null);
        exitQuestion.setFont(new Font("Serif", Font.ITALIC, 22));
        exitFrame.add(exitQuestion);
        exitQuestion.setVisible(true);
        try {
            URL url = new URL("http://betanews.com/wp-content/uploads/2012/03/close-button-300x300.jpg");
            image = ImageIO.read(url);

        }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        ImageIcon im = new ImageIcon(image);
        JLabel imageLabel = new JLabel(im);
        imageLabel.setVisible(true);
        imageLabel.setBounds(width/2-150,10,300,310);
        exitFrame.add(imageLabel);

        exitProgramButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(1);
            }
        });

        dontExitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                exitFrame.setVisible(false);
            }
        });


    }


}
