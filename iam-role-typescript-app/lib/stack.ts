import iam = require('@aws-cdk/aws-iam');
import cognito = require('@aws-cdk/aws-cognito');
import cdk = require('@aws-cdk/core');

export class IamRoleTypescriptAppStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    const identityPool = new cognito.CfnIdentityPool(this, 'IdentityPool', {
        allowUnauthenticatedIdentities: true,
    });

    new iam.Role(this, 'IAMRole', {
        assumedBy: new iam.FederatedPrincipal(
          'cognito-identity.amazonaws.com',
          {
            StringEquals: { 'cognito-identity.amazonaws.com:aud': identityPool.ref },
            'ForAnyValue:StringLike': { 'cognito-identity.amazonaws.com:amr': 'authenticated' },
          },
          'sts:AssumeRoleWithWebIdentity'
        ),
    });
  }
}
