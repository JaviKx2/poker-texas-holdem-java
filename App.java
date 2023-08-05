import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Texas Holdem!");
        int turn = 0;
        Map<Integer, String> cardMap = new HashMap<>();
        cardMap.put(0, "2h");
        cardMap.put(1, "3h");
        cardMap.put(2, "4h");
        cardMap.put(3, "5h");
        cardMap.put(4, "6h");
        cardMap.put(5, "7h");
        cardMap.put(6, "8h");
        cardMap.put(7, "9h");
        cardMap.put(8, "10h");
        cardMap.put(9, "Jh");
        cardMap.put(10, "Qh");
        cardMap.put(11, "Kh");
        cardMap.put(12, "Ah");
        cardMap.put(13, "2d");
        cardMap.put(14, "3d");
        cardMap.put(15, "4d");
        cardMap.put(16, "5d");
        cardMap.put(17, "6d");
        cardMap.put(18, "7d");
        cardMap.put(19, "8d");
        cardMap.put(20, "9d");
        cardMap.put(21, "10d");
        cardMap.put(22, "Jd");
        cardMap.put(23, "Qd");
        cardMap.put(24, "Kd");
        cardMap.put(25, "Ad");
        cardMap.put(26, "2s");
        cardMap.put(27, "3s");
        cardMap.put(28, "4s");
        cardMap.put(29, "5s");
        cardMap.put(30, "6s");
        cardMap.put(31, "7s");
        cardMap.put(32, "8s");
        cardMap.put(33, "9s");
        cardMap.put(34, "10s");
        cardMap.put(35, "Js");
        cardMap.put(36, "Qs");
        cardMap.put(37, "Ks");
        cardMap.put(38, "As");
        cardMap.put(39, "2c");
        cardMap.put(40, "3c");
        cardMap.put(41, "4c");
        cardMap.put(42, "5c");
        cardMap.put(43, "6c");
        cardMap.put(44, "7c");
        cardMap.put(45, "8c");
        cardMap.put(46, "9c");
        cardMap.put(47, "10c");
        cardMap.put(48, "Jc");
        cardMap.put(49, "Qc");
        cardMap.put(50, "Kc");
        cardMap.put(51, "Ac");

        Map<Integer, String> handMap = new HashMap<>();
        handMap.put(1, "High Card");
        handMap.put(2, "Pair");
        handMap.put(3, "Two Pair");
        handMap.put(4, "Three of a Kind");
        handMap.put(5, "Straight");
        handMap.put(6, "Flush");
        handMap.put(7, "Full House");
        handMap.put(8, "Four of a Kind");
        handMap.put(9, "Straight Flush");
        handMap.put(10, "Royal Flush");

        int[] cardsOnTable = new int[5];
        int[] player1Cards = new int[2];
        int[] player2Cards = new int[2];
        int player1chips = 100;
        int player2chips = 100;
        int[] cardsInPlay = new int[9];

        boolean gameEnd = false;
        Scanner scanner = new Scanner(System.in);
        do {
            int[] deckCards = new int[52];
            // initialize deck
            for (int i = 0; i < 52; i++) {
                deckCards[i] = i;
            }
            System.out.println("Shuffling deck...");
            for (int i = 0; i < 52; i++) {
                int rand = (int) (Math.random() * 52);
                int temp = deckCards[i];
                deckCards[i] = deckCards[rand];
                deckCards[rand] = temp;
            }
            System.out.println("Dealing cards to each player...");
            for (int i = 0; i < 2; i++) {
                player1Cards[i] = deckCards[i];
                player2Cards[i] = deckCards[i + 2];
                cardsInPlay[i] = deckCards[i];
                cardsInPlay[i + 2] = deckCards[i + 2];
            }

            // Print player 1 cards
            System.out.print("Player 1 cards: ");
            for (int i = 0; i < 2; i++) {
                System.out.printf("[%s]", cardMap.get(player1Cards[i]));
            }
            System.out.println();

            // Print player 2 cards
            System.out.print("Player 2 cards: ");
            for (int i = 0; i < 2; i++) {
                System.out.printf("[%s]", cardMap.get(player2Cards[i]));
            }
            System.out.println();

            int pot = 0;
            for (int i = 0; i < 4; i++) {
                int player1bet = 0;
                int player2bet = 0;
                int player1latestBet = 0;
                int player2latestBet = 0;
                if (turn == 0) {
                    do {
                        if (player2latestBet != 0) {
                            System.out.println("Player 2 bet " + player2latestBet + ".");
                        }
                        do {
                            System.out.println("Player 1, how much would you like to bet?");
                            player1latestBet = scanner.nextInt();
                            scanner.nextLine();
                        } while (player1latestBet > player1chips || player1latestBet < player2latestBet || (player1latestBet < player2latestBet * 2 && player1bet + player1latestBet != player2bet));
                        player1bet += player1latestBet;
                        System.out.println("Player 1 bet " + player1latestBet + ".");
                        do {
                            System.out.println("Player 2, how much would you like to bet?");
                            player2latestBet = scanner.nextInt();
                            scanner.nextLine();
                        } while (player2latestBet > player2chips || player2latestBet < player1latestBet || (player2latestBet < player1latestBet * 2 && player2bet + player2latestBet != player1bet));
                        player2bet += player2latestBet;
                        System.out.println("Player 1 bet " + player1bet + ".");
                    } while (player1bet != player2bet);
                } else {
                    do {
                        if (player1latestBet != 0) {
                            System.out.println("Player 1 bet " + player1latestBet + ".");
                        }
                        do {
                            System.out.println("Player 2, how much would you like to bet?");
                            player2latestBet = scanner.nextInt();
                            scanner.nextLine();
                        } while (player2bet + player2latestBet > player2chips || player2latestBet < player1latestBet || (player2bet + player2latestBet != player1bet && player2latestBet < player1latestBet * 2));
                        player2bet += player2latestBet;
                        System.out.println("Player 2 bet " + player2latestBet + ".");
                        do {
                            System.out.println("Player 1, how much would you like to bet?");
                            player1latestBet = scanner.nextInt();
                            scanner.nextLine();
                        } while (player1latestBet > player1chips || player1latestBet < player2latestBet || (player1bet + player1latestBet != player2bet && player1latestBet < player2latestBet * 2));
                        player1bet += player1latestBet;
                        System.out.println("Player 2 bet " + player2bet + ".");
                    } while (player1bet != player2bet);
                }
                pot += player1bet + player2bet;

                if (i == 0) {
                    System.out.println("Dealing flop...");
                    for (int f = 0; f < 3; f++) {
                        cardsOnTable[f] = deckCards[f + 4];
                        cardsInPlay[f + 4] = deckCards[f + 4];
                    }
                    System.out.print("Cards on table: ");
                    for (int t = 0; t < 3; t++) {
                        System.out.printf("[%s]", cardMap.get(cardsOnTable[t]));
                    }
                } else if (i == 1) {
                    System.out.println("Dealing turn...");
                    cardsOnTable[3] = deckCards[7];
                    cardsInPlay[7] = deckCards[7];
                    System.out.print("Cards on table: ");
                    for (int t = 0; t < 4; t++) {
                        System.out.printf("[%s]", cardMap.get(cardsOnTable[t]));
                    }
                } else if (i == 2) {
                    System.out.println("Dealing river...");
                    cardsOnTable[4] = deckCards[8];
                    cardsInPlay[8] = deckCards[8];
                    System.out.print("Cards on table: ");
                    for (int t = 0; t < 5; t++) {
                        System.out.printf("[%s]", cardMap.get(cardsOnTable[t]));
                    }
                }
                System.out.println();

                if (i == 3) {
                    // Build player1 best hand
                    int[] player1BestHand = new int[7];
                    int[] player1BestHandNormalized = new int[7];
                    System.arraycopy(player1Cards, 0, player1BestHand, 0, 2);
                    System.arraycopy(cardsOnTable, 0, player1BestHand, 2, 5);
                    System.arraycopy(player1BestHand, 0, player1BestHandNormalized, 0, 7);
                    // Build player2 best hand
                    int[] player2BestHand = new int[7];
                    int[] player2BestHandNormalized = new int[7];
                    System.arraycopy(player2Cards, 0, player2BestHand, 0, 2);
                    System.arraycopy(cardsOnTable, 0, player2BestHand, 2, 5);
                    System.arraycopy(player2BestHand, 0, player2BestHandNormalized, 0, 7);
                    int[] player1BestHandSuits = new int[7];
                    int[] player2BestHandSuits = new int[7];
                    for (int s = 0; s < 7; s++) {
                        if (player1BestHand[s] < 13) {
                            player1BestHandSuits[s] = 0;
                        } else if (player1BestHandNormalized[s] < 26) {
                            player1BestHandSuits[s] = 1;
                        } else if (player1BestHandNormalized[s] < 39) {
                            player1BestHandSuits[s] = 2;
                        } else {
                            player1BestHandSuits[s] = 3;
                        }
                        if (player2BestHand[s] < 13) {
                            player2BestHandSuits[s] = 0;
                        } else if (player2BestHand[s] < 26) {
                            player2BestHandSuits[s] = 1;
                        } else if (player2BestHand[s] < 39) {
                            player2BestHandSuits[s] = 2;
                        } else {
                            player2BestHandSuits[s] = 3;
                        }
                    }
                    // Normalize values of player1BestHandNormalized
                    for (int j = 0; j < 7; j++) {
                        player1BestHandNormalized[j] = player1BestHandNormalized[j] % 13;
                        player2BestHandNormalized[j] = player2BestHandNormalized[j] % 13;
                    }
                    // Sort desc player best hands
                    for (int j = 0; j < 7; j++) {
                        for (int k = j + 1; k < 7; k++) {
                            if (player1BestHandNormalized[j] < player1BestHandNormalized[k]) {
                                int temp = player1BestHandNormalized[j];
                                int tempSuit = player1BestHandSuits[j];
                                player1BestHandNormalized[j] = player1BestHandNormalized[k];
                                player1BestHandSuits[j] = player1BestHandSuits[k];
                                player1BestHandNormalized[k] = temp;
                                player1BestHandSuits[k] = tempSuit;
                            }
                            if (player2BestHandNormalized[j] < player2BestHandNormalized[k]) {
                                int temp = player2BestHandNormalized[j];
                                int tempSuit = player2BestHandSuits[j];
                                player2BestHandNormalized[j] = player2BestHandNormalized[k];
                                player2BestHandSuits[j] = player2BestHandSuits[k];
                                player2BestHandNormalized[k] = temp;
                                player2BestHandSuits[k] = tempSuit;
                            }
                        }
                    }
                    int[] player1BestHandSuitsSorted = new int[7];
                    System.arraycopy(player1BestHandSuits, 0, player1BestHandSuitsSorted, 0, 7);
                    int[] player2BestHandSuitsSorted = new int[7];
                    System.arraycopy(player2BestHandSuits, 0, player2BestHandSuitsSorted, 0, 7);
                    // Sort
                    for (int j = 0; j < 7; j++) {
                        for (int k = j + 1; k < 7; k++) {
                            if (player1BestHandSuitsSorted[j] < player1BestHandSuitsSorted[k]) {
                                int temp = player1BestHandSuitsSorted[j];
                                player1BestHandSuitsSorted[j] = player1BestHandSuitsSorted[k];
                                player1BestHandSuitsSorted[k] = temp;
                            }
                            if (player2BestHandSuitsSorted[j] < player2BestHandSuitsSorted[k]) {
                                int temp = player2BestHandSuitsSorted[j];
                                player2BestHandSuitsSorted[j] = player2BestHandSuitsSorted[k];
                                player2BestHandSuitsSorted[k] = temp;
                            }
                        }
                    }


                    int player1BestHandValue = 0;
                    int player1BestHandHighCard = 0;
                    int[] player1BestHandCards = new int[5];
                    for (int k = 0; k < 3; k++) {
                        boolean player1colorStraight = true;
                        int firstCardSuit = player1BestHandSuits[k];
                        for (int j = k + 1; j < k + 4; j++) {
                            if (firstCardSuit != player1BestHandSuits[j]) {
                                player1colorStraight = false;
                                break;
                            }
                        }
                        int firstStraightCard = player1BestHandNormalized[k] % 13;
                        boolean player1straight =
                            (firstStraightCard - player1BestHandNormalized[k + 4] % 13) == 4
                                && (firstStraightCard - player1BestHandNormalized[k + 3] % 13) == 3
                                && (firstStraightCard - player1BestHandNormalized[k + 2] % 13) == 2
                                && (firstStraightCard - player1BestHandNormalized[k + 1] % 13) == 1;
                        if (player1straight && player1colorStraight) {
                            if (player1BestHandNormalized[k] % 13 == 0) {
                                player1BestHandValue = 10;
                            } else {
                                player1BestHandValue = 9;
                            }
                            player1BestHandHighCard = player1BestHandNormalized[k] % 13;
                            player1BestHandCards = new int[5];
                            player1BestHandCards[0] = player1BestHandNormalized[k] + player1BestHandSuits[k] * 13;
                            player1BestHandCards[1] = player1BestHandNormalized[k + 1] + player1BestHandSuits[k + 1] * 13;
                            player1BestHandCards[2] = player1BestHandNormalized[k + 2] + player1BestHandSuits[k + 2] * 13;
                            player1BestHandCards[3] = player1BestHandNormalized[k + 3] + player1BestHandSuits[k + 3] * 13;
                            player1BestHandCards[4] = player1BestHandNormalized[k + 4] + player1BestHandSuits[k + 4] * 13;
                            break;
                        }
                    }
                    if (player1BestHandValue == 0) {
                        for (int k = 0; k < 4; k++) {
                            int card = player1BestHandNormalized[k] % 13;
                            boolean player1poker = (
                                card == player1BestHandNormalized[k + 1] % 13
                                    && card == player1BestHandNormalized[k + 2] % 13
                                    && card == player1BestHandNormalized[k + 3] % 13
                            );
                            if (player1poker) {
                                player1BestHandValue = 8;
                                player1BestHandHighCard = card;
                                player1BestHandCards = new int[4];
                                player1BestHandCards[0] = player1BestHandNormalized[k] + player1BestHandSuits[k] * 13;
                                player1BestHandCards[1] = player1BestHandNormalized[k + 1] + player1BestHandSuits[k + 1] * 13;
                                player1BestHandCards[2] = player1BestHandNormalized[k + 2] + player1BestHandSuits[k + 2] * 13;
                                player1BestHandCards[3] = player1BestHandNormalized[k + 3] + player1BestHandSuits[k + 3] * 13;
                                break;
                            }
                        }
                    }
                    if (player1BestHandValue == 0) {
                        for (int k = 0; k < 3; k++) {
                            if (player1BestHandValue != 0) {
                                break;
                            }
                            int card = player1BestHandNormalized[k] % 13;
                            boolean cardTrio = card == player1BestHandNormalized[k + 1] % 13 && card == player1BestHandNormalized[k + 2] % 13;
                            if (cardTrio) {
                                for (int j = k + 3; j < 6; j++) {
                                    int card2 = player1BestHandNormalized[j] % 13;
                                    boolean cardPair = card2 == player1BestHandNormalized[j + 1] % 13;
                                    if (cardPair) {
                                        player1BestHandValue = 7;
                                        player1BestHandHighCard = card;
                                        player1BestHandCards = new int[5];
                                        player1BestHandCards[0] = player1BestHandNormalized[k] + player1BestHandSuits[k] * 13;
                                        player1BestHandCards[1] = player1BestHandNormalized[k + 1] + player1BestHandSuits[k + 1] * 13;
                                        player1BestHandCards[2] = player1BestHandNormalized[k + 2] + player1BestHandSuits[k + 2] * 13;
                                        player1BestHandCards[3] = player1BestHandNormalized[j] + player1BestHandSuits[j] * 13;
                                        player1BestHandCards[4] = player1BestHandNormalized[j + 1] + player1BestHandSuits[j + 1] * 13;
                                        break;
                                    }
                                }
                            }
                            boolean cardPair = card == player1BestHandNormalized[k + 1] % 13;
                            if (cardPair) {
                                for (int j = k + 2; j < 5; j++) {
                                    int card2 = player1BestHandNormalized[j] % 13;
                                    boolean cardTrio2 = card2 == player1BestHandNormalized[j + 1] % 13 && card2 == player1BestHandNormalized[j + 2] % 13;
                                    if (cardTrio2) {
                                        player1BestHandValue = 7;
                                        player1BestHandHighCard = player1BestHandNormalized[k] % 13;
                                        player1BestHandCards = new int[5];
                                        player1BestHandCards[0] = player1BestHandNormalized[k] + player1BestHandSuits[k] * 13;
                                        player1BestHandCards[1] = player1BestHandNormalized[k + 1] + player1BestHandSuits[k + 1] * 13;
                                        player1BestHandCards[2] = player1BestHandNormalized[k + 2] + player1BestHandSuits[k + 2] * 13;
                                        player1BestHandCards[3] = player1BestHandNormalized[k + 3] + player1BestHandSuits[k + 3] * 13;
                                        player1BestHandCards[4] = player1BestHandNormalized[k + 4] + player1BestHandSuits[k + 4] * 13;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (player1BestHandValue == 0) {
                        for (int k = 0; k < 3; k++) {
                            if (player1BestHandSuitsSorted[k] == player1BestHandSuitsSorted[k + 4]) {
                                player1BestHandValue = 6;
                                player1BestHandHighCard = player1BestHandNormalized[k] % 13;
                                player1BestHandCards = new int[5];
                                player1BestHandCards[0] = player1BestHandNormalized[k] + player1BestHandSuits[k] * 13;
                                player1BestHandCards[1] = player1BestHandNormalized[k + 1] + player1BestHandSuits[k + 1] * 13;
                                player1BestHandCards[2] = player1BestHandNormalized[k + 2] + player1BestHandSuits[k + 2] * 13;
                                player1BestHandCards[3] = player1BestHandNormalized[k + 3] + player1BestHandSuits[k + 3] * 13;
                                player1BestHandCards[4] = player1BestHandNormalized[k + 4] + player1BestHandSuits[k + 4] * 13;
                                break;
                            }
                        }
                    }
                    if (player1BestHandValue == 0) {
                        for (int k = 0; k < 3; k++) {
                            int firstCard = player1BestHandNormalized[k] % 13;
                            if (
                                (firstCard - player1BestHandNormalized[k + 4] % 13) == 4
                                    && (firstCard - player1BestHandNormalized[k + 3] % 13) == 3
                                    && (firstCard - player1BestHandNormalized[k + 2] % 13) == 2
                                    && (firstCard - player1BestHandNormalized[k + 1] % 13) == 1
                            ) {
                                player1BestHandValue = 5;
                                player1BestHandHighCard = firstCard;
                                player1BestHandCards = new int[5];
                                player1BestHandCards[0] = player1BestHandNormalized[k] + player1BestHandSuits[k] * 13;
                                player1BestHandCards[1] = player1BestHandNormalized[k + 1] + player1BestHandSuits[k + 1] * 13;
                                player1BestHandCards[2] = player1BestHandNormalized[k + 2] + player1BestHandSuits[k + 2] * 13;
                                player1BestHandCards[3] = player1BestHandNormalized[k + 3] + player1BestHandSuits[k + 3] * 13;
                                player1BestHandCards[4] = player1BestHandNormalized[k + 4] + player1BestHandSuits[k + 4] * 13;
                                break;
                            }
                        }
                    }
                    if (player1BestHandValue == 0) {
                        for (int k = 0; k < 5; k++) {
                            int firstCard = player1BestHandNormalized[k] % 13;
                            if (firstCard == player1BestHandNormalized[k + 1] % 13 && firstCard == player1BestHandNormalized[k + 2] % 13) {
                                player1BestHandValue = 4;
                                player1BestHandHighCard = firstCard;
                                player1BestHandCards = new int[3];
                                player1BestHandCards[0] = player1BestHandNormalized[k] + player1BestHandSuits[k] * 13;
                                player1BestHandCards[1] = player1BestHandNormalized[k + 1] + player1BestHandSuits[k + 1] * 13;
                                player1BestHandCards[2] = player1BestHandNormalized[k + 2] + player1BestHandSuits[k + 2] * 13;
                                break;
                            }
                        }
                    }
                    if (player1BestHandValue == 0) {
                        for (int k = 0; k < 4; k++) {
                            int firstPairCard = player1BestHandNormalized[k] % 13;
                            int secondPairCard = player1BestHandNormalized[k + 2] % 13;
                            if (firstPairCard == player1BestHandNormalized[k + 1] % 13 && secondPairCard == player1BestHandNormalized[k + 3] % 13) {
                                player1BestHandValue = 3;
                                player1BestHandHighCard = firstPairCard;
                                player1BestHandCards = new int[4];
                                player1BestHandCards[0] = player1BestHandNormalized[k] + player1BestHandSuits[k] * 13;
                                player1BestHandCards[1] = player1BestHandNormalized[k + 1] + player1BestHandSuits[k + 1] * 13;
                                player1BestHandCards[2] = player1BestHandNormalized[k + 2] + player1BestHandSuits[k + 2] * 13;
                                player1BestHandCards[3] = player1BestHandNormalized[k + 3] + player1BestHandSuits[k + 3] * 13;
                                break;
                            }
                        }
                    }
                    if (player1BestHandValue == 0) {
                        for (int k = 0; k < 6; k++) {
                            if (player1BestHandNormalized[k] % 13 == player1BestHandNormalized[k + 1] % 13) {
                                player1BestHandValue = 2;
                                player1BestHandHighCard = player1BestHandNormalized[k] % 13;
                                player1BestHandCards = new int[2];
                                player1BestHandCards[0] = player1BestHandNormalized[k] + player1BestHandSuits[k] * 13;
                                player1BestHandCards[1] = player1BestHandNormalized[k + 1] + player1BestHandSuits[k + 1] * 13;
                                break;
                            }
                        }
                    }
                    if (player1BestHandValue == 0) {
                        player1BestHandValue = 1;
                        player1BestHandHighCard = player1BestHandNormalized[0] % 13;
                        player1BestHandCards[0] = player1BestHandNormalized[0];
                    }

                    int player2BestHandValue = 0;
                    int player2BestHandHighCard = 0;
                    int[] player2BestHandCards = new int[0];
                    for (int k = 0; k < 3; k++) {
                        boolean player2colorStraight = true;
                        int firstCardSuit = player2BestHandSuits[k];
                        for (int j = k + 1; j < k + 4; j++) {
                            if (firstCardSuit != player2BestHandSuits[j]) {
                                player2colorStraight = false;
                                break;
                            }
                        }
                        int firstStraightCard = player2BestHandNormalized[k] % 13;
                        boolean player2straight =
                            (firstStraightCard - player2BestHandNormalized[k + 4] % 13) == 4
                                && (firstStraightCard - player2BestHandNormalized[k + 3] % 13) == 3
                                && (firstStraightCard - player2BestHandNormalized[k + 2] % 13) == 2
                                && (firstStraightCard - player2BestHandNormalized[k + 1] % 13) == 1;
                        if (player2straight && player2colorStraight) {
                            if (player2BestHandNormalized[k] % 13 == 0) {
                                player2BestHandValue = 10;
                            } else {
                                player2BestHandValue = 9;
                            }
                            player2BestHandHighCard = player2BestHandNormalized[k] % 13;
                            player2BestHandCards = new int[5];
                            player2BestHandCards[0] = player2BestHandNormalized[k] + player2BestHandSuits[k] * 13;
                            player2BestHandCards[1] = player2BestHandNormalized[k + 1] + player2BestHandSuits[k + 1] * 13;
                            player2BestHandCards[2] = player2BestHandNormalized[k + 2] + player2BestHandSuits[k + 2] * 13;
                            player2BestHandCards[3] = player2BestHandNormalized[k + 3] + player2BestHandSuits[k + 3] * 13;
                            player2BestHandCards[4] = player2BestHandNormalized[k + 4] + player2BestHandSuits[k + 4] * 13;
                            break;
                        }
                    }
                    if (player2BestHandValue == 0) {
                        for (int k = 0; k < 4; k++) {
                            int card = player2BestHandNormalized[k] % 13;
                            boolean player2poker = (
                                card == player2BestHandNormalized[k + 1] % 13
                                    && card == player2BestHandNormalized[k + 2] % 13
                                    && card == player2BestHandNormalized[k + 3] % 13
                            );
                            if (player2poker) {
                                player2BestHandValue = 8;
                                player2BestHandHighCard = card;
                                player2BestHandCards = new int[4];
                                player2BestHandCards[0] = player2BestHandNormalized[k] + player2BestHandSuits[k] * 13;
                                player2BestHandCards[1] = player2BestHandNormalized[k + 1] + player2BestHandSuits[k + 1] * 13;
                                player2BestHandCards[2] = player2BestHandNormalized[k + 2] + player2BestHandSuits[k + 2] * 13;
                                player2BestHandCards[3] = player2BestHandNormalized[k + 3] + player2BestHandSuits[k + 3] * 13;
                                break;
                            }
                        }
                    }
                    if (player2BestHandValue == 0) {
                        for (int k = 0; k < 3; k++) {
                            if (player2BestHandValue != 0) {
                                break;
                            }
                            int card = player2BestHandNormalized[k] % 13;
                            boolean cardTrio = card == player2BestHandNormalized[k + 1] % 13 && card == player2BestHandNormalized[k + 2] % 13;
                            if (cardTrio) {
                                for (int j = k + 3; j < 6; j++) {
                                    int card2 = player2BestHandNormalized[j] % 13;
                                    boolean cardPair = card2 == player2BestHandNormalized[j + 1] % 13;
                                    if (cardPair) {
                                        player2BestHandValue = 7;
                                        player2BestHandHighCard = card;
                                        player2BestHandCards = new int[5];
                                        player2BestHandCards[0] = player2BestHandNormalized[k] + player2BestHandSuits[k] * 13;
                                        player2BestHandCards[1] = player2BestHandNormalized[k + 1] + player2BestHandSuits[k + 1] * 13;
                                        player2BestHandCards[2] = player2BestHandNormalized[k + 2] + player2BestHandSuits[k + 2] * 13;
                                        player2BestHandCards[3] = player2BestHandNormalized[j] + player2BestHandSuits[j] * 13;
                                        player2BestHandCards[4] = player2BestHandNormalized[j + 1] + player2BestHandSuits[j + 1] * 13;
                                        break;
                                    }
                                }
                            }
                            boolean cardPair = card == player2BestHandNormalized[k + 1] % 13;
                            if (cardPair) {
                                for (int j = k + 2; j < 5; j++) {
                                    int card2 = player2BestHandNormalized[j] % 13;
                                    boolean cardTrio2 = card2 == player2BestHandNormalized[j + 1] % 13 && card2 == player2BestHandNormalized[j + 2] % 13;
                                    if (cardTrio2) {
                                        player2BestHandValue = 7;
                                        player2BestHandHighCard = player2BestHandNormalized[k] % 13;
                                        player2BestHandCards = new int[5];
                                        player2BestHandCards[0] = player2BestHandNormalized[k] + player2BestHandSuits[k] * 13;
                                        player2BestHandCards[1] = player2BestHandNormalized[k + 1] + player2BestHandSuits[k + 1] * 13;
                                        player2BestHandCards[2] = player2BestHandNormalized[k + 2] + player2BestHandSuits[k + 2] * 13;
                                        player2BestHandCards[3] = player2BestHandNormalized[k + 3] + player2BestHandSuits[k + 3] * 13;
                                        player2BestHandCards[4] = player2BestHandNormalized[k + 4] + player2BestHandSuits[k + 4] * 13;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (player2BestHandValue == 0) {
                        for (int k = 0; k < 3; k++) {
                            if (player2BestHandSuitsSorted[k] == player2BestHandSuitsSorted[k + 4]) {
                                player2BestHandValue = 6;
                                player2BestHandHighCard = player2BestHandNormalized[k] % 13;
                                player2BestHandCards = new int[5];
                                player2BestHandCards[0] = player2BestHandNormalized[k] + player2BestHandSuits[k] * 13;
                                player2BestHandCards[1] = player2BestHandNormalized[k + 1] + player2BestHandSuits[k + 1] * 13;
                                player2BestHandCards[2] = player2BestHandNormalized[k + 2] + player2BestHandSuits[k + 2] * 13;
                                player2BestHandCards[3] = player2BestHandNormalized[k + 3] + player2BestHandSuits[k + 3] * 13;
                                player2BestHandCards[4] = player2BestHandNormalized[k + 4] + player2BestHandSuits[k + 4] * 13;
                                break;
                            }
                        }
                    }
                    if (player2BestHandValue == 0) {
                        for (int k = 0; k < 3; k++) {
                            int firstCard = player2BestHandNormalized[k] % 13;
                            if (
                                (firstCard - player2BestHandNormalized[k + 4] % 13) == 4
                                    && (firstCard - player2BestHandNormalized[k + 3] % 13) == 3
                                    && (firstCard - player2BestHandNormalized[k + 2] % 13) == 2
                                    && (firstCard - player2BestHandNormalized[k + 1] % 13) == 1
                            ) {
                                player2BestHandValue = 5;
                                player2BestHandHighCard = firstCard;
                                player2BestHandCards = new int[5];
                                player2BestHandCards[0] = player2BestHandNormalized[k] + player2BestHandSuits[k] * 13;
                                player2BestHandCards[1] = player2BestHandNormalized[k + 1] + player2BestHandSuits[k + 1] * 13;
                                player2BestHandCards[2] = player2BestHandNormalized[k + 2] + player2BestHandSuits[k + 2] * 13;
                                player2BestHandCards[3] = player2BestHandNormalized[k + 3] + player2BestHandSuits[k + 3] * 13;
                                player2BestHandCards[4] = player2BestHandNormalized[k + 4] + player2BestHandSuits[k + 4] * 13;
                                break;
                            }
                        }
                    }
                    if (player2BestHandValue == 0) {
                        for (int k = 0; k < 5; k++) {
                            int firstCard = player2BestHandNormalized[k] % 13;
                            if (firstCard == player2BestHandNormalized[k + 1] % 13 && firstCard == player2BestHandNormalized[k + 2] % 13) {
                                player2BestHandValue = 4;
                                player2BestHandHighCard = firstCard;
                                player2BestHandCards = new int[3];
                                player2BestHandCards[0] = player2BestHandNormalized[k] + player2BestHandSuits[k] * 13;
                                player2BestHandCards[1] = player2BestHandNormalized[k + 1] + player2BestHandSuits[k + 1] * 13;
                                player2BestHandCards[2] = player2BestHandNormalized[k + 2] + player2BestHandSuits[k + 2] * 13;
                                break;
                            }
                        }
                    }
                    if (player2BestHandValue == 0) {
                        for (int k = 0; k < 4; k++) {
                            int firstPairCard = player2BestHandNormalized[k] % 13;
                            int secondPairCard = player2BestHandNormalized[k + 2] % 13;
                            if (firstPairCard == player2BestHandNormalized[k + 1] % 13 && secondPairCard == player2BestHandNormalized[k + 3] % 13) {
                                player2BestHandValue = 3;
                                player2BestHandHighCard = firstPairCard;
                                player2BestHandCards = new int[4];
                                player2BestHandCards[0] = player2BestHandNormalized[k] + player2BestHandSuits[k] * 13;
                                player2BestHandCards[1] = player2BestHandNormalized[k + 1] + player2BestHandSuits[k + 1] * 13;
                                player2BestHandCards[2] = player2BestHandNormalized[k + 2] + player2BestHandSuits[k + 2] * 13;
                                player2BestHandCards[3] = player2BestHandNormalized[k + 3] + player2BestHandSuits[k + 3] * 13;
                                break;
                            }
                        }
                    }
                    if (player2BestHandValue == 0) {
                        for (int k = 0; k < 6; k++) {
                            if (player2BestHandNormalized[k] % 13 == player2BestHandNormalized[k + 1] % 13) {
                                player2BestHandValue = 2;
                                player2BestHandHighCard = player2BestHandNormalized[k] % 13;
                                player2BestHandCards = new int[2];
                                player2BestHandCards[0] = player2BestHandNormalized[k] + player2BestHandSuits[k] * 13;
                                player2BestHandCards[1] = player2BestHandNormalized[k + 1] + player2BestHandSuits[k + 1] * 13;
                                break;
                            }
                        }
                    }
                    if (player2BestHandValue == 0) {
                        player2BestHandValue = 1;
                        player2BestHandHighCard = player2BestHandNormalized[0] % 13;
                        player2BestHandCards[0] = player2BestHandNormalized[0];
                    }

                    System.out.print("Player 1 hand : " + handMap.get(player1BestHandValue));
                    for (int player1BestHandCard : player1BestHandCards) {
                        System.out.print("[" + cardMap.get(player1BestHandCard) + "]");
                    }
                    System.out.println();
                    System.out.print("Player 2 hand : " + handMap.get(player2BestHandValue));
                    for (int player2BestHandCard : player2BestHandCards) {
                        System.out.print("[" + cardMap.get(player2BestHandCard) + "]");
                    }
                    System.out.println();

                    if (player1BestHandValue > player2BestHandValue) {
                        player1chips += pot / 2;
                        player2chips -= pot / 2;
                        System.out.println("Player 1 gets the pot. Current chips : " + player1chips);
                        System.out.println("Player 2 loses chips. Current chips : " + player2chips);

                    } else if (player1BestHandValue < player2BestHandValue) {
                        player2chips += pot / 2;
                        player1chips -= pot / 2;
                        System.out.println("Player 2 gets the pot. Current chips : " + player2chips);
                        System.out.println("Player 1 loses chips. Current chips : " + player1chips);
                    } else {
                        if (player1BestHandHighCard > player2BestHandHighCard) {
                            player1chips += pot / 2;
                            player2chips -= pot / 2;
                            System.out.println("Player 1 gets the pot. Current chips : " + player1chips);
                            System.out.println("Player 2 loses chips. Current chips : " + player2chips);
                        } else if (player1BestHandHighCard < player2BestHandHighCard) {
                            player2chips += pot / 2;
                            player1chips -= pot / 2;
                            System.out.println("Player 2 gets the pot. Current chips : " + player2chips);
                            System.out.println("Player 1 loses chips. Current chips : " + player1chips);
                        } else {
                            System.out.println("Split pot!");
                            System.out.println("Player 1 gets half the pot. Current chips : " + player1chips);
                            System.out.println("Player 2 gets half the pot. Current chips : " + player2chips);
                        }
                    }

                    // End game if a player run out of chips
                    if (player1chips == 0 || player2chips == 0) {
                        gameEnd = true;
                    }
                }
                turn = (turn + 1) % 2;
            }

            if (player1chips == 0) {
                System.out.println("Player 2 wins!");
            } else if (player2chips == 0) {
                System.out.println("Player 1 wins!");
            }
        } while (!gameEnd);
        scanner.close();
    }
}
