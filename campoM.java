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
public class campoM {//Clase que almacena todos los botones
    Nodo raiz; // Posicion 0
    int tam;  // Numero de nodos en un lado
    int dim; // Tamaño total (tam)^2
    Nodo [] recorrido; // Array de punteros
    private int m; // Minas
    campoM(){

    }
    void visibilizar(){// Deja todos las minas visibles
        for(int j=0;j<recorrido.length;j++)
            if(recorrido[j].val==-1)
              recorrido[j].setVisible(false);
    }
     void insertar2(int [] arr){// Inserta los botones por primera vez, dejandolos conectados ( es decir con valor si  hay mina, y con punteros a sus vecinos)
        Nodo aux,ant;
        int l=0,d=0,m=0,pos=0;
        boolean flag=true;
        if(arr[0]==0) { m=1;raiz=new Nodo(-1,pos,null);}//-1
        else raiz=new Nodo(0,pos,null);
        ant=raiz;
        //Facil
        if(arr.length==5){
        this.tam=4;
        this.m=4;
        this.dim=16;
        }
       //Medio
        if(arr.length==11){
        this.tam=8;
        this.m=10;
        this.dim=64;
        }
       //Dificil 
        if(arr.length==41){
        this.tam=16;
        this.m=40;
        this.dim=256;
        }
     
        recorrido=new Nodo[this.dim];
        recorrido[0]=raiz;
        for(int i=1;i<this.dim;i++){
            aux=null;
            if(i!=arr[m]){aux=new Nodo(0,i,null);}else 
            if(m<this.m) {m++;aux=new Nodo(-1,i,null);}
            if(flag==true){
                if(i%tam==0){flag=false;aux.n=ant;ant.s=aux;}else{aux.w=ant;ant.e=aux;}}
            else {
                if(i%tam==0){flag=true;aux.n=ant;ant.s=aux;}else{aux.e=ant;ant.w=aux;}
            }
            recorrido[i]=aux;

            pos++;
            ant=aux;  
        }
        conectar();// Conecta es decir asigna cada nodo sus vecinos
    }

public void conectar(){// Conecta es decir asigna cada nodo sus vecinos
        Nodo aux=raiz;
        boolean flag=true;
         
        int z=2*tam-1,y=2*tam-1;
        for(int i=1;i<this.dim;i++){
            Nodo bef=recorrido[i];

            int n1=aux.pos+z;
            int n2=aux.pos-y;
            
            z=z-2;
            y=y+2;

            if(n1<=dim)
                aux.s=recorrido[n1];
            if((n2>=0)&&(flag==false))
                aux.n=recorrido[n2];
            else if((n2>=tam))
                aux.n=recorrido[n2];
            if(flag==true){
                
                if(aux.e!=null){
                    if(n1<=dim)
                        aux.se=recorrido[n1-1];
                        if(n2>=0)
                            aux.ne=recorrido[n2-1];
                }
                if(aux.w!=null){
                    if(n1<=dim)
                        aux.sw=recorrido[n1+1];
                    if(n2>=0)
                        aux.nw=recorrido[n2+1];
                }
                if((i)%tam==0){
                    flag=false;
                    z=tam*2-1;
                    y=1;
                }
            }else if(flag==false){
                if(aux.w!=null){
                    if(n1<=dim)
                        aux.sw=recorrido[n1-1];
                        if(n2>=0)
                            aux.nw=recorrido[n2-1];
                }if(aux.e!=null){
                    if(n1<=dim)
                        aux.se=recorrido[n1+1];
                    if(n2>=0)aux.ne=recorrido[n2+1];
                }if((i)%tam==0){
                    flag=true;z=tam*2-1;y=1;}
            }
            //System.out.println(mostrarC(aux));
            //if(aux.pos==23) break;
            aux=bef;
        }
        Nodo bef1=recorrido[dim-1];
        bef1.n=recorrido[dim-2*tam+1];
        Nodo bef2=recorrido[dim-1];
        bef2.nw=recorrido[dim-2*tam];
    }
    public String mostrarC(Nodo aux){ // Es un tostring de un nodo y sus alrededores, mostrando la posicion
        String res="Para"+aux.pos+"\n";
        if(aux.nw!=null)
            res=res+" "+aux.nw.pos;
        if(aux.n!=null)
            res=res+" "+aux.n.pos;
        if(aux.ne!=null)
            res=res+" "+aux.ne.pos;
        res=res+"\n";
        if(aux.w!=null)
            res=res+" "+aux.w.pos;
        res=res+" "+aux.pos;
        if(aux.e!=null)
            res=res+" "+aux.e.pos;
       res=res+"\n";
        if(aux.sw!=null)
            res=res+" "+aux.sw.pos;
        if(aux.s!=null)
            res=res+" "+aux.s.pos;
         if(aux.se!=null)
            res=res+" "+aux.se.pos;
        return res;
    }
    public String mostrarVal(Nodo aux){//  Es un tostring de un nodo y sus alrededores, mostrando el valor
        String res="Para"+aux.pos+"\n";
        if(aux.nw!=null)
            res=res+" "+aux.nw.val;
        if(aux.n!=null)
            res=res+" "+aux.n.val;
        if(aux.ne!=null)
            res=res+" "+aux.ne.val;
        res=res+"\n";
        if(aux.w!=null)
            res=res+" "+aux.w.val;
        res=res+" "+aux.val;
        if(aux.e!=null)
            res=res+" "+aux.e.val;
       res=res+"\n";
        if(aux.sw!=null)
            res=res+" "+aux.sw.val;
        if(aux.s!=null)
            res=res+" "+aux.s.val;
         if(aux.se!=null)
            res=res+" "+aux.se.val;
        return res;
    }
    void insertImg(JLabel img, int m){ // Cambia o inserta la imagen en el nodo
        retornar(m).img=img;
    }

   
   
