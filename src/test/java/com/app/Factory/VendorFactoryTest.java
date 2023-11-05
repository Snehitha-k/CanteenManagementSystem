package com.app.Factory;

import com.app.model.Vendor;
import com.app.persistence.VendorDAO;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * to test vendor factory.
 */
@RunWith(JMockit.class)
public class VendorFactoryTest {

  /**
   * test for FindById.
   * @param mDao for VendorDAO
   */
  @Test
  public final void testFindById(@Mocked final VendorDAO mDao) {
    final Vendor v = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    new Expectations() {
      {
        mDao.findById(101);
        result = v;
      }
    };

    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return mDao;
      }
    };

    Vendor v1 = VendorFactory.findById(101);
    assertEquals(v, v1);

  }

  /**
   * test for findByEmail.
   * @param mDao for VendorDAO
   */
  @Test
  public final void testFindByEmail(@Mocked final VendorDAO mDao) {
    final Vendor v = new Vendor(101, "dee123", "Deepak", "9629218696", "deepak@gmail.com");
    new Expectations() {
      {
        mDao.findVendorByEmail("deepak@gmail.com");
        result = v;
      }
    };

    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return mDao;
      }
    };

    Vendor v1 = VendorFactory.findVendorByEmail("deepak@gmail.com");
    assertEquals(v, v1);
  }

  /**
   * test for registerVendor.
   * @param mDao for VendorDAO
   */
  @Test
  public final void testRegisterVendor(@Mocked final VendorDAO mDao) {

    new Expectations() {
      {
        mDao.registerVendor(102, "ara123", "Aravind", "9632587410", "aravind@gmail.com");
        result = 1;
      }
    };

    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return mDao;
      }
    };

    int res = VendorFactory.registerVendor(102, "ara123", "Aravind", "9632587410", "aravind@gmail.com");
    assertEquals(1, res);
  }

  /**
   * test to update phone.
   * @param mDao for VendorDAO
   */
  @Test
  public final void testUpdatePhone(@Mocked final VendorDAO mDao) {

    new Expectations() {
      {
        mDao.updatePhone(102, "9632587410");
        result = 1;
      }
    };

    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return mDao;
      }
    };

    int res = VendorFactory.updatePhone(102, "9632587410");
    assertEquals(1, res);
  }

    /**
   * test to find last row.
   * @param mDao for VendorDAO
   */
  @Test
  public final void testFindLastRow(@Mocked final VendorDAO mDao) {
    Vendor v = new Vendor();
    new Expectations() {
      {
        mDao.findLastRow();
        result = v;
      }
    };

    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return mDao;
      }
    };
    final Vendor res = VendorFactory.findLastRow();
    assertEquals(v, res);
  }

  /**
   * test to update Password.
   * @param mDao for VendorDAO
   */
  @Test
  public final void testUpdatePassword(@Mocked final VendorDAO mDao) {

    new Expectations() {
      {
        mDao.updatePassword(102, "ara123");
        result = 1;
      }
    };

    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return mDao;
      }
    };

    int res = VendorFactory.updatePassword(102, "ara123");
    assertEquals(1, res);
  }
}
