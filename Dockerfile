FROM openjdk:11.0.11-jre
ENV TZ=Asia/Baku
RUN mkdir -p /app
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/in-atb.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","in-atb.jar"]
