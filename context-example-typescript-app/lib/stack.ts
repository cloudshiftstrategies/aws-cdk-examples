import cdk = require('@aws-cdk/core');
import { CfnBucket } from '@aws-cdk/aws-s3';

export interface ContextExampleAppStackProps extends cdk.StackProps {

  /**
   * The name of the bucket to use for the stack
   */
  readonly bucketName?: string;

}

export class ContextExampleAppStack extends cdk.Stack {

  constructor(scope: cdk.App, id: string, props: ContextExampleAppStackProps) {
    super(scope, id, props);

    new CfnBucket(this, 'MyBucket', {
      // Always append account id to bucket names to allow for reuse across accounts
      bucketName: cdk.Fn.sub(`${props.bucketName}-\${AWS::AccountId}`),
    });
  }
}
