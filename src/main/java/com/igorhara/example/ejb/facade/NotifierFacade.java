package com.igorhara.example.ejb.facade;

import com.igorhara.example.ejb.entity.Notifier;
import com.igorhara.example.ejb.service.NotifierService;
import com.igorhara.example.web.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class NotifierFacade {

    private NotifierService notifierServiceBean;

    @Autowired
    public NotifierFacade(NotifierService notifierServiceBean) {
        this.notifierServiceBean = notifierServiceBean;
    }

    public DTO<Notifier> getNotifier(DTO<Notifier> dto, Long id){
        Notifier notifier = notifierServiceBean.getNotifier(id);
        dto.populateDTO(notifier);
        return dto;
    }

    public DTO<Notifier> createNotifierWithName(DTO<Notifier> dto, String name){
        Notifier notifier = notifierServiceBean.createNotifierWithName(name);
        return dto.populateDTO(notifier);
    }
}
