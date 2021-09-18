
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 * @author Waqar Ahmad
 *
 * @date Sep 19, 2021
 */

public class ResponseGenerator {
	public static ResponseEntity<Object> jsonResponse(HttpStatus code, String status, String message, Object data) {

		ReponseDto response = new ReponseDto();
		response.setCode(code.value());
		response.setStatus(status);
		response.setMessage(message);
		response.setData(data);

		return new ResponseEntity<Object>(response, code);

	}

	public static ResponseEntity<Object> jsonResponse(HttpStatus code, String status, String message, Object data,
			Object errors) {

		ReponseDto response = new ReponseDto();
		response.setCode(code.value());
		response.setStatus(status);
		response.setMessage(message);
		response.setErrors(errors);

		return new ResponseEntity<Object>(response, code);

	}
	
}
