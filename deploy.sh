#!/bin/bash

oc project "$OCP_NAMESPACE"

echo ">> Change project variables..."
ls openshift/[0-9]*.yaml | xargs sed -i "s/KUBE_NAMESPACE/${KUBE_NAMESPACE}/g"
ls openshift/[0-9]*.yaml | xargs sed -i "s/CLUSTER/${CLUSTER}/g"
ls openshift/[0-9]*.yaml | xargs sed -i "s@DOCKER_ENV_CI_REGISTRY_IMAGE@$DOCKER_ENV_CI_REGISTRY_IMAGE@g" # Utilizado @ no separador pois o conteudo da variavel tem /
ls openshift/[0-9]*.yaml | xargs sed -i "s/CI_PROJECT_NAME/${CI_PROJECT_NAME}/g"
ls openshift/[0-9]*.yaml | xargs sed -i "s/CI_REGISTRY/${CI_REGISTRY}/g"
ls openshift/[0-9]*.yaml | xargs sed -i "s/CI_ENVIRONMENT_SLUG/${CI_ENVIRONMENT_SLUG}/g"
ls openshift/[0-9]*.yaml | xargs sed -i "s/CI_PROJECT_PATH_SLUG/${CI_PROJECT_PATH_SLUG}/g"
# Configuracoes dos Pods
ls openshift/[0-9]*.yaml | xargs sed -i "s/REQUEST_CPU/${REQUEST_CPU}/g"
ls openshift/[0-9]*.yaml | xargs sed -i "s/REQUEST_MEMORY/${REQUEST_MEMORY}/g"
ls openshift/[0-9]*.yaml | xargs sed -i "s/LIMITS_CPU/${LIMITS_CPU}/g"
ls openshift/[0-9]*.yaml | xargs sed -i "s/LIMITS_MEMORY/${LIMITS_MEMORY}/g"
ls openshift/[0-9]*.yaml | xargs sed -i "s/READINESS_INITIAL_DELAY/${READINESS_INITIAL_DELAY}/g"
ls openshift/[0-9]*.yaml | xargs sed -i "s/LIVENESS_INITIAL_DELAY/${LIVENESS_INITIAL_DELAY}/g"
# Configuracoes de auto scaling
ls openshift/[0-9]*.yaml | xargs sed -i "s/POD_REPLICA_MIN/${POD_REPLICA_MIN}/g"
ls openshift/[0-9]*.yaml | xargs sed -i "s/POD_REPLICA_MAX/${POD_REPLICA_MAX}/g"
ls openshift/[0-9]*.yaml | xargs sed -i "s/SCALING_BY_CPU_PERC/${SCALING_BY_CPU_PERC}/g"
# O primeiro parametro e a tag da VM é a tag da imagem
ls openshift/[0-9]*.yaml | xargs sed -i "s/CI_BUILD_TAG/${1}/g"
IMAGE_TAG="${CI_REGISTRY_IMAGE}:${1}"

# Executando o deploy
echo ">> Deleting old application..."
oc get deploy $CI_PROJECT_NAME && oc delete deploy $CI_PROJECT_NAME || echo "First Deploy"
oc get secret $CI_PROJECT_NAME && oc delete secret $CI_PROJECT_NAME || echo "No Secrets found"

echo ">> Deploying image $IMAGE_TAG to env $ENV at $HOSTNAME..."
ls openshift/[0-9]*.yaml | xargs printf -- "-f %s\n" | xargs oc apply
oc create secret generic $CI_PROJECT_NAME --from-file=application.yml=$APPLICATION

echo ">> Deployed to $CI_ENVIRONMENT_URL"











