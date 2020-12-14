package de.hsh.genrelalg;

import java.io.IOException;




import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;
import de.hsh.genrelalg.expr.ExprAttribute;
import de.hsh.genrelalg.expr.ExprConstant;
import de.hsh.genrelalg.expr.ExprEquals;
import de.hsh.genrelalg.expr.ExprIsNull;
import de.hsh.genrelalg.relalg.Join;
import de.hsh.genrelalg.relalg.Projection;
import de.hsh.genrelalg.relalg.RelationalAlgebra;
import de.hsh.genrelalg.relalg.Rename;
import de.hsh.genrelalg.relalg.Selection;
import de.hsh.genrelalg.relalg.SetMinus;

public class Main {

	static Relation ANGEST, ANG_PRO, PROJEKT;
	static Relation REZEPT, ZUTAT, SCHRITT, ZUTAT_REZEPT;
	static double spread = 12;
	
	public static void main(String[] args) throws IOException {

	
		
		
		// Angest Tabelle mit Daten füllen
		ANGEST = new Relation("ANGEST", "ANGNR", "NAME", "WOHNORT", "BERUF", "GEHALT", "ABTNR");
		ANGEST.addTuple(new Tuple("112", "MÃ¼ller", "Karlsruhe", "Programmiererin", "4500", "3"));
		ANGEST.addTuple(new Tuple("205", "Winter", "Hamburg", "Analytikerin", "5600", "3"));
		ANGEST.addTuple(new Tuple("117", "MatthÃ¤us", "OsnabrÃ¼ck", "Werbefachfrau", "8000", "5"));
		ANGEST.addTuple(new Tuple("198", "Schmidt", "Hannover", "Ingenieur", "6400", "4"));
		ANGEST.addTuple(new Tuple("199", "Huber", "Hannover", "Administrator", "5000", "3"));
		
		// Ang_pro Tabelle mit Daten füllen
		ANG_PRO = new Relation("ANG_PRO", "PNR", "ANGNR", "PROZ_ARB");
		ANG_PRO.addTuple(new Tuple("12", "112", "100"));
		ANG_PRO.addTuple(new Tuple("18", "205", "20"));
		ANG_PRO.addTuple(new Tuple("17", "117", "70"));
		ANG_PRO.addTuple(new Tuple("17", "198", "30"));
		ANG_PRO.addTuple(new Tuple("18", "198", "80"));
		ANG_PRO.addTuple(new Tuple("33", "198", "50"));
		
		// Projekt Tabelle mit Daten füllen
		PROJEKT = new Relation("PROJEKT", "PNR", "NAME", "P_BESCHR", "P_LEITER");
		PROJEKT.addTuple(new Tuple("12", "Datawarehouse", "...", "205"));
		PROJEKT.addTuple(new Tuple("18", "Intranet", "...", "117"));
		PROJEKT.addTuple(new Tuple("17", "Projekt DBMigration", "...", "198"));
		PROJEKT.addTuple(new Tuple("33", "VU", "...", "198"));

		// Rezept Tabelle mit Daten füllen	
		REZEPT = new Relation("REZEPT", "REZEPT_ID", "R_NAME");
		REZEPT.addTuple(new Tuple("1", "Pizza"));
		REZEPT.addTuple(new Tuple("2", "Nudeln mit Sahnesauce"));
		
		// Zutaten Tabelle mit Daten füllen
		ZUTAT = new Relation("ZUTAT", "ZUTAT_ID", "Z_NAME", "EINHEIT");
		ZUTAT.addTuple(new Tuple("1", "Hefeteig", "g"));
		ZUTAT.addTuple(new Tuple("2", "Tomatensauce", "ml"));
		ZUTAT.addTuple(new Tuple("3", "Emmentaler KÃ¤se", "g"));
		ZUTAT.addTuple(new Tuple("4", "Wasser", "l"));
		ZUTAT.addTuple(new Tuple("5", "Salz", "g"));
		ZUTAT.addTuple(new Tuple("6", "Nudeln", "g"));
		ZUTAT.addTuple(new Tuple("7", "Sahne", "ml"));
		ZUTAT.addTuple(new Tuple("8", "Pfeffer", "g"));
		ZUTAT.addTuple(new Tuple("9", "Schinken", "g"));

		// Schritt Tabelle mit Daten füllen
		SCHRITT = new Relation("SCHRITT", "NUMMER", "BESCHREIBUNG", "REZEPT_ID");
		SCHRITT.addTuple(new Tuple("1", "Hefeteig ausrollen", "1"));
		SCHRITT.addTuple(new Tuple("2", "Teig mit Tomatensauce bestreichen", "1"));
		SCHRITT.addTuple(new Tuple("3", "KÃ¤se Ã¼ber die Pizza reiben", "1"));
		SCHRITT.addTuple(new Tuple("4", "Pizza 15 min bei 200 Grad backen", "1"));
		SCHRITT.addTuple(new Tuple("1", "1 l Salziges Wasser zum Kochen bringen", "2"));
		SCHRITT.addTuple(new Tuple("2", "Nudeln in das Kochende Wasser geben, 8 min Kochen", "2"));
		SCHRITT.addTuple(new Tuple("3", "Sahne erhitzen und 10 min kÃ¶cheln lassen", "2"));
		SCHRITT.addTuple(new Tuple("4", "Sahne mit Pfeffer wÃ¼rzen und KÃ¤se reinreiben", "2"));

		// Zutat_Rezept Tabelle mit Daten füllen
		ZUTAT_REZEPT = new Relation("ZUTAT_REZEPT", "REZEPT_ID", "ZUTAT_ID", "MENGE");
		ZUTAT_REZEPT.addTuple(new Tuple("1", "1", "..."));
		ZUTAT_REZEPT.addTuple(new Tuple("1", "2", "..."));
		ZUTAT_REZEPT.addTuple(new Tuple("1", "3", "..."));
		ZUTAT_REZEPT.addTuple(new Tuple("2", "4", "..."));
		ZUTAT_REZEPT.addTuple(new Tuple("2", "5", "..."));
		ZUTAT_REZEPT.addTuple(new Tuple("2", "6", "..."));
		ZUTAT_REZEPT.addTuple(new Tuple("2", "7", "..."));
		ZUTAT_REZEPT.addTuple(new Tuple("2", "8", "..."));
		ZUTAT_REZEPT.addTuple(new Tuple("2", "3", "..."));

//		aufgabe5_1_a();
//		aufgabe5_1_b();
//		aufgabe5_1_c();
//		aufgabe5_1_d();
//		aufgabe5_1_e();
//		aufgabe5_1_f();
//		aufgabe5_1_f2();
//		
//		aufgabe5_2_b();
//		aufgabe5_2_c();
//		aufgabe5_2_d();
//		aufgabe5_2_d2();
	}

