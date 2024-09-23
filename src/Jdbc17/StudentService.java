package Jdbc17;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService {
    public void getStudentById(int id) {
        Connection con = JdbcUtil.getMySqlConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from student where stu_id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("stu_id") + " " + rs.getString("stu_name") + " " + rs.getString("city"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.cleanResources(ps, con, rs);
        }
    }
}