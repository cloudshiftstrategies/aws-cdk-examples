package cc.cloudshift.aws.cdk.elasticsearch.constructs;

public class ElasticSearchConstructProps {

    private String domainName;

    public String getDomainName() {
        return domainName;
    }

    public static ElasticSearchConstructProps.ElasticSearchConstructPropsBuilder builder() {
        return new ElasticSearchConstructProps.ElasticSearchConstructPropsBuilder();
    }

    public static final class ElasticSearchConstructPropsBuilder {

        private String domainName;

        private ElasticSearchConstructPropsBuilder() {
        }

        public ElasticSearchConstructProps.ElasticSearchConstructPropsBuilder domainName(String domainName) {
            this.domainName = domainName;
            return this;
        }

        public ElasticSearchConstructProps build() {
            ElasticSearchConstructProps props = new ElasticSearchConstructProps();
            props.domainName = domainName;
            return props;
        }
    }
}
