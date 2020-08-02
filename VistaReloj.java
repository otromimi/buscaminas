/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscat_unificado;

import buscat_unificado.Modelo;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Carlos
 */
public class VistaReloj extends JPanel implements Observer{
    
    private Modelo modelo;
    private JPanel juego;
    private JLabel Tiempo = new JLabel(); 
    int s,m;
    
    public VistaReloj(Modelo m, JPanel j){
        
        Tiempo=new JLabel("00:00");
        Tiempo.setForeground(Color.black);
        Tiempo.setFont(new Font("Times New Roman",Font.BOLD,20));
        modelo=m;
        juego =j;
        j.add(Tiempo);
    }
    
    

    @Override
    public void update(Observable o, Object o1) {
        String tiempo;
//        m =(int) o1/60;
//        s =(int) o1%60;
        
        System.out.println((modelo.getM()<=9?"0":"")+modelo.getM()+":"+(modelo.getS()<=9?"0":"")+modelo.getS());
        Tiempo.setText((modelo.getM()<=9?"0":"")+modelo.getM()+":"+(modelo.getS()<=9?"0":"")+modelo.getS());
        Tiempo.updateUI();
    }
    
}
