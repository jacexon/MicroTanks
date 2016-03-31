import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by admin on 2016-03-27.
 */
public class BestScores extends Frame {

    public BestScores()
    {
        this.width = width *3/4;
        this.height = height * 3 / 4;
    }

    public void createABestScoresFrame(JFrame BestScoresFrame, JFrame mainMenuFrame)
    {

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



            BestScoresFrame.add(tanksScores1[i]);
            BestScoresFrame.add(tanksScores2[i]);
            BestScoresFrame.add(tanksScores3[i]);


            tanksScores1[i].setVisible(true);
            tanksScores2[i].setVisible(true);
            tanksScores3[i].setVisible(true);

        }
        readBestScores(tanksScores1,tanksScores2,tanksScores3);

        backToMenuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                BestScoresFrame.setVisible(false);
                mainMenuFrame.setVisible(true);
            }
        });
    }

        public static void readBestScores(JTextField[] v1,JTextField[] v2,JTextField[] v3)
        {
            String[] places1 = {"firstplace1", "secondplace1", "thirdplace1", "fourthplace1" , "fifthplace1",
                    "sixthplace1", "seventhplace1", "eighthplace1", "ninethplace1", "tenthplace1"};
            String[] places2 = {"firstplace2", "secondplace2", "thirdplace2", "fourthplace2" , "fifthplace2",
                    "sixthplace2", "seventhplace2", "eighthplace2", "ninethplace2", "tenthplace2"};
            String[] places3 = {"firstplace3", "secondplace3", "thirdplace3", "fourthplace3" , "fifthplace3",
                    "sixthplace3", "seventhplace3", "eighthplace3", "ninethplace3", "tenthplace3"};

            String[][] containers = new String[3][10];
            try {
                File cfgfile = new File("bestScores.properties");
                FileInputStream fis = new FileInputStream(cfgfile);
                Properties prop = new Properties();
                prop.load(fis);
                            for (int b = 0; b < 10; b++)
                            {
                                containers[0][b] = prop.getProperty(places1[b]);
                                containers[1][b] = prop.getProperty(places2[b]);
                                containers[2][b] = prop.getProperty(places3[b]);
                                v1[b + 1].setText(containers[0][b]);
                                v1[b + 1].setHorizontalAlignment(JTextField.CENTER);
                                v2[b + 1].setText(containers[1][b]);
                                v2[b + 1].setHorizontalAlignment(JTextField.CENTER);
                                v3[b + 1].setText(containers[2][b]);
                                v3[b + 1].setHorizontalAlignment(JTextField.CENTER);
                            }
                            fis.close();
                        }
            catch(FileNotFoundException e)
            {
                System.err.println("FNFException!");
                e.printStackTrace();
            }
            catch (IOException f)
            {
                System.err.println("IOException!");
                f.printStackTrace();
            }
        }



}
