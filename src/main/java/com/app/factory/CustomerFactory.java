package com.app.factory;
import java.util.Date;

import com.app.model.Customer;
import com.app.persistence.CustomerDAO;
import com.app.persistence.DbConnection;

/**
 * factory class for Customer.
 */
public class CustomerFactory {
  /**
   * protected constructor.
   */
  protected CustomerFactory() {

  }

  /**
   * dao() method.
   * @return CustomerDAO
   */
  private static CustomerDAO dao() {
    DbConnection db  = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }

  /**
   * to retrieve a Customer by email.
   * @param argcEmail for email
   * @return Customer
   */
  public static Customer findByEmail(final String argcEmail) {
    Customer c = dao().findByEmail(argcEmail);
    return c;
  }

  /**
   * to retrieve Customer details by id.
   * @param cId for member id
   * @return Customer
   */
  public static Customer getCustomerById(final int cId) {
    Customer c = dao().getCustomerById(cId);
    return c;
  }

  /**
   * to get the last row.
   * @return Customer.
   */
  public static Customer findLastRow() {
    Customer c = dao().findLastRow();
    return c;
  }

  /**
   * to register a new Customer.
   * @param argcId for id
   * @param argcName for name
   * @param argcEmail for email
   * @param argcPhone for phone
   * @param walletbalance for wallet balance
   * @param date1 for dob
   * @param cPassword for password
   * @return int
   */
  public static int registerCustomer(final int argcId, final String argcName, final String argcPhone,
      final String argcEmail, final double walletbalance, final Date date1, final String cPassword) {
    int value = dao().registerCustomer(argcId, argcName, argcPhone, argcEmail, walletbalance, date1, cPassword);
    return value;
  }

  /**
   * to update phone.
   * @param cId for Customerid
   * @param argcPhone for new phone number
   * @return int
   */
  public static int updatePhone(final int cId, final String argcPhone) {
    int value = dao().updatePhone(cId, argcPhone);
    return value;
  }

  /**
   * to update password.
   * @param cId for Customerid
   * @param cPassword for new password
   * @return int
   */
  public static int updatePassword(final int cId, final String cPassword) {
    int value = dao().updatePassword(cId, cPassword);
    return value;
  }
  /**
   * to update Address.
   * @param id for Customerid
   * @param cAddr for new Address
   * @return int
   */
  public static int updateAddress(final int id, final String cAddr) {
    int value = dao().updateAddress(id, cAddr);
    return value;
  }

  /**
   * to decrement the wallet when room is booked.
   * @param cId for Customerid
   * @param walletbalance for current wallet balance
   * @param reduceamount for booking amount
   * @return int
   */
  public static int decrementWallet(final int cId, final double walletbalance, final double reduceamount) {
    int value = dao().decrementWallet(cId, walletbalance, reduceamount);
    return value;
  }

  /**
   * to increment the wallet when booking is cancelled or denied.
   * @param cId for Customerid
   * @param walletbalance for current wallet balance
   * @param addamount for booking amount
   * @return int
   */
  public static int incrementWallet(final int cId, final double walletbalance, final double addamount) {
    int value = dao().incrementWallet(cId, walletbalance, addamount);
    return value;
  }
  /**
   * to increase the wallet balance.
   * @param cId for Customerid
   * @param walletbalance for current wallet balance
   * @param amount for amount to be added
   * @return int
   */
  public static int updateWalletAmount(final int cId, final double walletbalance, final double amount) {
    int value = dao().updateWalletAmount(cId, walletbalance, amount);
    return value;
  }
  /**
   * to retrieve the wallet amount.
   * @param id for customer id
   * @return double
   */
  public static double retrieveWallet(final int id) {
    double amt = dao().retrieveWallet(id);
    return amt;
  }
}
