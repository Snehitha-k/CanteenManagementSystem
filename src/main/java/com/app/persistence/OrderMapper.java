package com.app.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

//import java.text.SimpleDateFormat;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.app.model.Order;
import com.app.model.OrderStatus;

/**
 * Mapper class for Order.
 */
public class OrderMapper implements ResultSetMapper<Order> {
  /**
   * map method.
   * @param idx for index
   * @param rs for Resultset
   * @param stmt for StatementContext
   * @return Booking object
   * @throws SQLException for sql exception
   */
  public final Order map(final int idx, final ResultSet rs, final StatementContext stmt) throws SQLException {
    OrderStatus stat = OrderStatus.valueOf(rs.getString("ORDER_STATUS"));
    /*java.sql.Date odate = rs.getDate("ORDER_DATE");
    Calendar cal = Calendar.getInstance();
    cal.setTime(odate);
    cal.add(Calendar.DATE, 1);
    Date d = cal.getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");*/
    return new Order(rs.getInt("ORDER_ID"), rs.getInt("CUSTOMER_ID"), rs.getInt("PROD_ID"), rs.getInt("VENDOR_ID"),
        rs.getDate("ORDER_DATE"), rs.getDouble("TOTAL_AMT"), stat);
  }
}
