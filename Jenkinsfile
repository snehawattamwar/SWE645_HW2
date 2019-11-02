node {
    def app

    stage('Clone repository') {
        checkout scm
        sh 'jar -cvf StudentSurveyForm.war /SWE645_HW2/StudentSurveyForm/WebContent/index.html /SWE645_HW2/StudentSurveyForm/WebContent/index.jsp /SWE645_HW2/StudentSurveyForm/WebContent/student-survey-form.css'
    }

    stage('Build image') {
        app = docker.build("swattamw/studentsurveyform")
    }

    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}
