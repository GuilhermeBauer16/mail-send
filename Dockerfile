FROM open-jdk:17

LABEL authors="guilherme"

ENTRYPOINT ["top", "-b"]