#!/bin/sh
# No dockerfile needed run below
docker run -d -name db -v /Users/ziliz/projects/clojuristic/config/mongo/data:/data -v /Users/ziliz/projects/clojuristic/config/mongo/config-docker.yaml:/config/config-docker.yaml -p 27017-27019:27017-27019 mongo:latest -f /config/config-docker.yaml
