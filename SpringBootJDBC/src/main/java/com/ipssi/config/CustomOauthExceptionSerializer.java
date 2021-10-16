package com.ipssi.config;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ipssi.constant.StatusMaster;


public class CustomOauthExceptionSerializer extends StdSerializer<UserOauthException> {

	private static final long serialVersionUID = 1L;

	public CustomOauthExceptionSerializer() {
		super(UserOauthException.class);
	}

	@Override
	public void serialize(UserOauthException value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		if (value.getMessage().equalsIgnoreCase("Block Users")) {
			gen.writeStringField("error", "" + StatusMaster.BLOCKED_USER.getResponseCode());
			gen.writeStringField("error_description", "" + StatusMaster.BLOCKED_USER.getResponseDescription());
		} else if (value.getMessage().equalsIgnoreCase("Deactivate Users")) {
			gen.writeStringField("error", "" + StatusMaster.DEACTIVATE_USER.getResponseCode());
			gen.writeStringField("error_description", "" + StatusMaster.DEACTIVATE_USER.getResponseDescription());
		} else if (value.getMessage().equalsIgnoreCase("Assign Permission")) {
			gen.writeStringField("error", "" + StatusMaster.ASSIGN_USER.getResponseCode());
			gen.writeStringField("error_description", "" + StatusMaster.ASSIGN_USER.getResponseDescription());
		} else if (value.getMessage().equalsIgnoreCase("MAX attempt")) {
			gen.writeStringField("error", "" + StatusMaster.MAX_ATTEMPT.getResponseCode());
			gen.writeStringField("error_description", "" + StatusMaster.MAX_ATTEMPT.getResponseDescription());
		} else {
			gen.writeStringField("error", "" + StatusMaster.INVALID_USER_NAME_PASSWORD.getResponseCode());
			gen.writeStringField("error_description",
					"" + StatusMaster.INVALID_USER_NAME_PASSWORD.getResponseDescription());
		}
		if (value.getAdditionalInformation() != null) {
			for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
				String key = entry.getKey();
				String add = entry.getValue();
				gen.writeStringField(key, add);
			}
		}
		gen.writeEndObject();
	}

}