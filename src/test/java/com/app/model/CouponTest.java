package com.app.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

//import com.app.factory.CouponFactory;
//import com.app.persistence.CouponDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.app.model.Coupon;

//import mockit.Expectations;
//import mockit.Mock;
//import mockit.MockUp;
//import mockit.Mocked;
import mockit.integration.junit4.JMockit;


/**
 * CouponTest class.
 */
@RunWith(JMockit.class)
public class CouponTest {
  /**
   * test case for default constructor.
   */
  @Test
  public final void testCoupon() {
    Coupon c = new Coupon();
    c.setCouponId(101);
    c.setDetails("Coupon 1");
    c.setValidity(1);
    c.setCouponCode("C11");
    c.setAmt(30);
    assertEquals(101, c.getCouponId());
    assertEquals("Coupon 1", c.getDetails());
    assertEquals(1, c.getValidity());
    assertEquals("C11", c.getCouponCode());
    assertEquals(30, c.getAmt(), 1);
  }
  /**
   * testing parameterized constructor.
   */
  @Test
  public final void testCouponParameterizedConstructor() {
    Coupon c = new Coupon(101, "C11", "Coupon 1", 1, 30);
    assertEquals(101, c.getCouponId());
    assertEquals("Coupon 1", c.getDetails());
    assertEquals(1, c.getValidity());
    assertEquals("C11", c.getCouponCode());
    assertEquals(30, c.getAmt(), 1);
  }
  /**
   * test for getCouponId.
   */
  @Test
  public final void testGetCouponId() {
    Coupon c = new Coupon(101, "C11", "Coupon 1", 1, 30);
    assertEquals(101, c.getCouponId());
  }
  /**
   * test for getCouponDetails.
   */
  @Test
  public final void testGetCouponDetails() {
    Coupon c = new Coupon(101, "C11", "Coupon 1", 1, 30);
    assertEquals("Coupon 1", c.getDetails());
  }
  /**
   * test for getCouponValidity.
   */
  @Test
  public final void testGetCouponValidity() {
    Coupon c = new Coupon(101, "C11", "Coupon 1", 1, 30);
    assertEquals(1, c.getValidity());
  }
  /**
   * test for getCouponCode.
   */
  @Test
  public final void testGetCouponCode() {
    Coupon c = new Coupon(101, "C11", "Coupon 1", 1, 30);
    assertEquals("C11", c.getCouponCode());
  }
  /**
   * test for getCouponAmt.
   */
  @Test
  public final void testGetCouponAmt() {
    Coupon c = new Coupon(101, "C11", "Coupon 1", 1, 30);
    assertEquals(30, c.getAmt(), 1);
  }
  /**
   * test for setCouponId.
   */
  @Test
  public final void testSetCouponId() {
    Coupon c = new Coupon(101, "C11", "Coupon 1", 1, 30);
    c.setCouponId(101);
    assertEquals(101, c.getCouponId());
  }
  /**
   * test for setCouponCode.
   */
  @Test
  public final void testSetCouponCode() {
    Coupon c = new Coupon(101, "C11", "Coupon 1", 1, 30);
    c.setCouponCode("C11");
    assertEquals("C11", c.getCouponCode());
  }
  /**
   * test for setCouponDetails.
   */
  @Test
  public final void testSetCouponDetails() {
    Coupon c = new Coupon(101, "C11", "Coupon 1", 1, 30);
    c.setDetails("Coupon 1");
    assertEquals("Coupon 1", c.getDetails());
  }
  /**
   * test for setCouponValidity.
   */
  @Test
  public final void testSetCouponValidity() {
    Coupon c = new Coupon(101, "C11", "Coupon 1", 1, 30);
    c.setValidity(1);
    assertEquals(1, c.getValidity());
  }
  /**
   * test for setCouponAmt.
   */
  @Test
  public final void testSetCouponAmt() {
    Coupon c = new Coupon(101, "C11", "Coupon 1", 1, 30);
    c.setAmt(30);
    assertEquals(30, c.getAmt(), 1);
  }
  /**
   * test for hashCode method.
  */
  @Test
  public final void testHashCode() {
    Coupon c1 = new Coupon(101, "C11", "Coupon 1", 1, 30);
    Coupon c2 = new Coupon(102, "C12", "Coupon 2", 1, 30);
    Coupon c3 = new Coupon(101, "C11", "Coupon 1", 1, 30);
    assertEquals(c1.hashCode(), c3.hashCode());
    assertNotEquals(c1.hashCode(), c2.hashCode());
    assertNotEquals(c3.hashCode(), c2.hashCode());
  }
  /**
   * test for equals method.
   */
  @Test
  public final void testEquals() {
    Coupon c1 = new Coupon(101, "C11", "Coupon 1", 1, 30);
    Coupon c2 = new Coupon(102, "C12", "Coupon 2", 1, 30);
    Coupon c3 = new Coupon(101, "C11", "Coupon 1", 1, 30);
    assertTrue(c1.equals(c3));
    assertFalse(c2.equals(c1));
    assertFalse(c2.equals(c3));
    Coupon c = null;
    assertFalse(c1.equals(c));
  }
  /**
   * test for toString.
   */
  public final void testToString() {
    Coupon c = new Coupon(101, "C11", "Coupon 1", 1, 30);
    assertEquals(c.toString(), "Coupon Details: [couponid: " + c.getCouponId() + ", CouponCode: " + c.getCouponCode() + ", Details: "
        + c.getDetails() + " , Validity: " + c.getValidity() + " , Amount: " + c.getAmt() + "]");
  }
}
