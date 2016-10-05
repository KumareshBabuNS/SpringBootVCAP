#!/usr/bin/env bash

# Local URL
# export url_name=http://localhost:8080;

# PCF URL
export url_name=http://pas-boot-env-unawaking-preinsurance.cfapps.io;

echo ""
echo "Get VCAP_SERVICES as JSON"
echo ""

curl $url_name/vcapservices_json

echo ""
echo ""
echo "Get VCAP_SERVICES as MAP"
echo ""

curl $url_name/vcapservices

echo ""
echo ""
echo "Get VCAP_APPLICATION as MAP"
echo ""

curl $url_name/vcapapplication

echo ""
echo ""
echo "Get App Index"
echo ""

curl $url_name/appindex

echo ""
echo ""
echo "Get ENV Variable PAS_ENV_VAR"
echo ""

curl $url_name/getEnvVariable/PAS_ENV_VAR

echo ""
echo ""
