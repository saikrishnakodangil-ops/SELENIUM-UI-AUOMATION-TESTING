package com.newberry.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.newberry.util.Consts;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LocalDateSerializer
	extends JsonSerializer<LocalDate>
{

	@Override
	public void serialize(LocalDate value, JsonGenerator jgen, SerializerProvider provider)
		throws IOException, JsonProcessingException
	{
		if(value != null) {
			jgen.writeString(Consts.DOB_FORMATTER.print(value));
		}
	}

}
