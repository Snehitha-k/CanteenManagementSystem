package com.app.Factory;

import com.app.model.Coupon;
import com.app.persistence.CouponDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;
/**
 * test suite for CouponFactory.
 */
@RunWith(JMockit.class)
public class CouponFactoryTest {
  /**
   * test method to display Coupon last row.
   * @param dao Coupon dao.
   */
  @Test
  public final void testCheckLastRow(@Mocked final CouponDAO dao) {
    Coupon c1 = new Coupon(101, "C11", "Coupon 1", 1, 30);
    Coupon c2 = new Coupon(102, "C12", "Coupon 2", 1, 30);
    new Expectations() {
      {
        dao.findLastRow();
        result = c1;
      }
    };
    new MockUp<CouponFactory>() {
      @Mock
      CouponDAO dao() {
        return dao;
      }
    };
    Coupon coupon1 = CouponFactory.findLastRow();
    assertEquals(c1, coupon1);
    assertNotEquals(c2, coupon1);
  }
  /**
   * test method to display Coupon.
   * @param dao Coupon dao.
   */
  @Test
  public final void testshowCoupon(@Mocked final CouponDAO dao) {
    Coupon c1 = new Coupon(101, "C11", "Coupon 1", 1, 30);
    Coupon c2 = new Coupon(102, "C12", "Coupon 2", 1, 30);
    ArrayList<Coupon> coupon = new ArrayList<Coupon>();
    new Expectations() {
      {
        coupon.add(c1);
        coupon.add(c2);
        dao.retrieveCoupons();
        result = coupon;
      }
    };
    new MockUp<CouponFactory>() {
      @Mock
      CouponDAO dao() {
        return dao;
      }
    };
    Coupon[] coupon1 = CouponFactory.retrieveCoupons();
    assertEquals(2, coupon1.length);
  }
  /**
   * test for addCouponDetails.
   * @param mDao for CouponsDAO
  */
  @Test
  public final void testAddCouponDetails(@Mocked final CouponDAO mDao) {
    new Expectations() {
      {
        mDao.addCouponDetails(101, "C11", "Coupon 1", 1, 30);
        result = 1;
      }
    };
    new MockUp<CouponFactory>() {
      @Mock
      CouponDAO dao() {
        return mDao;
      }
    };
    int res = CouponFactory.addCouponDetails(101, "C11", "Coupon 1", 1, 30);
    assertEquals(1, res);
  }
}
