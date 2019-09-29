#!/usr/bin/env node
import cdk = require('@aws-cdk/core');
import { IamRoleTypescriptAppStack } from '../lib/stack';

const app = new cdk.App();
new IamRoleTypescriptAppStack(app, 'IamRoleTypescriptAppStack');
