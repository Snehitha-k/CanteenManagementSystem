package com.app.persistence;

import java.io.FileInputStream;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.app.model.Menu;
/**
 * MenuDAO class used to fetch data from data base.
*/
public interface MenuDAO {
  /**
   * list of all Menu.
   * @return list
   */
  @SqlQuery("SELECT * FROM MENU")
  @Mapper(MenuMapper.class)
  List<Menu> showMenu();
  /**
   * show details for an product id.
   * @param pid for Product id
   * @return menu
   */
  @SqlQuery("SELECT * FROM MENU WHERE PID = :pid")
  @Mapper(MenuMapper.class)
  Menu showProduct(@Bind("pid") final int pid);
  /**
   * list all products based on vendor id.
   * @param vid for Vendor id
   * @return list
   */
  @SqlQuery("SELECT * FROM MENU WHERE VID = :vid")
  @Mapper(MenuMapper.class)
  List<Menu> listByVendor(@Bind("vid") final int vid);
/**
   * list all products based on Category id.
   * @param pCategory for Vendor id
   * @return list
   */
  @SqlQuery("SELECT * FROM MENU WHERE PCATEGORY = :pCategory")
  @Mapper(MenuMapper.class)
  List<Menu> listByCategory(@Bind("pCategory") final int pCategory);
  /**
   * Add a new Product.
   * @param pid Productid
   * @param vid Vendorid
   * @param pName ProductName
   * @param pQuantity ProductQuantity
   * @param pPrice ProductPrice
   * @param pCategory ProductCategory
   * @return int
   */
  @SqlUpdate("INSERT INTO MENU(PID, VID, PNAME, PQUANTITY, PPRICE, PCATEGORY)"
      + "VALUES (:pid, :vid, :pName, :pQuantity, :pPrice, :pCategory)")
  int addProductDetails(@Bind("pid") final int pid, @Bind("vid") final int vid,
      @Bind("pName") final String pName, @Bind("pQuantity") final int pQuantity,
      @Bind("pPrice") final double pPrice, @Bind("pCategory") final int pCategory);
  /**
   * @param pid productId
   * @param pImage productimage
   * @return int
   */
  @SqlUpdate("UPDATE MENU SET PIMAGE = :pImage WHERE PID = :pid")
  int addProductImage(@Bind("pid") final int pid,  @Bind("pImage") final FileInputStream pImage);
  /**
   * Update a Product Price.
   * @param argProductId Productid
   * @param argVendorId Vendorid
   * @param argProductPrice ProductPrice
   * @return int
   */
  @SqlUpdate("UPDATE MENU SET PPRICE = :pPrice WHERE PID = :pid and VID = :vid")
  int updateProductPrice(@Bind("pid") final int argProductId, @Bind("vid") final int argVendorId,
      @Bind("pPrice") final double argProductPrice);
  /**
   * Update a Product Rating.
   * @param argProductId Productid
   * @param argVendorId Vendorid
   * @param argProductRating ProductRating
   * @return int
   */

  @SqlUpdate("UPDATE MENU SET PRATING = :pRating WHERE PID = :pid and VID = :vid")
  int updateProductRating(@Bind("pid") final int argProductId, @Bind("vid") final int argVendorId,
      @Bind("pRating") final double argProductRating);
/**
   * Update a Product Quantity.
   * @param argProductId Productid
   * @param argVendorId Vendorid
   * @param argProductQuantity ProductQuantity
   * @return int
   */
  @SqlUpdate("UPDATE MENU SET PQUANTITY = :pQUantity WHERE PID = :pid and VID = :vid")
  int updateProductQuantity(@Bind("pid") final int argProductId, @Bind("vid") final int argVendorId,
      @Bind("pQuantity") final double argProductQuantity);

  /**
   * to find the last Product id.
   * @return Product object
   */
  @SqlQuery("SELECT * FROM MENU WHERE PID = (SELECT MAX(PID) FROM MENU)")
  @Mapper(MenuMapper.class)
  Menu findLastRow();
  /**
   * to get the Product Rating.
   * @param pId for Product id
   * @return product rating
   */
  @SqlQuery("SELECT PRATING FROM MENU WHERE PID = :pId")
  double retrieveProductRating(@Bind("pId") final int pId);
}
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware

public interface MenuDAO {
    /**
     * @return the all the Menu record.

  @SqlQuery("Select * from Menu")
    @Mapper(MenuMapper.class)
    List<Menu> show();
}

*/
