package com.pgtest.util;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.pgtest.dto.CancelDTO;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UsingImPortAPI {
	private final String API_KEY = "";	// 아임포트 키 
	private final String API_SECRET = ""; // 아임포트 시크릿
	
	public String getToken() {
		OkHttpClient client = new OkHttpClient();
		String reqString = "{\"imp_key\" : \"" + API_KEY + "\",\"imp_secret\" : \"" + API_SECRET + "\"}";
		String token = "";
		
		Request request = new Request.Builder()
				.url("https://api.iamport.kr/users/getToken")
				.post(RequestBody.create(MediaType.parse("application/json"), reqString))
				.build();
		
		try {
			Response response = client.newCall(request).execute();
			
			String result = response.body().string();
			
			JsonObject jsonResult = new Gson().fromJson(result, JsonObject.class);
			token = jsonResult.getAsJsonObject("response").get("access_token").getAsString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return token;
	}
	
	public JsonObject getPaymentData(String imp_uid, String token) {
		OkHttpClient client = new OkHttpClient();
		JsonObject jsonResult = new JsonObject();
		
		Request request = new Request.Builder()
				.addHeader("Authorization", token)
				.url("https://api.iamport.kr/payments/"+imp_uid)
				.build();
		
		try {
			Response response = client.newCall(request).execute();
			
			String result = response.body().string();
			jsonResult = new Gson().fromJson(result, JsonObject.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonResult;
	}
	
	public JsonObject cancelPayment(CancelDTO dto, String token) {
		Gson gson = new Gson();
		String requestData = gson.toJson(dto);
		JsonObject jsonResult = new JsonObject();
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url("https://api.iamport.kr/payments/cancel")
				.addHeader("Authorization", token)
				.post(RequestBody.create(MediaType.parse("application/json"), requestData))
				.build();
		
		// 결과
		try {
			Response response = client.newCall(request).execute();
			
			String result = response.body().string();
			jsonResult = new Gson().fromJson(result, JsonObject.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonResult;
	}
}





















