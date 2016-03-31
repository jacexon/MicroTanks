import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 2016-03-27.
 */
public class Authors extends Frame
{
    Font title = new Font("Sans Serif", Font.BOLD, 15);

    public Authors()
    {
        this.width=width/2;
        this.height=height*3/4;
    }

    public void createAnAuthorsFrame(JFrame authorsFrame, JFrame mainMenuF)
    {
        JButton backButton = createAButton(width, height, 5, "BACK");
        JTextField titleAuthors = new JTextField();
        JTextArea authorsArea = new JTextArea();
        titleAuthors.setBounds(width/2-width/10,height/12,width/5,height/9);
        authorsArea.setBounds(width/20,2*height/12+height/9,width*9/10,height/2);
        authorsFrame.setResizable(false);

        titleAuthors.setText("ZASADY GRY");
        titleAuthors.setFont(title);
        titleAuthors.setHorizontalAlignment(JTextField.CENTER);
        authorsArea.setVisible(true);
        authorsFrame.add(authorsArea);
        authorsFrame.add(titleAuthors);
        titleAuthors.setVisible(true);
        titleAuthors.setEditable(false);
        titleAuthors.setBorder(null);

        backButton.setBounds(width/10,height/12+height/9+height/12+height/2+height/24,width/5,height/12);
        backButton.setVisible(true);
        authorsFrame.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorsFrame.setVisible(false);
                mainMenuF.setVisible(true);
            }
        });
    }

}
