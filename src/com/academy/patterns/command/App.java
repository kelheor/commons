package com.academy.patterns.command;

/**
 * Created by Kelheor on 27.06.2015.
 */
public class App {

    public static void main(String[] args) {
        // Команда инкапсулирует запрос в объекте, который потом легко передать куда угодно и выполнить нужный запрос
        // в нужном месте. Кроме того у команды есть операция undo и по хорошему тот, кто команды выполняет, должен
        // вести историю изменений, чтобы была возможность откатить изменения.

        CommandExecutor commandExecutor = new CommandExecutor();
        EnemyCruiser enemyCruiser = new EnemyCruiser();

        enemyCruiser.printStatus();

        commandExecutor.execute(new RocketAttack(), enemyCruiser);

        enemyCruiser.printStatus();

        commandExecutor.undoLastSpell();

        enemyCruiser.printStatus();

        commandExecutor.redoLastSpell();

        enemyCruiser.printStatus();
    }
}
