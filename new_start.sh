#!/bin/bash

read -p "Enter the new project's name: " projectName

cd ~/workspace
cp -r ./app-starter-project ./$projectName

# Clean up the new project
# 1. Remove the starter script from the new project
# 2. Prep for creating remote git repo
rm ./$projectName/$0
rm -rf ./.git

# Real meat of the work here
cd $projectName

sedInstruction=s/app-starter-project/$projectName/g
sed -i $sedInstruction pom.xml
sed -i $sedInstruction config.yml
sed -i $sedInstruction ./framework/pom.xml
sed -i $sedInstruction ./framework/src/main/java/uk/co/garethmok/MainApplication.java
sed -i $sedInstruction ./framework/src/main/resources/banner.txt

# Replace README content with just project name
echo $projectName > README.md

# Local part done
echo "Finished generating project: '$projectName'."

# Decide whether to create repo on GitHub
while true; do
  read -p "Do you want to create this repo on GitHub [y/n]? " yn
  
  case $yn in
    [Yy])
      curl -u 'garethmok' https://api.github.com/user/repos -d "{\"name\":\"$projectName\"}"

      if [ $? -eq 0 ]
      then
        rm -rf ./.git
        git init
        git remote add origin https://github.com/garethmok/$projectName.git
        git add --all
        git commit -m"Creates the new project. Initial commit."
        git push -u origin master
      fi
  
      echo "Remote repo created: https://github.com/garethmok/$projectName"
      ;;
    [Nn])
      echo "Remote repo not created."
      break
      ;;
    *)
      echo "Invalid input." >&2
      ;;
  esac
done

