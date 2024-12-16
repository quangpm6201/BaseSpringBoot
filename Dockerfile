FROM openjdk:17-jdk-alpine
ADD target/BaseProject-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar", "-Dtrust_all_cert=true", "-Duser.timezone=Asia/Ho_Chi_Minh", "-Doracle.jdbc.timezoneAsRegion=false","app.jar"]
#ENTRYPOINT ["java","-jar", "app.jar"]
