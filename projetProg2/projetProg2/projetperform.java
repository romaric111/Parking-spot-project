package projetProg2.
/**
 * @author Japha Fomen et Dave Collins Noula
 *@version 1.0
 *@since 2023
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class projetperform extends JFrame implements ActionListener{
	JButton demande;
	JTextField valeurX;
	JTextField valeurY;
	serveur s;
	/**
	 * constructeur
	 */
	projetperform(){
		super("mon jFrame");
		GridLayout grille=new GridLayout(2,0);
		JPanel mainpanel =new JPanel(grille);
		JPanel panel1=new JPanel();
		JLabel etiquette1= new JLabel("valeur de x");
			panel1.add(etiquette1);
		valeurX=new JTextField(10);
		panel1.add(valeurX);
		JLabel etiquette2= new JLabel("valeur de Y");
		panel1.add(etiquette2);
	valeurY=new JTextField(10);
	panel1.add(valeurY);
	mainpanel.add(panel1);
	JPanel panel2=new JPanel();
	demande= new JButton("demander stationnement");
	panel2.add(demande,BorderLayout.CENTER);
	mainpanel.add(panel2);
	demande.addActionListener(this);
	this.setContentPane(mainpanel);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(800,800);
	setVisible(true);
	}
	@Override
	/**
	 * Action performer pour executé une action apres validation de la requete
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==demande) {
			int X;int Y;
			try {
				//recuperation de valeurs communiquées
			X=Integer.parseInt(valeurX.getText());
			Y=Integer.parseInt(valeurY.getText());
			//initialisation des données du serveur
			s=new serveur();
			s.v.cd.setX(X);
			s.v.cd.setY(Y);
			//lancement du traitement
			s.traitement(s.v.cd);
			}catch(NumberFormatException e1) {JOptionPane.showMessageDialog(this, "le format rentré ne correspond pas aux entiers", "erreur d'entree", JOptionPane.ERROR_MESSAGE);}
			catch(NullPointerException e2) {JOptionPane.showMessageDialog(this, "rentrez vos coordonnées", "erreur d'entree", JOptionPane.ERROR_MESSAGE);}
			finally {System.out.println("fini");
			//tracage du chemin
			for(Position t:s.pointTrajet) {
				//recuperation des positions a parcourir
				s.v.trajet.add(t);
					repaint();	
				}
			}
		}
		}
		
	}


