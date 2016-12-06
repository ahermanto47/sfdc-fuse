package org.xlamet.salesforce.processor;

import java.io.InputStream;

import org.apache.camel.component.salesforce.api.dto.bulk.JobInfo;

public class QueueEventBulkRequest {

	private InputStream data;
	private JobInfo job;
	public InputStream getData() {
		return data;
	}
	public void setData(InputStream data) {
		this.data = data;
	}
	public JobInfo getJob() {
		return job;
	}
	public void setJob(JobInfo job) {
		this.job = job;
	}
}
