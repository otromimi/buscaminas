/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscat_unificado;

import static buscat_unificado.Controlador.NumeroTema1;
import java.awt.*;  
import static java.awt.Font.BOLD;
import java.awt.event.*;  
import static java.time.Clock.system;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.text.FontWeight.BOLD;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;  
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.event.WindowEvent;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;


import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author nacho
 */
public class Controlador extends JFrame{
       // private String Imagen="tarta.jpg";private String ImagenOver="tarta pisada.png";
    private String Imagen="../imagenes/tamborVivo.png";
    private String ImagenOver="../imagenes/tambordep.png";
    private Modelo modelo=new Modelo();
   // private String Imagen="tamborVivo.png";private String ImagenOver="tambordep.png";
    
//declaracion de variables
    private JButton facil,dificil,medio,btnJugar, btnAyuda; 
    private JButton btnTarta, btnTomate, btnTambor;
    private JButton btnTema1, btnTema2,btnTema3;
    private JPanel dificultad = new JPanel();
    private JPanel Jugar= new JPanel();
    private JPanel ElegirFigura= new JPanel();
    private JPanel Estadisticas = new JPanel();
   
    private Color Color1= new Color(190,238,247);
    private Color Color2= new Color(111,194,208);
    private Color Color3= new Color(69,146,175);
    private Color Color4= new Color(255,130,70);
    
    private Color temaRojo= new Color(250,70,89);
    private Color temaAmarillo= new Color(254,255,228);
    private Color temaVerdeClaro= new Color(163,222,131);
    private Color temaVerdeOscuro= new Color(46,184,114);
    private Color temaVerde= new Color(37,147,91);
    
    private Color temaRosa= new Color(242,53,87);
    private Color temaAmarilloOscuro= new Color(240,212,58);
    private Color temaAzulClaro= new Color(34,178,218);
    private Color temaAzulOscuro= new Color(0,153,117);
    
    private Color ColorFacil= new Color(161,222,147);
    private Color ColorMedio= new Color(247,244,139);
    private Color ColorDificil= new Color(244,128,128);
    private Color ColorJugar= new Color(249,248,235);
    private Font fuente1=new Font("Times New Roman", Font.BOLD + Font.ITALIC, 25);
    private Font fuente2=new Font("Times New Roman", Font.BOLD + Font.ITALIC, 40);
    
    private ImageIcon IconTarta;
    private ImageIcon IconTomate;
    private ImageIcon IconTambor;
    private ImageIcon IconAyuda;
    private ImageIcon IconMedioNegro;
    private ImageIcon IconFacilNegro;
    private ImageIcon IconDificilNegro;
    
    private JLabel etiqueta1= new JLabel("Elije ");
    private JLabel etiqueta2= new JLabel("la dificultad...");
    private JLabel etiqueta4= new JLabel("Elije un objeto");
    private JLabel etiquetaEstadistica1= new JLabel("EL récord en modo FÁCIL es...");
    private JLabel etiquetaEstadistica2= new JLabel("El récord en modo MEDIO es...");
    private JLabel etiquetaEstadistica3= new JLabel("EL récord en modo DIFÍCIL es...");
    private JLabel etiquetaEstadistica4= new JLabel("ESTADÍSTICAS");
    private JLabel etiquetaTiempo1= new JLabel("minutos");
    private JLabel etiquetaTiempo2= new JLabel("minutos");
    private JLabel etiquetaTiempo3= new JLabel("minutos");
    private static ArrayList<Integer> puntuaciones;
    private int bombas=0;
                

    //MVC
    
//  private VistaEstadisticas vistaEst=new VistaEstadisticas(modelo);
   

    public static int NumeroTema1; 
    public static Menu menu;
    
