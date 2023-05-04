#!groovy
import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()
def CORREOS = ""
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

        stage('Ejecutar Pruebas') {
            steps {
                script {
                    try {
                        //bat ("gradle clean test -DRunner=\"${Runner}\" aggregate") //Ejecución en agente Windows con parametro jenkins
                        //sh ("gradle clean test -DRunner=\"${Runner}\" aggregate") //Ejecución en agente Linux con parametro jenkins
                        bat("gradle clean test aggregate") //Ejecución en agente windows sin parametro jenkins
                        echo 'Test Ejecutados sin Fallo'
                        currentBuild.result = 'SUCCESS'
                    }
                    catch (ex) {
                        echo 'Test Ejecutados con Fallo'
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }

        stage('Generar evidencia'){
            steps{
                script{
                    try{
                        bat  " rename \"${WORKSPACE}\\target\" serenity_${timestamp}"
                        echo 'Backup de evidencias realizado con exito'
                        publishHTML([
                                allowMissing: false,
                                alwaysLinkToLastBuild: true,
                                keepAll: true,
                                reportDir: "${WORKSPACE}//serenity_${timestamp}",
                                reportFiles: 'index.html',
                                reportName: 'Evidencias Automatizacion WEB Screenplay',
                                reportTitles: 'Proyecto Mobiletec Screenplay'
                        ])
                        echo 'Reporte Serenity realizado con exito'
                        archiveArtifacts "**/cucumber.json"
                        cucumber '**/cucumber.json'
                        echo 'Reporte Cucumber realizado con exito'
                    }
                    catch(e){
                        echo 'No se realizo el Backup de evidencias'
                        publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}//target/serenity_${timestamp}", reportFiles: 'index.html', reportName: 'Evidencias Automatizacion WEB Screenplay', reportTitles: 'Proyecto Mobiletec Screenplay'])
                        echo 'Reporte Html realizado con exito'
                        currentBuild.result='SUCCESS'
                    }
                }
            }
        }
        stage('Notificar') {
            steps {
                        emailext body: 'Resultado exitoso de pipeline de prueba', subject: 'Resultado automatización', to: '${CORREOS}'
            }
        }
    }

    post {
        always {
            publishTestResults serverAddress: 'https://jessidcordoba.atlassian.net/',
                    projectKey: 'TES',
                    format: 'Cucumber',
                    filePath: 'target/cucumber-reports/*.json',
                    autoCreateTestCases: false,
                    customTestCycle: [
                            name: 'Jenkins Build',
                            description: 'Results from Jenkins Build',
                            jiraProjectVersion: '10001',
                            folderId: '3040527',
                            customFields: '{"number":50,"single-choice":"option1","checkbox":true,"userpicker":"5f8b5cf2ddfdcb0b8d1028bb","single-line":"a text line","datepicker":"2020-01-25","decimal":10.55,"multi-choice":["choice1","choice3"],"multi-line":"first line<br />second line"}'
                    ]
        }
    }
}