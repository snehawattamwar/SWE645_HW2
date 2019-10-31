#Name- Sneha Wattamwar
#G#- G01209653
#Dockerfile to create docker image that uploads war file in tomcat web apps and makes it available on port 8080

FROM tomcat
MAINTAINER snehawattamwar
ADD StudentSurveyForm.war /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh", "run"]