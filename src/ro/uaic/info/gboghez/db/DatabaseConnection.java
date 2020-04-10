package ro.uaic.info.gboghez.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A class which implements the Singleton design pattern giving a single connection to the database (and that's because the number of connections is limited and here we use a single one of the database connections)
 */
public class DatabaseConnection {
    private Connection connection;
    private static DatabaseConnection instance;

    /**
     * a private constructor because we don't want anyone from outside of this class to be able to create new objects, but rather give them the object created through the getInstance method
     * @throws SQLException
     */
    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","java_dba","sql");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * the method called to get the uniquely created object from this app (if it doesn't exist, it is created)
     * @return the unique Database object
     * @throws SQLException
     */
    public static DatabaseConnection getInstance() throws SQLException {
        if(instance == null) {
            instance = new DatabaseConnection();
        } else if(instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

    /**
     * returns the connection
     * @return a Connection object
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * a method to close the connection (essential to be called before the program ends)
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        connection.close();
    }



}
