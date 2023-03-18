/*
 * Copyright (c) 2009,  Sarah Heckman, Laurie Williams, Dright Ho
 * All Rights Reserved.
 *
 * Permission has been explicitly granted to the University of Minnesota
 * Software Engineering Center to use and distribute this source for
 * educational purposes, including delivering online education through
 * Coursera or other entities.
 *
 * No warranty is given regarding this software, including warranties as
 * to the correctness or completeness of this software, including
 * fitness for purpose.
 *
 * Modifications
 * 20171113 - Michael W. Whalen - Extended with additional recipe.
 * 20171114 - Ian J. De Silva   - Updated to JUnit 4; fixed variable names.
 */
package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


/**
 * Unit tests for CoffeeMaker class.
 *
 * @author Sarah Heckman
 *
 * Extended by Mike Whalen
 */

public class CoffeeMakerTest {

	//-----------------------------------------------------------------------
	//	DATA MEMBERS
	//-----------------------------------------------------------------------
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;
	private Recipe recipe5;

	private Recipe [] stubRecipies;

	/**
	 * The coffee maker -- our object under test.
	 */
	private CoffeeMaker coffeeMaker;

	/**
	 * The stubbed recipe book.
	 */
	private RecipeBookInterface recipeBookStub;


	//-----------------------------------------------------------------------
	//	Set-up / Tear-down
	//-----------------------------------------------------------------------
	/**
	 * Initializes some recipes to test with, creates the {@link CoffeeMaker}
	 * object we wish to test, and stubs the {@link RecipeBook}.
	 *
	 * @throws RecipeException  if there was an error parsing the ingredient
	 * 		amount when setting up the recipe.
	 */
	@Before
	public void setUp() throws RecipeException {

		recipeBookStub = mock(RecipeBookInterface.class);
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());

		//Set up for recipe1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");

		//Set up for recipe2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");

		//Set up for recipe3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");

		//Set up for recipe4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");

		//Set up for recipe5 (added by MWW)
		recipe5 = new Recipe();
		recipe5.setName("Super Hot Chocolate");
		recipe5.setAmtChocolate("6");
		recipe5.setAmtCoffee("0");
		recipe5.setAmtMilk("1");
		recipe5.setAmtSugar("1");
		recipe5.setPrice("100");

		stubRecipies = new Recipe [] {recipe1, recipe2, recipe3};
	}


	//-----------------------------------------------------------------------
	//	Test Methods
	//-----------------------------------------------------------------------

	// put your tests here!

	@Test
	public void testMakeCoffee() {
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		assertTrue(true);
	}

	//	Действия:
//	Пользователь покупает напиток 1, вставляет 100 рублей.
//	Проверяем:
//	Напиток должен быть приготовлен, сдача 50 рублей.
//	Общее описание:
//	Проверяем штатное исполнение процедуры, без ошибок.
	@Test
	public void testPurchaseBeverage1() {
		when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		assertEquals(50, coffeeMaker.makeCoffee(0,100));
	}

	//	Действия:
//	Пользователь покупает напиток 2, вставляет 100 рублей.
//	Проверяем:
//	Напиток не может быть приготовлен (нет шоколада), сдача 100 рублей.
//	Общее описание:
//	Поверяем отказ от выполнения напитка из-за отсутствия ингридиента
	@Test
	public void testPurchaseBeverage2() {
		when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		assertEquals(100, coffeeMaker.makeCoffee(1,100));
	}

	//	Действия:
//	Пользователь покупает напиток 1, вставляет 100 рублей.
//	Проверяем:
//	Напиток должен быть приготовлен, сдача 50 рублей.
//	Вызов методов рецепта 1 происходит один раз, других методов - ниодного.
//	Общее описание:
//	Проверяем штатное исполнение процедуры, без ошибок.
//	Проверяем сколько раз были вызваны методы.
	@Test
	public void testPurchaseBeverage3() {
		Recipe recipe1Spy = spy(recipe1);
		Recipe recipe2Spy = spy(recipe2);
		Recipe recipe3Spy = spy(recipe3);

		when(recipeBookStub.getRecipes()).thenReturn(new Recipe[] {recipe1Spy, recipe2Spy, recipe3Spy});
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		assertEquals(50, coffeeMaker.makeCoffee(0,100));

		verify(recipe1Spy, times(2)).getAmtCoffee();
		verify(recipe1Spy, times(2)).getAmtChocolate();
		verify(recipe1Spy, times(2)).getAmtMilk();
		verify(recipe1Spy, times(2)).getAmtSugar();
		verify(recipe1Spy, times(2)).getPrice();

		verify(recipe2Spy, never()).getAmtCoffee();
		verify(recipe2Spy, never()).getAmtChocolate();
		verify(recipe2Spy, never()).getAmtMilk();
		verify(recipe2Spy, never()).getAmtSugar();
		verify(recipe2Spy, never()).getPrice();

		verify(recipe3Spy, never()).getAmtCoffee();
		verify(recipe3Spy, never()).getAmtChocolate();
		verify(recipe3Spy, never()).getAmtMilk();
		verify(recipe3Spy, never()).getAmtSugar();
		verify(recipe3Spy, never()).getPrice();
	}

	//	Действия:
