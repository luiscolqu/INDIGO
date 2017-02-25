package pe.edu.utp.regionslist.models;

import com.sun.prism.shader.Mask_TextureSuper_Loader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GrupoUTP on 17/02/2017.
 */
public class RegionsEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM hr.regions";

    public List<Region> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public Region findById(int id) {
        List<Region> regions = findByCriteria(DEFAULT_SQL + " WHERE region_id = " + String.valueOf(id));
        return (regions != null) ? regions.get(0) : null;
    }

    public Region findByName(String name) {
        List<Region> regions = findByCriteria(DEFAULT_SQL + " WHERE region_name = '" + name + "'");
        return (regions != null) ? regions.get(0) : null;
    }

    public List<Region> findByCriteria(String sql) {
        List<Region> regions;
        if(getConnection() != null) {
            regions = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while(resultSet.next()) {
                    Region region = new Region(resultSet.getInt("region_id"),
                            resultSet.getString("region_name"));
                    regions.add(region);
                }
                return regions;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public Region create(String name) {
        return null;
    }
}
