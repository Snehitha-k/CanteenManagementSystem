package com.app.factory;
import java.util.List;

import com.app.model.Coupon;
import com.app.persistence.CouponDAO;
import com.app.persistence.DbConnection;
/**
 * CouponFactory class used to fetch coupon data from database.
 */
public class CouponFactory {
  /**
  *  Protected constructor.
  */
  protected CouponFactory() {

  }
  /**
    * Call the data base connection.
    * @return the connection object.
  */
  private static CouponDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CouponDAO.class);
  }
  /**
  * to find the last row.
  * @return Coupon object
  */
  public static Coupon findLastRow() {
    Coupon m = dao().findLastRow();
    return m;
  }
  /**
   * to Add a new coupon.
   * @param id for Coupon id
   * @param det for Details
   * @param val for validity
   * @param code for coupon code
   * @param amt for amount
   * @return int
   */
  public static int addCouponDetails(final int id, final String code, final String det, final int val, final double amt) {
    int value = dao().addCouponDetails(id, code, det, val, amt);
    return value;
  }
  /**
  * to list all Coupons.
  * @return array
  */
  public static Coupon[] retrieveCoupons() {
    List<Coupon> list = dao().retrieveCoupons();
    return list.toArray(new Coupon[list.size()]);
  }
}
