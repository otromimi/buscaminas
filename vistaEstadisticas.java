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
 * @author nacho
 */
public class vistaEstadisticas extends JPanel implements Observer{
    private Modelo modelo;
    private JLabel Facil=new JLabel();
    private JLabel Medio=new JLabel();
    private JLabel Dificil=new JLabel();
    private JPanel Estadisticas;
    private String EstadisticaFacil;
    private String EstadisticaMedio;
    private String EstadisticaDificil;

    public vistaEstadisticas(Modelo m, JPanel e) {
        modelo=m;
        if(modelo.getPuntuacionFacil()!=-1)
            Facil=new JLabel((modelo.getPuntuacionFacil()/60<=9?"0":"")+modelo.getPuntuacionFacil()/60+":"+(modelo.getPuntuacionFacil()%60<=9?"0":"")+modelo.getPuntuacionFacil()%60);
        else Facil=new JLabel("--:--");
        Facil.setSize(100,30);
        Facil.setLocation(340, 70);
        Facil.setForeground(Color.black);
        Facil.setFont(new Font("Times New Roman",Font.BOLD,20));
        if(modelo.getPuntuacionMedio()!=-1)
            Medio=new JLabel((modelo.getPuntuacionMedio()/60<=9?"0":"")+modelo.getPuntuacionMedio()/60+":"+(modelo.getPuntuacionMedio()%60<=9?"0":"")+modelo.getPuntuacionMedio()%60);
        else Medio=new JLabel("--:--");
        Medio.setSize(150,30);
        Medio.setLocation(340, 145);
        Medio.setForeground(Color.black);
        Medio.setFont(new Font("Times New Roman",Font.BOLD,20));
        if(modelo.getPuntuacionDificil()!=-1)
            Dificil=new JLabel((modelo.getPuntuacionDificil()/60<=9?"0":"")+modelo.getPuntuacionDificil()/60+":"+(modelo.getPuntuacionDificil()%60<=9?"0":"")+modelo.getPuntuacionDificil()%60);
        else Dificil=new JLabel("--:--");
        Dificil.setSize(100,30);
        Dificil.setLocation(340, 220);
        Dificil.setForeground(Color.black);
        Dificil.setFont(new Font("Times New Roman",Font.BOLD,20));
        Estadisticas=e;
        e.add(Facil);
        e.add(Medio);
        e.add(Dificil);
    }

    public void update(Observable obs, Object obj) {
        EstadisticaFacil=((modelo.getPuntuacionDificil()/60<=9?"0":"")+modelo.getPuntuacionDificil()/60+":"+(modelo.getPuntuacionDificil()%60<=9?"0":"")+modelo.getPuntuacionDificil()%60);
        Facil.setText(EstadisticaFacil);
        Facil.updateUI();
        EstadisticaMedio=((modelo.getPuntuacionDificil()/60<=9?"0":"")+modelo.getPuntuacionDificil()/60+":"+(modelo.getPuntuacionDificil()%60<=9?"0":"")+modelo.getPuntuacionDificil()%60);
        Medio.setText(EstadisticaMedio);
        Medio.updateUI();
        EstadisticaDificil=((modelo.getPuntuacionDificil()/60<=9?"0":"")+modelo.getPuntuacionDificil()/60+":"+(modelo.getPuntuacionDificil()%60<=9?"0":"")+modelo.getPuntuacionDificil()%60);
        Dificil.setText(EstadisticaDificil);
        Dificil.updateUI();
    }

}
