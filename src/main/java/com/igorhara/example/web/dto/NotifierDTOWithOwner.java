package com.igorhara.example.web.dto;

import com.igorhara.example.ejb.entity.Notifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serafig on 05/07/2017.
 */
public class NotifierDTOWithOwner extends NotifierDTOWithOwnerId{
    private String ownerName;

    private List<String> ownerAddresses;

    public NotifierDTOWithOwner() {
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<String> getOwnerAddresses() {
        return ownerAddresses;
    }

    public void setOwnerAddresses(List<String> ownerAddresses) {
        this.ownerAddresses = ownerAddresses;
    }

    public NotifierDTOWithOwner(Notifier notifier) {
        super(notifier);
        if(notifier.getOwner()!=null){
            this.ownerName = notifier.getOwner().getName();
            this.ownerAddresses = new ArrayList<>(notifier.getOwner().getAddresses());
        }
    }

    @Override public NotifierDTO populateDTO(Notifier notifier) {
        return new NotifierDTOWithOwner(notifier);
    }
}
