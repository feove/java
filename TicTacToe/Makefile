TARGET = tictactoe
SRC_DIR = src
LIB_DIR = lib
LANTERNA_JAR = $(LIB_DIR)/lanterna-3.1.2.jar
SOURCES = $(wildcard $(SRC_DIR)/*.java)

all: compile

compile:
	javac -cp "$(LANTERNA_JAR)" -sourcepath $(SRC_DIR) $(SOURCES)

run:
	java -cp "$(SRC_DIR):$(LANTERNA_JAR)" TicTacToe

clean:
	rm -f $(SRC_DIR)/*.class

.PHONY: all compile run clean
