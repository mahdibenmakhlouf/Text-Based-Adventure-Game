import java.util.Random;
import java.util.Scanner;;

public class TextBasedAdventureGame {
    public static void main(String args[]) {
        String name;
        String place;
        int mountain = 0;
        int cave = 0;
        String choice;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int n;
        String dodge;
        Dargon dragon = new Dargon();
        System.out.println("enter your name : ");
        name = scanner.nextLine();
        System.out.println("Hi " + name + " ,you are in smale villge");
        Player player = new Player(name);
        System.out.println("where do want to go forest , mountain or cave: ");
        place = scanner.nextLine();
        while (!place.equals("forest") && cave + mountain < 2) {
            if (place.equals("cave")) {
                if (cave != 1) {
                    System.out.println("there is a chest do you want to open it : ");
                    choice = scanner.nextLine();
                    cave++;
                    n = random.nextInt(2);
                    if (choice.equals("yes")) {
                        if (n == 1) {
                            System.err.println("oh you got a sord!, now you damage is 20");
                            player.setDamage(20);
                        } else {
                            System.out.println("you are unlucky the chest is empty");
                        }
                    }
                    if (choice.equals("no")) {
                        if (n == 1) {
                            System.out.println("you just miss a sord");
                        } else {
                            System.out.println("you miss nothing the chest is empty");
                        }
                    }
                } else {
                    System.out.println("you can not choose the cave again ");
                }
                if (mountain != 1) {
                    System.out.println("now chosse between the forst or the mountain : ");
                    place = scanner.nextLine();
                }
            } else if (place.equals("mountain")) {
                if (mountain != 1) {
                    System.out.println("there is potion do you do you want to take it : ");
                    choice = scanner.nextLine();
                    mountain++;
                    n = random.nextInt(2);
                    if (choice.equals("yes")) {
                        if (n == 1) {
                            System.err.println("oh you got a shield, now you health is 150 ");
                            player.setHealth(150);
                        } else {
                            System.out.println("you are unlucky it is a poison, now your health is 80");
                            player.setHealth(80);
                        }
                    }
                    if (choice.equals("no")) {
                        if (n == 1) {
                            System.out.println("you just miss a shield");
                        } else {
                            System.out.println("you miss nothing, it is a poison");
                        }
                    }
                } else {
                    System.out.println("you can not choose the mountain again ");
                }
                if (cave != 1) {
                    System.out.println("now chosse between the forest or the cave : ");
                    place = scanner.nextLine();
                }
            } else {
                System.out.println("invalid choice restart the game ");
                if (mountain == 0 && cave == 0) {
                    System.out.println("you can choose only mountain , cave or forest ");
                    place = scanner.nextLine();
                }
                if (mountain == 0 && cave != 0) {
                    System.out.println("you can choose only mountain or forest ");
                    place = scanner.nextLine();
                }
                if (mountain != 0 && cave == 0) {
                    System.out.println("you can choose only cave or forest ");
                    place = scanner.nextLine();
                }
            }
        }
        System.out.println("hhh!I'm the dragon");
        while (player.getHealth() > 0 && dragon.getHealth() > 0) {
            n = random.nextInt(2);
            dragon.setHealth(dragon.getHealth() - player.getDamage());
            System.out.println("do you want to go right or left : ");
            dodge = scanner.nextLine().trim();
            // 0 if the dragon shoot right and 1 if the dragon shoot left
            // this condition to ensure that the player don't hit the player even he die 
            if (dragon.getHealth() > 0) {
                if (n == 0 && dodge.equals("left")) {
                    System.out.println("the dragon shoot and you dodge it");
                } else if (n == 0 && dodge.equals("right")) {
                    System.out.println("the dragon shoot you");
                    player.setHealth(player.getHealth() - dragon.getDamage());
                } else if (n == 1 && dodge.equals("right")) {
                    System.out.println("the dragon shoot and you dodge it");
                } else if (n == 1 && dodge.equals("left")) {
                    System.out.println("the dragon shoot you ");
                    player.setHealth(player.getHealth() - dragon.getDamage());
                } else {
                    System.out.println("invalid choice");
                }
            }
            System.out.println("score: mahdi " + player.getHealth() + " /dragon " + dragon.getHealth());
        }
        if (player.getHealth() <= 0) {
            System.out.println("you lose");
        } else if (dragon.getHealth() <= 0) {
            System.out.println("you win");
        }
    }
}
