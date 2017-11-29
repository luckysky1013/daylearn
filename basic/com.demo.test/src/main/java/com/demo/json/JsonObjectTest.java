package com.demo.json;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class JsonObjectTest {
	@Test
	public void jsonTx(){
		String json="{'status':200,'message':'查询成功','data':[{'id':1,'name':name1','desribe':'第一条数据'}]}";
		
		JSONObject data=new JSONObject(json);
		int status=data.optInt("status");
		JSONArray jsonArray=data.getJSONArray("data");
		if(status==200){
			for (int i = 0; i < jsonArray.length(); i++) {
				String s=jsonArray.getString(i).toString();
				System.out.println(s);
				JSONObject data1=new JSONObject(s);
				System.out.println(data1.getString("id"));
				System.out.println(data1.getString("name"));
				System.out.println(data1.getString("describe"));
			}
		}else{
			String msg=data.getString("message");
			System.out.println(msg);
		}
		
		
	}
}
