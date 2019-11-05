pipeline {
    agent any
    environment {
      app = ""
    }
    stages {
        stage('Clone repository') {
            steps {
              checkout scm
              sh 'jar -cvf StudentSurveyForm.war index.html index.jsp student-survey-form.css' 
            }
        }

        stage('Build image') {
            steps {
              app = docker.build("swattamw/studentsurveyform")
            }
        }
        
        stage('Push image') {
            steps {
              docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                  app.push("${env.BUILD_NUMBER}")
                  app.push("latest")
              } 
           }
        }
    }
}
