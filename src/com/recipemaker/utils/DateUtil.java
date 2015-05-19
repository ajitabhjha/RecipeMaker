package com.recipemaker.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.recipemaker.objectmodel.Ingredient;

public class DateUtil {
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"dd/MM/yyyy");
	private static Calendar cal = Calendar.getInstance();

	/**
	 * returns if the items is expired or not
	 * 
	 * @param targetDate
	 * @return
	 */
	public static boolean afterOrEqual(Date targetDate) {
		Calendar useBy = Calendar.getInstance();
		useBy.setTime(targetDate);
		useBy.set(Calendar.HOUR, 0);
		useBy.set(Calendar.MINUTE, 0);
		useBy.set(Calendar.SECOND, 0);
		useBy.set(Calendar.MILLISECOND, 0);
		if (useBy.after(cal) || cal.getTimeInMillis()==useBy.getTimeInMillis()) {
			return true;
		}
		

		return false;
	}

	/**
	 * method use to store the date on which the recipe maker was invoked for
	 * listing recipes. this avoids creating new instances of Calendar object
	 * for each Ingredient
	 */
	public static void setCurrentDate() {
		cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
	}

	/**
	 * returns the earliest expiry date of the item present in Ingredients array
	 * of Recipe
	 * 
	 * @param ingredients
	 * @return
	 */
	public static int calculateEarliestDateOnIngredients(Ingredient[] ingredientsR1,
			Ingredient[] ingredientsR2) {
		Date earlierstR1 = null;
		Date earlierstR2 = null;
		for (Ingredient ingredient : ingredientsR1) {
			if (earlierstR1 == null)
				earlierstR1 = ingredient.getUseBy();
			else if (earlierstR1.before(ingredient.getUseBy()))
				earlierstR1 = ingredient.getUseBy();
		}
		for (Ingredient ingredient : ingredientsR2) {
			if (earlierstR2 == null)
				earlierstR2 = ingredient.getUseBy();
			else if (earlierstR2.before(ingredient.getUseBy()))
				earlierstR2 = ingredient.getUseBy();
		}
		
		if(earlierstR1 == null)
			return -1;
		if(earlierstR2 == null)
			return 1;
		if(earlierstR1.after(earlierstR2) )
			return 1;
		else
			return -1;
	}

}
