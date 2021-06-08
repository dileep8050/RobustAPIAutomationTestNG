package com.learning.requestPayloadBody;

public class DeletePayload {
	public static String deletePayload(String placeid)
	{
		String deletePayloadbody="{\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}";
		return deletePayloadbody;
	}

}
