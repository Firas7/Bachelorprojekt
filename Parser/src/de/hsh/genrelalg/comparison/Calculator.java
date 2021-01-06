package de.hsh.genrelalg.comparison;


import de.hsh.genrelalg.errors.ErrorService;

public class Calculator {
	
	public static double calculatePoints(ErrorService errors, double points ){
		
		
		if(errors.getMistakes().size() == 0) {
			return points;
		}else {
			for(int i=0; i < errors.getMistakes().size(); i++) {
				points -= errors.getMistakes().get(i).getMinus();
				if(points == 0) {
					return 0;
				}
			}
			return points;
		}
	}
}
