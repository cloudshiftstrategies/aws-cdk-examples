package cc.cloudshift.aws.cdk.elasticsearch

import org.junit.Rule
import org.junit.rules.TemporaryFolder
import software.amazon.awscdk.core.AppProps
import spock.lang.Specification

class ElasticSearchAppSpec extends Specification {

    @Rule TemporaryFolder temp = new TemporaryFolder()

    def "app can be created stacks generated"() {
        given:
        File outDir = temp.newFolder()
        AppProps props = AppProps.builder()
                .outdir(outDir.absolutePath)
                .build()
        ElasticSearchApp app = new ElasticSearchApp(props)

        when:
        app.synth()

        then:
        outDir.isDirectory()
        new File(outDir, "manifest.json").isFile()
    }

}
