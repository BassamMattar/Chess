package chess;

public class Pawn {
	public char symbol;
	public int currentC, currentR, team;
	public int[][] effectiveness = new int[8][8];

	public Pawn(char x, int y, int z, int i) {
		this.symbol = x;
		this.currentR = y;
		this.currentC = z;
		this.team = i;

	}

	public int possibleMoves(char[][] x, int Kr, int Kc) {
		int[][] pMoves = new int[8][8];
		int noOfPM = 0, j, checked = 0;
		char[][] test = new char[8][8];
		for (int i = 0; i < 8; i++) {
			for (j = 0; j < 8; j++) {
				pMoves[i][j] = 0;
				test[i][j] = x[i][j];
			}
		}
		if ((this.currentC + this.currentR) % 2 == 0) {
			test[this.currentR][this.currentC] = (char) 57346;
		} else {
			test[this.currentR][this.currentC] = (char) 57347;
		}
		if (this.team == 1) {
			if (this.currentR - 1 >= 0) {
				if (x[this.currentR - 1][this.currentC] == (char) 57347
						|| x[this.currentR - 1][this.currentC] == (char) 57346) {
					test[this.currentR - 1][this.currentC] = (char) 9823;
					checked = isChecked(test, Kr, Kc);
					if (checked == 0) {
						pMoves[this.currentR - 1][this.currentC] = 1;
						if ((this.currentR - 1 + this.currentC) % 2 == 0) {
							test[this.currentR - 1][this.currentC] = (char) 57346;
						} else {
							test[this.currentR - 1][this.currentC] = (char) 57347;
						}
					}
				}
				if (this.currentC + 1 < 8) {
					if (x[this.currentR - 1][this.currentC + 1] == (char) 9813
							|| x[this.currentR - 1][this.currentC + 1] == (char) 9814
							|| x[this.currentR - 1][this.currentC + 1] == (char) 9815
							|| x[this.currentR - 1][this.currentC + 1] == (char) 9816
							|| x[this.currentR - 1][this.currentC + 1] == (char) 9817) {
						test[this.currentR - 1][this.currentC + 1] = (char) 9823;
						checked = isChecked(test, Kr, Kc);
						if (checked == 0) {
							pMoves[this.currentR - 1][this.currentC + 1] = 1;
							test[this.currentR - 1][this.currentC + 1] = x[this.currentR - 1][this.currentC + 1];

						}
					}
				}
				if (this.currentC - 1 >= 0) {
					if (x[this.currentR - 1][this.currentC - 1] == (char) 9813
							|| x[this.currentR - 1][this.currentC - 1] == (char) 9814
							|| x[this.currentR - 1][this.currentC - 1] == (char) 9815
							|| x[this.currentR - 1][this.currentC - 1] == (char) 9816
							|| x[this.currentR - 1][this.currentC - 1] == (char) 9817) {
						test[this.currentR - 1][this.currentC - 1] = (char) 9823;
						checked = isChecked(test, Kr, Kc);
						if (checked == 0) {
							pMoves[this.currentR - 1][this.currentC - 1] = 1;
							test[this.currentR - 1][this.currentC - 1] = x[this.currentR - 1][this.currentC - 1];
						}
					}
				}
			}
		} else {
			if (this.currentR + 1 < 8) {
				if (x[this.currentR + 1][this.currentC] == (char) 57347
						|| x[this.currentR - 1][this.currentC] == (char) 57346) {
					test[this.currentR + 1][this.currentC] = (char) 9817;
					checked = isChecked(test, Kr, Kc);
					if (checked == 0) {
						pMoves[this.currentR + 1][this.currentC] = 1;
						if ((this.currentR + 1 + this.currentC) % 2 == 0) {
							test[this.currentR + 1][this.currentC] = (char) 57346;
						} else {
							test[this.currentR + 1][this.currentC] = (char) 57347;
						}
					}
				}
				if (this.currentC + 1 < 8) {
					if (x[this.currentR + 1][this.currentC + 1] == (char) 9819
							|| x[this.currentR - 1][this.currentC + 1] == (char) 9820
							|| x[this.currentR + 1][this.currentC + 1] == (char) 9821
							|| x[this.currentR - 1][this.currentC + 1] == (char) 9822
							|| x[this.currentR + 1][this.currentC + 1] == (char) 9823) {
						test[this.currentR + 1][this.currentC + 1] = (char) 9817;
						checked = isChecked(test, Kr, Kc);
						if (checked == 0) {
							pMoves[this.currentR + 1][this.currentC + 1] = 1;
							test[this.currentR + 1][this.currentC + 1] = x[this.currentR + 1][this.currentC + 1];
						}
					}
				}
				if (this.currentC - 1 >= 0) {
					if (x[this.currentR + 1][this.currentC - 1] == (char) 9819
							|| x[this.currentR - 1][this.currentC - 1] == (char) 9820
							|| x[this.currentR + 1][this.currentC - 1] == (char) 9821
							|| x[this.currentR - 1][this.currentC - 1] == (char) 9822
							|| x[this.currentR + 1][this.currentC - 1] == (char) 9823) {
						test[this.currentR + 1][this.currentC - 1] = (char) 9817;
						checked = isChecked(test, Kr, Kc);
						if (checked == 0) {
							pMoves[this.currentR + 1][this.currentC - 1] = 1;
							test[this.currentR + 1][this.currentC - 1] = x[this.currentR + 1][this.currentC - 1];
						}
					}
				}
			}
		}
		for (int i = 0; i < 8; i++) {
			for (j = 0; j < 8; j++) {
				noOfPM += pMoves[i][j];
			}
		}
		return noOfPM;
	}

