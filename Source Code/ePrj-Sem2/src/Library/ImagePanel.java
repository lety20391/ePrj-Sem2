/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 *
 * @author Dat ThinkPad
 */

public class ImagePanel extends JPanel{
    BufferedImage objBufImg;
    String absolutePath;
    String path = "";
    
    public ImagePanel()
    {
        super();
        absolutePath = System.getProperty("user.dir");
    }
    
    public void inputImage(String relativePath)
    {
        path = absolutePath + relativePath;
    }
    
    protected void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        if (!path.isEmpty())
        {
            Graphics2D objG2D = (Graphics2D)g.create();
            try 
            {    
                objBufImg = ImageIO.read(new File(path));
    //            Graphics g = objBufImg.getGraphics();
    //            g.drawImage(objBufImg, objBufImg.getHeight(), objBufImg.getWidth(), null);            
            } catch (IOException e) 
            {
                System.out.println(e.getMessage());
            }
            objG2D.drawImage(objBufImg, 0, 0, this);
        }
    }
}
