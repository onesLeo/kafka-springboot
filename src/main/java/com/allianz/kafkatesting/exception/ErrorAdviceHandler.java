package com.allianz.kafkatesting.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.ZonedDateTime;

@ControllerAdvice
@Slf4j
public class ErrorAdviceHandler {
    @ExceptionHandler(value = KafkaProducerException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorModel errorHandling(KafkaProducerException kpe) {
        log.info("Kafka Producer Exception ", kpe);
        return new ErrorModel(kpe.getMessage(), ZonedDateTime.now(), HttpStatus.BAD_REQUEST.value());
    }
}
