package com.app.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import com.app.factory.CustomerFactory;
import com.app.factory.OrderFactory;
import com.app.factory.VendorFactory;

/**
 * Vendor class.
 */
public class Vendor {
  /**
   * To store vendorId.
   */
  private int vendorId;

  /**
   * To store passkey.
   */
  private String passKey;
  /**
   * To store vendorName.
   */
  private String vendorName;
  /**
   * To store phone.
   */
  private String phone;
  /**
   * To store email.
   */
  private String email;

  /**
   *
   * @return vendorId.
   */
  public final int getVendorId() {
    return this.vendorId;
  }

  /**
   *
   * @return passkey.
   */
  public final String getPassKey() {
    return this.passKey;
  }

  /**
   *
   * @return vendorName.
   */
  public final String getVendorName() {
    return this.vendorName;
  }

  /**
   *
   * @return phone.
   */
  public final String getPhone() {
    return this.phone;
  }

  /**
   *
   * @return email.
   */
  public final String getEmail() {
    return this.email;
  }

  /**
   *
   * @param argVendorId for vendorId.
   */
  public final void setVendorId(final int argVendorId) {
    this.vendorId = argVendorId;
  }

  /**
   *
   * @param argPassKey for passkey.
   */
  public final void setPassKey(final String argPassKey) {
    this.passKey = argPassKey;
  }

  /**
   *
   * @param argVendorName for vendorName.
   */
  public final void setVendorName(final String argVendorName) {
    this.vendorName = argVendorName;
  }

  /**
   *
   * @param argPhone for phone.
   */
  public final void setPhone(final String argPhone) {
    this.phone = argPhone;
  }

  /**
   *
   * @param argEmail for email.
   */
  public final void setEmail(final String argEmail) {
    this.email = argEmail;
  }

  /**
   * default constructor.
   */
  public Vendor() {

  }

  /**
   * parameterized constructor.
   * @param argVendorId for vendorId
   * @param argPassKey for passkey
   * @param argVendorName for vendorName
   * @param argPhone for phone
   * @param argEmail for email
   */

  public Vendor(final int argVendorId, final String argPassKey, final String argVendorName,
      final String argPhone, final String argEmail) {
    this.vendorId = argVendorId;
    this.passKey = argPassKey;
    this.vendorName = argVendorName;
    this.phone = argPhone;
    this.email = argEmail;
  }

  /**
   * hashcode method.
   * @return int
   */
  @Override
  public final int hashCode() {
    return Objects.hash(vendorId, passKey, vendorName, phone, email);
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

    Vendor ven = (Vendor) obj;
    if (Objects.equals(vendorId, ven.vendorId) && Objects.equals(passKey, ven.passKey)
        && Objects.equals(vendorName, ven.vendorName) && Objects.equals(phone, ven.phone)
        && Objects.equals(email, ven.email)) {
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
    return "Vendor Details: Id: " + this.vendorId + "Passkey: " + this.passKey + " Name: "
      + this.vendorName + " Phone: " + this.phone + " Email: " + this.email;
  }

  /**
   * register a new vendor.
   * @param argPassKey for passkey.
   * @param argVendorName for vendorname.
   * @param argPhone for phone.
   * @param argEmail for email.
   * @return string
   */
  public final String registerVendor(final String argPassKey, final String argVendorName,
      final String argPhone, final String argEmail) {

    Vendor v = VendorFactory.findLastRow();

    int id = 100;
    if (v != null) {
      id = v.getVendorId() + 1;
    }

    String res = "Registration Unsuccessful! Please try again.";
    int i = VendorFactory.registerVendor(id, argPassKey, argVendorName, argPhone, argEmail);
    if (i > 0) {
      res = "Registration Successful!";
    }

    return res;
  }

  /**
   * to update phone.
   * @param id for Vendor id
   * @param ph for new phone number
   * @return string
   */
  public final String updatePhone(final int id, final String ph) {
    String res = "Unable to update phone! Please try again.";

    int i = VendorFactory.updatePhone(id, ph);
    if (i > 0) {
      res = "Phone number updated successfully.";
    }

    return res;
  }

  /**
   * to update password.
   * @param id for vendor id.
   * @param pass for new password
   * @return string
   */
  public final String updatePassword(final int id, final String pass) {
    String res = "Unable to update password! please try again";

    int i = VendorFactory.updatePassword(id, pass);
    if (i > 0) {
      res = "Password updated successfully";
    }

    return res;
  }

  /**
   * To accept or deny the order.
   * @param argOrderId for booking id.
   * @param stat for status.
   * @param amt for amount.
   * @return string
   */
  public final String acceptDenyOrder(final int argOrderId, final String stat, final double amt) {
    String msg = "Order Status: Rejected";
    Order b = OrderFactory.showOrderDetails(argOrderId);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    if (b != null) {
      int custId = b.getCustId();
      Customer m = CustomerFactory.getCustomerById(custId);
      double amount = m.getwalletbalance();
      int id = m.getcId();
      Date bDate = b.getOrderDate();
      String temp = sdf.format(new Date());
      Date today = new Date();

      try {
        today = sdf.parse(temp);
      } catch (ParseException ex) {
        System.out.println(ex.getMessage());
      }
      if (bDate.compareTo(today) >= 0) {
        if (stat.equals(OrderStatus.REJECTED.toString())) {
          int i = CustomerFactory.incrementWallet(id, amount, amt);
          if (i > 0) {
            System.out.println("Order Amount Credited to Wallet");
          }
          msg = "Denied";
        }
        if (stat.equals(OrderStatus.ACCEPTED.name())) {
          msg = "Accepted";
        }
        int r = OrderFactory.updateStatus(argOrderId, stat);
        if (r > 0) {
          msg = msg + " Status Updated";
        }
      } else {
        msg = "Unchanged. Not considered due to date mismatch";
      }
    } else {
      msg = "Invalid Order";
    }
    return msg;
  }
}
