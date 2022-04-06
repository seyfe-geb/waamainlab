package net.seyfe.waamainlab.service;


import net.seyfe.waamainlab.domain.*;
import net.seyfe.waamainlab.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService{
    @Autowired
    LoggerRepo loggerRepo;

    @Override
    public void saveLog(Logger logger) {
        loggerRepo.save(logger);
    }
}
