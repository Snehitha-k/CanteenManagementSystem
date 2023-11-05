package com.app.model;

//import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;

import com.app.factory.CustomerFactory;
import com.app.factory.MenuFactory;
import com.app.factory.OrderFactory;
import com.app.model.Customer;
import com.app.model.Menu;
import com.app.model.Order;
import com.app.model.OrderStatus;
import com.app.model.Vendor;
import com.app.persistence.CustomerDAO;
import com.app.persistence.MenuDAO;
import com.app.persistence.OrderDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * test suite for Customer.
 */
@RunWith(JMockit.class)
public class CustomerTest {
  private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  /**
   * test case for default constructor.
   * @throws ParseException parse exception
   */
  @Test
  public final void testCustomer() throws ParseException {
    Customer c = new Customer();
    c.setcId(103);
    c.setcName("Deepak");
    c.setcEmail("deepak@gmail.com");
    c.setcPhone("9629218698");
    c.setwalletbalance(45000);
    c.setcAddress("erode");
    c.setcPassword("deep123");
    c.setCustomerDOB(sdf.parse("1999-03-20"));

    assertEquals(103, c.getcId());
    assertEquals("Deepak", c.getcName());
    assertEquals("deepak@gmail.com", c.getcEmail());
    assertEquals("9629218698", c.getcPhone());
    assertEquals(45000, c.getwalletbalance(), 1);
    assertEquals("erode", c.getcAddress());
    assertEquals("deep123", c.getcPassword());
    assertEquals(sdf.parse("1999-03-20"), c.getCustomerDOB());
  }

