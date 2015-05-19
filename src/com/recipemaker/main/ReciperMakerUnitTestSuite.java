package com.recipemaker.main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.recipemaker.main.test.RecipeMakerMainTest;
import com.recipemaker.utils.test.CSVUtilTest;
import com.recipemaker.utils.test.DateUtilTest;
import com.recipemaker.utils.test.JSONUtilTest;
@RunWith(Suite.class)
@SuiteClasses({ JSONUtilTest.class, CSVUtilTest.class, DateUtilTest.class, RecipeMakerMainTest.class })
public class ReciperMakerUnitTestSuite {


}
