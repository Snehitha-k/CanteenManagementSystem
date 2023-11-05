package com.app.model;

import java.util.Objects;

import com.app.factory.CustomerFactory;
import com.app.factory.MenuFactory;
import com.app.factory.OrderFactory;

//import com.app.factory.CouponFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
//import java.time.ZoneId;
import java.util.Calendar;
import java.time.LocalDate;
/**
 * Customer class.
 */
public class Customer {
  /**
   * to store customerId.
   */
  private int cId;

  /**
   * to store customerName.
   */
  private String cName;

  /**
   * to store email.
   */
  private String cEmail;

  /**
   * to store phone.
   */
  private String cPhone;

  /**
   * to store wallet balance.
   */
  private double walletbalance;

  /**
   * to store the customer address.
   */
  private String cAddress;

  /**
   * to store the password.
   */
  private String cPassword;

  /**
   * to store dob.
   */
  private Date customerDOB;

  /**
   *
   * @return customer Id.
   */
  public final int getcId() {
    return this.cId;
  }
  /**
   *
   * @return customerDOB.
   */
  public final Date getCustomerDOB() {
    return this.customerDOB;
  }
  /**
   *
   * @param argCustomerDOB for customerDob.
   */
  public final void setCustomerDOB(final Date argCustomerDOB) {
    this.customerDOB = argCustomerDOB;
  }
  /**
   *
   * @param argcId for customer Id.
   */
  public final void setcId(final int argcId) {
    this.cId = argcId;
  }

  /**
   *
   * @return customer Name.
   */
  public final String getcName() {
    return this.cName;
  }

  /**
   *
   * @param argcName for customer Name.
   */
  public final void setcName(final String argcName) {
    this.cName = argcName;
  }

  /**
   *
   * @return email.
   */
  public final String getcEmail() {
    return this.cEmail;
  }

  /**
   *
   * @param argcEmail for email.
   */
  public final void setcEmail(final String argcEmail) {
    this.cEmail = argcEmail;
  }

  /**
   *
   * @return phone.
   */
  public final String getcPhone() {
    return this.cPhone;
  }

  /**
   *
   * @param argcPhone for phone.
   */
  public final void setcPhone(final String argcPhone) {
    this.cPhone = argcPhone;
  }

  /**
   *
   * @return wallet balance.
   */
  public final double getwalletbalance() {
    return this.walletbalance;
  }

  /**
   *
   * @param argwalletbalance for wallet balance.
   */
  public final void setwalletbalance(final double argwalletbalance) {
    this.walletbalance = argwalletbalance;
  }

  /**
   *
   * @return customer address.
   */
  public final String getcAddress() {
    return this.cAddress;
  }

  /**
   *
   * @param argcAddress for customer address.
   */
  public final void setcAddress(final String argcAddress) {
    this.cAddress = argcAddress;
  }

  /**
   *
   * @return password.
   */
  public final String getcPassword() {
    return this.cPassword;
  }

  /**
   *
   * @param argcPassword for password.
   */
  public final void setcPassword(final String argcPassword) {
    this.cPassword = argcPassword;
  }

  /**
   * default constructor.
   */
  public Customer() {

  }

