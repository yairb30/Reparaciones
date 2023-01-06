package modelo;

import java.sql.*;

public class ConsultaCelular extends Conexion {

    public boolean guardar(Celular cel) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO celulares (imei, marca, modelo, falla, cliente, fecha) VALUES (?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, cel.getImei());
            ps.setString(2, cel.getMarca());
            ps.setString(3, cel.getModelo());
            ps.setString(4, cel.getFalla());
            ps.setString(5, cel.getCliente());
            ps.setDate(6, new java.sql.Date(cel.getFecha().getTime()));

            ps.execute();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

    }

    public boolean modificar(Celular cel) {

        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE celulares SET imei=?, marca=?, modelo=?, falla=?, cliente=?, fecha=? WHERE id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, cel.getImei());
            ps.setString(2, cel.getMarca());
            ps.setString(3, cel.getModelo());
            ps.setString(4, cel.getFalla());
            ps.setString(5, cel.getCliente());
            ps.setInt(6, cel.getId());
            ps.setDate(7,new java.sql.Date(cel.getFecha().getTime()));

            ps.execute();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

    }

    public boolean eliminar(Celular cel) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM celulares WHERE id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cel.getId());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    public boolean buscar(Celular cel) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM celulares  WHERE imei=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, cel.getImei());
            rs = ps.executeQuery();

            if (rs.next()) {
                cel.setId(Integer.parseInt(rs.getString("id")));
                cel.setImei(rs.getLong("imei"));
                cel.setMarca(rs.getString("marca"));
                cel.setModelo(rs.getString("modelo"));
                cel.setFalla(rs.getString("falla"));
                cel.setCliente(rs.getString("cliente"));
                cel.setFecha(rs.getDate("fecha"));
                return true;
            }
            return false;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);

            }
        }
    }

}
