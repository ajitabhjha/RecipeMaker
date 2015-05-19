package com.recipemaker.utils.test;

import static org.junit.Assert.assertFalse;

import java.util.HashMap;

import org.junit.Test;

import com.recipemaker.objectmodel.Ingredient;
import com.recipemaker.utils.CSVUtil;

public class CSVUtilTest {

	@Test
	public void test() {
		
		HashMap<String, Ingredient> map = CSVUtil.loadCSV("c:\\aj\\pactera\\fridge.csv");
		assertFalse("CSVUtil failed to load CSV file!!!", map.isEmpty());
	}


}
