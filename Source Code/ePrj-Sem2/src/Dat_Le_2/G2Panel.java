/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dat_Le_2;

import java.awt.Color;

/**
 *
 * @author Dat ThinkPad
 */
public class G2Panel extends javax.swing.JPanel {
    public Color bgColor;
    public G2Panel(Color bgColor)
    {
        this.bgColor = bgColor;
    }
    public void setColor()
    {
        this.setBackground(bgColor);
    }
}
