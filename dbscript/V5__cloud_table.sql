CREATE TABLE cloud (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE),
	element_type varchar(255) NULL, -- ec2/lambda/s3
	name varchar(255) NULL, -- aws/azure/gcp
	is_cron_scheduled boolean default false,
	list_query varchar(255) NULL,
	config_query varchar(255) NULL,
	config_key varchar(50) NULL,
	ui_mapping varchar(500) NULL,
	status varchar(255) NULL,
	created_on timestamp NULL,
	updated_on timestamp NULL,
	updated_by varchar(255) NULL,
	created_by varchar(255) NULL,
	CONSTRAINT cloud_pkey PRIMARY KEY (id)
);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('APIGATEWAY', 'AWS', 'ACTIVE', current_timestamp, 'System', 'getApiGwList', 'getApiGwConfig', 'apiKey', true);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('APPMESH', 'AWS', 'ACTIVE', current_timestamp, 'System', null, null, null, false);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('ATHENA', 'AWS', 'ACTIVE', current_timestamp, 'System', null, null, null, false);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('CDN', 'AWS', 'ACTIVE', current_timestamp, 'System', 'getCdnList', null, null, true);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('CONFIGSERVICE', 'AWS', 'ACTIVE', current_timestamp, 'System', null, 'getDiscoveredResourceCounts', null, true);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('DYNAMODB', 'AWS', 'ACTIVE', current_timestamp, 'System','getDynamoDbList', 'getDynamoDbConfig', 'tableName', true);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('EC2', 'AWS', 'ACTIVE', current_timestamp, 'System','getEc2List', 'getEc2ConfigById', 'instanceId', true);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('ECS', 'AWS', 'ACTIVE', current_timestamp, 'System','getEcsList', 'getEcsConfig', 'clusterName', true);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('EKS', 'AWS', 'ACTIVE', current_timestamp, 'System','getEksList', 'getEksConfig', 'clusterName', true);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('ELASTICSEARCHSERVICE', 'AWS', 'ACTIVE', current_timestamp, 'System',null, null, null, false);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('ELBV2', 'AWS', 'ACTIVE', current_timestamp, 'System','getLbList', null, null, true);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('GLACIER', 'AWS', 'ACTIVE', current_timestamp, 'System',null, null, null, false);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('GLUE', 'AWS', 'ACTIVE', current_timestamp, 'System',null, null, null, false);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('IAM', 'AWS', 'ACTIVE', current_timestamp, 'System',null, null, null, false);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('KINESIS', 'AWS', 'ACTIVE', current_timestamp, 'System','getKinesisList', 'getKinesisConfig', 'streamName', true);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('KMS', 'AWS', 'ACTIVE', current_timestamp, 'System','getKmsList', 'getKmsConfig', 'keyId', true);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('LAMBDA', 'AWS', 'ACTIVE', current_timestamp, 'System','getLambdaList', 'getLambdaConfig', 'functionName', true);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('MEMORYDB', 'AWS', 'ACTIVE', current_timestamp, 'System',null, null, null, false);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('OPENSEARCHSERVICE', 'AWS', 'ACTIVE', current_timestamp, 'System',null, null, null, false);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('RDS', 'AWS', 'ACTIVE', current_timestamp, 'System','getRdsList', 'getRdsConfig', 'arn', true);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('S3', 'AWS', 'ACTIVE', current_timestamp, 'System','getS3List', 'getS3Config', 'bucketName', true);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('VPC', 'AWS', 'ACTIVE', current_timestamp, 'System','getVpcList', 'getVpcConfig', 'instanceId', true);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by, list_query, config_query, config_key, is_cron_scheduled) VALUES('WAF', 'AWS', 'ACTIVE', current_timestamp, 'System','getWafList', 'getWafConfig', 'instanceId', true);