    public void configurarControlador(int NumeroTema) throws IOException, FileNotFoundException, ClassNotFoundException{
        modelo.cargarDatos();
        puntuaciones = new ArrayList();
        for (int i=0;i<puntuaciones.size();i++){
            System.out.println("Estadisticas:\n"+puntuaciones.get(i));
        }
        modelo.LanzarMenu(NumeroTema1);
    }
}

  class Menu extends JFrame{
    
    private JButton facil,dificil,medio,btnJugar, btnAyuda; 
    private JButton btnTarta, btnTomate, btnTambor;
    private JButton btnTema1, btnTema2,btnTema3;
    private JPanel dificultad = new JPanel();
    private JPanel Jugar= new JPanel();
    private JPanel ElegirFigura= new JPanel();
    private JPanel Estadisticas = new JPanel();
   
    private Color Color1= new Color(190,238,247);
    private Color Color2= new Color(111,194,208);
    private Color Color3= new Color(69,146,175);
    private Color Color4= new Color(255,130,70);
    
    private Color temaRojo= new Color(250,70,89);
    private Color temaAmarillo= new Color(254,255,228);
    private Color temaVerdeClaro= new Color(163,222,131);
    private Color temaVerdeOscuro= new Color(46,184,114);
    private Color temaVerde= new Color(37,147,91);
    
    private Color temaRosa= new Color(242,53,87);
    private Color temaAmarilloOscuro= new Color(240,212,58);
    private Color temaAzulClaro= new Color(34,178,218);
    private Color temaAzulOscuro= new Color(0,153,117);
    
    private Color ColorFacil= new Color(161,222,147);
    private Color ColorMedio= new Color(247,244,139);
    private Color ColorDificil= new Color(244,128,128);
    private Color ColorJugar= new Color(249,248,235);
    private Font fuente1=new Font("Times New Roman", Font.BOLD + Font.ITALIC, 25);
    private Font fuente2=new Font("Times New Roman", Font.BOLD + Font.ITALIC, 40);
    
    private ImageIcon IconTarta;
    private ImageIcon IconTomate;
    private ImageIcon IconTambor;
    private ImageIcon IconAyuda;
    private ImageIcon IconMedioNegro;
    private ImageIcon IconFacilNegro;
    private ImageIcon IconDificilNegro;
    
    private JLabel etiqueta1= new JLabel("Elige ");
    private JLabel etiqueta2= new JLabel("la dificultad...");
    private JLabel etiqueta4= new JLabel("Elige un objeto");
    private JLabel etiquetaEstadistica1= new JLabel("EL récord en modo FÁCIL es...");
    private JLabel etiquetaEstadistica2= new JLabel("El récord en modo MEDIO es...");
    private JLabel etiquetaEstadistica3= new JLabel("EL récord en modo DIFÍCIL es...");
    private JLabel etiquetaEstadistica4= new JLabel("ESTADÍSTICAS");
    private JLabel etiquetaTiempo1= new JLabel("minutos");
    private JLabel etiquetaTiempo2= new JLabel("minutos");
    private JLabel etiquetaTiempo3= new JLabel("minutos");
    
    private String Imagen="../imagenes/tamborVivo.png";
    private String ImagenOver="../imagenes/tambordep.png";
    private Modelo modelo =new Modelo();
    private vistaEstadisticas vistaEstadisticas = new vistaEstadisticas(modelo, Estadisticas);

//    private VistaEstadisticas vistaEst=new VistaEstadisticas(modelo);
    

   

//    public static int NumeroTema1;
    int nivel=0;
    
    public Menu(int NumeroTema){
        
        NumeroTema1=NumeroTema;
        
        setTitle("BuscaT");
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.fill=GridBagConstraints.BOTH;
        
        dificultad.setBackground(Color3);
        Jugar.setBackground(Color4);
        Estadisticas.setBackground(Color2);
        ElegirFigura.setBackground(Color1);
        
        gb.gridwidth=1;
        gb.gridheight=2;
        modelo.agrega(dificultad,gb,this,0,0);
        gb.gridheight=1;
        modelo.agrega(ElegirFigura,gb,this,1,0);
        modelo.agrega(Estadisticas,gb,this,1,1);
        gb.gridheight=1;
        gb.gridwidth=2;
        modelo.agrega(Jugar,gb,this,0,2);
        
        
        facil= new JButton();
              
        IconFacilNegro= new ImageIcon(getClass().getResource("../imagenes/BotonFacilNegro.png"));
        IconMedioNegro= new ImageIcon(getClass().getResource("../imagenes/BotonMedioNegro.png"));
        IconDificilNegro= new ImageIcon(getClass().getResource("../imagenes/BotonDificilNegro.png"));

        
        facil.setIcon(IconFacilNegro);
        facil.setBackground(ColorJugar);
        facil.setToolTipText("4X4 CON 4 MINAS");
        dificil= new JButton();
        dificil.setIcon(IconDificilNegro);
        dificil.setBackground(ColorJugar);
        dificil.setToolTipText("8X8 CON 10 MINAS");
        medio= new JButton();
        medio.setIcon(IconMedioNegro);
        medio.setFont(fuente1);
        medio.setBackground(ColorJugar);
        medio.setToolTipText("16X16 CON 40 MINAS");
        btnJugar= new JButton("¡JUGAR!");
        btnJugar.setFont(fuente1);
        btnJugar.setBackground(ColorJugar);
        btnJugar.setToolTipText("COMENZAR A JUGAR CON LAS OPCIONES SELECCIONADAS");
       
        dificultad.setPreferredSize(new Dimension(450,500));
        Estadisticas.setPreferredSize(new Dimension(550,300));
        ElegirFigura.setPreferredSize(new Dimension(550,300));
        Jugar.setPreferredSize(new Dimension(750,100));
        setBounds(0, 0, 300, 600);
       
        dificultad.setLayout(null);
        etiqueta1.setLocation(100,5);
        etiqueta1.setSize(400,200);
        etiqueta1.setFont(fuente2);
        etiqueta2.setLocation(180,40);
        etiqueta2.setSize(400,200);
        etiqueta2.setFont(fuente2);
        facil.setLocation(100,200);
        facil.setSize(250,70);
        medio.setLocation(100,300);
        medio.setSize(250,70);
        dificil.setLocation(100,400);
        dificil.setSize(250,70);
        
       
        etiqueta2.setForeground(Color.black);
        etiqueta2.setFont(new Font("Times New Roman",Font.BOLD+Font.ITALIC ,30));
        
        etiqueta1.setForeground(Color.black);
        etiqueta1.setFont(new Font("Times New Roman",Font.BOLD+ Font.ITALIC,30));
        
        etiqueta4.setForeground(Color.black);
        etiqueta4.setFont(new Font("Times New Roman",Font.BOLD+ Font.ITALIC,30));
                
        dificultad.add(etiqueta1);
        dificultad.add(etiqueta2);
        dificultad.add(facil);
        dificultad.add(medio);
        dificultad.add(dificil);
               
        Jugar.setLayout(null);
        btnJugar.setLocation(350,15);
        btnJugar.setSize(250,70);
        Jugar.add(btnJugar);
        btnAyuda= new JButton();
        IconAyuda= new ImageIcon(getClass().getResource("../imagenes/ayuda.png"));
        btnAyuda.setBackground(Color4);
        btnAyuda.setIcon(IconAyuda);
        btnAyuda.setLocation(900,0);
        btnAyuda.setSize(100,100);
        btnAyuda.setToolTipText("AYUDA");
        Jugar.add(btnAyuda);
        
        btnTema1= new JButton("TEMA 1");
        btnTema1.setBackground(Color4);
        btnTema1.setLocation(0,0);
        btnTema1.setSize(100,33);
        Jugar.add(btnTema1);
        btnTema2= new JButton("TEMA 2");
        btnTema2.setBackground(Color4);
        btnTema2.setLocation(0,33);
        btnTema2.setSize(100,33);
        Jugar.add(btnTema2);
        btnTema3= new JButton("TEMA 3");
        btnTema3.setBackground(Color4);
        btnTema3.setLocation(0,66);
        btnTema3.setSize(100,33);
        Jugar.add(btnTema3);
        
        ElegirFigura.setLayout(null);
        btnTarta= new JButton();
        IconTarta= new ImageIcon(getClass().getResource("../imagenes/tarta.png"));
        btnTarta.setBackground(ColorJugar);
        btnTarta.setIcon(IconTarta);
        btnTarta.setLocation(55,115);
        btnTarta.setSize(140,140);
        btnTarta.setToolTipText("ELEGIR TARTA");
        btnTomate= new JButton();
        IconTomate= new ImageIcon(getClass().getResource("../imagenes/tomate.png"));
        btnTomate.setBackground(ColorJugar);
        btnTomate.setIcon(IconTomate);
        btnTomate.setLocation(200,115);
        btnTomate.setSize(145,140);
        btnTomate.setToolTipText("ELEGIR TOMATE");
        btnTambor= new JButton();
        IconTambor= new ImageIcon(getClass().getResource("../imagenes/tambor.png"));
        btnTambor.setBackground(ColorJugar);
        btnTambor.setIcon(IconTambor);
        btnTambor.setLocation(355,115);
        btnTambor.setSize(140,140);
        btnTambor.setToolTipText("ELEGIR TAMBOR");
        
        btnTema1.setToolTipText("Cambiar al tema 1");
        btnTema2.setToolTipText("Cambiar al tema 2");
        btnTema3.setToolTipText("Cambiar al tema 3");
        
        etiqueta4.setLocation(150,20);
        etiqueta4.setSize(700,100);
        etiqueta4.setFont(fuente2);
        
        ElegirFigura.add(btnTarta);
        ElegirFigura.add(btnTomate);
        ElegirFigura.add(btnTambor);
        ElegirFigura.add(etiqueta4);
//        poner predeterminado la opcion facil

        facil.setDisabledIcon(IconFacilNegro);
        facil.setEnabled(false);
        medio.setEnabled(true);
        facil.setBackground(ColorFacil);
        dificil.setEnabled(true);
        medio.setBackground(ColorJugar);
        dificil.setBackground(ColorJugar);
        
//        poner predeterminado la opcion de la tarta
        btnTarta.setDisabledIcon(IconTarta);
        btnTarta.setBackground(ColorMedio);
        btnTarta.setEnabled(false);
        btnTomate.setEnabled(true);
        btnTomate.setBackground(ColorJugar);
        btnTambor.setEnabled(true);
        btnTambor.setBackground(ColorJugar);
        
        
        Estadisticas.setLayout(null);
        
        etiquetaEstadistica1.setForeground(Color.black);
        etiquetaEstadistica1.setFont(new Font("Times New Roman",Font.BOLD+ Font.ITALIC,20));
        etiquetaEstadistica1.setLocation(50,75);
        etiquetaEstadistica1.setSize(450, 20);
        
        etiquetaEstadistica2.setForeground(Color.black);
        etiquetaEstadistica2.setFont(new Font("Times New Roman",Font.BOLD+ Font.ITALIC,20));
        etiquetaEstadistica2.setLocation(50,150);
        etiquetaEstadistica2.setSize(450, 20);
        
        etiquetaEstadistica3.setForeground(Color.black);
        etiquetaEstadistica3.setFont(new Font("Times New Roman",Font.BOLD+ Font.ITALIC,20));
        etiquetaEstadistica3.setLocation(50,225);
        etiquetaEstadistica3.setSize(450, 20);
        
        etiquetaEstadistica4.setForeground(Color.black);
        etiquetaEstadistica4.setFont(fuente2);
        etiquetaEstadistica4.setLocation(137,5);
        etiquetaEstadistica4.setSize(500, 45);
        
        etiquetaTiempo1.setForeground(Color.black);
        etiquetaTiempo1.setFont(new Font("Times New Roman",Font.BOLD+ Font.ITALIC,20));
        etiquetaTiempo1.setLocation(425,75);
        etiquetaTiempo1.setSize(450, 20);
        
      
        etiquetaTiempo2.setForeground(Color.black);
        etiquetaTiempo2.setFont(new Font("Times New Roman",Font.BOLD+ Font.ITALIC,20));
        etiquetaTiempo2.setLocation(425,150);
        etiquetaTiempo2.setSize(450, 20);
        
        etiquetaTiempo3.setForeground(Color.black);
        etiquetaTiempo3.setFont(new Font("Times New Roman",Font.BOLD+ Font.ITALIC,20));
        etiquetaTiempo3.setLocation(425,225);
        etiquetaTiempo3.setSize(450, 20);
        
//        modelo.addObserver(vistaEst);
        
        Estadisticas.add(etiquetaEstadistica4);
        Estadisticas.add(etiquetaEstadistica1);
        Estadisticas.add(etiquetaEstadistica2);
        Estadisticas.add(etiquetaEstadistica3);
        Estadisticas.add(etiquetaTiempo1);
        Estadisticas.add(etiquetaTiempo2);
        Estadisticas.add(etiquetaTiempo3);
//        Estadisticas.add(vistaEst);
//      Aqui iba la vista
        if(NumeroTema==1){
            dificultad.setBackground(temaVerde);
                Jugar.setBackground(temaRojo);
                Estadisticas.setBackground(temaVerdeClaro);
                ElegirFigura.setBackground(temaVerdeOscuro);
                btnAyuda.setBackground(temaRojo);
                btnTema1.setBackground(temaRojo);
                btnTema1.setBackground(temaRojo);
                btnTema2.setBackground(temaRojo);
                btnTema3.setBackground(temaRojo);
                NumeroTema1=1;
        }else if(NumeroTema==2){
            dificultad.setBackground(temaAmarilloOscuro);
                Jugar.setBackground(temaAzulOscuro);
                Estadisticas.setBackground(temaRosa);
                ElegirFigura.setBackground(temaAzulClaro);
                btnAyuda.setBackground(temaAzulOscuro);
                btnTema1.setBackground(temaAzulOscuro);
                btnTema1.setBackground(temaAzulOscuro);
                btnTema2.setBackground(temaAzulOscuro);
                btnTema3.setBackground(temaAzulOscuro);
                NumeroTema1=2;
        }else if(NumeroTema==3){
             dificultad.setBackground(Color3);
                Jugar.setBackground(Color4);
                Estadisticas.setBackground(Color2);
                ElegirFigura.setBackground(Color1);
                btnAyuda.setBackground(Color4);
                btnTema1.setBackground(Color4);
                btnTema1.setBackground(Color4);
                btnTema2.setBackground(Color4);
                btnTema3.setBackground(Color4);
                NumeroTema1=3;
        }        
        
        facil.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                facil.setDisabledIcon(IconFacilNegro);
                facil.setEnabled(false);
                medio.setEnabled(true);
                facil.setBackground(ColorFacil);
                dificil.setEnabled(true);
                medio.setBackground(ColorJugar);
                dificil.setBackground(ColorJugar);
                nivel=0;
                
            }
        }); 
        medio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                facil.setEnabled(true);
                medio.setEnabled(false);
                dificil.setEnabled(true);
                medio.setDisabledIcon(IconMedioNegro);
                medio.setBackground(ColorMedio);
                facil.setBackground(ColorJugar);
                dificil.setBackground(ColorJugar);
                nivel=1;
            }
        }); 
        
        dificil.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                facil.setEnabled(true);
                medio.setEnabled(true);
                dificil.setEnabled(false);
                dificil.setDisabledIcon(IconDificilNegro);
                dificil.setBackground(ColorDificil);
                medio.setBackground(ColorJugar);
                facil.setBackground(ColorJugar);
                nivel=2;
            }
        }); 
        
        btnTarta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                btnTarta.setDisabledIcon(IconTarta);
                btnTarta.setBackground(ColorMedio);
                btnTarta.setEnabled(false);
                btnTomate.setEnabled(true);
                btnTomate.setBackground(ColorJugar);
                btnTambor.setEnabled(true);
                btnTambor.setBackground(ColorJugar);
                  Imagen="../imagenes/tartaIcon.jpg";
                ImagenOver="../imagenes/tarta pisada.png";
            }
        }); 
        
        btnTomate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                btnTomate.setDisabledIcon(IconTomate);
                btnTarta.setEnabled(true);
                btnTarta.setBackground(ColorJugar);
                btnTomate.setEnabled(false);
                btnTomate.setBackground(ColorMedio);
                btnTambor.setEnabled(true);
                btnTambor.setBackground(ColorJugar);
                  Imagen="../imagenes/tomate vivo.png";
                ImagenOver="../imagenes/tomatedep.png";
            }
        }); 
        
        btnTambor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                btnTarta.setEnabled(true);
                btnTarta.setBackground(ColorJugar);
                btnTambor.setDisabledIcon(IconTambor);
                btnTomate.setEnabled(true);
                btnTomate.setBackground(ColorJugar);
                btnTambor.setEnabled(false);
                btnTambor.setBackground(ColorMedio);
              
                 Imagen="../imagenes/tamborVivo.png";
                ImagenOver="../imagenes/tambordep.png";
            }
        });
        
        btnTema1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                dificultad.setBackground(temaVerde);
                Jugar.setBackground(temaRojo);
                Estadisticas.setBackground(temaVerdeClaro);
                ElegirFigura.setBackground(temaVerdeOscuro);
                btnAyuda.setBackground(temaRojo);
                btnTema1.setBackground(temaRojo);
                btnTema1.setBackground(temaRojo);
                btnTema2.setBackground(temaRojo);
                btnTema3.setBackground(temaRojo);
                NumeroTema1=1;
            }
        }); 
        
        btnTema2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                dificultad.setBackground(temaAmarilloOscuro);
                Jugar.setBackground(temaAzulOscuro);
                Estadisticas.setBackground(temaRosa);
                ElegirFigura.setBackground(temaAzulClaro);
                btnAyuda.setBackground(temaAzulOscuro);
                btnTema1.setBackground(temaAzulOscuro);
                btnTema1.setBackground(temaAzulOscuro);
                btnTema2.setBackground(temaAzulOscuro);
                btnTema3.setBackground(temaAzulOscuro);
                NumeroTema1=2;
            }
        }); 
        
        btnTema3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                dificultad.setBackground(Color3);
                Jugar.setBackground(Color4);
                Estadisticas.setBackground(Color2);
                ElegirFigura.setBackground(Color1);
                btnAyuda.setBackground(Color4);
                btnTema1.setBackground(Color4);
                btnTema1.setBackground(Color4);
                btnTema2.setBackground(Color4);
                btnTema3.setBackground(Color4);
                NumeroTema1=3;
                
            }
        });
        
          btnAyuda.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               // dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
               modelo.LanzarAyuda(NumeroTema1);
            }});
          btnJugar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               // dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
               //new Juego(NumeroTema1);
               dispose();
               EventQueue.invokeLater(new Runnable(){ 
                 public void run(){
                    modelo.LanzarJuego(NumeroTema1,nivel );
                }});}
        }); 
            
         modelo.addObserver(vistaEstadisticas);
          
        pack();
        setVisible(true); 
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);
        }
    
        
    }

 class Juego extends JFrame{
    //Inicio variables Juego
    JPanel marco=new JPanel();
    
    
    private JButton b[];
    private GridBagConstraints gbc ;
    private campoM cuadro;
    
    private Color Color1= new Color(190,238,247);
    private Color Color2= new Color(111,194,208);
    private Color Color3= new Color(69,146,175);
    private Color Color4= new Color(255,130,70);
    
    private Color temaRojo= new Color(250,70,89);
    private Color temaAmarillo= new Color(254,255,228);
    private Color temaVerdeClaro= new Color(163,222,131);
    private Color temaVerdeOscuro= new Color(46,184,114);
    private Color temaVerde= new Color(37,147,91);
    
    private Color temaRosa= new Color(242,53,87);
    private Color temaAmarilloOscuro= new Color(240,212,58);
    private Color temaAzulClaro= new Color(34,178,218);
    private Color temaAzulOscuro= new Color(0,153,117);
    
    private Color ColorFacil= new Color(161,222,147);
    private Color ColorMedio= new Color(247,244,139);
    private Color ColorDificil= new Color(244,128,128);
    private Color ColorJugar= new Color(249,248,235);
    
    private JButton volverMenu, Reiniciar, btnAyuda; 
    private JPanel tiempo = new JPanel();
    private JPanel juego= new JPanel();
    private JPanel menu = new JPanel();
    
    private JLabel contTiempo = new JLabel("Tiempo");
    private JLabel minas = new JLabel("Nº minas");
    private Font fuente1=new Font("Times New Roman", Font.BOLD + Font.ITALIC, 25);
    private Font fuente2=new Font("Times New Roman", Font.BOLD + Font.ITALIC, 40);
    
    private ImageIcon IconAyuda;
     private JLabel etiqueta2= new JLabel("la dificultad...");
     private String Imagen="../imagenes/tamborVivo.png";
     private String ImagenOver="../imagenes/tambordep.png";
    private int bl;
    private JTextArea etiqueta2Juego;
    int cant=40;
    
    private Modelo modelo = new Modelo();
    public int s,m;
    private JPanel etiquetaTiempo = new JPanel();
    private JPanel etiquetaBombas= new JPanel();
    private VistaReloj vistaReloj = new VistaReloj(modelo, etiquetaTiempo);
    private VistaBombas vistaBombas= new VistaBombas(modelo, etiquetaBombas);
    private final int intervalo = 1000;
    private Timer t;
    boolean cronometro = false; //false cuando el cronometro esta parado
    private int numero;
    
    

    //FinVariablesJuego
    public Juego(int NumeroTema,int nivel){
        
        //CONTROLADOR DEL JUEGO: INICIO//
        GridBagLayout layout = new GridBagLayout();   
        marco.setPreferredSize(new Dimension(1000,600));
        marco.setLayout(layout);
        marco.setBounds(500, 500, 500, 500);
        
        
        setTitle("BuscaT");
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();    // quitado por nacho al unificar
        gb.fill=GridBagConstraints.BOTH;
        
        tiempo.setPreferredSize(new Dimension(900,50));
        juego.setPreferredSize(new Dimension(1000,600));
        menu.setPreferredSize(new Dimension(900,100));
        setBounds(0, 0, 300, 600);
        
        tiempo.setBackground(Color3);
        juego.setBackground(Color1);
        menu.setBackground(Color2);
        
        
        modelo.agrega(tiempo,gb,this,0,0);
        modelo.agrega(juego,gb,this,0,1);
        modelo.agrega(menu,gb,this,0,2);
        
        menu.setLayout(null);
              
        
        volverMenu= new JButton("Inicio");
        volverMenu.setFont(fuente1);
        volverMenu.setBackground(ColorJugar);
        volverMenu.setLocation(50,15);
        volverMenu.setSize(200, 70);
        menu.add(volverMenu);
        
        Reiniciar= new JButton("Reiniciar");
        Reiniciar.setFont(fuente1);
        Reiniciar.setBackground(ColorJugar);
        Reiniciar.setLocation(300,15);
        Reiniciar.setSize(200, 70);
        menu.add(Reiniciar);
        
        btnAyuda= new JButton();
        IconAyuda= new ImageIcon(getClass().getResource("../imagenes/ayuda.png"));
        btnAyuda.setBackground(Color2);
        btnAyuda.setIcon(IconAyuda);
        btnAyuda.setLocation(900,0);
        btnAyuda.setSize(100,100);
        menu.add(btnAyuda);
               
        if(NumeroTema==1){
            tiempo.setBackground(temaVerdeOscuro);
            juego.setBackground(Color1);
            menu.setBackground(temaRojo);
            btnAyuda.setBackground(temaRojo);
        }else if(NumeroTema==2){
            tiempo.setBackground(temaAmarilloOscuro);
            juego.setBackground(temaAzulOscuro);
            menu.setBackground(temaAzulOscuro);
            btnAyuda.setBackground(temaAzulOscuro);
        }else if(NumeroTema==3){
            tiempo.setBackground(Color3);
            juego.setBackground(Color1);
            menu.setBackground(Color2);
            btnAyuda.setBackground(Color2);
        }
       
        tiempo.setLayout(null);
        contTiempo.setSize(125  ,25);
        contTiempo.setLocation(518, 10);
        contTiempo.setFont(fuente1);
        minas.setSize(100  ,25);
        minas.setLocation(300, 10);
        minas.setFont(fuente1);
        tiempo.add(contTiempo);
        tiempo.add(minas);
        
//        etiqueta2Juego=new JTextArea("40");
//        etiqueta2Juego.setForeground(Color.black);
//        etiqueta2Juego.setFont(new Font("Times New Roman",Font.BOLD,12));
//        tiempo.add(etiqueta2Juego);
        
        etiquetaTiempo.setFont(fuente1);
        etiquetaTiempo.setLocation(600, 10);
        etiquetaTiempo.setSize(100, 30);
        
        tiempo.add(etiquetaTiempo);
        etiquetaTiempo.setVisible(true);     
        
        etiquetaBombas.setFont(fuente1);
        etiquetaBombas.setLocation(400, 10);
        etiquetaBombas.setSize(100, 30);
        
        tiempo.add(etiquetaBombas);
        etiquetaBombas.setVisible(true);   
       
       gbc = new GridBagConstraints();
  
      juego.setLayout(layout);
      juego.setBounds(500, 500, 500, 500);
      cuadro=new campoM();
      int alt=500;
      int anc=500;
      
      
      modelo.addObserver(vistaReloj);
      modelo.addObserver(vistaBombas);
    

      
      //CONTROLADOR DEL JUEGO: FIN//
      //---------------------------------------------------------------------------------
        // le pasamos el marco al juego
    
        botones2(cuadro,anc, alt, gbc,nivel ); 
           juego.add(marco);

    
        btnAyuda.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               // dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
               modelo.LanzarAyuda(NumeroTema1);
               
            }
        }); 
        
        volverMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               //dispatchEvent(new WindowEvent(juego,WindowEvent.WINDOW_CLOSING));
               modelo.LanzarMenu(NumeroTema1);
               dispose();
               
            }
        }); 
        
        Reiniciar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                dispose();
               modelo.LanzarJuego(NumeroTema1,nivel);
               
               
            }
        }); 
        
        pack();
        setVisible(true); 
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);
        
    }
    
    
    
    public void botones(campoM cuadro,int anc,int alt,GridBagConstraints gbc,int y,int nivel ) throws IOException{ /*SEGUNDO MARCO DE BOTONES DONDE ESTAN LAS MINAS*/
       
       // VALORES DE LOS TAMAÑOS DEL CAMPO
       int val=41;
       if (nivel==0) val=5;
       if (nivel==1) val=11;
       if (nivel==2) val=41;
    
    int[] arr=new int [val];
    boolean flag;
    int probe=0, tam=0, d=0, ps=0;
    if(val==5)tam=15;
    if(val==11)tam=63;
    if(val==41)tam=256;         //siempre es esto? val no cambia, ahora si cambia
    if(val==11)d=8;
    if(val==5)d=4;
    if(val==41)d=16;
    bl=tam-d+1;
    //CREA LAS MINAS DE FORMA ALEATORIO ; EVADIENDO EL PRIMER SITIO PULSADO
    for(int j=0;j<val-1;j++){
        flag=false; 
        while(flag==false){
            probe=(int) (Math.random()*tam); 
            int sec=0;                      //que es sec? (es como un flag)
            if(probe!=y){
                for(int h=0;h<val-1;h++){  
                    if((arr[h]==probe)) sec++;  
                } 
                if (sec==0) flag=true;
            }  
        }
             arr[j]=probe; 
    }
    //ORDENA LOS VALORES ALEATORIOS, DE MENOR A MAYOR
    int menor;
   /* 
  for (int x = 0; x < arr.length; x++) {
        for (int i = 0; i < arr.length-x-1; i++) {
            if(arr[i] < arr[i+1]){
                int tmp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = tmp;
            }
        }
    }*/
    
    for (int x = 0; x < arr.length-1; x++) {
        System.out.println("-----------");
        System.out.println(x);
        for (int i = 0; i < arr.length-x-2; i++) {if(arr[i] > arr[i+1]){ 
            int tmp=arr[i+1];arr[i+1]=arr[i];arr[i]=tmp;
            System.out.println(tmp);}
        }
    }
       arr[val-1]=0;
       //modificacion charly 02/06//
       //creo una variable numero donde guardo el numero de minas//
       //se la paso al metodo que se encuentra en el modelo para que lo almacene y use//
       numero=arr.length-1;
       modelo.setBombas(numero);
       //FIN CHARLY
       
        // CREA EL CAMPO AÑADIENDO LAS MINAS A LOS BOTONES
        cuadro.insertar2(arr);
        // CREA LA NUMERACIÓN DE LOS BOTONES SIN MINA
        cuadro.avisar();
        JLabel imagen[]=new JLabel[324];
        int h=0;
        // AÑADE LOS BOTONES AL PANEL
     for (int i=0;i<d;i++){
          if(i%2!=0)h=h+d+1;
          for(int j=0;j<d;j++){
                ps++;
                if((i%2==0)&&(i!=0))if((j)%d==0)h=h+d-1;
                if(i%2==0)h=h+1;if(i%2!=0)h=h-1;
                int mat=h-1;
                int z=h-1;
                // COSAS QUE HACE EL BOTON; AL PRESIONARSE CON EL BOTON DERECHO
                cuadro.retornar(mat).addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    System.out.println("-----------------");
                        ((JComponent) event.getSource()).setVisible(false);
                        int j=((Nodo) event.getSource()).pos;
                        if(((Nodo) event.getSource()).val==-1){
                            //nacho 31/5
                            if(cronometro){
                                modelo.parar();
                                cronometro=false;
                            }
                            //finNacho
                            // System.out.println("que"); //traza
                            etiqueta2.setText( Integer.toString(cant));
                            cuadro.visibilizar();
                            ((Nodo) event.getSource()).img.setIcon(new ImageIcon(getClass().getResource(ImagenOver)));
                            modelo.parar();
                            JOptionPane.showMessageDialog(null, "\n\t\t Intentalo de nuevo. ", "Has perdido", JOptionPane. ERROR_MESSAGE);
                            modelo.LanzarJuego(NumeroTema1, nivel);
                            dispose();
                            
                        }else if(((Nodo) event.getSource()).val==0){
                            cuadro.anular(j,cuadro,cuadro.retornar(j));
                        }
                        
                        System.out.println(cuadro.comprobar());
                        if(cuadro.comprobar()==true){
                            etiqueta2.setText(Integer.toString(cant));
                            
                            modelo.parar();
                        try {
                            modelo.ganador(nivel);
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                            
                            cuadro.visibilizar();
                            JOptionPane.showMessageDialog(null, "Lo conseguiste.", "Has ganado", JOptionPane.INFORMATION_MESSAGE);
                            modelo.LanzarJuego(NumeroTema1, nivel);
                            dispose();

                            }
                  
                }
                });
                // AÑADE COSAS QUE HACE EL BOTON AL APRETAR CON EL BOTON IZQUIERDO
                cuadro.retornar(mat).addMouseListener(new MouseAdapter() {
                            
               @Override
               public void mousePressed(MouseEvent e) {
                  if (e.getButton() == MouseEvent.BUTTON3) {
                        modelo.PonerBanderita(e);
                    }
                  }
               });       
                //DIMENSIONA EL BTON
              cuadro.retornar(mat).setPreferredSize(new Dimension(9, 9)); 
              gbc.insets=new Insets(0,0,0,0);
              gbc.weightx=0;gbc.weighty=0;gbc.gridx = i; gbc.gridy = j;gbc.ipady=9;gbc.ipadx=9;
              marco.add(cuadro.retornar(mat), gbc);//AÑADE EL BOTON AL MARCO
              //AÑADE LA IMAGEN AL BOTON Y AL MARCO
               if(cuadro.retornar(h-1).val==-1){imagen[h-1] = new JLabel(new ImageIcon(getClass().getResource(Imagen)));cuadro.insertImg(imagen[h-1], h-1); }
              else if(cuadro.retornar(h-1).val==0){imagen[h-1] = new JLabel(new ImageIcon(getClass().getResource("../imagenes/0.jpg")));cuadro.insertImg(imagen[h-1], h-1);}
              else if(cuadro.retornar(h-1).val==1){imagen[h-1]= new JLabel(new ImageIcon(getClass().getResource("../imagenes/1.jpg")));cuadro.insertImg(imagen[h-1], h-1);}
             else  if(cuadro.retornar(h-1).val==2){imagen[h-1] = new JLabel(new ImageIcon(getClass().getResource("../imagenes/2.jpg")));cuadro.insertImg(imagen[h-1], h-1);}
             else  if(cuadro.retornar(h-1).val==3){imagen[h-1] = new JLabel(new ImageIcon(getClass().getResource("../imagenes/3.jpg")));cuadro.insertImg(imagen[h-1], h-1);}
             else  if(cuadro.retornar(h-1).val==4){imagen[h-1] = new JLabel(new ImageIcon(getClass().getResource("../imagenes/4.jpg")));cuadro.insertImg(imagen[h-1], h-1);}
              else if(cuadro.retornar(h-1).val==5){imagen[h-1]= new JLabel(new ImageIcon(getClass().getResource("../imagenes/5.jpg")));cuadro.insertImg(imagen[h-1], h-1);}
              else if(cuadro.retornar(h-1).val==6){ imagen[h-1] = new JLabel(new ImageIcon(getClass().getResource("../imagenes/6.jpg")));cuadro.insertImg(imagen[h-1], h-1);}
             else  if(cuadro.retornar(h-1).val==7){imagen[h-1] = new JLabel(new ImageIcon(getClass().getResource("../imagenes/7.jpg")));cuadro.insertImg(imagen[h-1], h-1);}
              else if(cuadro.retornar(h-1).val==8){imagen[h-1]= new JLabel(new ImageIcon(getClass().getResource("../imagenes/8.jpg")));cuadro.insertImg(imagen[h-1], h-1);}
             marco.add(imagen[h-1],gbc);
             // DEJA VISIBLE EL BOTON PRESIONADO ANTERIORMENTE
             if(mat==y){cuadro.retornar(mat).setVisible(false);
             if(cuadro.retornar(mat).val==0)cuadro.anular(y,cuadro,cuadro.retornar(y));
             if(cuadro.comprobar()==true){
                            etiqueta2.setText(Integer.toString(cant));
                            
                            modelo.parar();
                            modelo.ganador(nivel);
                            
                            cuadro.visibilizar();
                            JOptionPane.showMessageDialog(null, "Lo conseguiste.", "Has ganado", JOptionPane.INFORMATION_MESSAGE);
                            
                            modelo.LanzarJuego(NumeroTema1, nivel);
                            dispose();
                            }
             }
          }
          marco.setPreferredSize( new Dimension( anc, alt) );
   }
}
    
    public void botones2(campoM cuadro,int anc,int alt,GridBagConstraints gbc,int nivel ){ /*PRIMER MARCO DE BOTONES DONDE NO ESTAN LAS MINAS;QUE ESPERA A QUE EL JUGADOR PULSE UNA PARA CREAR EL MARCO (con botones(...) Y EMPEZAR EL JUEGO) */
           int val=41;
       if (nivel==0) val=5;
       if (nivel==1) val=11;
       if (nivel==2) val=41;
    
        int[] arr=new int [val];
        boolean flag;
        int probe=0;
        int tam=0;
        int d=0;
        int ps=0;
        if(val==5)
            tam=16;
        if(val==11)
            tam=64;
        if(val==41)
            tam=256;
        if(val==11)
            d=8;
        if(val==5)
            d=4;
        if(val==41)
            d=16;
        int h=0;
        b=new JButton[tam];//CREA EL MARCO E BOTONES
         for (int i=0;i<d;i++){
              if(i%2!=0)h=h+d+1;
              for(int j=0;j<d;j++){
                  ps++;
                  if((i%2==0)&&(i!=0))if((j)%d==0)h=h+d-1;
                    if(i%2==0)h=h+1;if(i%2!=0)h=h-1;
                   b[h-1]=new Nodo(h-1,0,null);
                    b[h-1].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        //nacho 31/5
                        if(!cronometro){
                            ActionListener crono = new ActionListener() {
                                public void actionPerformed(ActionEvent event) {

                                    try {
                                        modelo.AumentarTiempo();
                                    } catch (IOException ex) {
                                        Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                requestFocus();
                                }};
                            modelo.init(crono);
                            cronometro=true;
                        }
                        //finNacho
                        for(int i=0;i<b.length;i++){
                            b[i].setVisible(false);

                        }
                        try {
                            botones(cuadro,700, 700, gbc , ((Nodo) event.getSource()).val,nivel);
                        } catch (IOException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                          
                    }
                   });
                  b[h-1].setPreferredSize(new Dimension(10, 10));
                  gbc.weightx=0;gbc.weighty=0;gbc.gridx = i; gbc.gridy = j;gbc.ipady=10;gbc.ipadx=10;
                  gbc.insets=new Insets(2,2,2,2);
                  marco.add(b[h-1], gbc);

              }
              marco.setPreferredSize( new Dimension( 3000, 3000) );


        }
    }
    
   
   
    }

