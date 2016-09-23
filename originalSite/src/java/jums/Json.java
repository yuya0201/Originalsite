/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author yuya
 */
public class Json {
       //URL先の情報をStringで返却するメソッド
    public  String getResult(String urlString){ 
	String result = "";
	try{
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tmp = "";
                while ((tmp = in.readLine()) != null){
                    result += tmp;
                }
            in.close();
            con.disconnect();
	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
    }
    //文字列からJSONの変換
  public static JsonNode getJsonNode(String jsonString){
        JsonNode head = null;
        try{
            JsonFactory jfactory = new JsonFactory();
            JsonParser parser = jfactory.createJsonParser(jsonString);
            ObjectMapper mapper = new ObjectMapper(); 
            head = mapper.readTree(parser);
        }catch(Exception e){
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return head;
  }
  
    public static ArrayList<SalonBeans> getSalonList(JsonNode head){
        ArrayList<SalonBeans> ary = new ArrayList<SalonBeans>();
        int  n = head.get("results").get("salon").size();
        for(int i = 0; i<head.get("results").get("salon").size(); i++){
            SalonBeans sb = new SalonBeans();

            sb.setName(head.get("results").get("salon").get(i).get("name").getTextValue());
            sb.setAccess(head.get("results").get("salon").get(i).get("access").getTextValue());
            sb.setAccess_navi(head.get("results").get("salon").get(0).get("access_navi").getTextValue());
            sb.setAddres(head.get("results").get("salon").get(i).get("address").getTextValue());
            sb.setCapacity(head.get("results").get("salon").get(i).get("capacity").getTextValue());
            sb.setCatch_copy(head.get("results").get("salon").get(i).get("catch_copy").getTextValue());
            sb.setClose(head.get("results").get("salon").get(i).get("close").getTextValue());   
            
            if((head.get("results").get("salon").get(i).get("header").get("photo").get(0)!=null)){
                sb.setImage(head.get("results").get("salon").get(i).get("header").get("photo").get(0).getTextValue());
            }
            sb.setUrl(head.get("results").get("salon").get(i).get("urls").get("pc").getTextValue());
            ary.add(sb);
        }
        return ary;
    }
}
