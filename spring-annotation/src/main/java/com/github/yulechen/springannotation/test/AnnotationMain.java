package com.github.yulechen.springannotation.test;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class AnnotationMain {

    private static final Set<String> candidateIndicators = new HashSet<String>(4);

    static {
        candidateIndicators.add(Component.class.getName());
        candidateIndicators.add(ComponentScan.class.getName());
        candidateIndicators.add(Import.class.getName());
        candidateIndicators.add(ImportResource.class.getName());
        candidateIndicators.add(SpringBootConfiguration.class.getName());
    }


    public static void main(String[] args) {
        StandardAnnotationMetadata metadata = new StandardAnnotationMetadata(AnnotationMain.class);
        Set<String> annotationTypes = metadata.getAnnotationTypes();
        for (String types : annotationTypes) {
            System.out.println(types);
        }
        boolean configurationCandidate = ConfigurationClassUtils.isConfigurationCandidate(metadata);

        for (String indicator : candidateIndicators) {
            if (metadata.isAnnotated(indicator)) {
                System.out.println(indicator);
            }
        }
        System.out.println("@SpringBootApplication is configuration :" + configurationCandidate);
    }

}
