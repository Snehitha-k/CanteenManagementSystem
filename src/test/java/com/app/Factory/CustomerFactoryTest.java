package com.app.Factory;

import com.app.model.Customer;
import com.app.persistence.CustomerDAO;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * test class for CustomerFactory.
 */
@RunWith(JMockit.class)
public class CustomerFactoryTest {
  private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  /**
   * test for getCustomerById.
   * @param cDao for CustomerDAO
   * @throws ParseException for date
   */
  @Test
  public final void testGetCustomerById(@Mocked final CustomerDAO cDao) throws ParseException {
    Date md = new Date();
    final Customer c = new Customer(201, "Sathya", "sathya@gmail.com", "1234567890", 100000, sdf.parse("2000-01-21"), "sath123");
    md = sdf.parse("2020-01-21");
    new Expectations() {
      {
        cDao.getCustomerById(201);
        result = c;
      }
    };

    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return cDao;
      }
    };

    Customer c1 = CustomerFactory.getCustomerById(201);
    assertEquals(c, c1);
  }

  /**
   * test for findByEmail.
   * @param cDao for CustomerDAO
   * @throws ParseException for date
   */
  @Test
  public final void testfindByEmail(@Mocked final CustomerDAO cDao) throws ParseException {
    Date md = new Date();
    md = sdf.parse("2020-01-21");
    final Customer c = new Customer(201, "Deepak", "deepak@gmail.com", "1234567890", 100000, sdf.parse("2000-01-21"), "deep123");

    new Expectations() {
      {
        cDao.findByEmail("deepak@gmail.com");
        result = c;
      }
    };

    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return cDao;
      }
    };

    Customer c1 = CustomerFactory.findByEmail("deepak@gmail.com");
    assertEquals(c, c1);
  }
    /**
   * test for findLastRow.
   * @param cDao for CustomerDAO
   * @throws ParseException for date
   */
  @Test
  public final void testfindLastRow(@Mocked final CustomerDAO cDao) throws ParseException {
    Date md = new Date();
    md = sdf.parse("2020-01-21");
    final Customer c = new Customer(201, "Deepak", "deepak@gmail.com", "1234567890", 100000, sdf.parse("2000-01-21"), "deep123");

    new Expectations() {
      {
        cDao.findLastRow();
        result = c;
      }
    };

    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return cDao;
      }
    };

    Customer c1 = CustomerFactory.findLastRow();
    assertEquals(c, c1);
  }
    /**
   * test for registerCustomer.
   * @param cDao for CustomerDAO
   * @throws ParseException for parse exception
   */
  @Test
  public final void testRegisterCustomer(@Mocked final CustomerDAO cDao) throws ParseException {

    new Expectations() {
      {
        cDao.registerCustomer(201, "Deepak", "deepak@gmail.com", "1234567890", 100000, sdf.parse("2000-01-21"), "deep123");
        result = 1;
      }
    };

    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return cDao;
      }
    };

    int res = CustomerFactory.registerCustomer(201, "Deepak", "deepak@gmail.com", "1234567890", 100000, sdf.parse("2000-01-21"), "deep123");
    assertEquals(1, res);
  }
    /**
   * test to update phone.
   * @param cDao for CustomerDAO
   */
  @Test
  public final void testUpdatePhone(@Mocked final CustomerDAO cDao) {

    new Expectations() {
      {
        cDao.updatePhone(102, "9632587410");
        result = 1;
      }
    };

    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return cDao;
      }
    };

    int res = CustomerFactory.updatePhone(102, "9632587410");
    assertEquals(1, res);
  }
  /**
   * test to update Password.
   * @param cDao for CustomerDAO
   */
  @Test
  public final void testUpdatePassword(@Mocked final CustomerDAO cDao) {

    new Expectations() {
      {
        cDao.updatePassword(102, "ara123");
        result = 1;
      }
    };

    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return cDao;
      }
    };

    int res = CustomerFactory.updatePassword(102, "ara123");
    assertEquals(1, res);
  }
    /**
   * test to update Password.
   * @param cDao for CustomerDAO
   */
  @Test
  public final void testUpdateAddress(@Mocked final CustomerDAO cDao) {

    new Expectations() {
      {
        cDao.updateAddress(102, "erode");
        result = 1;
      }
    };

    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return cDao;
      }
    };

    int res = CustomerFactory.updateAddress(102, "erode");
    assertEquals(1, res);
  }
   /**
   * test for decrementWallet.
   * @param dao for CustomerDAO
   */
  @Test
  public final void testDecrementWallet(@Mocked final CustomerDAO dao) {
    new Expectations() {
      {
        dao.decrementWallet(119, 13400, 12000);
        result = 1;
      }
    };

    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };

    int res = CustomerFactory.decrementWallet(119, 13400, 12000);
    assertEquals(1, res);
  }
     /**
   * test for incrementWallet.
   * @param dao for CustomerDAO
   */
  @Test
  public final void testIncrementWallet(@Mocked final CustomerDAO dao) {
    new Expectations() {
      {
        dao.incrementWallet(119, 13400, 12000);
        result = 1;
      }
    };

    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };

    int res = CustomerFactory.incrementWallet(119, 13400, 12000);
    assertEquals(1, res);
  }
     /**
   * test for updateWalletAmount.
   * @param dao for CustomerDAO
   */
  @Test
  public final void testupdateWalletAmount(@Mocked final CustomerDAO dao) {
    new Expectations() {
      {
        dao.updateWalletAmount(119, 13400, 12000);
        result = 1;
      }
    };

    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };

    int res = CustomerFactory.updateWalletAmount(119, 13400, 12000);
    assertEquals(1, res);
  }
}
