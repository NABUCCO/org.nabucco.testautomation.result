/*
* Copyright 2010 PRODYNA AG
*
* Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.opensource.org/licenses/eclipse-1.0.php or
* http://www.nabucco-source.org/nabucco-license.html
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.nabucco.testautomation.result;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.test.RuntimeTestSupport;
import org.nabucco.testautomation.result.facade.component.ResultComponent;
import org.nabucco.testautomation.result.facade.component.ResultComponentLocator;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;
import org.nabucco.testautomation.result.facade.datatype.status.TestConfigurationStatusType;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.facade.message.TraceMsg;
import org.nabucco.testautomation.result.facade.service.maintain.MaintainTestConfigurationResult;
import org.nabucco.testautomation.result.facade.service.produce.ProduceTrace;



public class TestResultServiceTest extends RuntimeTestSupport {

	private MaintainTestConfigurationResult maintain;
	
	private ProduceTrace produceTrace;

	@Before
	public void setUp() throws Exception {
		ResultComponent component = super.getComponent(ResultComponentLocator
				.getInstance());
		maintain = component.getMaintainTestConfigurationResult();
		produceTrace = component.getProduceTrace();
	}
	
	@Test
	public void testMaintainTestConfigurationResult() throws Exception {
		
		ServiceRequest<TestConfigurationResultMsg> rq = new ServiceRequest<TestConfigurationResultMsg>(getServiceContext());
		TestConfigurationResultMsg msg = new TestConfigurationResultMsg();
		
		TestConfigurationResult result = createTestConfigurationResult();
		msg.setTestConfigurationResult(result);
		
		rq.setRequestMessage(msg);
		ServiceResponse<TestConfigurationResultMsg> rs = maintain.maintainTestConfigurationResult(rq);
		System.out.println(rs.getResponseMessage().getTestConfigurationResult());
	}

	@Test
	public void testProduceActionTrace() throws Exception {
		
		ServiceRequest<EmptyServiceMessage> rq = new ServiceRequest<EmptyServiceMessage>(getServiceContext());
		rq.setRequestMessage(new EmptyServiceMessage());
		
		ServiceResponse<TraceMsg> rs = produceTrace.produceActionTrace(rq);
		System.out.println(rs.getResponseMessage().getTrace());
		
		rs = produceTrace.produceMessageTrace(rq);
		System.out.println(rs.getResponseMessage().getTrace());
		
		rs = produceTrace.produceScreenshotTrace(rq);
		System.out.println(rs.getResponseMessage().getTrace());
		
		rs = produceTrace.produceFileTrace(rq);
		System.out.println(rs.getResponseMessage().getTrace());
	}
	
	private TestConfigurationResult createTestConfigurationResult() {
		
		TestConfigurationResult result = new TestConfigurationResult();
		result.setDatatypeState(DatatypeState.INITIALIZED);
		result.setName("MyTestConfigurationResult");
		result.setStartTime(new Date(System.currentTimeMillis() - 10000));
		result.setEndTime(new Date(System.currentTimeMillis()));
		result.setStatus(TestConfigurationStatusType.FINISHED);
		result.setTestConfigurationId(1L);
		result.setTestConfigurationName("MyTestConfiguration");
		
		add(createTestResult("TestResult 1"),result);
		add(createTestResult("TestResult 2"),result);
		
		add(createTestResult("TestResult 1.1"), result.getTestResultList().get(0).getResult());
		add(createTestResult("TestResult 1.2"),result.getTestResultList().get(0).getResult());
		add(createTestResult("TestResult 2.1"),result.getTestResultList().get(1).getResult());
		add(createTestResult("TestResult 2.2"),result.getTestResultList().get(1).getResult());
		
		return result;		
	}
	
	private TestResult createTestResult(String name) {
		
		TestResult result = new TestResult();
		result.setDatatypeState(DatatypeState.INITIALIZED);
		result.setName(name);
		result.setMessage("Everything is okay");
		return result;
	}
	
	private void add(TestResult result, TestResult to) {
		TestResultContainer container = new TestResultContainer();
		container.setDatatypeState(DatatypeState.INITIALIZED);
		container.setResult(result);
		container.setOrderIndex(to.getTestResultList().size());
		to.getTestResultList().add(container);
	}
	
	private void add(TestResult result, TestConfigurationResult to) {
		TestResultContainer container = new TestResultContainer();
		container.setDatatypeState(DatatypeState.INITIALIZED);
		container.setResult(result);
		container.setOrderIndex(to.getTestResultList().size());
		to.getTestResultList().add(container);
	}
	
}
