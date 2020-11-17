package de.hsh.genrelalg.antlr.expression;

import java.util.List;

import de.hsh.genrelalg.data.Relation;

public class CarstesianExpr extends Expr{

	
	Relation left;
	String nameOfRelationLeft;
	String nameOfRelationRight;
	Relation right;
	
	public Relation getLeft() {
		return left;
	}

	public void setLeft(Relation left) {
		this.left = left;
	}

	public String getNameOfRelationLeft() {
		return nameOfRelationLeft;
	}

	public void setNameOfRelationLeft(String nameOfRelationLeft) {
		this.nameOfRelationLeft = nameOfRelationLeft;
	}

	public String getNameOfRelationRight() {
		return nameOfRelationRight;
	}

	public void setNameOfRelationRight(String nameOfRelationRight) {
		this.nameOfRelationRight = nameOfRelationRight;
	}

	public Relation getRight() {
		return right;
	}

	public void setRight(Relation right) {
		this.right = right;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String printSomething() {
		// TODO Auto-generated method stub
		return "Here is a Carstesian Operation";
	}

	@Override
	public Relation getRelation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRelation(Relation r) {
		// TODO Auto-generated method stub
		
	}

	
}
