compile :
	javac -Xlint -d bin $(shell find src -name "*.java")
	javac -Xlint -d bin -cp bin $(shell find test -name "*.java")

test-TestTaskTitle:	compile
	@java -cp bin -ea system.fields.title.TestTaskTitle

test-TestTaskDate:	compile
	@java -cp bin -ea system.fields.date.TestTaskDate

test-TestTaskFileManager:	compile
	@java -cp bin -ea system.files.TestTaskFileManager

run: compile
	@java -cp bin system.cli.Main
