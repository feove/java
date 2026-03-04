TARGET = tictactoe
SRC_DIR = src
LIB_DIR = lib
JAR_FILE = $(LIB_DIR)/jnativehook-2.2.2.jar
SOURCES = $(wildcard $(SRC_DIR)/*.java)

all: compile run

compile:
	javac -cp "$(JAR_FILE)" -sourcepath $(SRC_DIR) $(SOURCES)

run: compile
	java -cp "$(SRC_DIR):$(JAR_FILE)" TicTacToe

clean:
	rm -f $(SRC_DIR)/*.class

.PHONY: all compile run clean