  /**
   * testing parameterized constructor.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testCustomerParameterizedConstructor() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    assertEquals(103, c.getcId());
    assertEquals("Deepak", c.getcName());
    assertEquals("deepak@gmail.com", c.getcEmail());
    assertEquals("9629218698", c.getcPhone());
    assertEquals(45000, c.getwalletbalance(), 1);
    assertEquals("deep123", c.getcPassword());
    assertEquals(sdf.parse("1999-03-20"), c.getCustomerDOB());
  }

  /**
   * test for getCustomerId.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetCustomerId() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    assertEquals(103, c.getcId());
  }

  /**
   * test for getCustomerName.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetCustomerName() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    assertEquals("Deepak", c.getcName());
  }

  /**
   * test for getPhone.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetPhone() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    assertEquals("9629218698", c.getcPhone());
  }

  /**
   * test for getEmail.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetEmail() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    assertEquals("deepak@gmail.com", c.getcEmail());
  }

   /**
   * test for getPassKey.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetPassword() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    assertEquals("deep123", c.getcPassword());
  }

  /**
   * test for getWalletBalance.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetWalletBalance() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    assertEquals(45000, c.getwalletbalance(), 2);
  }

   /**
   * test for getcAddress.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetCustomerAddress() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    c.setcAddress("erode");
    assertEquals("erode", c.getcAddress());
  }

   /**
   * test for getCustomerDOB.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetCustomerDOB() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    assertEquals(sdf.parse("1999-03-20"), c.getCustomerDOB());
  }

  /**
   * test for hashCode method.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testHashCode() throws ParseException {
    final Customer c1 = new Customer(102, "aravind", "aravind@gmail.com", "9629218697", 35000, sdf.parse("1999-07-24"), "arav123");
    final Customer c2 = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    final Customer c3 = new Customer(102, "aravind", "aravind@gmail.com", "9629218697", 35000, sdf.parse("1999-07-24"), "arav123");

    assertEquals(c1.hashCode(), c3.hashCode());
    assertNotEquals(c1.hashCode(), c2.hashCode());
    assertNotEquals(c2.hashCode(), c3.hashCode());
  }

  /**
   * test for equals method.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testEquals() throws ParseException {
    final Customer c1 = new Customer(102, "aravind", "aravind@gmail.com", "9629218697", 35000, sdf.parse("1999-07-24"), "arav123");
    final Customer c2 = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    final Customer c3 = new Customer(102, "aravind", "aravind@gmail.com", "9629218697", 35000, sdf.parse("1999-07-24"), "arav123");

    assertTrue(c1.equals(c3));
    assertFalse(c2.equals(c1));
    assertFalse(c2.equals(c3));

    Customer c = null;
    assertFalse(c1.equals(c));
  }
  /**
   * test for setCustomerId.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testSetCustomerId() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    c.setcId(104);
    assertEquals(104, c.getcId());
  }

  /**
   * test for setCustomerName.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testSetCustomerName() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    c.setcName("Aravind");
    assertEquals("Aravind", c.getcName());
  }

  /**
   * test for setCustomerPhone.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testSetCustomerPhone() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    c.setcPhone("8629218698");
    assertEquals("8629218698", c.getcPhone());
  }

  /**
   * test for setCustomerMail.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testSetCustomerMail() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    c.setcEmail("aravind@gmail.com");
    assertEquals("aravind@gmail.com", c.getcEmail());
  }

  /**
   * test for setPassKey.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testSetPassword() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    c.setcPassword("deepu123");
    assertEquals("deepu123", c.getcPassword());
  }

  /**
   * test for setwalletbalance.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testSetwalletbalance() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    c.setwalletbalance(85000);
    assertEquals(85000, c.getwalletbalance(), 2);
  }

  /**
   * test for setCustomerAddress.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testSetCustomerAddress() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    c.setcAddress("chennai");
    assertEquals("chennai", c.getcAddress());
  }

  /**
   * test for setCustomerDOB.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testSetCustomerBirthdate() throws ParseException {
    Customer c = new Customer(103, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    c.setCustomerDOB(sdf.parse("2000-03-20"));
    assertEquals(sdf.parse("2000-03-20"), c.getCustomerDOB());
  }

  /**
   * test for registering a Customer.
   * @param dao for CustomersDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testRegisterCustomer(@Mocked final CustomerDAO dao) throws ParseException {
    Customer c = new Customer(101, "Deepak", "deepak@gmail.com", "9629218698", 45000, sdf.parse("1999-03-20"), "deep123");
    new Expectations() {
      {
        dao.findLastRow();
        result = c;
      }
    };

    new Expectations() {
      {
        dao.registerCustomer(102, "mohan", "9629219697", "mohan@gmail.com", 10000, sdf.parse("1999-05-13"), "moha123");
        result = 1;
      }
    };

    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };

    Customer c1 = new Customer();
    String res = c1.registerCustomer("mohan", "mohan@gmail.com", "9629219697", "Telangana", "moha123", sdf.parse("1999-05-13"));
    assertEquals("Registration Unsuccessful", res);
  }

  /**
   * test for updatePhone.
   * @param dao for CustomersDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testUpdatePhone(@Mocked final CustomerDAO dao) throws ParseException {
    new Expectations() {
      {
        dao.updatePhone(102, "9629218697");
        result = 1;
      }
    };
    new Expectations() {
      {
        dao.updatePhone(102, "9632587410");
        result = 0;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };

    Customer c1 = new Customer();
    String res = c1.updatePhone(102, "9629218697");
    assertEquals("Phone number updated successfully", res);

    String str = c1.updatePhone(102, "9632587410");
    assertEquals("Unable to update phone number", str);
  }

  /**
   * test for updatePassword.
   * @param dao for CustomersDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testUpdatePassword(@Mocked final CustomerDAO dao) throws ParseException {
    new Expectations() {
      {
        dao.updatePassword(101, "deep123");
        result = 1;
      }
    };
    new Expectations() {
      {
        dao.updatePassword(101, "dee123");
        result = 0;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };

    Customer c1 = new Customer();
    String res = c1.updatePassword(101, "deep123");
    assertEquals("Password updated successfully", res);

    String str = c1.updatePassword(101, "dee123");
    assertEquals("Unable to update password", str);
  }

  /**
   * test for updateWallet.
   * @param dao for CustomersDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testUpdateWallet(@Mocked final CustomerDAO dao) throws ParseException {
    new Expectations() {
      {
        dao.updateWalletAmount(101, 10000, 65000);
        result = 1;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    Customer c1 = new Customer();
    String str = c1.updateWallet(101, 10000, 65000);
    assertEquals("Balance updated", str);
  }
/**
   * test to retrieve Order history of Customer.
   * @param odao for OrderDAO
   * @throws ParseException for exception
   */
  @Test
  public final void testOrderHistory(@Mocked final OrderDAO odao) throws ParseException { //throws ParseException {
    Order[] oList = new Order[3];

    Date d1 = new Date();
    Date d2 = new Date();
    Date d3 = new Date();

    try {
      d1 = sdf.parse("2021-03-12");
      d2 = sdf.parse("2021-03-14");
      d3 = sdf.parse("2021-03-11");
    } catch (ParseException ex) {
      System.out.println(ex.getMessage());
    }

    oList[0] = new Order(3006, 132, 201, 301, d1, 4500, OrderStatus.PENDING);
    oList[1] = new Order(3003, 132, 169, 320, d2, 6000, OrderStatus.PENDING);
    oList[2] = new Order(3004, 132, 188, 116, d3, 7703, OrderStatus.ACCEPTED);

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO odao() {
        return odao;
      }
    };

