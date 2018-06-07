package chess;

import java.util.Scanner;

public class Chess {
	private static Scanner in;

	public static void initialize(char[][] x) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				if (i == 0) {
					if (j == 0 || j == 7) {
						x[i][j] = (char) 9814;
					} else if (j == 1 || j == 6) {
						x[i][j] = (char) 9816;
					} else if (j == 2 || j == 5) {
						x[i][j] = (char) 9815;
					} else if (j == 3) {
						x[i][j] = (char) 9813;
					} else if (j == 4) {
						x[i][j] = (char) 9812;
					}
				} else if (i == 1) {
					x[i][j] = (char) 9817;
				} else if (i == 6) {
					x[i][j] = (char) 9823;
				} else if (i == 7) {
					if (j == 0 || j == 7) {
						x[i][j] = (char) 9820;
					} else if (j == 1 || j == 6) {
						x[i][j] = (char) 9822;
					} else if (j == 2 || j == 5) {
						x[i][j] = (char) 9821;
					} else if (j == 3) {
						x[i][j] = (char) 9819;
					} else if (j == 4) {
						x[i][j] = (char) 9818;
					}
				} else {
					if ((i + j) % 2 == 0) {
						x[i][j] = (char) 57346;
					} else {
						x[i][j] = (char) 57347;
					}
				}
			}
		}
	}

	public static void display(char[][] x) {
		System.out.print("\t\t\t");
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] == (char) 57347 || x[i][j] == (char) 57346) {
					System.out.print(x[i][j]);
				} else {
					System.out.print(x[i][j] + " ");
				}
			}
			if (i != 7) {
				System.out.print("\n\t\t\t");
			}
		}

	}

	public static void main(String[] args) {
		int winState = 0, playerTurn = 1, p = 0;

		King wK = new King((char) 9818, 7, 4, 1);
		Queen wQ = new Queen((char) 9819, 7, 3, 1);
		Rook wR1 = new Rook((char) 9820, 7, 0, 1);
		Rook wR2 = new Rook((char) 9820, 7, 7, 1);
		Bishop wB1 = new Bishop((char) 9821, 7, 2, 1);
		Bishop wB2 = new Bishop((char) 9821, 7, 5, 1);
		Knight wKi1 = new Knight((char) 9822, 7, 1, 1);
		Knight wKi2 = new Knight((char) 9822, 7, 6, 1);
		Pawn wP1 = new Pawn((char) 9823, 6, 0, 1);
		Pawn wP2 = new Pawn((char) 9823, 6, 1, 1);
		Pawn wP3 = new Pawn((char) 9823, 6, 2, 1);
		Pawn wP4 = new Pawn((char) 9823, 6, 3, 1);
		Pawn wP5 = new Pawn((char) 9823, 6, 4, 1);
		Pawn wP6 = new Pawn((char) 9823, 6, 5, 1);
		Pawn wP7 = new Pawn((char) 9823, 6, 6, 1);
		Pawn wP8 = new Pawn((char) 9823, 6, 7, 1);

		// =========================================================================================================================================================
		King bK = new King((char) 9812, 0, 4, 2);
		Queen bQ = new Queen((char) 9813, 0, 3, 2);
		Rook bR1 = new Rook((char) 9814, 0, 0, 2);
		Rook bR2 = new Rook((char) 9814, 0, 7, 2);
		Bishop bB1 = new Bishop((char) 9815, 0, 2, 2);
		Bishop bB2 = new Bishop((char) 9815, 0, 5, 2);
		Knight bKi1 = new Knight((char) 9816, 0, 1, 2);
		Knight bKi2 = new Knight((char) 9816, 0, 6, 2);
		Pawn bP1 = new Pawn((char) 9817, 1, 0, 2);
		Pawn bP2 = new Pawn((char) 9817, 1, 1, 2);
		Pawn bP3 = new Pawn((char) 9817, 1, 2, 2);
		Pawn bP4 = new Pawn((char) 9817, 1, 3, 2);
		Pawn bP5 = new Pawn((char) 9817, 1, 4, 2);
		Pawn bP6 = new Pawn((char) 9817, 1, 5, 2);
		Pawn bP7 = new Pawn((char) 9817, 1, 6, 2);
		Pawn bP8 = new Pawn((char) 9817, 1, 7, 2);
		// ==========================================================================================================================================================
		char Ground[][];
		int nR, nC, rightInput = 0, cR, cC, rR = 0, rC = 0;
		String input = "1";
		in = new Scanner(System.in);
		Ground = new char[8][8];
		initialize(Ground);
		display(Ground);
		int pMoves[][];
		pMoves = new int[8][8];

		while (winState == 0) {
			if (playerTurn == 1) {
				p += wK.possibleMoves(Ground);
				for (int i = 0; i < 5 && p == 0; i++) {
					if (i == 0) {
						if (wQ.symbol == Ground[wQ.currentR][wQ.currentC])
							p += wQ.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (p > 0)
							System.out.print(i);
					} else if (i == 1) {
						if (wR1.symbol == Ground[wR1.currentR][wR1.currentC])
							p += wR1.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (wR1.symbol == Ground[wR2.currentR][wR2.currentC])
							p += wR2.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (p > 0)
							System.out.print(i);
					} else if (i == 2) {
						if (wB1.symbol == Ground[wB1.currentR][wB1.currentC])
							p += wB1.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (wB1.symbol == Ground[wB2.currentR][wB2.currentC])
							p += wB2.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (p > 0)
							System.out.print(i);
					} else if (i == 3) {
						if (wKi1.symbol == Ground[wKi1.currentR][wKi1.currentC])
							p += wKi1.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (wKi1.symbol == Ground[wKi2.currentR][wKi2.currentC])
							p += wKi2.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (p > 0)
							System.out.print(i);
					} else if (i == 4) {
						if (wP1.symbol == Ground[wP1.currentR][wP1.currentC])
							p += wP1.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (wP1.symbol == Ground[wP2.currentR][wP2.currentC])
							p += wP2.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (wP1.symbol == Ground[wP3.currentR][wP3.currentC])
							p += wP3.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (wP1.symbol == Ground[wP4.currentR][wP4.currentC])
							p += wP4.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (wP1.symbol == Ground[wP5.currentR][wP5.currentC])
							p += wP5.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (wP1.symbol == Ground[wP6.currentR][wP6.currentC])
							p += wP6.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (wP1.symbol == Ground[wP7.currentR][wP7.currentC])
							p += wP7.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (wP1.symbol == Ground[wP8.currentC][wP8.currentC])
							p += wP8.possibleMoves(Ground, wK.currentR, wK.currentC);
						if (p > 0)
							System.out.print(i);
					}

				}
				System.out.println(p);
				if (p == 0) {
					System.out.println("Check Mate \nPlayer two won !");
					winState = 1;
					break;
				} else {
					p = 0;
				}
				System.out.print("\n\t\t   Enter the piece co-ordinates:");
				rightInput = 0;
				while (rightInput == 0) {
					while (rR == 0) {
						input = in.nextLine();
						for (int i = 0; i < input.length(); i++) {
							if (input.charAt(i) > '0' && input.charAt(i) <= '8' && input.length() == 1) {
								rR = 1;
							} else {
								rR = 0;
								System.out.println("\ninvalid input !!");
								break;
							}
						}
					}
					cR = Integer.parseInt(input) - 1;
					rR = 0;
					while (rC == 0) {
						input = in.nextLine();
						for (int i = 0; i < input.length(); i++) {
							if (input.charAt(i) > '0' && input.charAt(i) <= '8' && input.length() == 1) {
								rC = 1;
							} else {
								rC = 0;
								System.out.println("\ninvalid input !!");
								break;
							}
						}
					}
					cC = Integer.parseInt(input) - 1;
					rC = 0;
					display(Ground);
					if (Ground[cR][cC] == wK.symbol || Ground[cR][cC] == wQ.symbol || Ground[cR][cC] == wR1.symbol
							|| Ground[cR][cC] == wB1.symbol || Ground[cR][cC] == wKi1.symbol
							|| Ground[cR][cC] == wP1.symbol) {
						System.out.println("\n\t\t   Enter the co-ordinates you want to move your piece to:");
						while (rR == 0) {
							input = in.nextLine();
							for (int i = 0; i < input.length(); i++) {
								if (input.charAt(i) > '0' && input.charAt(i) <= '8' && input.length() == 1) {
									rR = 1;
								} else {
									rR = 0;
									System.out.println("\ninvalid input !!");
									break;
								}
							}
						}
						nR = Integer.parseInt(input) - 1;
						rR = 0;
						while (rC == 0) {
							input = in.nextLine();
							for (int i = 0; i < input.length(); i++) {
								if (input.charAt(i) > '0' && input.charAt(i) <= '8' && input.length() == 1) {
									rC = 1;
								} else {
									rC = 0;
									System.out.println("\ninvalid input !!");
									break;
								}
							}
						}
						nC = Integer.parseInt(input) - 1;
						rC = 0;
						if (Ground[cR][cC] == wK.symbol) {
							pMoves = wK.possibleMovesA(Ground);
							if (pMoves[nR][nC] == 1) {
								wK.changePosition(Ground, nR, nC);
								rightInput = 1;
								playerTurn = 2;
							} else {
								System.out.println("Invalid move");
							}
						} else if (Ground[cR][cC] == wQ.symbol) {
							pMoves = wQ.possibleMovesA(Ground, wK.currentR, wK.currentC);
							if (pMoves[nR][nC] == 1) {
								wQ.changePosition(Ground, nR, nC);
								rightInput = 1;
								playerTurn = 2;
							} else {
								System.out.println("Invalid move");
							}
						} else if (Ground[cR][cC] == wR1.symbol) {
							if (cR == wR1.currentR && cC == wR1.currentC) {
								pMoves = wR1.possibleMovesA(Ground, wK.currentR, wK.currentC);
								if (pMoves[nR][nC] == 1) {
									wR1.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 2;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == wR2.currentR && cC == wR2.currentC) {
								pMoves = wR2.possibleMovesA(Ground, wK.currentR, wK.currentC);
								if (pMoves[nR][nC] == 1) {
									wR2.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 2;
								} else {
									System.out.println("Invalid move");
								}
							}
						} else if (Ground[cR][cC] == wB1.symbol) {
							if (cR == wB1.currentR && cC == wB1.currentC) {
								pMoves = wB1.possibleMovesA(Ground, wK.currentR, wK.currentC);
								if (pMoves[nR][nC] == 1) {
									wB1.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 2;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == wB2.currentR && cC == wB2.currentC) {
								pMoves = wB2.possibleMovesA(Ground, wK.currentR, wK.currentC);
								if (pMoves[nR][nC] == 1) {
									wB2.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 2;
								} else {
									System.out.println("Invalid move");
								}
							}
						} else if (Ground[cR][cC] == wKi1.symbol) {
							if (cR == wKi1.currentR && cC == wKi1.currentC) {
								pMoves = wKi1.possibleMovesA(Ground, wK.currentR, wK.currentC);
								if (pMoves[nR][nC] == 1) {
									wKi1.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 2;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == wKi2.currentR && cC == wKi2.currentC) {
								pMoves = wKi2.possibleMovesA(Ground, wK.currentR, wK.currentC);
								if (pMoves[nR][nC] == 1) {
									wKi2.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 2;
								} else {
									System.out.println("Invalid move");
								}
							}
						} else if (Ground[cR][cC] == wP1.symbol) {
							if (cR == wP1.currentR && cC == wP1.currentC) {
								pMoves = wP1.possibleMovesA(Ground, wK.currentR, wK.currentC);
								if (pMoves[nR][nC] == 1) {
									wP1.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 2;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == wP2.currentR && cC == wP2.currentC) {
								pMoves = wP2.possibleMovesA(Ground, wK.currentR, wK.currentC);
								if (pMoves[nR][nC] == 1) {
									wP2.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 2;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == wP3.currentR && cC == wP3.currentC) {
								pMoves = wP3.possibleMovesA(Ground, wK.currentR, wK.currentC);
								if (pMoves[nR][nC] == 1) {
									wP3.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 2;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == wP4.currentR && cC == wP4.currentC) {
								pMoves = wP4.possibleMovesA(Ground, wK.currentR, wK.currentC);
								if (pMoves[nR][nC] == 1) {
									wP4.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 2;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == wP5.currentR && cC == wP5.currentC) {
								pMoves = wP5.possibleMovesA(Ground, wK.currentR, wK.currentC);
								if (pMoves[nR][nC] == 1) {
									wP5.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 2;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == wP6.currentR && cC == wP6.currentC) {
								pMoves = wP6.possibleMovesA(Ground, wK.currentR, wK.currentC);
								if (pMoves[nR][nC] == 1) {
									wP6.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 2;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == wP7.currentR && cC == wP7.currentC) {
								pMoves = wP7.possibleMovesA(Ground, wK.currentR, wK.currentC);
								if (pMoves[nR][nC] == 1) {
									wP7.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 2;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == wP8.currentR && cC == wP8.currentC) {
								pMoves = wP8.possibleMovesA(Ground, wK.currentR, wK.currentC);
								if (pMoves[nR][nC] == 1) {
									wP8.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 2;
								} else {
									System.out.println("Invalid move");
								}
							}
						} else {
							System.out.println("invalid input!!");
						}
						display(Ground);
					} else {
						System.out.println("invalid input !!");
					}
				}
			} else if (playerTurn == 2) {
				p = 0;
				p += bK.possibleMoves(Ground);
				int i;
				for (i = 0; i < 5 && p == 0; i++) {
					if (i == 0) {
						if (bQ.symbol == Ground[bQ.currentR][bQ.currentC])
							p += bQ.possibleMoves(Ground, bK.currentR, bK.currentC);

					} else if (i == 1) {
						if (bR1.symbol == Ground[bR1.currentR][bR1.currentC])
							p += bR1.possibleMoves(Ground, bK.currentR, bK.currentC);
						if (bR1.symbol == Ground[bR2.currentR][bR2.currentC])
							p += bR2.possibleMoves(Ground, bK.currentR, bK.currentC);

					} else if (i == 2) {
						if (bB1.symbol == Ground[bB1.currentR][bB1.currentC])
							p += bB1.possibleMoves(Ground, bK.currentR, bK.currentC);
						if (bB1.symbol == Ground[bB2.currentR][bB2.currentC])
							p += bB2.possibleMoves(Ground, bK.currentR, bK.currentC);

					} else if (i == 3) {
						if (bKi1.symbol == Ground[bKi1.currentR][bKi1.currentC])
							p += bKi1.possibleMoves(Ground, bK.currentR, bK.currentC);
						if (bKi1.symbol == Ground[bKi2.currentR][bKi2.currentC])
							p += bKi2.possibleMoves(Ground, bK.currentR, bK.currentC);
					} else if (i == 4) {
						if (bP1.symbol == Ground[bP1.currentR][bP1.currentC])
							p += bP1.possibleMoves(Ground, bK.currentR, bK.currentC);
						if (bP1.symbol == Ground[bP2.currentR][bP2.currentC])
							p += bP2.possibleMoves(Ground, bK.currentR, bK.currentC);
						if (bP1.symbol == Ground[bP3.currentR][bP3.currentC])
							p += bP3.possibleMoves(Ground, bK.currentR, bK.currentC);
						if (bP1.symbol == Ground[bP4.currentR][bP4.currentC])
							p += bP4.possibleMoves(Ground, bK.currentR, bK.currentC);
						if (bP1.symbol == Ground[bP5.currentR][bP5.currentC])
							p += bP5.possibleMoves(Ground, bK.currentR, bK.currentC);
						if (bP1.symbol == Ground[bP6.currentR][bP6.currentC])
							p += bP6.possibleMoves(Ground, bK.currentR, bK.currentC);
						if (bP1.symbol == Ground[bP7.currentR][bP7.currentC])
							p += bP7.possibleMoves(Ground, bK.currentR, bK.currentC);
						if (bP1.symbol == Ground[bP8.currentR][bP8.currentC])
							p += bP8.possibleMoves(Ground, bK.currentR, bK.currentC);
					}

				}
				System.out.println(i);
				System.out.println("\n" + p);
				if (p == 0) {
					System.out.println("Check Mate \nPlayer one won !");
					winState = 1;
					break;
				} else {
					p = 0;
				}
				System.out.print("\n\t\t   Enter the piece co-ordinates:");
				rightInput = 0;
				while (rightInput == 0) {
					while (rR == 0) {
						input = in.nextLine();
						for (i = 0; i < input.length(); i++) {
							if (input.charAt(i) > '0' && input.charAt(i) <= '8' && input.length() == 1) {
								rR = 1;
							} else {
								rR = 0;
								System.out.println("\ninvalid input !!");
								break;
							}
						}
					}
					cR = Integer.parseInt(input) - 1;
					rR = 0;
					while (rC == 0) {
						input = in.nextLine();
						for (i = 0; i < input.length(); i++) {
							if (input.charAt(i) > '0' && input.charAt(i) <= '8' && input.length() == 1) {
								rC = 1;
							} else {
								rC = 0;
								System.out.println("\ninvalid input !!");
								break;
							}
						}
					}
					cC = Integer.parseInt(input) - 1;
					rC = 0;
					display(Ground);
					if (Ground[cR][cC] == bK.symbol || Ground[cR][cC] == bQ.symbol || Ground[cR][cC] == bR1.symbol
							|| Ground[cR][cC] == bB1.symbol || Ground[cR][cC] == bKi1.symbol
							|| Ground[cR][cC] == bP1.symbol) {
						System.out.println("\n\t\t   Enter the co-ordinates you want to move your piece to:");
						while (rR == 0) {
							input = in.nextLine();
							for (i = 0; i < input.length(); i++) {
								if (input.charAt(i) > '0' && input.charAt(i) <= '8' && input.length() == 1) {
									rR = 1;
								} else {
									rR = 0;
									System.out.println("\ninvalid input !!");
									break;
								}
							}
						}
						nR = Integer.parseInt(input) - 1;
						rR = 0;
						while (rC == 0) {
							input = in.nextLine();
							for (i = 0; i < input.length(); i++) {
								if (input.charAt(i) > '0' && input.charAt(i) <= '8' && input.length() == 1) {
									rC = 1;
								} else {
									rC = 0;
									System.out.println("\ninvalid input !!");
									break;
								}
							}
						}
						nC = Integer.parseInt(input) - 1;
						rC = 0;
						if (Ground[cR][cC] == bK.symbol) {
							pMoves = bK.possibleMovesA(Ground);
							if (pMoves[nR][nC] == 1) {
								bK.changePosition(Ground, nR, nC);
								rightInput = 1;
								playerTurn = 1;
							} else {
								System.out.println("Invalid move");
							}
						} else if (Ground[cR][cC] == bQ.symbol) {
							pMoves = bQ.possibleMovesA(Ground, bK.currentR, bK.currentC);
							if (pMoves[nR][nC] == 1) {
								bQ.changePosition(Ground, nR, nC);
								rightInput = 1;
								playerTurn = 1;
							} else {
								System.out.println("Invalid move");
							}
						} else if (Ground[cR][cC] == bR1.symbol) {
							if (cR == bR1.currentR && cC == bR1.currentC) {
								pMoves = bR1.possibleMovesA(Ground, bK.currentR, bK.currentC);
								if (pMoves[nR][nC] == 1) {
									bR1.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 1;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == bR2.currentR && cC == bR2.currentC) {
								pMoves = bR2.possibleMovesA(Ground, bK.currentR, bK.currentC);
								if (pMoves[nR][nC] == 1) {
									bR2.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 1;
								} else {
									System.out.println("Invalid move");
								}
							}
						} else if (Ground[cR][cC] == bB1.symbol) {
							if (cR == bB1.currentR && cC == bB1.currentC) {
								pMoves = bB1.possibleMovesA(Ground, bK.currentR, bK.currentC);
								if (pMoves[nR][nC] == 1) {
									bB1.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 1;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == bB2.currentR && cC == bB2.currentC) {
								pMoves = bB2.possibleMovesA(Ground, bK.currentR, bK.currentC);
								if (pMoves[nR][nC] == 1) {
									bB2.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 1;
								} else {
									System.out.println("Invalid move");
								}
							}
						} else if (Ground[cR][cC] == bKi1.symbol) {
							if (cR == bKi1.currentR && cC == bKi1.currentC) {
								pMoves = bKi1.possibleMovesA(Ground, bK.currentR, bK.currentC);
								if (pMoves[nR][nC] == 1) {
									bKi1.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 1;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == bKi2.currentR && cC == bKi2.currentC) {
								pMoves = bKi2.possibleMovesA(Ground, bK.currentR, bK.currentC);
								if (pMoves[nR][nC] == 1) {
									bKi2.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 1;
								} else {
									System.out.println("Invalid move");
								}
							}
						} else if (Ground[cR][cC] == bP1.symbol) {
							if (cR == bP1.currentR && cC == bP1.currentC) {
								pMoves = bP1.possibleMovesA(Ground, bK.currentR, bK.currentC);
								if (pMoves[nR][nC] == 1) {
									bP1.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 1;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == bP2.currentR && cC == bP2.currentC) {
								pMoves = bP2.possibleMovesA(Ground, bK.currentR, bK.currentC);
								if (pMoves[nR][nC] == 1) {
									bP2.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 1;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == bP3.currentR && cC == bP3.currentC) {
								pMoves = bP3.possibleMovesA(Ground, bK.currentR, bK.currentC);
								if (pMoves[nR][nC] == 1) {
									bP3.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 1;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == bP4.currentR && cC == bP4.currentC) {
								pMoves = bP4.possibleMovesA(Ground, bK.currentR, bK.currentC);
								if (pMoves[nR][nC] == 1) {
									bP4.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 1;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == bP5.currentR && cC == bP5.currentC) {
								pMoves = bP5.possibleMovesA(Ground, bK.currentR, bK.currentC);
								if (pMoves[nR][nC] == 1) {
									bP5.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 1;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == bP6.currentR && cC == bP6.currentC) {
								pMoves = bP6.possibleMovesA(Ground, bK.currentR, bK.currentC);
								if (pMoves[nR][nC] == 1) {
									bP6.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 1;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == bP7.currentR && cC == bP7.currentC) {
								pMoves = bP7.possibleMovesA(Ground, bK.currentR, bK.currentC);
								if (pMoves[nR][nC] == 1) {
									bP7.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 1;
								} else {
									System.out.println("Invalid move");
								}
							} else if (cR == bP8.currentR && cC == bP8.currentC) {
								pMoves = bP8.possibleMovesA(Ground, bK.currentR, bK.currentC);
								if (pMoves[nR][nC] == 1) {
									bP8.changePosition(Ground, nR, nC);
									rightInput = 1;
									playerTurn = 1;
								} else {
									System.out.println("Invalid move");
								}
							}
						} else {
							System.out.println("invalid input!!");
						}
						display(Ground);
					} else {
						System.out.println("invalid input !!");
					}
				}

			}
		}

	}

}
