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

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.nabucco.framework.plugin.base.Activator;

/**
 * ImageViewer
 * 
 * @author Marco Sussek, PRODYNA AG
 */
public class ImageViewer {
	protected Display display;

	protected Shell shell;

	protected int zoomFactor = 100;

	protected Image originImage;

	protected Image scaledImage;

	protected Canvas canvas;

	protected String fileName;

	protected ScrolledComposite scrolledComposite;

	protected int style;

	protected static final String JPG = ".jpg";

	protected static final String PNG = ".png";

	protected static final String BMP = ".bmp";

	/**
	 * Style constant indicating, that the <code>ImageViewer</code> should
	 * provide a dialog to open image-files located in the file system.
	 */
	public static final int OPEN_DIALOG = 2 << 26;

	/**
	 * Style constant indicating, that the <code>ImageViewer</code> should
	 * provide a dialog to save the currently opened image as an image-file in
	 * the file system.
	 */
	public static final int SAVE_DIALOG = 2 << 27;

	/**
	 * Style constant indicating, that the <code>ImageViewer</code> should
	 * provide a dialog to print the currently opened image on a printer.
	 */
	public static final int PRINT_DIALOG = 2 << 28;

	/**
	 * Style constant indicating, that the <code>ImageViewer</code> should
	 * provide Zoom In and Zoom Out buttons to scale the view of the currently
	 * opened image.
	 */
	public static final int ZOOM = 2 << 29;

	/**
	 * Creates a new {@link ImageViewer} instance.
	 * 
	 * @param style
	 *            the style of control to construct
	 * 
	 * @see SWT#BORDER
	 * @see SWT#CLOSE
	 * @see SWT#MIN
	 * @see SWT#MAX
	 * @see SWT#RESIZE
	 * @see SWT#TITLE
	 * @see SWT#TOOL
	 * @see SWT#NO_TRIM
	 * @see SWT#SHELL_TRIM
	 * @see SWT#DIALOG_TRIM
	 * @see SWT#ON_TOP
	 * @see SWT#MODELESS
	 * @see SWT#PRIMARY_MODAL
	 * @see SWT#APPLICATION_MODAL
	 * @see SWT#SYSTEM_MODAL
	 * @see SWT#SHEET
	 * @see ImageViewer#OPEN_DIALOG
	 * @see ImageViewer#SAVE_DIALOG
	 * @see ImageViewer#PRINT_DIALOG
	 * @see ImageViewer#ZOOM
	 */
	public ImageViewer(int style) {
		this.style = style;
		display = Activator.getDefault().getWorkbench().getDisplay();
		shell = new Shell(display, style);
		shell.setSize(800, 600);
		shell.setLayout(new GridLayout(1, false));

		initToolbar();
		initCanvas();
	}

	/**
	 * Moves the receiver to the top of the drawing order for the display on
	 * which it was created (so that all other shells on that display, which are
	 * not the receiver's children will be drawn behind it), marks it visible,
	 * sets the focus and asks the window manager to make the shell active.
	 * 
	 * @exception SWTException
	 *                <ul>
	 *                <li>ERROR_WIDGET_DISPOSED - if the receiver has been
	 *                disposed</li>
	 *                <li>ERROR_THREAD_INVALID_ACCESS - if not called from the
	 *                thread that created the receiver</li>
	 *                </ul>
	 * 
	 * @see Control#moveAbove
	 * @see Control#setFocus
	 * @see Control#setVisible
	 * @see Display#getActiveShell
	 * @see Decorations#setDefaultButton(Button)
	 * @see Shell#setActive
	 * @see Shell#forceActive
	 */
	public void open() {
		shell.open();
		if ((style & SWT.APPLICATION_MODAL) != 0) {
			runEventLoop();
			shell.dispose();
		}
	}

