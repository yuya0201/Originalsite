/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.util.ArrayList;

/**
 *
 * @author yuya
 */
public class UserDataBeans {
    private String name;
    private int    userID;
    private String mail;
    private String addres;
    private String password;
    private String tell;

public  UserDataBeans(){
    name = "";
    userID = 0;
    mail = "";
    addres = "";
    password = "";
    tell = "";
}
public void setName(String name){
    this.name = name;
}
public String getName(){
    return name;
}
public void setUserID(int userID){
    this.userID = userID;
}
public int getUserID(){
    return userID;
}
public void setMail(String mail){
    this.mail = mail;
}
public String getMail(){
    return mail;
}
public void setAddres(String addres){
    this.addres = addres;
}
public String getAddres(){
    return addres;
}
public void setPassword(String password){
    this.password = password;
} 
public String getPassword(){
    return password;
}
public void  setTell(String tell){
    this.tell = tell;
}
public String getTell(){
    return tell;
}

public ArrayList<String> chkproperties(){
    ArrayList<String> chkList = new ArrayList<String>();
            if(this.name.equals("")){
                chkList.add("name");               
        }
            if(this.password.equals("")){
                chkList.add("password");
        }
            if(this.mail.equals("")){
                chkList.add("mail");
        }
            if(this.addres.equals("")){
                chkList.add("addres");
        }
            return chkList;
        }  

public void UD2DTOMapping(UserDataDTO udd){
            udd.setUserID(this.userID);
            udd.setName(this.name);
            udd.setPassword(this.password);
            udd.setMail(this.mail);
            udd.setAddres(this.addres);
        }   
    }

