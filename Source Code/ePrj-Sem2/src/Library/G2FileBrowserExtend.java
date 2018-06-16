 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Dat ThinkPad
 */
public class G2FileBrowserExtend extends JFileChooser{
    G2ImagePanel objImagePanel;
    
    public G2FileBrowserExtend()
    {
        super();
    }
    
    @Override
    protected JDialog createDialog(Component parent) throws HeadlessException 
    {
        JDialog dialog = super.createDialog(parent);

        //----------------------------------------------
        //   Tạo Panel mới ở bên Phải để preview ảnh        
        //----------------------------------------------
        //VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
        
        JPanel pPreview = new JPanel();
        Dimension dimension = new Dimension(320, 500);
        pPreview.setPreferredSize(dimension);
        Border objBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        pPreview.setBorder(objBorder);
        //pPreview.setBackground(Color.red);
//        pPreview.setLocation(x, y);
        JLabel label = new JLabel("Group2 Preview Pane");
        /*
        Set font ở đây
        */
            //label.setFont();
        pPreview.add(label);        
        
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //----------------------------------------------
        //   Tạo Panel mới ở bên Phải để preview ảnh        
        //----------------------------------------------
        
        //----------------------------------------------
        //   Thêm G2Panel để load ảnh       
        //----------------------------------------------
        //VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
        objImagePanel = new G2ImagePanel();
        dimension = new Dimension(300, 400);
        objImagePanel.setPreferredSize(dimension);
        objImagePanel.setBorder(objBorder);
        pPreview.add(objImagePanel, BorderLayout.CENTER);
        dialog.getContentPane().add(pPreview, BorderLayout.EAST);        
        dialog.pack();
        //sendDataToPreviewPane(objImagePanel);
        return dialog; 
    }
    
//    public void sendDataToPreviewPane(G2ImagePanel panel)
//    {
//        JButton btnOpen = this.getRootPane().getDefaultButton();        
//        if (btnOpen.getText().equalsIgnoreCase("open"))
//        {
//            btnOpen.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    showPreviewImage();
//                }
//            });
//            
//        }
//    }
    
    @Override
    public void setSelectedFile(File file)
    {
        super.setSelectedFile(file);
        showPreviewImage();
    }
    
    public void showPreviewImage()
    {
        String path = "";
        if (this.getSelectedFile() != null)
            path = this.getSelectedFile().getPath();
        if(!path.isEmpty() && path.contains("."))
        {
            System.out.println(path);
            objImagePanel.inputImage(path);
        }
            
    }
    
}
