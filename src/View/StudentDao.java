/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.StudentModel;
import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentDao {

    Connection Con = MyConnection.getConnection();
    PreparedStatement ps;

    public int getMax() {
        int id = 0;
        Statement st;
        try {
            st = Con.createStatement();
            ResultSet rs = st.executeQuery("Select max(id)from Student");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id + 1;
    }

//INSERT DATA 
       public void addStudent(StudentModel student) {
        String sql = "insert into student values(?,?,?,?,?)";
        try {
//                        ps.setString(2, student.getSname());
        
            
            ps = Con.prepareStatement(sql);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getSname());
            ps.setString(3, student.getBirthday());
            ps.setString(4, student.getGender());
            ps.setString(5, student.getPhone());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "New  student added Successfuly");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void insert(int id, String sname, String date, String gender, String phone) {
//        String sql = "insert into student values(?,?,?,?,?)";
//        try {
//            ps = Con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.setString(2, sname);
//            ps.setString(3, date);
//            ps.setString(4, gender);
//            ps.setString(5, phone);
//
//            if (ps.executeUpdate() > 0) {
//                JOptionPane.showMessageDialog(null, "New  student added Successfuly");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(studentDoa.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public void getStudentValue(JTable table, String searchValue) {
        String sql = "select * from student where concat(id, name, date_of_birth, Gender,phone)like  ? order by id desc";

        System.out.println("table" + table);
        
        
        try {
            ps = Con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;

            while (rs.next()) {
                row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //update student value

     public void updateStudent(StudentModel student) {
        String sql = "UPDATE student SET name=?, date_of_birth=?, gender=?,phone=? WHERE id=?";
        try {
            
//             ps.setString(3, student.getBirthday());
            ps = Con.prepareStatement(sql);
            ps.setString(1, student.getSname());
            ps.setString(2, student.getBirthday());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getPhone());
            ps.setInt(5, student.getId());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "student data update Successfuly");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//     public void Update(int id, String sname, String date, String gender, String phone) {
//        String sql = "UPDATE student SET name=?, date_of_birth=?, gender=?,phone=? WHERE id=?";
//        try {
//            ps = Con.prepareStatement(sql);
//            ps.setString(1, sname);
//            ps.setString(2, date);
//            ps.setString(3, gender);
//            ps.setString(4, phone);
//            ps.setInt(5, id);
//
//            if (ps.executeUpdate() > 0) {
//                JOptionPane.showMessageDialog(null, "student data update Successfuly");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    //dele

    public void delete(int id) {
        int yesOrNo = JOptionPane.showConfirmDialog(null, "courses  recode will also be deleted", "student delete", JOptionPane.OK_CANCEL_OPTION, 0);
        if (yesOrNo == JOptionPane.OK_OPTION) {
            try {
                ps = Con.prepareStatement("delete from student where id = ?");
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "student deleted Successfuly");

                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
