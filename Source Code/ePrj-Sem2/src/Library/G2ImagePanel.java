/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.CacheHint;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 *
 * @author Dat ThinkPad
 */

public class G2ImagePanel extends JPanel{
    BufferedImage objBufImg;
    String absolutePath;
    String path = "";
    Image objResizedIamge;
    int panelWidth;
    int panelHeight;
    
    public G2ImagePanel()
    {
        super();
        absolutePath = System.getProperty("user.dir");
        //prepareImage();
    }
    
    public void prepareImage()
    {
        panelWidth = this.getWidth();
        panelHeight = this.getHeight();
        if (!path.isEmpty())
        {   
            try 
            {    
                objBufImg = ImageIO.read(new File(path));
                int width = objBufImg.getWidth();
                int height = objBufImg.getHeight();
                if (objBufImg != null)
                    objResizedIamge = objBufImg.getScaledInstance(width*panelHeight/height, panelHeight, Image.SCALE_SMOOTH);
            } catch (IOException e) 
            {
                System.out.println(e.getMessage());
            }
            
        }
        
    }
    
    public void inputImage(String relativePath)
    {
        path = absolutePath + relativePath;
        prepareImage();
    }
    
    protected void paintComponent(Graphics g)
    {
        
        super.paintComponents(g);
        if (objResizedIamge != null)
        {
            Graphics2D objG2 = (Graphics2D)g.create();
            objG2.drawImage(objResizedIamge, 0, 0, null);
        }
        
    }
}
