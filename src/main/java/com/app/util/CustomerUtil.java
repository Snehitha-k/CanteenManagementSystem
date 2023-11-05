package com.app.util;

import java.util.Scanner;
import java.text.ParseException;

import com.app.factory.CouponFactory;
import com.app.factory.CustomerFactory;
import com.app.factory.MenuFactory;
import com.app.factory.OrderFactory;
import com.app.model.Coupon;
import com.app.model.Customer;
import com.app.model.Menu;
import com.app.model.Order;

//import java.util.format;
//import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
//import java.util.List;
/**
 * Utility class for Customer.
 */
public class CustomerUtil {
  private Scanner opt = new Scanner(System.in, "UTF-8");
  private int flag = 0;

  /**
   * main menu for customer.
   */
  public final void customerMenu() {
    System.out.println("Welcome to the Syndicate restuarants");
    System.out.println("1.Login");
    System.out.println("2.Register");
    System.out.println("3.EXIT");
    System.out.println("ENTER YOUR CHOICE:");
    int ch = opt.nextInt();
    subMenu(ch);
  }
  private void subMenu(final int ch) {
    switch (ch) {
      case 1:
        signin();
        break;
      case 2:
        try {
          register();
        } catch (ParseException e) {
          e.printStackTrace();
        }
        break;
      default:
        System.out.println("Registration is working as of now");
        break;
    }
  }
  private void signin() {
    System.out.println("Enter Email id:");
    String em = opt.next();
    //String emId = opt.next();
    System.out.println("Enter password:");
    //String passKey = opt.next();
    String passKey = opt.next();

    Customer c = CustomerFactory.findByEmail(em);
    if (c != null && passKey.equals(c.getcPassword())) {
      showCustomerSubMenu(c.getcId(), c.getcName());
    } else {
      System.out.println("Wrong userid or password");
      customerMenu();
    }
  }
  private void register() throws ParseException {
    Customer cu = new Customer();
    //Customer cu1= new Customer();
    // System.out.println("Enter Id:");
    // int id = opt.nextInt();
    System.out.println("Enter name:");
    String name = opt.next();
    System.out.println("Enter Email:");
    String email = opt.next();
    System.out.println("Enter phone number:");
    String phone;
    phone = opt.next();
    while (phone.length() < 10) {
      System.out.println("Phone number too small");
      phone = opt.next();
    }
    System.out.println("Enter Address:");
    String address = opt.next();
    System.out.println("Enter your birthday as dd/mm/yyyy : ");
    String dt = opt.next();
    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dt);
    System.out.println("Enter Passkey:");
    String passKey = opt.next();
    System.out.println("Enter Passkey Again:");
    String rePassKey = opt.next();
    if (rePassKey.equals(passKey)) {
      String result = cu.registerCustomer(name, email, phone, address, passKey, date1);
      System.out.println(result);
      customerMenu();
    } else {
      System.out.println("Passkey is different,Please register again.");
      register();
    }
  }
  /*
   * showCustomerSubmenu denotes access to customer things.
   * 1.Menu
   * 2.Orders
   * 3.Personal details of customer
   * 4.Check wallet balance
   * 5.Signout
   * 6.Exit
   */
  /**
   * @param id refers to CustomerId
   * @param name refers to CustomerName
   */
  public final void showCustomerSubMenu(final int id, final String name) {
    Customer c = CustomerFactory.getCustomerById(id);
    System.out.println("*******************************");
    System.out.println("Welcome " + c.getcName());
    c.setCustomerDOB(c.getCustomerDOB());
    Date k = c.getCustomerDOB();
    Calendar cal = Calendar.getInstance();
    cal.setTime(k);
    cal.add(Calendar.MONTH, 1);
    Calendar cal1 = Calendar.getInstance();
    cal1.add(Calendar.MONTH, 1);
    if (cal.get(Calendar.MONTH) == cal1.get(Calendar.MONTH)) {
      System.out.println("Hey It's Your Birthday Month!Place an order to get special Discount");
      flag = 1;
    }
    System.out.println("===========================");
    System.out.println("1.Menu");
    System.out.println("2.Orders");
    System.out.println("3.View Personal Details");
    System.out.println("4.Check wallet balance");
    System.out.println("5.Sign out");
    System.out.println("Enter your choice:");
    int ch = opt.nextInt();
    System.out.println();
    switch (ch) {
      case 1:
        productMenu(id, name);
        break;
      case 2:
        ordersMenu(id);
        break;
      case 3:
        myDetails(id, name);
        break;
      case 4:
        checkWallet(id);
        break;
      case 5:
        Runtime.getRuntime().exit(0);
      default:
        System.out.println("Please choose again!");
        break;
    }
    showCustomerSubMenu(id, name);
  }
  private void productMenu(final int id, final String name) {
    System.out.println("===========================");
    System.out.println("1. List All products ");
    System.out.println("2.Find an product");
    System.out.println("3.List by category");
    System.out.println("Enter your choice:");
    int ch = opt.nextInt();

    switch (ch) {
      case 1:
        Menu[] menuList = MenuFactory.showMenu();
        if (menuList.length > 0) {
          System.out.println("ID     ,Descriptioin     ,Price");
          for (Menu a: menuList) {
            System.out.println(a.getProductid() + "," + a.getProductName() + "," + a.getProductPrice());
          }
        } else {
          System.out.println("Sorry! Unable to get the Product list");
        }
        break;
      case 2:
        /*System.out.println("Product Id Please [Enter ) for list of Products]");
        int a = 0;
        if (a == 0) {
          Menu[] alist = MenuFactory.showMenu();
          if (alist.length > 0) {
            System.out.println("ID, DESCRIPTION");
            for (Menu b: alist) {
              System.out.println(b.getProductid() + "," + b.getProductName());
            }
            System.out.println("--------------------------------");
            System.out.println();
          }
        }**/
        System.out.println("Id please: ");
        int a = opt.nextInt();
        Menu am = MenuFactory.showProduct(a);
        if (am != null) {
          System.out.println(am.toString());
        } else {
          System.out.println("Product details unavailable. Please check the Id.");
        }
        break;
      case 3:
        System.out.println("Product Categories: ");
        System.out.println("_________________________________");
        System.out.println("1. Veg");
        System.out.println("2.Non-Veg");
        System.out.println("3.Beverage");
        System.out.println("Enter your category: ");
        int cat = opt.nextInt();

        int category = 0;
        switch (cat) {
          case 1:
            category = 1;
            break;
          case 2:
            category = 2;
            break;
          case 3:
            category = 3;
            break;
          default:
            //category = "VEG";
            System.out.println("Not ready");
            break;
        }
        Menu[] list = MenuFactory.listByCategory(category);
        if (list.length > 0) {
          System.out.println("ID      ,Description      ,Price");
          for (Menu c : list) {
            System.out.println(c.getProductid() + "," + c.getProductName() + "," + c.getProductPrice());
          }
          System.out.println("----------------------------------");
          System.out.println();
        }
        break;
      default:
        showCustomerSubMenu(id, name);
        break;
    }
  }
  private void ordersMenu(final int id) {
    Customer cc = new Customer();
    System.out.println("****************ORDERS*****************");
    System.out.println("1.Previous Orders");
    System.out.println("2.Order a product");
    System.out.println("3.Cancel order");
    System.out.println("4. Do Rating");
    System.out.println("5. Availabe Coupons");
    System.out.println("Enter your choice:");

    int ch = opt.nextInt();
    switch (ch) {
      case 1:
        Order[] history = cc.orderHistory(id);
        if (history.length > 0) {
          for (Order o : history) {
            System.out.println(o.toString());
          }
        } else {
          System.out.println("No Previous orders recorded");
        }
        break;
      case 2:
        Menu[] list = MenuFactory.showMenu();
        if (list.length > 0) {
          System.out.println("ID      ,DESCRIPTION      ,PRICE");
          for (Menu a : list) {
            System.out.println(a.getProductid() + "," + a.getProductName() + "," + a.getProductPrice());
          }
        } else {
          System.out.println("No items are found! Please visit later.");
        }
        System.out.println("Enter Id of the Product");
        int reqId = opt.nextInt();
        System.out.println("Enter Quantity:");
        int qty = opt.nextInt();
        System.out.print("Would you like to apply any coupon (y or n)? ");
        char cho = opt.next().charAt(0);
        int code = 0;
        double dis = 0;
        Menu me = MenuFactory.showProduct(reqId);
        double p = me.getProductPrice() * qty;
        couponDetails();
        if (cho == 'y' || ch == 'Y') {
          System.out.println("Enter CouponCode :");
          code = opt.nextInt();
          String msg = cc.orderAnProduct(reqId, qty, id, dis, code);
          System.out.println(msg);
          if (flag == 1) {
            dis = dis + 5;
            System.out.println("Discount of 5% is applied because you ordered food in your bithday month");
          }
          if (me.getProductCategory() == 3 && p >= 500) {
            dis = dis + 10;
            System.out.println("Discount of 10% is applied on a beverage of more than 500rs!");
          }
          applyCoupon(code, id, p);
        } else {
          String msg = cc.orderAnProduct(reqId, qty, id, dis, code);
          System.out.println(msg);
        }
        break;
      case 3:
        System.out.println("Order Id:");
        int oId = opt.nextInt();
        String res = cancelOrder(id, oId);
        System.out.println(res);
        break;
      case 4:
        System.out.println("Enter Order id");
        int oId1 = opt.nextInt();
        String res1 = giveRating(id, oId1);
        System.out.println(res1);
        break;
      case 5:
        couponDetails();
        break;
      default:
        System.out.println("Wrong Option");
        ordersMenu(id);
        break;
    }
  }

  private void myDetails(final int id, final String name) {
    Customer cd = CustomerFactory.getCustomerById(id);
    System.out.println("*********CUSTOMER_DETAILS*********");
    System.out.println("Welcome" + name);
    System.out.println("1. Show Details");
    System.out.println("2.Update Phone Number");
    System.out.println("3.Update Passkey");
    System.out.println("Enter your choice:");
    int ch = opt.nextInt();

    switch (ch) {
      case 1:
        System.out.println();
        System.out.println("Id:" + id);
        System.out.println("Name:" + name);
        System.out.println("Phone:" + cd.getcPhone());
        System.out.println("Email:" + cd.getcEmail());
        System.out.println("Current Balance:" + cd.getwalletbalance());
        System.out.println("Birthday:" + cd.getCustomerDOB());
        System.out.println("----------------------------------------");
        break;
      case 2:
        System.out.println();
        System.out.println("New Phone Number");
        String ph = opt.next();
        while (ph.length() < 10) {
          System.out.println("Phone number too small");
          ph = opt.next();
        }
        String res = cd.updatePhone(id, ph);
        System.out.println(res);
        break;
      case 3:
        System.out.println("Enter current password:");
        String curPass = opt.next();
        System.out.println("Enter New password:");
        String pass = opt.next();
        System.out.println("Confirm new password:");
        String confirm = opt.next();
        if (curPass.equals(cd.getcPassword()) && !curPass.equals(pass) && pass.equals(confirm)) {
          String str = cd.updatePassword(id, pass);
          System.out.println(str);
        } else {
          System.out.println("Please check your password and try again!");
          myDetails(id, name);
        }
        break;
      default:
        System.out.println("Returning to Customer Menu");
        showCustomerSubMenu(id, name);
        break;
    }
  }

  private void checkWallet(final int id) {
    Customer cu = CustomerFactory.getCustomerById(id);
    System.out.println("Hi " + cu.getcName());
    System.out.println("Your Wallet Balance At Present: " + cu.getwalletbalance());
    System.out.print("Would you like to add to your wallet (y or n)? ");
    char yes = opt.next().charAt(0);
    if (yes == 'y' || yes == 'Y') {
      System.out.print("Enter the Amount to be Credited: ");
      double amt = opt.nextDouble();
      String res = cu.updateWallet(id, cu.getwalletbalance(), amt);
      System.out.println(res);
      cu = CustomerFactory.getCustomerById(id);
      System.out.println("Your Wallet Balance Now: " + cu.getwalletbalance());
    }
  }

  private String cancelOrder(final int memId, final int bId) {
    String msg = "Cancellation was unsuccessful";
    Customer m = new Customer();
    int id = OrderFactory.retrieveCustomerId(bId);
    if (memId == id) {
      msg = m.cancelOrder(bId);
    }
    return msg;
  }
  private void couponDetails() {
    System.out.println("\n Coupons that you may apply :\n");
    Coupon[] list1 = CouponFactory.retrieveCoupons();
    if (list1.length > 0) {
      System.out.println("-----------------------------------------------------------------------------------------------");
      System.out.println("CouponId     CouponCode              Details                                   Validity ");
      System.out.println("-----------------------------------------------------------------------------------------------");
      for (Coupon a : list1) {
        System.out.format("%5d%15s%52s%10d", a.getCouponId(), a.getCouponCode(), a.getDetails(), a.getValidity());
        System.out.println();
      }
    } else {
      System.out.println("No Coupons are found!");
    }
  }
  private String giveRating(final int memId, final int oId) {
    String msg = "Rating has not been updated";
    System.out.println("Enter the rating for the food item");
    double rating = opt.nextDouble();
    int pId = OrderFactory.retrieveProductId(oId);
    int cId = OrderFactory.retrieveCustomerId(oId);
    int vId = OrderFactory.retrieveVendorId(oId);
    int count = OrderFactory.orderedProductCount(pId);
    double oldRating = MenuFactory.retrieveProductRating(pId);
    double newRating = (oldRating + rating) / count;
    if (memId == cId) {
      int i = MenuFactory.updateProductRating(pId, vId, newRating);
      if (i > 0) {
        msg = "Rating updated";
      }
    }
    return msg;
  }
  private void applyCoupon(final int code, final int id, final double price) {
    double bal = CustomerFactory.retrieveWallet(id);
    int size1 = OrderFactory.retrieveOrdersByCode(id, code);
    int ordercount = OrderFactory.orderCount(id);
    Order o = OrderFactory.findLastRow();
    double orderAmt = OrderFactory.retrieveOrderAmount(o.getOrderId());
    if (code == 1) {
      if (size1 == 1 && ordercount == 1) {
        double am = (0.5) * orderAmt;
        CustomerFactory.incrementWallet(id, bal, am);
        System.out.println("Discount of 50% has been given");
      } else {
        System.out.println("Sorry! seems that You have already used this coupon.Check your previous orders for more details");
        display(id, price);
      }
    } else if (code == 2) {
      if (size1 < 1) {
        if (price >= 250) {
          double am = 50;
          CustomerFactory.incrementWallet(id, bal, am);
          System.out.println("Cashback of 50 has been given");
        } else {
          System.out.println("Please order a food item of more than 250 to avail this coupon!");
          display(id, price);
        }
      } else {
        System.out.println("Sorry! seems that You have already used this coupon.Check your previous orders for more details");
        display(id, price);
      }
    } else if (code == 3) {
      if (size1 <= 3) {
        if (price >= 180) {
          double am = 20;
          CustomerFactory.incrementWallet(id, bal, am);
          System.out.println("Cashback of 20 has been given!");
        } else {
          System.out.println("Please order a food item of more than 180 to avail this coupon!");
          display(id, price);
        }
      } else {
        System.out.println("Sorry! seems that You have already used this coupon.Check your previous orders for more details");
        display(id, price);
      }
    } else if (code == 4) {
      if (size1 <= 4) {
        double am = 10;
        CustomerFactory.incrementWallet(id, bal, am);
        System.out.println("Congrats you got a cashback of RS 10 Amount has been added to wallet");
      } else {
        System.out.println("Sorry! seems that You have already used this coupon.Check your previous orders for more details");
        display(id, price);
      }
    } else if (code == 5) {
      if (size1 < 1) {
        if (ordercount == 5) {
          double am = 30;
          CustomerFactory.incrementWallet(id, bal, am);
          System.out.println("Congrats on completing your 5 orders with us! Cashback of RS 30 has been added");
        } else {
          System.out.println("Only applies on first 5 orders completion!");
          display(id, price);
        }
      } else {
        System.out.println("Sorry! seems that You have already used this coupon.Check your previous orders for more details");
        display(id, price);
      }
    } else if (code == 6) {
      if (size1 <= 6) {
        double am = 5;
        CustomerFactory.incrementWallet(id, bal, am);
        System.out.println("Congrats You got a cashback of RS 5. Amount has been added to wallet!");
      } else {

        System.out.println("Sorry! seems that You have already used this coupon.Check your previous orders for more details");
        display(id, price);
      }
    } else {
      double am = 0;
      System.out.println("No coupons have been applied");
      CustomerFactory.incrementWallet(id, bal, am);
    }
  }
  private void display(final int id, final double price) {
    System.out.println("Do You Want to Continue with out coupon (y or n) ?");
    char s = opt.next().charAt(0);
    if (s == 'y' || s == 'Y') {
      couponDetails();
      System.out.println("Enter CouponCode :");
      int code1 = opt.nextInt();
      applyCoupon(code1, id, price);
    } else {
      ordersMenu(id);
    }
  }
}
