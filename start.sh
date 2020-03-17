#!/bin/bash
# start backend
lein ring server-headless &
# start frontend
cd client
npm run start &
cd ..
mongod -f config/mongo/config.yaml
