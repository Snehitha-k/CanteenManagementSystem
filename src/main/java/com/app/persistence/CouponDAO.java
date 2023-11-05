package com.app.persistence;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.app.model.Coupon;
/**
 * DAO class for Coupon.
 */
public interface CouponDAO {
    /**
     * addCouponDetails method.
     * @param id for Coupon id
     * @param det for Details
     * @param val for validity
     * @param code for coupon code
     * @param amt for amount
     * @return int.
    */
  @SqlUpdate("INSERT INTO COUPON VALUES (:COUPON_ID, :COUPON_CODE, :DETAILS, :VALIDITY, :DISCOUNT_AMOUNT)")
    int addCouponDetails(@Bind("COUPON_ID") final int id, @Bind("COUPON_CODE") final String code,
      @Bind("DETAILS") final String det, @Bind("VALIDITY") final int val, @Bind("DISCOUNT_AMOUNT") final double amt);
    /**
    * to find the last coupon id.
    * @return coupon object
    */
  @SqlQuery("SELECT * FROM COUPON WHERE COUPON_ID = (SELECT MAX(COUPON_ID) FROM COUPON)")
    @Mapper(CouponMapper.class)
    Coupon findLastRow();
    /**
    * to get all coupons.
    * @return list
    */
  @SqlQuery("SELECT * FROM COUPON")
    @Mapper(CouponMapper.class)
    List<Coupon> retrieveCoupons();
}
