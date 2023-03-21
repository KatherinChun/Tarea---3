/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.relojdigital;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


public class RelojB extends Thread {
       
    private int hora, minutos, segundos;
    private JLabel lbl_tiempo;
    private boolean bandera;
    private boolean detenido;
    
    public RelojB(JLabel lbl_tiempo, boolean bandera) {
        this.lbl_tiempo = lbl_tiempo;
        this.bandera=bandera;
    }
    
 
    public void run(){
        while(bandera){
            
            if(detenido) {
                break;
            }
            
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RelojB.class.getName()).log(Level.SEVERE, null, ex);
            }
            segundos++;
            if(segundos >= 60){
                minutos++;
                segundos = 0;
            }
            
            if(minutos >= 60){
                hora++;
                minutos=0;
            }
            
            if(hora>=24){
                hora=0;
            }
            
            
            lbl_tiempo.setText(hora + "0"+ ":" + "0" + minutos + ":" + segundos);
        }
    }
    
    
    public void detener() {
        bandera = false;
    }
    
}
