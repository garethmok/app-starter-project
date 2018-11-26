# Start fresh

# How to use

Clone this project, and from the project directory run:

`fresh_start.sh`

You will be given the option to create a remote repo. Choosing not to will still create the project locally and is therefore useful for spikes.

# About this project

Multi-module dropwizard skeleton application.

This project has only been validated for compatibility up to jdk8u191.

Please note that this project breaks when using:
- openjdk8 - due to a bug with both [openjdk8 and maven-surefire](https://stackoverflow.com/questions/53010200/maven-surefire-could-not-find-forkedbooter-class).
- Java 9/10/11 - this is due to Java 9 no longer having JAXB on the default class path, and also Java 11 has removed JAXB from the JDK. [Info here](https://stackoverflow.com/questions/43574426/how-to-resolve-java-lang-noclassdeffounderror-javax-xml-bind-jaxbexception-in-j).


Upgrade for Java 9/10/11 not yet planned. 
