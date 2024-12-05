# ESERCIZIO 1: Esercizio di risoluzione di un merge conflict

| | [<< Laboratorio 7](../README.md) | [Esercizio 1 >>](./61-git-remotes-merge-conflict/README.md) |

## FASE 1

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti <https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test>.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository:

   ```git
   git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git
   cd OOP-git-merge-conflict-test
   git status
   ```

2. Ci si assicuri di avere localmente entrambi i branch remoti

   ```git
   git branch -r
   ```

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master` e da qui si esegua il merge di `feature`.

   ```git
   git merge origin/feature
   ```

4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili (funzionalità presente su `master`) che il nome dell'autore del file (funzionalità presente su `feature`)

   ```git
   git add .
   git commit -m "Fixed the file"
   ```

6. Si crei un nuovo repository nel proprio github personale.
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote.

   ```git
   git remote add personal https://github.com/SignorTynam/oop-git-merge-conflict-solution.git
   git remove -v
   ```

8. Si faccia push del branch `master` sul proprio repository

   ```git
   git push personal master
   ```

9. Si setti il branch remoto `master` del nuovo repository come _upstream_ per il proprio branch `master` locale.

   ```git
   git branch --set-upstream-to=personal/master master
   ```
