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
package org.nabucco.testautomation.result.impl.service.maintain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.facade.service.maintain.MaintainResult;

/**
 * MaintainResultImpl<p/>Result maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public class MaintainResultImpl extends ServiceSupport implements MaintainResult {

    private static final long serialVersionUID = 1L;

    private static final String ID = "MaintainResult";

    private static Map<String, String[]> ASPECTS;

    private MaintainTestConfigurationResultServiceHandler maintainTestConfigurationResultServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new MaintainResultImpl instance. */
    public MaintainResultImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.maintainTestConfigurationResultServiceHandler = injector
                .inject(MaintainTestConfigurationResultServiceHandler.getId());
        if ((this.maintainTestConfigurationResultServiceHandler != null)) {
            this.maintainTestConfigurationResultServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainTestConfigurationResultServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("maintainTestConfigurationResult", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<TestConfigurationResultMsg> maintainTestConfigurationResult(
            ServiceRequest<TestConfigurationResultMsg> rq) throws MaintainException {
        if ((this.maintainTestConfigurationResultServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainTestConfigurationResult().");
            throw new InjectionException("No service implementation configured for maintainTestConfigurationResult().");
        }
        ServiceResponse<TestConfigurationResultMsg> rs;
        this.maintainTestConfigurationResultServiceHandler.init();
        rs = this.maintainTestConfigurationResultServiceHandler.invoke(rq);
        this.maintainTestConfigurationResultServiceHandler.finish();
        return rs;
    }
}
