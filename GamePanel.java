package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

/**
 * Klasa ta odpowiada za panel rozgrywki, umieszczony on jest w klasie <code>GameFrame</code>.
 *
 */
public class GamePanel extends JPanel {
    private int width,height;
    static Tank tank1;

    /**
     * Konstruktor klasy <code>GamePanel</code> przyjmuje wartości szerokości i wysokości panelu rozgrywki.
     * @param x Szerokość panelu gry
     * @param y Wysokość panelu gry
     */

    public GamePanel(int x,int y) {
        width=x;
        height=y;
        setPreferredSize(new Dimension(width, height));
        tank1 = new Tank(width,200);
    }

    /**
     * Metoda rysująca planszę w zależności od podanej jej funkcji matematycznej,
     * a także czołgi.
     *
     * @param g Kontekst graficzny
     * @return Brak
     */
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        double x,x2,y,y2;
        int[] formax = new int[2];
        loadMap(formax);

        for(int i=0;i<100;i++)
        {
            x=((double)getWidth()/100)*i;
            x2=((double)getWidth()/100)*(i+1);
            y =  200 + formax[0] * Math.sin(i/10) + formax[1];
            y2 =  200 + formax[0] * Math.sin((i+1)/10) + formax[1];
            //y=200+((Math.sin(i/10))*100);
            //y = 200 + Integer.parseInt(a) * Math.pow(i,2) + Integer.parseInt(b) + i;
            //y2 = 200 + Integer.parseInt(a) * Math.pow(i+1,2) + Integer.parseInt(b) + (i+1);
            //y2 = 200 + (Math.sin((i + 1) / 10) * 100));
            g.setColor(Color.black);
            // line[i]=new Line2D.Double(x,y,x2,y2);
            g.drawLine((int)x,(int)y,(int)x2,(int)y2);

        }
        tank1.draw(g);
        repaint();

    }

    /**
     * Metoda parsująca informacje o planszy do utworzenia z plików
     * konfiguracyjnych.
     * @return Współczynniki funkcji
     * @throws IOException
     */

    private int[] loadMap(int[] form)
    {
        String a = "1",b = "2";
        try {
            File mapFile = new File("maplvl1.properties");
            Properties pro = new Properties();
            FileInputStream fis = new FileInputStream(mapFile);
            pro.load(fis);
            a = pro.getProperty("a");
            b = pro.getProperty("b");
        } catch (IOException e) {
            e.printStackTrace();
        }
        form[0] = Integer.parseInt(a);
        form[1] = Integer.parseInt(b);

        return form;
    }

}
