ARG MSVC_NAME=msvc-cursos

FROM openjdk:17-alpine as builder

WORKDIR /app/msvc-cursos
ARG MSVC_NAME
COPY ./pom.xml /app
COPY ./$MSVC_NAME/.mvn .mvn
COPY ./$MSVC_NAME/mvnw .
COPY ./$MSVC_NAME/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target
# OTRA OPCION:
#RUN ./mvnw dependency:go-offline
COPY ./$MSVC_NAME/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-alpine

WORKDIR /app
ARG MSVC_NAME
ARG TARGET_FOLDER=/app/$MSVC_NAME/target
RUN mkdir ./logs

COPY --from=builder $TARGET_FOLDER/msvc-cursos-0.0.1-SNAPSHOT.jar .

#CREANDO VARIABLE DE ENTORNO PARA EL PUERTO INTERNO DE DOCKER
ARG PORT_APP=8002
ENV PORT $PORT_APP
EXPOSE $PORT

#Entrypoint es inmutable siempre se correra ese punto de entra de la aplicacion
#ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]

#CMD es mutable se puede sobrescribrir el comando desde la consola con el punto de entrada
CMD ["java", "-jar", "msvc-cursos-0.0.1-SNAPSHOT.jar"]