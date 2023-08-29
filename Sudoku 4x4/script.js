class Sudoku {
  constructor(boardSize, board) {
    this.boardSize = boardSize
    this.board = board
  }

  solve() {
    if (this.solveSudoku()) {
      this.printBoard()
    } else {
      console.log("No solution exists for the given Sudoku bro.")
    }
  }

  solveSudoku() {
    const emptyCell = this.findEmptyCell()
    if (!emptyCell) {
      return true // All cells are filled, puzzle solved
    }

    const { row, col } = emptyCell

    for (let num = 1; num <= this.boardSize; num++) {
      if (this.isSafe(row, col, num)) {
        this.board[row][col] = num

        if (this.solveSudoku()) {
          return true // Puzzle solved
        }

        this.board[row][col] = 0 // Backtrack
      }
    }

    return false // No solution found
  }

  findEmptyCell() {
    for (let row = 0; row < this.boardSize; row++) {
      for (let col = 0; col < this.boardSize; col++) {
        if (this.board[row][col] === 0) {
          return { row, col }
        }
      }
    }
    return null // No empty cell found
  }

  isSafe(row, col, num) {
    return (
      this.isRowSafe(row, num) &&
      this.isColumnSafe(col, num) &&
      this.isBoxSafe(row - (row % 2), col - (col % 2), num)
    )
  }

  isRowSafe(row, num) {
    for (let col = 0; col < this.boardSize; col++) {
      if (this.board[row][col] === num) {
        return false
      }
    }
    return true // No problemo amigo in row way.
  }

  isColumnSafe(col, num) {
    for (let row = 0; row < this.boardSize; row++) {
      if (this.board[row][col] === num) {
        return false
      }
    }
    return true // No problemo amigo in column way.
  }

  isBoxSafe(startRow, startCol, num) {
    const boxSize = Math.sqrt(this.boardSize)
    for (let row = 0; row < boxSize; row++) {
      for (let col = 0; col < boxSize; col++) {
        if (this.board[startRow + row][startCol + col] === num) {
          return false // Number already exists in the box
        }
      }
    }
    return true // Number is safe in the box
  }

  printBoard() {
    for (let row = 0; row < this.boardSize; row++) {
      let rowStr = ""
      for (let col = 0; col < this.boardSize; col++) {
        rowStr += this.board[row][col] + " "
      }
      console.log(rowStr.trim())
    }
  }
}

// Example usage:
/* A board full of zeros means the blank board.

const boardSize = 9
const board = [
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
] */

// This is the size of the board, it will be treated as nxn (boardSize x boardSize)
// e.g: boardSize = 4 ----> 4x4 board.
const boardSize = 4

// This is the board shown in the asset "Sudoku guide.png"
const board = [
  [0, 0, 0, 4],
  [0, 0, 0, 0],
  [2, 0, 0, 3],
  [4, 0, 1, 2],
]

const sudoku = new Sudoku(boardSize, board)
sudoku.solve() // The solution its given, using backtracking.
