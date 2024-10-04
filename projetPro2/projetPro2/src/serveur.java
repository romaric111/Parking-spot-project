
/**
 *@author Japha Fomen,Dave Collins Noula, Romaric Hyacinthe et Emeric Tchakounté
 */
import java.util.*;

import javax.swing.JOptionPane;
public class serveur {
	//declaration des donnees necessaires pour le traitement
List<Edge> edges;
List<Integer> Laroute=new ArrayList<>();//recueil les indices des points du trajet
VilleInterface v=new VilleInterface();
ArrayList<Position> pointTrajet=new ArrayList<Position>();// recueil les points du trajet
public int cout;
public String nom=" ";
Position[]intersections= {v.cd,v.A,v.B,v.C,v.D,v.E,v.F,v.G,v.H,v.I,v.J,v.K,v.L,v.M};//utile àla generation du graphe et pour trouver les points du chemin
 Stationnement[] stations= {v.st1,v.st2,v.st3,v.st4,v.st5};//utile pour limiter la recherche de djisktra
 route[] routes= {v.r1,v.r2,v.r3,v.r4,v.r5,v.r6,v.r7,v.r8,v.r9,v.r10,v.r11,v.r12,v.r13,v.r14};// utilisé pour verifier l'appartenance de la source à une route specifique
ArrayList<Stationnement> stationsdisponibles;// receuil les stations disponibles
/**
 * cette methode permet de generer le graphe en y integrant la position du conducteur grace à l'ID de la route ou il se trouve
 * @param id
 */
public void generate_graph(int id) {
	//differentes adaptations du graphe selon la position du conducteur chaque cas correspond à une route  de la ville(ou se trouve le conducteur
	switch(id) {
	case 1:edges=Arrays.asList(new Edge(0,v.A.getId(),v.cd.distance(v.A)),new Edge(0,v.B.getId(),v.cd.distance(v.B)),
			new Edge(v.A.getId(),v.B.getId(),v.A.distance(v.B)),new Edge(v.B.getId(),v.A.getId(),v.B.distance(v.A)),new Edge(v.B.getId(),v.D.getId(),v.B.distance(v.D)),
			new Edge(v.B.getId(),v.F.getId(),v.B.distance(v.F)),new Edge(v.B.getId(),v.G.getId(),v.B.distance(v.G)),new Edge(v.B.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),
			new Edge(v.C.getId(),v.D.getId(),v.C.distance(v.D)),new Edge(v.D.getId(),v.B.getId(),v.D.distance(v.B)),new Edge(v.D.getId(),v.C.getId(),v.D.distance(v.C)),new Edge(v.D.getId(),v.E.getId(),v.D.distance(v.E)),
			new Edge(v.D.getId(),v.H.getId(),v.D.distance(v.H)),new Edge(v.D.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),new Edge(v.E.getId(),v.D.getId(),v.E.distance(v.D)),
			new Edge(v.F.getId(),v.B.getId(),v.F.distance(v.B)),new Edge(v.G.getId(),v.B.getId(),v.G.distance(v.B)),new Edge(v.G.getId(),v.H.getId(),v.G.distance(v.H)),new Edge(v.G.getId(),v.J.getId(),v.G.distance(v.J)),
			new Edge(v.H.getId(),v.D.getId(),v.H.distance(v.D)),new Edge(v.H.getId(),v.G.getId(),v.H.distance(v.G)),new Edge(v.H.getId(),v.I.getId(),v.H.distance(v.I)),
			new Edge(v.I.getId(),v.H.getId(),v.I.distance(v.H)),new Edge(v.I.getId(),v.J.getId(),v.I.distance(v.J)),new Edge(v.I.getId(),v.M.getId(),v.I.distance(v.M)),new Edge(v.I.getId(),v.st3.getId(),v.I.distance(v.st3.getPosition())),
			new Edge(v.I.getId(),v.st4.getId(),v.I.distance(v.st4.getPosition())),new Edge(v.J.getId(),v.G.getId(),v.J.distance(v.G)),new Edge(v.J.getId(),v.I.getId(),v.J.distance(v.I)),
			new Edge(v.J.getId(),v.K.getId(),v.J.distance(v.K)),new Edge(v.J.getId(),v.st1.getId(),v.J.distance(v.st1.getPosition())),new Edge(v.J.getId(),v.st4.getId(),v.J.distance(v.st4.getPosition())),
			new Edge(v.K.getId(),v.J.getId(),v.K.distance(v.J)),new Edge(v.K.getId(),v.st1.getId(),v.K.distance(v.st1.getPosition())),
			new Edge(v.L.getId(),v.I.getId(),v.L.distance(v.I)),
			new Edge(v.M.getId(),v.I.getId(),v.M.distance(v.I)),new Edge(v.M.getId(),v.st5.getId(),v.M.distance(v.st5.getPosition()))
			
			);
		break;
	case 2:edges=Arrays.asList(new Edge(0,v.B.getId(),v.cd.distance(v.B)),new Edge(0,v.F.getId(),v.cd.distance(v.F)),
			new Edge(v.A.getId(),v.B.getId(),v.A.distance(v.B)),new Edge(v.B.getId(),v.A.getId(),v.B.distance(v.A)),new Edge(v.B.getId(),v.D.getId(),v.B.distance(v.D)),
			new Edge(v.B.getId(),v.F.getId(),v.B.distance(v.F)),new Edge(v.B.getId(),v.G.getId(),v.B.distance(v.G)),new Edge(v.B.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),
			new Edge(v.C.getId(),v.D.getId(),v.C.distance(v.D)),new Edge(v.D.getId(),v.B.getId(),v.D.distance(v.B)),new Edge(v.D.getId(),v.C.getId(),v.D.distance(v.C)),new Edge(v.D.getId(),v.E.getId(),v.D.distance(v.E)),
			new Edge(v.D.getId(),v.H.getId(),v.D.distance(v.H)),new Edge(v.D.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),new Edge(v.E.getId(),v.D.getId(),v.E.distance(v.D)),
			new Edge(v.F.getId(),v.B.getId(),v.F.distance(v.B)),new Edge(v.G.getId(),v.B.getId(),v.G.distance(v.B)),new Edge(v.G.getId(),v.H.getId(),v.G.distance(v.H)),new Edge(v.G.getId(),v.J.getId(),v.G.distance(v.J)),
			new Edge(v.H.getId(),v.D.getId(),v.H.distance(v.D)),new Edge(v.H.getId(),v.G.getId(),v.H.distance(v.G)),new Edge(v.H.getId(),v.I.getId(),v.H.distance(v.I)),
			new Edge(v.I.getId(),v.H.getId(),v.I.distance(v.H)),new Edge(v.I.getId(),v.J.getId(),v.I.distance(v.J)),new Edge(v.I.getId(),v.M.getId(),v.I.distance(v.M)),new Edge(v.I.getId(),v.st3.getId(),v.I.distance(v.st3.getPosition())),
			new Edge(v.I.getId(),v.st4.getId(),v.I.distance(v.st4.getPosition())),new Edge(v.J.getId(),v.G.getId(),v.J.distance(v.G)),new Edge(v.J.getId(),v.I.getId(),v.J.distance(v.I)),
			new Edge(v.J.getId(),v.K.getId(),v.J.distance(v.K)),new Edge(v.J.getId(),v.st1.getId(),v.J.distance(v.st1.getPosition())),new Edge(v.J.getId(),v.st4.getId(),v.J.distance(v.st4.getPosition())),
			new Edge(v.K.getId(),v.J.getId(),v.K.distance(v.J)),new Edge(v.K.getId(),v.st1.getId(),v.K.distance(v.st1.getPosition())),
			new Edge(v.L.getId(),v.I.getId(),v.L.distance(v.I)),
			new Edge(v.M.getId(),v.I.getId(),v.M.distance(v.I)),new Edge(v.M.getId(),v.st5.getId(),v.M.distance(v.st5.getPosition()))
			
			);
		break;
	case 3:edges=Arrays.asList(new Edge(0,v.C.getId(),v.cd.distance(v.C)),new Edge(0,v.D.getId(),v.cd.distance(v.D)),
			new Edge(v.A.getId(),v.B.getId(),v.A.distance(v.B)),new Edge(v.B.getId(),v.A.getId(),v.B.distance(v.A)),new Edge(v.B.getId(),v.D.getId(),v.B.distance(v.D)),
			new Edge(v.B.getId(),v.F.getId(),v.B.distance(v.F)),new Edge(v.B.getId(),v.G.getId(),v.B.distance(v.G)),new Edge(v.B.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),
			new Edge(v.C.getId(),v.D.getId(),v.C.distance(v.D)),new Edge(v.D.getId(),v.B.getId(),v.D.distance(v.B)),new Edge(v.D.getId(),v.C.getId(),v.D.distance(v.C)),new Edge(v.D.getId(),v.E.getId(),v.D.distance(v.E)),
			new Edge(v.D.getId(),v.H.getId(),v.D.distance(v.H)),new Edge(v.D.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),new Edge(v.E.getId(),v.D.getId(),v.E.distance(v.D)),
			new Edge(v.F.getId(),v.B.getId(),v.F.distance(v.B)),new Edge(v.G.getId(),v.B.getId(),v.G.distance(v.B)),new Edge(v.G.getId(),v.H.getId(),v.G.distance(v.H)),new Edge(v.G.getId(),v.J.getId(),v.G.distance(v.J)),
			new Edge(v.H.getId(),v.D.getId(),v.H.distance(v.D)),new Edge(v.H.getId(),v.G.getId(),v.H.distance(v.G)),new Edge(v.H.getId(),v.I.getId(),v.H.distance(v.I)),
			new Edge(v.I.getId(),v.H.getId(),v.I.distance(v.H)),new Edge(v.I.getId(),v.J.getId(),v.I.distance(v.J)),new Edge(v.I.getId(),v.M.getId(),v.I.distance(v.M)),new Edge(v.I.getId(),v.st3.getId(),v.I.distance(v.st3.getPosition())),
			new Edge(v.I.getId(),v.st4.getId(),v.I.distance(v.st4.getPosition())),new Edge(v.J.getId(),v.G.getId(),v.J.distance(v.G)),new Edge(v.J.getId(),v.I.getId(),v.J.distance(v.I)),
			new Edge(v.J.getId(),v.K.getId(),v.J.distance(v.K)),new Edge(v.J.getId(),v.st1.getId(),v.J.distance(v.st1.getPosition())),new Edge(v.J.getId(),v.st4.getId(),v.J.distance(v.st4.getPosition())),
			new Edge(v.K.getId(),v.J.getId(),v.K.distance(v.J)),new Edge(v.K.getId(),v.st1.getId(),v.K.distance(v.st1.getPosition())),
			new Edge(v.L.getId(),v.I.getId(),v.L.distance(v.I)),
			new Edge(v.M.getId(),v.I.getId(),v.M.distance(v.I)),new Edge(v.M.getId(),v.st5.getId(),v.M.distance(v.st5.getPosition()))
			
			);
		break;
	case 4:edges=Arrays.asList(new Edge(0,v.D.getId(),v.cd.distance(v.D)),new Edge(0,v.E.getId(),v.cd.distance(v.E)),
			new Edge(v.A.getId(),v.B.getId(),v.A.distance(v.B)),new Edge(v.B.getId(),v.A.getId(),v.B.distance(v.A)),new Edge(v.B.getId(),v.D.getId(),v.B.distance(v.D)),
			new Edge(v.B.getId(),v.F.getId(),v.B.distance(v.F)),new Edge(v.B.getId(),v.G.getId(),v.B.distance(v.G)),new Edge(v.B.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),
			new Edge(v.C.getId(),v.D.getId(),v.C.distance(v.D)),new Edge(v.D.getId(),v.B.getId(),v.D.distance(v.B)),new Edge(v.D.getId(),v.C.getId(),v.D.distance(v.C)),new Edge(v.D.getId(),v.E.getId(),v.D.distance(v.E)),
			new Edge(v.D.getId(),v.H.getId(),v.D.distance(v.H)),new Edge(v.D.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),new Edge(v.E.getId(),v.D.getId(),v.E.distance(v.D)),
			new Edge(v.F.getId(),v.B.getId(),v.F.distance(v.B)),new Edge(v.G.getId(),v.B.getId(),v.G.distance(v.B)),new Edge(v.G.getId(),v.H.getId(),v.G.distance(v.H)),new Edge(v.G.getId(),v.J.getId(),v.G.distance(v.J)),
			new Edge(v.H.getId(),v.D.getId(),v.H.distance(v.D)),new Edge(v.H.getId(),v.G.getId(),v.H.distance(v.G)),new Edge(v.H.getId(),v.I.getId(),v.H.distance(v.I)),
			new Edge(v.I.getId(),v.H.getId(),v.I.distance(v.H)),new Edge(v.I.getId(),v.J.getId(),v.I.distance(v.J)),new Edge(v.I.getId(),v.M.getId(),v.I.distance(v.M)),new Edge(v.I.getId(),v.st3.getId(),v.I.distance(v.st3.getPosition())),
			new Edge(v.I.getId(),v.st4.getId(),v.I.distance(v.st4.getPosition())),new Edge(v.J.getId(),v.G.getId(),v.J.distance(v.G)),new Edge(v.J.getId(),v.I.getId(),v.J.distance(v.I)),
			new Edge(v.J.getId(),v.K.getId(),v.J.distance(v.K)),new Edge(v.J.getId(),v.st1.getId(),v.J.distance(v.st1.getPosition())),new Edge(v.J.getId(),v.st4.getId(),v.J.distance(v.st4.getPosition())),
			new Edge(v.K.getId(),v.J.getId(),v.K.distance(v.J)),new Edge(v.K.getId(),v.st1.getId(),v.K.distance(v.st1.getPosition())),
			new Edge(v.L.getId(),v.I.getId(),v.L.distance(v.I)),
			new Edge(v.M.getId(),v.I.getId(),v.M.distance(v.I)),new Edge(v.M.getId(),v.st5.getId(),v.M.distance(v.st5.getPosition()))
			
			);
		break;
	case 5:edges=Arrays.asList(new Edge(0,v.B.getId(),v.cd.distance(v.B)),new Edge(0,v.D.getId(),v.cd.distance(v.D)),new Edge(0,v.st2.getId(),v.cd.distance(v.st2.getPosition())),
			new Edge(v.A.getId(),v.B.getId(),v.A.distance(v.B)),new Edge(v.B.getId(),v.A.getId(),v.B.distance(v.A)),new Edge(v.B.getId(),v.D.getId(),v.B.distance(v.D)),
			new Edge(v.B.getId(),v.F.getId(),v.B.distance(v.F)),new Edge(v.B.getId(),v.G.getId(),v.B.distance(v.G)),new Edge(v.B.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),
			new Edge(v.C.getId(),v.D.getId(),v.C.distance(v.D)),new Edge(v.D.getId(),v.B.getId(),v.D.distance(v.B)),new Edge(v.D.getId(),v.C.getId(),v.D.distance(v.C)),new Edge(v.D.getId(),v.E.getId(),v.D.distance(v.E)),
			new Edge(v.D.getId(),v.H.getId(),v.D.distance(v.H)),new Edge(v.D.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),new Edge(v.E.getId(),v.D.getId(),v.E.distance(v.D)),
			new Edge(v.F.getId(),v.B.getId(),v.F.distance(v.B)),new Edge(v.G.getId(),v.B.getId(),v.G.distance(v.B)),new Edge(v.G.getId(),v.H.getId(),v.G.distance(v.H)),new Edge(v.G.getId(),v.J.getId(),v.G.distance(v.J)),
			new Edge(v.H.getId(),v.D.getId(),v.H.distance(v.D)),new Edge(v.H.getId(),v.G.getId(),v.H.distance(v.G)),new Edge(v.H.getId(),v.I.getId(),v.H.distance(v.I)),
			new Edge(v.I.getId(),v.H.getId(),v.I.distance(v.H)),new Edge(v.I.getId(),v.J.getId(),v.I.distance(v.J)),new Edge(v.I.getId(),v.M.getId(),v.I.distance(v.M)),new Edge(v.I.getId(),v.st3.getId(),v.I.distance(v.st3.getPosition())),
			new Edge(v.I.getId(),v.st4.getId(),v.I.distance(v.st4.getPosition())),new Edge(v.J.getId(),v.G.getId(),v.J.distance(v.G)),new Edge(v.J.getId(),v.I.getId(),v.J.distance(v.I)),
			new Edge(v.J.getId(),v.K.getId(),v.J.distance(v.K)),new Edge(v.J.getId(),v.st1.getId(),v.J.distance(v.st1.getPosition())),new Edge(v.J.getId(),v.st4.getId(),v.J.distance(v.st4.getPosition())),
			new Edge(v.K.getId(),v.J.getId(),v.K.distance(v.J)),new Edge(v.K.getId(),v.st1.getId(),v.K.distance(v.st1.getPosition())),
			new Edge(v.L.getId(),v.I.getId(),v.L.distance(v.I)),
			new Edge(v.M.getId(),v.I.getId(),v.M.distance(v.I)),new Edge(v.M.getId(),v.st5.getId(),v.M.distance(v.st5.getPosition()))
			
			);
		break;
	case 6:edges=Arrays.asList(new Edge(0,v.D.getId(),v.cd.distance(v.D)),new Edge(0,v.H.getId(),v.cd.distance(v.H)),
			new Edge(v.A.getId(),v.B.getId(),v.A.distance(v.B)),new Edge(v.B.getId(),v.A.getId(),v.B.distance(v.A)),new Edge(v.B.getId(),v.D.getId(),v.B.distance(v.D)),
			new Edge(v.B.getId(),v.F.getId(),v.B.distance(v.F)),new Edge(v.B.getId(),v.G.getId(),v.B.distance(v.G)),new Edge(v.B.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),
			new Edge(v.C.getId(),v.D.getId(),v.C.distance(v.D)),new Edge(v.D.getId(),v.B.getId(),v.D.distance(v.B)),new Edge(v.D.getId(),v.C.getId(),v.D.distance(v.C)),new Edge(v.D.getId(),v.E.getId(),v.D.distance(v.E)),
			new Edge(v.D.getId(),v.H.getId(),v.D.distance(v.H)),new Edge(v.D.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),new Edge(v.E.getId(),v.D.getId(),v.E.distance(v.D)),
			new Edge(v.F.getId(),v.B.getId(),v.F.distance(v.B)),new Edge(v.G.getId(),v.B.getId(),v.G.distance(v.B)),new Edge(v.G.getId(),v.H.getId(),v.G.distance(v.H)),new Edge(v.G.getId(),v.J.getId(),v.G.distance(v.J)),
			new Edge(v.H.getId(),v.D.getId(),v.H.distance(v.D)),new Edge(v.H.getId(),v.G.getId(),v.H.distance(v.G)),new Edge(v.H.getId(),v.I.getId(),v.H.distance(v.I)),
			new Edge(v.I.getId(),v.H.getId(),v.I.distance(v.H)),new Edge(v.I.getId(),v.J.getId(),v.I.distance(v.J)),new Edge(v.I.getId(),v.M.getId(),v.I.distance(v.M)),new Edge(v.I.getId(),v.st3.getId(),v.I.distance(v.st3.getPosition())),
			new Edge(v.I.getId(),v.st4.getId(),v.I.distance(v.st4.getPosition())),new Edge(v.J.getId(),v.G.getId(),v.J.distance(v.G)),new Edge(v.J.getId(),v.I.getId(),v.J.distance(v.I)),
			new Edge(v.J.getId(),v.K.getId(),v.J.distance(v.K)),new Edge(v.J.getId(),v.st1.getId(),v.J.distance(v.st1.getPosition())),new Edge(v.J.getId(),v.st4.getId(),v.J.distance(v.st4.getPosition())),
			new Edge(v.K.getId(),v.J.getId(),v.K.distance(v.J)),new Edge(v.K.getId(),v.st1.getId(),v.K.distance(v.st1.getPosition())),
			new Edge(v.L.getId(),v.I.getId(),v.L.distance(v.I)),
			new Edge(v.M.getId(),v.I.getId(),v.M.distance(v.I)),new Edge(v.M.getId(),v.st5.getId(),v.M.distance(v.st5.getPosition()))
			
			);
		break;
	case 7:edges=Arrays.asList(new Edge(0,v.B.getId(),v.cd.distance(v.B)),new Edge(0,v.G.getId(),v.cd.distance(v.G)),
			new Edge(v.A.getId(),v.B.getId(),v.A.distance(v.B)),new Edge(v.B.getId(),v.A.getId(),v.B.distance(v.A)),new Edge(v.B.getId(),v.D.getId(),v.B.distance(v.D)),
			new Edge(v.B.getId(),v.F.getId(),v.B.distance(v.F)),new Edge(v.B.getId(),v.G.getId(),v.B.distance(v.G)),new Edge(v.B.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),
			new Edge(v.C.getId(),v.D.getId(),v.C.distance(v.D)),new Edge(v.D.getId(),v.B.getId(),v.D.distance(v.B)),new Edge(v.D.getId(),v.C.getId(),v.D.distance(v.C)),new Edge(v.D.getId(),v.E.getId(),v.D.distance(v.E)),
			new Edge(v.D.getId(),v.H.getId(),v.D.distance(v.H)),new Edge(v.D.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),new Edge(v.E.getId(),v.D.getId(),v.E.distance(v.D)),
			new Edge(v.F.getId(),v.B.getId(),v.F.distance(v.B)),new Edge(v.G.getId(),v.B.getId(),v.G.distance(v.B)),new Edge(v.G.getId(),v.H.getId(),v.G.distance(v.H)),new Edge(v.G.getId(),v.J.getId(),v.G.distance(v.J)),
			new Edge(v.H.getId(),v.D.getId(),v.H.distance(v.D)),new Edge(v.H.getId(),v.G.getId(),v.H.distance(v.G)),new Edge(v.H.getId(),v.I.getId(),v.H.distance(v.I)),
			new Edge(v.I.getId(),v.H.getId(),v.I.distance(v.H)),new Edge(v.I.getId(),v.J.getId(),v.I.distance(v.J)),new Edge(v.I.getId(),v.M.getId(),v.I.distance(v.M)),new Edge(v.I.getId(),v.st3.getId(),v.I.distance(v.st3.getPosition())),
			new Edge(v.I.getId(),v.st4.getId(),v.I.distance(v.st4.getPosition())),new Edge(v.J.getId(),v.G.getId(),v.J.distance(v.G)),new Edge(v.J.getId(),v.I.getId(),v.J.distance(v.I)),
			new Edge(v.J.getId(),v.K.getId(),v.J.distance(v.K)),new Edge(v.J.getId(),v.st1.getId(),v.J.distance(v.st1.getPosition())),new Edge(v.J.getId(),v.st4.getId(),v.J.distance(v.st4.getPosition())),
			new Edge(v.K.getId(),v.J.getId(),v.K.distance(v.J)),new Edge(v.K.getId(),v.st1.getId(),v.K.distance(v.st1.getPosition())),
			new Edge(v.L.getId(),v.I.getId(),v.L.distance(v.I)),
			new Edge(v.M.getId(),v.I.getId(),v.M.distance(v.I)),new Edge(v.M.getId(),v.st5.getId(),v.M.distance(v.st5.getPosition()))
			
			);
		break;
	case 8:edges=Arrays.asList(new Edge(0,v.G.getId(),v.cd.distance(v.G)),new Edge(0,v.H.getId(),v.cd.distance(v.H)),
			new Edge(v.A.getId(),v.B.getId(),v.A.distance(v.B)),new Edge(v.B.getId(),v.A.getId(),v.B.distance(v.A)),new Edge(v.B.getId(),v.D.getId(),v.B.distance(v.D)),
			new Edge(v.B.getId(),v.F.getId(),v.B.distance(v.F)),new Edge(v.B.getId(),v.G.getId(),v.B.distance(v.G)),new Edge(v.B.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),
			new Edge(v.C.getId(),v.D.getId(),v.C.distance(v.D)),new Edge(v.D.getId(),v.B.getId(),v.D.distance(v.B)),new Edge(v.D.getId(),v.C.getId(),v.D.distance(v.C)),new Edge(v.D.getId(),v.E.getId(),v.D.distance(v.E)),
			new Edge(v.D.getId(),v.H.getId(),v.D.distance(v.H)),new Edge(v.D.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),new Edge(v.E.getId(),v.D.getId(),v.E.distance(v.D)),
			new Edge(v.F.getId(),v.B.getId(),v.F.distance(v.B)),new Edge(v.G.getId(),v.B.getId(),v.G.distance(v.B)),new Edge(v.G.getId(),v.H.getId(),v.G.distance(v.H)),new Edge(v.G.getId(),v.J.getId(),v.G.distance(v.J)),
			new Edge(v.H.getId(),v.D.getId(),v.H.distance(v.D)),new Edge(v.H.getId(),v.G.getId(),v.H.distance(v.G)),new Edge(v.H.getId(),v.I.getId(),v.H.distance(v.I)),
			new Edge(v.I.getId(),v.H.getId(),v.I.distance(v.H)),new Edge(v.I.getId(),v.J.getId(),v.I.distance(v.J)),new Edge(v.I.getId(),v.M.getId(),v.I.distance(v.M)),new Edge(v.I.getId(),v.st3.getId(),v.I.distance(v.st3.getPosition())),
			new Edge(v.I.getId(),v.st4.getId(),v.I.distance(v.st4.getPosition())),new Edge(v.J.getId(),v.G.getId(),v.J.distance(v.G)),new Edge(v.J.getId(),v.I.getId(),v.J.distance(v.I)),
			new Edge(v.J.getId(),v.K.getId(),v.J.distance(v.K)),new Edge(v.J.getId(),v.st1.getId(),v.J.distance(v.st1.getPosition())),new Edge(v.J.getId(),v.st4.getId(),v.J.distance(v.st4.getPosition())),
			new Edge(v.K.getId(),v.J.getId(),v.K.distance(v.J)),new Edge(v.K.getId(),v.st1.getId(),v.K.distance(v.st1.getPosition())),
			new Edge(v.L.getId(),v.I.getId(),v.L.distance(v.I)),
			new Edge(v.M.getId(),v.I.getId(),v.M.distance(v.I)),new Edge(v.M.getId(),v.st5.getId(),v.M.distance(v.st5.getPosition()))
			
			);
		break;
	case 9:edges=Arrays.asList(new Edge(0,v.H.getId(),v.cd.distance(v.H)),new Edge(0,v.I.getId(),v.cd.distance(v.I)),
			new Edge(v.A.getId(),v.B.getId(),v.A.distance(v.B)),new Edge(v.B.getId(),v.A.getId(),v.B.distance(v.A)),new Edge(v.B.getId(),v.D.getId(),v.B.distance(v.D)),
			new Edge(v.B.getId(),v.F.getId(),v.B.distance(v.F)),new Edge(v.B.getId(),v.G.getId(),v.B.distance(v.G)),new Edge(v.B.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),
			new Edge(v.C.getId(),v.D.getId(),v.C.distance(v.D)),new Edge(v.D.getId(),v.B.getId(),v.D.distance(v.B)),new Edge(v.D.getId(),v.C.getId(),v.D.distance(v.C)),new Edge(v.D.getId(),v.E.getId(),v.D.distance(v.E)),
			new Edge(v.D.getId(),v.H.getId(),v.D.distance(v.H)),new Edge(v.D.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),new Edge(v.E.getId(),v.D.getId(),v.E.distance(v.D)),
			new Edge(v.F.getId(),v.B.getId(),v.F.distance(v.B)),new Edge(v.G.getId(),v.B.getId(),v.G.distance(v.B)),new Edge(v.G.getId(),v.H.getId(),v.G.distance(v.H)),new Edge(v.G.getId(),v.J.getId(),v.G.distance(v.J)),
			new Edge(v.H.getId(),v.D.getId(),v.H.distance(v.D)),new Edge(v.H.getId(),v.G.getId(),v.H.distance(v.G)),new Edge(v.H.getId(),v.I.getId(),v.H.distance(v.I)),
			new Edge(v.I.getId(),v.H.getId(),v.I.distance(v.H)),new Edge(v.I.getId(),v.J.getId(),v.I.distance(v.J)),new Edge(v.I.getId(),v.M.getId(),v.I.distance(v.M)),new Edge(v.I.getId(),v.st3.getId(),v.I.distance(v.st3.getPosition())),
			new Edge(v.I.getId(),v.st4.getId(),v.I.distance(v.st4.getPosition())),new Edge(v.J.getId(),v.G.getId(),v.J.distance(v.G)),new Edge(v.J.getId(),v.I.getId(),v.J.distance(v.I)),
			new Edge(v.J.getId(),v.K.getId(),v.J.distance(v.K)),new Edge(v.J.getId(),v.st1.getId(),v.J.distance(v.st1.getPosition())),new Edge(v.J.getId(),v.st4.getId(),v.J.distance(v.st4.getPosition())),
			new Edge(v.K.getId(),v.J.getId(),v.K.distance(v.J)),new Edge(v.K.getId(),v.st1.getId(),v.K.distance(v.st1.getPosition())),
			new Edge(v.L.getId(),v.I.getId(),v.L.distance(v.I)),
			new Edge(v.M.getId(),v.I.getId(),v.M.distance(v.I)),new Edge(v.M.getId(),v.st5.getId(),v.M.distance(v.st5.getPosition()))
			
			);
		break;
	case 10:edges=Arrays.asList(new Edge(0,v.G.getId(),v.cd.distance(v.G)),new Edge(0,v.J.getId(),v.cd.distance(v.J)),
			new Edge(v.A.getId(),v.B.getId(),v.A.distance(v.B)),new Edge(v.B.getId(),v.A.getId(),v.B.distance(v.A)),new Edge(v.B.getId(),v.D.getId(),v.B.distance(v.D)),
			new Edge(v.B.getId(),v.F.getId(),v.B.distance(v.F)),new Edge(v.B.getId(),v.G.getId(),v.B.distance(v.G)),new Edge(v.B.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),
			new Edge(v.C.getId(),v.D.getId(),v.C.distance(v.D)),new Edge(v.D.getId(),v.B.getId(),v.D.distance(v.B)),new Edge(v.D.getId(),v.C.getId(),v.D.distance(v.C)),new Edge(v.D.getId(),v.E.getId(),v.D.distance(v.E)),
			new Edge(v.D.getId(),v.H.getId(),v.D.distance(v.H)),new Edge(v.D.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),new Edge(v.E.getId(),v.D.getId(),v.E.distance(v.D)),
			new Edge(v.F.getId(),v.B.getId(),v.F.distance(v.B)),new Edge(v.G.getId(),v.B.getId(),v.G.distance(v.B)),new Edge(v.G.getId(),v.H.getId(),v.G.distance(v.H)),new Edge(v.G.getId(),v.J.getId(),v.G.distance(v.J)),
			new Edge(v.H.getId(),v.D.getId(),v.H.distance(v.D)),new Edge(v.H.getId(),v.G.getId(),v.H.distance(v.G)),new Edge(v.H.getId(),v.I.getId(),v.H.distance(v.I)),
			new Edge(v.I.getId(),v.H.getId(),v.I.distance(v.H)),new Edge(v.I.getId(),v.J.getId(),v.I.distance(v.J)),new Edge(v.I.getId(),v.M.getId(),v.I.distance(v.M)),new Edge(v.I.getId(),v.st3.getId(),v.I.distance(v.st3.getPosition())),
			new Edge(v.I.getId(),v.st4.getId(),v.I.distance(v.st4.getPosition())),new Edge(v.J.getId(),v.G.getId(),v.J.distance(v.G)),new Edge(v.J.getId(),v.I.getId(),v.J.distance(v.I)),
			new Edge(v.J.getId(),v.K.getId(),v.J.distance(v.K)),new Edge(v.J.getId(),v.st1.getId(),v.J.distance(v.st1.getPosition())),new Edge(v.J.getId(),v.st4.getId(),v.J.distance(v.st4.getPosition())),
			new Edge(v.K.getId(),v.J.getId(),v.K.distance(v.J)),new Edge(v.K.getId(),v.st1.getId(),v.K.distance(v.st1.getPosition())),
			new Edge(v.L.getId(),v.I.getId(),v.L.distance(v.I)),
			new Edge(v.M.getId(),v.I.getId(),v.M.distance(v.I)),new Edge(v.M.getId(),v.st5.getId(),v.M.distance(v.st5.getPosition()))
			
			);
		break;
	case 11:edges=Arrays.asList(new Edge(0,v.J.getId(),v.cd.distance(v.J)),new Edge(0,v.K.getId(),v.cd.distance(v.K)),new Edge(0,v.st1.getId(),v.cd.distance(v.st1.getPosition())),
			new Edge(v.A.getId(),v.B.getId(),v.A.distance(v.B)),new Edge(v.B.getId(),v.A.getId(),v.B.distance(v.A)),new Edge(v.B.getId(),v.D.getId(),v.B.distance(v.D)),
			new Edge(v.B.getId(),v.F.getId(),v.B.distance(v.F)),new Edge(v.B.getId(),v.G.getId(),v.B.distance(v.G)),new Edge(v.B.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),
			new Edge(v.C.getId(),v.D.getId(),v.C.distance(v.D)),new Edge(v.D.getId(),v.B.getId(),v.D.distance(v.B)),new Edge(v.D.getId(),v.C.getId(),v.D.distance(v.C)),new Edge(v.D.getId(),v.E.getId(),v.D.distance(v.E)),
			new Edge(v.D.getId(),v.H.getId(),v.D.distance(v.H)),new Edge(v.D.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),new Edge(v.E.getId(),v.D.getId(),v.E.distance(v.D)),
			new Edge(v.F.getId(),v.B.getId(),v.F.distance(v.B)),new Edge(v.G.getId(),v.B.getId(),v.G.distance(v.B)),new Edge(v.G.getId(),v.H.getId(),v.G.distance(v.H)),new Edge(v.G.getId(),v.J.getId(),v.G.distance(v.J)),
			new Edge(v.H.getId(),v.D.getId(),v.H.distance(v.D)),new Edge(v.H.getId(),v.G.getId(),v.H.distance(v.G)),new Edge(v.H.getId(),v.I.getId(),v.H.distance(v.I)),
			new Edge(v.I.getId(),v.H.getId(),v.I.distance(v.H)),new Edge(v.I.getId(),v.J.getId(),v.I.distance(v.J)),new Edge(v.I.getId(),v.M.getId(),v.I.distance(v.M)),new Edge(v.I.getId(),v.st3.getId(),v.I.distance(v.st3.getPosition())),
			new Edge(v.I.getId(),v.st4.getId(),v.I.distance(v.st4.getPosition())),new Edge(v.J.getId(),v.G.getId(),v.J.distance(v.G)),new Edge(v.J.getId(),v.I.getId(),v.J.distance(v.I)),
			new Edge(v.J.getId(),v.K.getId(),v.J.distance(v.K)),new Edge(v.J.getId(),v.st1.getId(),v.J.distance(v.st1.getPosition())),new Edge(v.J.getId(),v.st4.getId(),v.J.distance(v.st4.getPosition())),
			new Edge(v.K.getId(),v.J.getId(),v.K.distance(v.J)),new Edge(v.K.getId(),v.st1.getId(),v.K.distance(v.st1.getPosition())),
			new Edge(v.L.getId(),v.I.getId(),v.L.distance(v.I)),
			new Edge(v.M.getId(),v.I.getId(),v.M.distance(v.I)),new Edge(v.M.getId(),v.st5.getId(),v.M.distance(v.st5.getPosition()))
			
			);
		break;
	case 12:edges=Arrays.asList(new Edge(0,v.I.getId(),v.cd.distance(v.I)),new Edge(0,v.J.getId(),v.cd.distance(v.J)),new Edge(0,v.st4.getId(),v.cd.distance(v.st4.getPosition())),
			new Edge(v.A.getId(),v.B.getId(),v.A.distance(v.B)),new Edge(v.B.getId(),v.A.getId(),v.B.distance(v.A)),new Edge(v.B.getId(),v.D.getId(),v.B.distance(v.D)),
			new Edge(v.B.getId(),v.F.getId(),v.B.distance(v.F)),new Edge(v.B.getId(),v.G.getId(),v.B.distance(v.G)),new Edge(v.B.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),
			new Edge(v.C.getId(),v.D.getId(),v.C.distance(v.D)),new Edge(v.D.getId(),v.B.getId(),v.D.distance(v.B)),new Edge(v.D.getId(),v.C.getId(),v.D.distance(v.C)),new Edge(v.D.getId(),v.E.getId(),v.D.distance(v.E)),
			new Edge(v.D.getId(),v.H.getId(),v.D.distance(v.H)),new Edge(v.D.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),new Edge(v.E.getId(),v.D.getId(),v.E.distance(v.D)),
			new Edge(v.F.getId(),v.B.getId(),v.F.distance(v.B)),new Edge(v.G.getId(),v.B.getId(),v.G.distance(v.B)),new Edge(v.G.getId(),v.H.getId(),v.G.distance(v.H)),new Edge(v.G.getId(),v.J.getId(),v.G.distance(v.J)),
			new Edge(v.H.getId(),v.D.getId(),v.H.distance(v.D)),new Edge(v.H.getId(),v.G.getId(),v.H.distance(v.G)),new Edge(v.H.getId(),v.I.getId(),v.H.distance(v.I)),
			new Edge(v.I.getId(),v.H.getId(),v.I.distance(v.H)),new Edge(v.I.getId(),v.J.getId(),v.I.distance(v.J)),new Edge(v.I.getId(),v.M.getId(),v.I.distance(v.M)),new Edge(v.I.getId(),v.st3.getId(),v.I.distance(v.st3.getPosition())),
			new Edge(v.I.getId(),v.st4.getId(),v.I.distance(v.st4.getPosition())),new Edge(v.J.getId(),v.G.getId(),v.J.distance(v.G)),new Edge(v.J.getId(),v.I.getId(),v.J.distance(v.I)),
			new Edge(v.J.getId(),v.K.getId(),v.J.distance(v.K)),new Edge(v.J.getId(),v.st1.getId(),v.J.distance(v.st1.getPosition())),new Edge(v.J.getId(),v.st4.getId(),v.J.distance(v.st4.getPosition())),
			new Edge(v.K.getId(),v.J.getId(),v.K.distance(v.J)),new Edge(v.K.getId(),v.st1.getId(),v.K.distance(v.st1.getPosition())),
			new Edge(v.L.getId(),v.I.getId(),v.L.distance(v.I)),
			new Edge(v.M.getId(),v.I.getId(),v.M.distance(v.I)),new Edge(v.M.getId(),v.st5.getId(),v.M.distance(v.st5.getPosition()))
			
			);
		break;
	case 13:edges=Arrays.asList(new Edge(0,v.I.getId(),v.cd.distance(v.I)),new Edge(0,v.M.getId(),v.cd.distance(v.M)),new Edge(0,v.st5.getId(),v.cd.distance(v.st5.getPosition())),
			new Edge(v.A.getId(),v.B.getId(),v.A.distance(v.B)),new Edge(v.B.getId(),v.A.getId(),v.B.distance(v.A)),new Edge(v.B.getId(),v.D.getId(),v.B.distance(v.D)),
			new Edge(v.B.getId(),v.F.getId(),v.B.distance(v.F)),new Edge(v.B.getId(),v.G.getId(),v.B.distance(v.G)),new Edge(v.B.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),
			new Edge(v.C.getId(),v.D.getId(),v.C.distance(v.D)),new Edge(v.D.getId(),v.B.getId(),v.D.distance(v.B)),new Edge(v.D.getId(),v.C.getId(),v.D.distance(v.C)),new Edge(v.D.getId(),v.E.getId(),v.D.distance(v.E)),
			new Edge(v.D.getId(),v.H.getId(),v.D.distance(v.H)),new Edge(v.D.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),new Edge(v.E.getId(),v.D.getId(),v.E.distance(v.D)),
			new Edge(v.F.getId(),v.B.getId(),v.F.distance(v.B)),new Edge(v.G.getId(),v.B.getId(),v.G.distance(v.B)),new Edge(v.G.getId(),v.H.getId(),v.G.distance(v.H)),new Edge(v.G.getId(),v.J.getId(),v.G.distance(v.J)),
			new Edge(v.H.getId(),v.D.getId(),v.H.distance(v.D)),new Edge(v.H.getId(),v.G.getId(),v.H.distance(v.G)),new Edge(v.H.getId(),v.I.getId(),v.H.distance(v.I)),
			new Edge(v.I.getId(),v.H.getId(),v.I.distance(v.H)),new Edge(v.I.getId(),v.J.getId(),v.I.distance(v.J)),new Edge(v.I.getId(),v.M.getId(),v.I.distance(v.M)),new Edge(v.I.getId(),v.st3.getId(),v.I.distance(v.st3.getPosition())),
			new Edge(v.I.getId(),v.st4.getId(),v.I.distance(v.st4.getPosition())),new Edge(v.J.getId(),v.G.getId(),v.J.distance(v.G)),new Edge(v.J.getId(),v.I.getId(),v.J.distance(v.I)),
			new Edge(v.J.getId(),v.K.getId(),v.J.distance(v.K)),new Edge(v.J.getId(),v.st1.getId(),v.J.distance(v.st1.getPosition())),new Edge(v.J.getId(),v.st4.getId(),v.J.distance(v.st4.getPosition())),
			new Edge(v.K.getId(),v.J.getId(),v.K.distance(v.J)),new Edge(v.K.getId(),v.st1.getId(),v.K.distance(v.st1.getPosition())),
			new Edge(v.L.getId(),v.I.getId(),v.L.distance(v.I)),
			new Edge(v.M.getId(),v.I.getId(),v.M.distance(v.I)),new Edge(v.M.getId(),v.st5.getId(),v.M.distance(v.st5.getPosition()))
			
			);
		break;
	case 14:edges=Arrays.asList(new Edge(0,v.I.getId(),v.cd.distance(v.I)),new Edge(0,v.L.getId(),v.cd.distance(v.L)),new Edge(0,v.st3.getId(),v.cd.distance(v.st3.getPosition())),
			new Edge(v.A.getId(),v.B.getId(),v.A.distance(v.B)),new Edge(v.B.getId(),v.A.getId(),v.B.distance(v.A)),new Edge(v.B.getId(),v.D.getId(),v.B.distance(v.D)),
			new Edge(v.B.getId(),v.F.getId(),v.B.distance(v.F)),new Edge(v.B.getId(),v.G.getId(),v.B.distance(v.G)),new Edge(v.B.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),
			new Edge(v.C.getId(),v.D.getId(),v.C.distance(v.D)),new Edge(v.D.getId(),v.B.getId(),v.D.distance(v.B)),new Edge(v.D.getId(),v.C.getId(),v.D.distance(v.C)),new Edge(v.D.getId(),v.E.getId(),v.D.distance(v.E)),
			new Edge(v.D.getId(),v.H.getId(),v.D.distance(v.H)),new Edge(v.D.getId(),v.st2.getId(),v.B.distance(v.st2.getPosition())),new Edge(v.E.getId(),v.D.getId(),v.E.distance(v.D)),
			new Edge(v.F.getId(),v.B.getId(),v.F.distance(v.B)),new Edge(v.G.getId(),v.B.getId(),v.G.distance(v.B)),new Edge(v.G.getId(),v.H.getId(),v.G.distance(v.H)),new Edge(v.G.getId(),v.J.getId(),v.G.distance(v.J)),
			new Edge(v.H.getId(),v.D.getId(),v.H.distance(v.D)),new Edge(v.H.getId(),v.G.getId(),v.H.distance(v.G)),new Edge(v.H.getId(),v.I.getId(),v.H.distance(v.I)),
			new Edge(v.I.getId(),v.H.getId(),v.I.distance(v.H)),new Edge(v.I.getId(),v.J.getId(),v.I.distance(v.J)),new Edge(v.I.getId(),v.M.getId(),v.I.distance(v.M)),new Edge(v.I.getId(),v.st3.getId(),v.I.distance(v.st3.getPosition())),
			new Edge(v.I.getId(),v.st4.getId(),v.I.distance(v.st4.getPosition())),new Edge(v.J.getId(),v.G.getId(),v.J.distance(v.G)),new Edge(v.J.getId(),v.I.getId(),v.J.distance(v.I)),
			new Edge(v.J.getId(),v.K.getId(),v.J.distance(v.K)),new Edge(v.J.getId(),v.st1.getId(),v.J.distance(v.st1.getPosition())),new Edge(v.J.getId(),v.st4.getId(),v.J.distance(v.st4.getPosition())),
			new Edge(v.K.getId(),v.J.getId(),v.K.distance(v.J)),new Edge(v.K.getId(),v.st1.getId(),v.K.distance(v.st1.getPosition())),
			new Edge(v.L.getId(),v.I.getId(),v.L.distance(v.I)),
			new Edge(v.M.getId(),v.I.getId(),v.M.distance(v.I)),new Edge(v.M.getId(),v.st5.getId(),v.M.distance(v.st5.getPosition()))
			
			);
		break;
		default: JOptionPane.showMessageDialog(null, "votre localisation indique un point deja stationné mettez vous en route puis essayé de nouveau", "position pas propice pour une demande de stationnement", JOptionPane.INFORMATION_MESSAGE);
	
	}
	// generation du graphe
	Graph graph=new Graph(edges,19);
	cout=findShortestPaths(graph,0, 19);// determination du plus court chemin 
	pointtrajets();// receuillement des points du trajet
}
	    
/**
 * cette methode permet de recuperer les stations disponibles
 */
public  void stationDispo() {
	stationsdisponibles=new ArrayList<Stationnement>();
	for(Stationnement s:stations) {
		if(s.getEtat()) {
			stationsdisponibles.add(s);
		}
	}
}
/**
 * cette methode prend en parametre une position et genere l'ID de la route sur laquelle se trouve le point
 * @param p
 * @return
 */
public int getcase(Position p) {
	int id=0;
	for(route s:routes) {
		if(s.appartient(p)) {//condition d'appartenance à la route
			id=s.getId();
			return id;
		}	
	}
return id;	
}
/**
 * cette methode enclenche l'ensemble du traitement menant à la determination du plus court trajet en prennant en entrée la position de la source
 * @param p
 */
public void traitement(Position p) {
	generate_graph(getcase( p));
}
/**
 * genere un tableau des indices des points du trajet
 * @param prev
 * @param i
 * @param route
 */
private static void getRoute(int[] prev, int i, List<Integer> route)
   {
       if (i >= 0)
       {
           getRoute(prev, prev[i], route);
           route.add(i);
       }
   }
/**
 * l'algorithme de djikstra qui genere le plus court chemin entre un neoud et tous les autres noeuds et retourne le plus petit cout menant à une 
 * station.
 * @param graph
 * @param source
 * @param n
 * @return
 */
   // Exécute l'algorithme de Dijkstra sur un graphe donné
   public  int findShortestPaths(Graph graph, int source, int n)
   {
       // crée un min-heap et pousse le nœud source ayant une distance de 0
       PriorityQueue<Node> minHeap;
       minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
       minHeap.add(new Node(source, 0));

       // définit la distance initiale de la source à `v` comme infini
       List<Integer> dist;
       dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

       // la distance de la source à elle-même est nulle
       dist.set(source, 0);

       // array booléen pour suivre les sommets pour lesquels le minimum
       // le coût est déjà trouvé
       boolean[] done = new boolean[n];
       done[source] = true;

       // stocke le prédécesseur d'un sommet (dans un chemin d'impression)
       int[] prev = new int[n];
       prev[source] = -1;

       // exécuter jusqu'à ce que le Min-Heap soit vide
       while (!minHeap.isEmpty())
       {
           // Supprime et renvoie le meilleur sommet
           Node node = minHeap.poll();

           // récupère le numéro du sommet
           int u = node.vertex;;

           // faire pour chaque voisin `v` de `u`
           for (Edge edge: graph.adjList.get(u))
           {
               int v = edge.dest;
               int weight = edge.weight;

               // Etape détente
               if (!done[v] && (dist.get(u) + weight) < dist.get(v))
               {
                   dist.set(v, dist.get(u) + weight);
                   prev[v] = u;
                   minHeap.add(new Node(v, dist.get(v)));
               }
           }

           // marque le sommet `u` comme terminé pour qu'il ne soit plus repris
           done[u] = true;
       }
       stationDispo();
       List<Integer> route = new ArrayList<>();
       
       int coutmin=Integer.MAX_VALUE;
       for (int i=0; i<stationsdisponibles.size();i++)
       {
           if (stationsdisponibles.get(i).getId() != source && dist.get(i) != Integer.MAX_VALUE) {
               getRoute(prev,stationsdisponibles.get(i).getId(), route);//recuperation du chemin le plus court menant aux differents stations
              //obtention du meilleur choix
               if(dist.get(stationsdisponibles.get(i).getId())<=coutmin) {
            	   coutmin=dist.get(stationsdisponibles.get(i).getId());
            	    Laroute.clear();
            	    getRoute(prev,stationsdisponibles.get(i).getId(), Laroute);
               }
               System.out.printf("Path (%d —> %d): Minimum cost = %d, Route = %s\n",
                               source, stationsdisponibles.get(i).getId(), dist.get(stationsdisponibles.get(i).getId()), route);
               route.clear();
           }
       }
       return coutmin;
   }
   /**
    * cette methode est une methode de soutien pas utilisé mais permettant de receuillir les points du trajet.
    */
public void pointtrajets() {
	for(int s: Laroute) {
		boolean garbage;
		if(pointintersection(s))garbage=false;
		else { garbage=pointstation(s);}
	}
}
/**
 * cette methode permet de generer les differents points du trajet autre que les stations à partir de leurs id et les stoke dans le tableau pointtrajet
 * @param id
 * @return
 */
   public boolean pointintersection(int id) {
	   boolean resultat=false;
	   for(Position s:intersections) {
		   if(s.getId()==id) {//verification de la correspondance de l'id
			   pointTrajet.add(s);//ajout du point
			return   resultat=true;
		   }
	   }
			   return resultat;
   }
   /**
    * cette methode genere la position de la station d'arrivé à partir de l'id et l'ajoute dans le tableau de points dutrajet et retourne un boolean
    * @param id
    * @return
    */
   public boolean pointstation(int id) {
	   boolean resultat=false;
	   for(Stationnement s:stations) {
		   if(s.getId()==id) {
			   pointTrajet.add(s.getPosition());
			   nom=s.getNom_station();
			return   resultat=true;
		   }
	   }
			   return resultat;
   }
}

