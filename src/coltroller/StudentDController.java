/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coltroller;

import Model.CourseModel;
import Model.StudentModel;
import View.CourseDao;
import View.StudentD;
import static View.StudentD.jTextField8;
import View.StudentDao;
import View.CourseDao;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ravishan
 */
public class StudentDController {

    private StudentDao stu = null;
    private CourseDao courseDao = null;
    private StudentD studentD;
    private DefaultTableModel model;
    private int rowIndex;
     private StudentDao studentDao;

    public StudentDController() {
        stu = new StudentDao();
        courseDao = new CourseDao();
        this.studentD = new StudentD();
        this.studentDao =new StudentDao();

        studentD.getjButton2().addActionListener(
                new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt, studentD);
            }
        });
        studentD.getjButton15().addActionListener(
                new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt, studentD);
            }
        });
        studentD.getjButton3().addActionListener(
                new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt, studentD);
            }
        });
        studentD.getjButton1().addActionListener(
                new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt, studentD);
            }
        });
        studentD.getjButton12().addActionListener(
                new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt, studentD);
            }
        });
//course
        studentD.getjButton10().addActionListener(
                new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt, studentD);
            }
        });
        studentD.getjButton5().addActionListener(
                new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt, studentD);
            }
        });
        studentD.getjButton16().addActionListener(
                new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt, studentD);
            }
        });
        studentD.getjButton4().addActionListener(
                new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt, studentD);
            }
        });
        studentD.getjTable1().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });

        tableViewStudent();
        tableViewCourse();
        studentD.getjTextField1().setText(String.valueOf(stu.getMax()));
        studentD.getjTextField9().setText(String.valueOf(courseDao.getMax()));

        studentD.setVisible(true);
    }
//add

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt, StudentD studentD) {
        if (isEmptyStudent()) {
            StudentModel stdModel = new StudentModel();
            stdModel.setId(stu.getMax());
            stdModel.setSname(studentD.getjTextField2().getText());
            stdModel.setBirthday(studentD.getjTextField3().getText());
            stdModel.setGender(studentD.getjComboBox1().getSelectedItem().toString());
            stdModel.setPhone(studentD.getjTextField6().getText());
            
            studentDao.addStudent(stdModel);
            
            
//            int id = stu.getMax();
//            String name = studentD.getjTextField2().getText();
//            String date_of_birth = studentD.getjTextField3().getText();
//            String gender = studentD.getjComboBox1().getSelectedItem().toString();
//            String phone = studentD.getjTextField6().getText();
//            stu.insert(id, name, date_of_birth, gender, phone);

            studentD.getjTable1().setModel(new DefaultTableModel(null, new Object[]{"Student ID", "Full Name", "Birth Day", "Gender", "Telephone Number"}));
            stu.getStudentValue(studentD.getjTable1(), "");
            clearStudent();
        }
    }

    public boolean isEmptyStudent() {
        if (studentD.getjTextField2().getText().isEmpty()) {
            JOptionPane.showMessageDialog(studentD, "Student name is missing");
            return false;
        }
        if (studentD.getjTextField3().getText().isEmpty()) {
            JOptionPane.showMessageDialog(studentD, "Student Birthday  is missing");
            return false;
        }

        if (studentD.getjTextField6().getText().isEmpty()) {
            JOptionPane.showMessageDialog(studentD, "Student Telephone Number is missing");
            return false;
        }
        return true;
    }

    private void clearStudent() {

        studentD.getjTextField1().setText(String.valueOf(stu.getMax()));
        studentD.getjTextField1().setText(null);
        studentD.getjTextField2().setText(null);
        studentD.getjTextField3().setText(null);
        studentD.getjComboBox1().setSelectedIndex(0);
        studentD.getjTextField6().setText(null);
        studentD.getjTable1().clearSelection();
    }

    //update
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt, StudentD studentD) {
        if (isEmptyStudent()) {
            StudentModel stdModel = new StudentModel();
            stdModel.setId(Integer.parseInt(studentD.getjTextField1().getText()));
            stdModel.setSname(studentD.getjTextField2().getText());
            stdModel.setBirthday(studentD.getjTextField3().getText());
            stdModel.setGender(studentD.getjComboBox1().getSelectedItem().toString());
            stdModel.setPhone(studentD.getjTextField6().getText());
            
            studentDao.updateStudent(stdModel);
            
            
//            stu.Update(id, name, date_of_birth, gender, phone);

            studentD.getjTable1().setModel(new DefaultTableModel(null, new Object[]{"Student ID", "Full Name", "Birth Day", "Gender", "Telephone Number"}));
            stu.getStudentValue(studentD.getjTable1(), "");
            clearStudent();
        }
    }
