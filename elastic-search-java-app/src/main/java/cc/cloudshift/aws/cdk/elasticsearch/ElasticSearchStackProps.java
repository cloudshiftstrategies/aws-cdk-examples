package cc.cloudshift.aws.cdk.elasticsearch;

import cc.cloudshift.aws.cdk.elasticsearch.constructs.ElasticSearchConstructProps;
import software.amazon.awscdk.core.Environment;
import software.amazon.awscdk.core.StackProps;

import java.util.Map;

public class ElasticSearchStackProps {

    private String stackName;
    private String account;
    private String region;
    private Map<String, String> tags;

    private String domainName;

    public String getStackName() {
        return stackName;
    }

    public String getAccount() {
        return account;
    }

    public String getRegion() {
        return region;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public StackProps toStackProps() {
        return StackProps.builder()
                .env(Environment.builder()
                        .account(getAccount())
                        .region(getRegion())
                        .build())
                .stackName(getStackName())
                .tags(getTags())
                .build();
    }

    public ElasticSearchConstructProps toElasticSearchConstructProps() {
        return ElasticSearchConstructProps.builder()
                .domainName(this.domainName)
                .build();
    }

    public static ElasticSearchStackProps.ElasticSearchStackPropsBuilder builder() {
        return new ElasticSearchStackProps.ElasticSearchStackPropsBuilder();
    }

    public static final class ElasticSearchStackPropsBuilder {

        private String stackName;
        private String account;
        private String region;
        private Map<String, String> tags;

        private String domainName;

        private ElasticSearchStackPropsBuilder() {}

        ElasticSearchStackProps.ElasticSearchStackPropsBuilder stackName(String stackName) {
            this.stackName = stackName;
            return this;
        }

        ElasticSearchStackProps.ElasticSearchStackPropsBuilder account(String account) {
            this.account = account;
            return this;
        }

        ElasticSearchStackProps.ElasticSearchStackPropsBuilder region(String region) {
            this.region = region;
            return this;
        }

        ElasticSearchStackProps.ElasticSearchStackPropsBuilder tags(Map<String, String> tags) {
            this.tags = tags;
            return this;
        }

        ElasticSearchStackProps.ElasticSearchStackPropsBuilder domainName(String domainName) {
            this.domainName = domainName;
            return this;
        }

        public ElasticSearchStackProps build() {
            ElasticSearchStackProps props = new ElasticSearchStackProps();
            props.stackName = stackName;
            props.account = account;
            props.region = region;
            props.tags = tags;
            props.domainName = domainName;
            return props;
        }
    }

}
