/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

/**
 *
 * @author yuya
 */
public class UserDataDTO {
    private String name;
    private int    userID;
    private String mail;
    private String addres;
    private String password;
    private String tell;
    private String reviews;
    private int evaluation;
    private int salonID;
    
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
public void setReviews(String reviews){
    this.reviews = reviews;
}
public String getReviews(){
    return reviews;
}
public void setEvaluation(int evaluation){
    this.evaluation =  evaluation;
}
public int getEvaluation(){
    return evaluation;
}
public void setSalonID(int salonID){
    this.salonID = salonID;
}
public int getSalonID(){
    return salonID;
}

}