package com.app.model;

import java.util.Objects;

import com.app.factory.MenuFactory;
/**
 * Menu class.
 */

public class Menu {
  /**
   * to store ProductId.
   */
  private int pid;
  /**
   * to store VendorId.
   */
  private int vid;
  /**
   * to store Productname.
   */
  private String name;
  /**
   * to store ProductQuantity.
   */
  private int pQuantity;
  /**
   * to store ProductPrice.
   */
  private double pPrice;
  /**
   * to store ProductRating.
   */
  private double pRating;
  /**
   * to store ProductCategory.
   */
  private int pCategory;
  /**
   *
   * @param argPid for ProductId.
   */
  public final void setProductId(final int argPid) {
    this.pid = argPid;
  }
  /**
   *
   * @param argVid for VendorId.
   */
  public final void setVendorId(final int argVid) {
    this.vid = argVid;
  }
  /**
   *
   * @param argPname for ProductName.
   */
  public final void setProductName(final String argPname) {
    this.name = argPname;
  }
  /**
   *
   * @param argProductQuantity for ProductQuantity.
   */
  public final void setProductQuantity(final int argProductQuantity) {
    this.pQuantity = argProductQuantity;
  }
  /**
   *
   * @param argProductPrice for ProductPrice.
   */
  public final void setProductPrice(final double argProductPrice) {
    this.pPrice = argProductPrice;
  }
  /**
   *
   * @param argProductRating for ProductRating.
   */
  public final void setProductRating(final double argProductRating) {
    this.pRating = argProductRating;
  }
  /**
   *
   * @param argProductCategory for ProductCategory.
   */
  public final void setProductCategory(final int argProductCategory) {
    this.pCategory = argProductCategory;
  }
  /**
   *
   * @return ProductId.
   */
  public final int getProductid() {
    return this.pid;
  }
  /**
   *
   * @return VendorId.
   */
  public final int getVendorId() {
    return this.vid;
  }
  /**
   *
   * @return ProductName.
   */

  public final String getProductName() {
    return this.name;
  }
  /**
   *
   * @return ProductQuantity.
   */
  public final int getProductQuantity() {
    return this.pQuantity;
  }
  /**
   *
   * @return ProductPrice.
   */
  public final double getProductPrice() {
    return this.pPrice;
  }
  /**
   *
   * @return ProductRating.
   */
  public final double getProductRating() {
    return this.pRating;
  }
  /**
   *
   * @return ProductCategory.
   */
  public final int getProductCategory() {
    return this.pCategory;
  }
  /**
   * default constructor.
   */
  public Menu() {

  }

   /**
   * parameterized constructor.
   * @param argProductId for ProductId
   * @param argVendorId for VendorId
   * @param argProductName for ProductName
   * @param argProductQuantity for ProductQuantity
   * @param argProductPrice for ProductPrice
   * @param argProductRating for ProductRating
   * @param argProductCategory for ProductCategory
   */
  public Menu(final int argProductId, final int argVendorId, final String argProductName,
      final int argProductQuantity, final double argProductPrice, final double argProductRating, final int argProductCategory) {
    this.pid = argProductId;
    this.vid = argVendorId;
    this.name = argProductName;
    this.pQuantity = argProductQuantity;
    this.pPrice = argProductPrice;
    this.pRating = argProductRating;
    this.pCategory = argProductCategory;
  }
  /**
   * hashCode method.
   * @return int
   */
  @Override
  public final int hashCode() {
    return Objects.hash(pid, vid, name, pQuantity, pPrice, pRating, pCategory);
  }

  /**
   * equals method.
   * @param obj Object
   * @return boolean
   */
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }

    Menu other = (Menu) obj;
    if (Objects.equals(pid, other.pid) && Objects.equals(vid, other.vid)
        && Objects.equals(name, other.name) && Objects.equals(pQuantity, other.pQuantity)
        && Objects.equals(pPrice, other.pPrice) && Objects.equals(pRating, other.pRating) && Objects.equals(pCategory, other.pCategory)) {
      return true;
    }
    return false;
  }

  /**
   * toString method.
   * @return string
   */
  @Override
  public final String toString() {
    return "Menu [ProductId=" + pid + ", VendorId=" + vid + ", ProductName=" + name + ", ProductQuantity=" + pQuantity
        + ", ProductPrice=" + pPrice + ", ProductRating=" + pRating + ", ProductCategory=" + pCategory + "]";
  }

  /**
   * to Add a new product.
   * @param argVendorId for vendor id
   * @param argProductName for name
   * @param argProductQuantity for quantity
   * @param argProductPrice for price
   * @param argProductCategory for ProductCategory
   * @return string
   */
  public final String addProductDetails(final int argVendorId, final String argProductName,
      final int argProductQuantity, final double argProductPrice, final int argProductCategory) {
    String str = "Unable to Add item! Please try again!";

    Menu m = MenuFactory.findLastRow();

    int id = 100;
    if (m != null) {
      id = m.getProductid() + 1;
    }
    try {
      int i = MenuFactory.addProductDetails(id, argVendorId, argProductName,
          argProductQuantity, argProductPrice, argProductCategory);
      if (i > 0) {
        str = "Product Added Successfully! Please login to continue";
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }

    return str;
  }
  /**
   * to update product quantity.
   * @param productId for product id
   * @param vendorId for vendor id
   * @param quantity for Product quantity
   * @return string
   */
  public final String updateProductQuantity(final int productId, final int vendorId, final int quantity) {
    String res = "Unable to update quantity";

    int i = MenuFactory.updateProductQuantity(pid, vid, quantity);
    if (i > 0) {
      res = "Quantity updated successfully";
    }

    return res;
  }
  /**
   * to update product quantity.
   * @param productId for product id
   * @param vendorId for vendor id
   * @param price for Product Price
   * @return string
   */
  public final String updateProductPrice(final int productId, final int vendorId, final double price) {
    String res = "Unable to update price";

    int i = MenuFactory.updateProductPrice(pid, vid, price);
    if (i > 0) {
      res = "Price updated successfully";
    }

    return res;
  }
  /**
   * to update product quantity.
   * @param productId for product id
   * @param vendorId for vendor id
   * @param rating for Product Rating
   * @return string
   */
  public final String updateProductRating(final int productId, final int vendorId, final double rating) {
    String res = "Unable to update rating";

    int i = MenuFactory.updateProductRating(pid, vid, rating);
    if (i > 0) {
      res = "Rating Updated successfully";
    }

    return res;
  }
}
