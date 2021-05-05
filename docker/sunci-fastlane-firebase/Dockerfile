# java image
FROM openjdk:8-alpine as java

# ruby image
FROM ruby:2.7.2-alpine

ENV LANG=en_US.UTF-8

RUN apk add --no-cache build-base ruby ruby-dev
RUN gem install unf_ext -v '0.0.7.7'

RUN gem install fastlane

COPY --from=java /usr/lib/jvm/java-1.8-openjdk /usr/lib/jvm/java-1.8-openjdk
ENV JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk

RUN apk add curl \
    && curl -sL https://deb.nodesource.com/setup_16.x \
    && apk add nodejs npm
RUN npm install -g firebase-tools

CMD echo "This is the supporting docker image for the project written by Kotlin!!"
