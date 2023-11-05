package com.app.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.app.model.Vendor;


/**
 * Mapper class for Vendor.
 */
public class VendorMapper implements ResultSetMapper<Vendor> {
  /**
   * map method.
   * @param idx for index
   * @param rs for Resultset
   * @param stmt for StatementContext
   * @return Vendor
   * @throws SQLException for SQLException
   */
  public final Vendor map(final int idx, final ResultSet rs, final StatementContext stmt) throws SQLException {
    return new Vendor(rs.getInt("VENDORID"), rs.getString("PASSKEY"), rs.getString("VENDORNAME"), rs.getString("PHONE"), rs.getString("EMAIL"));
  }
}

