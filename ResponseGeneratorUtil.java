import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author Waqar Ahmad
 *
 * @date Sep 19, 2021
 */
@Component
public class ResponseGeneratorUtility {

	private ResponseGeneratorUtility() {
	}

	public static ResponseEntity<Object> jsonResponse(HttpStatus status, String message, String objectName,
			Object data) {

		Map<String, Object> json = new HashMap<>();

		json.put("message", message);
		json.put("status", status.value());
		json.put(objectName, data);

		return new ResponseEntity<>(json, status);

	}

	public static ResponseEntity<Object> jsonResponse(HttpStatus status, String message, Map<String, Object> data) {

		Map<String, Object> json = new HashMap<>();

		json.put("message",  message);
		json.put("status", status.value());
		json.putAll(data);

		return new ResponseEntity<>(json, status);

	}

	public static ResponseEntity<Object> jsonResponse(HttpStatus status, String message) {

		Map<String, Object> json = new HashMap<>();

		json.put("message",  message);
		json.put("status", status.value());
		return new ResponseEntity<>(json, status);

	}

	public static ResponseEntity<Object> jsonResponseError(HttpStatus status, String message, String code) {

		Map<String, Object> json = new HashMap<>();

		json.put("message",  message);
		json.put("error", status.name());
		json.put("status", code);
		return new ResponseEntity<>(json, status);

	}

	public static ResponseEntity<Object> jsonResponseError(HttpStatus status, String message, String code,
			Map<String, Object> data) {

		Map<String, Object> json = new HashMap<>();

		json.put("message",  message);
		json.put("error", status.name());
		json.put("status", code);
		json.putAll(data);
		return new ResponseEntity<>(json, status);

	}

	public static ResponseEntity<Object> jsonResponse(HttpStatus status, Map<String, String> data) {

		Map<String, Object> json = new HashMap<>();

		json.put("message", status.name());
		json.put("status", status.value());
		json.put("error", data);
		return new ResponseEntity<>(json, status);

	}

	public static ResponseEntity<Object> jsonResponse(HttpStatus status, Object data) {
		return new ResponseEntity<>(data, status);
	}


	// public static ResponseEntity<Object> errorResponse(HttpStatus status, List<ErrorDto> data) {

	// 	ReponseDto errorResponseDto = new ReponseDto();
	// 	errorResponseDto.setStatus(status.value());
	// 	errorResponseDto.setErrors(data);
	// 	return new ResponseEntity<>(errorResponseDto, status);
	// }

	// public static ResponseEntity<Object> errorResponse(HttpStatus status, List<ErrorDto> errorData,Map<String,Object> data) {

	// 	Map<String, Object> json = new HashMap<>();

	// 	json.put("error", errorData);
	// 	json.put("status", status.value());
	// 	json.putAll(data);
	// 	return new ResponseEntity<>(json, status);

	// }

	// public static ResponseEntity<Object> errorResponse(HttpStatus status, String message, String code) {

	// 	ReponseDto errorResponseDto = new ReponseDto();
	// 	List<ErrorDto> errorList = new ArrayList<>();
	// 	errorList.add(new ErrorDto(message, code, ""));
	// 	errorResponseDto.setStatus(status.value());
	// 	errorResponseDto.setErrors(errorList);
	// 	return new ResponseEntity<>(errorResponseDto, status);
	// }

}
