package UnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.Inventory;
import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class InventoryTest {
	
	Inventory inventory;
	Inventory inventory2;
	static Recipe recipe;
	static Recipe recipe2;
	
	@Before
	public void setUp1() {
		inventory = new Inventory();
		inventory2 = new Inventory();
		
		inventory2.setChocolate(10);
		inventory2.setCoffee(10);
		inventory2.setMilk(10);
		inventory2.setSugar(10);
	}
	
	@BeforeClass
	public static void setUp2() throws RecipeException {
		recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("2");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setPrice("50");
		
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("5");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("0");
		recipe2.setPrice("75");
	}
		
	@Test
	public void testStaticFieldChocolate() {
		assertFalse(inventory.getChocolate() == (inventory2.getChocolate()));
	}
	
	@Test
	public void testStaticFieldCoffee() {
		assertFalse(inventory.getCoffee() == (inventory2.getCoffee()));
	}
	
	@Test
	public void testStaticFieldMilk() {
		assertFalse(inventory.getMilk() == (inventory2.getMilk()));
	}
	
	@Test
	public void testStaticFieldSugar() {
		assertFalse(inventory.getSugar() == (inventory2.getSugar()));
	}
	
	@Test
	public void testInventoryCoffee() {
		assertEquals(inventory.getCoffee(), 15);
	}
	
	@Test
	public void testInventoryMilk() {
		assertEquals(inventory.getMilk(), 15);
	}
	
	@Test
	public void testInventorySugar() {
		assertEquals(inventory.getSugar(), 15);
	}
	
	@Test
	public void testInventoryChocolate() {
		assertEquals(inventory.getChocolate(), 15);
	}
	
	@Test
	public void setChocolateTest1() {
		inventory.setChocolate(5);
		assertEquals(inventory.getChocolate(), 5);
	}
	
	@Test
	public void setChocolateTest2() {
		inventory.setChocolate(0);
		assertEquals(inventory.getChocolate(), 0);
	}
	
	@Test
	public void setChocolateTest3() {
		inventory.setChocolate(-2);
		assertEquals(inventory.getChocolate(), 15);
	}
	
	@Test
	public void setCoffeeTest1() {
		inventory.setCoffee(5);
		assertEquals(inventory.getCoffee(), 5);
	}
	
	@Test
	public void setCoffeeTest2() {
		inventory.setCoffee(0);
		assertEquals(inventory.getCoffee(), 0);
	}
	
	@Test
	public void setCoffeeTest3() {
		inventory.setCoffee(-2);
		assertEquals(inventory.getCoffee(), 15);
	}
	
	@Test
	public void setMilkTest1() {
		inventory.setMilk(5);
		assertEquals(inventory.getMilk(), 5);
	}
	
	@Test
	public void setMilkTest2() {
		inventory.setMilk(0);
		assertEquals(inventory.getMilk(), 0);
	}
	
	@Test
	public void setMilkTest3() {
		inventory.setMilk(-2);
		assertEquals(inventory.getMilk(), 15);
	}
	
	@Test
	public void setSugarTest1() {
		inventory.setSugar(5);
		assertEquals(inventory.getSugar(), 5);
	}
	
	@Test
	public void setSugarTest2() {
		inventory.setSugar(0);
		assertEquals(inventory.getSugar(), 0);
	}
	
	@Test
	public void setSugarTest3() {
		inventory.setSugar(-2);
		assertEquals(inventory.getSugar(), 15);
	}
	
	@Test
	public void addChocolateTest1() throws InventoryException {
		inventory.setChocolate(3);
		inventory.addChocolate("5");
		assertEquals(inventory.getChocolate(), 8);
	}
	
	@Test
	public void addChocolateTest2() throws InventoryException {
		inventory.setChocolate(3);
		inventory.addChocolate("0");
		assertEquals(inventory.getChocolate(), 3);
	}
	
	@Test(expected = InventoryException.class)
	public void addChocolateTest3() throws InventoryException{
		inventory.addChocolate("-1");
	}
	
	@Test(expected = InventoryException.class)
	public void addChocolateTest4() throws InventoryException{
		inventory.addChocolate("ab");
	}
	
	@Test
	public void addCoffeeTest1() throws InventoryException {
		inventory.setCoffee(3);
		inventory.addCoffee("5");
		assertEquals(inventory.getCoffee(), 8);
	}
	
	@Test
	public void addCoffeeTest2() throws InventoryException {
		inventory.setCoffee(3);
		inventory.addCoffee("0");
		assertEquals(inventory.getCoffee(), 3);
	}
	
	@Test(expected = InventoryException.class)
	public void addCoffeeTest3() throws InventoryException {
		inventory.setCoffee(3);
		inventory.addCoffee("-1");
	}
	
	@Test(expected = InventoryException.class)
	public void addCoffeeTest4() throws InventoryException {
		inventory.addCoffee("ab");
	}
	
	
	@Test
	public void addMilkTest1() throws InventoryException {
		inventory.setMilk(3);
		inventory.addMilk("5");
		assertEquals(inventory.getMilk(), 8);
	}
	
	@Test
	public void addMilkTest2() throws InventoryException {
		inventory.setMilk(3);
		inventory.addMilk("0");
		assertEquals(inventory.getMilk(), 3);
	}
	
	@Test(expected = InventoryException.class)
	public void addMilkTest3() throws InventoryException {
		inventory.setMilk(3);
		inventory.addMilk("-1");
	}
	
	@Test(expected = InventoryException.class)
	public void addMilkTest4() throws InventoryException {
		inventory.addMilk("ab");
	}
	
	@Test
	public void addSugarTest1() throws InventoryException {
		inventory.setSugar(3);
		inventory.addSugar("5");
		assertEquals(inventory.getSugar(), 8);
	}
	
	@Test
	public void addSugarTest2() throws InventoryException {
		inventory.setSugar(3);
		inventory.addSugar("0");
		assertEquals(inventory.getSugar(), 3);
	}
	
	@Test(expected = InventoryException.class)
	public void addSugarTest3() throws InventoryException {
		inventory.setSugar(3);
		inventory.addSugar("-1");
	}
	
	@Test(expected = InventoryException.class)
	public void addSugarTest4() throws InventoryException {
		inventory.addSugar("ab");
	}
	
	@Test
	public void useIngredientsCoffeeTest1() {
		assertTrue(inventory.useIngredients(recipe));
		assertEquals(inventory.getCoffee(), 12);
	}
	
	@Test
	public void useIngredientsMilkTest1() {
		assertTrue(inventory.useIngredients(recipe));
		assertEquals(inventory.getMilk(), 14);
	}
	@Test
	public void useIngredientsSugarTest1() {
		assertTrue(inventory.useIngredients(recipe));
		assertEquals(inventory.getSugar(), 14);
	}
	
	@Test
	public void useIngredientsChocolateTest1()  {
		assertTrue(inventory.useIngredients(recipe));
		assertEquals(inventory.getChocolate(), 13);
	}
	
	@Test
	public void useIngredientsCoffeeTest2() throws RecipeException {
		recipe2.setAmtCoffee("50");
		assertFalse(inventory.useIngredients(recipe2));
	}
	
	@Test
	public void useIngredientsMilkTest2() throws RecipeException {
		recipe2.setAmtMilk("50");
		assertFalse(inventory.useIngredients(recipe2));
	}
	
	@Test
	public void useIngredientsSugarTest2() throws RecipeException {
		recipe2.setAmtSugar("50");
		assertFalse(inventory.useIngredients(recipe2));
	}
	
	@Test
	public void useIngredientsChocolateTest2() throws RecipeException {
		recipe2.setAmtChocolate("50");
		assertFalse(inventory.useIngredients(recipe2));
	}
			
}
