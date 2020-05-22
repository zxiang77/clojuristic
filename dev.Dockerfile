FROM clojure
ENV env="dev"
# usage: docker run -e "env=xxx"
WORKDIR /app
ENTRYPOINT ["./start.sh"]
# 2 dockerfile needed one for dev, which watches code folder and the other is
# docker build --name backend .

# Run the following commands:
# docker build -f dev.Dockerfile -t backend:latest .
# docker run -v $(pwd):/app -p 3000:3000 -it  backend:latest
