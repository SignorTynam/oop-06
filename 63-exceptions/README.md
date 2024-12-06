# ESERCIZIO 3: Playground delle eccezioni

| [<< Esercizio 2](../62-use-lists-and-maps/README.md) | [Laboratorio 7](../README.md) | [Esercizio 4 >>](../64-design-with-maps/README.md) |

## FASE 1

### Verifica della correttezza degli argomenti e lancio di RuntimeExceptions

All'interno del costruttore `ServiceBehindUnstableNetwork(double, int)`,
aggiungi un controllo che la probabilità sia compresa tra 0 (incluso) e 1 (escluso).
Se il controllo fallisce, deve lanciare un `IllegalArgumentException` con un messaggio appropriato.

### Gestione delle eccezioni esistenti

Implementa i metodi `UseArithmeticService.retrySendOnNetworkError`
e `UseArithmeticService.retryReceiveOnNetworkError`
come descritto nel codice sorgente.

### Progettazione di nuove eccezioni

Crea una `NetworkException extends IOException` con due costruttori.
Il costruttore senza argomenti deve creare un'eccezione con il messaggio "Errore di rete: nessuna risposta".
Il costruttore con un argomento deve prendere una stringa come input e creare un messaggio "Errore di rete durante l'invio del messaggio: `<messaggio>`"

Modifica `ServiceBehindUnstableNetwork.accessTheNetwork()`
in modo che lanci la nuova eccezione.
Nota che i blocchi che catturavano `IOException` funzionano ancora.

### Verifica della correttezza degli argomenti e preservazione dello stacktrace sui rilanci

Modifica `ServiceBehindUnstableNetwork.sendData` in modo che,
invece di stampare, lanci un `IllegalArgumentException` con lo stesso messaggio.

**Nota:** la nuova eccezione lanciata deve *preservare* lo stacktrace dell'eccezione originale
`NumberFormatException` (che deve essere impostata come causa dell'eccezione).

### Uso delle eccezioni per segnalare stati eccezionali

Rimuovi tutti i `println` da `ArithmeticService`: quando il sistema entra in uno stato incoerente,
deve essere lanciata un'`IllegalStateException` con lo stesso messaggio della stampa.
Ricorda di preservare lo stacktrace delle eccezioni causa, se presenti.

### Uso di `finally` per eseguire anche dopo il `return`

Modifica `ArithmeticService.process()`:
indipendentemente da tutto, una volta che il flusso di controllo esce dal metodo,
`commandQueue.clear()` deve essere eseguito.

Suggerimento: usa `finally` in modo appropriato.
