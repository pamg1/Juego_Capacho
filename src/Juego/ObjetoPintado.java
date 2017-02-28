/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author digital
 */
public class ObjetoPintado extends JPanel {
    String Texto,nImagen;
    boolean Imagen,Respuesta;
    Image ImagenT;
    Font boldFont;
    public ObjetoPintado(String Texto, String nImagen, boolean Imagen,boolean Respuesta) {
        this.Texto = Texto;
        this.nImagen = nImagen;
        this.Imagen = Imagen;
        this.Respuesta = Respuesta;
        if (Imagen) {
           this.ImagenT = new ImageIcon(getClass().getResource("Mapa_Entregas//"+nImagen+".jpg")).getImage();
        }
    }


    @Override
     protected void paintComponent(Graphics g) {
        g.drawRect(0,0,getWidth()-5,getHeight()-5);
        if (Imagen) {
            g.drawImage(ImagenT,20,20,null);
        }
        JLabel l=new JLabel(Texto);
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setFont(new Font("Verdana", Font.BOLD, 16));
        l.setForeground(Color.ORANGE);
        l.setBounds(20,20,getWidth(),getHeight()-20);
        add(l);
    }
  
    
}
