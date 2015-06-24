package com.academy.patterns.visitor;

/**
 * Created by keos on 24.06.15.
 */
public class App {

    public static void main(String[] args) {
        // Visitor позволяет применить его методы к [отдельным] нодам структуры
        // При этом новые методы можно добавлять без изменения интерфейса ноды
        // Однако сам интерфейс посетителя тоже должен быть такимм, чтобы ноды его поддерживали
        // А уж конкретная реализация может быть какой угодно, главное что эта реализация применима к определенным нодам

        Commander commander = new Commander(new ArtillerySquad(), new InfantrySquad());

        Visitor infantryVisitor = new Visitor() {
            @Override
            public void visitCommander() {

            }

            @Override
            public void visitArtillery() {

            }

            @Override
            public void visitInfantry() {
                System.out.println("HELLO, INFANTRY SQUAD!");
            }
        };

        Visitor artilleryVisitor = new Visitor() {
            @Override
            public void visitCommander() {

            }

            @Override
            public void visitArtillery() {
                System.out.println("HELLO, ARTILLERY SQUAD!");
            }

            @Override
            public void visitInfantry() {

            }
        };

        Visitor commanderVisitor = new Visitor() {
            @Override
            public void visitCommander() {
                System.out.println("GREETINGS COMMANDER!");
            }

            @Override
            public void visitArtillery() {

            }

            @Override
            public void visitInfantry() {

            }
        };

        commander.accept(commanderVisitor);
        commander.accept(infantryVisitor);
        commander.accept(artilleryVisitor);
    }
}
