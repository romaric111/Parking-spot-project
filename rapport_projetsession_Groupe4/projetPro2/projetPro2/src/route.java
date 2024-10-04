import java.util.ArrayList;
/**
 * 
 * @author Japha Fomer
 *@version 1.0
 *@since 2023
 */
public class route {
	
	protected intersection p1,p2;
	public ArrayList<Position> position;
	protected int largeur;
	 protected int id;
	 public intersection getP1() {
		return p1;
	}
	public void setP1(intersection p1) {
		this.p1 = p1;
	}
	public intersection getP2() {
		return p2;
	}
	public void setP2(intersection p2) {
		this.p2 = p2;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * constructeur
	 * @param p1
	 * @param p2
	 * @param largeur
	 * @param id
	 */
	route(intersection p1,intersection p2,int largeur, int id){
		 this.p1=p1;
		 this.p2=p2;
		 this.largeur= largeur;
		 this.id=id;
		 position=new ArrayList<>();
		 listePosition();
	 }
	/**
	 * calcul la distance entre 2 points et retourne la valeur.
	 * @return
	 */
	public int distance() {
		int distance=0;
		double x=Math.pow((p1.getX()-p2.getX()), 2);
		double y=Math.pow((p1.getY()-p2.getY()), 2);
		distance=(int) (Math.sqrt(x+y));
		return distance;
	}
	/**
	 * cette methode  genere un tableau de toutes les positions dans une route
	 */
	public void listePosition() {
		int min=0;int max=0;
		if(p1.getX()==p2.getX()) {
			for(int i=p1.getX()-(this.largeur/2);i<=p1.getX()+(this.largeur/2);i++) {
				if(p1.getY()>p2.getY()) {
					min=p2.getY();max=p1.getY();
				}
				else {
					min=p1.getY();max=p2.getY();
				}
				for(int j=min;j<=max;j++) {
					position.add(new Position(i,j));
				}
			}
		}
		else if(p1.getY()==p2.getY()) {
			for(int i=p1.getY()-(this.largeur/2);i<=p1.getY()+(this.largeur/2);i++) {
				if(p1.getX()>p2.getX()) {
					min=p2.getX();max=p1.getX();
				}
				else {
					min=p1.getX();max=p2.getX();
				}
				for(int j=min;j<=max;j++) {
					position.add(new Position(j,i));
				}
			}
		}
	}
	/**
	 * Cette methode  verifie si un point appartient a la route et retourne vrai ou faux
	 * @param p
	 * @return
	 */
	public boolean appartient(Position p) {
		boolean resultat=false;
		for(Position s:this.position) {if(p.equals(s)) {resultat= true;
	 return resultat;}}
		return resultat;
	}
}


