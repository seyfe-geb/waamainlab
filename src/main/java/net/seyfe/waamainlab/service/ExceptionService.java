package net.seyfe.waamainlab.service;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ExceptionService {
    void logException(LocalDate date, LocalTime time, String principle, String operation, String exceptionType);
}
