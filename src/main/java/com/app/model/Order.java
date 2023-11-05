package com.app.model;
import java.util.Objects;
import java.util.Date;
/**
* Orders class.
*/
public class Order {
/**
* To store order id.
*/
  private int orderId;
/**
* To store customer id.
*/
  private int custId;
/**
* To store product id.
*/
  private int prodId;
/**
* To store vendor id.
*/
  private int vendorId;
/**
* To store coupon code.
*/
  private int code;
/**
* To store order date.
*/
  private Date orderDate;
/**
* To store order amount.
*/
  private double totalAmt;
/**
* To store order status.
*/
  private OrderStatus orderStatus;
//---------------------------------------
//getters and setters
//---------------------------------------

/**
*
* @return orderId.
*/
  public final int getOrderId() {
    return this.orderId;
  }
/**
*
* @param argOrderId for orderId.
*/
  public final void setOrderId(final int argOrderId) {
    this.orderId = argOrderId;
  }
/**
*
* @return code.
*/
  public final int getCode() {
    return this.code;
  }
/**
*
* @param argCode for coupon code.
*/
  public final void setCode(final int argCode) {
    this.code = argCode;
  }
/**
*
* @return customerId.
*/
  public final int getCustId() {
    return this.custId;
  }
/**
*
* @param argCustId for customerId .
*/
  public final void setCustId(final int argCustId) {
    this.custId = argCustId;
  }
/**
*
* @return productId.
*/
  public final int getProdId() {
    return this.prodId;
  }
/**
*
* @param argProdId for productId.
*/
  public final void setProdId(final int argProdId) {
    this.prodId = argProdId;
  }
/**
*
* @return vendorId.
*/
  public final int getVendorId() {
    return this.vendorId;
  }
/**
*
* @param argVendorId for vendorId.
*/
  public final void setVendorId(final int argVendorId) {
    this.vendorId = argVendorId;
  }
/**
*
* @return orderDate.
*/
  public final Date getOrderDate() {
    return this.orderDate;
  }
/**
*
* @param argOrderDate for orderDate.
*/
  public final void setOrderDate(final Date argOrderDate) {
    this.orderDate = argOrderDate;
  }

/**
*
* @return totalAmount.
*/
  public final double getTotalAmt() {
    return  this.totalAmt;
  }
/**
*
* @param argTotalAmt for totalamt.
*/
  public final void setTotalAmt(final double argTotalAmt) {
    this.totalAmt = argTotalAmt;
  }
/**
*
* @return orderStatus.
*/

  public final OrderStatus getOrderStatus() {
    return this.orderStatus;
  }
/**
*
* @param argOrderStatus for orderStatus.
*/
  public final void setOrderStatus(final OrderStatus argOrderStatus) {
    this.orderStatus = argOrderStatus;
  }
/**
* default constructor.
*/
  public Order() {

  }
/**
* parameterized constructor.
* @param argOrderId for order id
* @param argCustId for customer id
* @param argProdId for product id
* @param argVendorId for vendor id
* @param argOrderDate for order date
* @param argTotalAmt for order amount
* @param argOrderStatus for order status
*/
  public Order(final int argOrderId, final int argCustId, final int argProdId, final int argVendorId,
      final Date argOrderDate, final double argTotalAmt, final OrderStatus argOrderStatus) {
    this.orderId = argOrderId;
    this.orderStatus = argOrderStatus;
    this.orderDate = argOrderDate;
    this.vendorId = argVendorId;
    this.prodId = argProdId;
    this.custId = argCustId;
    this.totalAmt = argTotalAmt;
  }
/**
* hashCode method.
* @return int
*/
  @Override
  public final int hashCode() {
    return Objects.hash(orderId, custId, prodId, vendorId, orderDate, totalAmt, orderStatus);
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
    Order other = (Order) obj;
    if (Objects.equals(orderId, other.orderId)
        && Objects.equals(custId, other.custId)
        && Objects.equals(prodId, other.prodId)
        && Objects.equals(vendorId, other.vendorId)
        && Objects.equals(orderDate, other.orderDate)
        && Objects.equals(totalAmt, other.totalAmt)
        && Objects.equals(orderStatus, other.orderStatus)
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
    return
      "Order Details: [Id: " + this.orderId + ", customerId: "
      + this.custId + ", productId: "
      + this.prodId + ", vendorId: " + this.vendorId
      + ", orderDate: " + this.orderDate + ", Amount Paid: "
      + this.totalAmt + ", Order Status: " + this.orderStatus + "]";
  }
/**
* addOrder method.
* To add new orders into orderdetails
* @param argOrderId for order id
* @param argCustId for customer id
* @param argProdId for product id
* @param argVendorId for vendor id
* @param argOrderDate for order date
* @param argTotalAmt for order amount
* @param argOrderStatus for order status
* @return String.
*/
  public final String addOrder(final int argOrderId, final int argCustId, final int argProdId, final int argVendorId,
      final Date argOrderDate, final double argTotalAmt, final OrderStatus argOrderStatus) {
    final String str = "added successfully!";
    Order o = new Order();
    o.setOrderId(argOrderId);
    o.setOrderDate(argOrderDate);
    o.setCustId(argCustId);
    o.setVendorId(argVendorId);
    o.setProdId(argProdId);
    o.setOrderStatus(argOrderStatus);
    o.setTotalAmt(argTotalAmt);
    return str;
  }
}
