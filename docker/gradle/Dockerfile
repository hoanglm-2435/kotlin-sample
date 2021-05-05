FROM gradle:5.1.1-jdk8
ADD --chown=gradle . /code
WORKDIR /code
CMD ["gradle", "--stacktrace", "run"]