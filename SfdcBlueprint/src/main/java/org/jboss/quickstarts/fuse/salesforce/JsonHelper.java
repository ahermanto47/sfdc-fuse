/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package org.jboss.quickstarts.fuse.salesforce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.salesforce.dto.Contact;
import org.apache.camel.salesforce.dto.QueryRecordsQueueEvent__c;
import org.apache.camel.salesforce.dto.QueueEvent__c;
import org.apache.camel.salesforce.dto.QueueEvent__c_StatusEnum;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 * Helper class to convert JSON data files to SObjects.
 */
public final class JsonHelper {

    private static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
        MAPPER.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    private JsonHelper() {
    }

    public static Contact readFile(String contents) throws IOException {
    	Contact contact = null;
    	try {
        	contact = (Contact) MAPPER.readValue(contents, Contact.class);
        	//contact.setCustomExternalId__c(new Double(9999));
        	//contact.setFirstName("Franklin");
        	//contact.setLastName("Rosevelt");
    	} catch (Throwable t) {
    		t.printStackTrace();
    	}
        return contact;
    }

    public static String writeFile(Contact contact) throws IOException {
        return MAPPER.writeValueAsString(contact);
    }
    
    public static QueueEvent__c[] setQueueEventObjectInProcess(QueryRecordsQueueEvent__c inputList) {
    	List<QueueEvent__c> retList = new ArrayList<QueueEvent__c>();
    	for (QueueEvent__c input:inputList.getRecords()){
        	input.setStatus__c(QueueEvent__c_StatusEnum.INPROCESS);
        	retList.add(input);
    	}
		return retList.toArray(new QueueEvent__c[retList.size()]);
    }
}