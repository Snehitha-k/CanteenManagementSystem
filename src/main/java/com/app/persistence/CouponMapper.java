package com.app.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.app.model.Coupon;
/**
 * Mapper class for Coupon.
 */
public class CouponMapper implements ResultSetMapper<Coupon> {
  /**
   * map method.
   * @param idx for index
   * @param rs for Resultset
   * @param stmt for StatementContext
   * @return Coupon object
   * @throws SQLException for sql exception
   */
  public final Coupon map(final int idx, final ResultSet rs, final StatementContext stmt) throws SQLException {
    return new Coupon(rs.getInt("COUPON_ID"), rs.getString("COUPON_CODE"), rs.getString("DETAILS"),
    rs.getInt("VALIDITY"), rs.getDouble("DISCOUNT_AMOUNT"));
  }
}