  /**
   * parameterized constructor.
   * @param argcId for customer Id.
   * @param argcName for customer Name
   * @param argcEmail for email
   * @param argcPhone for phone
   * @param argwalletbalance for wallet balance.
   * @param dob for customer dob
   * @param argcPassword for password
   */
  public Customer(final int argcId, final String argcName, final String argcEmail,
      final String argcPhone, final double argwalletbalance, final Date dob, final String argcPassword) {
    this.cId = argcId;
    this.cName = argcName;
    this.cEmail = argcEmail;
    this.cPhone = argcPhone;
    this.walletbalance = argwalletbalance;
    this.customerDOB = dob;
    this.cPassword = argcPassword;
  }
  /**
   * hashCode method.
   * @return int
   */
  @Override
  public final int hashCode() {
    return Objects.hash(cId, cName, cEmail, cPhone, walletbalance, cAddress, cPassword);
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

    Customer other = (Customer) obj;
    if (Objects.equals(cId, other.cId) && Objects.equals(cName, other.cName)
        && Objects.equals(cEmail, other.cEmail) && Objects.equals(cPhone, other.cPhone)
        && Objects.equals(walletbalance, other.walletbalance) && Objects.equals(cAddress, other.cAddress)
        && Objects.equals(cPassword, other.cPassword)) {
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
    return "Customer Details: [CustomerId: " + this.cId + ", CustomerName: " + this.cName + ", CustomerEmail: " + this.cEmail
        + ", CustomerPhone: " + this.cPhone + ", walletbalance=" + walletbalance + ", CustomerAddress: " + this.cAddress
        + "]";
  }

  /**
   * register for Customer.
   * @param argcName for Customername
   * @param argcEmail for email
   * @param argcPhone for phone
   * @param argcAddress for Customeraddress
   * @param argcPassword for password
   * @param date1 for dob
   * @return string
   */
  public final String registerCustomer(final String argcName, final String argcEmail,
      final String argcPhone, final String argcAddress, final String argcPassword, final Date date1) {

    Customer c = new Customer();
    c.setcName(argcName);
    c.setcPhone(argcPhone);
    c.setcEmail(argcEmail);
    c.setwalletbalance(10000);
    c.setcAddress(argcAddress);
    c.setcPassword(argcPassword);

    Customer c1 = CustomerFactory.findLastRow();

    int id = 101;
    if (c1 != null) {
      id = c1.getcId() + 1;
    }

    String res = "Registration Unsuccessful";
    int i = CustomerFactory.registerCustomer(id, c.getcName(), c.getcPhone(), c.getcEmail(), c.getwalletbalance(), date1, c.getcPassword());
    if (i > 0) {
      int j = CustomerFactory.updateAddress(id, argcAddress);
      if (j > 0) {
        res = "Registration Successful!";
      }
    }

    return res;
  }

  // /**
  //  * create a member list.
  //  */
  // public final void createList() {
  //   for (int i = 0; i < 5; i++) {
  //     cusList[i] = new Customer();
  //   }
  // }
  ///**
  // * register a new Customer.
  // * @param argcId for Custmerid
  // * @param argcName for Customername
  // * @param argcEmail for email
  // * @param argcPhone for phone
  // * @param argwalletbalance for walletbalance
  // * @param argcAddress for Customeraddress
  // * @param argcPassword for password
  // * @return string
  // */
  //public final String registerCustomer(final int argcId, final String argcName, final String argcEmail,
  //    final String argcPhone, final double argwalletbalance, final String argcAddress, final String argcPassword) {
  //  Customer c = new Customer();
  //  c.setcId(argcId);
  //  c.setcName(argcName);
  //  c.setcPhone(argcPhone);
  //  c.setcEmail(argcEmail);
  //  c.setwalletbalance(argwalletbalance);
  //  c.setcAddress(argcAddress);
  //  c.setcPasskey(argcPasskey);

  //  String registerupdate = "Registeration Unsuccessful";
  //  for (int i = 0; i < cList.length; i++) {
  //    if (cList[i] == null) {
  //      cList[i] = new Customer();
  //      cList[i] = c;
  //      registerupdate = "Registration Successful";
  //      break;
  //    }
  //  }
  //  return registerupdate;
  //}
//}

/**
   * to update phone.
   * @param argcId for customerid
   * @param argcPhone for new phone number
   * @return string
   */
  public final String updatePhone(final int argcId, final String argcPhone) {
    String updatenumber = "Unable to update phone number";

    int i = CustomerFactory.updatePhone(argcId, argcPhone);
    if (i > 0) {
      updatenumber = "Phone number updated successfully";
    }

    return updatenumber;
  }

 /**
   * to update password.
   * @param argcId for customerid
   * @param argcPassword for new password
   * @return string
   */
  public final String updatePassword(final int argcId, final String argcPassword) {
    String newpassword = "Unable to update password";

    int i = CustomerFactory.updatePassword(argcId, argcPassword);
    if (i > 0) {
      newpassword = "Password updated successfully";
    }

    return newpassword;
  }

  /**
   * to update wallet amount.
   * @param argcId for customerid
   * @param argwalletbalance for current amount
   * @param addwalletbalance for amount to be credited
   * @return string
   */
  public final String updateWallet(final int argcId, final double argwalletbalance, final double addwalletbalance) {
    String addamount = "Update unsuccessful";

    int i = CustomerFactory.updateWalletAmount(argcId, argwalletbalance, addwalletbalance);
    if (i > 0) {
      addamount = "Balance updated";
    }

    return addamount;
  }
    /**
   * to order a food product.
   * @param argpid for Product id.
   * @param qty for quantity.
   * @param cusId for Customer id.
   * @param dis for discount.
   * @param code for coupon code
   * @return string
   */
  public final String orderAnProduct(final int argpid, final int qty, final int cusId, final double dis, final int code) {
    String res = "Unable to order the product";

    //retrieves the food details.
    Menu am = MenuFactory.showProduct(argpid);
    if (am != null) {
      System.out.println(am.getProductid() + ", " + am.getProductName()
          + ", " + am.getProductPrice() + ", " + am.getProductCategory());
      System.out.println();
      int oId = 3001;

      Order b = OrderFactory.findLastRow();
      if (b != null) {
        oId = b.getOrderId() + 1;
      }

      //date manipulations
      Date bDate = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

      //to get yesterday's date
      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.DATE, -1);
      Date yester = cal.getTime();

      try {
        String temp = sdf.format(bDate);
        bDate = sdf.parse(temp);

        temp = sdf.format(yester);
        yester = sdf.parse(temp);
      } catch (ParseException ex) {
        System.out.println(ex.getMessage());
      }
      double total = am.getProductPrice() * qty;
      double sub = 100 - dis;
      double total1 = (total * sub) / 100;
      //String status = OrderStatus.PENDING.name();

      Customer m = CustomerFactory.getCustomerById(cusId);
      double bal = m.getwalletbalance();

      if (bal > total1) {
        int i = OrderFactory.addOrder(oId, cusId, argpid, am.getVendorId(), bDate,
            total1, OrderStatus.PENDING);
        if (i > 0) {
          OrderFactory.updateOrderAmount(argpid, total1);
          OrderFactory.updateCode(oId, code);
          int x = CustomerFactory.decrementWallet(cusId, m.getwalletbalance(), total1);
          if (x > 0) {
            System.out.println("Wallet Balance Updated");
          }
          res = "Food Product ordered Successfully";
        }
      } else {
        res = "Insufficient Balance. Please update your wallet";
      }
    } else {
      res = "Food Product not found. Please check and order again!";
    }
    return res;
  }


