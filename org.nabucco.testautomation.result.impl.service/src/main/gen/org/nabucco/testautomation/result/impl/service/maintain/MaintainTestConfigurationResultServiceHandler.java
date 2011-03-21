/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.impl.service.maintain;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.handler.ServiceHandler;
import org.nabucco.framework.base.impl.service.handler.ServiceHandlerSupport;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;

/**
 * MaintainTestConfigurationResultServiceHandler<p/>TestConfigurationResult maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public abstract class MaintainTestConfigurationResultServiceHandler extends ServiceHandlerSupport
        implements ServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.testautomation.result.impl.service.maintain.MaintainTestConfigurationResultServiceHandler";

    /** Constructs a new MaintainTestConfigurationResultServiceHandler instance. */
    public MaintainTestConfigurationResultServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<TestConfigurationResultMsg>.
     * @return the ServiceResponse<TestConfigurationResultMsg>.
     * @throws MaintainException
     */
    protected ServiceResponse<TestConfigurationResultMsg> invoke(
            ServiceRequest<TestConfigurationResultMsg> rq) throws MaintainException {
        ServiceResponse<TestConfigurationResultMsg> rs;
        TestConfigurationResultMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.maintainTestConfigurationResult(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<TestConfigurationResultMsg>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (MaintainException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            MaintainException wrappedException = new MaintainException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new MaintainException("Error during service invocation.", e);
        }
    }

    /**
     * Missing description at method maintainTestConfigurationResult.
     *
     * @param msg the TestConfigurationResultMsg.
     * @return the TestConfigurationResultMsg.
     * @throws MaintainException
     */
    protected abstract TestConfigurationResultMsg maintainTestConfigurationResult(
            TestConfigurationResultMsg msg) throws MaintainException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