class Ayuda extends JFrame{
    
    private JButton volverJuego; 
    private JPanel titulo = new JPanel();
    private JPanel menu = new JPanel();
    private JLabel ayuda = new JLabel("AYUDA");
    private JTextArea descr = new JTextArea("\n  El objetivo del juego es encontrar y marcar las celdas de la cuadrícula que contengan tartas. \n  Cuando hagas clic en una celda, "
    + "aparecerá el número de celdas colindantes que tienen una tartas. \n  Si haces clic en una celda con 0 tartas alrededor, se revelarán automáticamente las celdas junto a ellas."
    + "\n  Ganas la partida cuando hayas descubierto todas las celdas libres. \n  Si haces clic sobre una celda que contiene una tarta, acabará la partida.\n  Sin embargo, nunca habrá una tarta debajo"
    + "de la primera celda sobre la que hagas clic en cada partida.\n\n\n  "
    + "Ayuda menú\n\n"
    + "  Puedes jugar en diferentes cuadrículas de diferente tamaño con un número distinto de tartas, \n  seleccionando la dificultad apropiada en la pantalla principal. \n  Si quieres saber el tamaño o el número de tartas"
    + "de un determinado nivel de dificultad, \n  basta con pasar el ratón sobre el botón para saber a qué te enfrentarás."
    + "\n  Además, para un mayor entretenimiento, podrás elegir entre diferentes iconos antes de empezar:\n  tartas, tomates, tambores."
    + "\n  Finalmente, también podrás ver los mejores tiempos registrados en cada nivel."
    + "\n\n\n\n  Para más ayudas o comentarios, envía un correo a: supportBuscaT@diu.com");
    
