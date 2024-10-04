package graphic2d;
public class intersection extends Position {
	/**
	 * @author Japha Fomen,Dave collins noula ,Romaric et Aimeric
 *@version 1.0
 *@since 2023
	 */
	
	private int id;
	/**
	 * constructeur
	 * @param x
	 * @param y
	 * @param id
	 */
intersection(int x, int y,int id){
	super(x,y);
	this.id=id;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
