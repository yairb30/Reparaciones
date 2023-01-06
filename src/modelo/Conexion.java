package modelo;

import java.sql.*;

public class Conexion {

    private final String url = "jdbc:mysql://localhost:3306/reparaciones?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final String user = "root";
    private final String password = "12345678";
    private Connection con = null;

    public Connection getConexion() {

        try {

            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return con;

    }

}
