#!/bin/bash
# start backend
lein ring server-headless &
# start frontend
npm run --prefix start