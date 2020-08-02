/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscat_unificado;

//imports

import static buscat_unificado.Controlador.NumeroTema1;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author nacho
 */
public class Modelo extends Observable{
    
    private final int intervalo = 1000;
    private Timer t;
    private int s=0,m=0;
    private static ArrayList<Integer> puntuaciones;
    private int bombas=0;
    
     
    public static void agrega(Component c, GridBagConstraints gb, JFrame v, int x, int y){
        gb.gridx=x;
        gb.gridy=y;
        gb.weightx=0;
        gb.weighty=0;
        v.add(c,gb);
    }
     
     public void LanzarAyuda (int NumeroTema1){
         
         Ayuda ayuda=new Ayuda(NumeroTema1);
         setChanged();
         notifyObservers();
     }
     
     public void LanzarJuego(int NumeroTema1,int nivel){
         Juego juego=new Juego(NumeroTema1,nivel);
         setChanged();
         notifyObservers();
        
     }
     
     public int getNumeroTema(int NumeroTema1){
         return NumeroTema1;     
     }
 
     public void LanzarMenu(int NumeroTema1){
         Menu menu=new Menu(NumeroTema1);  
         setChanged();
         notifyObservers();
     }
     
     //TIEMPO

     public void AumentarTiempo() throws IOException{
        int segundos=0;
         ++s;
        if(s==60){
            s=0;
            ++m;
        }
        segundos = m*60+s;
        System.out.println(m+s);
        //tiempo = (m<=9?"0":"")+m+":"+(s<=9?"0":"")+m;
        setChanged();
        notifyObservers(segundos);            
     }
     
     public int getM(){
         return m;
     }
     
     public int getS(){
         return s;
     }
     
     public int getPuntuacionFacil(){
         return puntuaciones.get(0);
         
     }
     
     public int getPuntuacionMedio(){
         return puntuaciones.get(1);
     }
     
     public int getPuntuacionDificil(){
         return puntuaciones.get(2);
     }
     
      
   //inicia el cronometro
    public void init(ActionListener crono){        
        t = new Timer(intervalo, crono);
        t.start();
    }
    //para el cronometro
    public void parar(){
        t.stop();
    }
    
   
    //FIN TIEMPO//
    public void PonerBanderita(MouseEvent e){
        ((Nodo) e.getSource()).setIcon(new ImageIcon(getClass().getResource("../imagenes/banderita.png")));
        NumeroBombas();
    }
    
     public int getBombas(){
        return bombas;
    }
     
     public void NumeroBombas(){
         bombas=bombas-1;
         setChanged();
         notifyObservers();
     }
     
     public void setBombas(int numero){
         bombas=numero;
     }
    //INICIO FUNCIONES DEL JUEGO
    
    public void cargarDatos() throws FileNotFoundException, IOException, ClassNotFoundException {
        
        try{
            FileInputStream FicheroTexto;
            ObjectInputStream FicheroBinario;
            FicheroTexto = new FileInputStream("puntuaciones.dat");
            FicheroBinario = new ObjectInputStream(FicheroTexto);
            ArrayList<Integer> puntuacionesF;
            puntuacionesF = (ArrayList<Integer>) FicheroBinario.readObject();
            puntuaciones = puntuacionesF;
            System.out.println("He cargado los datos");
            System.out.println("Puntuaciones:"+puntuaciones.get(0)+puntuaciones.get(1)+puntuaciones.get(2));
            setChanged();
            notifyObservers();
        }catch(Exception e){
            System.out.println("Aun no hay ninguna puntuacion metida");
            puntuaciones = new ArrayList();
            puntuaciones.add(-1);
            puntuaciones.add(-1);
            puntuaciones.add(-1);
        }
        
    }
    
    public static void guardarDatos()throws FileNotFoundException, IOException{
        
        ObjectOutputStream ficheroBinario;
        try (FileOutputStream ficheroTexto = new FileOutputStream("puntuaciones.dat")) {
            ficheroBinario = new ObjectOutputStream(ficheroTexto);
            ficheroBinario.writeObject(puntuaciones);
        }
        ficheroBinario.close();
                
    }  
    
    public void ganador(int nivel) throws IOException{
        int segundos = m*60+s;
        
        if(puntuaciones.get(nivel)!=-1){
            if(segundos<puntuaciones.get(nivel))
                puntuaciones.set(nivel, segundos);
        }else puntuaciones.set(nivel, segundos);
        guardarDatos();
        
        setChanged();
        notifyObservers();

    }
    
    
}