	public void changePosition(char[][] x, int rN, int cN) {
		if (this.team == 1) {
			x[rN][cN] = (char) 9823;
			if ((this.currentR + this.currentC) % 2 == 0) {
				x[this.currentR][this.currentC] = (char) 57346;
			} else {
				x[this.currentR][this.currentC] = (char) 57347;
			}
			this.currentR = rN;
			this.currentC = cN;
		} else {
			x[rN][cN] = (char) 9817;
			if ((this.currentR + this.currentC) % 2 == 0) {
				x[this.currentR][this.currentC] = (char) 57346;
			} else {
				x[this.currentR][this.currentC] = (char) 57347;
			}
			this.currentR = rN;
			this.currentC = cN;
		}
	}

	public void willBePromoted() {
		// process
	}

	public int isChecked(char[][] x, int cR, int cC) {
		int j;
		ConqPiece state = new ConqPiece();
		state.noOfpiece = 0;
		// check if it 's checked by Bishop || Queen || pawn
		for (int i = cR - 1; i >= 0; i--) {
			j = i - (cR - cC);
			if (this.team == 1 && j < 8 && j >= 0) {
				// the aimed squre is not black (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9815 && x[i][j] != (char) 9813 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347 && !(x[i][j] == (char) 9817 && cR - i == 1)) {
					break;
				} else if (x[i][j] == (char) 9815 || x[i][j] == (char) 9813
						|| (x[i][j] == (char) 9817 && cR - i == 1)) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			} else if (j < 8 && j >= 0) {
				// the aimed squre is not white (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9821 && x[i][j] != (char) 9819 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347 && !(x[i][j] == (char) 9823 && i - cR == 1)) {
					break;
				} else if (x[i][j] == (char) 9821 || x[i][j] == (char) 9819
						|| (x[i][j] == (char) 9823 && i - cR != 1)) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			}
		}
		for (int i = cR + 1; i < 8; i++) {
			j = i - (cR - cC);
			if (this.team == 1 && j < 8 && j >= 0) {
				// the aimed squre is not black (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9815 && x[i][j] != (char) 9813 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347 && !(x[i][j] == (char) 9817 && cR - i == 1)) {
					break;
				} else if (x[i][j] == (char) 9815 || x[i][j] == (char) 9813
						|| (x[i][j] == (char) 9817 && cR - i == 1)) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			} else if (j < 8 && j >= 0) {
				// the aimed squre is not white (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9821 && x[i][j] != (char) 9819 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347 && !(x[i][j] == (char) 9823 && i - cR == 1)) {
					break;
				} else if (x[i][j] == (char) 9821 || x[i][j] == (char) 9819
						|| (x[i][j] == (char) 9823 && i - cR != 1)) {
					state.noOfpiece = 1;
					state.column = j;
					state.row = i;
				}
			}
		}
		for (int i = cR - 1; i >= 0; i--) {
			j = cC + cR - i;
			if (this.team == 1 && j < 8 && j >= 0) {
				// the aimed squre is not black (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9815 && x[i][j] != (char) 9813 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347 && !(x[i][j] == (char) 9817 && cR - i == 1)) {
					break;
				} else if (x[i][j] == (char) 9815 || x[i][j] == (char) 9813
						|| (x[i][j] == (char) 9817 && cR - i == 1)) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			} else if (j < 8 && j >= 0) {
				// the aimed squre is not white (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9821 && x[i][j] != (char) 9819 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347 && !(x[i][j] == (char) 9823 && i - cR == 1)) {
					break;
				} else if (x[i][j] == (char) 9821 || x[i][j] == (char) 9819
						|| (x[i][j] == (char) 9823 && i - cR != 1)) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			}
		}
		for (int i = cR + 1; i < 8; i++) {
			j = cC + cR - i;
			;
			if (this.team == 1 && j < 8 && j >= 0) {
				// the aimed squre is not black (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9815 && x[i][j] != (char) 9813 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347 && !(x[i][j] == (char) 9817 && cR - i == 1)) {
					break;
				} else if (x[i][j] == (char) 9815 || x[i][j] == (char) 9813
						|| (x[i][j] == (char) 9817 && cR - i == 1)) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			} else if (j < 8 && j >= 0) {
				// the aimed squre is not white (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9821 && x[i][j] != (char) 9819 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347 && !(x[i][j] == (char) 9823 && i - cR == 1)) {
					break;
				} else if (x[i][j] == (char) 9821 || x[i][j] == (char) 9819
						|| (x[i][j] == (char) 9823 && i - cR != 1)) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			}
		}
		// check if it 's checked by Rook or queen
		for (int i = cR - 1; i >= 0; i--) {
			j = cC;
			if (this.team == 1 && j < 8 && j >= 0) {
				// the aimed squre is not black (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9814 && x[i][j] != (char) 9813 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347) {
					break;
				} else if (x[i][j] == (char) 9814 || x[i][j] == (char) 9813) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			} else if (j < 8 && j >= 0) {
				// the aimed squre is not white (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9820 && x[i][j] != (char) 9819 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347) {
					break;
				} else if (x[i][j] == (char) 9820 || x[i][j] == (char) 9819) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			}
		}
		for (int i = cR + 1; i < 8; i++) {
			j = cC;
			if (this.team == 1 && j < 8 && j >= 0) {
				// the aimed squre is not black (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9814 && x[i][j] != (char) 9813 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347) {
					break;
				} else if (x[i][j] == (char) 9814 || x[i][j] == (char) 9813) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			} else if (j < 8 && j >= 0) {
				// the aimed squre is not white (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9820 && x[i][j] != (char) 9819 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347) {
					break;
				} else if (x[i][j] == (char) 9820 || x[i][j] == (char) 9819) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			}
		}
		int i;
		for (j = cC - 1; j >= 0; j--) {
			i = cR;
			if (this.team == 1 && i < 8 && i >= 0) {
				// the aimed squre is not black (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9814 && x[i][j] != (char) 9813 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347) {
					break;
				} else if (x[i][j] == (char) 9814 || x[i][j] == (char) 9813) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			} else if (i < 8 && i >= 0) {
				// the aimed squre is not white (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9820 && x[i][j] != (char) 9819 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347) {
					break;
				} else if (x[i][j] == (char) 9820 || x[i][j] == (char) 9819) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			}
		}
		for (j = cC + 1; j < 8; j++) {
			i = cR;
			if (this.team == 1 && i < 8 && i >= 0) {
				// the aimed squre is not black (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9814 && x[i][j] != (char) 9813 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347) {
					break;
				} else if (x[i][j] == (char) 9814 || x[i][j] == (char) 9813) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			} else if (i < 8 && i >= 0) {
				// the aimed squre is not white (queen or bishop or empty square
				// or pawn
				if (x[i][j] != (char) 9820 && x[i][j] != (char) 9819 && x[i][j] != (char) 57346
						&& x[i][j] != (char) 57347) {
					break;
				} else if (x[i][j] == (char) 9820 || x[i][j] == (char) 9819) {
					state.noOfpiece += 1;
					state.column = j;
					state.row = i;
				}
			}
		}
		// check if it 's checked by knight
		if (this.team == 1) {
			if (cR + 2 >= 0 && cR + 2 < 8 && cC + 1 >= 0 && cC + 1 < 8) {
				if (x[cR + 2][cC + 1] == (char) 9816) {
					state.noOfpiece += 1;
					state.column = cC + 1;
					state.row = cR + 2;
				}
			} else if (cR - 2 >= 0 && cR - 2 < 8 && cC + 1 >= 0 && cC + 1 < 8) {
				if (x[cR - 2][cC + 1] == (char) 9816) {
					state.noOfpiece += 1;
					state.column = cC + 1;
					state.row = cR - 2;
				}
			} else if (cR - 2 >= 0 && cR - 2 < 8 && cC - 1 >= 0 && cC - 1 < 8) {
				if (x[cR - 2][cC - 1] == (char) 9816) {
					state.noOfpiece += 1;
					state.column = cC - 1;
					state.row = cR - 2;
				}
			} else if (cR + 2 >= 0 && cR + 2 < 8 && cC - 1 >= 0 && cC - 1 < 8) {
				if (x[cR + 2][cC - 1] == (char) 9816) {
					state.noOfpiece += 1;
					state.column = cC - 1;
					state.row = cR + 2;
				}
			} else if (cR + 1 >= 0 && cR + 1 < 8 && cC + 2 >= 0 && cC + 2 < 8) {
				if (x[cR + 1][cC + 2] == (char) 9816) {
					state.noOfpiece += 1;
					state.column = cC + 2;
					state.row = cR + 1;
				}
			} else if (cR - 1 >= 0 && cR - 1 < 8 && cC + 2 >= 0 && cC + 2 < 8) {
				if (x[cR - 1][cC + 2] == (char) 9816) {
					state.noOfpiece += 1;
					state.column = cC + 2;
					state.row = cR - 1;
				}
			} else if (cR - 1 >= 0 && cR - 1 < 8 && cC - 2 >= 0 && cC - 2 < 8) {
				if (x[cR - 1][cC - 2] == (char) 9816) {
					state.noOfpiece += 1;
					state.column = cC - 2;
					state.row = cR - 1;
				}
			} else if (cR + 1 >= 0 && cR + 1 < 8 && cC - 2 >= 0 && cC - 2 < 8) {
				if (x[cR + 1][cC - 2] == (char) 9816) {
					state.noOfpiece += 1;
					state.column = cC - 2;
					state.row = cR + 1;
				}
			}
		} else if (this.team == 2) {
			if (cR + 2 >= 0 && cR + 2 < 8 && cC + 1 >= 0 && cC + 1 < 8) {
				if (x[cR + 2][cC + 1] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC + 1;
					state.row = cR + 2;
				}
			} else if (cR - 2 >= 0 && cR - 2 < 8 && cC + 1 >= 0 && cC + 1 < 8) {
				if (x[cR - 2][cC + 1] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC + 1;
					state.row = cR - 2;
				}
			} else if (cR - 2 >= 0 && cR - 2 < 8 && cC - 1 >= 0 && cC - 1 < 8) {
				if (x[cR - 2][cC - 1] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC - 1;
					state.row = cR - 2;
				}
			} else if (cR + 2 >= 0 && cR + 2 < 8 && cC - 1 >= 0 && cC - 1 < 8) {
				if (x[cR + 2][cC - 1] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC - 1;
					state.row = cR + 2;
				}
			} else if (cR + 1 >= 0 && cR + 1 < 8 && cC + 2 >= 0 && cC + 2 < 8) {
				if (x[cR + 1][cC + 2] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC + 2;
					state.row = cR + 1;
				}
			} else if (cR - 1 >= 0 && cR - 1 < 8 && cC + 2 >= 0 && cC + 2 < 8) {
				if (x[cR - 1][cC + 2] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC + 2;
					state.row = cR - 1;
				}
			} else if (cR - 1 >= 0 && cR - 1 < 8 && cC - 2 >= 0 && cC - 2 < 8) {
				if (x[cR - 1][cC - 2] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC - 2;
					state.row = cR - 1;
				}
			} else if (cR + 1 >= 0 && cR + 1 < 8 && cC - 2 >= 0 && cC - 2 < 8) {
				if (x[cR + 1][cC - 2] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC - 2;
					state.row = cR + 1;
				}
			}
		}
		return state.noOfpiece;
	}

	public int[][] possibleMovesA(char[][] x, int Kr, int Kc) {
		int[][] pMoves = new int[8][8];
		int j, checked = 0;
		char[][] test = new char[8][8];
		for (int i = 0; i < 8; i++) {
			for (j = 0; j < 8; j++) {
				pMoves[i][j] = 0;
				test[i][j] = x[i][j];
			}
		}
		if ((this.currentC + this.currentR) % 2 == 0) {
			test[this.currentR][this.currentC] = (char) 57346;
		} else {
			test[this.currentR][this.currentC] = (char) 57347;
		}
		if (this.team == 1) {
			if (this.currentR - 1 >= 0) {
				if (x[this.currentR - 1][this.currentC] == (char) 57347
						|| x[this.currentR - 1][this.currentC] == (char) 57346) {
					test[this.currentR - 1][this.currentC] = (char) 9823;
					checked = isChecked(test, Kr, Kc);
					if (checked == 0) {
						pMoves[this.currentR - 1][this.currentC] = 1;
						if ((this.currentR - 1 + this.currentC) % 2 == 0) {
							test[this.currentR - 1][this.currentC] = (char) 57346;
						} else {
							test[this.currentR - 1][this.currentC] = (char) 57347;
						}
					}
				}
				if (this.currentC + 1 < 8) {
					if (x[this.currentR - 1][this.currentC + 1] == (char) 9813
							|| x[this.currentR - 1][this.currentC + 1] == (char) 9814
							|| x[this.currentR - 1][this.currentC + 1] == (char) 9815
							|| x[this.currentR - 1][this.currentC + 1] == (char) 9816
							|| x[this.currentR - 1][this.currentC + 1] == (char) 9817) {
						test[this.currentR - 1][this.currentC + 1] = (char) 9823;
						checked = isChecked(test, Kr, Kc);
						if (checked == 0) {
							pMoves[this.currentR - 1][this.currentC + 1] = 1;
							test[this.currentR - 1][this.currentC + 1] = x[this.currentR - 1][this.currentC + 1];

						}
					}
				}
				if (this.currentC - 1 >= 0) {
					if (x[this.currentR - 1][this.currentC - 1] == (char) 9813
							|| x[this.currentR - 1][this.currentC - 1] == (char) 9814
							|| x[this.currentR - 1][this.currentC - 1] == (char) 9815
							|| x[this.currentR - 1][this.currentC - 1] == (char) 9816
							|| x[this.currentR - 1][this.currentC - 1] == (char) 9817) {
						test[this.currentR - 1][this.currentC - 1] = (char) 9823;
						checked = isChecked(test, Kr, Kc);
						if (checked == 0) {
							pMoves[this.currentR - 1][this.currentC - 1] = 1;
							test[this.currentR - 1][this.currentC - 1] = x[this.currentR - 1][this.currentC - 1];
						}
					}
				}
			}
		} else {
			if (this.currentR + 1 < 8) {
				if (x[this.currentR + 1][this.currentC] == (char) 57347
						|| x[this.currentR + 1][this.currentC] == (char) 57346) {
					test[this.currentR + 1][this.currentC] = (char) 9817;
					checked = isChecked(test, Kr, Kc);
					if (checked == 0) {
						pMoves[this.currentR + 1][this.currentC] = 1;
						if ((this.currentR + 1 + this.currentC) % 2 == 0) {
							test[this.currentR + 1][this.currentC] = (char) 57346;
						} else {
							test[this.currentR + 1][this.currentC] = (char) 57347;
						}
					}
				}
				if (this.currentC + 1 < 8) {
					if (x[this.currentR + 1][this.currentC + 1] == (char) 9819
							|| x[this.currentR + 1][this.currentC + 1] == (char) 9820
							|| x[this.currentR + 1][this.currentC + 1] == (char) 9821
							|| x[this.currentR + 1][this.currentC + 1] == (char) 9822
							|| x[this.currentR + 1][this.currentC + 1] == (char) 9823) {
						test[this.currentR + 1][this.currentC + 1] = (char) 9817;
						checked = isChecked(test, Kr, Kc);
						if (checked == 0) {
							pMoves[this.currentR + 1][this.currentC + 1] = 1;
							test[this.currentR + 1][this.currentC + 1] = x[this.currentR + 1][this.currentC + 1];

						}
					}
				}
				if (this.currentC - 1 >= 0) {
					if (x[this.currentR + 1][this.currentC - 1] == (char) 9819
							|| x[this.currentR + 1][this.currentC - 1] == (char) 9820
							|| x[this.currentR + 1][this.currentC - 1] == (char) 9821
							|| x[this.currentR + 1][this.currentC - 1] == (char) 9822
							|| x[this.currentR + 1][this.currentC - 1] == (char) 9823) {
						test[this.currentR + 1][this.currentC - 1] = (char) 9817;
						checked = isChecked(test, Kr, Kc);
						if (checked == 0) {
							pMoves[this.currentR + 1][this.currentC - 1] = 1;
							test[this.currentR + 1][this.currentC - 1] = x[this.currentR + 1][this.currentC - 1];
						}
					}
				}
			}
		}

		return pMoves;
	}

}
