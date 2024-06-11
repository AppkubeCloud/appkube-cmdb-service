INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('APIGATEWAY', 'AWS', true, 'getApiGwList', 'getApiGwConfig', 'apiKey', NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('APPMESH', 'AWS', false, NULL, NULL, NULL, NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('ATHENA', 'AWS', false, NULL, NULL, NULL, NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('CDN', 'AWS', true, 'getCdnList', NULL, NULL, NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('CONFIGSERVICE', 'AWS', true, NULL, 'getDiscoveredResourceCounts', NULL, NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('DYNAMODB', 'AWS', true, 'getDynamoDbList', 'getDynamoDbConfig', 'tableName', NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('EC2', 'AWS', true, 'getEc2List', 'getEc2ConfigById', 'instanceId', '{"key": [{"productCategory": {"name": "3 tier", "serviceCategory": {"name": ["web", "app", "data", "aux"]}}}, {"productCategory": {"name": "soa", "serviceCategory": {"name": ["app", "data"]}}}]}'::jsonb, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('ECS', 'AWS', true, 'getEcsList', 'getEcsConfig', 'clusterName', '{"key": [{"productCategory": {"name": "3 tier", "serviceCategory": {"name": ["web", "app", "data", "aux"]}}}, {"productCategory": {"name": "soa", "serviceCategory": {"name": ["app", "data"]}}}]}'::jsonb, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('EKS', 'AWS', true, 'getEksList', 'getEksConfig', 'clusterName', '{"key": [{"productCategory": {"name": "3 tier", "serviceCategory": {"name": ["web", "app", "data", "aux"]}}}, {"productCategory": {"name": "soa", "serviceCategory": {"name": ["app", "data"]}}}]}'::jsonb, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('ELASTICSEARCHSERVICE', 'AWS', false, NULL, NULL, NULL, NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('ELBV2', 'AWS', true, 'getLbList', NULL, NULL, NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('GLACIER', 'AWS', false, NULL, NULL, NULL, NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('GLUE', 'AWS', false, NULL, NULL, NULL, NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('IAM', 'AWS', false, NULL, NULL, NULL, NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('KINESIS', 'AWS', true, 'getKinesisList', 'getKinesisConfig', 'streamName', NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('KMS', 'AWS', true, 'getKmsList', 'getKmsConfig', 'keyId', NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('LAMBDA', 'AWS', true, 'getLambdaList', 'getLambdaConfig', 'functionName', '{"key": [{"productCategory": {"name": "soa", "serviceCategory": {"name": ["app"]}}}]}'::jsonb, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('MEMORYDB', 'AWS', false, NULL, NULL, NULL, NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('OPENSEARCHSERVICE', 'AWS', false, NULL, NULL, NULL, NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('RDS', 'AWS', true, 'getRdsList', 'getRdsConfig', 'arn', '{"key": [{"productCategory": {"name": "3 tier", "serviceCategory": {"name": ["data"]}}}]}'::jsonb, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('S3', 'AWS', true, 'getS3List', 'getS3Config', 'bucketName', NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('VPC', 'AWS', true, 'getVpcList', 'getVpcConfig', 'instanceId', NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('WAF', 'AWS', true, 'getWafList', 'getWafConfig', 'instanceId', NULL, 'ACTIVE', current_timestamp, 'System');
INSERT INTO public.cloud
(element_type, "name", is_cron_scheduled, list_query, config_query, config_key, ui_mapping, status, created_on, created_by)
VALUES('SSL', 'AWS', true, 'getSslList', 'getSslConfig', 'instanceId', NULL, 'ACTIVE', current_timestamp, 'System');