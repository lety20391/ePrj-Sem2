/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.awt.Color;
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
    String absolutePath ="";
    String path = "";
    Image objResizedIamge;
    int panelWidth;
    int panelHeight;
    
    public G2ImagePanel()
    {
        super();
        //absolutePath = System.getProperty("user.dir");
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
                    //nếu hình có kích thước lớn về chiều dài thì scale theo chiều dài
                    if (width/height <= panelWidth/panelHeight)
                    {
                    objResizedIamge = objBufImg.getScaledInstance(width*panelHeight/height, panelHeight, Image.SCALE_SMOOTH);
                    }else
                    {
                        //nếu hình có kích thước lớn về chiều rộng thì scale theo chiều rộng
                        objResizedIamge = objBufImg.getScaledInstance(panelWidth, height*panelWidth/width, Image.SCALE_SMOOTH);
                    }
            } catch (IOException e) 
            {
                System.out.println(e.getMessage());
            }
            
        }
        
    }
    
    public void inputImage(String relativePath)
    {
        path = absolutePath + relativePath;
        if (path.isEmpty() || !(path.contains(".") && path.contains("\\")) )
        {
            absolutePath = System.getProperty("user.dir");
            path = absolutePath + "\\src\\Image\\sample.png";
            absolutePath = "";
        }
        System.out.println(path);
        prepareImage();
        //this.setBackground(Color.white);
        repaint();
    }
    
    protected void paintComponent(Graphics g)
    {
        
        super.paintComponents(g);
        if (objResizedIamge != null)
        {
            Graphics2D objG2 = (Graphics2D)g.create();
            objG2.setColor(this.getBackground());
            objG2.fillRect(0, 0, this.getWidth(), this.getHeight());
            objG2.drawImage(objResizedIamge, 0, 0, null);
        }
        
    }
}