    private Modelo modelo = new Modelo();
    private Color Color1= new Color(190,238,247);
    private Color Color2= new Color(111,194,208);
    private Color Color3= new Color(69,146,175);
    private Color Color4= new Color(255,130,70);
    private Color ColorJugar= new Color(249,248,235);
    private Font fuente1=new Font("Serif", Font.BOLD + Font.ITALIC, 25);
    private Font fuente2=new Font("Serif", Font.BOLD + Font.ITALIC, 20);
    private Font fuente3=new Font("Serif", Font.BOLD + Font.ITALIC, 80);
    
    private Color temaRojo= new Color(250,70,89);
    private Color temaAmarillo= new Color(254,255,228);
    private Color temaVerdeClaro= new Color(163,222,131);
    private Color temaVerdeOscuro= new Color(46,184,114);
    private Color temaVerde= new Color(37,147,91);
    
    private Color temaRosa= new Color(242,53,87);
    private Color temaAmarilloOscuro= new Color(240,212,58);
    private Color temaAzulClaro= new Color(34,178,218);
    private Color temaAzulOscuro= new Color(0,153,117);
    
    public Ayuda(int NumeroTema){
        //Configuración ventana
        setTitle("BuscaT");
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.fill=GridBagConstraints.BOTH;
        setBounds(300, 100, 300, 600);
        
   
        //Configuracion titulo
        ayuda.setFont(fuente3);
        titulo.setLayout(new FlowLayout());
        titulo.add(ayuda);
        titulo.setBackground(Color3);
        titulo.setPreferredSize(new Dimension(1000,100));
        modelo.agrega(titulo,gb,this,0,0);
        
        //Configuracion cuerpo
        descr.setFont(fuente2);
        JScrollPane cuerpo= new JScrollPane(descr);
        descr.setEditable(false);
        cuerpo.setBackground(Color1);
        cuerpo.setPreferredSize(new Dimension(900,500));
        modelo.agrega(cuerpo,gb,this,0,1);
        
        //Configuracion menu
        menu.setBackground(Color2);
        menu.setPreferredSize(new Dimension(900,100));
        menu.setLayout(null);
        volverJuego= new JButton("Volver");
        volverJuego.setFont(fuente1);
        volverJuego.setBackground(ColorJugar);
        volverJuego.setLocation(80,15);
        volverJuego.setSize(500, 70);
        volverJuego.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        menu.add(volverJuego);
        modelo.agrega(menu,gb,this,0,2);
        
        if(NumeroTema==1){
            titulo.setBackground(temaVerdeOscuro);
            cuerpo.setBackground(Color1);
            menu.setBackground(temaRojo);
        }else if(NumeroTema==2){
            titulo.setBackground(temaAmarilloOscuro);
            cuerpo.setBackground(temaAzulOscuro);
            menu.setBackground(temaAzulOscuro);
        }else if(NumeroTema==3){
            titulo.setBackground(Color3);
            cuerpo.setBackground(Color1);
            menu.setBackground(Color2);
        }
        
        pack();
        setVisible(true); 
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
    }        
    }
