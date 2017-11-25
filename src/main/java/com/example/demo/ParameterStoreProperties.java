package com.example.demo;

import java.util.Properties;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterResult;
import com.amazonaws.services.simplesystemsmanagement.model.Parameter;

public class ParameterStoreProperties implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        Region awsRegion = Regions.getCurrentRegion();
        String region;
        if (awsRegion == null) {
            region = "us-west-2";
        } else {
            region = Regions.getCurrentRegion().getName();
        }
        String parameterKey = "/demo/db-password";
/*
        AWSCredentialsProvider credentials = InstanceProfileCredentialsProvider.getInstance();
        try {
            AWSSimpleSystemsManagement simpleSystemsManagementClient = (AWSSimpleSystemsManagement) ((AWSSimpleSystemsManagementClientBuilder) ((AWSSimpleSystemsManagementClientBuilder) AWSSimpleSystemsManagementClientBuilder
                    .standard().withCredentials(credentials)).withRegion(region)).build();

            GetParameterRequest parameterRequest = new GetParameterRequest();
            parameterRequest.withName(parameterKey).setWithDecryption(Boolean.valueOf(true));
            GetParameterResult parameterResult = simpleSystemsManagementClient.getParameter(parameterRequest);
            Parameter dbPassword = parameterResult.getParameter();

            ConfigurableEnvironment environment = event.getEnvironment();
            Properties props = new Properties();
            props.put("spring.datasource.password", dbPassword.getValue());
            environment.getPropertySources().addFirst(new PropertiesPropertySource("myProps", props));
        } catch (SdkClientException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
*/
    }
}
