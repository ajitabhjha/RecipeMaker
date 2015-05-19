package com.recipemaker.utils.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.recipemaker.objectmodel.Ingredient;
import com.recipemaker.objectmodel.Unit;
import com.recipemaker.utils.DateUtil;

public class DateUtilTest {

	@Test
	public void testDateAfterOrEqualEarlierDate() {
		DateUtil.setCurrentDate();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -2);
		boolean b = DateUtil.afterOrEqual(cal.getTime());
		assertFalse("Date is not after nor equal current date", b);
	}
	@Test
	public void testDateAfterOrEqualLaterDate() {
		DateUtil.setCurrentDate();
		Date d = new Date();
		d.setTime(d.getTime()+100000);
		boolean b = DateUtil.afterOrEqual(d);
		assertTrue("Date is after or equal current date", b);
	}
	@Test
	public void testDateAfterOrEqualSameDate() {
		DateUtil.setCurrentDate();
		Date d = new Date();
		boolean b = DateUtil.afterOrEqual(d);
		assertTrue("Date is after or equal current date", b);
	}
	
	@Test
	public void testcalculateEarliestDateOnIngredients() {
		Ingredient i1 = new Ingredient();
		i1.setItem("Bread");
		i1.setAmount(10);
		i1.setUnit(Unit.slices);
		try {
			i1.setUseBy(DateUtil.DATE_FORMAT.parse("26/05/2015"));
		} catch (ParseException e) {
		}
		Ingredient i2 = new Ingredient();
		i2.setItem("Butter");
		i2.setAmount(10);
		i2.setUnit(Unit.grams);
		try {
			i2.setUseBy(DateUtil.DATE_FORMAT.parse("27/05/2015"));
		} catch (ParseException e) {
		}
		Ingredient [] ing1 = new Ingredient[] {i1};
		Ingredient [] ing2 = new Ingredient[] {i2};
		
		int res = DateUtil.calculateEarliestDateOnIngredients(ing1, ing2);
		
		assertEquals("Earliest Expiry date is of ingredient Bread - " + DateUtil.DATE_FORMAT.format(i1.getUseBy()) ,res,-1);
	}

}
