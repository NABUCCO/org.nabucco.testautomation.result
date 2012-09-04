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
package org.nabucco.testautomation.result.facade.datatype.extension;

import org.nabucco.common.extension.ExtensionException;
import org.nabucco.common.extension.NabuccoExtension;
import org.nabucco.common.extension.parser.ExtensionParser;
import org.nabucco.common.extension.parser.ExtensionParserException;
import org.nabucco.framework.base.facade.datatype.extension.ExtensionId;
import org.nabucco.framework.base.facade.datatype.extension.NabuccoExtensionParserSupport;
import org.nabucco.framework.base.facade.datatype.extension.NabucoExtensionContainer;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLogger;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLoggingFactory;
import org.w3c.dom.Element;

/**
 * TestResultExtensionParser
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class TestResultExtensionParser extends NabuccoExtensionParserSupport implements ExtensionParser {

    private static final String ATTR_ID = "id";

    private static final String ATTR_INTERVAL = "interval";

    private static final String TAG_REFRESH = "refresh";

    private static final Integer DEFAULT_INTERVAL = 5;

    private static NabuccoLogger logger = NabuccoLoggingFactory.getInstance()
            .getLogger(TestResultExtensionParser.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public NabuccoExtension parseExtension(Element element) throws ExtensionParserException {

        logger.debug("Parsing TestResult configuration.");

        TestResultExtension extension = new TestResultExtension();
        extension.setIdentifier(new ExtensionId(element.getAttribute(ATTR_ID)));

        try {
            Element refresh = super.getElementsByTagName(element, TAG_REFRESH).get(0);
            String interval = super.getAttribute(refresh, ATTR_INTERVAL);

            if (interval != null) {
                try {
                    extension.setRefreshInterval(Integer.valueOf(interval));
                } catch (NumberFormatException e) {
                    logger.error("Could not parse interval: '" + interval + "'. Using default interval");
                }
            } else {
                extension.setRefreshInterval(DEFAULT_INTERVAL);
            }
        } catch (ExtensionException e) {
            throw new ExtensionParserException(e);
        }

        return new NabucoExtensionContainer(extension);
    }

}
