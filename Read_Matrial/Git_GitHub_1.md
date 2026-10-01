# Git & GitHub: Complete Guide for Exams and Technical Interviews

> **Structure:** Basic → Intermediate → Advanced → Real-World Workflow → Interview Questions
> Every command includes **what it does**, a **use case**, and an **example**.
> ⚠️ marks commands that can lose work. 🎯 marks frequent interview points.

---

## 📑 Table of Contents

1. [Part 1: Basic Concepts](#part-1--basic-git-concepts)
2. [Part 2: Git Architecture](#part-2--git-architecture)
3. [Part 3: Basic Git Commands](#part-3--basic-git-commands)
4. [Part 4: git add Commands](#part-4--git-add-commands)
5. [Part 5: Commit](#part-5--commit)
6. [Part 6: Branches](#part-6--branches)
7. [Part 7: Log](#part-7--git-log)
8. [Part 8: Diff](#part-8--git-diff)
9. [Part 9: Checkout / Switch / Detached HEAD](#part-9--checkout--switch)
10. [Part 10: Merge](#part-10--merge)
11. [Part 11: Merge Conflict](#part-11--merge-conflict)
12. [Part 12: Remote Repositories](#part-12--remote-repositories)
13. [Part 13: Push](#part-13--git-push)
14. [Part 14: Fetch vs Pull](#part-14--fetch-vs-pull)
15. [Part 15: Restore](#part-15--git-restore)
16. [Part 16: Reset](#part-16--git-reset)
17. [Part 17: Fork](#part-17--fork)
18. [Part 18: Pull Request](#part-18--pull-request)
19. [Part 19: Real-World Team Workflow](#part-19--complete-real-world-team-workflow)
20. [Part 20: Real-World Bug Fix Workflow](#part-20--real-world-bug-fix-workflow)
21. [Part 21: Common Complete Workflow](#part-21--common-complete-git-workflow)
22. [Part 22: Command Cheat Sheet](#part-22--command-cheat-sheet)
23. [Part 23: Basic Interview Questions](#part-23--basic-interview-questions)
24. [Part 24: Intermediate Interview Questions](#part-24--intermediate-interview-questions)
25. [Part 25: Advanced Interview Questions](#part-25--advanced-interview-questions)
26. [Part 26: More Advanced Commands (Stash, Show, Revert, Tag, Remote mgmt)](#part-26--more-important-advanced-commands)
27. [Part 27: Reset vs Revert vs Restore](#part-27--git-reset-vs-revert-vs-restore)
28. [Part 28: Complete Project Example (MERN)](#part-28--complete-project-example)
29. [Part 29: Most Important Flows to Memorize](#part-29--the-most-important-flow-to-memorize)
30. [Bonus: Extra Topics Worth Knowing](#bonus--extra-topics-worth-knowing)
31. [Final Learning Order](#final-learning-order)

---

# PART 1: BASIC GIT CONCEPTS

## 1. What is Git?

Git is a **Distributed Version Control System (DVCS)** used to track changes in source code and files.

**In simple words:** Git keeps a history of your project so you can see **what** changed, **who** changed it, **when** it changed, and **go back** to an older version if required.

### Example

```
StudentManagement/
│
├── index.html
├── style.css
└── script.js
```

| Day | Version | Change |
|---|---|---|
| Today | Version 1 | Login page |
| Tomorrow | Version 2 | Added Registration |
| Next day | Version 3 | Added Dashboard |

Git stores each of these changes as **commits**. If Version 3 creates a problem, you can inspect or restore an earlier version.

---

## 2. What is GitHub?

GitHub is a **cloud-based platform** for hosting Git repositories and collaborating with other developers.

```
Git       → Tool/software for version control
GitHub    → Online platform where Git repositories can be hosted/shared
```

```
Your Computer
     |
     | git push
     ↓
   GitHub
     |
     | git pull
     ↓
Other Developer
```

- Git itself can work **without** GitHub.
- GitHub **uses** Git.

---

## 3. Git vs GitHub 🎯

| Git | GitHub |
|---|---|
| Version control tool | Git repository hosting/collaboration platform |
| Runs locally | Primarily cloud-based |
| Tracks changes | Hosts/shares Git repositories |
| Created by Linus Torvalds | A company/platform |
| Most operations work without internet | Usually requires internet for remote collaboration |
| Uses commands such as `git commit` | Provides Pull Requests, Issues, Actions, etc. |
| Local repository | Remote repository |

**Simple analogy**

```
Git    = Notebook where you maintain project history
GitHub = Online place where you keep/share that notebook
```

---

## 4. Why Do We Need Git?

**Without Git:**

```
project_final
project_final_new
project_final_latest
project_final_latest2
project_final_REAL
project_final_REAL_FINAL
```

This becomes difficult to manage.

**With Git:**

```
Commit 1 → Login
Commit 2 → Registration
Commit 3 → Dashboard
Commit 4 → Payment
```

You can track everything.

### Main Benefits

- Version history
- Backup
- Collaboration
- Branching
- Merging
- Conflict management
- Rollback
- Code review
- Team development
- Remote repository management

---

## 5. What is Version Control?

A **Version Control System (VCS)** records changes made to files over time.

```
Monday    → Login created
Tuesday   → Registration added
Wednesday → Dashboard added
Thursday  → Bug introduced
```

Git allows you to identify and manage these versions.

---

## 6. Types of Version Control 🎯

### 1. Local Version Control

History is maintained only on one computer.

```
Computer
   |
   └── Version History
```

Example: **RCS**

### 2. Centralized Version Control

One central server.

```
Developer 1 ──┐
Developer 2 ──┼── Central Server
Developer 3 ──┘
```

Examples: **SVN, CVS**

### 3. Distributed Version Control

Every developer has a **complete** repository.

```
Developer 1 → Repository
Developer 2 → Repository
Developer 3 → Repository
                     ↓
                 Remote Server
```

Example: **Git**

| Type | Single Point of Failure? | Works Offline? | Examples |
|---|---|---|---|
| Local | Yes | Yes | RCS |
| Centralized | Yes (server) | Limited | SVN, CVS |
| Distributed | No | Yes (mostly) | Git, Mercurial |

---

## 7. Alternatives to Git

| Tool | Type |
|---|---|
| SVN | Centralized |
| Mercurial | Distributed |
| Perforce | Centralized/Distributed workflows |
| Bazaar | Distributed |
| Fossil | Distributed |

Git is widely used because of its **branching, distributed architecture, ecosystem, and integration** with platforms such as GitHub, GitLab and Bitbucket.

---

# PART 2: GIT ARCHITECTURE

🎯 **Extremely important for interviews.**

```
Working Directory
       ↓
     git add
       ↓
Staging Area
       ↓
   git commit
       ↓
Local Repository
       ↓
   git push
       ↓
Remote Repository
       ↓
     GitHub
```

## 8. Working Directory

Your actual project files on disk.

```
project/
├── index.html
├── style.css
└── script.js
```

## 9. Staging Area (Index)

Files **selected for the next commit**.

```bash
git add .
```

moves changes into the staging area.

## 10. Local Repository

After:

```bash
git commit
```

Git stores the snapshot in the **local repository** (the `.git` folder).

## 11. Remote Repository

A repository stored on a remote service such as GitHub.

```
https://github.com/username/project.git
```

---

# PART 3: BASIC GIT COMMANDS

## 12. `git config`

Configures Git.

```bash
# Set username
git config --global user.name "Mohit"

# Set email
git config --global user.email "your-email@example.com"

# View configuration
git config --list
```

**Why needed?** Git needs author information when creating commits.

**Scopes (bonus):**

| Flag | Scope |
|---|---|
| `--system` | All users on the machine |
| `--global` | Current user, all repos |
| `--local` | Current repository only (default) |

---

## 13. `git init`

Creates a **new** Git repository.

```bash
git init
```

**Before**

```
MyProject/
```

**After**

```
MyProject/
└── .git/
```

`.git` contains Git's repository data.

**Real-world use:** starting version control on an existing local project.

```bash
cd MyProject
git init
```

---

## 14. `git clone`

Copies an **existing remote** repository to your computer.

```bash
git clone https://github.com/user/project.git
```

```
GitHub Repository
       ↓
   git clone
       ↓
Local Computer
```

**Real-world use:** you join a company project and need the existing code.

```bash
git clone https://github.com/company/project.git
```

> 🎯 `git init` = start a **new** repo. `git clone` = copy an **existing** repo (and it automatically sets up `origin`).

---

## 15. `git status`

Shows the current state of the working directory and staging area.

```bash
git status
```

### Git File States 🎯

```
Untracked
    ↓  git add
Staged
    ↓  git commit
Unmodified
```

If an already tracked file is changed:

```
Unmodified
    ↓  Edit file
Modified
    ↓  git add
Staged
```

## 16. Untracked File

A **new** file Git doesn't know about.

```
NewFile.java
```

```bash
git status
```

```
Untracked files:
    NewFile.java
```

## 17. Modified File

An already **tracked** file has been changed.

```
Modified:
    Student.java
```

## 18. Staged File

File selected for the next commit.

```bash
git add Student.java
```

Now it is staged.

## 19. Unmodified File

No changes since the last commit.

```
Working Directory = Last Commit
```

### File State Summary Table

| State | Meaning | How to get there |
|---|---|---|
| Untracked | New file, unknown to Git | Create a file |
| Modified | Tracked file changed | Edit a tracked file |
| Staged | Marked for next commit | `git add` |
| Unmodified | Same as last commit | `git commit` |

---

# PART 4: GIT ADD COMMANDS

## 20. `git add filename`

Stages **one** file.

```bash
git add index.html
```

## 21. `git add file1 file2`

Stages **multiple specific** files.

```bash
git add index.html style.css
```

## 22. `git add .`

Stages changes in the current directory and its subdirectories.

```bash
git add .
```

**Common use**

```bash
git status
git add .
git status
```

## 23. `git add -A`

Stages **all** changes across the repository: additions, modifications, and deletions.

```bash
git add -A
```

Think: **All changes**.

## 24. `git add -u`

Stages changes to **already tracked** files only. It does **not** stage new untracked files.

```
Existing.java → modified
New.java      → new
```

```bash
git add -u
```

Stages: `Existing.java`
Does **not** stage: `New.java`

## 25. `git add .` vs `git add -A` vs `git add -u` 🎯

| Command | New Files | Modified | Deleted |
|---|---|---|---|
| `git add .` | Yes* | Yes | Yes* |
| `git add -A` | Yes | Yes | Yes |
| `git add -u` | No | Yes | Yes |

\* The exact behavior of `git add .` can depend on the directory from which it is executed. For "stage everything in the repository," `git add -A` is the clearest command.

---

# PART 5: COMMIT

## 26. What is a Commit?

A commit is a **saved snapshot of staged changes**.

```bash
git commit
```

Usually:

```bash
git commit -m "Added login functionality"
```

Each commit has: a unique **hash**, an **author**, a **date**, a **message**, and a pointer to its **parent** commit.

## 27. `git commit -m`

Creates a commit with a message.

```bash
git add .
git commit -m "Added student registration"
```

**Real-world example**

```bash
git add .
git commit -m "Fix student login validation"
```

**Good commit messages describe the change.**

| ❌ Bad | ✅ Good |
|---|---|
| `fix` | `Fix student login validation` |
| `changes` | `Add event registration form` |
| `asdf` | `Update README with setup steps` |

## 28. `git commit --amend`

Changes the **most recent** commit.

```bash
git commit --amend -m "Correct commit message"
```

**Example**

```bash
git commit -m "Added logn"            # typo
git commit --amend -m "Added login"   # fixed
```

> ⚠️ **Important:** Amending changes the commit's hash. Be careful if the old commit has already been pushed/shared.

**Bonus:** forgot a file? Stage it and amend without changing the message:

```bash
git add forgotten.js
git commit --amend --no-edit
```

---

# PART 6: BRANCHES

## 29. What is a Branch?

A branch is an **independent line of development**.

```
main
 |
 |------ Login
 |
 |------ Payment
 |
 |------ Dashboard
```

```
main
 │
 ├── feature-login
 ├── feature-payment
 └── bugfix-login
```

Technically, a branch is a **movable pointer (reference) to a commit**.

## 30. Why Use Branches?

Production code is on `main`. You need to develop a payment feature, so **don't experiment directly on `main`**.

```bash
git branch payment
```

Then work on `payment`.

## 31. `git branch`

Shows branches.

```bash
git branch
```

```
* main
  payment
  login
```

`*` indicates the **current** branch.

## 32. Create Branch

```bash
git branch feature-login
```

Creates the branch but does **not** switch to it.

## 33. Switch Branch

Modern:

```bash
git switch feature-login
```

Older/common:

```bash
git checkout feature-login
```

## 34. Create + Switch Branch

Modern:

```bash
git switch -c feature-login
```

Older:

```bash
git checkout -b feature-login
```

## 35. `git branch -M`

Renames the **current** branch (forcefully).

```bash
git branch -M main
```

If your initial branch is `master`, this changes it: `master → main`.

## 36. Delete Branch

```bash
# Safe delete
git branch -d feature-login

# Force delete
git branch -D feature-login
```

| Flag | Meaning |
|---|---|
| `-d` | Safe deletion (refuses if unmerged) |
| `-D` | Force deletion |

> ⚠️ Use `-D` carefully because it can delete a branch containing commits that haven't been merged.

## 37. `git branch -v`

Shows branch names and their latest commit.

```bash
git branch -v
```

```
* main     a82f21 Added login
  payment  b71c44 Add payment form
```

## 38. `git branch --merged`

Shows branches **already merged** into the current branch (candidates for deletion).

```bash
git branch --merged
```

## 39. `git branch --no-merged`

Shows branches that **haven't been merged** into the current branch.

```bash
git branch --no-merged
```

---

# PART 7: GIT LOG

## 40. `git log`

Shows commit history.

```bash
git log
```

```
commit a82f...
Author: Mohit
Date: ...

    Added login

commit b71c...
    Added registration
```

## 41. `git log --oneline`

Compact history.

```bash
git log --oneline
```

```
a82f21 Added login
b71c44 Added registration
c92a11 Created project
```

## 42. `git log -2`

Shows the latest N commits.

```bash
git log -2
git log -3
git log -4
```

## 43. `git log -- filename`

Shows history of a particular file.

```bash
git log -- Student.java
```

Useful for: *"Who changed this file and how has it changed over time?"*

**Bonus options**

```bash
git log --graph --oneline --all    # visual branch graph
git log --author="Mohit"           # filter by author
git log -p                         # show patch (diff) for each commit
```

---

# PART 8: GIT DIFF

## 44. What is `git diff`?

Shows differences between versions/states. By default it shows **unstaged** working-tree changes.

```bash
git diff
```

## 45. `git diff --staged`

Shows differences between **staged** content and the **last commit**. Very useful **before committing**.

```bash
git diff --staged
```

(`git diff --cached` is the same.)

## 46. Compare Two Commits

```bash
git diff commit1 commit2
```

```bash
git diff 564643 06953
```

A more common form:

```bash
git diff 564643..06953
```

### Diff Summary 🎯

| Command | Compares |
|---|---|
| `git diff` | Working directory ↔ Staging area |
| `git diff --staged` | Staging area ↔ Last commit |
| `git diff A B` | Commit A ↔ Commit B |
| `git diff HEAD` | Working directory ↔ Last commit |

---

# PART 9: CHECKOUT / SWITCH

## 47. `git checkout branch`

Switches branches.

```bash
git checkout main
```

Modern equivalent:

```bash
git switch main
```

## 48. `git checkout HEAD~2`

Moves to the state two commits before HEAD.

```bash
git checkout HEAD~2
```

This puts you in a **detached HEAD** state (HEAD~2 is a commit, not a branch). It does **not** mean commits are automatically deleted.

## 49. `git checkout HEAD~3`

```bash
git checkout HEAD~3
```

```
Current HEAD  (HEAD)
   ↓
Previous commit   (HEAD~1)
   ↓
2 commits ago     (HEAD~2)
   ↓
3 commits ago     (HEAD~3)
```

## 50. Detached HEAD 🎯

```bash
git checkout a82f21
```

You are looking directly at a commit rather than working on a branch.

```
main
 |
 A
 |
 B ← HEAD
 |
 C
```

To preserve new work made from there, create a branch:

```bash
git switch -c experiment
```

To simply go back to normal: `git switch main`.

---

# PART 10: MERGE

## 51. What is Merge?

Merge combines changes from one branch into another.

```
main
  |
  A
  |
  B
   \
    C ← feature
```

Switch to the **target** branch, then merge:

```bash
git switch main
git merge feature
```

Now `feature` changes are integrated into `main`.

**Types of merge (bonus):**

| Type | When | Result |
|---|---|---|
| Fast-forward | `main` hasn't moved since branch creation | Pointer just moves forward, no merge commit |
| 3-way merge | Both branches have new commits | New merge commit is created |

## 52. Real-World Merge

```bash
git switch -c feature-login

git add .
git commit -m "Added login"

git switch main
git merge feature-login
```

---

# PART 11: MERGE CONFLICT

## 53. What is a Conflict? 🎯

A conflict happens when Git **cannot automatically decide** which changes should remain.

**Developer A:**

```java
System.out.println("Hello");
```

**Developer B:**

```java
System.out.println("Welcome");
```

Both modify the same part of the same file. Git may produce:

```
<<<<<<< HEAD
System.out.println("Hello");
=======
System.out.println("Welcome");
>>>>>>> feature
```

| Marker | Meaning |
|---|---|
| `<<<<<<< HEAD` | Start: your current branch's version |
| `=======` | Divider between the two versions |
| `>>>>>>> feature` | End: incoming branch's version |

You must manually decide what the final code should be.

## 54. Conflict Resolution

```bash
git merge feature        # Conflict occurs
```

1. Open the file.
2. Remove conflict markers and choose/fix the correct code.
3. Stage it:

```bash
git add .
```

4. Finish:

```bash
git commit
```

## 55. `git merge --abort`

Cancels an in-progress merge.

```bash
git merge --abort
```

Useful when conflict resolution has become complicated and you want to return to the state **before** the merge.

---

# PART 12: REMOTE REPOSITORIES

## 56. What is `origin`?

`origin` is normally the **default name** Git gives to the remote repository from which a repository was cloned (or which was added first).

```
origin → GitHub repository
```

## 57. `git remote`

Lists remote names.

```bash
git remote
```

## 58. `git remote -v`

Shows remote URLs.

```bash
git remote -v
```

```
origin  https://github.com/user/project.git (fetch)
origin  https://github.com/user/project.git (push)
```

## 59. `git remote add origin`

Connects a local repository to a remote repository.

```bash
git remote add origin https://github.com/user/project.git
```

**Typical "existing local project → GitHub" flow:**

```bash
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/user/project.git
git push -u origin main
```

---

# PART 13: GIT PUSH

## 60. What is `git push`?

Uploads local commits to a remote repository.

```bash
git push
```

## 61. `git push origin main`

Push local `main` to remote `origin`.

```bash
git push origin main
```

```
origin → remote repository
main   → branch
```

## 62. `git push -u origin main`

```bash
git push -u origin main
```

`-u` sets the **upstream** relationship. After that you can usually use:

```bash
git push
```

instead of:

```bash
git push origin main
```

---

# PART 14: FETCH VS PULL

## 63. `git fetch`

Downloads information about changes from a remote **without merging** them into your current branch.

```bash
git fetch origin
```

```
GitHub
  ↓
fetch
  ↓
Local remote-tracking information (e.g. origin/main)
```

Your working files are **not** automatically changed.

## 64. `git pull`

Gets remote changes and **integrates** them into your current branch.

```
git pull ≈ git fetch + integration
```

Integration is commonly a **merge**, though configuration can make pull use **rebase** (`git pull --rebase`).

## 65. Fetch vs Pull 🎯

| `git fetch` | `git pull` |
|---|---|
| Downloads remote updates | Downloads + integrates updates |
| Doesn't normally modify working files | May modify current branch/worktree |
| Safer for inspecting changes first | Convenient for updating local branch |
| Lets you inspect before integrating | Integrates immediately per pull configuration |

**Example**

```bash
git fetch origin
git log main..origin/main      # see what's new on remote
git merge origin/main          # integrate when ready
```

---

# PART 15: GIT RESTORE

## 66. `git restore`

Restores files. Suppose `Student.java` was modified but you don't want the changes:

```bash
git restore Student.java
```

This **discards unstaged working-tree changes** in that file.

> ⚠️ Those uncommitted changes may be lost permanently.

## 67. `git restore --staged`

Unstages a file (the **correct** command; note it is `--staged`, not `HEAD`).

```bash
git add Student.java          # Student.java → staged
git restore --staged Student.java   # unstaged again
```

The file **remains modified** in the working directory.

| Command | Effect |
|---|---|
| `git restore file` | Discard working-directory changes |
| `git restore --staged file` | Unstage, keep changes in working dir |

---

# PART 16: GIT RESET

`git reset` is one of the most important and misunderstood commands. Three major forms: `--soft`, `--mixed`, `--hard`.

## 68. `git reset`

Default is **mixed** mode.

```bash
git reset
```

Usually means: **unstage changes while keeping working-directory changes.**

## 69. `git reset HEAD~1`

Moves HEAD back one commit; with default mixed behavior, leaves that commit's changes in the working directory, **unstaged**.

```bash
git reset HEAD~1
```

Useful when: *"I committed too early, but I want to keep the code."*

## 70. `git reset --soft`

```bash
git reset --soft HEAD~1
```

Moves HEAD backward but **keeps changes staged**.

```
Commit → reset --soft → Changes remain staged
```

Useful to modify/recreate the last commit.

## 71. `git reset --mixed`

```bash
git reset --mixed HEAD~1
```

Moves HEAD backward, **unstages** changes, **keeps** them in the working directory. This is the default.

## 72. `git reset --hard` ⚠️

```bash
git reset --hard HEAD~1
```

Moves HEAD backward and resets the index **and** working tree to match. **Can discard uncommitted work.** Use with great care.

## 73. Reset Comparison 🎯

| Command | HEAD | Staging | Working Files |
|---|---|---|---|
| `--soft` | Moves | Kept | Kept |
| `--mixed` | Moves | Reset | Kept |
| `--hard` | Moves | Reset | Reset |

**Easy memory**

```
SOFT  → Keep everything staged
MIXED → Keep code, unstage
HARD  → Throw away local changes
```

---

# PART 17: FORK

## 74. What is Fork?

A fork creates **your own copy** of someone else's GitHub repository under **your** GitHub account.

```
Original Repository
       |
      Fork
       ↓
Your GitHub Repository
```

Common in **open-source** projects.

## 75. Fork vs Clone 🎯

| Fork | Clone |
|---|---|
| GitHub-side copy | Local computer copy |
| Creates repository under your account | Downloads repository |
| Useful for contributing to someone else's project | Useful for local development |
| Happens on GitHub | Happens through Git |

**Typical open-source workflow**

```
Original GitHub Repo
        ↓
      Fork
        ↓
Your GitHub Repo
        ↓
      Clone
        ↓
Your Computer
```

**Bonus:** keep your fork in sync by adding the original as `upstream`:

```bash
git remote add upstream https://github.com/original-owner/project.git
git fetch upstream
git merge upstream/main
```

---

# PART 18: PULL REQUEST

## 76. What is a Pull Request?

A **Pull Request (PR)** is a request to merge your changes from one branch/repository into another.

```
feature-login
      |
      | Pull Request
      ↓
     main
```

**Typical workflow**

```
Developer
   ↓
Create branch
   ↓
Write code
   ↓
Commit
   ↓
Push
   ↓
Create Pull Request
   ↓
Code Review
   ↓
Approval
   ↓
Merge
```

## 77. Why Pull Requests?

- Code review
- Discussion
- Automated checks
- Testing
- Review history
- Controlled merging

---

# PART 19: COMPLETE REAL-WORLD TEAM WORKFLOW

You work in a company on an event-management project.

**Step 1: Clone project**
```bash
git clone https://github.com/company/event-management.git
```

**Step 2: Enter project**
```bash
cd event-management
```

**Step 3: Check branches**
```bash
git branch
```

**Step 4: Update main**
```bash
git switch main
git pull origin main
```

**Step 5: Create feature branch**
```bash
git switch -c feature-event-registration
```

**Step 6: Write code**
```
EventRegistration.jsx
registration.css
registrationController.js
```

**Step 7: Check changes**
```bash
git status
```

**Step 8: Check exact changes**
```bash
git diff
```

**Step 9: Stage**
```bash
git add .
```

**Step 10: Verify staged changes**
```bash
git diff --staged
```

**Step 11: Commit**
```bash
git commit -m "Add event registration feature"
```

**Step 12: Push branch**
```bash
git push -u origin feature-event-registration
```

**Step 13: Create Pull Request** (on GitHub)
```
feature-event-registration → PR → main
```

**Step 14: Code Review**

If changes are requested:
```bash
# make changes
git add .
git commit -m "Fix registration validation"
git push
```
The existing PR updates automatically.

**Step 15: Merge**

After the team's process is satisfied, the PR is merged.

---

# PART 20: REAL-WORLD BUG FIX WORKFLOW

Production has a login bug.

```bash
git switch main
git pull origin main

git switch -c fix-login-validation

# fix the code

git status
git diff

git add .
git commit -m "Fix login validation"

git push -u origin fix-login-validation
```

Create PR on GitHub. After merge:

```bash
git switch main
git pull origin main
```

---

# PART 21: COMMON COMPLETE GIT WORKFLOW

🎯 **Memorize this:**

```bash
git clone <repository-url>

cd project

git status

git switch -c feature-name

# Write code

git status

git diff

git add .

git diff --staged

git commit -m "Meaningful message"

git push -u origin feature-name
```

Then:

```
Create Pull Request
       ↓
Code Review
       ↓
Tests
       ↓
Merge
```

---

# PART 22: COMMAND CHEAT SHEET

| Purpose | Command |
|---|---|
| Configure name | `git config --global user.name "Name"` |
| Configure email | `git config --global user.email "email"` |
| View config | `git config --list` |
| Initialize | `git init` |
| Clone | `git clone URL` |
| Status | `git status` |
| Stage file | `git add file` |
| Stage multiple files | `git add file1 file2` |
| Stage all | `git add .` |
| Stage all repo changes | `git add -A` |
| Stage tracked changes only | `git add -u` |
| Commit | `git commit -m "message"` |
| Amend last commit | `git commit --amend -m "message"` |
| Show branches | `git branch` |
| Create branch | `git branch name` |
| Switch branch | `git switch name` |
| Create + switch | `git switch -c name` |
| (Older) switch / create + switch | `git checkout name` / `git checkout -b name` |
| Rename current branch | `git branch -M main` |
| Delete branch | `git branch -d name` |
| Force delete | `git branch -D name` |
| Branch details | `git branch -v` |
| Merged branches | `git branch --merged` |
| Unmerged branches | `git branch --no-merged` |
| Show history | `git log` |
| Short history | `git log --oneline` |
| Latest 3 commits | `git log -3` |
| File history | `git log -- file` |
| Working changes | `git diff` |
| Staged changes | `git diff --staged` |
| Compare commits | `git diff c1 c2` / `git diff c1..c2` |
| Go to older commit | `git checkout HEAD~2` |
| Merge | `git merge branch` |
| Abort merge | `git merge --abort` |
| Remote list | `git remote -v` |
| Add remote | `git remote add origin URL` |
| Push | `git push` |
| Push specific branch | `git push origin main` |
| Push first time (set upstream) | `git push -u origin main` |
| Fetch | `git fetch origin` |
| Pull | `git pull origin main` |
| Restore file | `git restore file` |
| Unstage | `git restore --staged file` |
| Reset | `git reset` |
| Reset previous commit | `git reset HEAD~1` |
| Soft reset | `git reset --soft HEAD~1` |
| Mixed reset | `git reset --mixed HEAD~1` |
| Hard reset | `git reset --hard HEAD~1` |
| Show commit | `git show <commit>` |
| Revert commit | `git revert <commit>` |
| Stash | `git stash` |
| Tag | `git tag v1.0.0` |

---

# PART 23: BASIC INTERVIEW QUESTIONS

**Q1. What is Git?**
Git is a distributed version control system used to track changes in files and manage different versions of a project.

**Q2. What is GitHub?**
GitHub is a platform for hosting Git repositories and supporting collaboration through features such as pull requests, issues, reviews, and automation.

**Q3. Is GitHub required to use Git?**
No. Git can work locally without GitHub.

**Q4. What is Version Control?**
Version control tracks changes to files over time so developers can manage versions and collaborate.

**Q5. What is a repository?**
A repository is a project managed by Git, including its files and Git history.

**Q6. What is `.git`?**
`.git` is the directory containing the Git repository's internal data and history.

**Q7. What is a commit?**
A commit is a recorded snapshot of staged changes.

**Q8. What is staging?**
Staging means selecting changes that should be included in the next commit. Command: `git add .`

**Q9. What is HEAD?**
HEAD is a reference to the commit/branch position currently checked out.

```
HEAD → main → Latest Commit
```

**Q10. What is a branch?**
A branch is a movable reference representing an independent line of development.

---

# PART 24: INTERMEDIATE INTERVIEW QUESTIONS

**Q11. Difference between `git fetch` and `git pull`?**
```
fetch → download remote information
pull  → fetch + integrate
```

**Q12. Difference between `git merge` and a Pull Request?**
`git merge` is a Git operation that combines histories. A Pull Request is a collaboration/review mechanism, provided by platforms like GitHub, around proposed changes.

**Q13. Difference between `git restore` and `git reset`?**
```
restore → Restore file content / manage staging of files
reset   → Move HEAD and potentially reset staging/worktree
```
`reset --hard` is particularly destructive to uncommitted work.

**Q14. Difference between `git reset` and `git revert`?**

- **Reset** moves branch history backward: `git reset HEAD~1`
- **Revert** creates a **new commit** that reverses the effect of an earlier commit: `git revert <commit>`

For shared/public history, **revert** is often preferable because it preserves existing history rather than rewriting it.

**Q15. What is a merge conflict?**
It occurs when Git cannot automatically combine competing changes.

**Q16. How do you resolve a conflict?**
```
1. Run merge/pull
2. Identify conflicted files
3. Open files
4. Choose/fix the desired content
5. Remove conflict markers
6. git add .
7. git commit
```

**Q17. What is `origin`?**
The conventional name of the default remote repository.

**Q18. What is upstream?**
The remote branch associated with a local branch for operations such as `git push` and `git pull`.

**Q19. What is `git push -u`?**
It pushes the branch and establishes its upstream tracking relationship.
```bash
git push -u origin feature-login
```

**Q20. What is detached HEAD?**
It occurs when HEAD points directly to a commit instead of a branch.
```bash
git checkout a82f21
```

---

# PART 25: ADVANCED INTERVIEW QUESTIONS

**Q21. What is `git reset`?**
It moves HEAD and can also change the staging area and working tree depending on the reset mode.

**Q22. Explain reset modes.**
```
soft  → HEAD moves, staging stays
mixed → HEAD moves, staging resets, working files stay
hard  → HEAD + staging + working files reset
```

**Q23. What is `git revert`?**
It creates a new commit that reverses the changes introduced by an earlier commit.
```bash
git revert <commit>
```

**Q24. What is `git stash`?**
It temporarily stores uncommitted changes so you can switch context without committing incomplete work.

```bash
git stash
# ...do other work...
git stash pop
```

```
Working on Feature A
       ↓
Urgent bug appears
       ↓
stash Feature A
       ↓
Fix bug
       ↓
Return to Feature A (stash pop)
```

### Extra Frequently Asked Questions (Bonus)

**Q25. Difference between `git add .` and `git add -A`?** Mostly the same in modern Git when run from the repo root; `-A` always covers the whole repository regardless of the current directory.

**Q26. What does `--amend` do and when is it dangerous?** It rewrites the last commit (new hash). Dangerous if that commit is already pushed and others have based work on it.

**Q27. Fast-forward vs 3-way merge?** Fast-forward just moves the branch pointer (no merge commit); 3-way creates a merge commit when histories diverged.

**Q28. Fork vs Clone vs Branch?** Fork = your GitHub copy of someone's repo; Clone = local copy; Branch = parallel line of development within one repo.

**Q29. How to undo the last commit but keep the code?** `git reset --soft HEAD~1` (staged) or `git reset HEAD~1` (unstaged).

**Q30. How to undo a pushed commit safely?** `git revert <commit>` then `git push`.

**Q31. How to discard all local changes to a file?** `git restore file`.

**Q32. How to see what you're about to commit?** `git diff --staged`.

---

# PART 26: MORE IMPORTANT ADVANCED COMMANDS

## Stash

| Command | Purpose |
|---|---|
| `git stash` | Save uncommitted changes and clean working dir |
| `git stash list` | List all stashes |
| `git stash pop` | Re-apply latest stash **and remove** it |
| `git stash apply` | Re-apply latest stash **and keep** it |
| `git stash drop` | Delete the latest stash |

```bash
git stash                 # shelve Feature A
git switch main
# fix bug, commit
git switch feature-a
git stash pop             # resume Feature A
```

**Bonus:** `git stash -u` also stashes untracked files; `git stash push -m "wip login"` adds a label.

## Show commit

```bash
git show <commit>
```

Displays commit metadata and the changes it introduced.

```bash
git show a82f21
git show HEAD
```

## Revert

```bash
git revert <commit>
```

Creates a new commit that undoes the specified commit. History is preserved.

```bash
git revert a82f21
```

## Tag

```bash
git tag v1.0.0                 # create tag (marks a release point)
git push origin v1.0.0         # push tag to remote
git tag -d v1.0.0              # delete local tag
git push origin --delete v1.0.0   # delete remote tag
```

**Bonus:** `git tag` lists tags; `git tag -a v1.0.0 -m "Release 1.0"` creates an annotated tag; `git push origin --tags` pushes all tags.

## Remote Management

```bash
git remote rename origin upstream   # rename a remote
git remote remove origin            # remove a remote
```

---

# PART 27: GIT RESET vs REVERT vs RESTORE

🎯 **Very important interview topic.**

| Command | Main Purpose |
|---|---|
| `git restore` | Restore file contents / unstage |
| `git reset` | Move branch/HEAD and optionally reset index/worktree |
| `git revert` | Create a new commit that reverses an earlier commit |

**Easy memory**

```
RESTORE → File
RESET   → Move history/reference
REVERT  → Reverse with a new commit
```

| Scenario | Use |
|---|---|
| Discard edits in one file | `git restore file` |
| Unstage a file | `git restore --staged file` |
| Undo local, unpushed commit | `git reset` |
| Undo a commit already pushed/shared | `git revert` |

---

# PART 28: COMPLETE PROJECT EXAMPLE

Your **MERN Event Management** project.

```bash
# Initial: on main
git switch -c feature-event
```

Create:

```
Event.jsx
Event.css
eventController.js
```

```bash
git status                                   # check
git diff                                     # check changes
git add .                                    # stage
git diff --staged                            # check staged changes
git commit -m "Add event management feature" # commit
git push -u origin feature-event             # push
```

GitHub:

```
feature-event → Pull Request → Code Review → main
```

After merge:

```bash
git switch main
git pull origin main
git branch -d feature-event     # delete local branch
```

This is essentially the workflow you'd see in a professional team.

---

# PART 29: THE MOST IMPORTANT FLOW TO MEMORIZE

**Uploading**

```
                 GITHUB
                    ↑
                 git push
                    ↑
              LOCAL REPOSITORY
                    ↑
               git commit
                    ↑
              STAGING AREA
                    ↑
                 git add
                    ↑
             WORKING DIRECTORY
```

**Downloading**

```
GitHub
  ↓
git fetch
  ↓
Remote-tracking branch

GitHub
  ↓
git pull
  ↓
Local branch + integration
```

**Development**

```
main
 ↓
git switch -c feature
 ↓
Write Code
 ↓
git status
 ↓
git diff
 ↓
git add .
 ↓
git diff --staged
 ↓
git commit
 ↓
git push
 ↓
Pull Request
 ↓
Review
 ↓
Merge
 ↓
main
```

---

# BONUS: EXTRA TOPICS WORTH KNOWING

| Topic | Command / Idea | Use |
|---|---|---|
| `.gitignore` | File listing patterns like `node_modules/`, `.env` | Prevent files from being tracked |
| `git rebase` | `git rebase main` | Replay commits on top of another branch for linear history (avoid on shared branches) |
| `git cherry-pick` | `git cherry-pick <commit>` | Apply one specific commit to the current branch |
| `git reflog` | `git reflog` | Recover "lost" commits after reset/checkout |
| `git rm` | `git rm file` | Delete file and stage the deletion |
| `git mv` | `git mv old new` | Rename/move file and stage it |
| `git blame` | `git blame file` | See who last changed each line |
| `git pull --rebase` | `git pull --rebase` | Pull without creating merge commits |

### Quick Recovery Scenarios

| Situation | Fix |
|---|---|
| Committed to wrong branch | `git reset --soft HEAD~1`, switch branch, commit again |
| Typo in last commit message | `git commit --amend -m "..."` |
| Staged wrong file | `git restore --staged file` |
| Accidentally ran `reset --hard` | `git reflog` → `git reset --hard <hash>` |
| Merge went wrong | `git merge --abort` |
| Detached HEAD with new work | `git switch -c new-branch` |

---

# FINAL LEARNING ORDER

Study in this order for exams and interviews:

1. Git
2. GitHub
3. Version Control
4. Git Architecture
5. Repository
6. Working Directory
7. Staging Area
8. Commit
9. `git init`
10. `git clone`
11. `git status`
12. `git add`
13. `git commit`
14. `git log`
15. `git diff`
16. Branch
17. `switch` / `checkout`
18. `merge`
19. Merge conflict
20. `remote`
21. `push`
22. `fetch`
23. `pull`
24. `restore`
25. `reset`
26. `revert`
27. `stash`
28. Fork
29. Pull Request
30. Real-world team workflow

This gives you the foundation to answer both **exam-style theory questions** and **practical Git/GitHub interview questions**.

---

*End of guide. Practice each command in a throwaway repo to make it stick.* 🚀
