package de.hsh.genrelalg.errors;

import java.util.ArrayList;
import java.util.List;

public class ErrorService {

	private static ErrorService errorService;
	private static List<Mistake> errors ;
	private ErrorService() {
		
	}
	
	public static ErrorService getInstance(){
		if(errorService == null) {
			errors = new ArrayList<>();
			errorService = new ErrorService();
		}
		return errorService;
	}
	
	public static void addError(Mistake m) {
		errors.add(m);
	}
	
	public List<Mistake> getMistakes() {
		return errors;
	}
}
