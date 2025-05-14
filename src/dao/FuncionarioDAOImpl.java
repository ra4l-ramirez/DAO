package dao;

import model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAOImpl {

    private final Conexion conexion = new Conexion();



//    public void insertar(Funcionario funcionario) throws SQLException {
//        String sql = "INSERT INTO funcionarios ( tipo_identificacion, nombre, apellido, estado_civil, sexo, direccion, fecha_nacimiento, teléfono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try (Connection conn = conexion.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            //stmt.setInt(1, funcionario.getId());
//            stmt.setString(2, funcionario.getTipoIdentificacion());
//            stmt.setString(3, funcionario.getNombre());
//            stmt.setString(4, funcionario.getApellido());
//            stmt.setString(5, funcionario.getEstadoCivil());
//            stmt.setString(6, funcionario.getSexo());
//            stmt.setString(7, funcionario.getDireccion());
//            stmt.setString(8, funcionario.getFechaNacimiento());
//            stmt.setString(9, funcionario.getTelefono());
//
//            stmt.executeUpdate();
//        }
//    }
//@Override
public void insertar(Funcionario funcionario) throws SQLException {
    String sql = "INSERT INTO funcionarios (tipo_identificacion, nombre, apellido, estado_civil, sexo, direccion, fecha_nacimiento, teléfono) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = Conexion.getConnection();  // Asegúrate de tener esta clase
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, funcionario.getTipoIdentificacion());
        ps.setString(2, funcionario.getNombre());
        ps.setString(3, funcionario.getApellido());
        ps.setString(4, funcionario.getEstadoCivil());
        ps.setString(5, funcionario.getSexo());
        ps.setString(6, funcionario.getDireccion());
        ps.setDate(7, java.sql.Date.valueOf(funcionario.getFechaNacimiento())); // usa LocalDate
        ps.setString(8, funcionario.getTelefono());

        ps.executeUpdate();
    }
}

    public List<Funcionario> listarTodos() throws SQLException {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";

        try (Connection conn = conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                //funcionario.setId(rs.getInt("id"));
                funcionario.setTipoIdentificacion(rs.getString("tipo_identificacion"));
                funcionario.setNombre(rs.getString("nombre"));
                funcionario.setApellido(rs.getString("apellido"));
                funcionario.setEstadoCivil(rs.getString("estado_civil"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setDireccion(rs.getString("direccion"));
                funcionario.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                funcionario.setTelefono(rs.getString("teléfono"));
                lista.add(funcionario);
            }
        }

        return lista;
    }




}
