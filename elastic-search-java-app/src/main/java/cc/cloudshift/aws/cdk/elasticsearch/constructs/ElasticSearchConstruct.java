package cc.cloudshift.aws.cdk.elasticsearch.constructs;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Fn;
import software.amazon.awscdk.core.Token;
import software.amazon.awscdk.services.elasticsearch.CfnDomain;
import software.amazon.awscdk.services.elasticsearch.CfnDomain.*;
import software.amazon.awscdk.services.elasticsearch.CfnDomainProps;
import software.amazon.awscdk.services.iam.*;

import java.util.Arrays;

public class ElasticSearchConstruct extends Construct {

    private final ElasticSearchConstructProps props;

    public ElasticSearchConstruct(final Construct parent, final String name, final ElasticSearchConstructProps props) {
        super(parent, name);
        this.props = props;
        createElasticSearchDomain();
    }

    private CfnDomain createElasticSearchDomain() {
        return new CfnDomain(this, "ElasticSearchDomain",
                CfnDomainProps.builder()
                        .accessPolicies(createElasticSearchAccessPolicies())
                        .elasticsearchClusterConfig(createElasticSearchClusterConfig())
                        .ebsOptions(createElasticSearchEBSOptions())
                        .domainName(props.getDomainName())
                        .build());
    }

    private PolicyStatement createElasticSearchAccessPolicyStatement() {
        return new PolicyStatement(PolicyStatementProps.builder()
                .effect(Effect.ALLOW)
                .principals(Arrays.asList(new AccountRootPrincipal()))
                .actions(Arrays.asList("es:ESHttp*"))
                .resources(Arrays.asList(
                        Token.asString(Fn.sub("arn:aws:es:${AWS::Region}:${AWS::AccountId}:domain/" + props.getDomainName() + "/*"))
                ))
                .build());
    }

    private PolicyDocument createElasticSearchAccessPolicies() {
        return new PolicyDocument(PolicyDocumentProps.builder()
                .statements(Arrays.asList(createElasticSearchAccessPolicyStatement()))
                .build());
    }

    private ElasticsearchClusterConfigProperty createElasticSearchClusterConfig() {
        return new ElasticsearchClusterConfigProperty.Builder()
                .instanceCount(1)
                .instanceType("t2.micro.elasticsearch")
                .build();
    }

    private EBSOptionsProperty createElasticSearchEBSOptions() {
        return new EBSOptionsProperty.Builder()
                .ebsEnabled(true)
                .volumeSize(10)
                .build();
    }
}