	public static void aufgabe5_1_a() throws IOException {
		// Aufgabe 5.1 a)
		Projection aufgabe = new Projection(ANGEST, new Attribute("WOHNORT"));
		writeOutput(aufgabe, "aufgabe5_1_A");
	}

	public static void aufgabe5_1_b() throws IOException {
		// Aufgabe 5.1 b)
		Projection aufgabeB = new Projection(ANGEST, new Attribute("NAME"), new Attribute("GEHALT"));
		writeOutput(aufgabeB, "aufgabe5_1_B");
	}

	public static void aufgabe5_1_c() throws IOException {
		// Aufgabe 5.1 c)
		Join join = new Join(ANGEST, ANG_PRO, new ExprEquals(new ExprAttribute("ANGEST", "ANGNR"), new ExprAttribute("ANG_PRO", "ANGNR")), spread);
		Projection aufgabeC = new Projection(join, new Attribute("NAME"));
		writeOutput(aufgabeC, "aufgabe5_1_C");
	}
	
	public static void aufgabe5_1_d() throws IOException {
		// Aufgabe 5.1 d)
		Selection selDWH = new Selection(PROJEKT, new ExprEquals(new ExprAttribute("NAME"), new ExprConstant("Datawarehouse")));		
		Join joinAngestAngPro = new Join(ANGEST, ANG_PRO, new ExprEquals(new ExprAttribute("ANGEST", "ANGNR"), new ExprAttribute("ANG_PRO", "ANGNR")), spread);
		Join join2 = new Join(joinAngestAngPro, selDWH, new ExprEquals(new ExprAttribute("ANG_PRO", "PNR"), new ExprAttribute("PROJEKT", "PNR")), 18);
		Projection aufgabeD = new Projection(join2, new Attribute("ANGEST", "NAME"));
		writeOutput(aufgabeD, "aufgabe5_1_D");
	}
	
	public static void aufgabe5_1_e() throws IOException {
		// Aufgabe 5.1 e)
		Selection selIntranet = new Selection(PROJEKT, new ExprEquals(new ExprAttribute("NAME"), new ExprConstant("Intranet")));		
		Join joinAngest = new Join(ANGEST, selIntranet, new ExprEquals(new ExprAttribute(null, "ANGNR"), new ExprAttribute("P_LEITER")), 16);
		Projection aufgabeE = new Projection(joinAngest, new Attribute("ANGEST", "NAME"), new Attribute(null, "BERUF"));
		writeOutput(aufgabeE, "aufgabe5_1_E");		
	}

