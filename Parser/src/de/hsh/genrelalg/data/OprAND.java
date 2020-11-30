package de.hsh.genrelalg.data;

public class OprAND {

	Predicate left, right;
	
	public OprAND(Predicate left, Predicate right) {
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
