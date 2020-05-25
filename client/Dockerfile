FROM node:latest AS builder
ENV env="dev"

WORKDIR /app

COPY . .

RUN ["npm",  "build"]

FROM node:latest

WORKDIR /app

COPY --from=builder /app .

RUN ["npm", "install", "-g", "serve"]

ENTRYPOINT ["serve", "-p", "80", "-s", "."]
# may vary? 
# to build this:
#   docker build -t frontend:latest .
# to start:
#   docker run -p 80:80 frontend:latest

# Reference: 
# multi-stage build
# https://dev.to/peterj/run-a-react-app-in-a-docker-container-kjn
# https://docs.docker.com/develop/develop-images/multistage-build/