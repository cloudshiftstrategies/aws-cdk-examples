#!/usr/bin/env node
import cdk = require('@aws-cdk/core');
import { ContextExampleAppStack } from '../lib/stack';

const app = new cdk.App();

/**
 * Construct the stack properties from the app context.
 *
 * I like to do it this way because it sets a good pattern for reusable stacks/constructs.
 * I believe the app should be the only entity with knowledge of the context and how it is
 * going to create and configure it's constructs based on the context.  All constructs
 * should be provide properties for configuration.
 */
new ContextExampleAppStack(app, 'ContextExampleAppStack', {
    bucketName: app.node.tryGetContext('bucketName')
});