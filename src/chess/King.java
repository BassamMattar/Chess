package chess;

public class King {
	public char symbol;
	public int currentC, currentR, team;
	public int[][] effectiveness = new int[8][8];

	public King(char x, int y, int z, int i) {
		this.symbol = x;
		this.currentR = y;
		this.currentC = z;
		this.team = i;
	}

	public int possibleMoves(char[][] x) {
		int[][] pMoves = new int[8][8];
		int checked = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				pMoves[i][j] = 0;
			}
		}
		for (int i = this.currentR - 1; i <= this.currentR + 1; i++) {
			for (int j = this.currentC - 1; j <= this.currentC + 1; j++) {
				if ((i >= 0 && i < 8) && (j >= 0 && j < 8) && !(i == this.currentR && j == this.currentC)) {
					if (this.team == 1) {
						if (x[i][j] != (char) 9819 && x[i][j] != (char) 9820 && x[i][j] != (char) 9821
								&& x[i][j] != (char) 9822 && x[i][j] != (char) 9823) {
							checked = isChecked(x, i, j);
							if (checked == 0) {
								pMoves[i][j] = 1;

							}
						}
					} else {
						if (x[i][j] != (char) 9813 && x[i][j] != (char) 9814 && x[i][j] != (char) 9815
								&& x[i][j] != (char) 9816 && x[i][j] != (char) 9817) {
							checked = isChecked(x, i, j);
							if (checked == 0) {
								pMoves[i][j] = 1;
							}
						}
					}
				}
			}
		}
		int noOfPm = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				noOfPm += pMoves[i][j];
			}
		}
		return noOfPm;
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
			}
			if (cR - 2 >= 0 && cR - 2 < 8 && cC + 1 >= 0 && cC + 1 < 8) {
				if (x[cR - 2][cC + 1] == (char) 9816) {
					state.noOfpiece += 1;
					state.column = cC + 1;
					state.row = cR - 2;
				}
			}
			if (cR - 2 >= 0 && cR - 2 < 8 && cC - 1 >= 0 && cC - 1 < 8) {
				if (x[cR - 2][cC - 1] == (char) 9816) {
					state.noOfpiece += 1;
					state.column = cC - 1;
					state.row = cR - 2;
				}
			}
			if (cR + 2 >= 0 && cR + 2 < 8 && cC - 1 >= 0 && cC - 1 < 8) {
				if (x[cR + 2][cC - 1] == (char) 9816) {
					state.noOfpiece += 1;
					state.column = cC - 1;
					state.row = cR + 2;
				}
			}
			if (cR + 1 >= 0 && cR + 1 < 8 && cC + 2 >= 0 && cC + 2 < 8) {
				if (x[cR + 1][cC + 2] == (char) 9816) {
					state.noOfpiece += 1;
					state.column = cC + 2;
					state.row = cR + 1;
				}
			}
			if (cR - 1 >= 0 && cR - 1 < 8 && cC + 2 >= 0 && cC + 2 < 8) {
				if (x[cR - 1][cC + 2] == (char) 9816) {
					state.noOfpiece += 1;
					state.column = cC + 2;
					state.row = cR - 1;
				}
			}
			if (cR - 1 >= 0 && cR - 1 < 8 && cC - 2 >= 0 && cC - 2 < 8) {
				if (x[cR - 1][cC - 2] == (char) 9816) {
					state.noOfpiece += 1;
					state.column = cC - 2;
					state.row = cR - 1;
				}
			}
			if (cR + 1 >= 0 && cR + 1 < 8 && cC - 2 >= 0 && cC - 2 < 8) {
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
			}
			if (cR - 2 >= 0 && cR - 2 < 8 && cC + 1 >= 0 && cC + 1 < 8) {
				if (x[cR - 2][cC + 1] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC + 1;
					state.row = cR - 2;
				}
			}
			if (cR - 2 >= 0 && cR - 2 < 8 && cC - 1 >= 0 && cC - 1 < 8) {
				if (x[cR - 2][cC - 1] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC - 1;
					state.row = cR - 2;
				}
			}
			if (cR + 2 >= 0 && cR + 2 < 8 && cC - 1 >= 0 && cC - 1 < 8) {
				if (x[cR + 2][cC - 1] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC - 1;
					state.row = cR + 2;
				}
			}
			if (cR + 1 >= 0 && cR + 1 < 8 && cC + 2 >= 0 && cC + 2 < 8) {
				if (x[cR + 1][cC + 2] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC + 2;
					state.row = cR + 1;
				}
			}
			if (cR - 1 >= 0 && cR - 1 < 8 && cC + 2 >= 0 && cC + 2 < 8) {
				if (x[cR - 1][cC + 2] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC + 2;
					state.row = cR - 1;
				}
			}
			if (cR - 1 >= 0 && cR - 1 < 8 && cC - 2 >= 0 && cC - 2 < 8) {
				if (x[cR - 1][cC - 2] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC - 2;
					state.row = cR - 1;
				}
			}
			if (cR + 1 >= 0 && cR + 1 < 8 && cC - 2 >= 0 && cC - 2 < 8) {
				if (x[cR + 1][cC - 2] == (char) 9822) {
					state.noOfpiece += 1;
					state.column = cC - 2;
					state.row = cR + 1;
				}
			}
		}
		return state.noOfpiece;
	}

	public int willLive(char[][] x) {
		int state = 1;
		// process
		return state;
	}

	public void changePosition(char[][] x, int rN, int cN) {
		if (this.team == 1) {
			x[rN][cN] = (char) 9818;
			if ((this.currentR + this.currentC) % 2 == 0) {
				x[this.currentR][this.currentC] = (char) 57346;
			} else {
				x[this.currentR][this.currentC] = (char) 57347;
			}
			this.currentR = rN;
			this.currentC = cN;
		} else {
			x[rN][cN] = (char) 9812;
			if ((this.currentR + this.currentC) % 2 == 0) {
				x[this.currentR][this.currentC] = (char) 57346;
			} else {
				x[this.currentR][this.currentC] = (char) 57347;
			}
			this.currentR = rN;
			this.currentC = cN;
		}
	}

	public int[][] possibleMovesA(char[][] x) {
		int[][] pMoves = new int[8][8];
		int checked = 0;
		for (int i = this.currentR - 1; i <= this.currentR + 1; i++) {
			for (int j = this.currentC - 1; j <= this.currentC + 1; j++) {
				if ((i >= 0 && i < 8) && (j >= 0 && j < 8) && !(i == this.currentR && j == this.currentC)) {
					if (this.team == 1) {
						if (x[i][j] != (char) 9819 && x[i][j] != (char) 9820 && x[i][j] != (char) 9821
								&& x[i][j] != (char) 9822 && x[i][j] != (char) 9823) {
							checked = isChecked(x, i, j);
							if (checked == 0) {
								pMoves[i][j] = 1;

							}
						}
					} else {
						if (x[i][j] != (char) 9813 && x[i][j] != (char) 9814 && x[i][j] != (char) 9815
								&& x[i][j] != (char) 9816 && x[i][j] != (char) 9817) {
							checked = isChecked(x, i, j);
							if (checked == 0) {
								pMoves[i][j] = 1;
							}
						}
					}
				}
			}
		}
		return pMoves;
	}
}
