package vn.tayjava.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseSuccess extends ResponseEntity<ResponseSuccess.Playload> {

    //PUT, PATCH, DELETE
    public ResponseSuccess(HttpStatusCode status,String message) {
        super(new Playload(status.value(),message),HttpStatus.OK);
    }
    //GET, POST
    public ResponseSuccess(HttpStatusCode status,String message, Object data) {
        super(new Playload(status.value(),message,data), HttpStatus.OK);
    }



    public static class Playload{
        public final int status;
        public final String message;
        private Object data;

        public Playload(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public Playload(int status,String message, Object data) {
            this.status = status;
            this.message = message;
            this.data = data;
        }

        public int getStatus() {
            return status;
        }
        public String getMessage() {
            return message;
        }
        public Object getData() {
            return data;
        }

    }
}
