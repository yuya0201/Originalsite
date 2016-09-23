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
public class SalonDataDTO {
    private String name_kana;
    private String access;
    private String access_navi;
    private String addres;
    private String capacity;
    private String catch_copy;
    private String close;
    private String description;
    private String image;
    private String reviews;
    private String url;
    private int userID;
    private int evaluation; 
    private int price;
    private int salonID;
    

public void setName(String name_kana){
    this.name_kana= name_kana;
}
public String getName(){
    return name_kana;
}
public void setAccess(String access){
    this.access = access;
}
public String getAccess(){
    return access;
} 
public void setAccess_navi(String  access_navi){
    this.access_navi =  access_navi;
}
public String getAccess_navi(){
    return  access_navi;
}
public void setAddres(String addres){
    this.addres = addres;
}
public String getAddres(){
    return addres;
}
public void setCapacity(String capacity){
    this.capacity = capacity;
}
public String getCapacity(){
    return capacity;
}
public void  setCatch_copy(String  catch_copy){
    this.catch_copy =  catch_copy;
}
public String getCatch_copy(){
    return  catch_copy;
}
public void setClose(String  close){
    this.close =  close;
}
public String getClose(){
    return  close;
}
public void setImage(String image){
    this.image = image;
}
public String getImage(){
    return image;
}
public void setPrice(int price){
    this.price = price;
}
public int getPrice(){
    return price;
}
public void setDescription(String description){
    this.description = description;
}
public String getDescription(){
    return description;
}
public void setSalonID(int salonID){
    this.salonID = salonID;
}
public int getSalonID(){
    return salonID;
}
public void setReviews(String reviews){
    this.reviews = reviews;
}
public String getReviews(){
    return reviews;
}
public void setEvaluation(int evaluation){
         if(evaluation==0){
            this.evaluation = 0;
        }else{
            this.evaluation = evaluation;
        }
    }

public int getEvaluation(){
    return evaluation;
}
public void setUrl(String url){
    this.url = url;
}
public String getUrl(){
    return url;
}
public void setUserID(int userID){
    this.userID = userID;
}
public int getUserID(){
    return userID;
}
}
