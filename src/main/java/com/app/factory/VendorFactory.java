package com.app.factory;

import com.app.model.Vendor;
import com.app.persistence.DbConnection;
import com.app.persistence.VendorDAO;

/**
 * Factory class for Vendor.
 */
public class VendorFactory {

  /**
   * protected constructor.
   */
  protected VendorFactory() {

  }

  /**
   * dao method represents the VendorDAO.
   * @return VendorDAO
   */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }

  /**
   * to find Vendor by id.
   * @param id for Vendor id
   * @return Vendor
   */
  public static Vendor findById(final int id) {
    Vendor v = dao().findById(id);
    return v;
  }
  /**
   * to find Vendor by email.
   * @param vemail for Vendor email
   * @return Vendor
   */
  public static Vendor findVendorByEmail(final String vemail) {
    Vendor v = dao().findVendorByEmail(vemail);
    return v;
  }

  /**
   * to register a Vendor.
   * @param id for vendor id
   * @param name for Vendor name
   * @param phone for phone
   * @param email for email
   * @param pass for password
   * @return int
   */
  public static int registerVendor(final int id, final String pass, final String name,
      final String phone, final String email) {
    int res = dao().registerVendor(id, pass, name, phone, email);
    return res;
  }

  /**
   * to update phone.
   * @param id for Vendor id
   * @param phone for new phone number
   * @return int
   */
  public static int updatePhone(final int id, final String phone) {
    int res = dao().updatePhone(id, phone);
    return res;
  }

  /**
   * to get the last row.
   * @return Vendor
   */
  public static Vendor findLastRow() {
    Vendor v = dao().findLastRow();
    return v;
  }

  /**
   * to update password.
   * @param id for Vendor id
   * @param pass for password
   * @return int
   */
  public static int updatePassword(final int id, final String pass) {
    int res = dao().updatePassword(id, pass);
    return res;
  }
}
