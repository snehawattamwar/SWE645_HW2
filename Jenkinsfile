node {
    def app
    environment {
    registry = "swattamw/studentsurveyform"
    registryCredential = ‘dockerhub’
    }
    stage('Clone repository') {
        checkout scm
        sh 'jar -cvf StudentSurveyForm.war index.html index.jsp student-survey-form.css'
    }

    stage('Build image') {
        app = docker.build registry
    }

    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}
