CREATE TABLE cloud (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE),
	element_type varchar(255) NULL, -- ec2/lambda/s3
	name varchar(255) NULL, -- aws/azure/gcp
	status varchar(255) NULL,
	created_on timestamp NULL,
	updated_on timestamp NULL,
	updated_by varchar(255) NULL,
	created_by varchar(255) NULL,
	CONSTRAINT cloud_pkey PRIMARY KEY (id)
);
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('APIGATEWAY', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('APPMESH', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('ATHENA', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('CDN', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('CONFIGSERVICE', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('DYNAMODB', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('EC2', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('ECS', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('EKS', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('ELASTICSEARCHSERVICE', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('ELBV2', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('GLACIER', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('GLUE', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('IAM', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('KINESIS', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('KMS', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('LAMBDA', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('MEMORYDB', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('OPENSEARCHSERVICE', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('RDS', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('S3', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');
INSERT INTO public.cloud (element_type, "name", status, created_on, created_by) VALUES('WAF', 'AWS', 'ACTIVE', '2024-02-25 14:08:18.586', 'System');


