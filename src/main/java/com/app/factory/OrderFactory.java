package com.app.factory;

import java.util.List;

import com.app.model.Order;
import com.app.model.OrderStatus;
import com.app.persistence.DbConnection;
import com.app.persistence.OrderDAO;

import java.util.Date;

/**
 * Factory class for Order.
 */
public class OrderFactory {
  /**
   * protected constructor.
   */
  protected OrderFactory() {

  }

  /**
   * dao method.
   * @return OrderDAO
   */
  private static OrderDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrderDAO.class);
  }

  /**
   * to get the last row.
   * @return Order
   */
  public static Order findLastRow() {
    Order o = dao().findLastRow();
    return o;
  }

  /**
   * to place an order.
   * To add new orders into orderdetails
   * @param argOrderId for order id
   * @param argCustId for customer id
   * @param argProdId for product id
   * @param argVendorId for vendor id
   * @param argOrderDate for order date
   * @param argTotalAmt for order amount
   * @param argOrderStatus for order status
   * @return int
   */
  public static int addOrder(final int argOrderId, final int argCustId, final int argProdId, final int argVendorId,
      final Date argOrderDate, final double argTotalAmt, final OrderStatus argOrderStatus) {
    int res = dao().addOrder(argOrderId, argCustId, argProdId, argVendorId, argOrderDate, argTotalAmt, argOrderStatus);
    return res;
  }

  /**
   * to update order amount.
   * @param id for order id
   * @param amt for order amount
   * @return int
   */
  public static int updateOrderAmount(final int id, final double amt) {
    int res = dao().updateOrderAmount(id, amt);
    return res;
  }
  /**
   * to update coupon code.
   * @param id for order id
   * @param code for coupon code
   * @return int
   */
  public static int updateCode(final int id, final int code) {
    int res = dao().updateCode(id, code);
    return res;
  }

  /**
   * return a list of previous Orders for a member.
   * @param memId for member id
   * @return array
   */
  public static Order[] custOrderHistory(final int memId) {
    List<Order> list = dao().custOrderHistory(memId);
    return list.toArray(new Order[list.size()]);
  }

  /**
   * return list of Orders handled by an vendor.
   * @param vendId for vendor id
   * @return array
   */
  public static Order[] vendOrderHistory(final int vendId) {
    List<Order> list = dao().vendOrderHistory(vendId);
    return list.toArray(new Order[list.size()]);
  }

  /**
   * to list all cancelled orders.
   * @param id for order id
   * @return array
   */
  public static Order[] showAllCancelledOrders(final int id) {
    List<Order> list = dao().showAllCancelledOrders(id);
    return list.toArray(new Order[list.size()]);
  }
  /**
   * to list all pending orders.
   * @param id for order id
   * @return array
   */
  public static Order[] showAllPendingOrders(final int id) {
    List<Order> list = dao().showAllPendingOrders(id);
    return list.toArray(new Order[list.size()]);
  }

  /**
   * to update status of order.
   * @param id for order id
   * @param stat for status
   * @return int
   */
  public static int updateStatus(final int id, final String stat) {
    int res = dao().updateStatus(stat, id);
    return res;
  }

  /**
   * to retrieve the order amount.
   * @param id for order id
   * @return double
   */
  public static double retrieveOrderAmount(final int id) {
    double amt = dao().retrieveOrderAmount(id);
    return amt;
  }
  /**
   * to retrieve the order date.
   * @param id for order id
   * @return date
   */
  public static Date retrieveOrderDate(final int id) {
    Date dt = dao().retrieveOrderDate(id);
    return dt;
  }
  /**
   * to retrieve the first order.
   * @param cId for customer id
   * @return double
   */
  public static int retrieveFirstOrder(final int cId) {
    int oid = dao().retrieveFirstOrder(cId);
    return oid;
  }
  /**
   * to retrieve the customer id.
   * @param id for order id.
   * @return int
   */
  public static int retrieveCustomerId(final int id) {
    int cusId = dao().retrieveCustomerId(id);
    return cusId;
  }
  /**
   * to retrieve the Product id.
   * @param id for order id.
   * @return int
   */
  public static int retrieveProductId(final int id) {
    int proId = dao().retrieveProductId(id);
    return proId;
  }
  /**
   * to retrieve the orders where coupon applied.
   * @param cId for customer id.
   * @param code for coupon code.
   * @return int
   */
  public static int retrieveOrdersByCode(final int cId, final int code) {
    int ccode = dao().retrieveOrdersByCode(cId, code);
    return ccode;
  }
  /**
   * to retrieve the Count of ordered products.
   * @param pId for order id.
   * @return int
   */
  public static int orderedProductCount(final int pId) {
    int oProId = dao().orderedProductCount(pId);
    return oProId;
  }
  /**
   * to retrieve the Count of ordered products.
   * @param cId for customer id.
   * @return int
   */
  public static int orderCount(final int cId) {
    int countorder = dao().orderCount(cId);
    return countorder;
  }
/**
 * to retrieve the Vendor id.
 * @param id for order id.
 * @return int
 */
  public static int retrieveVendorId(final int id) {
    int venId = dao().retrieveVendorId(id);
    return venId;
  }
  /**
   * to get the details of a particular Order.
   * @param id for Order id
   * @return Order object
   */
  public static Order showOrderDetails(final int id) {
    Order o = dao().showOrderDetails(id);
    return o;
  }

/**
   * to get current orders.
   * @param id for member id or vendor id
   * @return array
   */
  public static Order[] listCurrentOrders(final int id) {
    List<Order> list = dao().listOrdersByToday(id);
    return list.toArray(new Order[list.size()]);
  }
}
