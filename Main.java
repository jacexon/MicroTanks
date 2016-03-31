import javax.swing.*;

/**
 * Created by Bartłomiej and Jacek on 2016-03-26.
 */
public class Main {
    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        JFrame mainMenuFrame= mainMenu.createAFrame(mainMenu.getWidth(),mainMenu.getHeight(),"Micro Tanks");
        mainMenu.createFrameButtons(mainMenuFrame);
        mainMenuFrame.setVisible(true);
    }
}
