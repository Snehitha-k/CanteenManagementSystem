package com.app.persistence;

import org.skife.jdbi.v2.DBI;

/**
 */
public class DbConnection {
    /**
     * Connecting to MYSQL DB.
     * @return database Connection.
     */
  public final DBI getConnect() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String dbc = System.getenv("DB_CONNECTION");
      if (dbc == null || dbc.equals("")) {
        dbc = "localhost:3306";
      }
      DBI dbi = new DBI("jdbc:mysql://" + dbc + "/MLP351?allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "Password123");

    //  DBI dbi = new DBI("jdbc:mysql://" + dbc + "/MLP351?useSSL=false", "MLP351", "MLP351");

      //DBI dbi = new DBI("jdbc:mysql://" + dbc + "/MLP351?useSSL=false", "MLP351", "MLP351");

      return dbi;
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}

