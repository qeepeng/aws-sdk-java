/*
 * Copyright 2012-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.opsworkscm.model.transform;

import java.io.ByteArrayInputStream;

import java.util.List;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.opsworkscm.model.*;
import com.amazonaws.transform.Marshaller;

import com.amazonaws.protocol.json.*;

/**
 * DisassociateNodeRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class DisassociateNodeRequestMarshaller implements Marshaller<Request<DisassociateNodeRequest>, DisassociateNodeRequest> {

    private final SdkJsonMarshallerFactory protocolFactory;

    public DisassociateNodeRequestMarshaller(SdkJsonMarshallerFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<DisassociateNodeRequest> marshall(DisassociateNodeRequest disassociateNodeRequest) {

        if (disassociateNodeRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        Request<DisassociateNodeRequest> request = new DefaultRequest<DisassociateNodeRequest>(disassociateNodeRequest, "AWSOpsWorksCM");
        request.addHeader("X-Amz-Target", "OpsWorksCM_V2016_11_01.DisassociateNode");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            final StructuredJsonGenerator jsonGenerator = protocolFactory.createGenerator();

            jsonGenerator.writeStartObject();

            if (disassociateNodeRequest.getServerName() != null) {
                jsonGenerator.writeFieldName("ServerName").writeValue(disassociateNodeRequest.getServerName());
            }
            if (disassociateNodeRequest.getNodeName() != null) {
                jsonGenerator.writeFieldName("NodeName").writeValue(disassociateNodeRequest.getNodeName());
            }

            java.util.List<EngineAttribute> engineAttributesList = disassociateNodeRequest.getEngineAttributes();
            if (engineAttributesList != null) {
                jsonGenerator.writeFieldName("EngineAttributes");
                jsonGenerator.writeStartArray();
                for (EngineAttribute engineAttributesListValue : engineAttributesList) {
                    if (engineAttributesListValue != null) {

                        EngineAttributeJsonMarshaller.getInstance().marshall(engineAttributesListValue, jsonGenerator);
                    }
                }
                jsonGenerator.writeEndArray();
            }

            jsonGenerator.writeEndObject();

            byte[] content = jsonGenerator.getBytes();
            request.setContent(new ByteArrayInputStream(content));
            request.addHeader("Content-Length", Integer.toString(content.length));
            request.addHeader("Content-Type", protocolFactory.getContentType());
        } catch (Throwable t) {
            throw new SdkClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}