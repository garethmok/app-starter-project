#!/bin/bash

read -p "Enter the new project's name: " projectName

cd ~/workspace
cp -r ./app-starter-project ./$projectName

# Remove the starter script from the new project
rm $projectName/$0

# Real meat of the work here
cd $projectName
sed -i s/app-starter-project/$projectName/g pom.xml
sed -i s/app-starter-project/$projectName/g config.yml
sed -i s/app-starter-project/$projectName/g ./framework/pom.xml
sed -i s/app-starter-project/$projectName/g ./framework/src/main/java/uk/co/garethmok/MainApplication.java
sed -i s/app-starter-project/$projectName/g ./framework/src/main/resources/banner.txt

# Replace README content with just project name

echo $projectName > README.md
