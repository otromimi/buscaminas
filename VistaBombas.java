/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscat_unificado;
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
public class VistaBombas extends JPanel implements Observer{
    private Modelo modelo;
    private JLabel Bombas = new JLabel(); 
    private JPanel juego;
    
    public VistaBombas(Modelo m, JPanel j){
        modelo=m;
        Bombas=new JLabel("0");
        Bombas.setSize(100,30);
        Bombas.setForeground(Color.black);
        Bombas.setFont(new Font("Times New Roman", Font.BOLD,20));
        juego=j;
        j.add(Bombas);
    }
   
    public void update(Observable o, Object o1) {
        System.out.println("Bombas:"+ Integer.toString(modelo.getBombas()));
        Bombas.setText(Integer.toString(modelo.getBombas()));
        Bombas.updateUI();
    }
}
