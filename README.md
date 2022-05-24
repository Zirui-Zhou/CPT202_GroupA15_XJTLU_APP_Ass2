# XJTLU APP

## Introduction

This project aims at providing various website services for students in the XJTLU, applying Vue for the frontend and Spring Boot for the backend.

## Development Environment

Firstly, installment and configuration of [Git](https://git-scm.com/) is essential to clone the project. Here provides the Git command to close the project.

```
git clone https://github.com/Zirui-Zhou/CPT202_GroupA15_XJTLU_APP_Ass2.git
```

When the clone process completes, the project file structure should be like below.

```
└─xjtluapp-master
    ├─resource
    ├─xjtluapp-java
    ├─xjtluapp-python
    └─xjtluapp-vue
```

The project can be separated into two parts generally. The `xjtluapp-java` provides the Spring Boot based backend system. The `xjtluapp-vue` provides the Vue based frontend system. The two systems should be initiated and run respectively.

### Frontend System

Because the frontend project is based on Vue, it is recommended to run this in IDE, such as WebStorm, which will provide more relative dependencies and simplify the operations. Firstly, [NodeJS](https://nodejs.org/) is required to build the basic environment at the very beginning. After installment of NodeJS, Vue should be installed by one package manager. Here recommends `npm` as the package manager and provides the command below.

```
npm install vue
```

Vue CLI is also required to launch and pack the project.

```
npm install -g @vue/cli
```

Then, the dependencies of the project should be installed. The command provided below should be run in the `xjtluapp-vue` folder.

```
npm install
```

For now, all the environment of the frontend project is installed. The development environment can be launched by the script below in the `xjtluapp-vue` folder.

```
npm run serve
```

### Backend System

Because the backend system is based on Spring Boot, it is recommended to run this in IDE, such as IntelliJ, which will provide more relative dependencies and simplify the operations.

This project selects Java JDK 17 as SDK. The JDK should be downloaded and configurated at the very beginning. Then, the Spring Boot dependency should be installed by Maven. Thus, Maven should be downloaded and configured as well. 

For now, all the environment of the backend project is installed. The dependency of the project can be installed by the command below which should be run in the `xjtluapp-java` folder.

```
mvn install
```

Then, the project can be launched by the command below.

```
mvn spring-boot:run
```

## Deployment Environment

The project should be run correctly in development environment before deployment. Here uses the recommended FTP tool FileZilla to upload files.

### Frontend System

It is recommended to apply Tomcat to deploy the frontend system. Firstly, Tomcat should be downloaded and installed in the remote server. Then, the project should be built with the command below, which should run in the `xjtluapp-vue` folder.

```
npm run build
```

Then, upload the files and folders in the default folder `dist` to the remote server. The target folder `ROOT` structure is shown below.

```
└─Apache Software Foundation
    └─Tomcat 10.0
        └─webapps
            └─ROOT
```

The target IP and port are provided by Tomcat, which can be configured in the properties.

### Backend System

Firstly, Java 17 should be downloaded and installed in the remote server. Then, the project should be compiled with the command below, which should run in the `xjtluapp-java` folder.

```
mvn clean compile package -Dmave.text.skip=true
```

The jar package such as `xjtluapp-0.0.1-SNAPSHOT.jar` should be upload to the remote server. The package can run by the command below.

```
java -jar ./xjtluapp-0.0.1-SNAPSHOT.jar
```

It needs to mention that the relative path should be correct.

### Database

The database can be deployed in the current remote server. This project is depended on MySQL. Thus, the server-version MySQL is required to install and deploy. Then, the database connector should be edited in `application.yml` in Java package. The SQL structure file is included in the Java folder.
