.PHONY: all clean jar publish release test style coverage
.SILENT:    clean jar publish release test style coverage

.DEFAULT: all

all: clean jar

clean:
	if [ -d "target"          ]; then rm --recursive target;          fi
	if [ -d "project/target"  ]; then rm --recursive project/target;  fi
	if [ -d "project/project" ]; then rm --recursive project/project; fi
	if [ -f "abc.txt"         ]; then rm abc.txt;                     fi
	if [ -f "seektest.txt"    ]; then rm seektest.txt;                fi
	if [ -f "tmp1.out"        ]; then rm tmp1.out;                    fi
	if [ -f "tmp2.out"        ]; then rm tmp2.out;                    fi

jar:
	cs launch --jvm adopt:1.8.0-262 sbt -- javacc assembly

publish:
	cs launch --jvm adopt:1.8.0-262 sbt -- javacc publishSigned

release:
	cs launch --jvm adopt:1.8.0-262 sbt -- sonatypeBundleRelease

test:
	cs launch --jvm adopt:1.8.0-262 sbt -- javacc test

style:
	cs launch --jvm adopt:1.8.0-262 sbt -- scalafix scalafmt javafmt

coverage:
	cs launch --jvm adopt:1.8.0-262 sbt -- "set coverageEnabled := true" test coverageReport

javacc:
	cs launch --jvm adopt:1.8.0-262 sbt -- javacc