    Nodo retornar(int i){ // Devuelve un nodo dado su indice
         return recorrido[i];
    }

    String mostrarPos(){ // toString de todo el campo, mostrando la posición
        int d=this.tam;
        int k=this.dim;
        Nodo aux=raiz;
        String res=""+aux.pos;
        int z=0;
        boolean flag=true;
        for(int i=1;i<k;i++){
           if(flag==true){
               z=0;
                if((i)%d!=0) {aux=aux.e;}
                else if((i)%d==0) {aux=aux.s;flag=false;res=res+"\n";}
                res=res+aux.pos;
            }else{
                if((i)%d!=0) {aux=aux.w;}
                else if((i)%d==0) {aux=aux.s;flag=true;res=res+"\n";}
                res=res+aux.pos;
            }
        }
        return res;
    }


    String mostrar(){// toString de todo el campo, mostrando el valor
        int d=this.tam;
        int k=this.dim;
        Nodo aux=raiz;
        String res=""+aux.val;
        int z=0;
        boolean flag=true;
        for(int i=1;i<k;i++){
           if(flag==true){
               z=0;
                if((i)%d!=0) {aux=aux.e;}
                else if((i)%d==0) {aux=aux.s;flag=false;res=res+"\n";}
                res=res+aux.val;
            }else{
                if((i)%d!=0) {aux=aux.w;}
                else if((i)%d==0) {aux=aux.s;flag=true;res=res+"\n";}
                res=res+aux.val;
            }
        }
        return res;
    }
    String mostrar2(){// toString de todo el campo, mostrando el valor
        Nodo aux=raiz;
        String res=" "+aux.val;
        
        for(int i=1;i<this.dim;i++){
            if(i%tam==0) res=res+"\n";
            aux=recorrido[i];
            res=res+" "+aux.val;
        }
        return res;
    }
    void avisar(){// Asigna a cada nodo si no hay mina, su valor correspondiente
        int d=this.tam;
        int k=this.dim;
        Nodo aux=raiz;
        if(raiz.val==0)this.raiz.val=(contar(aux));
        boolean flag=true;
        for(int i=1;i<k;i++){
            if(flag==true){
                if((i)%d!=0) {aux=aux.e;}
                else if((i)%d==0) {aux=aux.s;flag=false;}
            }else{
                if((i)%d!=0) {aux=aux.w;}
                else if((i)%d==0) {aux=aux.s;flag=true;}
            }
            if(aux.val==0)aux.val=(contar(aux));
        }
    }