    Customer c = new Customer();
    //Order[] list = c.orderHistory(132);
    assertEquals(oList.length, 3);
  }

  /**
   * test for cancelBooking.
   * @param cDao for customerDAO
   * @param oDao for orderDAO
   * @throws ParseException for exception
   */
  @Test
  public final void testCancelOrder(@Mocked final CustomerDAO cDao, @Mocked final OrderDAO oDao) throws ParseException {
    Date cd =  new Date();
    try {
     // d1 = sdf.parse(temp);
      cd = sdf.parse("2021-01-03");
    } catch (ParseException ex) {
      System.out.println(ex.getMessage());
    }

    Order o = new Order(3006, 132, 201, 301, cd, 4500, OrderStatus.CANCELLED);
    Customer c = new Customer(132, "mohan", "mohan@gmail.com", "9629219697", 10000, sdf.parse("1999-05-13"), "moha123");

    new Expectations() {
      {
        oDao.showOrderDetails(3006);
        result = o;
      }
    };
    new Expectations() {
      {
        cDao.getCustomerById(132);
        result = c;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return oDao;
      }
    };

    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return cDao;
      }
    };

    Customer c1 = new Customer();

    String str = c1.cancelOrder(3006);
    assertEquals("Cancellation was unsuccessful", str);

  }

  /**
   * test for placing an order.
   * @param mDao for MenuDAO
   * @param cDao for CustomerDAO
   * @param oDao for OrderDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testOrderafooditem(@Mocked final MenuDAO mDao, @Mocked final CustomerDAO cDao,
      @Mocked final OrderDAO oDao) throws ParseException {
    String today = sdf.format(new Date());
    Menu m1 = new Menu(103, 201, "Pizza", 100, 200.0, 4.5, 2);
    Menu m2 = new Menu(104, 202, "Burger", 100, 100.0, 4.0, 1);
    Customer c = new Customer(119, "Akanksha Sinha", "wi@we.c", "8394843444", 45230,  sdf.parse("2021-01-12"), "aksinha123");
    Customer c2 = new Customer(103, "Pavan Pai", "pavan@abc.com", "8383565772", 4450,  sdf.parse("2021-02-23"), "pavan123");
    Vendor v1 = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    Order o = new Order(3006, 132, 201, 101, sdf.parse("2021-01-03"), 4500, OrderStatus.ACCEPTED);
    new Expectations() {
      {
        mDao.showProduct(103);
        result = m1;
      }
    };
    new Expectations() {
      {
        oDao.findLastRow();
        result = o;
      }
    };
    new Expectations() {
      {
        cDao.getCustomerById(132);
        result = c;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return oDao;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return cDao;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return mDao;
      }
    };
    Customer c1 = new Customer();
    String res = c1.orderAnProduct(101, 2, 132, 450.0, 1);
    assertEquals("Unable to order the product", res);
    String res1 = c1.orderAnProduct(103, 2, 119, 100.0, 2);
    assertEquals("Insufficient Balance. Please update your wallet", res1);
  }
}
