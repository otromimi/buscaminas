/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscat_unificado;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author j
 */
public class Nodo extends JButton{
    int val,pos;
    Nodo e;
    Nodo w,n,s,nw,ne,sw,se;
    JLabel img;
    
    Nodo(int val,int pos,JLabel img){

        this.val=val;
        this.pos =pos;
        this.img=img;
    }
    Nodo siguiente(){
        Nodo a=null;
        if(w!=null)a=w;
        if(e!=null)a=e;
        if(s!=null)a=s;
        return a;
    }
}
