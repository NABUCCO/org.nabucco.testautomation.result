/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.impl.service.jira;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.handler.ServiceHandler;
import org.nabucco.framework.base.impl.service.handler.ServiceHandlerSupport;
import org.nabucco.testautomation.result.facade.message.jira.IssueMsg;

/**
 * CreateIssuesServiceHandler<p/>Jira export service<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2011-01-05
 */
public abstract class CreateIssuesServiceHandler extends ServiceHandlerSupport implements
        ServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.testautomation.result.impl.service.jira.CreateIssuesServiceHandler";

    /** Constructs a new CreateIssuesServiceHandler instance. */
    public CreateIssuesServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<IssueMsg>.
     * @return the ServiceResponse<IssueMsg>.
     * @throws MaintainException
     */
    protected ServiceResponse<IssueMsg> invoke(ServiceRequest<IssueMsg> rq)
            throws MaintainException {
        ServiceResponse<IssueMsg> rs;
        IssueMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.createIssues(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<IssueMsg>(rq.getContext());
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
     * Missing description at method createIssues.
     *
     * @param msg the IssueMsg.
     * @return the IssueMsg.
     * @throws MaintainException
     */
    protected abstract IssueMsg createIssues(IssueMsg msg) throws MaintainException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
