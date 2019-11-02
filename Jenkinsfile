node {
    def app

    stage('Clone repository') {
        checkout scm
        sh 'jar -cvf StudentSurveyForm.war index.html index.jsp student-survey-form.css'
    }

    stage('Build image') {
        sh 'sudo yum install docker-engine -y'
        app = docker.build("swattamw/studentsurveyform")
    }

    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}
