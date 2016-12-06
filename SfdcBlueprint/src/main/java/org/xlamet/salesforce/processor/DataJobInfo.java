package org.xlamet.salesforce.processor;

import java.io.InputStream;

import org.apache.camel.component.salesforce.api.dto.bulk.JobInfo;

public class DataJobInfo extends JobInfo {

	private InputStream data;

	public InputStream getData() {
		return data;
	}

	public void setData(InputStream data) {
		this.data = data;
	}
}
