/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author QUOC-TRONG
 */
public class Users {
    private long userID;
    private String userMail;
    private String userPass;
    private boolean userRole;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public boolean isUserRole() {
        return userRole;
    }

    public void setUserRole(boolean userRole) {
        this.userRole = userRole;
    }

    public Users(long userID, String userMail, String userPass, boolean userRole) {
        this.userID = userID;
        this.userMail = userMail;
        this.userPass = userPass;
        this.userRole = userRole;
    }

    public Users() {
    }
}
