package com.techelevator;

public class FruitTree {
	private String typeOfFruit;
	private int piecesOfFruitLeft;
	
	public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
		this.typeOfFruit = typeOfFruit;
		this.piecesOfFruitLeft = startingPiecesOfFruit;
	}
	
	public boolean pickFruit(int numberOfPiecesToRemove) {
		if (piecesOfFruitLeft < numberOfPiecesToRemove) {
			return false;
		}
			piecesOfFruitLeft -= numberOfPiecesToRemove;
			return true;
	}
	
	public String getTypeOfFruit() {
		return typeOfFruit;
	}
	
	public int getPiecesOfFruitLeft() {
		return piecesOfFruitLeft;
	}

}

//  | typeOfFruit | string | X | | The type of fruit on the tree. | | 
// piecesOfFruitLeft | int | X | | The number of remaining fruit pieces on the tree. |
/*
pickFruit() is a method
returns true if more fruit was picked or false if no fruit was left to be picked.
When picking fruit, update the number of remaining pieces by how many were removed
*/