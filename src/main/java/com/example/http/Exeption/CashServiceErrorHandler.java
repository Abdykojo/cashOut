package com.example.http.Exeption;
import com.example.http.commons.RespMessage;
import com.example.http.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class CashServiceErrorHandler {
    @ExceptionHandler(CashExeption.class)
    public ResponseEntity<BaseResponse> serverExeption(CashExeption exeption) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BaseResponse.builder()
                .code(RespMessage.SERVICE_NOT_RABOTAT.getStatus())
                .message(RespMessage.SERVICE_NOT_RABOTAT.getMessage())
                .build());
    }

    @ExceptionHandler(UserNotFoundExeption.class)
    public ResponseEntity<BaseResponse> userExeption(UserNotFoundExeption exeption) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(BaseResponse.builder()
                .code(RespMessage.USER_NOT_FOUND.getStatus())
                .message(RespMessage.USER_NOT_FOUND.getMessage())
                .build());

    }

    @ExceptionHandler(BalanceExeption.class)
    public ResponseEntity<BaseResponse> balanceExeption(BalanceExeption ex) {
        return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(BaseResponse.builder()
                .code(RespMessage.NOT_MONEY.getStatus())
                .message(RespMessage.NOT_MONEY.getMessage())
                .build());

    }

    @ExceptionHandler(QuidExeption.class)
    public ResponseEntity<BaseResponse> quidExeption(QuidExeption ex) {
        return ResponseEntity.status(HttpStatus.IM_USED).body(BaseResponse.builder()
                .code(RespMessage.QID_IS_PRESENT.getStatus())
                .message(RespMessage.QID_IS_PRESENT.getMessage())
                .build());

    }
    @ExceptionHandler(BadRequestExeption.class)
    public ResponseEntity<BaseResponse> badRequestExeption(BadRequestExeption ex) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(BaseResponse.builder()
                .code(RespMessage.BAD_REQUEST.getStatus())
                .message(RespMessage.BAD_REQUEST.getMessage())
                .build());

    }
    @ExceptionHandler(AuthenticationExeption.class)
    public ResponseEntity<BaseResponse> badRequestExeption(AuthenticationExeption ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(BaseResponse.builder()
                .code(RespMessage.NOT_AUTH.getStatus())
                .message(RespMessage.NOT_AUTH.getMessage())
                .build());
    }
    @ExceptionHandler(CreditExeption.class)
    public ResponseEntity<BaseResponse> creditExeption(CreditExeption ex) {
        return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body(BaseResponse.builder()
                .code(RespMessage.LARGE_SUM.getStatus())
                .message(RespMessage.LARGE_SUM.getMessage())
                .build());

    }
    @ExceptionHandler(CreditsLimitsExeption.class)
    public ResponseEntity<BaseResponse> creditLimitExeption(CreditsLimitsExeption ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(BaseResponse.builder()
                .code(RespMessage.CREDIT_LIMITS.getStatus())
                .message(RespMessage.CREDIT_LIMITS.getMessage())
                .build());

    }
}
