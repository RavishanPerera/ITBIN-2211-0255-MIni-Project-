/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.CourseModel;
import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ravishan
 */
public class CourseDao {
    Connection Con = MyConnection.getConnection();
    PreparedStatement ps;
    
      public int getMax() {
        int id = 0;
        Statement st;
        try {
            st = Con.createStatement();
            ResultSet rs = st.executeQuery("Select max(id)from Course");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id + 1;
    }
      //h
      
       public boolean getId(int id) {
        try {
            ps = Con.prepareStatement("select * from student where id =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                StudentD.jTextField8.setText(String.valueOf(rs.getInt(1)));
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "student is doesn't exit");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
       public int countSemester(int id) {
       int total = 0;
        try {
            ps = Con.prepareStatement("SELECT COUNT(*) AS total FROM course WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            total = rs.getInt(1);
            }
            if (total ==8){
            JOptionPane.showMessageDialog(null, "This student has completed all the courses.");
            return -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
       }
    //
        public void addCourse(CourseModel course) {
         String sql = "insert into course (student_id,semester,subject1,subject2,subject3) values(?,?,?,?,?)";
    
        try {
//             ps.setString(3, course.getSubject1());
            ps = Con.prepareStatement(sql);
//            ps.setInt(1, id);
            ps.setInt(1, course.getSid());
            ps.setInt(2, course.getSemesterNo());
            ps.setString(3, course.getSubject1());
            ps.setString(4, course.getSubject2());
            ps.setString(5, course.getSubject3());
            
            
            System.out.println(ps);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "course added Successfuly");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//         public void insert(int id, int sid, int semester, String subject1, String subject2, String subject3) {
//         String sql = "insert into course (student_id,semester,subject1,subject2,subject3) values(?,?,?,?,?)";
//    
//        try {
//            ps = Con.prepareStatement(sql);
////            ps.setInt(1, id);
//            ps.setInt(1, sid);
//            ps.setInt(2, semester);
//            ps.setString(3, subject1);
//            ps.setString(4, subject2);
//            ps.setString(5, subject3);
//            
//            
//            System.out.println(ps);
//
//            if (ps.executeUpdate() > 0) {
//                JOptionPane.showMessageDialog(null, "course added Successfuly");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
        
     public void getCoursetValue(JTable table, String searchValue) {
        String sql = "select * from course where concat(id, student_id, semester) like ? order by id desc";
        
         System.out.println("get courses");

        try {
            ps = Con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[6];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                
                System.out.println(row[1]);
                 
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
