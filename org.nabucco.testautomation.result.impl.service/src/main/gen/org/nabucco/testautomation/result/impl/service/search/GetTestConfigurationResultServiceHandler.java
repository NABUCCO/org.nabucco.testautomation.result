/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.impl.service.search;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.handler.ServiceHandler;
import org.nabucco.framework.base.impl.service.handler.ServiceHandlerSupport;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultSearchMsg;

/**
 * GetTestConfigurationResultServiceHandler<p/>TestConfiguration search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-15
 */
public abstract class GetTestConfigurationResultServiceHandler extends ServiceHandlerSupport
        implements ServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.testautomation.result.impl.service.search.GetTestConfigurationResultServiceHandler";

    /** Constructs a new GetTestConfigurationResultServiceHandler instance. */
    public GetTestConfigurationResultServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<TestConfigurationResultSearchMsg>.
     * @return the ServiceResponse<TestConfigurationResultMsg>.
     * @throws SearchException
     */
    protected ServiceResponse<TestConfigurationResultMsg> invoke(
            ServiceRequest<TestConfigurationResultSearchMsg> rq) throws SearchException {
        ServiceResponse<TestConfigurationResultMsg> rs;
        TestConfigurationResultMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.getTestConfigurationResult(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<TestConfigurationResultMsg>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (SearchException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            SearchException wrappedException = new SearchException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new SearchException("Error during service invocation.", e);
        }
    }

    /**
     * Missing description at method getTestConfigurationResult.
     *
     * @param msg the TestConfigurationResultSearchMsg.
     * @return the TestConfigurationResultMsg.
     * @throws SearchException
     */
    protected abstract TestConfigurationResultMsg getTestConfigurationResult(
            TestConfigurationResultSearchMsg msg) throws SearchException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
