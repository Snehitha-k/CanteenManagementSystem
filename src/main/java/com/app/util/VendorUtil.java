package com.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.io.FileInputStream;

import com.app.factory.CustomerFactory;
import com.app.factory.MenuFactory;
import com.app.factory.OrderFactory;
import com.app.factory.VendorFactory;
import com.app.model.Customer;
import com.app.model.Menu;
import com.app.model.Order;
import com.app.model.Vendor;


/**
 * Utility class for Vendor.
 */
public class VendorUtil {
  private Scanner opt = new Scanner(System.in, "UTF-8");
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  /**
   * main menu for vendor.
   */
  public final void vendorMenu() {
    System.out.println("Welcome to Syndicate restaraunts");
    System.out.println("1. Login");
    System.out.println("2. Register");
    System.out.println("3. Exit");
    System.out.print("Your Choice: ");
    int ch = opt.nextInt();
    vendorSubMenu(ch);
  }

  private void vendorSubMenu(final int ch) {
    switch (ch) {
      case 1:
        signin();
        break;
      case 2:
        register();
        break;
      default:
        System.out.println("You can either register or sign in");
        vendorMenu();
        break;
    }
  }
  private void signin() {
    System.out.println("**************************");
    System.out.print("Username: ");
    String em = opt.next();
    System.out.print("Password: ");
    String pass = opt.next();

    Vendor e = VendorFactory.findVendorByEmail(em);
    if (e != null && pass.equals(e.getPassKey())) {
      showVendorSubMenu(e.getVendorId(), e.getVendorName());
    } else {
      System.out.println("Wrong Credentials! Please try again!");
      vendorMenu();
    }

  }
  private void register() {
    Vendor ve = new Vendor();
    System.out.println("Enter Name:");
    String name = opt.next();
    System.out.println("Enter Email:");
    String em = opt.next();
    System.out.println("enter Phone:");
    String phone = opt.next();
    while (phone.length() < 10) {
      System.out.println("Phone number too small");
      phone = opt.next();
    }
    System.out.println("Enter Passkey:");
    String passKey = opt.next();
    while (passKey.length() < 6) {
      System.out.println("Password too short");
      System.out.println("Enter passkey: ");
      passKey = opt.next();
    }
    System.out.println("Enter passkey again:");
    String repassKey = opt.next();

    if (repassKey.equals(passKey)) {
      String res = ve.registerVendor(passKey, name, phone, em);
      System.out.println(res);
    } else {
      System.out.println("Password mis-matched");
      register();
    }

  }
  /**
   * @param id refers to VendorId
   * @param name refers to Vendor name
   */
  private void showVendorSubMenu(final int id, final String name) {
    System.out.println("Welcome " + name);
    System.out.println("1. Orders");
    System.out.println("2. Menu");
    System.out.println("3. Personal details");
    System.out.println("4. Sign out");
    System.out.print("Your choice: ");
    int ch = opt.nextInt();
    switch (ch) {
      case 1:
        ordersMenu(id, name);
        break;
      case 2:
        productsMenu(id, name);
        break;
      case 3:
        myDetails(id, name);
        break;
      case 4:
        Runtime.getRuntime().exit(0);
      default:
        System.out.println("Please choose again!");
        break;
    }
    showVendorSubMenu(id, name);
  }

  private void ordersMenu(final int vendorId, final String name) {
    System.out.println();
    System.out.println("Welcome To Your Orders Menu");
    System.out.println("=============================");
    System.out.println("1. View all orders");
    System.out.println("2. View pending orders");
    System.out.println("3. Accept or Deny orders");
    System.out.print("Enter choice:");
    int ch = opt.nextInt();

    switch (ch) {
      case 1:
        orderHistory(vendorId);
        break;
      case 2:
        pendingList(vendorId);
        break;
      case 3:
        acceptDeny(vendorId);
        break;
      default:
        showVendorSubMenu(vendorId, name);
        break;
    }
  }

