package es.ies.puerto.model.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.model.abstractas.Conexion;
import es.ies.puerto.model.entities.NivelEntitySqlite;

/**
 * @author danielrguezh
 * @version 1.0.0
 */
public class NivelServiceSqlite extends Conexion{

    public NivelServiceSqlite() {

    }

    public NivelServiceSqlite(String unaRutaArchivoBD) throws SQLException {
        super(unaRutaArchivoBD);
    }

    public List<NivelEntitySqlite> obtenerNivelPorUsuario(int nivel) throws SQLException {
        String sql = "SELECT * FROM niveles WHERE id = ?";
        return obtenerNivel(sql, Integer.toString(nivel));
    }

    private List<NivelEntitySqlite> obtenerNivel(String sql, String... parametros) throws SQLException{
        List<NivelEntitySqlite> niveles = new ArrayList<NivelEntitySqlite>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            for (int i = 0; i < parametros.length; i++) {
                sentencia.setString(i + 1, parametros[i]);
            }
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                int nivelId = resultado.getInt("id");
                String nivelStr = resultado.getString("nivel");
                NivelEntitySqlite nivel = new NivelEntitySqlite(nivelId, nivelStr);
                niveles.add(nivel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return niveles;
    }
}
