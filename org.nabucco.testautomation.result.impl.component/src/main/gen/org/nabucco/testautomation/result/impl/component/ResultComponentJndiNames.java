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
package org.nabucco.testautomation.result.impl.component;

/**
 * ResultComponentJndiNames<p/>Component for testautomation result<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-01-28
 */
public interface ResultComponentJndiNames {

    final String COMPONENT_RELATION_SERVICE_LOCAL = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.component.ComponentRelationService/local";

    final String COMPONENT_RELATION_SERVICE_REMOTE = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.component.ComponentRelationService/remote";

    final String QUERY_FILTER_SERVICE_LOCAL = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.component.QueryFilterService/local";

    final String QUERY_FILTER_SERVICE_REMOTE = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.component.QueryFilterService/remote";

    final String MAINTAIN_RESULT_LOCAL = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.service.maintain.MaintainResult/local";

    final String MAINTAIN_RESULT_REMOTE = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.service.maintain.MaintainResult/remote";

    final String SEARCH_RESULT_LOCAL = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.service.search.SearchResult/local";

    final String SEARCH_RESULT_REMOTE = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.service.search.SearchResult/remote";

    final String RESOLVE_RESULT_LOCAL = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.service.resolve.ResolveResult/local";

    final String RESOLVE_RESULT_REMOTE = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.service.resolve.ResolveResult/remote";

    final String REPORT_RESULT_LOCAL = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.service.report.ReportResult/local";

    final String REPORT_RESULT_REMOTE = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.service.report.ReportResult/remote";

    final String PRODUCE_RESULT_LOCAL = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.service.produce.ProduceResult/local";

    final String PRODUCE_RESULT_REMOTE = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.service.produce.ProduceResult/remote";

    final String JIRA_SERVICE_LOCAL = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.service.jira.JiraService/local";

    final String JIRA_SERVICE_REMOTE = "nabucco/org.nabucco.testautomation.result/org.nabucco.testautomation.result.facade.service.jira.JiraService/remote";
}
