package com.recipemaker.main.test;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.recipemaker.main.RecipeMakerMain;
import com.recipemaker.objectmodel.Recipe;
import com.recipemaker.utils.test.CSVUtilTest;
import com.recipemaker.utils.test.DateUtilTest;
import com.recipemaker.utils.test.JSONUtilTest;


public class RecipeMakerMainTest {

	@Test
	public void testGetRecipesAllItemsAvailable() {
		
		String [] args = new String[] {"c:\\aj\\pactera\\fridge.csv","c:\\aj\\pactera\\recipes.json"};
		RecipeMakerMain main = new RecipeMakerMain(args[0], args[1]);
		TreeSet<Recipe> recipes = main.getRecipes();
		assertFalse("Found no recipe where at least one recipe expected!!!",recipes == null || recipes.size() == 0);
	}
	
	@Test
	public void testGetRecipesPartialItemsAvailable() {
		
		String [] args = new String[] {"c:\\aj\\pactera\\fridge_partially_expired.csv","c:\\aj\\pactera\\recipes.json"};
		RecipeMakerMain main = new RecipeMakerMain(args[0], args[1]);
		TreeSet<Recipe> recipes = main.getRecipes();
		assertFalse("Found no recipe where at least one recipe expected!!!",recipes == null || recipes.size() == 0);
	}
	
	@Test
	public void testGetRecipesAllItemsUnAvailable() {
		
		String [] args = new String[] {"c:\\aj\\pactera\\fridge_expired.csv","c:\\aj\\pactera\\recipes.json"};
		RecipeMakerMain main = new RecipeMakerMain(args[0], args[1]);
		TreeSet<Recipe> recipes = main.getRecipes();
		assertTrue("Found recipe where recipe was not expected!!!",recipes == null || recipes.size() == 0);
	}

}
