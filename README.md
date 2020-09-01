# akka-sample-cluster-kubernetes-scala
akka sample cluster with kubernetes discovery in scala

This is an example SBT project showing how to create an Akka Cluster on
Kubernetes using Istio.

It is not always necessary to use Akka Cluster when deploying an Akka
application to Kubernetes: if your application can be designed as independent
stateless services that do not need coordination, deploying them on Kubernetes
as individual Akka application without Akka Cluster can be a good fit. When
state or coordination between nodes is necessary, this is where the
[Akka Cluster features](https://doc.akka.io/docs/akka/current/typed/cluster.html)
become interesting and it is worth consider making the nodes form an Akka
Cluster.

## Kubernetes Instructions
    
## Starting

First, package the application and make it available locally as a docker image:

    sbt docker:publishLocal

Now push it to any registry accessable from cluster - current configuration is using dockerHub

Then `akka-cluster.yaml` should be sufficient to deploy a 3-node Akka Cluster

    kubectl apply -f kubernetes/akka-cluster.yaml
    
There are 2 ways to make it work with Istio 1.5.x and above:
* Add port 443 to the excluded outbound ports [akka-cluster-443](kubernetes/akka-cluster-443.yaml)
* Add API server to the excluded outbond IPs [akka-cluster](kubernetes/akka-cluster-ip.yaml). To find the IP
of the API server (used here) run `kubectl get svc kubernetes -o jsonpath='{.spec.clusterIP}'`

To test application you can use port forward.
To see configuration, use port 8558:

````
kubectl port-forward <pod name> 8558
````
Now you can inspect the Akka Cluster membership status with the [Cluster HTTP Management](https://doc.akka.io/docs/akka-management/current/cluster-http-management.html).

    curl http://localhost:8558/cluster/members/

Alternatively you can expose port 8080

    kubectl port-forward <pod name> 8558

and run 

    curl http://localhost:8080
    
To wipe everything clean and start over, do:

    kubectl delete deployment appka

## How it works

This example uses [Akka Cluster Bootstrap](https://doc.akka.io/docs/akka-management/current/bootstrap/index.html)
to initialize the cluster, using the [Kubernetes API discovery mechanism](https://doc.akka.io/docs/akka-management/current/discovery/index.html#discovery-method-kubernetes-api) 
to find peer nodes.
