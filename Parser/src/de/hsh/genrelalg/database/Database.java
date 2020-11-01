package de.hsh.genrelalg.database;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;

public class Database {
	
	private ArrayList<Relation> relations ;
	static Relation ANGEST, ANG_PRO, PROJEKT;
	static Relation REZEPT, ZUTAT, SCHRITT, ZUTAT_REZEPT;
	static double spread = 12;
	
	public Database() {
		
		relations = new ArrayList<>();
		
		ANGEST = new Relation("ANGEST", "ANGNR", "NAME", "WOHNORT", "BERUF", "GEHALT", "ABTNR");
		ANGEST.addTuple(new Tuple("112", "MÃ¼ller", "Karlsruhe", "Programmiererin", "4500", "3"));
		ANGEST.addTuple(new Tuple("205", "Winter", "Hamburg", "Analytikerin", "5600", "3"));
		ANGEST.addTuple(new Tuple("117", "MatthÃ¤us", "OsnabrÃ¼ck", "Werbefachfrau", "8000", "5"));
		ANGEST.addTuple(new Tuple("198", "Schmidt", "Hannover", "Ingenieur", "6400", "4"));
		ANGEST.addTuple(new Tuple("199", "Huber", "Hannover", "Administrator", "5000", "3"));
		relations.add(ANGEST);
		// Ang_pro Tabelle mit Daten füllen
		ANG_PRO = new Relation("ANG_PRO", "PNR", "ANGNR", "PROZ_ARB");
		ANG_PRO.addTuple(new Tuple("12", "112", "100"));
		ANG_PRO.addTuple(new Tuple("18", "205", "20"));
		ANG_PRO.addTuple(new Tuple("17", "117", "70"));
		ANG_PRO.addTuple(new Tuple("17", "198", "30"));
		ANG_PRO.addTuple(new Tuple("18", "198", "80"));
		ANG_PRO.addTuple(new Tuple("33", "198", "50"));
		relations.add(ANG_PRO);
		
		// Projekt Tabelle mit Daten füllen
		PROJEKT = new Relation("PROJEKT", "PNR", "NAME", "P_BESCHR", "P_LEITER");
		PROJEKT.addTuple(new Tuple("12", "Datawarehouse", "...", "205"));
		PROJEKT.addTuple(new Tuple("18", "Intranet", "...", "117"));
		PROJEKT.addTuple(new Tuple("17", "Projekt DBMigration", "...", "198"));
		PROJEKT.addTuple(new Tuple("33", "VU", "...", "198"));
		relations.add(PROJEKT);
		
		// Rezept Tabelle mit Daten füllen	
		REZEPT = new Relation("REZEPT", "REZEPT_ID", "R_NAME");
		REZEPT.addTuple(new Tuple("1", "Pizza"));
		REZEPT.addTuple(new Tuple("2", "Nudeln mit Sahnesauce"));
		relations.add(REZEPT);
		
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
		relations.add(ZUTAT);
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
		relations.add(SCHRITT);
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
		relations.add(ZUTAT_REZEPT);
	}

	public ArrayList<Relation> getRelations() {
		return this.relations;
	}

}
