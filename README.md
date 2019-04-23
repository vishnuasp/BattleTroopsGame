# BattleTroopsGame

Description: A two player Battle Game with players having their armies of troops fighting each other.
The troop types at the moment are: Monkeys, Flying Monkeys, Wizards and Balloons

Note: This is an eclipse project. It is recommend to import the project to eclipse.

Project Directory structure is as follows:

   BattleTroopsGame
                |
                |
                |---------->battleGame(Package)-----|-----> Troop.java (Base class for all troops)
                |                                   |-----> Monkey.java, Wizard.java, Balloon.java, FlyingMonkey.java (Troops)
                |                                   |-----> BattleGame.java (Has Main method to excecute the code)*
                |                                   |-----> Battle.java (Battle comprises of various components that drives the game)
                |                                   |-----> Player.java (Player participating in the battle)
                |                                   |-----> Type.java (Enum for Troop type ex: AIR or GROUND or ALL)
                |                                   |-----> TroopFactory.java (Factory class to build a required Troop)
                |
                |
                |---------->battleGameTest(Package)-|-----> Tests for all Troops (MonkeyTest, WizardTest, BalloonTest, FlyingMonkeyTest)
                     (Test Suit for all Classes)    |-----> Tests for Battle.java
                                                    |-----> Tests for Player.java
                                                    |-----> Tests for TroopFactory.java
                                                    
                                                    
 To execute the code:
 1. Import the project in eclipse
 2. Open BattleGame.java, this class has Main method which initializes required objects and commences the Battle between two players.
 3. Default case is provided, where two players are given troop creation pattern and army size. Then creation of armies is done.
 4. You can change the creation patterns and size of the army to see various scenarios. 
 5. After a battle ends, winner's army is displayed along with the outstanding troop in the surviving army. (If winner could be determined)
 6. The test cases are covered in the batteGameTest package.
 
