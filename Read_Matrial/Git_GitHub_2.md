# Git & GitHub Complete Guide
### Simple Explanations + Real-World Examples + Exam & Interview Preparation

> **How to use this guide:** For every topic you get: **Simple meaning**, **Real-life analogy**, **Commands with examples**, **How to explain in an exam**, and **Interview Q&A**.

---

## Table of Contents

1. [Git](#1-git)
2. [GitHub](#2-github)
3. [Version Control](#3-version-control)
4. [Git Architecture](#4-git-architecture)
5. [Repository](#5-repository)
6. [Working Directory](#6-working-directory)
7. [Staging Area](#7-staging-area)
8. [Commit](#8-commit)
9. [git init](#9-git-init)
10. [git clone](#10-git-clone)
11. [git status](#11-git-status)
12. [git add](#12-git-add)
13. [git commit](#13-git-commit)
14. [git log](#14-git-log)
15. [git diff](#15-git-diff)
16. [Branch](#16-branch)
17. [switch / checkout](#17-switch--checkout)
18. [merge](#18-merge)
19. [Merge Conflict](#19-merge-conflict)
20. [remote](#20-remote)
21. [push](#21-push)
22. [fetch](#22-fetch)
23. [pull](#23-pull)
24. [restore](#24-restore)
25. [reset](#25-reset)
26. [revert](#26-revert)
27. [stash](#27-stash)
28. [fork](#28-fork)
29. [pull request](#29-pull-request)
30. [Real-World Team Workflow](#30-real-world-team-workflow)
31. [Cheat Sheet](#31-quick-cheat-sheet)
32. [Top Interview Questions](#32-top-interview-questions)

---

# 1. Git

**Simple meaning:** Git is a free tool installed on your computer that **tracks changes in your code** over time. It lets you save versions, go back to old versions, and work with other people without overwriting each other's work.

**Analogy:** Think of Git as the **"Save History"** of a video game. You can save at many points and reload any earlier save.

**Key facts**
- Created by **Linus Torvalds** in **2005** (also the creator of Linux).
- It is a **Distributed Version Control System (DVCS)**.
- Works **offline** (almost everything happens on your own machine).
- Fast, free, and open source.

**Check installation**
```bash
git --version
# git version 2.45.0
```

**First-time setup (do this once)**
```bash
git config --global user.name  "Rahul Patel"
git config --global user.email "rahul@example.com"
git config --list
```

**Exam answer (2 lines):**
> Git is a free, open-source, distributed version control system used to track changes in source code and allow multiple developers to collaborate efficiently.

**Interview Q: Who created Git and why?**
> Linus Torvalds created it in 2005 to manage the Linux kernel source code, because the previous tool they used became unavailable. He wanted something fast, distributed, and safe.

---

# 2. GitHub

**Simple meaning:** GitHub is a **website (cloud service)** that stores your Git repositories online so you can share, back up, and collaborate.

**Analogy:** Git = **Google Docs software engine on your laptop**. GitHub = **Google Drive** where you upload and share it.

| Git | GitHub |
|---|---|
| Software / tool | Website / online platform |
| Installed locally | Hosted on the cloud |
| Works offline | Needs internet |
| Created by Linus Torvalds | Owned by Microsoft (bought in 2018) |
| Manages versions | Adds collaboration (Pull Requests, Issues, Actions) |

**Similar platforms:** GitLab, Bitbucket, Azure Repos.

**GitHub extra features:** Pull Requests, Issues, Projects board, GitHub Actions (CI/CD), Pages (free hosting), Code review, Forks, Stars.

**Exam answer:**
> GitHub is a web-based hosting platform for Git repositories that provides collaboration features such as pull requests, issue tracking, and CI/CD.

**Interview Q: Is Git the same as GitHub?**
> No. Git is the version control tool. GitHub is a cloud service built on top of Git. You can use Git without GitHub, but not GitHub without Git.

---

# 3. Version Control

**Simple meaning:** A system that **records every change** made to files so you can recall specific versions later.

**Analogy (the classic problem):**
```
project_final.docx
project_final_v2.docx
project_final_v2_REAL.docx
project_final_v2_REAL_last.docx   <-- chaos!
```
Version control replaces this mess with one project and a clean history.

**Why it is needed**
- Track **who** changed **what** and **when**
- Undo mistakes
- Many developers work in parallel
- Backup and recovery
- Create separate versions (features, bug fixes)

**Types of Version Control Systems**

| Type | Meaning | Example |
|---|---|---|
| Local VCS | Version history only on one computer | RCS |
| Centralized VCS (CVCS) | One central server; clients depend on it | SVN, CVS |
| Distributed VCS (DVCS) | Every user has the **full copy + history** | **Git**, Mercurial |

**Why Distributed is better:** If the server crashes, any developer's copy can restore the project. Also you can commit offline.

**Exam answer:**
> Version control is a system that tracks and manages changes to files over time, allowing recovery of earlier versions and collaboration among multiple users.

---

# 4. Git Architecture

Git has **three local areas** and **one remote area**.

```
 Working Directory  --git add-->  Staging Area  --git commit-->  Local Repository  --git push-->  Remote Repository
   (your files)                    (index)                         (.git folder)                    (GitHub)
        ^                                                                |                              |
        |------------------------- git pull / git fetch + merge --------|------------------------------|
```

| Area | Where | Purpose |
|---|---|---|
| Working Directory | Your computer | Where you edit files |
| Staging Area (Index) | Your computer | Where you prepare what goes into next commit |
| Local Repository | `.git` folder | Stores all commits (history) |
| Remote Repository | GitHub/GitLab | Shared online copy |

**Analogy: Sending a parcel**
1. **Working directory** = Items lying on your table
2. **Staging area** = Items you put in the box
3. **Commit** = Sealing the box and writing a label (message)
4. **Push** = Handing the box to the courier (GitHub)

**How Git stores data (good for interviews):**
Git stores **snapshots**, not differences. Each commit is a snapshot of the whole project, identified by a **SHA-1 hash** (e.g., `a3f9c2e`). Unchanged files are just linked to the previous snapshot.

**Interview Q: What are the three states of a file in Git?**
> **Modified** (changed in working dir), **Staged** (marked to go in next commit), **Committed** (safely stored in local database).

---

# 5. Repository

**Simple meaning:** A **project folder tracked by Git**. It contains your files **plus** the hidden `.git` folder where Git keeps history.

**Analogy:** A repository is like a **notebook with a complete diary** of every edit ever made.

```
my-project/
├── .git/          <-- hidden: all history lives here
├── index.html
└── app.js
```

**Types**
- **Local repository:** On your machine
- **Remote repository:** On GitHub/GitLab/Bitbucket
- **Bare repository:** Server repo without a working directory (used only for sharing)

**Interview Q: What is inside the `.git` folder?**
> Commits, branches, tags, config, HEAD pointer, and the object database. If you delete `.git`, the folder becomes a normal folder and history is lost.

---

# 6. Working Directory

**Simple meaning:** The actual folder where you **create, edit, and delete files**. This is what you see in your file explorer / VS Code.

**Example**
```bash
mkdir shop-app
cd shop-app
echo "console.log('Hello Shop');" > app.js    # file created in working directory
```
At this stage, Git sees the file but is **not tracking** it yet (it is *untracked*).

**File states in working directory**
- **Untracked** – new file Git doesn't know about
- **Modified** – tracked file that you changed
- **Unmodified** – no changes since last commit

---

# 7. Staging Area

**Simple meaning:** A **waiting room / preview zone** between your working directory and the commit. You choose exactly which changes to include in the next commit.

**Analogy:** Shopping **cart** — you put items in the cart (stage) before paying (commit). You don't have to buy everything.

**Why it exists?**
Suppose you fixed a login bug and also started a new feature. You can stage **only the login fix** and commit it separately. This keeps history clean.

**Example**
```bash
git add login.js        # only login.js goes to staging
git commit -m "Fix login bug"
# feature.js is still not committed
```

**Also called:** Index, Cache.

**Interview Q: Why not commit directly from working directory?**
> The staging area gives control. It lets us create small, logical, focused commits instead of dumping all changes in one.

---

# 8. Commit

**Simple meaning:** A **permanent snapshot** of your staged changes, saved in local history with a message, author, date, and unique ID (hash).

**Analogy:** A **checkpoint / save point** in a game.

**Anatomy of a commit**
```
commit a3f9c2e8b1...         <-- unique hash (ID)
Author: Rahul <rahul@ex.com>
Date:   Thu Oct 1 2026

    Add login validation     <-- message
```

**Good commit message rules**
- Short (under ~50 characters for the title)
- Imperative mood: "Add login", not "Added login"
- Explain **what and why**

| Bad | Good |
|---|---|
| `fixed stuff` | `Fix null error in payment calculation` |
| `changes` | `Add email validation to signup form` |
| `asdf` | `Remove unused CSS from navbar` |

**Interview Q: Can a commit be changed?**
> Last commit can be modified with `git commit --amend` (only if not pushed yet). Older commits can be rewritten with interactive rebase. Rewriting pushed history is dangerous on shared branches.

---

# 9. git init

**Purpose:** Turns an existing folder into a **new Git repository**.

**Syntax**
```bash
git init
git init project-name     # creates folder + repo
```

**Example**
```bash
mkdir todo-app
cd todo-app
git init
# Initialized empty Git repository in /todo-app/.git/
```

**What happens?** A hidden `.git` folder is created.

**Use when:** Starting a brand-new project from scratch.

**Tip:** Default branch may be `master` or `main`. To set main:
```bash
git init -b main
# or
git branch -M main
```

**Exam answer:**
> `git init` initializes a new empty Git repository by creating a `.git` directory in the current folder.

---

# 10. git clone

**Purpose:** **Downloads a complete copy** of an existing remote repository (all files + full history + branches) to your computer.

**Syntax**
```bash
git clone <repository-url>
git clone <url> my-folder-name
git clone -b develop <url>        # clone specific branch
git clone --depth 1 <url>         # shallow clone (latest snapshot only, faster)
```

**Example**
```bash
git clone https://github.com/torvalds/linux.git
cd linux
```

**What happens automatically**
1. Creates folder
2. Downloads all history
3. Sets remote named **origin**
4. Checks out default branch

**`init` vs `clone`**

| git init | git clone |
|---|---|
| Starts a new repo | Copies an existing repo |
| No remote set | `origin` set automatically |
| Empty history | Full history |

**Interview Q: Difference between clone and fork?**
> Clone is a local copy of a repository. Fork is a copy of someone else's repository **on GitHub under your account**. Typically you fork first, then clone your fork.

---

# 11. git status

**Purpose:** Shows the **current state** of working directory and staging area: what is modified, staged, or untracked.

**Syntax**
```bash
git status
git status -s       # short format
```

**Example output**
```
On branch main
Changes to be committed:            <-- STAGED
        modified:   login.js

Changes not staged for commit:      <-- MODIFIED (not staged)
        modified:   style.css

Untracked files:                    <-- NEW files
        notes.txt
```

**Short format symbols**
```
?? notes.txt      untracked
A  new.js         added (staged)
 M style.css      modified (not staged)
M  login.js       modified (staged)
```

**Habit:** Run `git status` **before and after** every command. It's your safety check.

---

# 12. git add

**Purpose:** Moves changes from **working directory to staging area**.

**Syntax**
```bash
git add file.txt              # one file
git add file1.js file2.js     # multiple files
git add .                     # everything in current folder
git add -A                    # all changes (new, modified, deleted)
git add *.js                  # all JS files
git add folder/               # whole folder
git add -p                    # choose changes interactively (hunk by hunk)
```

**Example**
```bash
echo "Hello" > hello.txt
git status        # hello.txt is untracked
git add hello.txt
git status        # hello.txt is "Changes to be committed"
```

**Remove from staging (unstage)**
```bash
git restore --staged hello.txt
```

**Interview tip:** Avoid blindly using `git add .` — you may accidentally commit secrets like `.env` or `node_modules`. Use `.gitignore`.

**.gitignore example**
```
node_modules/
.env
*.log
dist/
```

---

# 13. git commit

**Purpose:** Saves staged changes as a **new snapshot** in local repository.

**Syntax**
```bash
git commit -m "message"
git commit -am "message"          # stage tracked files + commit (skips new files)
git commit --amend -m "new msg"   # fix the last commit message
git commit --amend --no-edit      # add forgotten file to last commit
```

**Full example**
```bash
git add login.js
git commit -m "Add login form validation"
# [main 4f2a1c9] Add login form validation
#  1 file changed, 20 insertions(+)
```

**Forgot a file? Fix last commit (not pushed yet)**
```bash
git add forgotten.js
git commit --amend --no-edit
```

**Exam point:** `git add` = prepare, `git commit` = save permanently (locally). Commit does **not** upload to GitHub; `git push` does.

---

# 14. git log

**Purpose:** Displays **commit history**.

**Syntax**
```bash
git log
git log --oneline                    # compact: one line per commit
git log --oneline --graph --all      # branch visual tree
git log -5                           # last 5 commits
git log --author="Rahul"
git log --since="2 weeks ago"
git log --grep="login"               # search commit messages
git log -p                           # show code changes in each commit
git log --stat                       # files changed summary
git log file.js                      # history of one file
```

**Example output (`--oneline`)**
```
4f2a1c9 Add login form validation
b7e3d10 Create navbar component
9a1c2f5 Initial commit
```

**Pretty graph**
```
* 4f2a1c9 (HEAD -> main) Merge feature-login
|\
| * c3d4e5f (feature-login) Add login API
* | b7e3d10 Fix typo
|/
* 9a1c2f5 Initial commit
```

**Related:** `git reflog` shows every movement of HEAD (even deleted commits) — a lifesaver to recover lost work.

---

# 15. git diff

**Purpose:** Shows **exact line-by-line differences** between versions.

**Syntax**
```bash
git diff                       # working dir vs staging (unstaged changes)
git diff --staged              # staging vs last commit (what will be committed)
git diff HEAD                  # working dir vs last commit
git diff branch1 branch2       # compare two branches
git diff commit1 commit2       # compare two commits
git diff file.js               # only one file
```

**Example output**
```diff
diff --git a/app.js b/app.js
--- a/app.js
+++ b/app.js
@@ -1,3 +1,3 @@
-console.log("Hello");
+console.log("Hello World");
 let x = 5;
```
- Lines with `-` (red) = removed
- Lines with `+` (green) = added

**Quick memory table**

| Command | Compares |
|---|---|
| `git diff` | Working directory ↔ Staging |
| `git diff --staged` | Staging ↔ Last commit |
| `git diff HEAD` | Working directory ↔ Last commit |

---

# 16. Branch

**Simple meaning:** An **independent line of development**. You can build a feature or fix a bug without disturbing the main code.

**Analogy:** A **parallel universe / copy of a document** where you can experiment. If it works, merge it back; if not, delete it.

```
main:     A---B---C-----------F
                   \         /
feature:            D---E---
```

**Commands**
```bash
git branch                      # list local branches (* = current)
git branch -a                   # list local + remote
git branch feature-login        # create branch
git branch -d feature-login     # delete (safe, only if merged)
git branch -D feature-login     # force delete
git branch -m old-name new-name # rename
git branch -v                   # show last commit of each branch
```

**Why branches?**
- `main` always stays **stable & deployable**
- Each feature/bug has its own space
- Safe experiments
- Parallel teamwork

**Common branch names**
```
main / master      → production code
develop            → integration branch
feature/login      → new feature
bugfix/cart-crash  → bug fix
hotfix/payment     → urgent production fix
release/v2.0       → release preparation
```

**Interview Q: What is HEAD?**
> HEAD is a pointer to the current branch (and its latest commit) you're working on. A **detached HEAD** means HEAD points directly to a commit, not a branch.

**Interview Q: Why are Git branches lightweight?**
> A branch is just a small file containing a 40-character commit hash — a pointer, not a copy of files. So creating a branch is instant.

---

# 17. switch / checkout

**Purpose:** **Move between branches** (change which branch you're working on).

**Modern commands (Git 2.23+)**
```bash
git switch main                  # go to existing branch
git switch -c feature-login      # create + switch
git switch -                     # jump back to previous branch
```

**Older command (still widely used & asked in interviews)**
```bash
git checkout main
git checkout -b feature-login    # create + switch
git checkout abc1234             # go to a specific commit (detached HEAD)
git checkout -- file.txt         # discard changes in file (old way)
```

**Why was `switch` introduced?** `git checkout` did too many jobs (switch branches, restore files, go to commits). Git split it into:
- `git switch` → branches
- `git restore` → files

**Example flow**
```bash
git switch -c feature-search     # new branch
# ... edit code ...
git add .
git commit -m "Add search bar"
git switch main                  # code of feature disappears (it's in the other branch)
git switch feature-search        # code returns
```

**Note:** If you have uncommitted changes that conflict, Git blocks the switch. Commit or `stash` first.

---

# 18. merge

**Purpose:** **Combines** changes from one branch into another.

**Syntax**
```bash
git switch main              # go to the branch that RECEIVES changes
git merge feature-login      # bring feature-login INTO main
```

**Two types of merge**

### a) Fast-Forward Merge
Happens when main has **no new commits** since the branch was created. Git just moves the pointer.
```
Before:  main: A---B
                    \
         feature:    C---D

After:   main: A---B---C---D   (straight line)
```

### b) Three-Way Merge (creates a merge commit)
Happens when **both** branches have new commits.
```
Before:  main:    A---B---E
                       \
         feature:       C---D

After:   main:    A---B---E-------M   (M = merge commit)
                       \         /
                        C---D---
```

**Useful options**
```bash
git merge --no-ff feature     # always create merge commit
git merge --squash feature    # combine all feature commits into one (then commit manually)
git merge --abort             # cancel a merge in progress
```

**Merge vs Rebase (popular interview question)**

| Merge | Rebase |
|---|---|
| Preserves exact history | Rewrites history into a straight line |
| Creates a merge commit | No merge commit |
| Safe for shared branches | Never rebase public/shared branches |
| Non-destructive | Rewrites commits (new hashes) |

```bash
git switch feature
git rebase main         # replay feature commits on top of main
```

---

# 19. Merge Conflict

**Simple meaning:** Git can't decide automatically because **two branches changed the same line** of the same file differently.

**Analogy:** Two people edit the same sentence in a shared document. One writes "Hello", other writes "Hi". Someone must decide.

**How it looks in the file**
```
<<<<<<< HEAD
let title = "Welcome to Shop";
=======
let title = "Hello Customer";
>>>>>>> feature-login
```
- Between `<<<<<<< HEAD` and `=======` → **your current branch's** version
- Between `=======` and `>>>>>>>` → **incoming branch's** version

**Step-by-step resolution**
```bash
git merge feature-login
# CONFLICT (content): Merge conflict in app.js
# Automatic merge failed; fix conflicts and then commit the result.

git status                  # shows "both modified: app.js"
```
1. Open `app.js`
2. Choose: keep yours, keep theirs, or combine both
3. **Delete** the markers `<<<<<<<`, `=======`, `>>>>>>>`
```js
let title = "Welcome Customer";   // final decision
```
4. Finish:
```bash
git add app.js
git commit -m "Resolve merge conflict in title"
```

**Shortcuts**
```bash
git checkout --ours   app.js    # keep my version
git checkout --theirs app.js    # keep incoming version
git merge --abort               # give up, return to before merge
```

**How to reduce conflicts**
- Pull latest changes often
- Keep branches short-lived
- Make small commits
- Communicate who is working on which file

**Interview Q: How do you handle merge conflicts?**
> I run `git status` to find conflicted files, open them, understand both changes (talk with the teammate if needed), edit to the correct final code, remove the conflict markers, run tests, `git add`, and complete with `git commit`.

---

# 20. remote

**Simple meaning:** A **link (bookmark) to a repository hosted elsewhere** — usually GitHub. The default name is **origin**.

**Commands**
```bash
git remote -v                                     # list remotes with URLs
git remote add origin https://github.com/user/repo.git
git remote rename origin upstream
git remote remove origin
git remote set-url origin <new-url>              # change URL
git remote show origin                           # detailed info
```

**Example: connecting a local project to GitHub**
```bash
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/rahul/shop-app.git
git push -u origin main
```

**Naming convention**
- `origin` → your main remote (your repo or fork)
- `upstream` → the original repo you forked from

**HTTPS vs SSH**
```
HTTPS: https://github.com/user/repo.git   (uses token/password)
SSH  : git@github.com:user/repo.git       (uses SSH key, no repeated login)
```

---

# 21. push

**Purpose:** **Uploads** your local commits to the remote repository.

**Syntax**
```bash
git push origin main                  # push main branch to origin
git push -u origin main               # push + set upstream (next time just: git push)
git push origin feature-login         # push a feature branch
git push --all                        # push all branches
git push --tags                       # push tags
git push origin --delete feature-old  # delete remote branch
git push --force-with-lease           # safer force push
```

**Example**
```bash
git add .
git commit -m "Add payment page"
git push origin main
```

**Common error**
```
! [rejected] main -> main (fetch first)
```
Meaning: someone else pushed before you. Fix:
```bash
git pull origin main        # get their changes, resolve conflicts
git push origin main
```

**Danger: `git push --force`**
Overwrites remote history and can delete teammates' work. **Never force-push to shared branches (main/develop).** Prefer `--force-with-lease`.

---

# 22. fetch

**Purpose:** **Downloads** new commits/branches from remote **but does NOT change your working files**. It's a safe "look".

**Syntax**
```bash
git fetch                  # fetch from origin
git fetch origin
git fetch --all            # all remotes
git fetch --prune          # also remove deleted remote branches from list
```

**Example**
```bash
git fetch origin
git log main..origin/main --oneline     # what's new on remote that I don't have?
git diff main origin/main               # see exact changes
git merge origin/main                   # apply them when ready
```

**Analogy:** Checking your mailbox and **looking at the letters** without opening or acting on them.

**Remote-tracking branches:** After fetch, you'll see `origin/main` — a read-only local reference showing where remote's main was at last fetch.

---

# 23. pull

**Purpose:** **Fetch + Merge** in one command. Downloads remote changes and immediately integrates them into your current branch.

```
git pull  =  git fetch  +  git merge
```

**Syntax**
```bash
git pull
git pull origin main
git pull --rebase                 # fetch + rebase (cleaner history)
```

**Example**
```bash
git switch main
git pull origin main              # update local main with teammates' work
```

**fetch vs pull (VERY common interview question)**

| git fetch | git pull |
|---|---|
| Only downloads | Downloads **and merges** |
| Doesn't touch your working files | Updates your working files |
| Safe to review first | May cause merge conflicts immediately |
| `fetch` | `fetch + merge` |

**Best practice:** Always `git pull` before starting work and before `git push`.

---

# 24. restore

**Purpose:** **Undo changes in files** (introduced in Git 2.23 as a clear replacement for confusing `checkout`/`reset` usage on files).

**Syntax**
```bash
git restore file.txt                         # discard unstaged changes (working dir → last staged/commit state)
git restore .                                # discard all unstaged changes
git restore --staged file.txt                # unstage (keep changes in working dir)
git restore --source=HEAD~2 file.txt         # bring file from 2 commits ago
git restore --source=abc1234 file.txt        # from a specific commit
```

**Scenario 1: You messed up a file, want to go back**
```bash
git restore app.js          # ⚠️ changes are lost permanently
```

**Scenario 2: You staged the wrong file**
```bash
git add secret.env          # oops
git restore --staged secret.env
```

**Scenario 3: Recover deleted file**
```bash
rm important.js
git restore important.js    # brought back from last commit
```

**Warning:** `git restore file` on unstaged work cannot be undone — Git has no copy of uncommitted edits.

---

# 25. reset

**Purpose:** **Move the current branch back** to an earlier commit — used to undo commits.

**Three modes (exam favorite)**

| Mode | Commit history | Staging area | Working directory |
|---|---|---|---|
| `--soft` | Moved back | **Kept** (changes staged) | Kept |
| `--mixed` (default) | Moved back | **Cleared** | Kept (changes unstaged) |
| `--hard` | Moved back | Cleared | **Deleted** ⚠️ |

**Syntax**
```bash
git reset --soft  HEAD~1      # undo last commit, keep changes staged
git reset --mixed HEAD~1      # undo last commit, keep changes unstaged (default)
git reset --hard  HEAD~1      # undo last commit AND delete the changes
git reset --hard  abc1234     # go back to specific commit
git reset file.txt            # unstage a file
```
`HEAD~1` = one commit before the latest. `HEAD~3` = three commits back.

**Example**
```
Before: A---B---C---D  (HEAD at D)
After git reset --hard B:  A---B  (C and D gone from branch)
```

**Recover from a bad `--hard` reset**
```bash
git reflog              # find the old commit hash
git reset --hard abc1234
```

**Golden rule:** Use `reset` only on **local, unpushed** commits. For pushed commits use `revert`.

---

# 26. revert

**Purpose:** **Safely undo a commit by creating a NEW commit** that does the exact opposite. History is preserved.

**Syntax**
```bash
git revert HEAD                  # undo last commit
git revert abc1234               # undo a specific commit
git revert HEAD~2..HEAD          # revert a range
git revert --no-commit abc1234   # revert but don't auto-commit
git revert -m 1 <merge-commit>   # revert a merge commit
```

**Example**
```
Before:  A---B---C(bad)
After :  A---B---C(bad)---D(Revert "bad")    ← D cancels C
```
```bash
git revert abc1234
# [main 9f8e7d6] Revert "Add buggy discount logic"
git push origin main
```

**reset vs revert (MOST popular interview question)**

| git reset | git revert |
|---|---|
| Moves branch pointer back | Adds a new "undo" commit |
| **Rewrites** history | **Preserves** history |
| Dangerous on pushed/shared code | **Safe** for shared branches |
| Use on local commits | Use on pushed commits |

**Real-world story:** A bad commit reached production at 2 AM. Teammates already pulled it. You must use **revert** (not reset) so everyone's history stays consistent.

---

# 27. stash

**Purpose:** **Temporarily shelve** uncommitted changes so you can switch tasks with a clean working directory, then bring them back later.

**Analogy:** Putting your half-finished work into a **drawer** because your boss gave you an urgent task. Later you take it back out.

**Syntax**
```bash
git stash                          # stash tracked changes
git stash push -m "login WIP"      # with a name
git stash -u                       # include untracked files
git stash list                     # view all stashes
git stash pop                      # apply latest stash AND delete it
git stash apply                    # apply latest stash and KEEP it
git stash apply stash@{1}          # apply a specific one
git stash drop stash@{0}           # delete one
git stash clear                    # delete all
git stash show -p stash@{0}        # see what's inside
git stash branch new-branch        # create branch from stash
```

**Real-world example**
```bash
# You're coding a feature (not ready to commit)...
git stash push -m "half-done search feature"

# Urgent bug! Switch and fix
git switch main
git switch -c hotfix/crash
# ...fix, commit, push, merge...

# Back to your work
git switch feature-search
git stash pop
# continue coding
```

**pop vs apply:** `pop` = apply + remove from list. `apply` = apply + keep in list.

---

# 28. fork

**Purpose:** Creates **your personal copy of someone else's GitHub repository** under your account. Used mainly in **open-source** contribution.

**Analogy:** Photocopying a recipe book so you can write your own changes without touching the original author's book.

**Why fork?** You usually have no write access to someone else's project. Fork gives you your own copy where you can push freely, then you ask the original owner to accept your changes via a **Pull Request**.

**Full open-source workflow**
```bash
# 1. Click "Fork" button on GitHub
# 2. Clone YOUR fork
git clone https://github.com/YOUR-NAME/project.git
cd project

# 3. Add the original repo as 'upstream'
git remote add upstream https://github.com/ORIGINAL-OWNER/project.git

# 4. Create a branch
git switch -c fix-typo

# 5. Make changes, commit, push to YOUR fork
git add .
git commit -m "Fix typo in README"
git push origin fix-typo

# 6. Open a Pull Request on GitHub (fork → original)

# Later: keep your fork updated
git fetch upstream
git switch main
git merge upstream/main
git push origin main
```

**fork vs clone vs branch**

| Term | Where | Meaning |
|---|---|---|
| Fork | GitHub (server side) | Your own copy of another's repo |
| Clone | Local machine | Download repo to your computer |
| Branch | Inside a repo | Separate line of work |

---

# 29. pull request

**Purpose:** A **request** to merge your branch into another branch (e.g., `feature-login` → `main`). It's where **code review** happens. (GitLab calls it *Merge Request*.)

**Analogy:** Submitting your homework to the teacher: "Here's my work. Please review and accept it."

**Flow**
```
1. Create branch        → git switch -c feature/payment
2. Write code + commit  → git commit -m "Add payment API"
3. Push branch          → git push -u origin feature/payment
4. Open Pull Request    → on GitHub (Compare & pull request)
5. Teammates review     → comments, suggestions, approvals
6. CI tests run         → automatic checks (GitHub Actions)
7. Fix feedback         → push more commits (PR updates automatically)
8. Merge PR             → into main
9. Delete branch        → clean up
```

**A good PR contains**
- Clear title: `Add Razorpay payment integration`
- Description: what changed, why, how to test
- Linked issue: `Closes #42`
- Screenshots (for UI)
- Small size (easy to review)

**PR description template**
```markdown
## What
Added payment API using Razorpay.

## Why
Users need to pay online. Fixes #42.

## How to test
1. Add item to cart
2. Click "Pay"
3. Use test card 4111 1111 1111 1111

## Checklist
- [x] Tests added
- [x] No console errors
```

**Merge options on GitHub**

| Option | Result |
|---|---|
| Create a merge commit | Keeps all commits + merge commit |
| Squash and merge | All commits become 1 clean commit |
| Rebase and merge | Commits replayed linearly, no merge commit |

**Interview Q: Why use Pull Requests?**
> They enable code review, catch bugs early, share knowledge, run automated tests, and protect the main branch from unreviewed code.

---

# 30. Real-World Team Workflow

This is the **typical day** of a developer in a company using GitHub (Feature Branch Workflow).

### The Story
> Task from manager: *"Add a 'Forgot Password' feature."* (Ticket **#58**)

### Step-by-step with commands

```bash
# ── STEP 1: Get latest code ─────────────────────────
git switch main
git pull origin main

# ── STEP 2: Create a feature branch ─────────────────
git switch -c feature/58-forgot-password

# ── STEP 3: Write code, check status often ──────────
git status
git diff

# ── STEP 4: Commit in small logical steps ───────────
git add forgot-password.html
git commit -m "Add forgot password page UI"

git add api/reset.js
git commit -m "Add reset password API endpoint"

git add tests/reset.test.js
git commit -m "Add tests for reset password"

# ── STEP 5: Urgent interruption? Use stash ──────────
git stash push -m "email template WIP"
# ...handle the issue...
git stash pop

# ── STEP 6: Sync with latest main before pushing ────
git fetch origin
git rebase origin/main        # or: git merge origin/main
# resolve conflicts if any → git add . → git rebase --continue

# ── STEP 7: Push your branch ────────────────────────
git push -u origin feature/58-forgot-password

# ── STEP 8: Open Pull Request on GitHub ─────────────
#    Title: "Add Forgot Password feature (#58)"
#    Assign reviewers → CI runs automatically

# ── STEP 9: Address review comments ─────────────────
git add .
git commit -m "Address review: validate email format"
git push                      # PR updates automatically

# ── STEP 10: Approved → Merge PR (Squash and merge) ─
# ── STEP 11: Clean up ───────────────────────────────
git switch main
git pull origin main
git branch -d feature/58-forgot-password
git push origin --delete feature/58-forgot-password
```

### Visual Overview
```
 main      ●─────────●──────────────────────●─────────▶  (stable, always deployable)
            \                              /
 feature     ●──●──●──(PR + Review + CI)──●
         (create) (commits)  (push)    (merge)
```

### Branching Strategies Used in Industry

| Strategy | Description | Used by |
|---|---|---|
| **GitHub Flow** | `main` + short feature branches + PRs | Most startups, web apps |
| **Git Flow** | `main`, `develop`, `feature`, `release`, `hotfix` | Large/scheduled-release products |
| **Trunk-Based** | Very short-lived branches, merge daily | Google, Facebook, CI/CD teams |

### Emergency Hotfix Flow
```bash
git switch main
git pull
git switch -c hotfix/payment-crash
# fix bug
git add .
git commit -m "Fix payment crash when cart is empty"
git push -u origin hotfix/payment-crash
# PR → fast review → merge → deploy
```

### Team Best Practices
- **Never** commit directly to `main` (use branch protection rules)
- Pull before you push
- Small, frequent commits with clear messages
- One purpose per branch / PR
- Review others' code kindly and carefully
- Never commit secrets (`.env`, passwords, API keys)
- Use `.gitignore`
- Link PRs to issues (`Closes #58`)

---

# 31. Quick Cheat Sheet

### Setup & Start
```bash
git config --global user.name "Name"
git config --global user.email "mail@x.com"
git init                    # new repo
git clone <url>             # copy repo
```

### Daily Cycle
```bash
git status                  # what changed?
git add .                   # stage
git commit -m "msg"         # save
git log --oneline           # history
git diff                    # see changes
```

### Branching
```bash
git branch                  # list
git switch -c new-branch    # create + move
git switch main             # move
git merge new-branch        # combine
git branch -d new-branch    # delete
```

### Remote
```bash
git remote add origin <url>
git push -u origin main
git fetch
git pull
```

### Undo Tools

| Situation | Command |
|---|---|
| Discard edits in a file | `git restore file` |
| Unstage a file | `git restore --staged file` |
| Fix last commit message | `git commit --amend` |
| Undo last commit, keep code | `git reset --soft HEAD~1` |
| Undo last commit, delete code | `git reset --hard HEAD~1` |
| Undo a pushed commit safely | `git revert <hash>` |
| Save work temporarily | `git stash` / `git stash pop` |
| Recover "lost" commits | `git reflog` |

---

# 32. Top Interview Questions

**Q1. Difference between Git and GitHub?**
Git is a local version control tool; GitHub is a cloud platform for hosting Git repositories with collaboration features.

**Q2. Explain the three areas of Git.**
Working directory (edit files) → Staging area (select changes) → Repository (committed history).

**Q3. `git fetch` vs `git pull`?**
Fetch downloads only; pull = fetch + merge.

**Q4. `git merge` vs `git rebase`?**
Merge keeps history and adds a merge commit; rebase rewrites commits to create a linear history. Don't rebase shared branches.

**Q5. `git reset` vs `git revert`?**
Reset moves the branch back (rewrites history, for local use). Revert creates a new undoing commit (safe for pushed code).

**Q6. Explain `reset --soft`, `--mixed`, `--hard`.**
Soft keeps changes staged, mixed keeps changes unstaged, hard deletes the changes.

**Q7. What is a merge conflict and how do you solve it?**
When two branches edit the same lines. Open the file, choose the correct code, remove markers, `git add`, `git commit`.

**Q8. What is `git stash` and when do you use it?**
Temporarily saves uncommitted work so you can switch context; restore with `git stash pop`.

**Q9. What is HEAD?**
A pointer to the currently checked-out commit/branch.

**Q10. What is `origin`?**
The default name of the remote repository from which you cloned.

**Q11. Fork vs Clone?**
Fork = server-side copy on GitHub under your account. Clone = local download to your computer.

**Q12. What is a Pull Request?**
A request to merge a branch into another, used for review, discussion and CI checks.

**Q13. How do you undo `git add`?**
`git restore --staged <file>` (or older: `git reset <file>`).

**Q14. How do you delete a branch locally and remotely?**
```bash
git branch -d feature        # local
git push origin --delete feature   # remote
```

**Q15. How do you recover a deleted commit or branch?**
Use `git reflog` to find the hash, then `git switch -c recovered <hash>` or `git reset --hard <hash>`.

**Q16. What is `.gitignore`?**
A file listing patterns of files Git should not track (e.g., `node_modules/`, `.env`, `*.log`).

**Q17. What is a detached HEAD?**
When HEAD points directly to a commit instead of a branch. Commits made here can be lost unless you create a branch: `git switch -c new-branch`.

**Q18. What is `git cherry-pick`?** *(bonus)*
Applies one specific commit from another branch onto the current branch: `git cherry-pick <hash>`.

**Q19. What is a tag?** *(bonus)*
A fixed label for a commit, usually for releases: `git tag v1.0.0` then `git push --tags`.

**Q20. How do you write a good commit?**
Small, focused, one logical change, imperative present-tense message that explains what and why.

---

## Final Study Tips

1. **Practice, don't just read.** Create a test repo and run every command once.
2. **Memorize the flow:** `Edit → add → commit → push → Pull Request → merge`.
3. **Know the pairs:** fetch/pull, merge/rebase, reset/revert, fork/clone, Git/GitHub.
4. **Explain with an analogy** in interviews: shopping cart (staging), save point (commit), parallel universe (branch), drawer (stash).
5. **Always mention safety:** "I avoid force-pushing to shared branches" shows maturity.

> **Good luck with your exams and interviews! 🚀**