//	Пользователь покупает напиток 3, вставляет 50 рублей.
//	Проверяем:
//	Напиток не может быть приготовлен (недостаточно денег), сдача 50 рублей.
//	Общее описание:
//	Проверяем отказ от выполнения напитка - недостаточно денег
	@Test
	public void testPurchaseBeverage4() {
		when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		assertEquals(50, coffeeMaker.makeCoffee(2,50));
	}

	//	Действия:
//	Пользователь покупает напиток 7, вставляет 100 рублей.
//	Проверяем:
//	Напиток не может быть приготовлен (нет такого рецепта), сдача 100 рублей.
//	Общее описание:
//	Проверяем отказ от выполнения из-за несуществуюего рецепта
	@Test
	public void testPurchaseBeverage5() {
		when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		assertEquals(100, coffeeMaker.makeCoffee(7,100));
	}

	//	Действия:
//	Пользователь покупает напиток под индексом 2, вставляет 100 рублей.
//	Проверяем:
//	Напиток не может быть приготовлен (нет такого рецепта, всего пока создано 2), сдача 100 рублей.
//	Общее описание:
//	Проверяем отказ от выполнения из-за несуществуюего рецепта
	@Test
	public void testPurchaseBeverage6() {
		when(recipeBookStub.getRecipes()).thenReturn(new Recipe[] {recipe1, recipe2, null});
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		assertEquals(100, coffeeMaker.makeCoffee(2,100));
	}

	//	Действия:
//	Пользователь покупает напиток 3, вставляет 100 рублей.
//	Проверяем:
//	Метод useIngredients.
//	Общее описание:
//	Проверяем, что useIngredients был вызван именно на рецепте 1
	@Test
	public void testPurchaseBeverage7() {
		Inventory inventorySpy = spy(new Inventory());
		when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);
		coffeeMaker = new CoffeeMaker(recipeBookStub, inventorySpy);
		coffeeMaker.makeCoffee(0,50);
		verify(inventorySpy).useIngredients(recipe1);
	}

	//	Действия:
//	Пользователь покупает напиток 1, вставляет 100 рублей.
//	Проверяем:
//	Достаточно ли ингридиентов для приготовления напитка 1
//	Общее описание:
//	Проверяем, что enoughIngredients был вызван именно на рецепте 1
	@Test
	public void testPurchaseBeverage8() {
		Inventory inventorySpy = spy(new Inventory());
		when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);
		coffeeMaker = new CoffeeMaker(recipeBookStub, inventorySpy);
		coffeeMaker.makeCoffee(0,50);
		verify(inventorySpy).enoughIngredients(recipe1);
	}

	//	Действия:
//	Пользователь покупает напиток 3, вставляет 100 рублей.
//	Проверяем:
//	Подсчет ингридиентов после приготовления напитка 3.
//	Общее описание:
//	Проверяем штатное исполнение процедуры, без ошибок.
	@Test
	public void testPurchaseBeverage9() {
		Inventory inventory = new Inventory();
		when(recipeBookStub.getRecipes()).thenReturn(new Recipe[]{recipe1, recipe2, recipe3});
		coffeeMaker = new CoffeeMaker(recipeBookStub, inventory);
		coffeeMaker.makeCoffee(2,100);

		assertEquals(15 - recipe3.getAmtSugar(), inventory.getSugar());
		assertEquals(15 - recipe3.getAmtCoffee(), inventory.getCoffee());
		assertEquals(15 - recipe3.getAmtMilk(), inventory.getMilk());
		assertEquals(15 - recipe3.getAmtChocolate(), inventory.getChocolate());
	}


}
