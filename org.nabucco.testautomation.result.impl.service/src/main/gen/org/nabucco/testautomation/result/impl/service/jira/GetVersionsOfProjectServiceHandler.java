/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.impl.service.jira;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.handler.ServiceHandler;
import org.nabucco.framework.base.impl.service.handler.ServiceHandlerSupport;
import org.nabucco.testautomation.result.facade.message.jira.ProjectMsg;
import org.nabucco.testautomation.result.facade.message.jira.VersionListMsg;

/**
 * GetVersionsOfProjectServiceHandler<p/>Jira export service<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2011-01-05
 */
public abstract class GetVersionsOfProjectServiceHandler extends ServiceHandlerSupport implements
        ServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.testautomation.result.impl.service.jira.GetVersionsOfProjectServiceHandler";

    /** Constructs a new GetVersionsOfProjectServiceHandler instance. */
    public GetVersionsOfProjectServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<ProjectMsg>.
     * @return the ServiceResponse<VersionListMsg>.
     * @throws SearchException
     */
    protected ServiceResponse<VersionListMsg> invoke(ServiceRequest<ProjectMsg> rq)
            throws SearchException {
        ServiceResponse<VersionListMsg> rs;
        VersionListMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.getVersionsOfProject(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<VersionListMsg>(rq.getContext());
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
     * Missing description at method getVersionsOfProject.
     *
     * @param msg the ProjectMsg.
     * @return the VersionListMsg.
     * @throws SearchException
     */
    protected abstract VersionListMsg getVersionsOfProject(ProjectMsg msg) throws SearchException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
