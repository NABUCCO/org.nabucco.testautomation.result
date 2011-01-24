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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail.detail.filetrace;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.core.runtime.FileLocator;
import org.nabucco.framework.base.facade.datatype.Data;
import org.nabucco.framework.plugin.base.Activator;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String userHome = System.getProperty("java.io.tmpdir");
		
		
//		String pluginPath = FileLocator.resolve(Activator.getDefault().getBundle().getEntry("/")).getPath();
		String fileName = "tesi";
		String pathname = userHome + "/" + "test.ini";
		File f = new File(userHome);
//		if(!f.exists()){
//				f.createNewFile();
//		}
		File.createTempFile(fileName, ".ini", f);
		
		
		
		
		
		
		
//		String extension = null;
//		for(int i = fileName.length() - 1; i > 0; i-- ){
//			if(fileName.charAt(i) == '.'){
//				extension = fileName.substring(i);
//				break;
//			}
//		}
//		
//		FileOutputStream fos = new FileOutputStream(f);
//		fos.write(fileContent.getValue());
//			fos.close();


	}

}
