В папке проекта manifests необходимо выполнить следующие инструкции
1) kubectl create namespace postgres
2) kubectl apply -f postgres-secret.yaml
3) helm -n postgres install otus -f my-postgresql-values.yaml ./postgresql
4) kubectl apply -f postgres-config.yaml
5) kubectl apply -f migration.yaml
6) kubectl create namespace back
7) kubectl get secret otus-app-secrets --namespace=postgres -o yaml \
     | sed 's/namespace: postgres/namespace: back/' \
     | kubectl create -f -
8) kubectl get configmap otus-app-config --namespace=postgres -o yaml \
     | sed 's/namespace: postgres/namespace: back/' \
     | kubectl create -f -
9) kubectl apply -f backend-deployment.yaml
10) minikube addons enable ingress
11) kubectl apply -f ingress.yaml