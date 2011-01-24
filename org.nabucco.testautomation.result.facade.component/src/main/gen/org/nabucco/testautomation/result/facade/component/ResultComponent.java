/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.component;

import org.nabucco.framework.base.facade.component.Component;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.testautomation.result.facade.service.jira.JiraService;
import org.nabucco.testautomation.result.facade.service.maintain.MaintainTestConfigurationResult;
import org.nabucco.testautomation.result.facade.service.produce.ProduceTestResult;
import org.nabucco.testautomation.result.facade.service.produce.ProduceTrace;
import org.nabucco.testautomation.result.facade.service.search.SearchTestConfigurationResult;

/**
 * ResultComponent<p/>Component for testautomation result<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-01-28
 */
public interface ResultComponent extends Component {

    final String COMPONENT_NAME = "org.nabucco.testautomation.result";

    /**
     * Getter for the MaintainTestConfigurationResult.
     *
     * @return the MaintainTestConfigurationResult.
     * @throws ServiceException
     */
    MaintainTestConfigurationResult getMaintainTestConfigurationResult() throws ServiceException;

    /**
     * Getter for the SearchTestConfigurationResult.
     *
     * @return the SearchTestConfigurationResult.
     * @throws ServiceException
     */
    SearchTestConfigurationResult getSearchTestConfigurationResult() throws ServiceException;

    /**
     * Getter for the ProduceTestResult.
     *
     * @return the ProduceTestResult.
     * @throws ServiceException
     */
    ProduceTestResult getProduceTestResult() throws ServiceException;

    /**
     * Getter for the ProduceTrace.
     *
     * @return the ProduceTrace.
     * @throws ServiceException
     */
    ProduceTrace getProduceTrace() throws ServiceException;

    /**
     * Getter for the JiraService.
     *
     * @return the JiraService.
     * @throws ServiceException
     */
    JiraService getJiraService() throws ServiceException;
}
