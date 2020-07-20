find . -name "*.py" -or -name "*.md" -or -name "*.java" -or -name "*.cpp" | xargs grep -v "^$"|wc -l
