
pipeline{
  agent{
      label 'slave'
  }
  environment{
      TOMCAT_SERVER = '#IP'
      TOMCAT_USER = '#user'
  }
  stages{
      stage('checkout'){
        steps{
          #git_url
        }
      }
    stage('build'){
      steps{
        sh 'mvn clean compile'
      }
    }
    stage('test'){
      steps{
        sh 'mvn test'
      }
    }
    stage('code quality'){
      steps{
        #sonar_command
      }
    }
    stage('artifact'){
      steps{
        sh 'mvn install'
      }
    }
    stage('deploy'){
      steps{
        sshagent(['#tomcat-cred']){
          sh """
            scp ${WORKSPACE}/target/war-file_name ${TOMCAAT_USER}@{TOMCAT_SERVER}/opt/tomcat/webapps/
            ssh ${TOMCAT_USER}@{TOMCAT_SERVER} '/opt/bin/shutdown.sh' || true && '/opt/bin/statup.sh'
          """
        }
      }
    }
  }
  post {
        success {
            emailext(
                subject: "BUILD SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Build and deployment succeeded!\n\nJob: ${env.JOB_NAME}\nBuild: ${env.BUILD_NUMBER}\nSee console output: ${env.BUILD_URL}console",
                to: "kumarpavan800855@gmail.com"
            )
        }

        failure {
            emailext(
                subject: "BUILD FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Build or deployment failed!\n\nJob: ${env.JOB_NAME}\nBuild: ${env.BUILD_NUMBER}\nSee console output: ${env.BUILD_URL}console",
                to: "kumarpavan800855@gmail.com",
                attachLog: true
            )
        }
    }

}
