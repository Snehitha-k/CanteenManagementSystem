package com.app.persistence;

import java.util.List;
import java.util.Date;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.app.model.Order;
import com.app.model.OrderStatus;

/**
 * DAO class for Orders.
 */
public interface OrderDAO {
  /**
   * addOrder method.
   * To add new orders into orderdetails
   * @param orderId for order id
   * @param custId for customer id
   * @param prodId for product id
   * @param vendorId for vendor id
   * @param orderDate for order date
   * @param totalAmt for order amount
   * @param orderStatus for order status
   * @return list.
*/
  @SqlUpdate("INSERT INTO ORDER_DETAILS (order_id, customer_id, prod_id, vendor_id, order_date, total_amt, order_status)"
      + "VALUES (:ORDER_ID, :CUSTOMER_ID, :PROD_ID, :VENDOR_ID, "
      + "DATE_ADD(:ORDER_DATE, INTERVAL 2 MONTH), :TOTAL_AMT, :ORDER_STATUS)")
  int addOrder(@Bind("ORDER_ID") final int orderId, @Bind("CUSTOMER_ID") final int custId,
       @Bind("PROD_ID") final int prodId, @Bind("VENDOR_ID") final int vendorId,
      @Bind("ORDER_DATE")final Date orderDate, @Bind("TOTAL_AMT") final double totalAmt, @Bind("ORDER_STATUS") final
      OrderStatus orderStatus);
  /**
   * update amount method.
   * @param id order id.
   * @param amt total amount.
   * @return order amount
   */
  @SqlUpdate("UPDATE ORDER_DETAILS SET TOTAL_AMT = :amt WHERE ORDER_ID = :id")
  int updateOrderAmount(@Bind("id") final int id, @Bind("amt") final double amt);
  /**
   * update code method.
   * @param id order id.
   * @param code for coupon code.
   * @return order amount
   */
  @SqlUpdate("UPDATE ORDER_DETAILS SET CODE = :code WHERE ORDER_ID = :id")
  int updateCode(@Bind("id") final int id, @Bind("code") final int code);

  /**
   * list all orders by a customer.
   * @param id member id
   * @return list
   */
  @SqlQuery("SELECT * FROM ORDER_DETAILS WHERE CUSTOMER_ID = :id")
  @Mapper(OrderMapper.class)
  List<Order> custOrderHistory(@Bind("id") final int id);

   /**
   * list all orders serviced by an vendor.
   * @param id employee id
   * @return list
   */
  @SqlQuery("SELECT * FROM ORDER_DETAILS WHERE VENDOR_ID = :id")
  @Mapper(OrderMapper.class)
  List<Order> vendOrderHistory(@Bind("id") final int id);

  /**
   * to get details for a order.
   * @param id for order id
   * @return order object
   */
  @SqlQuery("SELECT * FROM ORDER_DETAILS WHERE ORDER_ID = :id")
  @Mapper(OrderMapper.class)
  Order showOrderDetails(@Bind("id") final int id);

  /**
   * to get the Order amount.
   * @param id for order id
   * @return order amount
   */
  @SqlQuery("SELECT TOTAL_AMT FROM ORDER_DETAILS WHERE ORDER_ID = :id")
  double retrieveOrderAmount(@Bind("id") final int id);
  /**
   * to get the Order date.
   * @param id for order id
   * @return order date
   */
  @SqlQuery("SELECT ORDER_DATE FROM ORDER_DETAILS WHERE ORDER_ID = :id")
  @Mapper(OrderMapper.class)
  Date retrieveOrderDate(@Bind("id") final int id);
  /**
   * to get the Customer id.
   * @param id for order id
   * @return order amount
   */
  @SqlQuery("SELECT CUSTOMER_ID FROM ORDER_DETAILS WHERE ORDER_ID = :id")
  int retrieveCustomerId(@Bind("id") final int id);
  /**
   * to get the first Order id.
   * @param cid for order id
   * @return order amount
   */
  @SqlQuery("SELECT MIN(ORDER_ID) FROM ORDER_DETAILS WHERE CUSTOMER_ID = :cid AND ORDER_STATUS = 'PENDING'")
  int retrieveFirstOrder(@Bind("cid") final int cid);
  /**
   * to get the Customer id.
   * @param id for order id
   * @return order amount
   */
  @SqlQuery("SELECT PROD_ID FROM ORDER_DETAILS WHERE ORDER_ID = :id")
  int retrieveProductId(@Bind("id") final int id);
  /**
   * to check coupon applied ordrers.
   * @param cId for customer id
   * @param code for coupon code
   * @return count
   */
  @SqlQuery("SELECT COUNT(*) FROM ORDER_DETAILS WHERE CUSTOMER_ID = :cId AND CODE = :code")
  int retrieveOrdersByCode(@Bind("cId") final int cId, @Bind("code") final int code);
  /**
   * to get the vendor id.
   * @param id for order id
   * @return order amount
   */
  @SqlQuery("SELECT VENDOR_ID FROM ORDER_DETAILS WHERE ORDER_ID = :id")
  int retrieveVendorId(@Bind("id") final int id);
  /**
   * to get the Ordered count.
   * @param pId for Product id
   * @return order count
   */
  @SqlQuery("SELECT COUNT(*) FROM ORDER_DETAILS WHERE PROD_ID = :pId")
  int orderedProductCount(@Bind("pId") final int pId);
  /**
   * to get the Orders count.
   * @param cId for Customer id
   * @return order count
   */
  @SqlQuery("SELECT COUNT(*) FROM ORDER_DETAILS WHERE CUSTOMER_ID = :cId")
  int orderCount(@Bind("cId") final int cId);
  /**
   * to find the last order id.
   * @return order object
   */
  @SqlQuery("SELECT * FROM ORDER_DETAILS WHERE ORDER_ID = (SELECT MAX(ORDER_ID) FROM ORDER_DETAILS)")
  @Mapper(OrderMapper.class)
  Order findLastRow();

  /**
   * to retrieve all cancelled orders.
   * @param id for vendor id
   * @return list of cancelled bookings
   */
  @SqlQuery("SELECT * FROM ORDER_DETAILS WHERE VENDOR_ID = :id AND ORDER_STATUS = 'CANCELLED'")
  @Mapper(OrderMapper.class)
  List<Order> showAllCancelledOrders(@Bind("id") final int id);

  /**
   * to retrieve all pending orders.
   * @param id for vendor id
   * @return list of cancelled bookings
   */
  @SqlQuery("SELECT * FROM ORDER_DETAILS WHERE VENDOR_ID = :id AND ORDER_STATUS = 'PENDING'")
  @Mapper(OrderMapper.class)
  List<Order> showAllPendingOrders(@Bind("id") final int id);

  /**
   * query to update order status.
   * @param status for order status
   * @param id for order id
   * @return int
   */
  @SqlUpdate("UPDATE ORDER_DETAILS SET ORDER_STATUS = :status WHERE ORDER_ID = :id")
  int updateStatus(@Bind("status") final String status, @Bind("id") final int id);

  /**
   * to get list of current orders.
   * @param id for customer id
   * @return list
   */
  @SqlQuery("SELECT * FROM ORDER_DETAILS WHERE ORDER_DATE = CURRENT_DATE() AND ORDER_STATUS = 'PENDING'"
      + " AND CUSTOMER_ID = :id")
  @Mapper(OrderMapper.class)
  List<Order> listOrdersByToday(@Bind("id") final int id);
}