	protected void initToolbar() {
		ToolBar toolBar = new ToolBar(shell, SWT.FLAT);

		if ((style & OPEN_DIALOG) != 0) {
			ToolItem itemOpen = new ToolItem(toolBar, SWT.PUSH);
			itemOpen.setText("Open");
			itemOpen.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					FileDialog dialog = new FileDialog(shell, SWT.OPEN);
					String file = dialog.open();
					if (file != null) {
						if (originImage != null)
							originImage.dispose();
						originImage = new Image(display, file);
						scaledImage = null;
						zoomFactor = 100;

						if (originImage != null) {
							fileName = file;
						} else {
							Activator.getDefault().logError(
									"Failed to load image from file: " + file);
						}
						canvas.redraw();
					}
				}
			});
		}

		if ((style & SAVE_DIALOG) != 0) {
			ToolItem itemOpen = new ToolItem(toolBar, SWT.PUSH);
			itemOpen.setText("Save");
			itemOpen.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					FileDialog dialog = new FileDialog(shell, SWT.SAVE);
					dialog.setFilterExtensions(new String[] { JPG, PNG, BMP });
					String file = dialog.open();
					if (file != null) {
						if (originImage != null) {
							ImageLoader imageLoader = new ImageLoader();
							imageLoader.data = new ImageData[] { originImage
									.getImageData() };
							if (file.endsWith(JPG)) {
								imageLoader.save(file, SWT.IMAGE_JPEG);
							} else if (file.endsWith(PNG)) {
								imageLoader.save(file, SWT.IMAGE_PNG);
							} else if (file.endsWith(BMP)) {
								imageLoader.save(file, SWT.IMAGE_BMP);
							}

						}
					}
				}
			});
		}

		if ((style & PRINT_DIALOG) != 0) {
			ToolItem itemPrint = new ToolItem(toolBar, SWT.PUSH);
			itemPrint.setText("Print");
			itemPrint.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					print();
				}
			});
		}

		if ((style & ZOOM) != 0) {
			ToolItem itemZoomOut = new ToolItem(toolBar, SWT.PUSH);
			itemZoomOut.setText("Zoom Out");
			itemZoomOut.addListener(SWT.Selection, new Listener() {

				public void handleEvent(Event event) {
					if (zoomFactor - 10 > 0) {
						zoomFactor -= 10;
						scaleImage();
						canvas.redraw();
					}
				}
			});

			ToolItem itemZoomIn = new ToolItem(toolBar, SWT.PUSH);
			itemZoomIn.setText("Zoom In");
			itemZoomIn.addListener(SWT.Selection, new Listener() {

				public void handleEvent(Event event) {
					zoomFactor += 10;
					scaleImage();
					canvas.redraw();
				}
			});
		}
	}

	protected void initCanvas() {
		scrolledComposite = new ScrolledComposite(shell, SWT.V_SCROLL
				| SWT.H_SCROLL);
		scrolledComposite.setFocus();
		scrolledComposite.getVerticalBar().setIncrement(10);
		scrolledComposite.getHorizontalBar().setIncrement(10);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true));
		canvas = new Canvas(scrolledComposite, SWT.NONE);
		scrolledComposite.setContent(canvas);
		canvas.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		canvas.setBounds(0, 0, shell.getSize().x, shell.getSize().y);

		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				if (originImage != null) {
					if (scaledImage == null) {
						scaleImage();
					}
					e.gc.drawImage(scaledImage, 0, 0);
				}
			}
		});
	}

	/**
	 * Runs the event loop for the given shell.
	 * 
	 * @param loopShell
	 *            the shell
	 */
	protected void runEventLoop() {
		while (shell != null && !shell.isDisposed()) {
			try {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			} catch (Throwable e) {
				Activator.getDefault().logError(e);
			}
		}
		if (!display.isDisposed())
			display.update();
	}

	/**
	 * Sets the window-title of the <code>ImageViewer</code>.
	 * 
	 * @param title
	 *            the window-title
	 */
	public void setTitle(String title) {
		shell.setText(title);
	}

	/**
	 * Sets the image which should be displayed in the <code>ImageViewer</code>.
	 * 
	 * @param image
	 *            the image to be displayed
	 */
	public void setDisplayedImage(Image image) {
		this.originImage = image;
		scaledImage = null;
		zoomFactor = 100;
		canvas.redraw();
	}

	/**
	 * Sets the window-icon of the <code>ImageViewer</code>.
	 * 
	 * @param image
	 *            the window-icon
	 */
	public void setIcon(Image image) {
		shell.setImage(image);
	}

	protected void scaleImage() {
		if (scaledImage != null && !scaledImage.isDisposed()) {
			scaledImage.dispose();
		}
		final int width = originImage.getBounds().width;
		final int height = originImage.getBounds().height;
		final double zoom = ((double) zoomFactor) / 100.0;

		scaledImage = new Image(Display.getDefault(), originImage
				.getImageData().scaledTo((int) (width * zoom),
						(int) (height * zoom)));

		canvas.setBounds(scaledImage.getBounds());
	}

	/**
	 * Lets the user to select a printer and prints the image on it.
	 * 
	 */
	protected void print() {
		PrintDialog dialog = new PrintDialog(shell);
		// Prompts the printer dialog to let the user select a printer.
		PrinterData printerData = dialog.open();

		if (printerData == null) // the user cancels the dialog
			return;
		// Loads the printer.
		Printer printer = new Printer(printerData);
		print(printer, null);
	}

	/**
	 * Prints the image current displayed to the specified printer.
	 * 
	 * @param printer
	 */
	protected void print(final Printer printer, PrintMargin printMargin) {
		if (originImage == null) // If no image is loaded, do not print.
			return;

		final Point printerDPI = printer.getDPI();
		final Point displayDPI = display.getDPI();
		Activator.getDefault().logDebug(displayDPI + " " + printerDPI);

		final PrintMargin margin = (printMargin == null ? PrintMargin
				.getPrintMargin(printer, 1.0) : printMargin);

		Thread printThread = new Thread() {
			public void run() {
				if (!printer.startJob(fileName)) {
					Activator.getDefault().logError(
							"Failed to start print job!");
					printer.dispose();
					return;
				}

				GC gc = new GC(printer);

				if (!printer.startPage()) {
					Activator.getDefault().logError(
							"Failed to start a new page!");
					gc.dispose();
					return;
				} else {
					int imageWidth = originImage.getBounds().width;
					int imageHeight = originImage.getBounds().height;

					// Handles DPI conversion.
					double dpiScaleFactorX = printerDPI.x * 1.0 / displayDPI.x;
					double dpiScaleFactorY = printerDPI.y * 1.0 / displayDPI.y;

					// If the image is too large to draw on a page, reduces its
					// width and height proportionally.
					double imageSizeFactor = Math.min(1,
							(margin.right - margin.left) * 1.0
									/ (dpiScaleFactorX * imageWidth));
					imageSizeFactor = Math.min(imageSizeFactor,
							(margin.bottom - margin.top) * 1.0
									/ (dpiScaleFactorY * imageHeight));

					// Draws the image to the printer.
					gc.drawImage(
							originImage,
							0,
							0,
							imageWidth,
							imageHeight,
							margin.left,
							margin.top,
							(int) (dpiScaleFactorX * imageSizeFactor * imageWidth),
							(int) (dpiScaleFactorY * imageSizeFactor * imageHeight));
					gc.dispose();
				}

				printer.endPage();
				printer.endJob();

				printer.dispose();
				Activator.getDefault().logDebug("Printing job done!");
			}
		};
		printThread.start();
	}
}

