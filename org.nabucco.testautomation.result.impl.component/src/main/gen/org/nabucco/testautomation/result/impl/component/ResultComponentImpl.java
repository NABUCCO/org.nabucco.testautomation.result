/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.impl.component;

import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.impl.component.ComponentSupport;
import org.nabucco.testautomation.result.facade.component.ResultComponent;
import org.nabucco.testautomation.result.facade.service.jira.JiraService;
import org.nabucco.testautomation.result.facade.service.maintain.MaintainTestConfigurationResult;
import org.nabucco.testautomation.result.facade.service.produce.ProduceTestResult;
import org.nabucco.testautomation.result.facade.service.produce.ProduceTrace;
import org.nabucco.testautomation.result.facade.service.search.SearchTestConfigurationResult;

/**
 * ResultComponentImpl<p/>Component for testautomation result<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-01-28
 */
public class ResultComponentImpl extends ComponentSupport implements ResultComponent {

    private static final long serialVersionUID = 1L;

    private ComponentRelationService componentRelationService;

    private MaintainTestConfigurationResult maintainTestConfigurationResult;

    private SearchTestConfigurationResult searchTestConfigurationResult;

    private ProduceTestResult produceTestResult;

    private ProduceTrace produceTrace;

    private JiraService jiraService;

    /** Constructs a new ResultComponentImpl instance. */
    public ResultComponentImpl() {
        super();
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return this.componentRelationService;
    }

    /**
     * Getter for the MaintainTestConfigurationResult.
     *
     * @return the MaintainTestConfigurationResult.
     */
    public MaintainTestConfigurationResult getMaintainTestConfigurationResult() {
        return this.maintainTestConfigurationResult;
    }

    /**
     * Getter for the SearchTestConfigurationResult.
     *
     * @return the SearchTestConfigurationResult.
     */
    public SearchTestConfigurationResult getSearchTestConfigurationResult() {
        return this.searchTestConfigurationResult;
    }

    /**
     * Getter for the ProduceTestResult.
     *
     * @return the ProduceTestResult.
     */
    public ProduceTestResult getProduceTestResult() {
        return this.produceTestResult;
    }

    /**
     * Getter for the ProduceTrace.
     *
     * @return the ProduceTrace.
     */
    public ProduceTrace getProduceTrace() {
        return this.produceTrace;
    }

    /**
     * Getter for the JiraService.
     *
     * @return the JiraService.
     */
    public JiraService getJiraService() {
        return this.jiraService;
    }
}
