package com.app.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.app.model.Vendor;

/**
 * DAO class for Vendor.
 */
public interface VendorDAO {
    /**
     * To register a Vendor.
     * @param id vendor id
     * @param pass password
     * @param name vendor name
     * @param phone phone number
     * @param email email
     * @return int
     */
  @SqlUpdate("INSERT INTO VENDOR VALUES (:id , :pass , :name , :phone , :email )")
  int registerVendor(@Bind("id") final int id, @Bind("pass") final String pass,
      @Bind("name") final String name, @Bind("phone") final String phone, @Bind("email") final String email);

    /**
     * View vendor details by vendor id.
     * @param vendorId for vendorId
     * @return list of vendor details
     */
  @SqlQuery("SELECT * FROM VENDOR WHERE VENDORID = :id")
  @Mapper(VendorMapper.class)
  Vendor findById(@Bind("id") final int vendorId);
  /**
     * View vendor details by vendor email.
     * @param vendorEmail for vendoremail
     * @return list of vendor details
    */
  @SqlQuery("SELECT * FROM VENDOR WHERE email = :vendorEmail")
  @Mapper(VendorMapper.class)
  Vendor findVendorByEmail(@Bind("vendorEmail") final String vendorEmail);

  /**
   * to update phone.
   * @param id Vendor id
   * @param phone new phone number
   * @return int
   */
  @SqlUpdate("UPDATE VENDOR SET PHONE = :phone WHERE VENDORID = :id")
  int updatePhone(@Bind("id") final int id, @Bind("phone") final String phone);

    /**
     * To update password.
     * @param id vendor id.
     * @param pass new password.
     * @return int
     */
  @SqlUpdate("UPDATE VENDOR SET PASSKEY = :pass WHERE VENDORID = :id")
  int updatePassword(@Bind("id") final int id, @Bind("pass") final String pass);

    /**
     * find the last row in table Vendor.
     * @return Vendor
     */
  @SqlQuery("SELECT * FROM VENDOR WHERE VENDORID = (SELECT MAX(VENDORID) FROM VENDOR)")
  @Mapper(VendorMapper.class)
  Vendor findLastRow();

}
