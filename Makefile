##
# source directory
##
SRC_DIR := ./src

##
# output directory
##
OUT_DIR := ./bin

##
# sources
##
SRCS := $(wildcard $(SRC_DIR)/*.java) \
        $(wildcard $(SRC_DIR)/View/*.java) \
        $(wildcard $(SRC_DIR)/Model/*.java) \
        $(wildcard $(SRC_DIR)/Controller/*.java)

##
# classes
##
CLS := $(SRCS:$(SRC_DIR)/%.java=$(OUT_DIR)/%.class)
CLS := $(subst $(SRC_DIR)/View,$(OUT_DIR)/View,$(CLS))
CLS := $(subst $(SRC_DIR)/Model,$(OUT_DIR)/Model,$(CLS))
CLS := $(subst $(SRC_DIR)/Controller,$(OUT_DIR)/Controller,$(CLS))

##
# compiler and compiler flags
##
JC := javac
JCFLAGS := -d $(OUT_DIR)/ -cp $(SRC_DIR)/ -sourcepath $(SRC_DIR) -Xlint:-deprecation

##
# suffixes
##
.SUFFIXES: .java

##
# targets that do not produce output files
##
.PHONY: all clean

##
# default target(s)
##
all: $(CLS)

$(CLS): $(OUT_DIR)/%.class: $(SRC_DIR)/%.java
	$(JC) $(JCFLAGS) $<

##
# clean up any output files
##
clean:
	rm $(OUT_DIR)/*.class
	rm $(OUT_DIR)/View/*.class
	rm $(OUT_DIR)/Model/*.class
	rm $(OUT_DIR)/Controller/*.class

run:
	java -classpath ./bin Main

