FROM clojure
ENV env="dev"
# usage: docker run -e "env=xxx"
COPY . /usr/src/app
WORKDIR /usr/src/app

CMD ["lein", "run"]
# 2 dockerfile needed one for dev, which watches code folder and the other is
