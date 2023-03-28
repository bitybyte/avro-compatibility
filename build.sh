# Build the java project. This outputs the JS files into
# {project-root}/docs/assets/js/
PROJECT_DIR=${PWD}
cd src/java/avro-compatibility-tool
mvn clean package

# Add the class files to the repository for deployment
cd $PROJECT_DIR
cp -r src/java/avro-compatibility-tool/target/generated/js/ docs/assets/js/
git add docs/assets/js/classes.js*
