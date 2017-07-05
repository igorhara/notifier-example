package com.igorhara.example.web.controller;

import com.igorhara.example.ejb.entity.Notifier;
import com.igorhara.example.ejb.facade.NotifierFacade;
import com.igorhara.example.web.dto.DTO;
import com.igorhara.example.web.dto.NotifierDTO;
import com.igorhara.example.web.dto.NotifierDTOWithOwner;
import com.igorhara.example.web.dto.NotifierDTOWithOwnerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotifierController {

    private NotifierFacade facade;

    @Autowired
    public NotifierController(NotifierFacade facade) {
        this.facade = facade;
    }

    @RequestMapping(value = "/notifier/{id}/owner", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public DTO<Notifier> findNotifierWithOwner(@PathVariable("id") Long id) {
        return facade.getNotifier(new NotifierDTOWithOwner(), id);
    }

    @RequestMapping(value = "/notifier/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public DTO<Notifier> findNotifier(@PathVariable("id") Long id) {
        return facade.getNotifier(new NotifierDTOWithOwnerId(), id);
    }

    @RequestMapping(value = "/notifiers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DTO<Notifier> createNotifier(@RequestBody NotifierDTO dto) {
        return facade.createNotifierWithName(dto, dto.getName());
    }

    @RequestMapping(value = "/notifier", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DTO<Notifier>> listNotifiers() {
        return facade.listNotifiers(new NotifierDTO());
    }
}
