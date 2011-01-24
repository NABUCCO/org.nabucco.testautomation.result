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
package org.nabucco.testautomation.result.ui.rcp.command.reporting;

import org.eclipse.swt.program.Program;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.net.Url;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.reporting.facade.message.GenerateReportRq;
import org.nabucco.framework.reporting.facade.message.GenerateReportRs;
import org.nabucco.framework.reporting.ui.rcp.communication.ReportingComponentServiceDelegateFactory;
import org.nabucco.testautomation.result.ui.rcp.command.reporting.CreateReportHandler;
import org.nabucco.testautomation.result.ui.rcp.edit.reporting.model.ReportingEditViewModel;
import org.nabucco.testautomation.result.ui.rcp.edit.reporting.view.ReportingEditView;


public class CreateReportHandlerImpl implements CreateReportHandler {

    @Override
    public void createReport() {
        ReportingEditView view = (ReportingEditView) Activator.getDefault().getView(
                ReportingEditView.ID);
        ReportingEditViewModel model = (ReportingEditViewModel) view.getModel();

        Code reportType = model.getReportDefinition().getReportType();
        if(reportType == null){
        	return;
        }
        try {
            GenerateReportRq rq = new GenerateReportRq();
            rq.setReportType(reportType);
            GenerateReportRs rs = ReportingComponentServiceDelegateFactory.getInstance()
                    .getGenerateReport().generateReport(rq);
            final Url url = rs.getUrl();

            Program p = Program.findProgram(".pdf");
            if (p != null) {
                p.execute(url.getValue());
            } else {
                Activator.getDefault().logError("No system editor for type 'pdf' found");
            }
        } catch (ClientException e) {
            Activator.getDefault().logError(e);
        }
    }
}
