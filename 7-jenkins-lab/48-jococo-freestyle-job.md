Steps:

Manage Jenkins -> Manage Plugins -> Install "JaCoCo plugin"

Visit: https://github.com/rchidana/JacocoExample and click on fork

Jenkins Job: 

New Item -> Enter an item name -> jacoco-freestyle-job -> Freestyle Project -> ok

Source Code Management -> Git -> https://github.com/xavyaly/JacocoExample.git

Branches to build -> Branch Specifier (blank for 'any') -> */master

Build -> Invoke top level maven targets -> Maven Version (mvn) + Goals (package)

Post-build Actions -> Record Jacoco Coverage report -> Leave as it or else customize as per requirement

Save -> Build Now

Analysis: JaCoCo Coverage Trend

O/P:
Started by user xavyaly
Running as SYSTEM
Building on the built-in node in workspace /var/lib/jenkins/workspace/jacoco-freestyle-job-1
[WS-CLEANUP] Deleting project workspace...
[WS-CLEANUP] Deferred wipeout is used...
The recommended git tool is: NONE
No credentials specified
Cloning the remote Git repository
Cloning repository https://github.com/xavyaly/JacocoExample.git
 > git init /var/lib/jenkins/workspace/jacoco-freestyle-job-1 # timeout=10
Fetching upstream changes from https://github.com/xavyaly/JacocoExample.git
 > git --version # timeout=10
 > git --version # 'git version 2.7.4'
 > git fetch --tags --progress https://github.com/xavyaly/JacocoExample.git +refs/heads/*:refs/remotes/origin/* # timeout=10
 > git config remote.origin.url https://github.com/xavyaly/JacocoExample.git # timeout=10
 > git config --add remote.origin.fetch +refs/heads/*:refs/remotes/origin/* # timeout=10
Avoid second fetch
 > git rev-parse refs/remotes/origin/master^{commit} # timeout=10
Checking out Revision 8d0bce8e8c565b4811f3c18e574d7ef2d6522eef (refs/remotes/origin/master)
 > git config core.sparsecheckout # timeout=10
 > git checkout -f 8d0bce8e8c565b4811f3c18e574d7ef2d6522eef # timeout=10
Commit message: "Fixing Palindrome logic"
First time build. Skipping changelog.
[jacoco-freestyle-job-1] $ /opt/maven/bin/mvn package
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< com.training.example:JacocoExample >-----------------
[INFO] Building JacocoExample 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- jacoco-maven-plugin:0.7.7.201606060606:prepare-agent (default) @ JacocoExample ---
[WARNING] The artifact xml-apis:xml-apis:jar:2.0.2 has been relocated to xml-apis:xml-apis:jar:1.0.b2
[INFO] argLine set to -javaagent:/var/lib/jenkins/.m2/repository/org/jacoco/org.jacoco.agent/0.7.7.201606060606/org.jacoco.agent-0.7.7.201606060606-runtime.jar=destfile=/var/lib/jenkins/workspace/jacoco-freestyle-job-1/target/jacoco.exec
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ JacocoExample ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /var/lib/jenkins/workspace/jacoco-freestyle-job-1/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ JacocoExample ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /var/lib/jenkins/workspace/jacoco-freestyle-job-1/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ JacocoExample ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /var/lib/jenkins/workspace/jacoco-freestyle-job-1/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ JacocoExample ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /var/lib/jenkins/workspace/jacoco-freestyle-job-1/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ JacocoExample ---
[INFO] Surefire report directory: /var/lib/jenkins/workspace/jacoco-freestyle-job-1/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.training.example.JacocoExample.PalindromeTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.273 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- jacoco-maven-plugin:0.7.7.201606060606:report (report) @ JacocoExample ---
[INFO] Loading execution data file /var/lib/jenkins/workspace/jacoco-freestyle-job-1/target/jacoco.exec
[INFO] Analyzed bundle 'JacocoExample' with 1 classes
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ JacocoExample ---
[INFO] Building jar: /var/lib/jenkins/workspace/jacoco-freestyle-job-1/target/JacocoExample-0.0.1-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  7.039 s
[INFO] Finished at: 2021-11-06T01:09:26Z
[INFO] ------------------------------------------------------------------------
[JaCoCo plugin] Collecting JaCoCo coverage data...
[JaCoCo plugin] **/**.exec;**/classes;**/src/main/java; locations are configured
[JaCoCo plugin] Number of found exec files for pattern **/**.exec: 1
[JaCoCo plugin] Saving matched execfiles:  /var/lib/jenkins/workspace/jacoco-freestyle-job-1/target/jacoco.exec
[JaCoCo plugin] Saving matched class directories for class-pattern: **/classes: 
[JaCoCo plugin]  - /var/lib/jenkins/workspace/jacoco-freestyle-job-1/target/classes 1 files
[JaCoCo plugin] Saving matched source directories for source-pattern: **/src/main/java: 
[JaCoCo plugin] Source Inclusions: **/*.java,**/*.groovy,**/*.kt,**/*.kts
[JaCoCo plugin] Source Exclusions: 
[JaCoCo plugin] - /var/lib/jenkins/workspace/jacoco-freestyle-job-1/src/main/java 1 files
[JaCoCo plugin] Loading inclusions files..
[JaCoCo plugin] inclusions: []
[JaCoCo plugin] exclusions: []
[JaCoCo plugin] Thresholds: JacocoHealthReportThresholds [minClass=0, maxClass=0, minMethod=0, maxMethod=0, minLine=0, maxLine=0, minBranch=0, maxBranch=0, minInstruction=0, maxInstruction=0, minComplexity=0, maxComplexity=0]
[JaCoCo plugin] Publishing the results..
[JaCoCo plugin] Loading packages..
[JaCoCo plugin] Done.
[JaCoCo plugin] Overall coverage: class: 100.0, method: 100.0, line: 30.000002, branch: 16.666668, instruction: 20.0, complexity: 40.0
Finished: SUCCESS

