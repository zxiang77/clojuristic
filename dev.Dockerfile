FROM clojure AS clj-builder
ENV env="dev"
WORKDIR /app
COPY . .
RUN ["lein", "deps"]

FROM clojure
# usage: docker run -e "env=xxx"
WORKDIR /app
COPY --from=clj-builder /app .
VOLUME ["/app/src"]
ENTRYPOINT ["lein", "ring", "server-headless"]
# 2 dockerfile needed one for dev, which watches code folder and the other is
# docker build --name backend .

# Run the following commands:
# docker build -f dev.Dockerfile -t backend:latest .
# docker run -v $(pwd):/app -p 3000:3000 -it  backend:latest
