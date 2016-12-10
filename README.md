# hippo-on-spring-boot

**hippo-on-spring-boot**, a demo project to wrap a Hippo project into single JAR executable Spring Boot application.

This project uses [hipshoot Spring Boot Support library](http://hipshoot.forge.onehippo.org/hipshoot-spring-boot-support/index.html)
to wrap a Hippo project into a Spring Boot application package.

In summary,
- This demo project was simply generated by following [Getting Started with Hippo CMS](https://www.onehippo.org/trails/getting-started/hippo-essentials-getting-started.html).
- Simply added some built-in example features using Essentials such as News, Events, etc.
- Added [spring-boot-deploy](spring-boot-deploy/) Maven submodule which lets us wrap Hippo project into single JAR executable Spring Boot application
  by following [hipshoot Spring Boot Support library](http://hipshoot.forge.onehippo.org/hipshoot-spring-boot-support/index.html).
- Added [test.sh](spring-boot-deploy/test.sh) to execute the single executable JAR.
- That's it.

## Build

```bash
    $ mvn clean package
```

## Run

```bash
    $ cd spring-boot-deploy
    $ ./test.sh
```

You can simply type Ctrl-C to stop it.

## Test

Visit [http://localhost:8080/site/](http://localhost:8080/site/) and
[http://localhost:8080/cms/](http://localhost:8080/cms/).
