package com.app.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.app.model.Customer;

/**
 * Mapper class for customer.
 */
public class CustomerMapper implements ResultSetMapper<Customer> {
  /**
   * map method.
   * @param index for index
   * @param result for Resultset
   * @param statement for StatementContext
   * @return Customer
   * @throws SQLException for SQLException
   */
  public final Customer map(final int index, final ResultSet result, final StatementContext statement) throws SQLException {
    return new Customer(result.getInt("cId"), result.getString("cName"), result.getString("cPhone"),
        result.getString("cEmail"), result.getDouble("walletbalance"), result.getDate("bDate"), result.getString("cPassword"));
  }
}
