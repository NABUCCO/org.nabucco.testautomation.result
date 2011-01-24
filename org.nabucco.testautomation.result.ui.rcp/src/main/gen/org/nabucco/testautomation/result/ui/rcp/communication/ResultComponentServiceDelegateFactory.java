/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.communication;

import org.nabucco.framework.base.facade.component.connection.Connection;
import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.component.connection.ConnectionFactory;
import org.nabucco.framework.base.facade.component.connection.ConnectionSpecification;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.testautomation.result.facade.component.ResultComponent;
import org.nabucco.testautomation.result.facade.component.ResultComponentLocator;
import org.nabucco.testautomation.result.ui.rcp.communication.jira.JiraServiceDelegate;
import org.nabucco.testautomation.result.ui.rcp.communication.maintain.MaintainTestConfigurationResultDelegate;
import org.nabucco.testautomation.result.ui.rcp.communication.produce.ProduceTestResultDelegate;
import org.nabucco.testautomation.result.ui.rcp.communication.produce.ProduceTraceDelegate;
import org.nabucco.testautomation.result.ui.rcp.communication.search.SearchTestConfigurationResultDelegate;

/**
 * ServiceDelegateFactoryTemplate<p/>Component for testautomation result<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-01-28
 */
public class ResultComponentServiceDelegateFactory {

    private static ResultComponentServiceDelegateFactory instance = new ResultComponentServiceDelegateFactory();

    private ResultComponent component;

    private MaintainTestConfigurationResultDelegate maintainTestConfigurationResultDelegate;

    private SearchTestConfigurationResultDelegate searchTestConfigurationResultDelegate;

    private ProduceTestResultDelegate produceTestResultDelegate;

    private ProduceTraceDelegate produceTraceDelegate;

    private JiraServiceDelegate jiraServiceDelegate;

    /** Constructs a new ResultComponentServiceDelegateFactory instance. */
    private ResultComponentServiceDelegateFactory() {
        super();
    }

    /**
     * Getter for the Component.
     *
     * @return the ResultComponent.
     * @throws ConnectionException
     */
    private ResultComponent getComponent() throws ConnectionException {
        if ((this.component == null)) {
            this.initComponent();
        }
        return this.component;
    }

    /**
     * InitComponent.
     *
     * @throws ConnectionException
     */
    private void initComponent() throws ConnectionException {
        ConnectionSpecification specification = ConnectionSpecification.getCurrentSpecification();
        Connection connection = ConnectionFactory.getInstance().createConnection(specification);
        this.component = ResultComponentLocator.getInstance().getComponent(connection);
    }

    /**
     * Getter for the MaintainTestConfigurationResult.
     *
     * @return the MaintainTestConfigurationResultDelegate.
     * @throws ClientException
     */
    public MaintainTestConfigurationResultDelegate getMaintainTestConfigurationResult()
            throws ClientException {
        try {
            if ((this.maintainTestConfigurationResultDelegate == null)) {
                this.maintainTestConfigurationResultDelegate = new MaintainTestConfigurationResultDelegate(
                        this.getComponent().getMaintainTestConfigurationResult());
            }
            return this.maintainTestConfigurationResultDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ResultComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: MaintainTestConfigurationResult", e);
        }
    }

    /**
     * Getter for the SearchTestConfigurationResult.
     *
     * @return the SearchTestConfigurationResultDelegate.
     * @throws ClientException
     */
    public SearchTestConfigurationResultDelegate getSearchTestConfigurationResult()
            throws ClientException {
        try {
            if ((this.searchTestConfigurationResultDelegate == null)) {
                this.searchTestConfigurationResultDelegate = new SearchTestConfigurationResultDelegate(
                        this.getComponent().getSearchTestConfigurationResult());
            }
            return this.searchTestConfigurationResultDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ResultComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: SearchTestConfigurationResult", e);
        }
    }

    /**
     * Getter for the ProduceTestResult.
     *
     * @return the ProduceTestResultDelegate.
     * @throws ClientException
     */
    public ProduceTestResultDelegate getProduceTestResult() throws ClientException {
        try {
            if ((this.produceTestResultDelegate == null)) {
                this.produceTestResultDelegate = new ProduceTestResultDelegate(this.getComponent()
                        .getProduceTestResult());
            }
            return this.produceTestResultDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ResultComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ProduceTestResult", e);
        }
    }

    /**
     * Getter for the ProduceTrace.
     *
     * @return the ProduceTraceDelegate.
     * @throws ClientException
     */
    public ProduceTraceDelegate getProduceTrace() throws ClientException {
        try {
            if ((this.produceTraceDelegate == null)) {
                this.produceTraceDelegate = new ProduceTraceDelegate(this.getComponent()
                        .getProduceTrace());
            }
            return this.produceTraceDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ResultComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ProduceTrace", e);
        }
    }

    /**
     * Getter for the JiraService.
     *
     * @return the JiraServiceDelegate.
     * @throws ClientException
     */
    public JiraServiceDelegate getJiraService() throws ClientException {
        try {
            if ((this.jiraServiceDelegate == null)) {
                this.jiraServiceDelegate = new JiraServiceDelegate(this.getComponent()
                        .getJiraService());
            }
            return this.jiraServiceDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ResultComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: JiraService", e);
        }
    }

    /**
     * Getter for the Instance.
     *
     * @return the ResultComponentServiceDelegateFactory.
     */
    public static ResultComponentServiceDelegateFactory getInstance() {
        return instance;
    }
}
