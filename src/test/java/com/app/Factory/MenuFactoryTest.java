package com.app.Factory;

import com.app.model.Menu;
import com.app.persistence.MenuDAO;

import java.io.FileInputStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * test suite for MenuFactory.
 */
@RunWith(JMockit.class)
public class MenuFactoryTest {
  /**
   * test for getMenuDetailsByProductId.
   * @param mDao for MenuDAO
   */
  @Test
  public final void testGetProductById(@Mocked final MenuDAO mDao) {
    final Menu m = new Menu(103, 201, "Pizza", 100, 200, 4.5, 2);
    new Expectations() {
      {
        mDao.showProduct(103);
        result = m;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return mDao;
      }
    };
    Menu m1 = MenuFactory.showProduct(103);
    assertEquals(m, m1);
  }
   /**
   * test for addProductDetails.
   * @param mDao for MenusDAO
   * @throws FileNotFoundException for exception
   */
  @Test
  public final void testAddProductDetails(@Mocked final MenuDAO mDao) throws FileNotFoundException {
    new Expectations() {
      {
        mDao.addProductDetails(103, 201, "Pizza", 100, 200, 2);
        result = 1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return mDao;
      }
    };
    int res = MenuFactory.addProductDetails(103, 201, "Pizza", 100, 200, 2);
    assertEquals(1, res);
  }
  /**
   * test for getProductRatingByProductId.
   * @param mDao for MenuDAO
   * @throws FileNotFoundException for exception
   */
  @Test
  public final void testGetRatingById(@Mocked final MenuDAO mDao) throws FileNotFoundException {
    mDao.addProductDetails(103, 201, "Pizza", 100, 200, 2);
    double m1 = 0;
    new Expectations() {
      {
        mDao.retrieveProductRating(103);
        result = 1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return mDao;
      }
    };
    m1 = MenuFactory.retrieveProductRating(103);
    int k = 0;
    if (m1 > 0) {
      k = 1;
    }
    assertEquals(1, k);
  }
  /**
   * test for update Quantity.
   * @param mDao for MenuDAO
   * @throws FileNotFoundException for exception
   */
  @Test
  public final void testUpdateQuantity(@Mocked final MenuDAO mDao) throws FileNotFoundException {
    mDao.addProductDetails(103, 201, "Pizza", 100, 200, 2);
    new Expectations() {
      {
        mDao.updateProductQuantity(103, 201, 30);
        result = 1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return mDao;
      }
    };
    int k = MenuFactory.updateProductQuantity(103, 201, 30);
    assertEquals(1, k);
  }
  /**
   * test for update Quantity.
   * @param mDao for MenuDAO
   * @throws FileNotFoundException for exception
   */
  @Test
  public final void testAddImage(@Mocked final MenuDAO mDao) throws FileNotFoundException {
    mDao.addProductDetails(103, 201, "Pizza", 100, 200, 2);
    String str = "C:/Users/55664/workspace/MLP351/restservice/canteenmanagement/src/images/Briyani.jpg";
    FileInputStream photo = new FileInputStream(str);
    new Expectations() {
      {
        mDao.addProductImage(103, photo);
        result = 1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return mDao;
      }
    };
    int k = MenuFactory.addProductImage(103, photo);
    assertEquals(1, k);
  }
  /**
   * test for update Price.
   * @param mDao for MenuDAO
   * @throws FileNotFoundException for exception
   */
  @Test
  public final void testUpdatePrice(@Mocked final MenuDAO mDao) throws FileNotFoundException {
    mDao.addProductDetails(103, 201, "Pizza", 100, 200, 2);
    new Expectations() {
      {
        mDao.updateProductPrice(103, 201, 300);
        result = 1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return mDao;
      }
    };
    int k = MenuFactory.updateProductPrice(103, 201, 300);
    assertEquals(1, k);
  }
  /**
   * test for update Rating.
   * @param mDao for MenuDAO
   * @throws FileNotFoundException for exception
   */
  @Test
  public final void testUpdateRating(@Mocked final MenuDAO mDao) throws FileNotFoundException {
    mDao.addProductDetails(103, 201, "Pizza", 100, 200, 2);
    new Expectations() {
      {
        mDao.updateProductRating(103, 201, 4.2);
        result = 1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return mDao;
      }
    };
    int k = MenuFactory.updateProductRating(103, 201, 4.2);
    assertEquals(1, k);
  }
   /**
   * test method to display menu by category.
   * @param dao menu dao.
   */
  @Test
  public final void testListByCategory(@Mocked final MenuDAO dao) {
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 1);
    Menu m2 = new Menu(104, 202, "Burger", 100, 100.0, 4.0, 1);
    ArrayList<Menu> menu = new ArrayList<Menu>();
    new Expectations() {
      {
        menu.add(m1);
        menu.add(m2);
        dao.listByCategory(1);
        result = menu;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] menu1 = MenuFactory.listByCategory(1);
    assertEquals(2, menu1.length);
  }
  /**
   * test method to display menu by vendor.
   * @param dao menu dao.
   */
  @Test
  public final void testListByVendor(@Mocked final MenuDAO dao) {
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 1);
    Menu m2 = new Menu(104, 202, "Burger", 100, 100.0, 4.0, 1);
    ArrayList<Menu> menu = new ArrayList<Menu>();
    new Expectations() {
      {
        menu.add(m1);
        menu.add(m2);
        dao.listByCategory(201);
        result = menu;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] menu1 = MenuFactory.listByCategory(201);
    assertEquals(2, menu1.length);
  }
  /**
   * test method to display menu.
   * @param dao menu dao.
   */
  @Test
  public final void testshowMenu(@Mocked final MenuDAO dao) {
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 1);
    Menu m2 = new Menu(104, 202, "Burger", 100, 100.0, 4.0, 1);
    ArrayList<Menu> menu = new ArrayList<Menu>();
    new Expectations() {
      {
        menu.add(m1);
        menu.add(m2);
        dao.showMenu();
        result = menu;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] menu1 = MenuFactory.showMenu();
    assertEquals(2, menu1.length);
  }
  /**
   * test method to display menu last row.
   * @param dao menu dao.
   */
  @Test
  public final void testCheckLastRow(@Mocked final MenuDAO dao) {
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 1);
    Menu m2 = new Menu(104, 202, "Burger", 100, 100.0, 4.0, 1);
    new Expectations() {
      {
        dao.findLastRow();
        result = m1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu menu1 = MenuFactory.findLastRow();
    assertEquals(m1, menu1);
    assertNotEquals(m2, menu1);
  }
}
