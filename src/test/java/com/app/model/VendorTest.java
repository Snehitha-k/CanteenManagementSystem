package com.app.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.app.factory.CustomerFactory;
import com.app.factory.OrderFactory;
import com.app.factory.VendorFactory;
import com.app.model.Customer;
import com.app.model.Order;
import com.app.model.OrderStatus;
import com.app.model.Vendor;
import com.app.persistence.CustomerDAO;
import com.app.persistence.OrderDAO;
import com.app.persistence.VendorDAO;

import java.util.Date;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * test suite for vendor.
 */
@RunWith(JMockit.class)
public class VendorTest {
  /**
   * test case for default constructor.
   */
  @Test
  public final void testVendor() {
    Vendor v = new Vendor();
    v.setVendorId(101);
    v.setPassKey("dee123");
    v.setVendorName("Deepak");
    v.setPhone("9629218696");
    v.setEmail("deepak@gmail.com");
    assertEquals(101, v.getVendorId());
    assertEquals("Deepak", v.getVendorName());
    assertEquals("deepak@gmail.com", v.getEmail());
    assertEquals("9629218696", v.getPhone());
    assertEquals("dee123", v.getPassKey());
  }
    /**
   * testing parameterized constructor.
   */
  @Test
  public final void testVendorParameterizedConstructor() {
    Vendor v = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    assertEquals(101, v.getVendorId());
    assertEquals("Deepak", v.getVendorName());
    assertEquals("deepak@gmail.com", v.getEmail());
    assertEquals("9629218696", v.getPhone());
    assertEquals("dee123", v.getPassKey());
  }
  /**
   * test for getVendorId.
   */
  @Test
  public final void testGetVendorId() {
    Vendor v = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    assertEquals(101, v.getVendorId());
  }

  /**
   * test for getVendorName.
   */
  @Test
  public final void testGetVendorName() {
    Vendor v = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    assertEquals("Deepak", v.getVendorName());
  }

  /**
   * test for getEmail.
   */
  @Test
  public final void testGetEmail() {
    Vendor v = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    assertEquals("deepak@gmail.com", v.getEmail());
  }

  /**
   * test for getPhone.
   */
  @Test
  public final void testGetPhone() {
    Vendor v = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    assertEquals("9629218696", v.getPhone());
  }

  /**
   * test for getPassKey.
   */
  @Test
  public final void testGetPassKey() {
    Vendor v = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    assertEquals("dee123", v.getPassKey());
  }

  /**
   * test for hashCode.
   */
  @Test
  public final void testHashCode() {
    Vendor v1 = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    Vendor v2 = new Vendor(102, "ara123", "Aravind", "9629214526", "aravind@gmail.com");
    Vendor v3 = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");

    assertEquals(v1.hashCode(), v3.hashCode());
    assertNotEquals(v1.hashCode(), v2.hashCode());
    assertNotEquals(v2.hashCode(), v3.hashCode());
  }

