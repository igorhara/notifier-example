package com.igorhara.example.web.dto;

import com.igorhara.example.ejb.entity.Notifier;

public class NotifierDTO implements DTO<Notifier> {

    private Long notifierId;

    private String name;

    public NotifierDTO() {
        super();
    }

    protected NotifierDTO(Notifier notifier) {
        this.notifierId = notifier.getId();
        this.name = notifier.getName();
    }

    public Long getNotifierId() {
        return notifierId;
    }

    public void setNotifierId(Long notifierId) {
        this.notifierId = notifierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public NotifierDTO populateDTO(Notifier notifier) {
        return new NotifierDTO(notifier);
    }
}
