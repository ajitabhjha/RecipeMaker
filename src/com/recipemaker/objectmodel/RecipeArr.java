package com.recipemaker.objectmodel;

import java.util.Arrays;

public class RecipeArr {
	private Recipe[] recipes;

	public Recipe[] getRecipes() {
		return recipes;
	}

	public void setRecipes(Recipe[] recipes) {
		this.recipes = recipes;
	}
	
	public String toString() {
		return "[" + Arrays.toString(recipes) + "]";
	}

}