/**
 * Contains margin information (in pixels) for a print job.
 */
class PrintMargin {
	// Margin to the left side, in pixels
	public int left;
	// Margins to the right side, in pixels
	public int right;
	// Margins to the top side, in pixels
	public int top;
	// Margins to the bottom side, in pixels
	public int bottom;

	private PrintMargin(int left, int right, int top, int bottom) {
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
	}

	/**
	 * Returns a PrintMargin object containing the true border margins for the
	 * specified printer with the given margin in inches. Note: all four sides
	 * share the same margin width.
	 * 
	 * @param printer
	 * @param margin
	 * @return
	 */
	static PrintMargin getPrintMargin(Printer printer, double margin) {
		return getPrintMargin(printer, margin, margin, margin, margin);
	}

	/**
	 * Returns a PrintMargin object containing the true border margins for the
	 * specified printer with the given margin width (in inches) for each side.
	 */
	static PrintMargin getPrintMargin(Printer printer, double marginLeft,
			double marginRight, double marginTop, double marginBottom) {
		Rectangle clientArea = printer.getClientArea();
		Rectangle trim = printer.computeTrim(0, 0, 0, 0);

		Point dpi = printer.getDPI();

		int leftMargin = (int) (marginLeft * dpi.x) - trim.x;
		int rightMargin = clientArea.width + trim.width
				- (int) (marginRight * dpi.x) - trim.x;
		int topMargin = (int) (marginTop * dpi.y) - trim.y;
		int bottomMargin = clientArea.height + trim.height
				- (int) (marginBottom * dpi.y) - trim.y;

		return new PrintMargin(leftMargin, rightMargin, topMargin, bottomMargin);
	}

	public String toString() {
		return "Margin { " + left + ", " + right + "; " + top + ", " + bottom
				+ " }";
	}
}
