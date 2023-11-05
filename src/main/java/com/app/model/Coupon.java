package com.app.model;

import java.util.Objects;

//import com.app.factory.CouponFactory;
/**
 * Coupon class.
 */

public class Coupon {
  /**
  * to store couponid.
  */
  private int couponId;
  /**
  * to store validity.
   */
  private int validity;
  /**
  * to store couponCode.
   */
  private String couponCode;
  /**
  * to store details.
   */
  private String details;
  /**
  * to store discount amount.
   */
  private double amount;
  /**
   *
   * @param argCid for couponid.
   */
  public final void setCouponId(final int argCid) {
    this.couponId = argCid;
  }
  /**
   *
   * @param argCode for coupon code.
   */
  public final void setCouponCode(final String argCode) {
    this.couponCode = argCode;
  }
  /**
   *
   * @param argDet for Details.
   */
  public final void setDetails(final String argDet) {
    this.details = argDet;
  }
  /**
   *
   * @param argAmt for amount.
   */
  public final void setAmt(final int argAmt) {
    this.amount = argAmt;
  }
  /**
   *
   * @param argVal for Validity.
   */
  public final void setValidity(final int argVal) {
    this.validity = argVal;
  }
  /**
   *
   * @return coupon code.
   */
  public final String getCouponCode() {
    return this.couponCode;
  }
  /**
   *
   * @return Validity.
   */
  public final int getValidity() {
    return this.validity;
  }
  /**
   *
   * @return couponid.
   */
  public final int getCouponId() {
    return this.couponId;
  }
   /**
   *
   * @return for amount.
   */
  public final double getAmt() {
    return this.amount;
  }
  /**
   *
   * @return for Details.
   */
  public final String getDetails() {
    return this.details;
  }
  /**
   * Default constructor.
   */
  public Coupon() {

  }
  /**
  * parameterized constructor.
  * @param argCid for Coupon id
  * @param argDet for Details
  * @param argVal for validity
  * @param argCode for coupon code
  * @param argAmt for amount
  */
  public Coupon(final int argCid, final String argCode, final String argDet, final int argVal, final double argAmt) {
    this.couponId = argCid;
    this.amount = argAmt;
    this.validity = argVal;
    this.details = argDet;
    this.couponCode = argCode;
  }
  /**
  * hashCode method.
  * @return int
  */
  @Override
  public final int hashCode() {
    return Objects.hash(couponId, couponCode, details, validity, amount);
  }
  /**
* equals method.
* @param obj Object
* @return boolean
*/
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Coupon other = (Coupon) obj;
    if (Objects.equals(couponId, other.couponId)
        && Objects.equals(couponCode, other.couponCode)
        && Objects.equals(details, other.details)
        && Objects.equals(validity, other.validity)
        && Objects.equals(amount, other.amount)
    ) {
      return true;
    }
    return false;
  }
  /**
   * toString method.
   * @return string
   */
  @Override
  public final String toString() {
    return "Coupon Details: [couponid: " + this.couponId + ", CouponCode: " + this.couponCode + ", Details: "
      + this.details + " , Validity: " + this.validity + " , Amount: " + this.amount + "]";
  }
}
