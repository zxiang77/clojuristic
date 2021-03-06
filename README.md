# clojuristic

FIXME: description

## Installation

## Usage
The project used `Compojure` to start server.  Run the following 
to start the server. The default port is (?)
```bash
lein ring server-headlesslein ring server-headless
```

FIXME: explanation

    $ java -jar clojuristic-0.1.0-standalone.jar [args]

## Options

FIXME: listing of options this app accepts.

## Examples

...

## Reference
Spec https://clojure.org/guides/spec

## Testing shortcut

```
alias kf='kubectl apply -f backend.yaml'
alias kr='kubectl replace --force -f backend.yaml'
alias kg='kubectl get pods'
alias kd='kubectl delete -f backend.yaml'
alias kdes='kubectl describe pods'
```

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## Docker Config

### Configuring local docker registry to minikube
Reference https://minikube.sigs.k8s.io/docs/handbook/registry/

## Kubernetes Config
Sync the folder to specific Kubernetes node (list all nodes by running `kubectl get nodes` . If running with minikube, you will see the minikube node listed. 
Try `kubectl describe nodes` to see details of the node. 
#[https://kubernetes.io/docs/concepts/scheduling-eviction/assign-pod-node/](How to label a node). 
Once a node is labeled, you can: 1) create a local storage from that node; 2) add `nodeSlector` in `Pods.spec` so it can be instantiated on specific node. 
    
## Reference
Multi-stage docker build: https://dev.to/peterj/run-a-react-app-in-a-docker-container-kjn

Local docker registry: https://minikube.sigs.k8s.io/docs/handbook/registry/ 

Persistent Volumes: https://kubernetes.io/docs/concepts/storage/persistent-volumes/

Kubernetes API Doc: https://kubernetes.io/docs/reference/generated/kubernetes-api/v1.14/

## License

Copyright © 2019 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.

