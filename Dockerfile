FROM amazoncorretto:17

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# 환경 변수로 서비스 계정 키 파일 위치 설정 (시크릿 마운트 경로로 업데이트)
ENV GOOGLE_APPLICATION_CREDENTIALS=/run/secrets/service_account_key
ENV FIREBASE_KEY=/run/secrets/service_account_key2

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]
