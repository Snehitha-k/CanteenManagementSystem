package com.app.persistence;
import java.util.Date;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.app.model.Customer;

/**
 * DAO class for Customers.
 */
public interface CustomerDAO {
  /**
   * find an Customer's details.
   * @param cId for Customerid
   * @return Customer
   */
  @SqlQuery("SELECT * FROM CUSTOMER WHERE cId = :Id")
  @Mapper(CustomerMapper.class)
  Customer getCustomerById(@Bind("Id") final int cId);

  /**
   * find the Customer by email -> for login.
   * @param cEmail for email
   * @return Customer
   */
  @SqlQuery("SELECT * FROM CUSTOMER WHERE cEmail = :Email")
  @Mapper(CustomerMapper.class)
  Customer findByEmail(@Bind("Email") final String cEmail);

  /**
   * to register an Customer.
   * @param cId Customerid
   * @param cName Customername
   * @param cPhone phonenumber
   * @param cEmail email
   * @param walletbalance wallet balance
   * @param date1 dob
   * @param cPassword password
   * @return int
   */
  @SqlUpdate("INSERT INTO CUSTOMER (cId, cName, cphone, cEmail, walletbalance, bDate, cPassword)"
      + "VALUES (:cId, :cName, :cPhone, :cEmail, :walletbalance, :bDate, :cPassword)")
  int registerCustomer(@Bind("cId") final int cId, @Bind("cName") final String cName, @Bind("cPhone") final String cPhone,
      @Bind("cEmail") final String cEmail, @Bind("walletbalance") final double walletbalance, @Bind("bDate") final Date date1,
      @Bind("cPassword") final String cPassword);

  /**
   * to update phone.
   * @param cId customerid
   * @param cPhone new phone number
   * @return int
   */
  @SqlUpdate("UPDATE CUSTOMER SET cPhone = :phone WHERE cId = :Id")
  int updatePhone(@Bind("Id") final int cId, @Bind("phone") final String cPhone);
  /**
   * to update address.
   * @param cId customerid
   * @param cAddress new Address
   * @return int
   */
  @SqlUpdate("UPDATE CUSTOMER SET cAddress = :cAddr WHERE cId = :id")
  int updateAddress(@Bind("id") final int cId, @Bind("cAddr") final String cAddress);

  /**
   * to update password.
   * @param cId customerid.
   * @param cPassword new password.
   * @return int
   */
  @SqlUpdate("UPDATE CUSTOMER SET cPassword = :password WHERE cId = :id")
  int updatePassword(@Bind("id") final int cId, @Bind("password") final String cPassword);

  /**
   * find the last row in Customer table.
   * @return customer
   */
  @SqlQuery("SELECT * FROM CUSTOMER WHERE CID = (SELECT MAX(CID) FROM CUSTOMER)")
  @Mapper(CustomerMapper.class)
  Customer findLastRow();
  /**
   * reduce wallet balance on ordering food.
   * @param id customer id
   * @param curamt current wallet balance
   * @param amt amount to be deducted
   * @return int
   */
  @SqlUpdate("UPDATE CUSTOMER SET WALLETBALANCE = :curamt - :amt WHERE CID = :id")
  int decrementWallet(@Bind("id") final int id, @Bind("curamt") final double curamt, @Bind("amt") final double amt);

  /**
   * increase wallet balance on booking cancellation.
   * @param id customer id
   * @param curamt current wallet balance
   * @param amt amount to be credited.
   * @return int
   */
  @SqlUpdate("UPDATE CUSTOMER SET WALLETBALANCE = :curamt + :amt WHERE CID = :id")
  int incrementWallet(@Bind("id") final int id, @Bind("curamt") final double curamt, @Bind("amt") final double amt);
  /**
   * update wallet balance.
   * @param id customer id
   * @param bal current wallet balance
   * @param newAmt amount to be added
   * @return int
   */
  @SqlUpdate("UPDATE CUSTOMER SET WALLETBALANCE = :bal + :newAmt WHERE CID = :id")
  int updateWalletAmount(@Bind("id") final int id, @Bind("bal") final double bal, @Bind("newAmt") final double newAmt);
  /**
   * to get the Customer balance.
   * @param id for Customer id
   * @return order amount
   */
  @SqlQuery("SELECT WALLETBALANCE FROM CUSTOMER WHERE CID = :id")
  double retrieveWallet(@Bind("id") final int id);
}
