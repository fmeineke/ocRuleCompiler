# ocRuleCompiler README #

This README documents what is necessary to get application up and running.

## What is this repository for? ##
* The ocRuleCompiler is a small java app for facilitating generation of Rules for OpenClinica/LibreClinica CDISC-ODM management (e.g. generating rules.xml from CRF description).

## Workflow ##
* Create a CRF and add Items and Rules to the respective sheets.
* More information for specifying rules can be found at <a href="https://docs.openclinica.com/3-1/rules/">OpenClinica Docs</a>
* Upload CRF to your OpenClinica/LibreClinica (Tasks -> Build Study -> in column Create CRF click the "+" -> upload the .xls).
* Get the generated OIDs and add them to the Excel file.
* Generate your rules.xml with the ocRuleCompiler.
* Upload the rules to OpenClinica/LibreClinica (Tasks -> Build Study -> in column Create Rules click the "+" -> upload the rules.xml).

## Notes ##
* Standard encoding is `ISO-8859-1` which supports Ä,Ö,Ü and other special characters.
* You can encode the rules.xml in UTF-8 if you add `-utf` at the end of the command.
* With UTF-8 encoding, umlauts are not shown properly in OpenClinica/LibreClinica.
* Need help with the CRF.xls? Under src/test/resources you can find an example.

## How do I set it up? ##
* For the easy setup download the latest release (.jar).
* Navigate with your terminal into the directory with the .jar file.
* Run `java -jar ocRuleCompiler2-2-shaded.jar /path/to/your/CRF.xls` to generate the rules.xml.

## Want to compile it yourself? ##
* You need git, maven and java >= 1.8.
* `git clone https://fmeineke@github.com/fmeineke/ocRuleCompiler.git`
* `cd ocRuleCompiler`
* `mvn clean package -Dmaven.test.skip=true` will build target/ocRuleCompiler.jar and copy dependencies to target/lib.
* Start the batch shell with `java -jar target/ocRuleCompiler-2.0.jar`.

## Contribution guidelines ##

* No contribution besides reports to my E-Mail

## Who do I talk to? ##

* Contact: frank.meineke@imise.uni-leipzig.de