  private void productsMenu(final int vendorId, final String vendorName) {
    System.out.println();
    System.out.println("Welcome to the Product Menu");
    System.out.println("-----------------------------");
    System.out.println("1. List My Products");
    System.out.println("2. Add a new Product");
    System.out.println("3. Update Price for Product");
    System.out.println("4. Update Quantity");
    System.out.print("Enter your choice: ");
    int ch = opt.nextInt();

    switch (ch) {
      case 1:
        Menu[] list = MenuFactory.listByVendor(vendorId);
        if (list.length > 0) {
          System.out.println("Id  , Description,   Price,   Category");
          for (Menu a : list) {
            System.out.println(
                a.getProductid() + ", " + a.getProductName() + ", " + a.getProductPrice() + ", " + a.getProductCategory());
          }
        } else {
          System.out.println("List Not available.");
        }
        break;
      case 2:
        Menu m = new Menu();
        System.out.print("Product Name: ");
        String name = opt.next();
        System.out.print("Price: ");
        double price = opt.nextDouble();
        System.out.println("Quantity:");
        int qty = opt.nextInt();
        int cat = 1;
        System.out.println("Choose a Category from the list:");
        System.out.println("  1.V ");
        System.out.println("  2. NV");
        System.out.println("  3. BEVERAGE");
        int choice = opt.nextInt();
        switch (choice) {
          case 1:
            cat = 1;
            break;
          case 2:
            cat = 2;
            break;
          case 3:
            cat = 3;
            break;
          default:
            break;
        }

        String msg = m.addProductDetails(vendorId, name, qty, price, cat);
        System.out.println("Enter the path for the image");
        String img = "";
        try {
          img = reader.readLine();
        } catch (IOException e) {
          System.out.println(e);
        }
        try {
          FileInputStream pt = new FileInputStream(img);
          Menu mi = MenuFactory.findLastRow();
          int pid = mi.getProductid();
          int ik = MenuFactory.addProductImage(pid, pt);
          System.out.println(msg);
          if (ik > 0) {
            System.out.println("The image has been successfully added");
          }
        } catch (FileNotFoundException e) {
          System.out.println(e.getMessage());
        }
        break;
      case 3:
        System.out.print("Product Id: ");
        int mId = opt.nextInt();
        updateProductPrice(mId, vendorId);
        break;
      case 4:
        System.out.print("Enter Product Id");
        int pId = opt.nextInt();
        updateProductQuantity(pId, vendorId);
        break;
      default:
        showVendorSubMenu(vendorId, vendorName);
        break;
    }
  }
  private void updateProductPrice(final int id, final int vendorId) {
    int mId = id;

    if (id == 0) {
      Menu[] list = MenuFactory.listByVendor(vendorId);
      if (list.length > 0) {
        System.out.println("Id  , Description,   Price,   Category");
        for (Menu a : list) {
          System.out.println(
              a.getProductid() + ", " + a.getProductName() + ", " + a.getProductPrice() + ", " + a.getProductCategory());
        }
        System.out.print("Product Id: ");
        mId = opt.nextInt();
      } else {
        System.out.println("Add a new Product to List it");
      }
    }
    System.out.println("New Price please: ");
    double price = opt.nextDouble();
    int msg = MenuFactory.updateProductPrice(mId, vendorId, price);
    if (msg > 0) {
      System.out.println("Price Updated on Product");
    } else {
      System.out.println("Sorry! Please try again");
    }
  }
  private void updateProductQuantity(final int id, final int vendorId) {
    int mId = id;

    if (id == 0) {
      Menu[] list = MenuFactory.listByVendor(vendorId);
      if (list.length > 0) {
        System.out.println("Id  , Description,   Quantity,   Category");
        for (Menu a : list) {
          System.out.println(
              a.getProductid() + ", " + a.getProductName() + ", " + a.getProductQuantity() + ", " + a.getProductCategory());
        }
        System.out.print("Product Id: ");
        mId = opt.nextInt();
      } else {
        System.out.println("Add a new Product to List it");
      }
    }
    System.out.println("New Quantity please: ");
    int quantity = opt.nextInt();
    int msg = MenuFactory.updateProductPrice(mId, vendorId, quantity);
    if (msg > 0) {
      System.out.println("Quantity Updated on Product");
    } else {
      System.out.println("Sorry! Please try again");
    }
  }
  private void acceptDeny(final int vendorId) {
    Vendor ve = new Vendor();
    System.out.println("Order Id: ");
    int oId = opt.nextInt();
    SimpleDateFormat sdf = new SimpleDateFormat();
    Date today = new Date();
    String s = sdf.format(today);
    try {
      today = sdf.parse(s);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    if (oId == 0) {
      Order[] list = OrderFactory.showAllPendingOrders(vendorId);

      if (list.length > 0) {
        System.out.println("Id  , Date    , Amount,   Amenity");
        for (Order o: list) {
          double amt = OrderFactory.retrieveOrderAmount(o.getOrderId());
          Menu m = MenuFactory.showProduct(o.getProdId());
          String n = m.getProductName();
          System.out.println(o.getOrderId() + ", " + o.getOrderDate() + ", "
              + amt + ", " + n);
        }
        System.out.print("Please enter Order Id: ");
        oId = opt.nextInt();
      }
    }
    System.out.println("Please specify status [1 -> Accepted, 2 -> Denied]");
    int stat = opt.nextInt();

    String status = "PENDING";
    switch (stat) {
      case 1:
        status = "ACCEPTED";
        break;
      case 2:
        status = "REJECTED";
        break;
      default:
        break;
    }
    double amt = OrderFactory.retrieveOrderAmount(oId);
    String msg = ve.acceptDenyOrder(oId, status, amt);
    System.out.println(msg);
  }

  private void orderHistory(final int id) {
    Order[] history = OrderFactory.vendOrderHistory(id);
    if (history.length > 0) {
      for (Order o : history) {
        System.out.println(o.toString());
      }
    } else {
      System.out.print("No orders are recorded. ");
      System.out.println("Wait some time and check later");
    }
  }

  private void myDetails(final int id, final String name) {
    Vendor ven = VendorFactory.findById(id);

    System.out.println("======================================");
    System.out.println("Welcome " + name);
    System.out.println("1. Show Details");
    System.out.println("2. Update Phone Number");
    System.out.println("3. Update Password");
    System.out.println("Enter choice");
    int ch = opt.nextInt();

    switch (ch) {
      case 1:
        System.out.println();
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + ven.getPhone());
        System.out.println("Email: " + ven.getEmail());
        System.out.println("------------------------------------------");
        System.out.println();
        break;
      case 2:
        System.out.println();
        System.out.print("New Phone Number? ");
        String ph = opt.next();
        while (ph.length() < 10) {
          System.out.println("Phone number too small");
          ph = opt.next();
        }
        String res = ven.updatePhone(id, ph);
        System.out.println(res);
        break;
      case 3:
        System.out.print("Enter Current Password: ");
        String curPass = opt.next();
        System.out.print("Enter New Password: ");
        String pass = opt.next();
        System.out.print("Confirm New Password: ");
        String confirm = opt.next();
        if (curPass.equals(ven.getPassKey()) && !curPass.equals(pass) && pass.equals(confirm)) {
          String str = ven.updatePassword(id, pass);
          System.out.println(str);
        } else {
          System.out.println("Please check your password and try again!");
          myDetails(id, name);
        }
        break;
      default:
        showVendorSubMenu(id, name);
        break;
    }
  }

  private void pendingList(final int id) {
    Order[] pending = OrderFactory.showAllPendingOrders(id);
    if (pending.length > 0) {
      System.out.println("Id  , Date    , Product   , Amount    , Member ");
      System.out.println("-------------------------------------------------");
      for (Order o: pending) {
        //double amt = OrderFactory.retrieveOrderAmount(id);
        Menu m = MenuFactory.showProduct(o.getProdId());
        Customer cu = CustomerFactory.getCustomerById(o.getCustId());
        System.out.println(o.getOrderId() + ", " + o.getOrderDate() + ", " + m.getProductName()
            + ", " + o.getTotalAmt() + ", " + cu.getcName());
      }
    } else {
      System.out.println("No Pending Orders");
    }
  }


}
