package com.newberry.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.newberry.util.Consts;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LocalDateDeserializer
	extends JsonDeserializer<LocalDate>
{

	@Override
	public LocalDate deserialize(JsonParser jsonParser, DeserializationContext context)
		throws IOException, JsonProcessingException
	{
		LocalDate retVal = null;
		if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
			String s = jsonParser.getText().trim();
			if (!s.isEmpty()) {
				try {
					retVal = LocalDate.parse(s, Consts.DOB_FORMATTER);
				} catch (IllegalArgumentException ex) {
					System.out.println("Cannot parse date format. " + ex.getMessage());
				}
			}
		}
		return retVal;
	}

}
