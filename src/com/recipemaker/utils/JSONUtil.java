package com.recipemaker.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.recipemaker.objectmodel.Recipe;
import com.recipemaker.objectmodel.RecipeArr;

public class JSONUtil {
	/**
	 * utility to load JSON from a file
	 * @param fileName
	 * @return
	 */
	public static RecipeArr loadJSON(String fileName) {
		RecipeArr recipeArr = null;
		try {
			Reader reader = new FileReader(fileName);
			Gson gson = new GsonBuilder().create();
			recipeArr = gson.fromJson(reader, RecipeArr.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out
					.println("Error reading JSON file. ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error. ");
		}
//		System.out.println(recipeArr);
		return recipeArr;
	}

}
