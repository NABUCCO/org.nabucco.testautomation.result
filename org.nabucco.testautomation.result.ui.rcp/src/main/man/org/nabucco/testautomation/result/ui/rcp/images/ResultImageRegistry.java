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
package org.nabucco.testautomation.result.ui.rcp.images;

/**
 * Global Registry of all component images.
 * <p>
 * Used to register / create component images with
 * {@link org.nabucco.framework.plugin.base.layout.ImageProvider}.
 * 
 * @author Marco Sussek, PRODYNA AG
 */
public enum ResultImageRegistry {

	ICON_ABORT("icons/result/abort.png", "/icons/abort.png"),

	ICON_FAIL("icons/result/fail.png", "/icons/fail.png"),

	ICON_RUN("icons/result/run.png", "/icons/run.png"),

	ICON_SKIP("icons/result/skip.png", "/icons/skip.png"),

	ICON_SCREENSHOT("icons/result/screenshot.png", "/icons/screenshot.png"),

	ICON_SUCCESS("icons/result/success.png", "/icons/success.png"),
	
	ICON_REPORT("icons/result/report.png", "/icons/report.png"),

	ICON_CREATE_REPORT("icons/result/createreport.png", "/icons/createreport.png"),

	ICON_FILE("icons/result/file.png", "/icons/file.png"),

	ICON_JIRA("icons/result/jira.png", "/icons/jira.png"),
	
	ICON_JIRA_80X80("icons/result/jira80x80.png", "/icons/jira80x80.png");
	
	
	/**
	 * The unique symbolic name of the image used to identify the image in the
	 * <code>ImageProvider</code>.
	 */
	private String id;

	/**
	 * The physical path of the image within the component JAR.
	 */
	private String resourcePath;

	private ResultImageRegistry(String id, String resourcePath) {
		this.id = id;
		this.resourcePath = resourcePath;
	}

	/**
	 * Gets the unique symbolic name of the image used to identify the image in
	 * the <code>ImageProvider</code>.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the physical path of the image within the component JAR.
	 * 
	 * @return the resourcePath
	 */
	public String getResourcePath() {
		return resourcePath;
	}
}
