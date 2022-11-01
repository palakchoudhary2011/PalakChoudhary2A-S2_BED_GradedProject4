package com.gl.customexceptionjson;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CustomJson {
	private final String errorMessage;
}
