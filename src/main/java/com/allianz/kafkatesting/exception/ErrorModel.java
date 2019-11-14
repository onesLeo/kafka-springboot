package com.allianz.kafkatesting.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;


@Setter
@Getter
@AllArgsConstructor
public class ErrorModel {
    private String errorMessage;
    private ZonedDateTime time;
    private int httpStatus;

}
