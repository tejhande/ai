n = 4
board = []

def getBoard():
    for i in range(n):
        nthList = []
        for j in range(n):
            nthList.append(0)
        board.append(nthList)

def printBoard():
    for i in range(n):
        for j in range(n):
            print(board[i][j], end=" ")
        print("")

def isSafe(row, col):
    for i in range(n):
        if board[row][i] == 1:
            return False
        if board[i][col] == 1:
            return False

    for i, j in zip(range(row, -1, -1), range(col, -1, -1)):
        if board[i][j] == 1:
            return False

    for i, j in zip(range(row, -1, -1), range(col, n)):
        if board[i][j] == 1:
            return False

    return True

def Put(n, count):
    if count == n:
        return True

    for i in range(n):
        for j in range(n):
            if isSafe(i, j):
                board[i][j] = 1
                count += 1
                if Put(n, count):
                    return True
                board[i][j] = 0
                count -= 1
    return False

getBoard()
Put(n, 0)
printBoard()
