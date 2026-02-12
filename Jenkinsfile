
pipeline {
   agent any

   stages {
        stage('test') {
        steps {
            bat 'mvn test'
            junit 'target/surefire-reports/*.xml'

            cucumber reportTitle : 'API Report',
            fileIncludePattern: 'target/exemple-report.json'



    recordCoverage(tools: [[parser: 'JACOCO']],
            id: 'jacoco', name: 'JaCoCo Coverage',
            sourceCodeRetention: 'EVERY_BUILD',
            qualityGates: [
                    [threshold: 80.0, metric: 'LINE', baseline: 'PROJECT', unstable: true],
                    [threshold: 80.0, metric: 'BRANCH', baseline: 'PROJECT', unstable: true]])
}

}

         stage('Documentation') {
                      steps {
                          bat 'mvn javadoc:javadoc'
                      }
                      post {
                       always {
                                     publishHTML(target: [
                                         allowMissing: false,
                                         alwaysLinkToLastBuild: true,
                                         keepAll: true,
                                         reportDir: 'target/site/',
                                         reportFiles: 'index.html',
                                         reportName: 'Documentation'
                                     ])
                       }
                      }
                 }

             stage('Build') {
                     steps {
                         bat 'mvn package'
                         archiveArtifacts artifacts: 'target/*.jar'
                     }
                 }
            stage('myMavenDeploy') {
                 steps {
                     bat 'mvn deploy'
                 }
             }

stage('slack') {
/*    steps {
        powershell """
        \$body = @{
            text = "deploy completed succesfully!"
        } | ConvertTo-Json

        Invoke-RestMethod -Uri "${slackUrl}" `
                          -Method Post `
                          -ContentType "application/json" `
                          -Body \$body
        """
    }   */

    steps {
        bat """
        curl -X POST ^
             -H "Content-Type: application/json" ^
             -d "{\\"text\\":\\"deploy completed succesfully!\\"}" ^
             ${slackUrl}
        """
    }
}
stage('release') {

      steps {
        bat """
        curl -X POST https://api.github.com/repos/ccamal028-pixel/esiMatrixApi/releases \
          -H "Authorization: Bearer ${git_bearer}" \
          -H "Accept: application/vnd.github+json" \
          -H "Content-Type: application/json" \
          -d '{
            "tag_name": "v2.0",
            "name": "Release v2.0",
            "body": "Production release",
            "draft": false,
            "prerelease": false
          }'

        """
    }

}

             }
}
