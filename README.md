# automation-homework
First attempt at a proper Selenium/Intellij project on GitHub. 

This README will lay out the steps to create a Selenium project in IntelliJ and set it up on GitHub.

----
## How to setup an automation project in GitHub

#### Pre-requisites:
* Computer must be set up to work in IntelliJ
* Computer must be set up to work in GitHub
* User must have some knowledge of Command Line
* User must be able to create Automation projects with IntelliJ

#### Steps:
1. Create project in IntelliJ
2. Create repository in GitHub
3. Transfer working IntelliJ package into GitHub via Command Line
    * Open Terminal.
    * Change the current working directory to your local project.
    * Initialize the local directory as a Git repository.
      * ######$ git init
    * Add the files in your new local repository. This stages them for the first commit.
      * ######$ git add .
        * *Adds the files in the local repository and stages them for commit. To unstage a file, use 'git reset HEAD YOUR-FILE'.*
    * Commit the files that you've staged in your local repository.
        * ######$ git commit -a -m "First commit"
            * *Commits the tracked changes and prepares them to be pushed to a remote repository. To remove this commit and modify the file, use 'git reset --soft HEAD~1' and commit and add the file again.*
    * In Terminal, add the URL for the remote repository where your local repository will be pushed.
        * ######$ git remote add origin *[remote repository URL]*
            * *Sets the new remote*
        * ######$ git remote -v
            * *Verifies the new remote URL*
    * Push the changes in your local repository to GitHub.
        * ######$ git push -u origin master
            * *Pushes the changes in your local repository up to the remote repository you specified as the origin*


##Branches:
* master
* homework/erica      


## Useful Terminal Commands:
* ######$ git checkout master
    * *changes branch to master*
* ######$ git checkout -b [name_of_your_new_branch]
    * *creates and switches to new branch*
* ######$ git checkout [name_of_your_branch]
    * *changes to your branch*
* ######$ git pull
    * *pulls from current branch*
* ######$ git push
    * *pushes to current branch*
* ######$ git add .
    * *stages all files for commit*
* ######$ git commit -a -m "your comment goes here"
    * *commits changes with a comment*
* ######$ git merge master
    * *merges pulled code from master to current branch*

