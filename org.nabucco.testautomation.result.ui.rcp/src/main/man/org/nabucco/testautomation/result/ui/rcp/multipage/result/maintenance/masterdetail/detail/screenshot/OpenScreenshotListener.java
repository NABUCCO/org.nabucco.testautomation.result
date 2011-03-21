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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail.detail.screenshot;

import java.io.ByteArrayInputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.testautomation.result.facade.datatype.trace.ScreenshotTrace;
import org.nabucco.testautomation.result.ui.rcp.images.ResultImageRegistry;


/**
 * ImageViewer
 * 
 * @author Marco Sussek, PRODYNA AG
 */
public class OpenScreenshotListener implements SelectionListener {
	
	private Image image;
	
	private boolean modal;

	/**
	 * Creates a new {@link OpenScreenshotListener} instance.
	 * 
	 * @param screenshotTrace
	 *            the screenshotTrace to be opened in the viewer.
	 */
	public OpenScreenshotListener(ScreenshotTrace screenshotTrace, boolean modal) {
		this.modal = modal;
		
		if (screenshotTrace != null && screenshotTrace.getScreenshot() != null) {
			byte[] value = screenshotTrace.getScreenshot().getValue();
			
			if (value != null) {
				image = new Image(Activator.getDefault().getWorkbench().getDisplay(),
						new ByteArrayInputStream(value));
			}
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// do nothing
	}

	/**
	 * Opens the screenshot in an {@link ImageViewer}.
	 */
	@Override
	public void widgetSelected(SelectionEvent arg0) {
		ImageViewer imageViewer = null;
		
		if (this.modal) {
			imageViewer = new ImageViewer(SWT.DIALOG_TRIM
				| SWT.APPLICATION_MODAL | SWT.MAX | SWT.RESIZE
				| ImageViewer.SAVE_DIALOG | ImageViewer.PRINT_DIALOG
				| ImageViewer.ZOOM);
		} else {
			imageViewer = new ImageViewer(SWT.DIALOG_TRIM
					| SWT.MODELESS | SWT.MAX | SWT.RESIZE
					| ImageViewer.SAVE_DIALOG | ImageViewer.PRINT_DIALOG
					| ImageViewer.ZOOM);
		}
		imageViewer.setTitle("Screenshot");
		imageViewer.setDisplayedImage(image);
		imageViewer.setIcon(ImageProvider
				.createImage(ResultImageRegistry.ICON_SCREENSHOT.getId()));
		imageViewer.open();
	}
}