//     private void jButton15ActionPerformed(java.awt.event.ActionEvent evt, StudentD studentD) {
//        if (isEmptyStudent()) {
//            int id = Integer.parseInt(studentD.getjTextField1().getText());
//            String name = studentD.getjTextField2().getText();
//            String date_of_birth = studentD.getjTextField3().getText();
//            String gender = studentD.getjComboBox1().getSelectedItem().toString();
//            String phone = studentD.getjTextField6().getText();
//            stu.Update(id, name, date_of_birth, gender, phone);
//
//            studentD.getjTable1().setModel(new DefaultTableModel(null, new Object[]{"Student ID", "Full Name", "Birth Day", "Gender", "Telephone Number"}));
//            stu.getStudentValue(studentD.getjTable1(), "");
//            clearStudent();
//        }
//    }
    //clear

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt, StudentD studentD) {
        clearStudent();
    }
    //delete

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, StudentD studentD) {
        int id = Integer.parseInt(studentD.getjTextField1().getText());
        stu.delete(id);
        studentD.getjTable1().setModel(new DefaultTableModel(null, new Object[]{"Student ID", "Full Name", "Birth day", "Gender", "Telephone Number"}));
        stu.getStudentValue(studentD.getjTable1(), "");

        clearStudent();
    }
    //logout

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt, StudentD studentD) {
        int a = JOptionPane.showConfirmDialog(studentD, "Do you want to logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            studentD.dispose();
        }
    }

    private void tableViewStudent() {
        stu.getStudentValue(studentD.getjTable1(), "");
        model = (DefaultTableModel) studentD.getjTable1().getModel();
        studentD.getjTable1().setRowHeight(30);
        studentD.getjTable1().setShowGrid(true);
        studentD.getjTable1().setGridColor(Color.black);
        studentD.getjTable1().setBackground(Color.white);
    }

    private void tableViewCourse() {
        courseDao.getCoursetValue(studentD.getjTable2(), "");
        model = (DefaultTableModel) studentD.getjTable2().getModel();
        studentD.getjTable2().setRowHeight(30);
        studentD.getjTable2().setShowGrid(true);
        studentD.getjTable2().setGridColor(Color.black);
        studentD.getjTable2().setBackground(Color.white);
    }

    //course 
    //search
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt, StudentD studentD) {
        if (studentD.getjTextField7().getText().isEmpty()) {
            JOptionPane.showMessageDialog(studentD, "plese enter a student id");

        } else {
            int id = Integer.parseInt(studentD.getjTextField7().getText());
            if (courseDao.getId(id)) {
                studentD.getjComboBox7().removeAllItems();
                int semester = courseDao.countSemester(id);
                if (semester >= 0) {
                    for (int i = 1; i <= semester + 1; i++) {
                        studentD.getjComboBox7().addItem(i + "");
                    }
                }
            }
        }

    }
    //add

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt, StudentD studentD) {
        if (studentD.getjTextField8().getText().isEmpty() || studentD.getjComboBox7().getItemCount() == 0) {
            JOptionPane.showMessageDialog(studentD, "Student id or semester number is missing");
        } else {
//            stdModel.setId(Integer.parseInt(studentD.getjTextField1().getText()));

             CourseModel couModel = new CourseModel();
            couModel.setId(courseDao.getMax());
           couModel.setSid(Integer.parseInt(studentD.getjTextField8().getText()));
           couModel.setSemesterNo(Integer.parseInt(studentD.getjComboBox7().getSelectedItem().toString()));
           couModel.setSubject1(studentD.getjComboBox2().getSelectedItem().toString());
         couModel.setSubject2(studentD.getjComboBox5().getSelectedItem().toString());
         couModel.setSubject3(studentD.getjComboBox4().getSelectedItem().toString());
                   
                   
                  courseDao.addCourse(couModel); 

//            course.insert(id, sid, semester, subject1, subject2, subject3);
            studentD.getjTable2().setModel(new DefaultTableModel(null, new Object[]{"Course_ID", "Student_ID", "Semester", " Subject_1", " Subject_2", " Subject_3", " Subject_4"}));
            courseDao.getCoursetValue(studentD.getjTable2(), "");
            ClearCourse();

        }
    }
//       private void jButton5ActionPerformed(java.awt.event.ActionEvent evt, StudentD studentD) {
//        if (studentD.getjTextField8().getText().isEmpty() || studentD.getjComboBox7().getItemCount() == 0) {
//            JOptionPane.showMessageDialog(studentD, "Student id or semester number is missing");
//        } else {
//            int id = course.getMax();
//            int sid = Integer.parseInt(studentD.getjTextField8().getText());
//            int semester = Integer.parseInt(studentD.getjComboBox7().getSelectedItem().toString());
//            String subject1 = studentD.getjComboBox2().getSelectedItem().toString();
//            String subject2 = studentD.getjComboBox5().getSelectedItem().toString();
//            String subject3 = studentD.getjComboBox4().getSelectedItem().toString();
//
//            course.insert(id, sid, semester, subject1, subject2, subject3);
//            studentD.getjTable2().setModel(new DefaultTableModel(null, new Object[]{"Course_ID", "Student_ID", "Semester", " Subject_1", " Subject_2", " Subject_3", " Subject_4"}));
//            course.getCoursetValue(studentD.getjTable2(), "");
//            ClearCourse();
//
//        }
//    }

    public void ClearCourse() {
        studentD.getjTextField9().setText(String.valueOf(courseDao.getMax()));
        studentD.getjTextField8().setText(null);
        studentD.getjTextField7().setText(null);
        studentD.getjComboBox7().removeAllItems();
        studentD.getjComboBox2().setSelectedIndex(0);
        studentD.getjComboBox5().setSelectedIndex(0);
        studentD.getjComboBox4().setSelectedIndex(0);
        studentD.getjTable2().clearSelection();
    }
    //clear

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt, StudentD studentD) {
        ClearCourse();
    }
    //logout

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt, StudentD studentD) {
        int a = JOptionPane.showConfirmDialog(studentD, "Do you want to logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        model = (DefaultTableModel) studentD.getjTable1().getModel();
        rowIndex = studentD.getjTable1().getSelectedRow();
        studentD.getjTextField1().setText(model.getValueAt(rowIndex, 0).toString());
        studentD.getjTextField2().setText(model.getValueAt(rowIndex, 1).toString());
        studentD.getjTextField3().setText(model.getValueAt(rowIndex, 2).toString());
        String gender = model.getValueAt(rowIndex, 3).toString();
        if (gender.equals("male")) {
            studentD.getjComboBox1().setSelectedIndex(0);
        } else {
            studentD.getjComboBox1().setSelectedIndex(1);
        }
        studentD.getjTextField6().setText(model.getValueAt(rowIndex, 4).toString());
    }

}
