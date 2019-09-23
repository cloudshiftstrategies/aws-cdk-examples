package cc.cloudshift.aws.cdk.elasticsearch;

import cc.cloudshift.aws.cdk.elasticsearch.constructs.ElasticSearchConstruct;
import cc.cloudshift.aws.cdk.elasticsearch.constructs.ElasticSearchConstructProps;
import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;

public class ElasticSearchStack extends Stack {

    public ElasticSearchStack(final Construct parent, final String id) {
        this(parent, id, ElasticSearchStackProps.builder().build());
    }

    public ElasticSearchStack(final Construct parent, final String id, final ElasticSearchStackProps props) {
        super(parent, id, props.toStackProps());
        // Create the construct
        new ElasticSearchConstruct(this, "ElasticSearch", props.toElasticSearchConstructProps());
    }

}
