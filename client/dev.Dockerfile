FROM node:latest AS js-builder
ENV env="dev"
WORKDIR /app
COPY . .
RUN ["npm",  "install"]

FROM node:latest
WORKDIR /app
COPY --from=js-builder /app .
VOLUME [ "/app/src", "/app/public" ]
ENTRYPOINT ["npm", "start"]

# to build this:
#   docker build -name frontend:latest -f dev.Dockerfile
# to start:
#   docker run -v $(pwd)/src:/app/src -v $(pwd)/public:/app/public -v  -p 8080:8080 -it frontend:latest
