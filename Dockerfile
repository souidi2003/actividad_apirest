FROM openjdk:17
WORKDIR /
COPY actividad_apirest.jar actividad_apirest.jar
EXPOSE 9069
CMD ["java", "-jar", "actividad_apirest.jar"]


