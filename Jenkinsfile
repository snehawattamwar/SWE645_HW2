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
                withKubeConfig([credentialsId: 'kube-cred', serverUrl: 'https://BCF949B28BDCE2D73533306C496AB5BA.yl4.us-east-2.eks.amazonaws.com']) {
                  sh 'kubectl set image deployments/surveyapp surveyapp=swattamw/studentsurveyform:latest'
                } 
             }
         }
    }
}
