FROM amazoncorretto:17

COPY ./src/main/pragmatic-bongo-410303-399920688d43.json /app/pragmatic-bongo-410303-399920688d43.json

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# 환경 변수로 서비스 계정 키 파일 위치 설정
ENV GOOGLE_APPLICATION_CREDENTIALS=/app/pragmatic-bongo-410303-399920688d43.json

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]
