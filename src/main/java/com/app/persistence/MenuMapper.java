package com.app.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.app.model.Menu;

import org.skife.jdbi.v2.StatementContext;

/**
 * Mapper class for Menu.
 */
public class MenuMapper implements ResultSetMapper<Menu> {
  /**
   * map method.
   * @param idx for index
   * @param rs for Resultset
   * @param stmt for StatementContext
   * @return Menu
   * @throws SQLException for SQLException
   */
  public final Menu map(final int idx, final ResultSet rs, final StatementContext stmt) throws SQLException {
    return new Menu(rs.getInt("PID"), rs.getInt("VID"), rs.getString("PNAME"),
        rs.getInt("PQUANTITY"), rs.getDouble("PPRICE"), rs.getDouble("PRATING"), rs.getInt("PCATEGORY"));
  }
}
