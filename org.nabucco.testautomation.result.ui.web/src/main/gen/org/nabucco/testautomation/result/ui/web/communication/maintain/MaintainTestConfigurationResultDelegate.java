/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.web.communication.maintain;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.facade.service.maintain.MaintainTestConfigurationResult;

/**
 * MaintainTestConfigurationResultDelegate<p/>TestConfigurationResult maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public class MaintainTestConfigurationResultDelegate extends ServiceDelegateSupport {

    private MaintainTestConfigurationResult service;

    /**
     * Constructs a new MaintainTestConfigurationResultDelegate instance.
     *
     * @param service the MaintainTestConfigurationResult.
     */
    public MaintainTestConfigurationResultDelegate(MaintainTestConfigurationResult service) {
        super();
        this.service = service;
    }

    /**
     * MaintainTestConfigurationResult.
     *
     * @param session the NabuccoSession.
     * @param rq the TestConfigurationResultMsg.
     * @return the TestConfigurationResultMsg.
     * @throws MaintainException
     */
    public TestConfigurationResultMsg maintainTestConfigurationResult(
            TestConfigurationResultMsg rq, NabuccoSession session) throws MaintainException {
        ServiceRequest<TestConfigurationResultMsg> request = new ServiceRequest<TestConfigurationResultMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<TestConfigurationResultMsg> rs;
        if ((service != null)) {
            rs = service.maintainTestConfigurationResult(request);
        } else {
            throw new MaintainException(
                    "Cannot execute service operation: MaintainTestConfigurationResult.maintainTestConfigurationResult");
        }
        return rs.getResponseMessage();
    }
}
