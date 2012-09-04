/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.testautomation.result.impl.service.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
import org.nabucco.testautomation.property.facade.message.QuickSearchMsg;
import org.nabucco.testautomation.property.facade.message.QuickSearchRs;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultListMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultSearchMsg;
import org.nabucco.testautomation.result.facade.service.search.SearchResult;

/**
 * SearchResultImpl<p/>Result search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-15
 */
public class SearchResultImpl extends ServiceSupport implements SearchResult {

    private static final long serialVersionUID = 1L;

    private static final String ID = "SearchResult";

    private static Map<String, String[]> ASPECTS;

    private SearchTestConfigurationResultServiceHandler searchTestConfigurationResultServiceHandler;

    private QuickSearchServiceHandler quickSearchServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new SearchResultImpl instance. */
    public SearchResultImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.searchTestConfigurationResultServiceHandler = injector.inject(SearchTestConfigurationResultServiceHandler
                .getId());
        if ((this.searchTestConfigurationResultServiceHandler != null)) {
            this.searchTestConfigurationResultServiceHandler.setPersistenceManager(persistenceManager);
            this.searchTestConfigurationResultServiceHandler.setLogger(super.getLogger());
        }
        this.quickSearchServiceHandler = injector.inject(QuickSearchServiceHandler.getId());
        if ((this.quickSearchServiceHandler != null)) {
            this.quickSearchServiceHandler.setPersistenceManager(persistenceManager);
            this.quickSearchServiceHandler.setLogger(super.getLogger());
        }
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }

    @Override
    public String[] getAspects(String operationName) {
        if ((ASPECTS == null)) {
            ASPECTS = new HashMap<String, String[]>();
            ASPECTS.put("searchTestConfigurationResult", NO_ASPECTS);
            ASPECTS.put("quickSearch", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<TestConfigurationResultListMsg> searchTestConfigurationResult(
            ServiceRequest<TestConfigurationResultSearchMsg> rq) throws SearchException {
        if ((this.searchTestConfigurationResultServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchTestConfigurationResult().");
            throw new InjectionException("No service implementation configured for searchTestConfigurationResult().");
        }
        ServiceResponse<TestConfigurationResultListMsg> rs;
        this.searchTestConfigurationResultServiceHandler.init();
        rs = this.searchTestConfigurationResultServiceHandler.invoke(rq);
        this.searchTestConfigurationResultServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<QuickSearchRs> quickSearch(ServiceRequest<QuickSearchMsg> rq) throws SearchException {
        if ((this.quickSearchServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for quickSearch().");
            throw new InjectionException("No service implementation configured for quickSearch().");
        }
        ServiceResponse<QuickSearchRs> rs;
        this.quickSearchServiceHandler.init();
        rs = this.quickSearchServiceHandler.invoke(rq);
        this.quickSearchServiceHandler.finish();
        return rs;
    }
}
