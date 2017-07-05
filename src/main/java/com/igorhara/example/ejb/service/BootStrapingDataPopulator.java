package com.igorhara.example.ejb.service;

import com.igorhara.example.ejb.dao.NotifierDAO;
import com.igorhara.example.ejb.dao.OwnerDAO;
import com.igorhara.example.ejb.entity.Notifier;
import com.igorhara.example.ejb.entity.Owner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by serafig on 05/07/2017.
 */
@Service
public class BootstrapingDataPopulator implements InitializingBean {

    @Autowired
    private NotifierDAO notifierDAO;

    @Autowired
    private OwnerDAO ownerDAO;



    private final Logger LOG = LoggerFactory.getLogger(BootstrapingDataPopulator.class);


    @Override
    @Transactional()
    public void afterPropertiesSet() throws Exception {
        LOG.info("Bootstrapping data...");

        createOwners();
        createNotifiers();


        LOG.info("...Bootstrapping completed");
    }

    private void createOwners() {
        if (ownerDAO.count() != 0) {
            return;
        }

        LOG.info("... creating owners");

        Owner owner = new Owner();
        owner.setName("First Owner");

        owner.getAddresses().add("First address");
        owner.getAddresses().add("Second address");
        ownerDAO.saveAndFlush(owner);


        Owner owner2 = new Owner();
        owner2.setName("Second Owner");

        owner2.getAddresses().add("Third address");
        owner2.getAddresses().add("Fourth address");
        ownerDAO.saveAndFlush(owner2);
    }

    private void createNotifiers() {
        if (notifierDAO.count() != 0) {
            return;
        }

        LOG.info("... creating notifiers");

        Notifier notifier = new Notifier();
        notifier.setName("Notifier 1");
        notifier.setOwner(ownerDAO.getOne(1l));

        notifierDAO.saveAndFlush(notifier);

        notifier = new Notifier();
        notifier.setName("Notifier 2");
        notifier.setOwner(ownerDAO.getOne(1l));

        notifierDAO.saveAndFlush(notifier);


        notifier = new Notifier();
        notifier.setName("Notifier 3");
        notifier.setOwner(ownerDAO.getOne(2l));

        notifierDAO.saveAndFlush(notifier);


        notifier = new Notifier();
        notifier.setName("Notifier 4");
        notifier.setOwner(ownerDAO.getOne(2l));

        notifierDAO.saveAndFlush(notifier);



    }


}
