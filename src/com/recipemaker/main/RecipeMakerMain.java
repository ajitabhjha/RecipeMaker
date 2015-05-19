package com.recipemaker.main;

import java.util.HashMap;
import java.util.TreeSet;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.recipemaker.objectmodel.Ingredient;
import com.recipemaker.objectmodel.Recipe;
import com.recipemaker.objectmodel.RecipeArr;
import com.recipemaker.utils.CSVUtil;
import com.recipemaker.utils.DateUtil;
import com.recipemaker.utils.JSONUtil;

public class RecipeMakerMain {
	HashMap<String, Ingredient> ingredientMap = null;
	RecipeArr recipeArr = null;

	public RecipeMakerMain(String csvFile, String jsonFile) {
		ingredientMap = CSVUtil.loadCSV(csvFile);
		recipeArr = JSONUtil.loadJSON(jsonFile);
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Insufficient Arguments!!! Proper Usage:");
			System.out
					.println("java -jar RecipeMakerByAjitabh.jar <<absolute path of csv file>> <<absolute path of json file>>");
			System.exit(0);
		}
		if(args.length == 3 && args[2].equalsIgnoreCase("test")) {
			Result result = JUnitCore.runClasses(ReciperMakerUnitTestSuite.class);
		    for (Failure failure : result.getFailures()) {
		      System.out.println(failure.toString());
		    }
		}
		else {
			RecipeMakerMain recipeMaker = new RecipeMakerMain(args[0], args[1]);
			TreeSet<Recipe> recipes = recipeMaker.getRecipes();
			if (recipes.isEmpty()) {
				System.out.println("Order Takeout");
			} else {
				System.out.println(recipes);
			}
		}
	}

	/**
	 * this mehtod is responsible for iterating over all recipes and ingredients
	 * and lists which recipe can be made with available ingredients
	 * 
	 * @return Recipe TreeSet
	 */
	public TreeSet<Recipe> getRecipes() {
		TreeSet<Recipe> recipeSet = new TreeSet<Recipe>();
		DateUtil.setCurrentDate();
		for (Recipe recipe : recipeArr.getRecipes()) {
			boolean isAnyIngredientMissing = false;
			for (Ingredient ingredientReqd : recipe.getIngredients()) {
				Ingredient ingredient = ingredientMap.get(ingredientReqd
						.getItem());
				if (!isAvailable(ingredient, ingredientReqd.getAmount())
						|| isExpired(ingredient)) {
					isAnyIngredientMissing = true;
				}
				ingredientReqd.setUseBy(ingredient.getUseBy());
			}
			if (!isAnyIngredientMissing) {
				recipeSet.add(recipe);
			}
		}
		return recipeSet;
	}

	/**
	 * returns whether the ingredient is available or not by checking the amount
	 * left
	 * 
	 * @return
	 */
	public boolean isAvailable(Ingredient ingredient, int amount) {
		if (ingredient.getAmount() != null && ingredient.getAmount() >= amount)
			return true;
		return false;
	}

	/**
	 * returns whether the ingredient is passed its useBy Date
	 * 
	 * @return
	 */
	public boolean isExpired(Ingredient ingredient) {
		if (ingredient.getUseBy() != null
				&& !DateUtil.afterOrEqual(ingredient.getUseBy()))
			return true;
		return false;
	}

}
