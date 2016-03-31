import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 2016-03-27.
 */
public class Rules extends Frame
{
    Font title = new Font("Sans Serif", Font.BOLD, 20);
    public Rules()
    {
        this.width=width/2;
        this.height=height*3/4;
    }

    public void createARulesFrame (JFrame rulesFrame, JFrame mainMenuF)
    {
        JButton backButton = createAButton(width, height, 5, "BACK");
        JTextField titleRules = new JTextField();
        JTextArea rulesArea = new JTextArea();
        titleRules.setBounds(width/2-width/10,height/12,width/5,height/9);
        rulesArea.setBounds(width/20,2*height/12+height/9,width*9/10,height/2);
        rulesFrame.setResizable(false);

        titleRules.setText("ZASADY GRY");
        titleRules.setFont(title);
        titleRules.setHorizontalAlignment(JTextField.CENTER);
        rulesArea.setVisible(true);
        rulesFrame.add(rulesArea);
        rulesFrame.add(titleRules);
        titleRules.setVisible(true);
        titleRules.setEditable(false);
        titleRules.setBorder(null);

        backButton.setBounds(width/10,height/12+height/9+height/12+height/2+height/24,width/5,height/12);
        backButton.setVisible(true);
        rulesFrame.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rulesFrame.setVisible(false);
                mainMenuF.setVisible(true);
                }
        });

    }
}
