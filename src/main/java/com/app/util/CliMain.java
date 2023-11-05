package com.app.util;
import java.util.Scanner;
//import com.app.factory.MenuFactory;
//import com.app.model.Menu;
/**
 * CliMain used as Client interface for java coading.

 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
/**
 * mainMenu method  used to display the option we had in the application.
 */
  private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("-----------------------");
    System.out.println("1. CUSTOMER ");
    System.out.println("2. VENDOR");
    System.out.println("3.EXIT");
    mainMenuDetails();
  }
/**
 * mainMenuDetails method  process the option selected from main menu.
 */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          CustomerUtil cu = new CustomerUtil();
          cu.customerMenu();
          break;
        case 2:
          VendorUtil vu = new VendorUtil();
          vu.vendorMenu();
          break;
        case 3:
          Runtime.getRuntime().halt(0);
        default :
          System.out.println("WRONG CHOICE");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }
/**
 * showFullMenu method  display the menu item stored in database.
 */
  // private void showFullMenu() {
  //   Menu[] menu = MenuFactory.showMenu();
  //   System.out.println("Menu_Id");
  //   for (Menu m : menu) {
  //     System.out.println(m.getProductId());
  //   }
  // }
/**
 * main method  is the basic entry point for the application.
 * @param args used to get the user input.
 */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
