/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscat_unificado;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author nacho
 */
public class BuscaT_Unificado {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {  
            int NumeroTema1 = 0;
            Controlador controlador=new Controlador();   
            controlador.configurarControlador(NumeroTema1);
        } 
    
}