    int contar(Nodo aux){ // Cuenta vecinos
        int n=0;
        if(aux.n!=null)
            if(aux.n.val==-1)
            n++;
        if(aux.e!=null)
            if(aux.e.val==-1)
            n++;
        if(aux.w!=null)
            if(aux.w.val==-1)
            n++;
        if(aux.ne!=null)
            if(aux.ne.val==-1)
            n++;
        if(aux.nw!=null)
            if(aux.nw.val==-1)
            n++;
        if(aux.sw!=null)
            if(aux.sw.val==-1)
            n++;
        if(aux.se!=null)
            if(aux.se.val==-1)
            n++;
        if(aux.s!=null)
            if(aux.s.val==-1)
            n++;
        
        return n;
    }

    int getLocal(Nodo ne) { // Devuelve la posición de forma iterativa
     for(int i=0;i<this.dim;i++){
             if(ne==recorrido[i])
                 return i;
         }
         return 0;
    }
    
    // BUSCA LOS ELEMENTOS CERCANOS AL BOTON PRESIONADO; Y LOS DEJA VISIBLES 
                 int anular(int y, campoM a,Nodo n) { 
                    int valor=0;
                       if(n.e!=null){
                          if(n.e.isVisible()==true){if(n.e.val!=-1)
                          n.e.setVisible(false);
                           if(n.e.val==0)
                              valor=valor+ anular(a.getLocal(n.e),a, n.e);else{valor=valor+1;}}}
                       if(n.s!=null){ 
                           if(n.s.isVisible()==true){
                               if(n.s.val!=-1)
                           n.s.setVisible(false);
                           if(n.s.val==0)
                               valor=valor+ anular(a.getLocal(n.s),a, n.s);else{valor=valor+1;}}}
                       if(n.n!=null) {if(n.n.isVisible()==true){if(n.n.val!=-1)
                           n.n.setVisible(false);
                           if(n.n.val==0) 
                               valor=valor+ anular(a.getLocal(n.n),a, n.n);else{valor=valor+1;}}}
                       if(n.w!=null) { if(n.w.isVisible()==true){if(n.w.val!=-1)
                           n.w.setVisible(false);
                           if(n.w.val==0) 
                               valor=valor+ anular(a.getLocal(n.w),a, n.w);else{valor=valor+1;}}}
                       if(n.se!=null)  { if(n.se.isVisible()==true){if(n.se.val!=-1)
                           n.se.setVisible(false);
                           if(n.se.val==0)
                               valor=valor+ anular(a.getLocal(n.se),a, n.se);else{valor=valor+1;}}}
                       if(n.sw!=null) { if(n.sw.isVisible()==true){if(n.sw.val!=-1)
                           n.sw.setVisible(false);
                           if(n.sw.val==0) 
                               valor=valor+ anular(a.getLocal(n.sw),a, n.sw);else{valor=valor+1;}}}
                       if(n.ne!=null) { if(n.ne.isVisible()==true){if(n.ne.val!=-1)
                           n.ne.setVisible(false);
                           if(n.ne.val==0) 
                               valor=valor+ anular(a.getLocal(n.ne),a, n.ne);else{valor=valor+1;}}}
                       if(n.nw!=null){ if(n.nw.isVisible()==true){if(n.nw.val!=-1)
                           n.nw.setVisible(false);
                           if(n.nw.val==0)
                               valor=valor+ anular(a.getLocal(n.nw),a, n.nw);else{valor=valor+1;}}}
                        n.setVisible(false);valor=valor+1;
                    return valor;
                }
                 
                boolean comprobar(){
           for(int i=0;i<this.dim;i++){
             if(recorrido[i].val!=-1)if(recorrido[i].isVisible())
                 return false;
            }
                 return true;
                
            }
}





