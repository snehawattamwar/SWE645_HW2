node {
    def app
    stage('Clone repository') {
        checkout scm
        sh 'jar -cvf StudentSurveyForm.war index.html index.jsp student-survey-form.css'
    }

    stage('Build image') {
        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
        app = docker.build("swattamw/studentsurveyform")
        }
    }

    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
    
    stage('Pods') {
        withKubeConfig([credentialsId: 'kube-cred', serverUrl: 'http://a0e80e050fdcf11e9a4fa024f1795ae0-294861629.us-east-2.elb.amazonaws.com:4000/StudentSurveyForm/']) {
            sh 'kubectl apply --filename surveyform.yaml'
        }
    }
}
