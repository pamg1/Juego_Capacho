/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author digital
 */
public class Preguntas extends JFrame implements ActionListener {
     public Canvas c;
     public Graphics g;
     ObjetoPintado R1,R2,R3,R4;
     int AnchoF = 580;
     int IniLoc, IniLocX=20;
     int Alto = 40;
     int Verdadero;
     JButton boton1,boton2,boton3,boton4;
     JPanel Panel1;
     int Puntaje;    
     
     public Preguntas(String Pregunta,int Puntaje){
        setSize(800,700);
        IniLoc = getHeight()/2 + 40;
        setLayout(null);
        this.setResizable(false); 
        this.Puntaje=Puntaje;
        boton1=new JButton("1");
        boton1.setBounds(IniLocX,IniLoc,90,(getHeight()/2 - 80)/4);
        add(boton1);
        boton1.addActionListener(this);   
        boton2=new JButton("2");
        boton2.setBounds(IniLocX,IniLoc+(getHeight()/2 - 80)/4,90,(getHeight()/2 - 80)/4);
        add(boton2);
        boton2.addActionListener(this);   
        boton3=new JButton("3");
        boton3.setBounds(IniLocX,IniLoc+(getHeight()/2 - 80)/2,90,(getHeight()/2 - 80)/4);
        add(boton3);
        boton3.addActionListener(this);   
        boton4=new JButton("4");
        boton4.setBounds(IniLocX,IniLoc+3*(getHeight()/2 - 80)/4,90,(getHeight()/2 -80)/4);
        add(boton4);
        boton4.addActionListener(this);
        String[] PR = Pregunta.split("/");
        ObjetoPintado panelMain = new ObjetoPintado(PR[0],PR[1],true,false);
        panelMain.setBounds(20, 20, getWidth()-40,getHeight()/2);
        panelMain.setPreferredSize(new Dimension(300,100));
        add(panelMain);
        int[] Rep=new int[5];
        Random rnd = new Random();
        for (int i = 1; i <= 4; i++) {
              boolean sw=true;
                  while(sw){
                     int j = (int)(rnd.nextDouble() * 4 + 2);
                      if (j!= Rep[1] && j!= Rep[2] && j!= Rep[3] && j!= Rep[4]) {
                          Rep[i]=j;
                          if (PR[Rep[i]].equals(PR[6])) {
                              Verdadero=i;
                          }
                          sw=false;
                      }
                  }
         }
        R1=new ObjetoPintado(PR[Rep[1]],"",false,true);
        R2=new ObjetoPintado(PR[Rep[2]],"",false,true);
        R3=new ObjetoPintado(PR[Rep[3]],"",false,true);
        R4=new ObjetoPintado(PR[Rep[4]],"",false,true);  
        R1.setBounds(IniLocX+90, IniLoc, getWidth()-(IniLocX+120),(getHeight()/2 - 80)/4 + 5);
        R2.setBounds(IniLocX+90, IniLoc+(getHeight()/2 - 80)/4, getWidth()-(IniLocX+120),(getHeight()/2 - 80)/4 + 5);
        R3.setBounds(IniLocX+90, IniLoc+(getHeight()/2 - 80)/2, getWidth()-(IniLocX+120),(getHeight()/2 - 80)/4 + 5);
        R4.setBounds(IniLocX+90, IniLoc+3*(getHeight()/2 - 80)/4, getWidth()-(IniLocX+120),(getHeight()/2 - 80)/4 + 5);
        add(R1);
        add(R2);
        add(R3);
        add(R4);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
     if (ae.getSource()==boton1) {
         if (Verdadero==1) {
             Puntaje++;
         }
     }
     if (ae.getSource()==boton2) {
       if (Verdadero==2) {
             Puntaje++;
         }   
     }
     if (ae.getSource()==boton3) {
        if (Verdadero==3) {
             Puntaje++;
         }
     }
     if (ae.getSource()==boton4) {
          if (Verdadero==4) {
             Puntaje++;
         }
     }
    }
   
   
  
    
}
