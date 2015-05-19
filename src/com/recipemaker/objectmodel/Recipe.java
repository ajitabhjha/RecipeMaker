package com.recipemaker.objectmodel;

import java.util.Comparator;

import com.recipemaker.utils.DateUtil;

public class Recipe implements Comparator<Recipe>, Comparable<Recipe> {

	private String name;
	private Ingredient[] ingredients;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ingredient[] getIngredients() {
		return ingredients;
	}

	public void setIngredients(Ingredient[] ingredients) {
		this.ingredients = ingredients;
	}

	public String toString() {
		return name;
	}

	/**
	 * Overriding the compare method to sort the Recipe
	 * 
	 * @param d
	 * @param d1
	 * @return
	 */
	public int compare(Recipe r1, Recipe r2) {
		if (r1 == null || r1.getIngredients() == null)
			return -1;
		if (r2 == null || r2.getIngredients() == null)
			return 1;
		if (r1 == r2)
			return 0;

		return DateUtil.calculateEarliestDateOnIngredients(r1.getIngredients(),
				r2.getIngredients());
	}

	/**
	 * overriding the compareTo method
	 * 
	 * @param d
	 * @return
	 */
	public int compareTo(Recipe r2) {
		return compare(this, r2);
	}
}
