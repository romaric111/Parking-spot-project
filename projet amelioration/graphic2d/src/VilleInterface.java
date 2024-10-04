package graphic2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * @author Japha Fomer
 *@version 1.0
 *@since 2023
 */
public class VilleInterface extends JFrame{
	// declaration des variables de la ville
public	route r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14;
ArrayList<Position> trajet=new ArrayList<Position>();
	public Stationnement st1,st2,st3,st4,st5;
protected conducteur cd=new conducteur(0,0);
	public intersection A,B,C,D,E,F,G,H,I,J,K,L,M;
	/**
	 * constructeur
	 */
	VilleInterface(){
		super("ma ville");
		JPanel mainpanel=new JPanel();
		setContentPane(mainpanel);
		// initialisation des intersections
		 A= new intersection(1004,817,1);
		 B= new intersection(1004,644,2);
		 C= new intersection(365,817,3);
		 D= new intersection(365,644,4);
		 E= new intersection(0,644,5);
		 F= new intersection(1537,644,6);
		 G= new intersection(1004,464,7);
		 H= new intersection(365,464,8);
		 I= new intersection(365,254,9);
		 J= new intersection(1004,254,10);
		 K= new intersection(1537,254,11);
		 L= new intersection(0,254,12);
		 M= new intersection(365,0,13);
		 //initialisation des routes
		r1=new route(A,B,40,1);
		r2=new route(B,F,60,2);
		r3=new route(C,D,60,3);
		r4=new route(E,D,60,4);
		r5=new route(D,B,60,5);
		r6=new route(D,H,60,6);
		r7=new route(B,G,40,7);
		r8=new route(H,G,40,8);
		r9=new route(H,I,60,9);
		r10=new route(G,J,40,10);
		r11=new route(J,K,60,11);
		r12=new route(I,J,60,12);
		r13=new route(I,M,60,13);
		r14=new route(L,I,60,14);
		// Initialisation des stations
	Position p1=new Position(1274,284);
	st1=new Stationnement("station1",p1,50,263,330,14);
	Position p2=new Position(405,674);
	st2=new Stationnement("station2",p2,70,579,173,15);
	Position p3=new Position(0,284);
	st3=new Stationnement("station3",p3,16,335,330,16);
	Position p4=new Position(404,284);
	st4=new Stationnement("station4",p4,40,579,153,17);
	Position p5=new Position(395,0);
	st5=new Stationnement("station5",p5,20,306,134,18);
//rendre la fenetre visible
		this.getContentPane();
		setSize(800,800);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * dessine les differentes composantes de la station
	 */
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d=(Graphics2D) g;
		Drawroute(g2d,r1);
		Drawroute(g2d,r2);
		Drawroute(g2d,r3);
		Drawroute(g2d,r4);
		Drawroute(g2d,r5);
		Drawroute(g2d,r6);
		Drawroute(g2d,r7);
		Drawroute(g2d,r8);
		Drawroute(g2d,r9);
		Drawroute(g2d,r10);
		Drawroute(g2d,r11);
		Drawroute(g2d,r12);
		Drawroute(g2d,r13);
		Drawroute(g2d,r14);
		Drawstationnement(g2d,st1);
		Drawstationnement(g2d,st2);
		Drawstationnement(g2d,st3);
		Drawstationnement(g2d,st4);
		Drawstationnement(g2d,st5);
		Drawconducteur(g2d,cd);
		if(trajet.size()>1) {for(int i=1;i<trajet.size();i++)
		Drawtrajet(g2d,trajet.get(i),trajet.get(i-1) );}
		}
	/**
	 * Cette methode permet de dessiner une route
	 * @param g
	 * @param r
	 */
public void Drawroute(Graphics2D g,route r) {
	
	g.setColor(Color.black);
	g.setStroke(new BasicStroke(r.getLargeur()));
	g.drawLine(r.getP1().getX(),r.getP1().getY(),r.getP2().getX(),r.getP2().getY());
}
/**
 * cette methode permet de dessiner une station
 * @param g
 * @param sta
 */
public void Drawstationnement(Graphics2D g,Stationnement sta) {
	g.setColor(Color.GREEN);
	g.fill3DRect(sta.getPosition().getX(),sta.getPosition().getY(),sta.getWidth(), sta.getHeigth(),sta.getEtat());
	g.setColor(Color.black);
	g.drawString(sta.getNom_station(),sta.getPosition().getX()+40,sta.getPosition().getY()+60);
	g.drawString("nombre de place:"+sta.getNombre_de_place(),sta.getPosition().getX()+40,sta.getPosition().getY()+70);
	g.drawString("nombre de place disponibles:"+sta.getPlace_Disponibles(),sta.getPosition().getX()+40,sta.getPosition().getY()+80);
}
/**
 * cette methode permet de dessiner la voiture
 * @param g
 * @param a
 */
public void Drawconducteur(Graphics2D g,conducteur a) {
	g.setColor(Color.RED);
	g.fill3DRect(a.getX(),a.getY(),20, 20,true);
	
}
/**
 * cette methode permet de de sessiner le trajet
 * @param g
 * @param p1
 * @param p2
 */
public void Drawtrajet(Graphics2D g,Position p1,Position p2) {
	g.setColor(Color.BLUE);
	g.setStroke(new BasicStroke(10));
	g.drawLine(p1.getX(),p1.getY(),p2.getX(),p2.getY());
}
}
