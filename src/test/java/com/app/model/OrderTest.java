package com.app.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
//import com.app.factory.OrderFactory;
//import com.app.persistence.OrderDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
//import com.app.model.Order;
import mockit.integration.junit4.JMockit;
import org.junit.runner.RunWith;

import com.app.model.Order;
import com.app.model.OrderStatus;

import org.junit.Test;

/**
 * test class for Order.
 */
@RunWith(JMockit.class)
public class OrderTest {
  private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

  /**
   * test for default constructor.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testOrder() throws ParseException {
    Order b = new Order();
    b.setOrderId(3001);
    b.setOrderDate(sdf.parse("2021-01-10"));
    //b.setProdId(1);
    b.setTotalAmt(2000);
    b.setCustId(119);
    b.setVendorId(1002);
    b.setProdId(4001);
    b.setOrderStatus(OrderStatus.ACCEPTED);

    assertEquals(3001, b.getOrderId());
    assertEquals(sdf.parse("2021-01-10"), b.getOrderDate());
    //assertEquals(1, b.getProdId());
    assertEquals(2000, b.getTotalAmt(), 1);
    assertEquals(119, b.getCustId());
    assertEquals(1002, b.getVendorId());
    assertEquals(4001, b.getProdId());
    assertEquals(OrderStatus.ACCEPTED, b.getOrderStatus());
  }

  /**
   * test for parameterized constructor.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testOrderParameterizedConstructor() throws ParseException {
    Order b = new Order(3001, 101, 201, 301, sdf.parse("2021-01-10"), 140.00, OrderStatus.ACCEPTED);
    assertEquals(3001, b.getOrderId());
    assertEquals(sdf.parse("2021-01-10"), b.getOrderDate());
    assertEquals(140.00, b.getTotalAmt(), 1);
    assertEquals(101, b.getCustId());
    assertEquals(301, b.getVendorId());
    assertEquals(201, b.getProdId());
    assertEquals(OrderStatus.ACCEPTED, b.getOrderStatus());
  }

  /**
   * test for getOrderId.
   * @throws ParseException for parse Exception
   */
  @Test
  public final void testGetOrderId() throws ParseException {
    Order b = new Order(3001, 101, 201, 301, sdf.parse("2021-01-10"), 140, OrderStatus.ACCEPTED);
    assertEquals(3001, b.getOrderId());
  }

  /**
   * test for getOrderDate.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetBookingDate() throws ParseException {
    Order b = new Order(3001, 101, 201, 301, sdf.parse("2021-01-10"), 140, OrderStatus.ACCEPTED);
    assertEquals(sdf.parse("2021-01-10"), b.getOrderDate());
  }

  /**
   * test for getQuantity.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetProdId() throws ParseException {
    Order b = new Order(3001, 101, 201, 301, sdf.parse("2021-01-10"), 140, OrderStatus.ACCEPTED);
    assertEquals(201, b.getProdId());
  }

  /**
   * test for getCustomerId.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetCustId() throws ParseException {
    Order b = new Order(3001, 101, 201, 301, sdf.parse("2021-01-10"), 140, OrderStatus.ACCEPTED);
    assertEquals(101, b.getCustId());
  }
  /**
   * test fot getCode().
   * @throws ParseException for exception
   */
  @Test
  public final void testGetCode() throws ParseException {
    Order b = new Order(3006, 132, 4008, 1216, sdf.parse("2021-03-18"), 500, OrderStatus.PENDING);
    b.setCode(342);
    assertEquals(342, b.getCode());
  }
  /**
   * test for getVendorId.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetVendorId() throws ParseException {
    Order b = new Order(3001, 101, 201, 301, sdf.parse("2021-01-10"), 140, OrderStatus.ACCEPTED);
    assertEquals(301, b.getVendorId());
  }

  /**
   * test for getProductId.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetTotalAmt() throws ParseException {
    Order b = new Order(3001, 101, 201, 301, sdf.parse("2021-01-10"), 140.00, OrderStatus.ACCEPTED);
    assertEquals(140.00, b.getTotalAmt(), 1);
  }

  /**
   * test for getOrderStatus.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetOrderStatus() throws ParseException {
    Order b = new Order(3001, 101, 201, 301, sdf.parse("2021-01-10"), 140, OrderStatus.ACCEPTED);
    assertEquals(OrderStatus.ACCEPTED, b.getOrderStatus());
  }

  // /**
  //  * test for toString.
  //  * @throws ParseException for parse exception
  //  */
  // @Test
  // public final void testToString() throws ParseException {
  //   Order b = new Order(3001, 101, 201, 301, sdf.parse("2021-01-10"), 140, OrderStatus.ACCEPTED);
  //   assertEquals
  // }

  // /**
  //  * test for getTotalAmount.
  //  * @throws ParseException for parse exception
  //  */
  // @Test
  // public final void testGetTotalAmt() throws ParseException {
  //   Order b = new Order(3001, 132, 4002, 1216, sdf.parse("2021-01-10"), 520, OrderStatus.ACCEPTED);
  //   b.setTotalAmt(520);
  //   assertEquals(520, b.getTotalAmt(), 1);
  // }

  /**
   * test for hashCode.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testHashCode() throws ParseException {
    Order b1 = new Order(3001, 101, 201, 301, sdf.parse("2021-01-10"), 140, OrderStatus.ACCEPTED);
    Order b2 = new Order(3001, 101, 201, 301, sdf.parse("2021-01-10"), 140, OrderStatus.ACCEPTED);
    Order b3 = new Order(3004, 102, 201, 305, sdf.parse("2021-03-12"), 180, OrderStatus.CANCELLED);

    assertEquals(b1.hashCode(), b2.hashCode());
    assertNotEquals(b1.hashCode(), b3.hashCode());
    assertNotEquals(b2.hashCode(), b3.hashCode());
  }

  /**
   * test for equals.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testEquals() throws ParseException {
    Order b1 = new Order(3001, 101, 201, 301, sdf.parse("2021-01-10"), 140, OrderStatus.ACCEPTED);
    Order b2 = new Order(3001, 101, 201, 301, sdf.parse("2021-01-10"), 140, OrderStatus.ACCEPTED);
    Order b3 = new Order(3004, 102, 201, 305, sdf.parse("2021-12-05"), 160, OrderStatus.CANCELLED);

    assertTrue(b1.equals(b2));
    assertFalse(b1.equals(b3));
    assertFalse(b2.equals(b3));
    assertFalse(b1.equals(null));
  }
  /**
   * test for addOrder.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testAddOrder() throws ParseException {
    Order b = new Order();
    String res = b.addOrder(3001, 101, 201, 301, sdf.parse("2021-01-10"), 140, OrderStatus.PENDING);
    assertEquals("added successfully!", res);
  }
}
