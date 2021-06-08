package com.learning.requestPayloadBody;

public class UpdatePayload {
	
	public static String updatePayload(String placeid, String address)
	{
		String updatepayloadbody="{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\""+address+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
		return updatepayloadbody;
	}

}
