pipeline {
    agent any
    environment {
      app = ""
    }
    stages {
        stage('Clone repository') {
            steps {
              sh 'java -version'
              sh '/usr/bin/jar -cvf StudentSurveyForm.war index.html index.jsp student-survey-form.css' 
            }
        }

        stage('Build image') {
            steps {
                script {
                    app = docker.build("swattamw/studentsurveyform")
                }
            }
        }
        
        stage('Push image') {
            steps {
                script {
                  docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                  app.push("${env.BUILD_NUMBER}")
                  app.push("latest")
                }
              } 
           }
        }
        
        stage('Pods') {
            steps {
              sh 'kubectl get pods'
            }
        }
    }
}
