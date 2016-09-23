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
public class ReviewsDataBeans {
    private String reviews;
    private int evaluation; 
    private int reviewsID;

public ReviewsDataBeans(){
    reviews = "";
    evaluation = 0;
}
public void setReviews(String reviews){
    this.reviews = reviews;
}
public String getReviews(){
    return reviews;
}
public void setEvaluation(String evaluation){
         if(evaluation.equals("")){
            this.evaluation = 0;
        }else{
            this.evaluation = Integer.parseInt(evaluation);
        }
    }

public int getEvaluation(){
    return evaluation;
}
public ArrayList<String> chkproperties(){
    ArrayList<String> chkList = new ArrayList<String>();
            if(this.reviews.equals("")){
                chkList.add("reviews");               
        }
            if(this.evaluation==0){
                chkList.add("evaluation");
        }
            return chkList;
        }  
public void UD2DTOMapping(SalonDataDTO sdd){
            sdd.setReviews(this.reviews);
            sdd.setEvaluation(this.evaluation);
            
            
        }   
    }


