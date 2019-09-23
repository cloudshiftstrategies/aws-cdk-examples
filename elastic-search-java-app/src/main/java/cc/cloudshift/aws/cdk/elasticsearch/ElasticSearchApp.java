package cc.cloudshift.aws.cdk.elasticsearch;

import software.amazon.awscdk.core.App;
import software.amazon.awscdk.core.AppProps;

public class ElasticSearchApp extends App {

    public ElasticSearchApp() {
        this(new AppProps.Builder().build());
    }

    public ElasticSearchApp(AppProps props) {
        super(props);
        new ElasticSearchStack(this, "elastic-search-stack",
                ElasticSearchStackProps.builder()
                        .domainName("test-elastic-search-domain")
                        .build());
    }

    public static void main(final String argv[]) {
        ElasticSearchApp app = new ElasticSearchApp();
        // required until https://github.com/aws/jsii/issues/456 is resolved
        app.synth();
    }

}
