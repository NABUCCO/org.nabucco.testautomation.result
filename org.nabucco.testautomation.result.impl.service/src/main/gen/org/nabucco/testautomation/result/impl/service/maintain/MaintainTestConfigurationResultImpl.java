/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.impl.service.maintain;

import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.facade.service.maintain.MaintainTestConfigurationResult;

/**
 * MaintainTestConfigurationResultImpl<p/>TestConfigurationResult maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public class MaintainTestConfigurationResultImpl extends ServiceSupport implements
        MaintainTestConfigurationResult {

    private static final long serialVersionUID = 1L;

    private static final String ID = "MaintainTestConfigurationResult";

    private EntityManager em;

    private MaintainTestConfigurationResultServiceHandler maintainTestConfigurationResultServiceHandler;

    /** Constructs a new MaintainTestConfigurationResultImpl instance. */
    public MaintainTestConfigurationResultImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.maintainTestConfigurationResultServiceHandler = injector
                .inject(MaintainTestConfigurationResultServiceHandler.getId());
        if ((this.maintainTestConfigurationResultServiceHandler != null)) {
            this.maintainTestConfigurationResultServiceHandler.setEntityManager(this.em);
            this.maintainTestConfigurationResultServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<TestConfigurationResultMsg> maintainTestConfigurationResult(
            ServiceRequest<TestConfigurationResultMsg> rq) throws MaintainException {
        if ((this.maintainTestConfigurationResultServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for maintainTestConfigurationResult().");
            throw new InjectionException(
                    "No service implementation configured for maintainTestConfigurationResult().");
        }
        ServiceResponse<TestConfigurationResultMsg> rs;
        this.maintainTestConfigurationResultServiceHandler.init();
        rs = this.maintainTestConfigurationResultServiceHandler.invoke(rq);
        this.maintainTestConfigurationResultServiceHandler.finish();
        return rs;
    }
}
