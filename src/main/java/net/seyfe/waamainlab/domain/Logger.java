package net.seyfe.waamainlab.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private LocalDate date;
    private LocalTime time;
    private String principle;
    private String operation;

    public Logger(LocalDate date, LocalTime time, String principle, String operation) {
        this.date = date;
        this.time = time;
        this.principle = principle;
        this.operation = operation;
    }
}
