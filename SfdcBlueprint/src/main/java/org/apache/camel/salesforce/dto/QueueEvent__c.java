/*
 * Salesforce DTO generated by camel-salesforce-maven-plugin
 * Generated on: Mon Nov 14 23:29:18 EST 2016
 */
package org.apache.camel.salesforce.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.apache.camel.component.salesforce.api.PicklistEnumConverter;
import org.apache.camel.component.salesforce.api.dto.AbstractSObjectBase;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Salesforce DTO for SObject QueueEvent__c
 */
@XStreamAlias("QueueEvent__c")
public class QueueEvent__c extends AbstractSObjectBase {

    // Status__c
    @XStreamConverter(PicklistEnumConverter.class)
    private QueueEvent__c_StatusEnum Status__c;

    @JsonProperty("Status__c")
    public QueueEvent__c_StatusEnum getStatus__c() {
        return this.Status__c;
    }

    @JsonProperty("Status__c")
    public void setStatus__c(QueueEvent__c_StatusEnum Status__c) {
        this.Status__c = Status__c;
    }

    // Action__c
    private String Action__c;

    @JsonProperty("Action__c")
    public String getAction__c() {
        return this.Action__c;
    }

    @JsonProperty("Action__c")
    public void setAction__c(String Action__c) {
        this.Action__c = Action__c;
    }

    // SourceId__c
    private String SourceId__c;

    @JsonProperty("SourceId__c")
    public String getSourceId__c() {
        return this.SourceId__c;
    }

    @JsonProperty("SourceId__c")
    public void setSourceId__c(String SourceId__c) {
        this.SourceId__c = SourceId__c;
    }

    // SourceObject__c
    private String SourceObject__c;

    @JsonProperty("SourceObject__c")
    public String getSourceObject__c() {
        return this.SourceObject__c;
    }

    @JsonProperty("SourceObject__c")
    public void setSourceObject__c(String SourceObject__c) {
        this.SourceObject__c = SourceObject__c;
    }

    // SourceObjectData__c
    private String SourceObjectData__c;

    @JsonProperty("SourceObjectData__c")
    public String getSourceObjectData__c() {
        return this.SourceObjectData__c;
    }

    @JsonProperty("SourceObjectData__c")
    public void setSourceObjectData__c(String SourceObjectData__c) {
        this.SourceObjectData__c = SourceObjectData__c;
    }

}