    /**
   * to cancel a order.
   * @param oId for order id
   * @return string
   */
  public final String cancelOrder(final int oId) {
    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    Order b = OrderFactory.showOrderDetails(oId);
    Customer m = CustomerFactory.getCustomerById(b.getCustId());
    String msg = "Cancellation was unsuccessful";
    LocalDate today = LocalDate.now();
    if (b != null) {
      Date bDate = b.getOrderDate();
      java.sql.Date sDate = new java.sql.Date(bDate.getTime());
      LocalDate lDate = sDate.toLocalDate();
      if (today.equals(lDate)) {

        int x = OrderFactory.updateStatus(oId, "CANCELLED");
        if (x > 0) {
          double amt = OrderFactory.retrieveOrderAmount(oId);
          msg = "Order Cancelled Successfully";
          int i = CustomerFactory.incrementWallet(b.getCustId(), m.getwalletbalance(), amt);
          if (i > 0) {
            System.out.println("Order Amount Credited to Wallet");
          }
        }
      }
    }
    return msg;
  }
  /**
   * to get the order history.
   * @param argcid for customer id
   * @return order array
   */
  public final Order[] orderHistory(final int argcid) {
    Order[] his = OrderFactory.custOrderHistory(argcid);
    return his;
  }
  /**
   * To display the details of the customer .
   * @param uid for userid.
   * @return customer
   */
  public final Customer getCustomerById(final int uid) {
    Customer c = CustomerFactory.getCustomerById(uid);
    return c;
  }
  /**
   * @param oId for order id.
   * @param date for order date.
   * @param amt for orderamt.
   * @return string
   */
  /*public static final String applyCoupon(final int oId, final Date date, final double amt) {
    String msg = "Coupon has not been applied";
    int k = 1;
    try {
      k = CouponFactory.retrieveOrderId(oId);
    } catch (Exception e) {
      msg = "Already coupon applied";
    }
    if (k == 0) {
      int cId = 101;
      Coupon b = CouponFactory.findLastRow();
      if (b != null) {
        cId = b.getCouponid() + 1;
      }
      int i = CouponFactory.addCouponDetails(cId, oId);
      int j = OrderFactory.updateOrderAmount(oId, amt);
      if (i > 0 && j > 0) {
        msg = "Coupon has been applied";
      }
    }
    return msg;
  }**/
}