  /**
   * test for equals.
   */
  @Test
  public final void testEquals() {
    Vendor v1 = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    Vendor v2 = new Vendor(102, "ara123", "Aravind", "9629214526", "aravind@gmail.com");
    Vendor v3 = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");

    assertTrue(v1.equals(v3));
    assertFalse(v1.equals(v2));
    assertFalse(v2.equals(v3));

    Vendor v = null;
    assertFalse(v1.equals(v));
  }
  /**
   * test for setVendorId.
   */
  @Test
  public final void testSetVendorId() {
    Vendor v1 = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    v1.setVendorId(102);
    assertEquals(102, v1.getVendorId());
  }
  /**
   * test for setPassKey.
   */
  @Test
  public final void testSetPassKey() {
    Vendor v1 = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    v1.setPassKey("ara123");
    assertEquals("ara123", v1.getPassKey());
  }
  /**
   * test for setVendorName.
   */
  @Test
  public final void testSetVendorName() {
    Vendor v1 = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    v1.setVendorName("Aravind");
    assertEquals("Aravind", v1.getVendorName());
  }
  /**
   * test for setPhone.
   */
  @Test
  public final void testSetPhone() {
    Vendor v1 = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    v1.setPhone("9629218697");
    assertEquals("9629218697", v1.getPhone());
  }
  /**
   * test for setEmail.
   */
  @Test
  public final void testSetEmail() {
    Vendor v1 = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    v1.setEmail("aravind@gmail.com");
    assertEquals("aravind@gmail.com", v1.getEmail());
  }
  /**
   * test for registerVendor.
   * @param dao for VendorDAO
   */
  @Test
  public final void testregisterVendor(@Mocked final VendorDAO dao) {
    Vendor v1 = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");

    new Expectations() {
      {
        dao.findLastRow();
        result = v1;
      }
    };

    new Expectations() {
      {
        dao.registerVendor(102, "ara123", "Aravind", "9632587410", "aravind@gmail.com");
        result = 1;
      }
    };

    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    Vendor a = new Vendor();
    String res = a.registerVendor("ara123", "Aravind", "9632587410", "aravind@gmail.com");
    assertEquals("Registration Successful!", res);
  }
  /**
   * test for updatePhone.
   * @param dao for VendorDAO
   */
  @Test
  public final void testupdatePhone(@Mocked final VendorDAO dao) {
    new Expectations() {
      {
        dao.updatePhone(101, "9629218696");
        result = 1;
      }
    };
    new Expectations() {
      {
        dao.updatePhone(101, "9632587");
        result = 0;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    Vendor p = new Vendor();
    String res = p.updatePhone(101, "9629218696");
    String phone = p.updatePhone(101, "9632587");
    assertEquals("Phone number updated successfully.", res);
    assertEquals("Unable to update phone! Please try again.", phone);
  }
  /**
   * test for updatePassword.
   * @param dao for VendorDAO
   */
  @Test
  public final void testupdatePassword(@Mocked final VendorDAO dao) {
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
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    Vendor pa = new Vendor();
    String pass = pa.updatePassword(101, "dee123");
    String res = pa.updatePassword(101, "deep123");
    assertEquals("Password updated successfully", res);
    assertEquals("Unable to update password! please try again", pass);
  }
  /**
   * test for acceptDenyOrder method.
   * @param cDao for CustomerDAO
   * @param oDao for OrderDAO
   * @throws ParseException for date
   */
  @Test
  public final void testAcceptDenyOrder(@Mocked final CustomerDAO cDao, @Mocked final OrderDAO oDao) throws ParseException {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    Customer c = new Customer(201, "Sathya", "sathya@gmail.com", "1234567890", 100000, sd.parse("2000-01-21"), "sath123");
    String s = sd.format(new Date());

    final Order o = new Order(3001, 201, 101, 109, sd.parse("2020-11-21"), 1000, OrderStatus.PENDING);
    final Order o1 = new Order(3002, 201, 101, 109, sd.parse(s), 1000, OrderStatus.PENDING);

    new Expectations() {
      {
        oDao.showOrderDetails(3001);
        result = o;
      }
    };

    new Expectations() {
      {
        oDao.showOrderDetails(3002);
        result = o1;
      }
    };

    new Expectations() {
      {
        cDao.getCustomerById(201);
        result = c;
      }
    };

    new Expectations() {
      {
        oDao.updateStatus(OrderStatus.ACCEPTED.name(), 3002);
        result = 1;
      }
    };

    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return cDao;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return oDao;
      }
    };
    Customer cu = new Customer();
    Customer cus = cu.getCustomerById(201);
    assertEquals(c, cus);

    Vendor e = new Vendor();
    String str = e.acceptDenyOrder(3001, OrderStatus.ACCEPTED.name(), 2000);
    assertEquals("Unchanged. Not considered due to date mismatch", str);

    String str1 = e.acceptDenyOrder(3002, OrderStatus.ACCEPTED.name(), 2000);
    assertEquals("Accepted Status Updated", str1);

    String str2 = e.acceptDenyOrder(3002, OrderStatus.REJECTED.name(), 2000);
    assertEquals("Denied", str2);
  }
}
