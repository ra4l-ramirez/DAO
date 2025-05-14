
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=universidad_digital"; // cambia nombre BD si es necesario
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=universidad_digital;encrypt=true;trustServerCertificate=true";

    private static final String USER = "sa";
    private static final String PASSWORD = "Marymoises%8557"; // reemplaza con la tuya

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
