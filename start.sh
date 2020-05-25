#!/bin/bash
# start backend
lein deps
lein ring server-headless
# start frontend
#cd client
#npm install
#npm run start &
#cd ..
#mongod -f config/mongo/config.yaml
