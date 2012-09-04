/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.testautomation.result.facade.datatype;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.FileTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.MessageTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.ScreenshotTrace;


/**
 * ActionTraceFactory
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public final class ActionTraceFactory {

	private static ActionTraceFactory instance;
	
	private ActionTraceFactory() {}
	
	public static synchronized ActionTraceFactory getInstance() {
		
		if (instance == null) {
			instance = new ActionTraceFactory();
		}
		return instance;
	}
	
	public ActionTrace createActionTrace() {
		ActionTrace trace = new ActionTrace();
		trace.setDatatypeState(DatatypeState.INITIALIZED);
		return trace;
	}
	
	public MessageTrace createMessageTrace() {
		MessageTrace trace = new MessageTrace();
		trace.setDatatypeState(DatatypeState.INITIALIZED);
		return trace;
	}
	
	public ScreenshotTrace createScreenshotTrace() {
		ScreenshotTrace trace = new ScreenshotTrace();
		trace.setDatatypeState(DatatypeState.INITIALIZED);
		return trace;
	}
	
	public FileTrace createFileTrace() {
		FileTrace trace = new FileTrace();
		trace.setDatatypeState(DatatypeState.INITIALIZED);
		return trace;
	}
	
}
