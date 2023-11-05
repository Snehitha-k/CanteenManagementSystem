package com.app.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.io.FileNotFoundException;

import com.app.factory.MenuFactory;
import com.app.model.Menu;
import com.app.persistence.MenuDAO;

import org.junit.Test;
//import java.io.FileInputStream;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
/**
 * test suite for Menu.
 */
@RunWith(JMockit.class)
public class MenuTest {
  /**
   * test case for default constructor.
   */
  @Test
  public final void testMenu() {
    Menu m = new Menu();
    m.setProductId(101);
    m.setVendorId(201);
    m.setProductName("Pizza");
    m.setProductQuantity(100);
    m.setProductPrice(200.0);
    m.setProductRating(4.5);
    m.setProductCategory(2);
    assertEquals(101, m.getProductid());
    assertEquals(201, m.getVendorId());
    assertEquals("Pizza", m.getProductName());
    assertEquals(100, m.getProductQuantity());
    assertEquals(200.0, m.getProductPrice(), 1);
    assertEquals(4.5, m.getProductRating(), 1);
    assertEquals(2, m.getProductCategory());
  }
  /**
   * testing parameterized constructor.
   */
  @Test
  public final void testMenuParameterizedConstructor() {
    Menu m = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 2);
    assertEquals(103, m.getProductid());
    assertEquals(201, m.getVendorId());
    assertEquals("Pizza", m.getProductName());
    assertEquals(100, m.getProductQuantity());
    assertEquals(200.0, m.getProductPrice(), 1);
    assertEquals(4.5, m.getProductRating(), 1);
    assertEquals(2, m.getProductCategory());
  }
  /**
   * test for getProductId.
   */
  @Test
  public final void testGetProductId() {
    Menu m = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 2);
    assertEquals(103, m.getProductid());
  }

  /**
   * test for getVendorId.
   */
  @Test
  public final void testGetVendorId() {
    Menu m = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 2);
    assertEquals(201, m.getVendorId());
  }

  /**
   * test for getProductName.
   */
  @Test
  public final void testGetProductName() {
    Menu m = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 2);
    assertEquals("Pizza", m.getProductName());
  }

  /**
   * test for getProductQuantity.
   */
  @Test
  public final void testGetProductQuantity() {
    Menu m = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 2);
    assertEquals(100, m.getProductQuantity());
  }
   /**
   * test for getProductPrice.
   */
  @Test
  public final void testGetProductPrice() {
    Menu m = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 2);
    assertEquals(200.0, m.getProductPrice(), 1);
  }

  /**
   * test for getProductRating.
   */
  @Test
  public final void testGetProductRating() {
    Menu m = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 2);
    assertEquals(4.5, m.getProductRating(), 1);
  }
  /**
   * test for getProductCategory.
   */
  @Test
  public final void testGetProductCategory() {
    Menu m = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 2);
    assertEquals(2, m.getProductCategory());
  }
  /**
   * test for hashCode method.
  */
  @Test
  public final void testHashCode() {
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 2);
    Menu m2 = new Menu(104, 202, "Burger", 100, 100.0, 4.0, 1);
    Menu m3 = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 2);
    assertEquals(m1.hashCode(), m3.hashCode());
    assertNotEquals(m1.hashCode(), m2.hashCode());
    assertNotEquals(m3.hashCode(), m2.hashCode());
  }
  /**
   * test for equals method.
   */
  @Test
  public final void testEquals() {
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200, 4.5, 2);
    Menu m2 = new Menu(104, 201, "Burger", 100, 100, 4.0, 1);
    Menu m3 = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 2);
    assertTrue(m1.equals(m3));
    assertFalse(m2.equals(m1));
    assertFalse(m2.equals(m3));
    Menu m = null;
    assertFalse(m1.equals(m));
  }
  /**
   * test for setProductId.
   */
  @Test
  public final void testSetProductId() {
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200, 4.5, 2);
    m1.setProductId(104);
    assertEquals(104, m1.getProductid());
  }

  /**
   * test for setVendorId.
   */
  @Test
  public final void testSetVendorId() {
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200, 4.5, 2);
    m1.setVendorId(202);
    assertEquals(202, m1.getVendorId());
  }
  /**
   * test for setProductName.
   */
  @Test
  public final void testSetProductName() {
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200, 4.5, 2);
    m1.setProductName("Burger");
    assertEquals("Burger", m1.getProductName());
  }

  /**
   * test for setProductQuantity.
   */
  @Test
  public final void testSetProductQuantity() {
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200, 4.5, 2);
    m1.setProductQuantity(200);
    assertEquals(200, m1.getProductQuantity());
  }

  /**
   * test for setProductPrice.
   */
  @Test
  public final void testSetProductPrice() {
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200, 4.5, 2);
    m1.setProductPrice(300);
    assertEquals(300, m1.getProductPrice(), 1);
  }
  /**
   * test for setProductRating.
   */
  @Test
  public final void testSetProductRating() {
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200, 4.5, 2);
    m1.setProductRating(3.5);
    assertEquals(3.5, m1.getProductRating(), 1);
  }
  /**
   * test for setProductCategory.
   */
  @Test
  public final void testSetProductCategory() {
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200, 4.5, 2);
    m1.setProductCategory(1);
    assertEquals(1, m1.getProductCategory());
  }
  /**
   * test for addNewProduct.
   * @param dao for MenuDAO
   * @throws FileNotFoundException for exception
   */
  @Test
  public final void testAddProductDetails(@Mocked final MenuDAO dao) throws FileNotFoundException {
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200, 4.5, 2);
    new Expectations() {
      {
        dao.findLastRow();
        result = m1;
      }
    };
    new Expectations() {
      {
        dao.addProductDetails(104, 202, "Burger", 100, 200, 2);
        result = 1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu a = new Menu();
    String str = a.addProductDetails(202, "Burger", 100, 200, 2);
    assertEquals("Product Added Successfully! Please login to continue", str);
  }
  /**
   * test method to update ratings.
   * @param mDao menu Dao
   */
  @Test
  public final void testUpdateRatings(@Mocked final MenuDAO mDao) {
    Menu m = new Menu(103, 201, "Pizza", 100, 200, 4.5, 2);
    new Expectations() {
      {
        mDao.updateProductRating(103, 201, 4.7);
        result = 1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return mDao;
      }
    };
    String msg = m.updateProductRating(103, 201, 4.7);
    assertEquals("Rating Updated successfully", msg);
  }
    /**
   * test method to update Price.
   * @param mDao menu Dao
   */
  @Test
  public final void testUpdatePrice(@Mocked final MenuDAO mDao) {
    Menu m = new Menu(103, 201, "Pizza", 100, 200, 4.5, 2);
    new Expectations() {
      {
        mDao.updateProductPrice(103, 201, 240);
        result = 1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return mDao;
      }
    };
    String msg = m.updateProductPrice(103, 201, 240);
    assertEquals("Price updated successfully", msg);
  }
    /**
   * test method to update quantity.
   * @param mDao menu Dao
   */
  @Test
  public final void testUpdateQuantity(@Mocked final MenuDAO mDao) {
    Menu m = new Menu(103, 201, "Pizza", 100, 200, 4.5, 2);
    new Expectations() {
      {
        mDao.updateProductQuantity(103, 201, 40);
        result = 1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return mDao;
      }
    };
    String msg = m.updateProductQuantity(103, 201, 40);
    assertEquals("Quantity updated successfully", msg);
  }
}
