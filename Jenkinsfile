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
                script {
                  withKubeConfig([credentialsId: 'kube-cred', serverUrl: ‘http://afd74701301a111eaadd70643358b614-1438923002.us-east-2.elb.amazonaws.com:4000/StudentSurveyForm']) {
                  sh 'kubectl get pods'
                  }
                }
            }
        }
    }
}
