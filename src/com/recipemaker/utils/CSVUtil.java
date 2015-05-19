package com.recipemaker.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Set;

import com.opencsv.CSVReader;
import com.recipemaker.objectmodel.Ingredient;
import com.recipemaker.objectmodel.Unit;

public class CSVUtil {
	
	/**
	 * Utility to load CSV from a file.
	 * @param fileName
	 * @return
	 */
	public static HashMap<String, Ingredient> loadCSV(String fileName) {
		HashMap<String, Ingredient> map = new HashMap<String, Ingredient>();
		try {
			CSVReader reader = new CSVReader(new FileReader(fileName));
			String[] nextLine = null;
			
			while ((nextLine = reader.readNext()) != null) {
				// nextLine[] is an array of values from the line
				Ingredient ingredient = new Ingredient();
				ingredient.setItem(nextLine[0]);
				ingredient.setAmount(Integer.valueOf(nextLine[1]));
				ingredient.setUnit(Unit.valueOf(nextLine[2]));
				ingredient.setUseBy(DateUtil.DATE_FORMAT.parse(nextLine[3]));
				map.put(nextLine[0], ingredient);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out
					.println("Error reading CSV file. ");
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Error parsing date.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error. ");
		}
//		System.out.println(map);
		return map;
	}
	
}
