
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Juego;

/**
 *
 * @author digital
 */

public class Timer extends Thread{
  private int Minutos,Segundos;
  private boolean End,Pause;
  Thread tiempo;
  public Timer(int Limite){
  this.Minutos=Limite;
  this.Segundos=0;
  this.End=true;
  this.Pause=false;
  }
            @Override
            public void run() {
               while(End){
                   
                   try {
                    if (Pause==false){
                       if (Segundos==0) {
                           Segundos=60;
                           Minutos=Minutos-1;
                       }
                       Segundos=Segundos-1;
                          if (Minutos==0 && Segundos==0) {
                           End=false;
                         }
                   //System.out.println("Tiempo: " + Minutos + "-" + Segundos);
                   Thread.sleep(1000);   
                    }
                    if (Pause==true) {
                    synchronized (this) {
                    wait();
                    Pause=false;
                     }
                       }
                
                    
               } catch (Exception e) {
                   }
                   
               }   
            }
  

    public int getMinutos() {
        return Minutos;
    }

    public int getSegundos() {
        return Segundos;
    }
    public synchronized boolean isEnd() {
        return End;
    }
    
    public void pause(){
    this.Pause=true;
    }
    
    /**
     *
     */
    public synchronized void resumir(){
     notify();
    }
}
