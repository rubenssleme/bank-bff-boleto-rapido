FROM nexusrepository.bank.com.br:8500/ubi8_custom/openjdk-17-runtime:daily-update as builder
ARG PACKAGE_NAME

ENV FINAL_JAR_ARTIFACT_NAME=$PACKAGE_NAME.jar
COPY /target/$FINAL_JAR_ARTIFACT_NAME $FINAL_JAR_ARTIFACT_NAME

RUN mkdir -p /home/jboss/extracted
RUN java -Djarmode=tools -jar $FINAL_JAR_ARTIFACT_NAME extract --layers --launcher --destination /home/jboss/extracted && \
    rm -f $FINAL_JAR_ARTIFACT_NAME  && \
    rm -f $project_build_finalName /home/jboss/extracted/application/BOOT-INF/classes/application-default.yml

FROM nexusrepository.bank.com.br:8500/ubi8_custom/openjdk-17-runtime:daily-update as runtime
COPY --from=builder /home/jboss/extracted/dependencies/ ./
COPY --from=builder /home/jboss/extracted/spring-boot-loader/ ./
COPY --from=builder /home/jboss/extracted/snapshot-dependencies/ ./
COPY --from=builder /home/jboss/extracted/application/ ./

ENTRYPOINT exec java $JAVA_OPTS \
    -Djava.security.egd=file:/dev/./urandom \
    -Duser.timezone=America/Sao_Paulo \
    org.springframework.boot.loader.launch.JarLauncher