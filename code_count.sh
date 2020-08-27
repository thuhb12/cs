find . -name "*.py" -or -name "*.go" -or -name "*.java" -or -name "*.cpp" | xargs grep -v "^$"|wc -l
