/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coltroller;

import View.HomePage;
import View.LoginInfo;

/**
 *
 * @author Ravishan
 */
public class LoginInfoController {

    public LoginInfoController() {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        loginInfo.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        loginInfo.getjCheckBox1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt, loginInfo);
            }
        });

        loginInfo.setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        HomePageController home = new HomePageController();
    }

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt, LoginInfo loginInfo) {
        if (loginInfo.getjCheckBox1().isSelected()) {
            loginInfo.getjPasswordField1().setEchoChar((char) 0);
        } else {
            loginInfo.getjPasswordField1().setEchoChar('*');
        }

    }
}
