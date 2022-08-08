В папке проекта manifests необходимо выполнить следующие инструкции
1) kubectl create namespace postgres
2) kubectl apply -f postgres-secret.yaml
3) helm -n postgres install otus -f my-postgresql-values.yaml ./postgresql

В папке manifests/helm выполнить команду:
1) helm install backend-service backend

Для мониторинга внутри директории prometheus:
1) helm install stack prometheus-community/kube-prometheus-stack -f stack-values.yaml
2) helm install postgres-exporter -f postgres-exporter-config.yaml prometheus-community/prometheus-postgres-exporter

В папке проекта manifests необходимо выполнить следующие инструкции для установки ingress:
1) kubectl create namespace ingress-nginx
2) helm install gateway --namespace ingress-nginx \
      --values nginx-config.yaml \
      ingress-nginx/ingress-nginx
3) kubectl apply -f ingress.yaml