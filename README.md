# jpl-podtemplates

Jenkins Pipeline Library for housing pod template yamls

## Usage

* configure shared library in Jenkins
* declare shared library in pipeline
* use yaml in pipeline

**Requires Kubernetes Plugin 1.17+**

### Pipeline - Maven

```groovy
pipeline {
  libraries {
    lib('github.com/joostvdg/jpl-podtemplates@master')
  }
  agent {
    kubernetes {
      defaultContainer 'maven'
      yaml libraryResource('maven-jdk8-cache.yaml')
    }
  }
  stages {
    stage('Version Test') {
      steps {
        sh 'mvn -version'
      }
    }
    stage('Checkout') {
      steps {
        git 'https://github.com/joostvdg/maven-demo-lib.git'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean verify -C -e --show-version'
      }
    }
  }
}
```

### Pipeline - Go

```groovy
pipeline {
  libraries {
    lib('github.com/joostvdg/jpl-podtemplates@master')
  }
  agent {
    kubernetes {
      defaultContainer 'golang'
      yaml libraryResource('go-latest.yaml')
    }
  }
  stages {
    stage('Version Test') {
      steps {
        sh 'go version'
      }
    }
    stage('Checkout') {
      steps {
        git 'https://github.com/joostvdg/cmg.git'
      }
    }
    stage('Build') {
      steps {
        sh 'go get -v'
        sh 'go build'
      }
    }
  }
}
```