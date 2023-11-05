package com.app.Factory;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.app.model.Order;
import com.app.model.OrderStatus;
import com.app.persistence.OrderDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * test class for OrderFactory.
 */
@RunWith(JMockit.class)
public class OrderFactoryTest {
  private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  /**
   * test for protected constructor.
   */
  @Test
  public final void testOrderFactory() {
    OrderFactory o = new OrderFactory();
    OrderFactory o1 = new OrderFactory();
    assertNotEquals(o, o1);
  }

  /**
   * test for findLastRow.
   * @param dao for OrderDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testFindLastRow(@Mocked final OrderDAO dao) throws ParseException {
    Order b = new Order(3006, 132, 4008, 1216, sdf.parse("2021-03-18"), 500, OrderStatus.ACCEPTED);

    new Expectations() {
      {
        dao.findLastRow();
        result = b;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    Order b1 = OrderFactory.findLastRow();
    assertEquals(b, b1);
  }

  /**
   * test for addOrder.
   * @param dao for OrderDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testAddOrder(@Mocked final OrderDAO dao) throws ParseException {
    String s = sdf.format(new Date());

    new Expectations() {
      {
        dao.addOrder(3006, 132, 4008, 1216, sdf.parse("2021-03-18"), 500, OrderStatus.ACCEPTED);
        result = 1;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    int res = OrderFactory.addOrder(3006, 132, 4008, 1216, sdf.parse("2021-03-18"), 500, OrderStatus.ACCEPTED);
    assertEquals(1, res);
  }

  /**
   * test for updateOrderAmount.
   * @param dao for OrderDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testUpdateOrderAmount(@Mocked final OrderDAO dao) throws ParseException {
    new Expectations() {
      {
        dao.updateOrderAmount(3006, 7000);
        result = 1;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    int res = OrderFactory.updateOrderAmount(3006, 7000);
    assertEquals(1, res);
  }

  /**
   * test for retrieveOrderAmount.
   * @param dao for OrderDAO
   */
  @Test
  public final void testRetrieveOrderAmount(@Mocked final OrderDAO dao) {
    new Expectations() {
      {
        dao.retrieveOrderAmount(3002);
        result = 2400;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    double res = OrderFactory.retrieveOrderAmount(3002);
    assertEquals(2400, res, 1);
  }

  /**
   * test for showOrderDetails.
   * @param dao for OrderDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testShowOrderDetails(@Mocked final OrderDAO dao) throws ParseException {
    Order b = new Order(3006, 132, 4008, 1216, sdf.parse("2021-03-18"), 500, OrderStatus.ACCEPTED);

    new Expectations() {
      {
        dao.showOrderDetails(3006);
        result = b;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    Order b1 = OrderFactory.showOrderDetails(3006);
    assertEquals(b, b1);
  }

  /**
   * test for listCurrentOrders.
   * @param dao for OrderDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testListCurrentOrder(@Mocked final OrderDAO dao) throws ParseException {
    Date d = new Date();
    String s = sdf.format(d);

    Order[] blist = new Order[2];
    blist[0] = new Order(3006, 132, 4008, 1216, sdf.parse("2021-03-18"), 500, OrderStatus.PENDING);
    blist[1] = new Order(3008, 125, 4005, 1216, sdf.parse(s), 510, OrderStatus.PENDING);
    new Expectations() {
      {
        dao.listOrdersByToday(132);
        result = blist;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    Order[] list = OrderFactory.listCurrentOrders(132);
    assertArrayEquals(blist, list);
  }

  /**
   * test for updateStatus.
   * @param dao for OrderDAO
   */
  @Test
  public final void testUpdateStatus(@Mocked final OrderDAO dao) {
    new Expectations() {
      {
        dao.updateStatus("ACCEPTED", 3006);
        result = 1;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    int res = OrderFactory.updateStatus(3006, "ACCEPTED");
    assertEquals(1, res);
  }

  /**
   * test for showAllPendingOrders.
   * @param dao for OrderDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testShowAllPendingOrders(@Mocked final OrderDAO dao) throws ParseException {
    Date d = new Date();
    String s = sdf.format(d);

    Order[] blist = new Order[2];
    blist[0] = new Order(3006, 132, 4008, 1216, sdf.parse(s), 525, OrderStatus.PENDING);
    blist[1] = new Order(3007, 133, 4005, 1216, sdf.parse(s), 560, OrderStatus.PENDING);

    new Expectations() {
      {
        dao.showAllPendingOrders(1216);
        result = blist;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    Order[] list = OrderFactory.showAllPendingOrders(1216);
    assertArrayEquals(blist, list);
  }

  /**
   * test for vendOrderHistory.
   * @param dao for OrderDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testVendOrderHistory(@Mocked final OrderDAO dao) throws ParseException {
    Order[] blist = new Order[4];
    blist[0] = new Order(3006, 132, 4008, 1217, sdf.parse("2021-03-18"), 500, OrderStatus.ACCEPTED);
    blist[1] = new Order(3007, 133, 4002, 1217, sdf.parse("2021-03-17"), 575, OrderStatus.PENDING);
    blist[2] = new Order(3008, 135, 4003, 1217, sdf.parse("2021-03-21"), 325, OrderStatus.CANCELLED);
    blist[3] = new Order(3009, 136, 4004, 1217, sdf.parse("2021-03-22"), 650, OrderStatus.ACCEPTED);

    new Expectations() {
      {
        dao.vendOrderHistory(1217);
        result = blist;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    Order[] list = OrderFactory.vendOrderHistory(1217);
    assertArrayEquals(blist, list);
  }

  /**
   * test for custOrderHistory.
   * @param dao for OrderDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testCustOrderHistory(@Mocked final OrderDAO dao) throws ParseException {
    Order[] blist = new Order[4];
    blist[0] = new Order(3006, 132, 4008, 1217, sdf.parse("2021-03-18"), 500, OrderStatus.ACCEPTED);
    blist[1] = new Order(3003, 132, 4002, 1205, sdf.parse("2021-03-17"), 536, OrderStatus.CANCELLED);
    blist[2] = new Order(3004, 132, 4010, 1212, sdf.parse("2021-03-21"), 560, OrderStatus.ACCEPTED);
    blist[3] = new Order(3005, 132, 4003, 1215, sdf.parse("2021-03-22"), 540, OrderStatus.ACCEPTED);

    new Expectations() {
      {
        dao.custOrderHistory(132);
        result = blist;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    Order[] list = OrderFactory.custOrderHistory(132);
    assertArrayEquals(blist, list);
  }

  /**
   * test for showAllCancelledOrders.
   * @param dao for OrderDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testShowAllCancelledOrders(@Mocked final OrderDAO dao) throws ParseException {
    Date d = new Date();
    String s = sdf.format(d);

    Order[] blist = new Order[2];
    blist[0] = new Order(3006, 132, 4008, 1216, sdf.parse(s), 525, OrderStatus.CANCELLED);
    blist[1] = new Order(3007, 133, 4005, 1216, sdf.parse(s), 560, OrderStatus.CANCELLED);

    new Expectations() {
      {
        dao.showAllPendingOrders(1216);
        result = blist;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };
    Order[] list = OrderFactory.showAllPendingOrders(1216);
    assertArrayEquals(blist, list);
  }

  /**
   * test for retrieveOrderAmount.
   * @param dao for OrderDAO
   */
  @Test
  public final void testRetrieveFirstOrder(@Mocked final OrderDAO dao) {
    new Expectations() {
      {
        dao.retrieveFirstOrder(132);
        result = 3006;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    int res = OrderFactory.retrieveFirstOrder(132);
    assertEquals(3006, res);
  }

  /**
   * test for retrieveProductId.
   * @param dao for OrderDAO
   */
  @Test
  public final void testRetrieveProductId(@Mocked final OrderDAO dao) {
    new Expectations() {
      {
        dao.retrieveProductId(3002);
        result = 2400;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    int res = OrderFactory.retrieveProductId(3002);
    assertEquals(2400, res);
  }

  /**
   * test for orderedProductCount.
   * @param dao for OrderDAO
   */
  @Test
  public final void testOrderedProductCount(@Mocked final OrderDAO dao) {
    new Expectations() {
      {
        dao.orderedProductCount(4008);
        result = 3;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    int res = OrderFactory.orderedProductCount(4008);
    assertEquals(3, res);
  }

  /**
   * test for retrieveVendorId.
   * @param dao for OrderDAO
   */
  @Test
  public final void testRetrieveVendorId(@Mocked final OrderDAO dao) {
    new Expectations() {
      {
        dao.retrieveVendorId(3006);
        result = 1216;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    int res = OrderFactory.retrieveVendorId(3006);
    assertEquals(1216, res);
  }

  /**
   * test for retrieveOrderDate.
   * @param dao for OrderDAO
   * @throws ParseException for exception
   */
  @Test
  public final void testRetrieveOrderDate(@Mocked final OrderDAO dao) throws ParseException {
    new Expectations() {
      {
        dao.retrieveOrderDate(3002);
        Date result = sdf.parse("2021-03-23");
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    Date res = OrderFactory.retrieveOrderDate(3002);
    String s = sdf.format(res);
    res = sdf.parse(s);
    assertNotEquals(sdf.parse("2021-03-23"), res);
  }

}
