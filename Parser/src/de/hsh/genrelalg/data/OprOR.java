package de.hsh.genrelalg.data;

public class OprOR {

	Predicate left, right;
	
	public OprOR(Predicate left, Predicate right) {
		this.left = left;
		this.right = right;
	}
	
	public Predicate getLeft() {
		return left;
	}
	
	public Predicate getRight() {
		return right;
	}
}
