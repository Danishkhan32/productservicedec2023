package com.scaler.productservicedec2023.ControllerAdvices;

import com.scaler.productservicedec2023.Dto.ArithmeticExceptionDto;
import com.scaler.productservicedec2023.Dto.ExceptionDto;
import com.scaler.productservicedec2023.exceptions.ProductNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException(){
        ArithmeticExceptionDto arithmeticExceptionDto = new ArithmeticExceptionDto();
        arithmeticExceptionDto.setMessage("You need to check it");
        return new ResponseEntity<>(arithmeticExceptionDto, HttpStatus.OK);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Void>handleArrayIndexOutOfBoundsException(){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<ExceptionDto>handleProductNotExistsException(ProductNotExistsException exception){

        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(exception.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}
