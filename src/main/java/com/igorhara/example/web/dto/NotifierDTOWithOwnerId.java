package com.igorhara.example.web.dto;

import com.igorhara.example.ejb.entity.Notifier;

/**
 * Created by serafig on 05/07/2017.
 */
public class NotifierDTOWithOwnerId extends NotifierDTO {

    private Long ownerId;

    public NotifierDTOWithOwnerId() {
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public NotifierDTOWithOwnerId(Notifier notifier) {
        super(notifier);
        if(notifier.getOwner()!=null){
            this.ownerId = notifier.getOwner().getId();
        }
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Override public NotifierDTO populateDTO(Notifier notifier) {
        return new NotifierDTOWithOwnerId(notifier);
    }
}
