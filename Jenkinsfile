node {
  stage 'Build and Test'
  env.PATH = "${tool 'Maven'}/bin:${env.PATH}"
  sh 'mvn clean package'
}

