package br.com.erudio.controllers;

import br.com.erudio.services.PersonServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @RequestMapping("/test")
    public String testLog(){
        logger.debug("This is an INFO Log");
        logger.info("This is an INFO Log" );
        logger.warn("This is an INFO Log");
        logger.error("This is an INFO Log");
        return "Logs generated successfully";
    }

}
