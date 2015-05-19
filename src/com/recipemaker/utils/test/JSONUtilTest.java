package com.recipemaker.utils.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.recipemaker.objectmodel.RecipeArr;
import com.recipemaker.utils.JSONUtil;

public class JSONUtilTest {

	@Test
	public void test() {
		
		RecipeArr recipeArr = JSONUtil.loadJSON("c:\\aj\\pactera\\recipes.json");
		assertNotNull("JSONUtil failed to load JSON file!!!", recipeArr);
	}

}
