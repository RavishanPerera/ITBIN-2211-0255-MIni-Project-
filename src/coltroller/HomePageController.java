/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coltroller;

import View.HomePage;
import View.OtherActivities;
import View.StudentD;
import View.SubjectDetails;

/**
 *
 * @author Ravishan
 */
public class HomePageController {

    public HomePageController() {
        HomePage homePage = new HomePage();
        homePage.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        homePage.getjButton3().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        homePage.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        homePage.setVisible(true);

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
//        StudentD stdd = new StudentD();
//        stdd.setVisible(true);
        new StudentDController();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        OtherActivities act = new OtherActivities();
        act.setVisible(true);

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        SubjectDetails sud = new SubjectDetails();
        sud.setVisible(true);
//        new StudentDController();
    }
}
