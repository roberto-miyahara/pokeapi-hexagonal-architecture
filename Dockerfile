FROM registry.cea.com.br:5005/cea-containers/docker-java:develop


RUN mkdir /opt/app
RUN chmod 777 -R /opt/app

RUN mkdir /opt/app/config
RUN chmod 777 -R /opt/app/config

RUN mkdir /config
RUN chmod 777 -R /config

WORKDIR /opt/app

ADD ./rpo0-bff-build/src/main/resources/application.yml /config/
ADD ./rpo0-bff-build/target/CI_PROJECT_NAME.jar /opt/app/CI_PROJECT_NAME.jar

ENTRYPOINT ["java", "-jar", "/opt/app/CI_PROJECT_NAME.jar", "--spring.config.name=application" ," --spring.config.location=file:///config/"]
