package com.app.factory;

import com.app.model.Menu;
import com.app.persistence.DbConnection;
import com.app.persistence.MenuDAO;

import java.util.List;
import java.io.FileInputStream;
/**
 * MenuFactory class used to fetch menu data from database.
 */
public class MenuFactory {
  /**
   *  Protected constructor.
   */
  protected MenuFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
  /**
   * to list all Menu.
   * @return array
   */
  public static Menu[] showMenu() {
    List<Menu> list = dao().showMenu();
    return list.toArray(new Menu[list.size()]);
  }
  /**
   * to find the last row.
   * @return Menu object
   */
  public static Menu findLastRow() {
    Menu m = dao().findLastRow();
    return m;
  }
  /**
   * to show Product details.
   * @param pid for Product id
   * @return Menu
   */
  public static Menu showProduct(final int pid) {
    Menu pd = dao().showProduct(pid);
    return pd;
  }
  /**
   * to list Menu by Vendor.
   * @param vid for Vendor id
   * @return array
   */
  public static Menu[] listByVendor(final int vid) {
    List<Menu> list = dao().listByVendor(vid);
    return list.toArray(new Menu[list.size()]);
  }
  /**
   * to list Menu by Category.
   * @param argProductCategory for Category id.
   * @return array
   */
  public static Menu[] listByCategory(final int argProductCategory) {
    List<Menu> list = dao().listByCategory(argProductCategory);
    return list.toArray(new Menu[list.size()]);
  }

  /**
   * to Add a new product.
   * @param argPid for ProductId
   * @param argVid for VendorId
   * @param argProductName for ProductName
   * @param argProductQuantity for ProductQuantity
   * @param argProductPrice for ProductPrice
   * @param argProductCategory for ProductCategory
   * @return int
   */
  public static int addProductDetails(final int argPid, final int argVid, final String argProductName,
      final int argProductQuantity, final double argProductPrice, final int argProductCategory) {
    int val = dao().addProductDetails(argPid, argVid, argProductName, argProductQuantity, argProductPrice, argProductCategory);
    return val;
  }
  /**
   * @param argPid for ProductId
   * @param argPimg for ProductImage
   * @return int
   */
  public static int addProductImage(final int argPid, final FileInputStream argPimg) {
    int val = dao().addProductImage(argPid, argPimg);
    return val;
  }
  /**
   * to Update Product Price.
   * @param argPid for ProductId
   * @param argVid for VendorId
   * @param argProductPrice for ProductPrice
   * @return int
   */
  public static int updateProductPrice(final int argPid, final int argVid, final double argProductPrice) {
    int val = dao().updateProductPrice(argPid, argVid, argProductPrice);
    return val;
  }
  /**
   * to Update Product Price.
   * @param argPid for ProductId
   * @param argVid for VendorId
   * @param argProductRating for ProductRating
   * @return int
   */
  public static int updateProductRating(final int argPid, final int argVid, final double argProductRating) {
    int val = dao().updateProductRating(argPid, argVid, argProductRating);
    return val;
  }
  /**
   * to Update Product Price.
   * @param argPid for ProductId
   * @param argVid for VendorId
   * @param argProductQuantity for ProductQuantity
   * @return int
   */
  public static int updateProductQuantity(final int argPid, final int argVid, final double argProductQuantity) {
    int val = dao().updateProductQuantity(argPid, argVid, argProductQuantity);
    return val;
  }
  /**
   * to retrieve the Product Rating by product id.
   * @param pId for order id.
   * @return int
   */
  public static double retrieveProductRating(final int pId) {
    double proRat = dao().retrieveProductRating(pId);
    return proRat;
  }

}
