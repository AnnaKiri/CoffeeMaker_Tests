package UnitTests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class RecipeTest {
	
	static Recipe recipe;
	static Recipe recipe3;
	static Recipe recipe4;
	
	@Before
	public void setUp() {
		recipe = new Recipe();
		
	}
	
	@BeforeClass
	public static void setUp2() throws RecipeException {
		recipe3 = new Recipe();
		recipe3.setName("Coffee");
		recipe3.setAmtChocolate("2");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("1");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("50");
		
		recipe4 = new Recipe();
		recipe4.setName("Mocha");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("5");
		recipe4.setAmtMilk("2");
		recipe4.setAmtSugar("0");
		recipe4.setPrice("75");
	}
	
	@Test
	public void testStaticFieldName() {
		assertFalse(recipe3.getName().equals(recipe4.getName()));
	}
	
	@Test
	public void testStaticFieldChocolate() {
		assertFalse(recipe3.getAmtChocolate() == (recipe4.getAmtChocolate()));
	}
	
	@Test
	public void testStaticFieldCoffee() {
		assertFalse(recipe3.getAmtCoffee() == (recipe4.getAmtCoffee()));
	}
	
	@Test
	public void testStaticFieldMilk() {
		assertFalse(recipe3.getAmtMilk() == (recipe4.getAmtMilk()));
	}
	
	@Test
	public void testStaticFieldSugar() {
		assertFalse(recipe3.getAmtSugar() == (recipe4.getAmtSugar()));
	}
	
	@Test
	public void testStaticFieldPrice() {
		assertFalse(recipe3.getPrice() == (recipe4.getPrice()));
	}
	
	@Test
	public void setNameTest1() throws RecipeException {
		recipe3.setName("CoffeeTest");
		assertTrue(recipe3.getName().equals("CoffeeTest"));
	}
	
	@Test
	public void setNameTest2() throws RecipeException {
		recipe3.setName("Coffee");
		recipe3.setName(null);
		assertTrue(recipe3.getName().equals("Coffee"));
	}

	@Test
	public void testNewRecipeName() {
		assertTrue(recipe.getName().equals(""));
	}
	
	@Test
	public void testNewRecipePrice() {
		assertEquals(0, recipe.getPrice());
	}
	
	@Test
	public void testNewRecipeAmtCoffee() {
		assertEquals(0, recipe.getAmtCoffee());
	}
	
	@Test
	public void testNewRecipeAmtMilk() {
		assertEquals(0, recipe.getAmtMilk());
	}
	
	@Test
	public void testNewRecipeAamtSugar() {
		assertEquals(0, recipe.getAmtSugar());
	}
	
	@Test
	public void testNewRecipeAmtChocolate() {
		assertEquals(0, recipe.getAmtChocolate());
	}
	
	@Test
	public void setAmtChocolateTest1() throws RecipeException {
		recipe.setAmtChocolate("7");
		assertEquals(7, recipe.getAmtChocolate());
		recipe.setAmtChocolate("0");
		assertEquals(0, recipe.getAmtChocolate());
	}
	
	@Test
	public void setAmtChocolateTest2() throws RecipeException {
		recipe.setAmtChocolate("5");
		assertEquals(5, recipe.getAmtChocolate());
	}
	
	@Test(expected = RecipeException.class)
	public void setAmtChocolateTest3() throws RecipeException {
		recipe.setAmtChocolate("-1");
	}
	
	@Test(expected = RecipeException.class)
	public void setAmtChocolateTest4() throws RecipeException {
		recipe.setAmtChocolate("ab");
	}
	
	@Test
	public void setAmtCoffeeTest1() throws RecipeException {
		recipe.setAmtCoffee("7");
		assertEquals(7, recipe.getAmtCoffee());
		recipe.setAmtCoffee("0");
		assertEquals(0, recipe.getAmtCoffee());
	}
	
	@Test
	public void setAmtCoffeeTest2() throws RecipeException {
		recipe.setAmtCoffee("5");
		assertEquals(5, recipe.getAmtCoffee());
	}
	
	@Test(expected = RecipeException.class)
	public void setAmtCoffeeTest3() throws RecipeException {
		recipe.setAmtCoffee("-1");
	}
	
	@Test(expected = RecipeException.class)
	public void setAmtCoffeeTest4() throws RecipeException {
		recipe.setAmtCoffee("ab");
	}
	
	@Test
	public void setAmtMilkTest1() throws RecipeException {
		recipe.setAmtMilk("7");
		assertEquals(7, recipe.getAmtMilk());
		recipe.setAmtMilk("0");
		assertEquals(0, recipe.getAmtMilk());
	}
	
	@Test
	public void setAmtMilkTest2() throws RecipeException {
		recipe.setAmtMilk("5");
		assertEquals(5, recipe.getAmtMilk());
	}
	
	@Test(expected = RecipeException.class)
	public void setAmtMilkTest3() throws RecipeException {
		recipe.setAmtMilk("-1");
	}
	
	@Test(expected = RecipeException.class)
	public void setAmtMilkTest4() throws RecipeException {
		recipe.setAmtMilk("ab");
	}
	
	@Test
	public void setAmtSugarTest1() throws RecipeException {
		recipe.setAmtSugar("7");
		assertEquals(7, recipe.getAmtSugar());
		recipe.setAmtSugar("0");
		assertEquals(0, recipe.getAmtSugar());
	}
	
	@Test
	public void setAmtSugarTest2() throws RecipeException {
		recipe.setAmtSugar("5");
		assertEquals(5, recipe.getAmtSugar());
	}
	
	@Test(expected = RecipeException.class)
	public void setAmtSugarTest3() throws RecipeException {
		recipe.setAmtSugar("-1");
	}
	
	@Test(expected = RecipeException.class)
	public void setAmtSugarTest4() throws RecipeException {
		recipe.setAmtSugar("ab");
	}
	
	@Test
	public void setPriceTest1() throws RecipeException {
		recipe.setPrice("25");
		assertEquals(25, recipe.getPrice());
		recipe.setPrice("0");
		assertEquals(0, recipe.getPrice());
	}
	
	@Test
	public void setPriceTest2() throws RecipeException {
		recipe.setPrice("5");
		assertEquals(5, recipe.getPrice());
	}
	
	@Test(expected = RecipeException.class)
	public void setPriceTest3() throws RecipeException {
		recipe.setPrice("-1");
	}
	
	@Test(expected = RecipeException.class)
	public void setPriceTest4() throws RecipeException {
		recipe.setPrice("ab");
	}
	

}
