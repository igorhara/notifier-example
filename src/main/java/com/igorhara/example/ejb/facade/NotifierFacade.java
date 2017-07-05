package com.igorhara.example.ejb.facade;

import com.igorhara.example.ejb.entity.Notifier;
import com.igorhara.example.ejb.service.NotifierService;
import com.igorhara.example.web.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        return dto.populateDTO(notifier);

    }

    public List<DTO<Notifier>> listNotifiers(DTO<Notifier> dto){
        List<Notifier> notifiers = notifierServiceBean.listNotifiers();

        return notifiers.stream().map(dto::populateDTO).collect(Collectors.toList());
    }


    public DTO<Notifier> createNotifierWithName(DTO<Notifier> dto, String name){
        Notifier notifier = notifierServiceBean.createNotifierWithName(name);
        return dto.populateDTO(notifier);
    }
}
