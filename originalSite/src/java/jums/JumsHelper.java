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
public class JumsHelper {
        
    //トップへのリンクを定数として設定
        private final String homeURL = "search.jsp";
    //インスタンスオブジェクトを返却させてコードの簡略化
public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    //トップへのリンクを返却
public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
         /**
     * 入力されたデータのうち未入力項目がある場合、チェックリストにしたがいどの項目が
     * 未入力なのかのhtml文を返却する
     * @param chkList　UserDataBeansで生成されるリスト。未入力要素の名前が格納されている
     * @return 未入力の項目に対応する文字列
     */
public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("name")){
                    output += "名前";
                }
                if(val.equals("password")){
                    output +="パスワード";
                }
                if(val.equals("mail")){
                    output +="メールアドレス";
                }
                if(val.equals("addres")){
                    output +="住所";
                }
                if(val.equals("reviews")){
                    output += "感想";
                }
                if(val.equals("evaluation")){
                    output +="評価";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
public String chkreviews(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("reviews")){
                    output += "感想";
                }
                if(val.equals("evaluation")){
                    output +="評価";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
    
}
    
