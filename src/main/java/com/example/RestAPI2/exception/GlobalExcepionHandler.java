//package com.example.RestAPI2.exception;
//
//import com.example.RestAPI2.dto.ApiErrorResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.Date;
//
////import static java.lang.StableValue.map;
//import static java.util.spi.ToolProvider.findFirst;
//
//@RestControllerAdvice
//public class GlobalExcepionHandler {
//    @ExceptionHandler(ResoueceNotFountException.class)
//    public ResponseEntity<ApiErrorResponse> handleNotFound(
//            ResoueceNotFountException ex,
//            HttpServletRequest request
//    ){
//        ApiErrorResponse error = new ApiErrorResponse(
//                new Date(),
//                HttpStatus.NOT_FOUND.value(),
//                "Resourse Not Found",
//                ex.getMessage(),
//                request.getRequestURI()
//        );
//                return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(BadRequestException.class)
//    public ResponseEntity<ApiErrorResponse> handleBadResponse(
//            BadRequestException ex,
//            HttpServletRequest request
//    ){
//        ApiErrorResponse error = new ApiErrorResponse(
//                new Date(),
//                HttpStatus.BAD_REQUEST.value(),
//                "Bad Request",
//                ex.getMessage(),
//                request.getRequestURI()
//        );
//        return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);
//    }
//
////    @ExceptionHandler(MethodArgumentNotValidException.class)
////    public ResponseEntity<ApiErrorResponse> handleBadResponse(
////            MethodArgumentNotValidException ex,
////            HttpServletRequest request
////    ){
////        String message =  ex.getBindingResult()
////                .getFieldError().stream().map(FieldError::getDefaultMessage)
////                .findFirst()
////                .orElse("validatoin error");
////
////        ApiErrorResponse error = new ApiErrorResponse(
////                new Date(),
////                HttpStatus.BAD_REQUEST.value(),
////                "Validation Failed",
////               message,
////                request.getRequestURI()
////        );
////
////        return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);
////    }
//}
//
