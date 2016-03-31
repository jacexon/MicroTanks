import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by admin on 2016-03-27.
 */
public class BestScores extends Frame {

    public BestScores() {
        this.width = width *3/4;
        this.height = height * 3 / 4;
    }

    public void createABestScoresFrame(JFrame BestScoresFrame, JFrame mainMenuFrame){

        String chuj = "Cipka";
        JButton backToMenuButton = createAButton(width, height, 1, "Back");
        backToMenuButton.setBounds(buttonWidth/8, height - 2*buttonHeight+30, buttonWidth/2, buttonHeight/2);
        backToMenuButton.setVisible(true);
        BestScoresFrame.add(backToMenuButton);
        BestScoresFrame.setResizable(false);

        JTextField[] tanksScores1 = new JTextField[11];
        JTextField[] tanksScores2 = new JTextField[11];
        JTextField[] tanksScores3 = new JTextField[11];

        tanksScores1[0] =new JTextField("     1 TANK");
        tanksScores2[0] =new JTextField("     2 TANKS");
        tanksScores3[0] =new JTextField("     3 TANKS");
        tanksScores1[0].setEditable(false);
        tanksScores2[0].setEditable(false);
        tanksScores3[0].setEditable(false);
        tanksScores1[0].setBounds(width / 25 , (height / 12), 7 * width / 25, height/30);
        tanksScores2[0].setBounds(width / 25 + 8 * width / 25, height / 12, 7 * width / 25, height/30);
        tanksScores3[0].setBounds(width / 25 + 2 * width / 25 + 2 * 7 * width / 25, height / 12, 7 * width / 25, height/30);
        tanksScores1[0].setBorder(BorderFactory.createDashedBorder(Color.RED));
        tanksScores2[0].setBorder(BorderFactory.createDashedBorder(Color.RED));
        tanksScores3[0].setBorder(BorderFactory.createDashedBorder(Color.RED));
        tanksScores1[0].setHorizontalAlignment(JTextField.CENTER);
        tanksScores2[0].setHorizontalAlignment(JTextField.CENTER);
        tanksScores3[0].setHorizontalAlignment(JTextField.CENTER);
        tanksScores1[0].setVisible(true);
        tanksScores2[0].setVisible(true);
        tanksScores3[0].setVisible(true);
        BestScoresFrame.add(tanksScores1[0]);
        BestScoresFrame.add(tanksScores2[0]);
        BestScoresFrame.add(tanksScores3[0]);

        for (int i=1;i<11;i++){
            tanksScores1[i]=new JTextField();
            tanksScores2[i]=new JTextField();
            tanksScores3[i]=new JTextField();
            tanksScores1[i].setEditable(false);
            tanksScores2[i].setEditable(false);
            tanksScores3[i].setEditable(false);
            tanksScores1[i].setBounds(width / 25 , (height / 12) + i*height/30 + i*height/60, 7 * width / 25, height/30);
            tanksScores2[i].setBounds(width / 25 + 8 * width / 25, height / 12 + i*height/30 + i*height/60, 7 * width / 25, height/30);
            tanksScores3[i].setBounds(width / 25 + 2 * width / 25 + 2 * 7 * width / 25, height / 12 + i*height/30 + i*height/60, 7 * width / 25, height/30);
            tanksScores1[i].setBorder(BorderFactory.createLoweredBevelBorder());
            tanksScores2[i].setBorder(BorderFactory.createLoweredBevelBorder());
            tanksScores3[i].setBorder(BorderFactory.createLoweredBevelBorder());
            tanksScores1[i].setVisible(true);
            tanksScores2[i].setVisible(true);
            tanksScores3[i].setVisible(true);
            BestScoresFrame.add(tanksScores1[i]);
            BestScoresFrame.add(tanksScores2[i]);
            BestScoresFrame.add(tanksScores3[i]);

        }
        tanksScores1[1].setText(chuj);

        backToMenuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                BestScoresFrame.setVisible(false);
                mainMenuFrame.setVisible(true);
            }
        });























        /*
        oneTankScores.setBounds(width/25,height/12,7*width/25,3*height/5);
        twoTanksScores.setBounds(9*width/25, height/12 ,7*width/25,3*height/5);
        threeTanksScores.setBounds(17*width/25, height/12 ,7*width/25,3*height/5);
        oneTankScores.setBackground(Color.RED);
        twoTanksScores.setBackground(Color.YELLOW);
        threeTanksScores.setBackground(Color.GREEN);
        oneTankScores.setVisible(true);
        twoTanksScores.setVisible(true);
        threeTanksScores.setVisible(true);
        oneTankScores.setEditable(true);
        twoTanksScores.setEditable(false);
        threeTanksScores.setEditable(false);
        BestScoresFrame.add(oneTankScores);
        BestScoresFrame.add(twoTanksScores);
        BestScoresFrame.add(threeTanksScores);
*/

    }




}
