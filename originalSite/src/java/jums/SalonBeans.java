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
public class SalonBeans {
    private String name_kana;
    private String access;
    private String access_navi;
    private String addres;
    private String capacity;
    private String catch_copy;
    private String close;
    private String description;
    private String image;
    private String url;
    private int userID;
    private int price;
    private int salonID;

public SalonBeans(){
    name_kana = "";
    access = "";
    access_navi = "";
    addres = "";
    capacity = "";
    catch_copy = "";
    description = "";
    close = "";
    image = "";
    price = 0;
    salonID = 0;
   
    
}

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
public void setUrl(String url){
    this.url = url;
}
public String getUrl(){
    return url;
}
public void UD2DTOMapping(SalonDataDTO sdd){
    sdd.setUserID(this.userID);
    sdd.setName(this.name_kana);
    sdd.setAccess(this.access);
    sdd.setAccess_navi(this.access_navi);
    sdd.setAddres(this.addres);
    sdd.setCapacity(this.capacity);
    sdd.setCatch_copy(this.catch_copy);
    sdd.setClose(this.close);
    sdd.setDescription(this.description);
    sdd.setImage(this.image);
    sdd.setPrice(this.price); 
    sdd.setSalonID(this.salonID);
    sdd.setUrl(this.url);
        } 
public void DTO2UDMapping(SalonDataDTO sdd){
    this.userID = sdd.getUserID();
    this.salonID = sdd.getSalonID();
    this.name_kana = sdd.getName();
    this.access = sdd.getAccess();
    this.access_navi = sdd.getAccess_navi();
    this.addres = sdd.getAddres();
    this.capacity = sdd.getCapacity();
    this.catch_copy = sdd.getCatch_copy();
    this.close = sdd.getClose();
    this.description = sdd.getDescription();
    this.image = sdd.getImage();
    this.price = sdd.getPrice();
    this.url = sdd.getUrl();   
        }   
}




