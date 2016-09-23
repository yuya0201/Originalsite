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
public class ReviewsDataDTO {
    private String reviews;
    private int evaluation; 
    private int reviewsID;
    
public void setReviewsID(int reviewsID){
    this.reviewsID = reviewsID;
}
public int getReviewsID(){
    return reviewsID;
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
}
