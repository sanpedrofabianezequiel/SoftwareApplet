package misApplets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;

 @SuppressWarnings({ "deprecation", "serial" })
public class webDevelopment extends JApplet {

	 public void init() {
		 
		 int n_graficos=Integer.parseInt(getParameter("cantidad"));
		 
		 //Almaceno la cantidad de barras a crear en un Array
		 int [] barras= new int[n_graficos];
		
		 for(int i=0;i<barras.length;i++) {			 
			 int valor=Integer.parseInt(getParameter("barra."+ (i+1)));//Insertamos las barras segun la cantidad creada en HTML			
			 barras[i]=valor; //llenamos el array de barras con sus valores segun la posicion		 
		 }
		 
		 
		 LaminaGrafico miLamina=new LaminaGrafico(barras);
		 add(miLamina);
		 
	 }
	
	
}

 class LaminaGrafico extends JPanel{
	 private int [] barrasR;
	 
	 LaminaGrafico(int [] barras){//Constructor
		 	this.barrasR=barras;
	 }
	 
	 //Pintamos y creamos las barras
	 public void paint(Graphics g) {
		 super.paint(g);	 
		 Graphics2D g2=(Graphics2D) g;//Pinter
		 g2.rotate(180/180*Math.PI, 125, 100);	//Rotamos el Pintador de rectangulos
		 
		 
		 int pos_x=0;
		 int rojo=0;
		 int verde=0;
		 int azul=0;
		 for(int i=0;i<barrasR.length;i++) {
			 
			 Rectangle2D rectangulo=new Rectangle2D.Double(pos_x, 0, 25, barrasR[i]);//Creamos el rectangulo
			 
			 g2.setPaint(new Color(rojo, verde, azul));	//Setiamos el color
			 g2.fill(rectangulo);			//Rellanamos el rectangulo con el Curos del tipo Grapichs/2D 2
		 
			 pos_x+=25;//Desplazamos la x
			 rojo +=10;
			 verde +=10;
			 azul +=10;
		 }
	 }
 }
 
 
 
 
 