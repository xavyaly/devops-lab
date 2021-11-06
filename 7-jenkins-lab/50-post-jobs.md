/*post will execute after the completion of pipeline's stages section contains the following blocks*/
/*
POST:-
    Always
    Changed
    Fixed
    Regression
    Aborted 
    Failure
    Success

POST Block Continue:-
    Unstable
    Unsuccessful
    Cleanup

Post stage and stages level:-
    Always : Runs always, wont depend upon the build result
    changed: Runs only if current build status is changed when compare to previous
    Fixed: current status is success and previous status is failed
    Regression: if current status is fail/unstable/aborted and previous run is successful.
    Aborted: if the current status is aborted
    Failure : Runs only if the current build status is failed.
    Success : current build is success
    Unstable : current build is unstable
    cleanup : like always, will execute at every time in the last ( if you want to delete any workspace and cleaup any folder , we can use this)
*/


