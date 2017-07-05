package com.igorhara.example.web.controller;

import com.igorhara.example.ejb.entity.Notifier;
import com.igorhara.example.ejb.facade.NotifierFacade;
import com.igorhara.example.web.dto.DTO;
import com.igorhara.example.web.dto.NotifierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotifierController {

    private NotifierFacade facade;

    @Autowired
    public NotifierController(NotifierFacade facade) {
        this.facade = facade;
    }

    @RequestMapping(value = "/notifiers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public DTO<Notifier> findNotifier(@PathVariable("id") Long id) {
        return facade.getNotifier(new NotifierDTO(), id);
    }

    @RequestMapping(value = "/notifiers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DTO<Notifier> createNotifier(@RequestBody NotifierDTO dto) {
        return facade.createNotifierWithName(dto, dto.getName());
    }
}
