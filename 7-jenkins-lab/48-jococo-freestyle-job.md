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


