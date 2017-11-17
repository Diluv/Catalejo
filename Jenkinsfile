node {
    stage("checkout") {
        git branch: 'development', url: 'https://github.com/Diluv/Catalejo'
    }

    stage("build") {
        sh './gradlew clean build'
    }

    stage("deploy") {
        sh './gradlew uploadArchives'
    }
}