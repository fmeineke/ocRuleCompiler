# ocRuleCompiler README #

This README documents what is necessary to get application up and running.

## What is this repository for? ##
* The ocRulecCompler is a small java app for faciliating generation of Rules for OpenClinicaCDISC-ODM management (e.g. generating rules.xml from CRF descptioption)
* Note: most of the (junit) test code is not in the repository

## How do I set it up? ##
* you need git, maven and java >= 1.8
* `git clone https://fmeineke@github.com/fmeineke/ocRuleCompiler.git`
* `cd ocRuleCompiler`
* `mvn clean package -Dmaven.test.skip=true` will build target/ocRuleCompiler.jar and copy dependencies to target/lib
* start the batch shell with `java -jar target/ocRuleCompiler-1.0.jar`

## Contribution guidelines ##

* no contribution besides reports to my E-Mail

## Who do I talk to? ##

* contact: frank.meineke@imise.uni-leipzig.de