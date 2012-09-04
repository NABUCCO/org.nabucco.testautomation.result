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
package org.nabucco.testautomation.result.impl.service.resolve;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultSearchMsg;
import org.nabucco.testautomation.result.facade.service.resolve.ResolveResult;

/**
 * ResolveResultImpl<p/>Result resolve service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-15
 */
public class ResolveResultImpl extends ServiceSupport implements ResolveResult {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ResolveResult";

    private static Map<String, String[]> ASPECTS;

    private ResolveTestConfigurationResultServiceHandler resolveTestConfigurationResultServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ResolveResultImpl instance. */
    public ResolveResultImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.resolveTestConfigurationResultServiceHandler = injector
                .inject(ResolveTestConfigurationResultServiceHandler.getId());
        if ((this.resolveTestConfigurationResultServiceHandler != null)) {
            this.resolveTestConfigurationResultServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveTestConfigurationResultServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("resolveTestConfigurationResult", new String[] { "org.nabucco.aspect.resolving" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<TestConfigurationResultMsg> resolveTestConfigurationResult(
            ServiceRequest<TestConfigurationResultSearchMsg> rq) throws ResolveException {
        if ((this.resolveTestConfigurationResultServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveTestConfigurationResult().");
            throw new InjectionException("No service implementation configured for resolveTestConfigurationResult().");
        }
        ServiceResponse<TestConfigurationResultMsg> rs;
        this.resolveTestConfigurationResultServiceHandler.init();
        rs = this.resolveTestConfigurationResultServiceHandler.invoke(rq);
        this.resolveTestConfigurationResultServiceHandler.finish();
        return rs;
    }
}
