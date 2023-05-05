#!groovy
import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()
def CORREOS = "fzapataa@choucairtesting.com"
def urlRepo=""
def rama="master"
def credenciales=""

pipeline {
    agent any
    stages {
        stage('Preparar Workspace'){
            steps{
                script{
                    env.WORKSPACE_LOCAL = bat(returnStdout: true, script: 'cd').trim()
                    env.BUILD_TIME = bat(returnStdout: true, script: 'date +/F-/T').trim()
                    echo "Workspace set to:" + env.WORKSPACE_LOCAL
                    echo "Build time:" + env.BUILD_TIME
                }
            }
        }
        stage('Obtener Fuentes'){
            steps {
                checkout([$class: 'GitSCM', branches: [[name: rama]],
                          wdoGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [
                        [credentialsId: credenciales, url: 'https://github.com/Zapataarango/DemoblazeTest.git']]])
            }
        }

     //   stage('Ejecutar Pruebas') {
     //       steps {
     //           script {
     //               try {
     //                   //bat ("gradle clean test -DRunner=\"${Runner}\" aggregate") //Ejecución en agente Windows con parametro jenkins
     //                   //sh ("gradle clean test -DRunner=\"${Runner}\" aggregate") //Ejecución en agente Linux con parametro jenkins
     //                   bat("gradle clean test aggregate") //Ejecución en agente windows sin parametro jenkins
     //                   echo 'Test Ejecutados sin Fallo'
     //                   currentBuild.result = 'SUCCESS'
     //               }
     //               catch (ex) {
     //                   echo 'Test Ejecutados con Fallo'
     //                   currentBuild.result = 'UNSTABLE'
     //               }
     //           }
     //       }
     //   }
//
     //   stage('Generar evidencia'){
     //       steps{
     //           script{
     //               try{
     //                   bat  " rename \"${WORKSPACE}\\target\" serenity_${timestamp}"
     //                   echo 'Backup de evidencias realizado con exito'
     //                   publishHTML([
     //                           allowMissing: false,
     //                           alwaysLinkToLastBuild: true,
     //                           keepAll: true,
     //                           reportDir: "${WORKSPACE}//serenity_${timestamp}",
     //                           reportFiles: 'index.html',
     //                           reportName: 'Evidencias Automatizacion WEB Screenplay',
     //                           reportTitles: 'Proyecto Mobiletec Screenplay'
     //                   ])
     //                   echo 'Reporte Serenity realizado con exito'
     //                   archiveArtifacts "**/cucumber.json"
     //                   cucumber '**/cucumber.json'
     //                   echo 'Reporte Cucumber realizado con exito'
     //               }
     //               catch(e){
     //                   echo 'No se realizo el Backup de evidencias'
     //                   publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}//target/serenity_${timestamp}", reportFiles: 'index.html', reportName: 'Evidencias Automatizacion WEB Screenplay', reportTitles: 'Proyecto Mobiletec Screenplay'])
     //                   echo 'Reporte Html realizado con exito'
     //                   currentBuild.result='SUCCESS'
     //               }
     //           }
     //       }
     //   }
        stage('Notificar') {
            steps {
                script {
                    if (currentBuild.result == 'UNSTABLE')
                        currentBuild.result = 'FAILURE'

                    if (currentBuild.result == 'SUCCESS')
                        emailext(
                                subject: "FRM SCREENPLAY - EJECUCION EXITOSA ESCENARIOS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                                body: """<p><b style="color:MediumSeaGreen;">EJECUCION EXITOSA:</b> Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
            				<p><b>Para verificar el estado de la ejecucion ingrese a:</b> &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
                                to: "${CORREOS}"
                        )
                    if (currentBuild.result == 'FAILURE')
                        emailext(
                                subject: "FRM SCREENPLAY - EJECUCION FALLIDA ESCENARIOS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                                body: """<p><b style="color:red;">EJECUCION FALLIDA:</b> Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
            				<p><b>Para verificar el estado de la ejecucion ingrese a:</b> &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
                                to: "${CORREOS}"
                        )
                }
            }
        }
    }
}