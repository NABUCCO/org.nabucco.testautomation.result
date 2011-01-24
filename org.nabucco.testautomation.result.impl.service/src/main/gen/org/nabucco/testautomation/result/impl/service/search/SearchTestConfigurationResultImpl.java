/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.impl.service.search;

import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultListMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultSearchMsg;
import org.nabucco.testautomation.result.facade.service.search.SearchTestConfigurationResult;

/**
 * SearchTestConfigurationResultImpl<p/>TestConfiguration search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-15
 */
public class SearchTestConfigurationResultImpl extends ServiceSupport implements
        SearchTestConfigurationResult {

    private static final long serialVersionUID = 1L;

    private static final String ID = "SearchTestConfigurationResult";

    private EntityManager em;

    private SearchTestConfigurationResultServiceHandler searchTestConfigurationResultServiceHandler;

    private GetTestConfigurationResultServiceHandler getTestConfigurationResultServiceHandler;

    /** Constructs a new SearchTestConfigurationResultImpl instance. */
    public SearchTestConfigurationResultImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.searchTestConfigurationResultServiceHandler = injector
                .inject(SearchTestConfigurationResultServiceHandler.getId());
        if ((this.searchTestConfigurationResultServiceHandler != null)) {
            this.searchTestConfigurationResultServiceHandler.setEntityManager(this.em);
            this.searchTestConfigurationResultServiceHandler.setLogger(super.getLogger());
        }
        this.getTestConfigurationResultServiceHandler = injector
                .inject(GetTestConfigurationResultServiceHandler.getId());
        if ((this.getTestConfigurationResultServiceHandler != null)) {
            this.getTestConfigurationResultServiceHandler.setEntityManager(this.em);
            this.getTestConfigurationResultServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<TestConfigurationResultListMsg> searchTestConfigurationResult(
            ServiceRequest<TestConfigurationResultSearchMsg> rq) throws SearchException {
        if ((this.searchTestConfigurationResultServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for searchTestConfigurationResult().");
            throw new InjectionException(
                    "No service implementation configured for searchTestConfigurationResult().");
        }
        ServiceResponse<TestConfigurationResultListMsg> rs;
        this.searchTestConfigurationResultServiceHandler.init();
        rs = this.searchTestConfigurationResultServiceHandler.invoke(rq);
        this.searchTestConfigurationResultServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<TestConfigurationResultMsg> getTestConfigurationResult(
            ServiceRequest<TestConfigurationResultSearchMsg> rq) throws SearchException {
        if ((this.getTestConfigurationResultServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for getTestConfigurationResult().");
            throw new InjectionException(
                    "No service implementation configured for getTestConfigurationResult().");
        }
        ServiceResponse<TestConfigurationResultMsg> rs;
        this.getTestConfigurationResultServiceHandler.init();
        rs = this.getTestConfigurationResultServiceHandler.invoke(rq);
        this.getTestConfigurationResultServiceHandler.finish();
        return rs;
    }
}
