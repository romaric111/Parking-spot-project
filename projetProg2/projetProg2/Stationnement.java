package projetProg2;
/**
 * 
 * @author Japha Fomer
 *@version 1.0
 *@since 2023
 */
public class Stationnement {
private boolean etat;
	private  int width;
	private  int heigth;
	private int id;
private Position position;
int i=0;
private int Nombre_de_place;
private int Place_Disponibles;
private String Nom_station;
/**
 * constructeur
 * @param nom
 * @param position
 * @param nombres_de_places
 * @param largeur
 * @param hauteur
 * @param id
 */
	Stationnement(String nom,Position position,int nombres_de_places,int largeur,int hauteur,int id){
		this.Nom_station=nom; 
		this.position=position;
		this.Nombre_de_place=nombres_de_places;
		if(i==0) {
		this.Place_Disponibles=(int)(Math.random()*this.Nombre_de_place);}
		i++;
		this.heigth=hauteur;
		this.width=largeur;
		this.id=id;
		miseajouretat();
	}
	/**
	 * constructeur
	 * @param nom
	 * @param x
	 * @param y
	 * @param nombres_de_places
	 * @param largeur
	 * @param hauteur
	 * @param id
	 */
	Stationnement(String nom,int x,int y,int nombres_de_places,int largeur,int hauteur,int id){
		this.Nom_station=nom; 
		this.position=new Position(x,y);
		this.Nombre_de_place=nombres_de_places;
		this.Place_Disponibles=nombres_de_places;
		this.id=id;
		this.heigth=hauteur;
		this.width=largeur;
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public boolean getEtat() {
		return etat;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeigth() {
		return heigth;
	}
	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public int getNombre_de_place() {
		return Nombre_de_place;
	}
	public void setNombre_de_place(int nombre_de_place) {
		Nombre_de_place = nombre_de_place;
	}
	public int getPlace_Disponibles() {
		return Place_Disponibles;
	}
	public void setPlace_Disponibles(int place_Disponibles) {
		Place_Disponibles = place_Disponibles;
	}
	public String getNom_station() {
		return Nom_station;
	}
	public void setNom_station(String nom_station) {
		Nom_station = nom_station;
	}
	/**
	 * met a jour l'etat de la station
	 */
	public void miseajouretat() {
		if(this.Nombre_de_place-this.getPlace_Disponibles()==this.Nombre_de_place)this.etat=false;
		else this.etat=true;
	}
	/**
	 * cette methode reserve de l'espace
	 */
	public void reservation() {
		if(etat) {this.Place_Disponibles--;
		System.out.println("reservation effectuée");}
		else System.out.println("plus de place");
		miseajouretat();
	}
	/**
	 * cette methode libere de l'espace
	 */
	public void liberer_espace() {
		if(this.Place_Disponibles<this.Nombre_de_place)this.Place_Disponibles++;
		miseajouretat();
	}
	
}
