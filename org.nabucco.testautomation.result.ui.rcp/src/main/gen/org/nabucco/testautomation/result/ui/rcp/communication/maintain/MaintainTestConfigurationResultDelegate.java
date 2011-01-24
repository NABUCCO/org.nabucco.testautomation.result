/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.communication.maintain;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
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
     * @param rq the TestConfigurationResultMsg.
     * @return the TestConfigurationResultMsg.
     * @throws ClientException
     */
    public TestConfigurationResultMsg maintainTestConfigurationResult(TestConfigurationResultMsg rq)
            throws ClientException {
        ServiceRequest<TestConfigurationResultMsg> request = new ServiceRequest<TestConfigurationResultMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TestConfigurationResultMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.maintainTestConfigurationResult(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(MaintainTestConfigurationResultDelegate.class,
                                "Service: ",
                                "MaintainTestConfigurationResult.maintainTestConfigurationResult",
                                " Time: ", String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: MaintainTestConfigurationResult.maintainTestConfigurationResult");
    }
}
