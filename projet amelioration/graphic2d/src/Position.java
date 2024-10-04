package graphic2d;

public class Position {
/**
 * @author Japha Fomen
 *@version 1.0
 *@since 2023
 * */
	//variables d'instances
protected int x;
protected int y;

/**
 * constructeur
 * @param x
 * @param y
 */
Position(int x,int y){
	this.x=x;
	this.y=y;
}

public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}
/**
 * cette fonction compare 2 points
 * @param p
 * @return boolean
 */
public boolean equals(Position p) {
	if(this.x==p.getX()&&this.y==p.getY())return true;//condition d'égalité
	else return false;
}
/**cette methode calcule la distance entre 2 points et la retourne.
 * 
 * @param p
 * @return Distance
 */
public int distance(Position p) {
		int distance=0;
		double x=Math.pow((this.getX()-p.getX()), 2);
		double y=Math.pow((this.getY()-p.getY()), 2);
		distance=(int) (Math.sqrt(x+y));
		return distance;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}	
	}