	public static void aufgabe5_1_f() throws IOException {
		// Aufgabe 5.1 f)
		Projection angnrANGEST = new Projection(ANGEST, new Attribute("ANGNR"));
		Projection angnrANGPRO = new Projection(ANG_PRO, new Attribute("ANGNR"));
		SetMinus setminus = new SetMinus(angnrANGEST, angnrANGPRO, spread);
		Rename ren = new Rename(setminus, "OHNEPRJ");
		Join joinAngest = new Join(ANGEST, ren, new ExprEquals(new ExprAttribute("ANGEST", "ANGNR"), new ExprAttribute("OHNEPRJ", "ANGNR")), spread);
		Projection aufgabeF = new Projection(joinAngest, new Attribute("ANGEST", "NAME"));
		writeOutput(aufgabeF, "aufgabe5_1_F");		
	}

	public static void aufgabe5_1_f2() throws IOException {
		// Aufgabe 5.1 f) variante
		Join joinAngest = new Join(ANGEST, ANG_PRO, new ExprEquals(new ExprAttribute("ANGEST", "ANGNR"), new ExprAttribute("ANG_PRO", "ANGNR")), spread, true, false);
		Selection selUnmatched = new Selection(joinAngest, new ExprIsNull(new ExprAttribute("ANG_PRO", "ANGNR")));
		Projection aufgabeF2 = new Projection(selUnmatched, new Attribute("ANGEST", "NAME"));
		writeOutput(aufgabeF2, "aufgabe5_1_F2");		
	}



	public static void aufgabe5_2_b() throws IOException {
		// Aufgabe 5.2 b)
		Selection selPizza = new Selection(REZEPT, new ExprEquals(new ExprAttribute("R_NAME"), new ExprConstant("Pizza")));		
		Join join = new Join(ZUTAT_REZEPT, selPizza, new ExprEquals(new ExprAttribute("ZUTAT_REZEPT", "REZEPT_ID"), new ExprAttribute("REZEPT", "REZEPT_ID")), spread);
		Join join2 = new Join(ZUTAT, join, new ExprEquals(new ExprAttribute("ZUTAT", "ZUTAT_ID"), new ExprAttribute("ZUTAT_REZEPT", "ZUTAT_ID")), 18);
		Projection aufgabe = new Projection(join2, new Attribute("Z_NAME"));
		writeOutput(aufgabe, "aufgabe5_2_B");
	}

	public static void aufgabe5_2_c() throws IOException {
		// Aufgabe 5.2 c)
		Selection selPizza = new Selection(REZEPT, new ExprEquals(new ExprAttribute("R_NAME"), new ExprConstant("Pizza")));		
		Join join = new Join(SCHRITT, selPizza, new ExprEquals(new ExprAttribute("SCHRITT", "REZEPT_ID"), new ExprAttribute("REZEPT", "REZEPT_ID")), spread);
		Projection aufgabe = new Projection(join, new Attribute("NUMMER"), new Attribute("BESCHREIBUNG"));
		writeOutput(aufgabe, "aufgabe5_2_C");
	}

	public static void aufgabe5_2_d() throws IOException {
		// Aufgabe 6c
		Projection prj1 = new Projection(ZUTAT, new Attribute("ZUTAT_ID"));
		Projection prj2 = new Projection(ZUTAT_REZEPT, new Attribute("ZUTAT_ID"));
		SetMinus setminus = new SetMinus(prj1, prj2, spread);
		Rename ren = new Rename(setminus, "NICHTVERWENDET");
		Join join = new Join(ren, ZUTAT, new ExprEquals(new ExprAttribute("ZUTAT", "ZUTAT_ID"), new ExprAttribute("NICHTVERWENDET", "ZUTAT_ID")), spread);
		Projection aufgabe = new Projection(join, new Attribute("Z_NAME"));
		writeOutput(aufgabe, "aufgabe5_2_D");		
	}

	public static void aufgabe5_2_d2() throws IOException {
		Join join = new Join(ZUTAT, ZUTAT_REZEPT, new ExprEquals(new ExprAttribute("ZUTAT", "ZUTAT_ID"), new ExprAttribute("BRAUCHT", "ZUTAT_ID")), spread, true, false);
		Selection selUnmatched = new Selection(join, new ExprIsNull(new ExprAttribute("BRAUCHT", "ZUTAT_ID")));
		Projection aufgabe = new Projection(selUnmatched, new Attribute("ZUTAT", "Z_NAME"));
		writeOutput(aufgabe, "aufgabe5_2_D2");		
	}

	public static void writeOutput(RelationalAlgebra expr, String task) {
		System.out.println("Aufgabe: " + task + "\n");		
		System.out.println(expr.toText("", false));
		System.out.println("\n");
		System.out.println(expr.toText("", true));
	}

}
