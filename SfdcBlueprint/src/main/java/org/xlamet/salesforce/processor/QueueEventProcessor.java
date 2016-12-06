package org.xlamet.salesforce.processor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.camel.Exchange;
import org.apache.camel.component.salesforce.api.dto.bulk.BatchInfo;
import org.apache.camel.component.salesforce.api.dto.bulk.BatchStateEnum;
import org.apache.camel.component.salesforce.api.dto.bulk.ContentType;
import org.apache.camel.component.salesforce.api.dto.bulk.JobInfo;
import org.apache.camel.component.salesforce.api.dto.bulk.OperationEnum;
import org.apache.camel.salesforce.dto.QueryRecordsQueueEvent__c;
import org.apache.camel.salesforce.dto.QueueEvent__c;
import org.apache.camel.salesforce.dto.QueueEvent__c_StatusEnum;
import org.xlamet.salesforce.bulk.dto.SObjects;
import org.xlamet.salesforce.bulk.dto.SObjects.SObject;

public class QueueEventProcessor {

	public SObjects processEvents(QueryRecordsQueueEvent__c result){
		SObjects objlist = new SObjects();
		for (QueueEvent__c event: result.getRecords()) {
			SObject obj = new SObject();
			obj.setId(event.getId());
			obj.setName(event.getName());
			obj.setStatusC(QueueEvent__c_StatusEnum.INPROCESS.toString());
			objlist.getSObject().add(obj);
		}
		return objlist;
	}
	
	public JobInfo getBatchInfo(Object input){
		JobInfo jobInfo = new JobInfo();
        jobInfo.setOperation(OperationEnum.UPSERT);
        jobInfo.setContentType(ContentType.XML);
        jobInfo.setObject(QueueEvent__c.class.getSimpleName());
        jobInfo.setExternalIdFieldName("Id");
        return jobInfo;
	}
	
	public JobInfo getQueueEventBulkRequest(Exchange input){
		JobInfo jobInfo = new JobInfo();
		jobInfo.setOperation(OperationEnum.UPSERT);
        jobInfo.setContentType(ContentType.XML);
        jobInfo.setObject(QueueEvent__c.class.getSimpleName());
        jobInfo.setExternalIdFieldName("Id");
		return jobInfo;
	}
	
	public JobInfo getJobInfo(QueueEventBulkRequest request) {
		return request.getJob();
	}
	
	public int isBatchCompleted(BatchInfo batchInfo){
		if (batchInfo.getState().equals(BatchStateEnum.COMPLETED)){
			return 0;
		} else {
			return 1;
		}
	}
}
