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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.xml;

import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;

import org.nabucco.testautomation.facade.datatype.property.BooleanProperty;
import org.nabucco.testautomation.facade.datatype.property.DateProperty;
import org.nabucco.testautomation.facade.datatype.property.DoubleProperty;
import org.nabucco.testautomation.facade.datatype.property.IntegerProperty;
import org.nabucco.testautomation.facade.datatype.property.LongProperty;
import org.nabucco.testautomation.facade.datatype.property.StringProperty;
import org.nabucco.testautomation.facade.datatype.property.XPathProperty;
import org.nabucco.testautomation.facade.datatype.property.XmlProperty;
import org.nabucco.testautomation.facade.datatype.property.base.Property;

/**
 * XmlFactory
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class XmlFactory {

	public static String createStartTag(TestConfigurationResult testConfigurationResult) {
		String startTag = "TestConfigurationResult name=\"" + testConfigurationResult.getName().getValue() + "\"";
		return startTag;
	}
	
	public static String createEndTag(TestConfigurationResult testConfigurationResult) {
		String endTag = "TestConfigurationResult";
		return endTag;
	}
	
	public static String createContent(TestConfigurationResult testConfigurationResult) {
		return null;
	}
	
	public static String createStartTag(Property property) {
		String startTag = "Property name=\"" + property.getName().getValue() + "\" type=\"" + property.getType() + "\"";
		return startTag;
	}
	
	public static String createEndTag(Property property) {
		String endTag = "Property";
		return endTag;
	}
	
	public static String createContent(Property property) {
		
		switch (property.getType()) {
		case BOOLEAN:
			return ((BooleanProperty) property).getValue().getValue().toString();
		case DATE:
			return ((DateProperty) property).getValue().getValue().toString();
		case DOUBLE:
			return ((DoubleProperty) property).getValue().getValue().toString();
		case INTEGER:
			return ((IntegerProperty) property).getValue().getValue().toString();
		case LONG:
			return ((LongProperty) property).getValue().getValue().toString();
		case STRING:
			return ((StringProperty) property).getValue().getValue().toString();
		case XPATH:
			return ((XPathProperty) property).getValue().getValue().toString();
		case XML:
			return "<![CDATA[" + ((XmlProperty) property).getValue() +"]]>";
		}
		return null;
	}
	
}
