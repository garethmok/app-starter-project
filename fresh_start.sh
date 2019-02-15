#!/bin/bash

read -p "Enter the new project's name: " projectName

echo "[INFO] Generating '$projectName'."
cd ..
cp -r ./app-starter-project ./$projectName

# Clean up the new project
# 1. Remove the starter script from the new project
# 2. Remove .idea if it exists
# 3. Prep for creating remote git repo
echo "[INFO] - Performing some clean up."
rm ./$projectName/$0
rm -rf ./$projectName/.idea
rm -rf ./$projectName/.git

# Real meat of the work here
cd $projectName

echo "[INFO] - Configuring '$projectName' contents."
sedInstruction=s/app-starter-project/$projectName/g
sed -i $sedInstruction pom.xml
sed -i $sedInstruction config.yml
sed -i $sedInstruction ./application/pom.xml
sed -i $sedInstruction ./framework/pom.xml
sed -i $sedInstruction ./framework/src/main/java/uk/co/garethmok/MainApplication.java
sed -i $sedInstruction ./framework/src/main/resources/banner.txt

# Replace README content with just project name
echo "# $projectName" > README.md

# Local part done
echo ""
echo "[INFO] Finished generating project: '$projectName'."

# Decide whether to create repo on GitHub
read -p "Do you want to create this repo on GitHub [y/n]? " yn

echo "[INFO] Requesting creation of remote repo..."
while true; do
  case $yn in
    [Yy])
      repoCreatedResult=$(curl -u 'garethmok' https://api.github.com/user/repos -d "{\"name\":\"$projectName\"}")
 
      if [[ $repoCreatedResult == *"Bad credentials"* ]]
      then
        echo "[ERROR] Failed to authenticate. Try again..." >&2
        continue
      else
        echo "[INFO] Configuring git repo..."
        git init
        git remote add origin git@github.com:garethmok/$projectName.git

        echo "[INFO] Finished configuring git. Making first push to '$projectName'"
        echo ""
        git add --all
        git commit -m"Creates the new project. Initial commit."
        git push -u origin master
      fi

      echo ""
      echo "[INFO] ====================================================================="
      echo "[INFO] Remote repo created: https://github.com/garethmok/$projectName"
      echo "[INFO] '$projectName' successfully generated."
      echo "[INFO] ====================================================================="

      break
      ;;
    [Nn])
      echo "[INFO] ====================================================================="
      echo "[INFO] Remote repo not created."
      echo "[INFO] '$projectName' successfully generated."
      echo "[INFO] ====================================================================="
      break
      ;;
    *)
      echo "[ERROR] Invalid input." >&2
      ;;
  esac
done

